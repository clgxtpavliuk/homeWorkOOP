public enum DomesticAnimal {
    DOG("Dog"),
    CAT("Cat"),
    PARROT("Parrot");

    private String value;

    DomesticAnimal(String domesticAnimal) {
        this.value=domesticAnimal;
    }

    public static DomesticAnimal valueOfDomesticAnimal(String label) {
        for (DomesticAnimal e : values()) {
            if (e.value.equals(label)) {

                return e;
            }
        }

        return null;
    }
}