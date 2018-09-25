package ua.org.oa.evlashdv.lectures.lecture1.testPractice.testPractice2;

import java.util.Iterator;

public class MyListImpl implements MyList,ListIterable{
    private int size=0;
    private Object[] array;

    public MyListImpl() {
        this.array = new Object[size];
    }

    @Override
    public void add(Object e) {
        if (size==array.length){
            resize(size+1);
        }
        array[size]=e;
        size++;
    }

    private void resize(int newSize) {
        Object[] newArray=new Object[newSize];
        System.arraycopy(array,0,newArray,0,array.length);
        array=newArray;
    }

    @Override
    public void clear() {
        size=0;
    }

    @Override
    public boolean remove(Object o) {
        boolean found = false;
        int i;

        for (i = 0; i < array.length; i++) {
            if (array[i] == null && array[i] == o) {
                found = true;
                break;
            } else if (array[i] != null && array[i].equals(o)) {
                found = true;
                break;
            }
        }

        if (!found)
            return false;

        for (int j = 0; j < size; j++) {
            if (array[i]==null||array[j].equals(o)){
                System.arraycopy(array,j+1,array,i,size-j-1);
                size--;
                return true;
            }
        }
        return false;

    }

    @Override
    public Object[] toArray() {
        Object[] newArray=new Object[size];
        System.arraycopy(array,0,newArray,0,size);
        return newArray;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (array[i]==null&array[i]==o){
                return true;
            }else if (array[i]!=null&&array[i].equals(o)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(MyList c) {
        int point=0;
        Object[] checkTheArray=c.toArray();
        for (Object e:checkTheArray) {
            if (contains(e)){
                point++;
            }
        }
        return point==c.size();
    }

    @Override
    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    @Override
    public ListIterator listIterator() {
        return new ListIteratorImpl();
    }

    private class IteratorImpl implements Iterator<Object>{
        protected int counter;
        protected int cursor;
        protected boolean checkRemove = true;

        @Override
        public boolean hasNext() {
            return cursor<size;
        }

        @Override
        public Object next() {
            counter = cursor;
            cursor = counter + 1;
            checkRemove = true;
            return array[counter];
        }

        @Override
        public void remove() {
            if (cursor==0 | !checkRemove) {
                throw new IllegalStateException();
            }
            Object[] newArray=new Object[size];
            System.arraycopy(array,0,newArray,0,cursor);
            System.arraycopy(array,counter+1,newArray,counter,size-(counter+1));
            checkRemove=false;
            cursor--;
            size--;
            array=newArray;
        }
    }

    @Override
    public String toString() {
        String str="";
        for (int i = 0; i < size; i++) {
            str+="результат вызова toString для элемента "+array[i]+", ";
        }
        return "["+str+"]";
    }


    private class ListIteratorImpl extends IteratorImpl implements ListIterator {
        @Override
        public boolean hasPrevious() {
            if (cursor==0){
                return false;
            }
            return true;
        }

        @Override
        public Object previous() {
            counter = cursor-1;
            cursor = counter;
            checkRemove = true;
            return array[counter];
        }

        @Override
        public void set(Object e) {
            if (cursor == 0 || !checkRemove) {
                throw new IllegalStateException();
            }
            array[cursor]=e;
            checkRemove = false;
        }
    }
}
