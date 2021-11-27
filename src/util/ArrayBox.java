package util;

public class ArrayBox implements Box {

    private static final int DEFAULT_SIZE = 10;
    private int size = 0;
    private int[] elementData;


    public ArrayBox() {
        elementData = new int[DEFAULT_SIZE];
    }

    public ArrayBox(int cap){
        elementData = new int[cap];
    }

    private void ensureCap(int minCap) {
        if (minCap < elementData.length) {
            this.grow(minCap);
        }
    }

    private void grow(int minCap) {
        int oldCap = elementData.length;
        int newCap = oldCap + oldCap >> 1;
        if (newCap < minCap) {
            newCap = minCap;
        }
        elementData = this.copyOf(elementData, newCap);
    }

    private int[] copyOf(int[] oldArray, int newCap) {
        int[] newArray = new int[newCap];
        for (int i = 0; i < oldArray.length; i++) {
            newArray[i] = oldArray[i];
        }
        return newArray;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new BoxIndexOutOfBoundsException("Index:" + index + ",Size:" + size);
        }
    }

    public boolean add(int element) {
        this.ensureCap(size + 1);
        elementData[size++] = element;
        return true;
    }

    public int get(int index) {
        this.checkIndex(index);
        return elementData[index];
    }


    public int remove(int index) {
        this.checkIndex(index);
        int oldValue = elementData[index];
        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
        elementData[--size] = 0;
        return oldValue;
    }

    public int size() {
        return size;
    }
}
