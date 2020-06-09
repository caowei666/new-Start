package com.caowei.introspector;

import org.junit.Test;

public class BeanTest {
    @Test
    public void getBeanTest(){
        Config bean = (Config)BeanFactory.getBean("bean.name");
        System.out.println(bean);
    }
}
