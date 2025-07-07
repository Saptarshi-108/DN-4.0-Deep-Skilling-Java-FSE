package org.saptarshi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        // Simple Spring ApplicationContext example
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        System.out.println("Spring ApplicationContext loaded: " + context.getDisplayName());
        HelloService helloService = (HelloService) context.getBean("helloService");
        System.out.println(helloService.sayHello());
    }
}