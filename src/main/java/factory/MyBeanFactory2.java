package factory;

import dao.Impl.userDaoImpl;
import dao.userDao;

//动态工厂模式创建Bean
public class MyBeanFactory2 {
    public  userDao userDao(){
        //Bean创建前可以进行其他业务逻辑操作
        return new userDaoImpl();
    }
}
