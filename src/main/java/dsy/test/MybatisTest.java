package dsy.test;

import dsy.pojo.test;
import dsy.services.Impl.userServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MybatisTest {
    public static void main(String[] args) throws Exception{
//        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
//        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
//        SqlSessionFactory sqlSessionFactory = builder.build(in);
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//
//        testMapper mapper = sqlSession.getMapper(testMapper.class);
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContest.xml");
        userServiceImpl userService = (userServiceImpl)applicationContext.getBean("userService");
        List<test> testList =userService.findAll();
        testList.forEach(System.out::println);

    }
}
