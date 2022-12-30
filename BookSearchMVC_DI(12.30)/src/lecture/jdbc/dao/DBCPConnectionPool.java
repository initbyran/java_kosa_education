package lecture.jdbc.dao;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class DBCPConnectionPool {

	private static BasicDataSource basicDS;
	static {
		// connection pool
		basicDS = new BasicDataSource();
		// Driver loading & connection
		basicDS.setDriverClassName("com.mysql.cj.jdbc.Driver");
		basicDS.setUrl("jdbc:mysql://127.0.0.1:3306/library?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true");
		basicDS.setUsername("root");
		basicDS.setPassword("test1234");
		basicDS.setInitialSize(10); // connection 초기개수
		basicDS.setMaxTotal(20); // connection 최대개수
	}
	
	public static DataSource getDataSource() {
		// basic data source의 상위 type : data source(interface)
		// is-A 관계 : Data source에는 여러 종류의 data source들이 있음
		//            basicDS에서 다른 걸로 변경시 일일이 바꿔줘야하는 것을 방지하기 위해 상위 인터페이스 명을 사용.
		return basicDS;
	
}}
