package test;

import dao.userDao;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import services.userService;

public class BeanFactory_test {
    public static void main(String[] args) {
        //创建工厂对象
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //创建读取器(读取xml文件)
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        //读取配置文件给工厂
        reader.loadBeanDefinitions("beans.xml");
        //根据id获取Bean实例对象
        userService userService = (userService) beanFactory.getBean("userService");
//        userDao userDao = (userDao) beanFactory.getBean("userDao");

    }
}
