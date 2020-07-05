package utils;

public class PriceParser {
    public static PriceInfo parsePriceRange(String range) {
        String[] parts = range.split("-");
        String min = parts[0].trim().replace("$", "");
        String max = parts[1].trim().replace("$", "");
        PriceInfo priceInfo = new PriceInfo();
        priceInfo.setMinPrice(Double.parseDouble(min));
        priceInfo.setMaxPrice(Double.parseDouble(max));
        return priceInfo;
    }

    public static double parsePrice(String pr) {
        String price = pr.trim().replace("$", "");
        return Double.parseDouble(price);
    }
}
