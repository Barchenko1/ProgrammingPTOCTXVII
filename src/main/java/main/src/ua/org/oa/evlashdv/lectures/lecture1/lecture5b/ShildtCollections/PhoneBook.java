package ua.org.oa.evlashdv.lectures.lecture1.lecture5b.ShildtCollections;

import java.io.*;
import java.util.Properties;

public class PhoneBook {
    public static void main(String[] args) throws IOException {
        Properties ht=new Properties();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String name,number;
        FileInputStream fil=null;
        boolean changed=false;
        try {
            fil=new FileInputStream("phonebook.dat");
        } catch (FileNotFoundException e) {

        }
        try {
            if (fil!=null){
                ht.load(fil);
                fil.close();
            }
        }catch (IOException e){
            System.out.println("Ошибка чтения файла");
        }
        do {
            System.out.println("введите имя (выход для завершения): ");
            name=br.readLine();
            if (name.equals("выход"))continue;
            System.out.println("Введите номер: ");
            number=br.readLine();
            ht.put(name,number);
        }while (!name.equals("выход"));
        if (changed){
            FileOutputStream fout=new FileOutputStream("phonebook.dat");
            ht.store(fout,"Телефонная книга");
            fout.close();
        }
        do {
            System.out.println("введите имя (выход для завершения): ");
            name=br.readLine();
            if (name.equals("выход"))continue;
            number=(String )ht.get(name);
            System.out.println(number);
        }while (!name.equals("выход"));
    }
}
