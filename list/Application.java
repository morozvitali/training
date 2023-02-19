package list;

public class Application {
    public static void main(String[] args) {
        MyList<Integer> ints = new MyArrayList<>();

        ints.add(1);
        ints.add(2);
        ints.add(3);
        ints.add(4);
        ints.add(5);
        ints.add(6);
        ints.add(7);
        ints.add(8);

        for (int i = 0; i<ints.size();i++) {
            System.out.println(ints.get(i));
        }
        System.out.println();

        ints.addIndexValue(100,5);

        for (int i = 0; i<ints.size();i++) {
            System.out.println(ints.get(i));
        }
        System.out.println(ints.isEmpty());

        for (Integer i : ints) {
            System.out.println(i);
        }




    }
}
