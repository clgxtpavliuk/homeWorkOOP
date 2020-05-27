import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Citizen {
    private String name;
    private String surname;
    private Sex sex;
    private DomesticAnimal domesticAnimal;
    private int children;

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public DomesticAnimal getDomesticAnimal() {
        return domesticAnimal;
    }

    public void setDomesticAnimal(DomesticAnimal domesticAnimal) {
        this.domesticAnimal = domesticAnimal;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(" Citizen: ");
        sb.append(name).append(' ');
        sb.append(surname);
        return sb.toString();
    }
}
