package map;

import java.util.HashMap;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        map.put("fkjf", 44);
        map.put("fkjf", 4);
        map.put("fkjf", 34);
        map.put("fkjf", 54);

        System.out.println(map);


    }


}
