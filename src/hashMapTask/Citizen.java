package hashMapTask;

public class Citizen {
    private String name;
    private String surname;

    public Citizen(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(" Citizen: ");
        sb.append(name).append(' ');
        sb.append(surname);
        return sb.toString();
    }
}
