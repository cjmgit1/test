package j31.java.dao;

import j31.java.entity.UserInfo;

import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

public class UserDao extends BaseDao {
	private QueryRunner qr = new QueryRunner(this.getconn());
	public UserInfo Login(String name,String pass)
	{
		UserInfo u=new UserInfo();
		try {
		String sql="select * from userlogin where username=? and pwd=? ";
		u=qr.query(sql, new BeanHandler<UserInfo>(UserInfo.class),name,pass);
		
//		if(u!=null)
//		{
//			
//			
//			return true;
//			
//		}else
//		{
//			return false;
//		}
		} catch (Exception e) {
			e.printStackTrace();
			//return false;
		}
//		return false;
		return u;
	}
	


}
