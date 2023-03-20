package test;

import dao.Impl.userDaoImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import services.Impl.userServiceImpl;
import services.userService;

public class ApplicationContest_test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContest.xml");
//        userService userService = (userService) applicationContext.getBean("userService");
//        System.out.println(applicationContext);
//        System.out.println(userService);
        userServiceImpl userService = (userServiceImpl) applicationContext.getBean("userService1");
        userService.show();

        //关闭容器
        applicationContext.close();
    }
}
