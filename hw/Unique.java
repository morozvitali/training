package hw;

import java.util.ArrayList;

public class Unique {
    public static ArrayList <Integer> findUnique(ArrayList<Integer> arrayList) {
        ArrayList <Integer> arrayListCopy = arrayList;
        ArrayList <Integer> arrayListResult = null;

        for (int i = 0; i<arrayList.size(); i++) {
            for (int a = 0; a<arrayList.size(); a++) {
                if (i == a) {
                    continue;
                }

                if (arrayList.get(i) == arrayListCopy.get(a)) {
                    arrayListCopy.remove(a);
                }
            }
        }

//        for (Integer i : arrayListCopy) {
//            if (arrayList.get(i)!= null) {
//                arrayListResult.add(arrayListCopy.get(i));
//            }
//        }
        return arrayListCopy;
    }

    public static void main(String[] args) {
        ArrayList <Integer> arrayList = new ArrayList();
        arrayList.add(11);
        arrayList.add(12);
        arrayList.add(13);
        arrayList.add(11);
        arrayList.add(12);
        arrayList.add(200);
        arrayList.add(13);
        arrayList.add(11);
        arrayList.add(12);
        arrayList.add(13);
        arrayList.add(14);
        arrayList.add(15);

        System.out.println(findUnique (arrayList));

    }
}
