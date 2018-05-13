package ua.org.oa.evlashdv.lectures.lecture1.net;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.xml.transform.Transformer;
import java.io.IOException;
import java.util.Properties;

public class Email {
    public static void main(String[] args) throws IOException, MessagingException {
        final Properties properties=new Properties();
        properties.load(Email.class.getClassLoader().getResourceAsStream("mail.properties"));

        Session mailSession=Session.getDefaultInstance(properties);
        MimeMessage message=new MimeMessage(mailSession);
        message.setFrom(new InternetAddress("wyerer123@gmail.com"));
        message.addRecipients(javax.mail.Message.RecipientType.TO, String.valueOf(new InternetAddress("wyerer123@mail.ru")));
        message.setSubject("hello");
        message.setText("hi this is my test massage");

        Transport tr=mailSession.getTransport();
        tr.connect("wyerer123@gmail.com","878988qqq");
        tr.sendMessage(message,message.getAllRecipients());
        tr.close();
    }
}
