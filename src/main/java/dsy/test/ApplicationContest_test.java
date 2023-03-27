package dsy.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContest_test {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContest.xml");

        //工厂后处理器批量注册使用自定义注解类至 BeanDefinitionMap 测试
        System.out.println(applicationContext.getBean("otherBean"));

        System.out.println(applicationContext.getBean("userDao"));
    }
}
