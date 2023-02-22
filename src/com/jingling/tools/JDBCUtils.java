package com.jingling.tools;
import org.apache.commons.dbcp.BasicDataSource;
import javax.sql.DataSource;
/*
*   获取数据库的主要类
*
*   实现连接池DBCP连接池
* */
public class JDBCUtils {
    //创建BasicDataSource类连接对象
  private static   BasicDataSource basicDataSource = new BasicDataSource() ;
        //静态代码块
    static{
        //必要的选项
        basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        basicDataSource.setUrl("jdbc:mysql://localhost:3306/day09");
        basicDataSource.setUsername("root");
        basicDataSource.setPassword("123456");
        basicDataSource.setMaxActive(10);
        basicDataSource.setMaxIdle(5);
        basicDataSource.setMinIdle(2);
        basicDataSource.setInitialSize(10);
        }
        public static DataSource getDataSource(){
        return basicDataSource;
        }
}
