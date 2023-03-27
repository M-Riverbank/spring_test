package dsy.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Proxy;
import java.util.Date;

public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(beanName + ":postProcessBeforeInitialization");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        System.out.println(beanName+":postProcessAfterInitialization");
        //使用动态代理对目标Bean进行增强，返回proxy对象， 进而存储到单例池 singletonObjects 中

        return Proxy.newProxyInstance(
                bean.getClass().getClassLoader(),
                bean.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    //1、输出开始时间
                    System.out.println("方法：" + method.getName() + "开始-" + new Date());
                    //2、执行目标方法
                    Object result = method.invoke(bean, args);
                    //3、输出结束时间
                    System.out.println("方法：" + method.getName() + "结束-" + new Date());
                    return result;
                }
        );
    }
}
