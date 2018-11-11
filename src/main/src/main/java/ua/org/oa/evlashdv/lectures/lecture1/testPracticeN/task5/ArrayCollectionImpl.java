package ua.org.oa.evlashdv.lectures.lecture1.testPracticeN.task5;

import interfaces.task5.ArrayCollection;
import interfaces.task5.ArrayIterator;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayCollectionImpl<E> implements ArrayCollection<E> {
    //private int length;
    private int size=0;
    private E[] objArray= (E[]) new Object[0];

    private class ArrayIteratorImpl implements ArrayIterator<E> {
        private int cursor;
        private int counter;
        //private boolean call;


        @Override
        public Object[] getArray() {
            return objArray;
        }

        @Override
        public boolean hasNext() {
            if (cursor == size){
                return false;
            }
            return true;
        }

        @Override
        public E next() {
            if (counter >= size){
                throw new NoSuchElementException();
            } else {
                counter = cursor++;
                //call=true;
                return objArray[counter];
            }
        }

    }

    @Override
    public Object[] getArray() {
        return objArray;
    }

    @Override
    public void setArray(E[] e) {
        objArray = e;
        //length=objArray.length;
        size=objArray.length;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size==0){
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        boolean flag = false;
        if (o==null){
            for (int i = 0; i < size; i++) {
                if (objArray[i]==null){
                    flag=true;
                    return flag;
                }
            }
        }
        for (int i = 0; i < size; i++) {
            if (objArray[i].equals(o)){
                flag=true;
                return flag;
            }
        }
        return flag;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayIteratorImpl();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] ts) {
        return (T[]) objArray;
    }

    @Override
    public boolean add(E e) {
        if (size == objArray.length){
            arrayUpSize(1);
            objArray[size] = e;
            size++;
        }else {
            objArray[size] = e;
            size++;
        }
        return true;
    }

    @Override
    public boolean remove(Object o) {
        boolean flag=false;
        for (int i = 0; i < objArray.length; i++) {
            if (objArray[i].equals(o)){
                removeByIndex(i);
                arrayDownSize(1);
                flag=true;
                return flag;
            }
        }
        return flag;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        for (Object o:collection) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        if (this == collection){
            throw new IllegalArgumentException();
        }
        for (E e:collection) {
            add(e);
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        boolean flag=false;
        for (Object o:collection) {
            if (remove(o)){
                flag=true;
            }
        }
        return flag;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        if (collection == null){
            throw new NullPointerException();
        }
        boolean flag=false;
        Object o;
        for (int i = 0; i < size; i++) {
            o=objArray[i];
            if (!collection.contains(o)){
                this.remove(o);
                flag=true;
            }
        }
        return flag;
    }

    @Override
    public void clear() {
        //objArray= (E[]) new Object[0];
        size=0;
    }
    private void arrayUpSize(int up){
        E[] tempArray = (E[]) new Object[objArray.length + up];
        System.arraycopy(objArray,0,tempArray,0,objArray.length);
        objArray = tempArray;
    }
    private void arrayDownSize(int down){
        E[] tempArray = (E[]) new Object[objArray.length - down];
        System.arraycopy(objArray,0,tempArray,0,tempArray.length);
        objArray = tempArray;
    }
    private void removeByIndex(int i){
        System.arraycopy(objArray,i+1,objArray,i,objArray.length-1-i);
        objArray[size-1]=null;
        size--;
    }

}
