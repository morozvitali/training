package phonebook;

import java.util.ArrayList;

public class Record {
    private String name;
    private String number;
    ArrayList <String> numberList = null;

        // конструктор + запись вв книжке, имя и много номеров телефонов

    public Record (String name, String number) {
        this.name = name;
        numberList.add (this.number);
    }
    public void addNumber (String number) {
        numberList.add(number);
    }

}
