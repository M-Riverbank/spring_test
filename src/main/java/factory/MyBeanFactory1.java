package factory;

import dao.Impl.userDaoImpl;
import dao.userDao;

//静态工厂模式创建Bean
public class MyBeanFactory1 {
    public static userDao userDao(String name,int age){
        System.out.println(name+age);
        //Bean创建前可以进行其他业务逻辑操作
        return new userDaoImpl();
    }
}
