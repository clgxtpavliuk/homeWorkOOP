package hashMapTask;

import java.util.HashMap;

public class Test {
    public static void main (String[] args) {
        Citizen citizen1 = new Citizen("George", "Washington");
        Citizen citizen2 = new Citizen("Thomas", "Jefferson");
        Citizen citizen3 = new Citizen("Theodore",  "Roosevelt");

        Passport passport1 = new Passport("JS", 258469);
        Passport passport2 = new Passport("WQ", 741258);
        Passport passport3 = new Passport("SA", 963852);

        HashMap<Passport, Citizen> searchCitizens = new HashMap<Passport, Citizen>();
        searchCitizens.put(passport1, citizen1);
        searchCitizens.put(passport2, citizen2);
        searchCitizens.put(passport3, citizen3);

        System.out.println(searchCitizens.entrySet());
        System.out.println(searchCitizens.get(passport1));

    }
}
