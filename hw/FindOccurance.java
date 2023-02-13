package hw;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class FindOccurance {
    ArrayList<String> arrayList;

        public static HashMap findOccurance(ArrayList<String> arrayList) {

            HashMap dataResult = new HashMap<>(); // ініціалізуємо геш меп!
            ArrayList<String> arrayListCopy = arrayList;

            for (int i = 0; i < arrayList.size(); i++) {
                int counter = 0;
                for (int a = 0; a < arrayList.size(); a++) {
                    if (arrayListCopy.get(i).contains(arrayList.get(a))) {
                        counter++;
                    }
                }

                String value = arrayList.get(i);
                dataResult.put(value, counter);
            }
            return dataResult;
        }

        public static void main(String[] args) {
            ArrayList <String> arrayList = new ArrayList<>();
            arrayList.add("hi");
            arrayList.add("Kitty");
            arrayList.add("Kitty");
            arrayList.add("Kitty");
            arrayList.add("hi");
            arrayList.add("bye");
            arrayList.add("bye");
            arrayList.add("bye");
            arrayList.add("bye");
            arrayList.add("bye");
            arrayList.add("bye");
            arrayList.add("hi");
            arrayList.add("hi");
            arrayList.add("hello");
            arrayList.add("hello");
            arrayList.add("hello");
            arrayList.add("hello");
            arrayList.add("hi");
            arrayList.add("hello");
            arrayList.add("hello");
            arrayList.add("hello");
            arrayList.add("hello");
            arrayList.add("hello");
            arrayList.add("hello");
            arrayList.add("Kitty");
            arrayList.add("Kitty");
            arrayList.add("Kitty");
            arrayList.add("Kitty");
            arrayList.add("Kitty");

            System.out.println(findOccurance(arrayList));

        }
    }


