package example.mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisConnectionFactory {

	// SqlSessionFactory 확보
	
	private static SqlSessionFactory sqlSessionFactory;
	
	static {
		
		String resource = "./SqlMapConfig.xml";
		try {
			Reader reader = Resources.getResourceAsReader(resource);
            if(sqlSessionFactory == null) {
            	// sqlSessionFactory 하나 만들어서 계속 사용 ; 싱글톤
            	sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);   	
            }
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getSqlSessionFactory() {
		//getter
		return sqlSessionFactory;
	}
}
