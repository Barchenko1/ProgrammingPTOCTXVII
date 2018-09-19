package ua.org.oa.evlashdv.lectures.lecture1.lecture6b;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static final String RESOURCES = "./src/main/resources";

    public static void main(String[] args) {
        copyTextFiles(RESOURCES + "/text", RESOURCES + "/text1","utf-8","windows-1251");
        copyTextFilesBuffered(RESOURCES + "/text", RESOURCES + "/text2");
        copyFileByteStream(RESOURCES + "/text", RESOURCES + "/text3");

        try (DataOutputStream dout=new DataOutputStream(new FileOutputStream(RESOURCES+"/data"))){
            dout.writeDouble(25.369);
            dout.writeLong(25648793);
            dout.writeUTF("Hello");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (DataInputStream din=new DataInputStream(new FileInputStream(RESOURCES+"/data"))){
            System.out.println(din.readDouble());
            System.out.println(din.readLong());
            System.out.println(din.readUTF());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copyFileByteStream(String from, String to) {
        try (FileInputStream in=new FileInputStream(from);
            FileOutputStream out=new FileOutputStream(to)){
            byte[] buf=new byte[10];
            int length=0;
            while ((length=in.read(buf))!=-1){
                out.write(buf,0,length);
            }
    }catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copyTextFilesBuffered(String from, String to) {
        try {
            BufferedReader br=new BufferedReader(new FileReader(from));
            BufferedWriter bw=new BufferedWriter(new FileWriter(to));
        while (br.ready()){
                bw.write(br.readLine());
                bw.newLine();
        }
        bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void copyTextFiles(String from, String to, String fromCharSet, String toCharSet) {
        try(InputStreamReader reader=new InputStreamReader(new FileInputStream(from),fromCharSet);
        OutputStreamWriter writer=new OutputStreamWriter(new FileOutputStream(to),toCharSet)){
            while (reader.ready()){
                writer.write(reader.read());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //serializeObjects(RESOURCES+"humans",new Human("Vasya",25));
        deserializeObjects(RESOURCES+"humans").forEach(System.out::println);
    }
    public static  <T>void serializeObjects(String path,T...objects){
        try (ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(path))){

        for (T object:objects) {
            oos.writeObject(object);
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static  <T>List<T> deserializeObjects(String path){
        List<T>tList=new ArrayList<>();
        try (ObjectInputStream ois=new ObjectInputStream(new FileInputStream(path))){
            T object=null;

            while ((object=(T)ois.readObject())!=null){

            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return tList;
    }

}
