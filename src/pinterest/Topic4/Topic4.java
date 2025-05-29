package pinterest.Topic4;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Topic4 {

    public List<Integer> iceCreamParlor(int m, List<Integer> arr) {
        Map<Integer, Integer> seenPrices = new HashMap<>();
        for (int i = 0; i < arr.size(); i++) {
            int currentPrice = arr.get(i);
            int neededPrice = m - currentPrice;
            if (seenPrices.containsKey(neededPrice)) {
                int indexNeeded = seenPrices.get(neededPrice);
                return Arrays.asList(
                        Math.min(i + 1, indexNeeded + 1),
                        Math.max(i + 1, indexNeeded + 1)
                );
            } else {
                seenPrices.put(currentPrice, i);
            }
        }
        return Collections.emptyList();
    }

    public boolean colorFullNumbers(int number) {
        HashSet<Integer> set = new HashSet<>();
        String colorString = String.valueOf(number);
        int len = colorString.length();
        for (int i = 0; i < len; i++) {
            int product = 1;
            for (int j = i; j < len; j++) {
                int value = colorString.charAt(j) - '0';
                product *= value;
                if (set.contains(product)) {
                    return false;
                } else {
                    set.add(product);
                }
            }
        }
        return true;
    }

}
