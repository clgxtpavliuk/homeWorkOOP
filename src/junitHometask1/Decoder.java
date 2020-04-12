package junitHometask1;

public class Decoder {

    public void validate(String inputString) {
        int counter = 1;
        for (int i = 0; i < inputString.length(); i++) {
            if ((i + 1) < inputString.length() && inputString.charAt(i) == '\\') {
                while (inputString.charAt(i+1) == '\\') {
                    counter++;
                    i++;
                }
                if ((counter % 2) == 0) {
                    throw new ValidationException("Input string did not pass the validation: incorrect number of slashes: " + counter);
                }
            }
        }}

    public String convert(String inputString) {
        validate(inputString);
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder1 = new StringBuilder();
        for (int i = 0; i < inputString.length(); i++) {
            char a = inputString.charAt(i);
            if ((i + 1) < inputString.length() && Character.isDigit(a)) {
                if (Character.isLetter(inputString.charAt(i + 1))) {//digit then letter
                    for (int j = 1; j <= Character.getNumericValue(a); j++) {
                        stringBuilder.append(inputString.charAt(i + 1));
                    }
                } else if (Character.isDigit(inputString.charAt(i + 1))) {
                    do {
                        stringBuilder1.append(a);
                        stringBuilder1.append(inputString.charAt(i + 1));
                        i++;
                    } while (Character.isDigit(inputString.charAt(i + 1)));
                    for (int j = 1; j <= Integer.parseInt(stringBuilder1.toString()); j++) {
                        stringBuilder.append(inputString.charAt(i + 1));
                    }
                }
            } else if ((i + 1) < inputString.length() && a == '\\' && inputString.charAt(i + 1) == '\\') {
                stringBuilder.append("\\");
                i++;
            } else if ((i + 1) < inputString.length() && a == '\\' && Character.isDigit(inputString.charAt(i + 1))) {
                stringBuilder.append(inputString.charAt(i + 1));
            }
        }
        return stringBuilder.toString();
    }
}