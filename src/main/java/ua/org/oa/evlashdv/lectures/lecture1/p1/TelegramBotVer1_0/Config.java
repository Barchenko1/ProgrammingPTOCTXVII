package ua.org.oa.evlashdv.lectures.lecture1.p1.TelegramBotVer1_0;

import java.io.*;
import java.util.Properties;

public class Config {
    public static final String CONFIGURATION_BOT_FILE="./bot.properties";
    public static final String CONFIGURATION_DB_FILE="./database.properties";

    public static String BOT_NAME;
    public static String BOT_TOKEN;

    public static String DB_URL;
    public static String DB_USER;
    public static String DB_PWD;

    public static void load(){

        Properties botSettings=new Properties();
        try (InputStream is=new FileInputStream(new File(CONFIGURATION_BOT_FILE))){
            botSettings.load(is);
            is.close();
            System.out.println("Конфиг бота загружен");
        } catch (Exception e) {
            System.out.println("Ошибка загрузки конфига");
        }

        Properties databaseSettings=new Properties();
        try (InputStream is=new FileInputStream(new File(CONFIGURATION_DB_FILE))){
            databaseSettings.load(is);
            is.close();
            System.out.println("Конфиг базы данных загружен");
        } catch (Exception e){
            System.out.println("Ошибка конфига базы данных загружен");
        }

        BOT_NAME=botSettings.getProperty("BotName","Pasha123FunTest_bot");
        BOT_TOKEN=botSettings.getProperty("BotToken","606663646:AAEEVXLWwbom-kJ_r4IZeeXjRyDXbmqfEhc");

        DB_URL=databaseSettings.getProperty("DbUrl","jdbc:mysql://localhost:3306/mydbtest");
        DB_USER=databaseSettings.getProperty("DbUser","root");
        DB_PWD=databaseSettings.getProperty("DbPwd","878988qqq");
    }
}
