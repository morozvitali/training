package hw;

import java.util.ArrayList;

public class List {
    public static ArrayList toList(String[] array) {
        ArrayList arrayList = new ArrayList();
        for (String str : array) {
            arrayList.add(str);
        }
        return arrayList;
    }


    public static void main(String[] args) {
        String [ ] str = new String[] {"ww",
                "weeww",
                "wqw",
                "wwi",
                "ww",
                "wwkk",
        };
        ArrayList a = toList (str);

        System.out.println(a);


    }
}
