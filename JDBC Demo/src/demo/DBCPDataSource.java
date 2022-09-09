package demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

public class DBCPDataSource {
	public static DataSource getDataSource(String dbType){
		Properties props = new Properties();
		FileInputStream fis = null;
		BasicDataSource ds = new BasicDataSource();
		
		try {
			fis = new FileInputStream("db.properties");
			props.load(fis);
		}catch(IOException e){
			e.printStackTrace();
			return null;
		}
		if("h2".equals(dbType)){
			ds.setDriverClassName(props.getProperty("H2_DB_DRIVER_CLASS"));
            ds.setUrl(props.getProperty("H2_DB_URL"));
            ds.setUsername(props.getProperty("H2_DB_USERNAME"));
            ds.setPassword(props.getProperty("H2_DB_PASSWORD"));
		}else {
			return null;
		}
		return ds;
	}

}
