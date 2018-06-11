package ua.org.oa.evlashdv.lectures.lecture1.p1.TelegramBotVer1_0;

public class Code {
    public static String CodeCreate(int length){
        String symbols="abcdefghiklmnopqrstuvwxyzABCDEFGHIKLMNOPQRSTUVWXYZ1234567890";
        String pCode="";
        int max=symbols.length()-1;
        for (int i=0; i<length;i++){
            int position= (int) Math.floor(Math.random()*max);
            pCode=pCode+symbols.substring(position,position+1);
        }
        return pCode;
    }
}
