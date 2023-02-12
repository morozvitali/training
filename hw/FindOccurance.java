package hw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
/////////////////////////////////
///////////////////////////// 4***
///////////////////////////////////////

public class FindOccurance {


    public static void calcOccurance(ArrayList<String> arrayList) {

        ArrayList <String> arrayListCopy = arrayList;

        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayListCopy.get(i) + ": ");
            int counter = 0;
            for (int a = 0; a <arrayList.size(); a++) {
                if (arrayListCopy.get(i).contains(arrayList.get(a))) {
                    counter++;
                }
            }
            arrayListCopy.removeAll(Collections.singleton(arrayList.get(i)));
            System.out.println(counter);
        }
    }

    public static void main(String[] args) {
        ArrayList <String> arrayList = new ArrayList<>();

        arrayList.add("dog");
        arrayList.add("dog");
        arrayList.add("dog");
        arrayList.add("dog");
        arrayList.add("dog");
        arrayList.add("dog");
        arrayList.add("dog");
        arrayList.add("dog");



        arrayList.add("cat");
        arrayList.add("cat");
        arrayList.add("cat");
        arrayList.add("cat");
        arrayList.add("cat");
        arrayList.add("cat");
        arrayList.add("cat");
        arrayList.add("cat");
        arrayList.add("dog");
        arrayList.add("dog");
        arrayList.add("dog");
        arrayList.add("dog");
        arrayList.add("dog");
        arrayList.add("dog");
        arrayList.add("dog");
        arrayList.add("cat");
        arrayList.add("fox");
        arrayList.add("dog");
        arrayList.add("dog");
        arrayList.add("fox");
        arrayList.add("fox");
        arrayList.add("fox");
        arrayList.add("fox");
        arrayList.add("fox");
        arrayList.add("fox");
        arrayList.add("fox");
        arrayList.add("fox");
        arrayList.add("dog");
        arrayList.add("fox");
        arrayList.add("fox");
        arrayList.add("fox");

        calcOccurance (arrayList);


    }

}
