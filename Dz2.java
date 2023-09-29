package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class PhoneBook {

    private static java.util.HashMap<String, ArrayList> contacts = new HashMap();

    public static void addContact(String name, String phoneNumber) {
        if (contacts.containsKey(name)) {
            ArrayList phoneNumbers = contacts.get(name);
            if(!phoneNumbers.contains(phoneNumber)) {
                phoneNumbers.add(phoneNumber);
                contacts.put(name, phoneNumbers);
            }
        } else {
            ArrayList phoneNumbers = new ArrayList();
            phoneNumbers.add(phoneNumber);
            contacts.put(name, phoneNumbers);
        }
    }

    public static void printContacts() {
        ArrayList<Map.Entry<String, ArrayList>> list =
                new ArrayList(contacts.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, ArrayList>>() {
            public int compare(Map.Entry<String, ArrayList> o1, Map.Entry<String, ArrayList> o2) {
                return o2.getValue().size() - o1.getValue().size();
            }
        });
        
        for (Map.Entry<String, ArrayList> entry : list) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        addContact("Петр Иванович", "8-900-505-30-00");
        addContact("Макс Сантехник", "8-908-505-35-11");
        addContact("Макс Сантехник", "8-988-005-35-81");
        addContact("Макс Сантехник", "8-908-999-35-91");
        addContact("Петр Иванович", "8-900-505-30-00");

        contacts.forEach((k, v) -> System.out.print(k + " = " + v + ", "));
    }
}
