package hw;

import java.util.ArrayList;

public class Occurance {
    public static int countOccurance(ArrayList aList, String str) {
        int counter = 0;
        for (Object al : aList) {
            if (al.equals(str)) {
                counter++;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("hi");
        arrayList.add("hi");
        arrayList.add("hi");
        arrayList.add("hi");
        arrayList.add("hello");
        arrayList.add("hi");
        arrayList.add("hello");
        arrayList.add("hi");
        arrayList.add("hello");
        arrayList.add("bye");

        System.out.println(countOccurance (arrayList, "hi"));

    }
}
