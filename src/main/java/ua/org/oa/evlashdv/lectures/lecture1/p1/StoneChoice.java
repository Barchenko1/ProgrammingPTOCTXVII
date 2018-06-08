package ua.org.oa.evlashdv.lectures.lecture1.p1;

import java.io.FileNotFoundException;
import java.io.IOException;

class Stone{
    void build() throws FileNotFoundException, IOException {}
}
class WhiteStone extends Stone{
    void build(){
        System.out.println("белый камень");
    }
}
class BlachStone extends Stone{
    void build() throws IOException{
        System.out.println("черный камень");
    }
}
public class StoneChoice {
    static void infoStone(Stone stone){
        try {
            stone.build();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
