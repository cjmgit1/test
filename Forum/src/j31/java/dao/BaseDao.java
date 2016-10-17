package j31.java.dao;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class BaseDao {

	private static ComboPooledDataSource cm=new ComboPooledDataSource();
	
	protected DataSource getconn()
	{
		return cm;
	}
}
