package phonebook;

import java.util.ArrayList;

public class PhoneBook {
    ArrayList phonebook = null;
    private Record record;
    public void add (Record record) {
        phonebook.add(record);
    }
}
