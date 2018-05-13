package ua.org.oa.evlashdv.lectures.lecture1.net;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class MyShowDocument extends JApplet {
    private URL bsu=null;
    String getMyURL(){
        return "http://www.bsu.by";
    }
    public void print(Graphics g){
        int timer=0;
        g.drawString("загрузка страницы",10,10);
        try{
            for (;timer<30;timer++){
                g.drawString(".",10+timer*5,25);
                Thread.sleep(100);
            }
            bsu=new URL(getMyURL());
            getAppletContext().showDocument(bsu," blank");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
