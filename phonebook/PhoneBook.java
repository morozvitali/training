package phonebook;
// зробити не паблік
//зробити окремий аплікейшн
//видалити сміття

import java.util.ArrayList;
public class PhoneBook {
    public  ArrayList<Record> phonebook = new ArrayList<>();
    public void add(String name, String number) {
        phonebook.add(new Record(name, number));
    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "phonebook=" + phonebook.toString() +
                '}';
    }

    public Record find (String partName) {
        for (Record rec : phonebook) {
            if (rec.name.contains(partName)) {
                return rec;
            }
        }
        return null;
    }

    public ArrayList <Record> findAll (String partName) {
        ArrayList <Record> findAllList = new ArrayList<>();
        for (Record rec : phonebook) {
            if (rec.name.contains(partName)) {
                findAllList.add(rec);
            }
        }
        return findAllList;
    }

    public static void main(String[] args) {
        PhoneBook phonebook = new PhoneBook();
        phonebook.add("енігма" , "21356745674");
        phonebook.add("бетмен" , "25675744357557234");
        phonebook.add("фриз" , "245674567557234");
        phonebook.add("смайл" , "21344577234");
        phonebook.add("джокер" , "21343574567234");

        System.out.println(phonebook);

        phonebook.find("бе");
        System.out.println(phonebook.findAll("а"));
    }
}

class Record {
    @Override
    public String toString() {
        return "Запис у книжці: " +
                "Iм'я " + name + " Номер телефону " + numberList.toString();
    }

    public String name;
    public ArrayList <String> numberList = new ArrayList<>();
    //public String number;

    public Record (String name, String number) {
        this.name = name;
        numberList.add (number);
    }
}

