package factory;


import dao.Impl.userDaoImpl;
import dao.userDao;
import org.springframework.beans.factory.FactoryBean;

//
public class MyBeanFactory3 implements FactoryBean<userDao> {
    @Override
    public userDao getObject() throws Exception {
        return new userDaoImpl();
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

}
