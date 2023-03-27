package dsy.services.Impl;

import dsy.dao.userDao;
import dsy.mapper.testMapper;
import dsy.pojo.test;
import dsy.services.userService;
import org.springframework.beans.factory.InitializingBean;

import java.util.List;

public class userServiceImpl implements userService, InitializingBean {

    //注入List
//    private List<String> stringList;
    private userDao userDao;
    private testMapper testMapper;

    public testMapper getTestMapper() {
        return testMapper;
    }

    public List<test> findAll() {
        return testMapper.findAll();
    }

    public void setTestMapper(dsy.mapper.testMapper testMapper) {
        this.testMapper = testMapper;
    }

    public void show() {
//        System.out.println(stringList);
    }

    public userServiceImpl() {
//        System.out.println("userServiceImpl无参构造");
    }

    public userServiceImpl(String str) {
        System.out.println("userServiceImpl有参构造" + str);
    }


    //BeanFactory去调用该方法 从容器中去获取userDao设置到此处
    public void setUserDao(userDao userDao) {
//        System.out.println("setUserDao");
        this.userDao = userDao;
    }

    //注入list
    public void setStringList(List<String> stringList) {
//        this.stringList = stringList;
    }

    public void init() {
//        System.out.println("初始化方法");
    }

    public void destroy() {
//        System.out.println("销毁方法");
    }

    @Override
    //在init之前执行，属性设置之后执行
    public void afterPropertiesSet() throws Exception {
//        System.out.println("afterPropertiesSet方法执行");
    }
}
