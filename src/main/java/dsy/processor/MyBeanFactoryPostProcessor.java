package dsy.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("beanDefinitionMap填充完毕后回调方法");
        //获得xxx的 beanDefinition 并修改全限定名
//        BeanDefinition beanDefinition = configurableListableBeanFactory.getBeanDefinition("xxx");
//        beanDefinition.setBeanClassName("xxx.xx.x");

        //动态注册 beanDefinition
        BeanDefinition beanDefinition = new RootBeanDefinition();
        beanDefinition.setBeanClassName("dao.Impl.personDaoImpl");
        DefaultListableBeanFactory defaultListableBeanFactory =
                (DefaultListableBeanFactory) beanFactory;
        defaultListableBeanFactory.registerBeanDefinition("personDao", beanDefinition);
    }
}
