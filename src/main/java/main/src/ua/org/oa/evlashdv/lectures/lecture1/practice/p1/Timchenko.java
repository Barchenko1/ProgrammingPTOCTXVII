package ua.org.oa.evlashdv.lectures.lecture1.practice.p1;

public class Timchenko {
    public static void main(String[] args) {
        int b;
        double s;
        double c;
        double Fck;
        double Gl;
        double Rnv;
        double r0 = 0.1;
        double Yl;
        double Y;
        double w=16.9;
        double ml=20;
        double Rl=1.402;
        double qb;
        double qm;

        b(r0);
        System.out.println();
//        fcb(ml,w,r0,Rl);
    }

    private static double b(double r0) {
        int b;
        double s;
        double c;
        double Fck;
        double Gl;
        double Rnv;
        double Y;
        double Yl;
        for (b = 3; b < 16; b++) {
             s=Math.sin(b);
             c=Math.cos(b);
             Fck=3.296*Math.pow(10,5);
             Gl=1.764*Math.pow(10,3);
             Rnv=12.722;
             r0=0.1;
             Y=2.176*Math.pow(10,4);
             Yl=Y*(0.7*Rnv-r0)-Gl*((Rnv-r0)/2)*c-Fck*((Rnv-r0)/2)*s;
            System.out.println("b="+b+" Yl= "+Yl);
        }
        return r0;
    }

    static void fcb(double ml, double w, double r0, double Rl){
        double fcb;
        double qn1;
        double qn2;
        for (int i=8; i > -1; i--) {
            fcb=ml*Math.pow(w,2)*(r0+i*Rl+(Rl/2))*Math.cos(6.5);
            for (int j = 0; j < 1; j++) {
                int N1=0;
                N1+=fcb*Math.cos(6.5);
                System.out.println("N1 = "+N1);
                for (int k = 0; k < 1; k++) {
                    qn1=N1/Rl;
                    System.out.println("qn1 "+qn1);
                    for (int f = 0; f < 1; f++) {
                        double q1;
                        double qb=1710;
                        double qm=139.756;
                        q1=qb-qm-qn1;
                        System.out.println("qE1= "+q1);
                    }
                }
            }
            for (int k = 0; k < 1; k++) {
                int N2=0;
                N2+=fcb*Math.sin(6.5);
                System.out.println("N2 = "+N2);
                for (int j = 0; j < 1; j++) {
                    qn2=N2/Rl;
                    System.out.println("qn2 "+qn2);
                    for (int f = 0; f < 1; f++) {
                        double q2;
                        double qb=1710;
                        double qm=139.756;
                        q2=qb-qm-qn2;
                        System.out.println("qE2= "+q2);
                    }
                }
            }
            System.out.println("fcb = "+fcb+" i= "+i);
        }
    }
}
