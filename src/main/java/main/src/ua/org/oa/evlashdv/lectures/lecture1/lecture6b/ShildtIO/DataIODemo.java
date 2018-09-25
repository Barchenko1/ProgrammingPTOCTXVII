package ua.org.oa.evlashdv.lectures.lecture1.lecture6b.ShildtIO;



import java.io.*;

public class DataIODemo {
    public static void main(String[] args) {
        try (DataOutputStream dout=new DataOutputStream(new FileOutputStream("Test.dat"))){
            dout.writeDouble(98.6);
            dout.writeInt(1000);
            dout.writeBoolean(true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (DataInputStream din=new DataInputStream(new FileInputStream("Test.dat"))){
            double d=din.readDouble();
            int i=din.readInt();
            boolean b=din.readBoolean();
            System.out.printf("полученые значения: "+d+" "+i+" "+b);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
