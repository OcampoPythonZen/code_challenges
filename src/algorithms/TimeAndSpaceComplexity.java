package algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TimeAndSpaceComplexity {

    public static void main(String[] args) {
        String[][] records = {
                {"Edgar", "exit"},
                {"Paul", "enter"},
                {"Paul", "exit"},
                {"John", "enter"},
                {"Paul", "enter"},
                {"Paul", "exit"},
                {"John", "exit"},
                {"Maria", "exit"},
                {"Annie", "enter"},
        };
        Result res = crunchyRollChallenge(records);
        System.out.println("No Exit: " + res.noExit);
        System.out.println("No Entry: " + res.noEntry);
    }


    public static class Result {
        List<String> noExit;
        List<String> noEntry;

        public Result(List<String> noExit, List<String> noEntry) {
            this.noExit = noExit;
            this.noEntry = noEntry;
        }
    }

    /*
    ✅ Final Result
    Type                --      	Complexity
    Time Complexity	                    O(n)
    Space Complexity	                O(n) */

    public static Result crunchyRollChallenge(String[][] records) {
        Map<String, Integer> balance = new HashMap<>();
        Set<String> noEntry = new HashSet<>();
        List<String> noExit = new ArrayList<>();

        for (String[] record : records) {
            String name = record[0];
            String status = record[1];
            if (status.equals("enter")) {
                balance.put(name, balance.getOrDefault(name, 0) + 1);
            } else if (status.equals("exit")) {
                if (balance.getOrDefault(name, 0) == 0) {
                    noEntry.add(name);
                } else {
                    balance.put(name, balance.get(name) - 1);
                }
            }
        }

        for (Map.Entry<String, Integer> entry : balance.entrySet()) {
            if (entry.getValue() > 0) {
                noExit.add(entry.getKey());
            }
        }

        return new Result(noExit, new ArrayList<>(noEntry));
    }
}
