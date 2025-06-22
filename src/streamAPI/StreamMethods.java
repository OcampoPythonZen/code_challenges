package streamAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamMethods {


    //How to Predicate internally
    Predicate<Integer> predicate = new Predicate<Integer>() {
        @Override
        public boolean test(Integer n) {
            return n % 2 == 0;
        }
    };

    //How to Comparator internally
    Comparator<Integer> comparator = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }
    };


    public static void predicateBuild() {
        Predicate<Integer> predicate = element -> element % 2 != 0;
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 4, 5, 6, 7, 8, 9));
        List<Integer> numbersNews = numbers.stream().filter(predicate).toList();
        System.out.println(numbersNews);
    }

    public static void filterStream(List<PersonDTO> people) {
        List<String> namesComplaint = people.stream()
                .filter(p -> p.age() < 30)
                .map(PersonDTO::name)
                .sorted()
                .collect(Collectors.toList());
        System.out.println(namesComplaint);
    }

    public static void filterStreamReturningObject(List<PersonDTO> people) {
        List<PersonDTO> peopleFiltered = people.stream()
                .filter(personDTO -> personDTO.age() < 30)
                .sorted(Comparator.comparing(PersonDTO::name))
                .toList();
        System.out.println(peopleFiltered);
    }

    public static void executeFilteredWIthRecordClass() {
        List<PersonDTO> people = List.of(
                new PersonDTO(1L, "Edgar", 38, "QRO", "Ed", null),
                new PersonDTO(2L, "Peter", 28, "EDOMEX", "Piter", null),
                new PersonDTO(3L, "Ana", 29, "CDMX", "Annie", null)
        );
        filterStream(people);
        filterStreamReturningObject(people);
    }

    public static Optional<String> findTheLongestString(List<String> words) {
        return words.stream()
                .max(Comparator.comparingInt(String::length));
    }

    public static Map<String, Long> countWordFrequency(List<String> words) {
        // Function.identity() == e -> e
        return words.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public static List<String> filterAdultsAndByAGe(List<PersonDTO> people) {
        return people.stream()
                .filter(personDTO -> personDTO.age() > 18)
                .sorted(Comparator.comparingInt(PersonDTO::age))
                .map(PersonDTO::name)
                .collect(Collectors.toList());
    }

    public static OptionalDouble AverageLenOfLongString(List<String> words) {
        return words.stream()
                .filter(w -> w.length() > 5)
                .mapToInt(String::length)
                .average();
    }

    public static List<Integer> doubleOddNumberAndFilterMoreThanTen(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 != 0)
                .peek(n -> System.out.println("Odd n: " + n))
                .map(n -> n * 2)
                .peek(n -> System.out.println("n*2: " + n))
                .filter(n -> n > 10)
                .peek(n -> System.out.println("n>10: " + n))
                .collect(Collectors.toList());
    }

    public static List<Integer> flattenAListOfList(List<List<Integer>> nestedList) {
        return nestedList.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    public static boolean checkIfAnyStringIsEmpty(List<String> words) {
        return words.stream()
                //.anyMatch(word -> word.isEmpty())
                .anyMatch(String::isEmpty);
    }

    public static boolean checkIfAllStringsHaveMoreThan3Characters(List<String> words) {
        return words.stream()
                .allMatch(w -> w.length() > 3);
    }

    public static Map<Integer, List<String>> groupByTheirLength(List<String> words) {
        return words.stream()
                .collect(Collectors.groupingBy(
                        String::length,
                        TreeMap::new,
                        Collectors.toList()
                ));
    }


    public static List<Integer> lowPriceToUp(List<Auto> autos) {
        return autos.stream()
                .map(Auto::cost)
                .sorted()
                .collect(Collectors.toList());
    }

    public static List<String> sortedBranchAndPrice(List<Auto> autos) {
        return autos.stream()
                .map(a -> a.brand() + " - $" + a.cost())
                .sorted()
                .collect(Collectors.toList());
    }

    public static List<String> brandsUpTo23(List<Auto> autos) {
        return autos.stream()
                .filter(a -> a.cost() < 23000)
                .map(Auto::model)
                .sorted()
                .collect(Collectors.toList());
    }

    public static List<String> VWOrChevroletModel(List<Auto> autos) {
        return autos.stream()
                .filter(a -> a.brand().equals("Volkswagen") || a.brand().equals("Chevrolet"))
                .map(Auto::model)
                .sorted()
                .collect(Collectors.toList());
    }

    public static boolean anyMatchWithA(List<Auto> autos) {
        return autos.stream()
                .map(Auto::model)
                .anyMatch(a -> a.toLowerCase().contains("a"));
    }

    public static Double pricesAvg(List<Auto> autos) {
        return autos.stream()
                .peek(a -> System.out.println("Auto: " + a.brand() + ", Cost: " + a.cost()))
                .mapToInt(Auto::cost)
                .average()
                .orElse(0.0);
    }


    public static void main(String[] args) {
        List<Auto> autos = List.of(
                new Auto("Volkswagen", "Amarok", 25000),
                new Auto("Volkswagen", "Taos", 32000),
                new Auto("Chevrolet", "Onix", 22000),
                new Auto("Chevrolet", "Tracker", 30000),
                new Auto("Fiat", "Cronos", 21000),
                new Auto("Fiat", "Pulse", 24000),
                new Auto("Toyota", "Corolla", 28000),
                new Auto("Toyota", "Yaris", 23000),
                new Auto("Renault", "Stepway", 20000),
                new Auto("Renault", "Duster", 27000),
                new Auto("Nissan", "Versa", 25000)
        );
        System.out.println(lowPriceToUp(autos));
        System.out.println(sortedBranchAndPrice(autos));
        System.out.println(brandsUpTo23(autos));
        System.out.println(VWOrChevroletModel(autos));
        System.out.println(anyMatchWithA(autos));
        System.out.println(pricesAvg(autos));
    }


}
