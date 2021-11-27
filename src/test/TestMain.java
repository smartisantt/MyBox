package test;

import util.*;

public class TestMain {
    public static void main(String[] args) {
        ArrayBox ab = new ArrayBox();
        ab.add(11);
        ab.get(0);
        ab.remove(0);

        LinkedBox lb = new LinkedBox();
        lb.add(22);
        lb.get(0);
        lb.remove(0);

    }
}
