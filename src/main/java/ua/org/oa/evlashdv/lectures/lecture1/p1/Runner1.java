package ua.org.oa.evlashdv.lectures.lecture1.p1;

import java.util.Random;

class Transport {
    public void repair() {/* пустая реализация */
    }
}
class Bus extends Transport {
    public void repair() {
        System.out.println("отремонтирован АВТОБУС");
    }
}
class Tram extends Transport {
    public void repair() {
        System.out.println("отремонтирован ТРАМВАЙ");
    }
}
class RepairingFactory {//шаблон Factory

    public Transport getClassFromFactory(int numMode) {
        switch (new Random().nextInt(numMode)) {
            case 0:
                return new Bus();
            case 1:
                return new Tram();
            default:
                throw new IllegalArgumentException();
        }
    }
}
public class Runner1 {
    public static void main(String[] args) {
        RepairingFactory rc=new RepairingFactory();
        Transport[] box=new Transport[15];
        for (int i = 0; i <box.length ; i++) {
            box[i]=rc.getClassFromFactory(2);
            for (Transport s:box) {
                s.repair();
            }
        }
    }
}
