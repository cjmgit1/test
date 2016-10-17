package j31.java.dao;

import j31.java.entity.PageForum;

import java.util.List;
import java.util.Map;



import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

public class ShowDao extends BaseDao {
	private QueryRunner qr = new QueryRunner(this.getconn());
	
	public List<Map<String,Object>> GetInfo(PageForum p)
	{
		try {
			String sql="select k.* from (select ROWNUM r ,t.id,t.tTitle,u.userName,t.tTime,(select count(*) from REPLY where TID=t.id )c from TOPIC t, USERLOGIN u where t.userid=u.ID and ROWNUM<=?) k where k.r>?";
			List<Map<String,Object>> list=qr.query(sql, new MapListHandler(),(p.getIndex() * p.getSize()),
						(p.getIndex() - 1) * p.getSize());
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int getCount()
	{
		
		try {
		String sql="select * from TOPIC";
		List<Map<String,Object>> list=qr.query(sql, new MapListHandler());
		return list.size();
		} catch (Exception e) {
			
		}
		return 0;
	}
	
	public int deleteInfo(int id)
	{
		int a=0;
		try {
			String sql="DELETE from TOPIC where id=?";
			a=qr.update(sql,id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}
	
	public int delre(int id)
	{
		int a=0;
		try {
			String sql="DELETE from REPLY where tid=?";
			a=qr.update(sql,id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}
	
	public List<Map<String, Object>> getShowInfo(int id,PageForum p)
	{
		try {
			String sql="select k.* from (select ROWNUM r ,t.id,t.tTitle,u.userName,t.tTime,REPLY.rid,REPLY.rTime,REPLY.rcontent,(select count(*) from REPLY where TID=t.id )c from TOPIC t, USERLOGIN u,REPLY where REPLY.userid=u.ID and REPLY.tid=? and t.id=? and ROWNUM<=?) k where k.r>?";
			List<Map<String, Object>> list=qr.query(sql, new MapListHandler(),id,id,(p.getIndex() * p.getSize()),
					(p.getIndex() - 1) * p.getSize());
			return list;
		} catch (Exception e) {
			e.printStackTrace();
					
		}
		return null;
	}
	
	public int getCount(int id)
	{
		
		try {
			
		String sql="select * from (select ROWNUM r ,t.id,t.tTitle,u.userName,t.tTime,REPLY.rid,REPLY.rTime,REPLY.rcontent,(select count(*) from REPLY where TID=t.id )c from TOPIC t, USERLOGIN u,REPLY where REPLY.userid=u.ID and REPLY.tid=? and t.id=? )";
		List<Map<String,Object>> list=qr.query(sql, new MapListHandler(),id,id);
		
		return list.size();
		
		} catch (Exception e) {
			
		}
		
		return 0;
		
	}
	
	public List<Map<String, Object>> findByShow(int id)
	{
		try {
			String sql="select t.id,t.tTitle,u.username,u.ID,t.ttime,t.tcontent from TOPIC t,USERLOGIN u where t.userId=u.ID and t.id=?";
			List<Map<String, Object>> list=qr.query(sql, new MapListHandler(),id);
			
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	public int Add(String title,String neirong,int id)
	{
		int a=0;
		try {
			String sql="insert into TOPIC values(TOPIC_seq.nextval,?,?,DEFAULT,?)";
			a=qr.update(sql,title,neirong,id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}
	
	public int AddLiuyan(int id,int id1,String liuyan)
	{
		int b=0;
		try {
			String sql="insert into REPLY values(REPLY_seq.nextval,?,?,DEFAULT,?)";
			b=qr.update(sql,id,id1,liuyan);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}
}


