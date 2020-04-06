package stringTask;

public class Test {
    public static void main(String[] args) {
        String string1 = "AAAAaaaBBBBBB\\12";
        String string2 = "AaaaBB2";
        String string3 = "AaaaBB\\\\2";

        RLE rle = new RLE();

//        System.out.println(rle.convert(string1));
//        System.out.println(rle.convert(string2));
//        System.out.println(rle.convert(string3));

        String stringWithError = "4A3a6B\\\\1\\2";
        String stringForDecoder = "4A3a6B\\\\\\\\1\\2";
        Decoder decoder = new Decoder();

        System.out.println(decoder.convert(stringForDecoder));
        //System.out.println(decoder.convert(stringWithError));
    }
}
