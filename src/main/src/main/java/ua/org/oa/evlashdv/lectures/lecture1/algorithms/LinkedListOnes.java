package ua.org.oa.evlashdv.lectures.lecture1.algorithms;

public class LinkedListOnes {
    public static void main(String[] args) {
        Node tail=null;
        for (int i = 0; i < 10; i++) {
            tail=new Node(i,tail);
        }

//        for (int i = 0; i < 10; i++) {
//            tail1=new Node(i,tail1);
//        }
        Node tail1=new Node(3,null);
        Node tail2=new Node(6,tail1);
        Node tail3=new Node(9,tail2);
        print(tail3);
        System.out.println();
        System.out.println(toStr(tail));
        System.out.println(copy(tail));
        System.out.println(isEqul(tail,tail1));
//        Node cursor=tail;
//        while (cursor!=null){
//            System.out.println(" "+cursor.value);
//            cursor=cursor.next;
//        }
    }
    static void print(Node tail){
        System.out.print(" "+tail.value);
        if (tail.next!=null)
        print(tail.next);
    }
    static String toStr(Node tail){
        return (tail==null)?(""):(tail.value+" "+toStr(tail.next));
    }
    static Node copy(Node tail){
        return tail==null?null:new Node(tail.value,copy(tail.next));
    }
    static boolean isEqul(Node t0,Node t1){
        if (t0!=null&&t1!=null){
            return (t0.value==t1.value) && isEqul(t0.next, t1.next);
        }else {
            return t0==t1;
        }
    }
}
