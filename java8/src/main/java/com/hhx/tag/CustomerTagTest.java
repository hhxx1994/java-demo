package com.hhx.tag;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;    
public class CustomerTagTest {    
    public static void main(String[] args) {    
        ApplicationContext beans=new ClassPathXmlApplicationContext("classpath:application.xml");
        User user=(User)beans.getBean("testBean");    
        System.out.println("username:"+user.getUserName()+":"+"email:"+user.getEmail());    
    }    
}   