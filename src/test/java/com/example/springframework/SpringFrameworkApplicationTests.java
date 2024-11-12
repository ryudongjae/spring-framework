package com.example.springframework;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
class SpringFrameworkApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void singletonScope(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(
                SingletonBean.class,ClientSingletonBean.class);
        Set<SingletonBean> beans = new HashSet<>();
        beans.add(applicationContext.getBean(SingletonBean.class));
        beans.add(applicationContext.getBean(SingletonBean.class));
        System.out.println(applicationContext.getBean(SingletonBean.class));
        System.out.println(applicationContext.getBean(SingletonBean.class));
        assertThat(beans.size(), Matchers.is(1));
    }


    static class SingletonBean{}
    static class ClientSingletonBean{
    @Autowired SingletonBean singletonBean1;
    @Autowired SingletonBean singletonBean2;
    }

    @Test
    void proxyScope(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(
                ProxyBean.class,ClientProxyBean.class);
        Set<ProxyBean> beans = new HashSet<>();
        beans.add(applicationContext.getBean(ClientProxyBean.class).proxyBean1);
        assertThat(beans.size(), Matchers.is(1));
        System.out.println(applicationContext.getBean(ProxyBean.class));

        beans.add(applicationContext.getBean(ClientProxyBean.class).proxyBean2);
        assertThat(beans.size(), Matchers.is(2));
        System.out.println(applicationContext.getBean(ProxyBean.class));

    }

    @Scope("prototype")
    static class ProxyBean{}
    static class ClientProxyBean{
        @Autowired ProxyBean proxyBean1;
        @Autowired ProxyBean proxyBean2;
    }
}
