package ua.org.oa.evlashdv.lectures.lecture1.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("context.xml");
        context.getBean(spring.Quoter.class).sayQuote();
    }
}
