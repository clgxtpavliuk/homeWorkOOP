public enum Sex {
    MALE("Male"),
    FEMALE("Female");

    private String value;

    Sex(String sex) {
        this.value=sex;
    }

    public static Sex valueOfSex(String label) {
        for (Sex e : values()) {
            if (e.value.equals(label)) {
                return e;
            }
        }
        return null;
    }
}