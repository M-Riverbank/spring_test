package dsy.test;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.util.Date;

public class mysqlConnectionTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("mysql.xml");

        //连接池
        DruidDataSource dataSource = (DruidDataSource) applicationContext.getBean("dataSource");
        System.out.println(dataSource);


        //=============================================
        //connection连接
        Connection connection = (Connection) applicationContext.getBean("connection");
        System.out.println(connection);

        //时间对象转换
        Date data = (Date) applicationContext.getBean("date");
        System.out.println(data);

        //mybatis
//        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");//静态工厂
//        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();//无参构造
//        SqlSessionFactory build = builder.build(in);//实例工厂
        SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) applicationContext.getBean("sqlSessionFactory");
        System.out.println(sqlSessionFactory);
    }
}
