package hometask3.stringTask;

public class RLE {
    private String inputString;

    public String convert(String inputString) {
        int counter = 1;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0; i<inputString.length(); i++) {
            char a = inputString.charAt(i);
            if (a == '\\') {
                stringBuilder.append("\\\\");
            } else if ((i+1)<inputString.length() && inputString.charAt(i+1) == a) {
                counter ++;

            } else if (Character.isDigit(a)) {
                stringBuilder.append("\\");
                stringBuilder.append(a);
            }
            else {
                stringBuilder.append(counter);
                stringBuilder.append(a);
                counter = 1;
            }
        }
        return stringBuilder.toString();
    }
}