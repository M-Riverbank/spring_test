package dsy.processor;

import dsy.utils.BaseClassScanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;

import java.util.Map;

public class myComponentBeanFactoryPostProcessor implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        //通过扫描工具去扫描指定包及其子包的所有类,收集使用@MyComponent注解的类
        Map<String, Class> dsy = BaseClassScanUtils.scanMyComponentAnnotation("dsy");
        //便利Map,注册使用了注解的 BeanDefinition
        dsy.forEach((beanName, clazz) -> {
            //获得 beanClassName
            String clazzName = clazz.getName();
            //创建 BeanDefinition
            RootBeanDefinition beanDefinition = new RootBeanDefinition();
            beanDefinition.setBeanClassName(clazzName);
            //注册 BeanDefinition
            beanDefinitionRegistry.registerBeanDefinition(beanName, beanDefinition);
        });
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

    }
}
