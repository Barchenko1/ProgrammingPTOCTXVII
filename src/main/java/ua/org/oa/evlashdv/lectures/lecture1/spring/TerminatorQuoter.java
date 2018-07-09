package ua.org.oa.evlashdv.lectures.lecture1.spring;

import ua.org.oa.evlashdv.lectures.lecture1.spring.InjectRandomInt;
import ua.org.oa.evlashdv.lectures.lecture1.spring.PostProxy;
import ua.org.oa.evlashdv.lectures.lecture1.spring.Profiling;
import ua.org.oa.evlashdv.lectures.lecture1.spring.Quoter;

import javax.annotation.PostConstruct;

@Profiling
public class TerminatorQuoter implements Quoter {
    @InjectRandomInt(min=2,max=7)
    private int repeat;
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }
    @PostConstruct
    public void init(){
        System.out.println("Phase 2");
        System.out.println(repeat);
    }
    public TerminatorQuoter() {
        System.out.println("Phase 1");
    }

    @Override
    @PostProxy
    public void sayQuote() {
        System.out.println("Phase 3");
        for (int i = 0; i <repeat ; i++) {
            System.out.println("message = "+message);
        }
    }
}