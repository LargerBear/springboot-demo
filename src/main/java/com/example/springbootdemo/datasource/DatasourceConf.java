package com.example.springbootdemo.datasource;

import java.sql.*;

/**
 * Description: </br>
 * <p>版权所有：</p>
 * 未经本公司许可，不得以任何方式复制或使用本程序任何部分
 * <p>
 * 杭州孚立计算机软件有限公司
 *
 * @author LargerBear</ br>
 * date: 2021/9/29 10:06</br>
 * @since JDK 1.8
 */
public class DatasourceConf {

	public static void main(String[] args) {
//		//mysql8.0
//		String url = "jdbc:mysql://192.168.1.229:3306/govern_developer?useUnicode=true&autoReconnect=true&characterEncoding=utf8&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=GMT%2B8&allowMultiQueries=true&rewriteBatchedStatements=true";
//		String user = "govern";
//		String pwd = "govern@pwd.com";
//		String tableName = "developer_datasource";

		//mysql5.7
//		String url = "jdbc:mysql://localhost:3306/springboot_test?useUnicode=true&autoReconnect=true&characterEncoding=utf8&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=GMT%2B8&allowMultiQueries=true&rewriteBatchedStatements=true";
////		String user = "root";
////		String pwd = "123456";
////		String tableName = "demo_user";

		//oracle
		String url = "jdbc:oracle:thin:@fsoft.8800.org:1521:orcl";
		String user = "wfzz";
		String pwd = "free";
		String tableName = "BASE_BUILDING_ADDRESS";

//		达梦
// 		String url = "jdbc:dm://localhost:5236/SYSDBA?zeroDateTimeBehavior=convertToNull&useUnicode=true&characterEncoding=utf-8";
//		String user = "SYSDBA";
//		String pwd = "123456789";
//		String tableName = "TEST.DEMO_USER";

//		sql server
//		String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
//		String url="jdbc:sqlserver://192.168.1.224:1433;DatabaseName=szfg;instanceName=MSSQLSERVER1";
//		String user="sa";
//		String pwd="Free224";
//		String tableName = "tbDepart";
//		try {
//			Class.forName(driverName);
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}

		try {
			Connection connection = DriverManager.getConnection(url, user, pwd);
			Statement statement = connection.createStatement();
			boolean execute = statement.execute("select * from " + tableName);
			ResultSet resultSet = statement.executeQuery("select * from " + tableName);
			while (resultSet.next()){
				String id = resultSet.getString(1);
				System.out.println(id);
			}
			System.out.println("test connection success：" + execute);
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
