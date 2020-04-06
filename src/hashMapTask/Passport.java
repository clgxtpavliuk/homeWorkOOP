package hashMapTask;

public class Passport {
    private String series;
    private int number;

    public Passport(String series, int number) {
        this.series = series;
        this.number = number;
    }

    public String getSeries() {
        return series;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Passport: ");
        sb.append(series).append(' ');
        sb.append(number).append(' ');
        return sb.toString();
    }
}
