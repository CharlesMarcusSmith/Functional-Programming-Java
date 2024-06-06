/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package counter;

import counter.items.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;

public class App {
    public static void main(String[] argv) {
        // Some things to count
        List<Apple> someApples = Arrays.asList(
                new Apple(Colour.RED, LocalDate.of(2023, 3, 8), LocalDate.of(2023, 5, 4)),
                new Apple(Colour.RED, LocalDate.of(2023, 2, 10), LocalDate.of(2023, 6, 20)),
                new Apple(Colour.RED, LocalDate.of(2023, 1, 7), LocalDate.of(2023, 4, 18)),
                new Apple(Colour.YELLOW, LocalDate.of(2023, 3, 25), LocalDate.of(2023, 5, 11)),
                new Apple(Colour.YELLOW, LocalDate.of(2023, 2, 23), LocalDate.of(2023, 4, 16)),
                new Apple(Colour.GREEN, LocalDate.of(2023, 2, 12), LocalDate.of(2023, 3, 7)),
                new Apple(Colour.GREEN, LocalDate.of(2023, 2, 9), LocalDate.of(2023, 5, 9)),
                new Apple(Colour.GREEN, LocalDate.of(2023, 3, 1), LocalDate.of(2023, 4, 10))
        );

        Box<Apple> boxOfApples = new Box<>();
        boxOfApples.add(new Apple(Colour.RED, LocalDate.of(2023, 3, 8), LocalDate.of(2023, 5, 4)));
        boxOfApples.add(new Apple(Colour.YELLOW, LocalDate.of(2023, 2, 23), LocalDate.of(2023, 4, 16)));

        Cart<Apple> cart = new Cart<>();
        cart.add(boxOfApples);

        System.out.println("Lambda Exercise Output:");
        // Sorting exercise:

        // Use overridden class:
        Collections.sort(someApples, new bestBeforeComparator());

        // Use inline anonymous class:
        Collections.sort(someApples, new Comparator<Apple>() {
            @Override
            public int compare(Apple a1, Apple a2) {
                return a1.bestBefore().compareTo(a2.bestBefore());
            }
        });

        // Use Lambda:
        Collections.sort(someApples, (a1, a2) -> a1.bestBefore().compareTo(a2.bestBefore()));
        // Recommended syntax improvement:
        Collections.sort(someApples, Comparator.comparing(Apple::bestBefore));

        // ForEach exercise:
        System.out.println();
        System.out.println("After sorting:====================================================");
        someApples.forEach(Apple -> System.out.println(Apple.toString()));
        System.out.println();

        // ArrayOfComparators:
        Comparator<Apple>[] comparators = new Comparator[3];



        System.out.println("Streams Exercises Output:");
        // Add your stream exercises here

        System.out.println("Print all:");
        someApples.stream()
                .forEach(apple -> System.out.println(apple));
        System.out.println();

        // Lambda improved upon in this version:
        System.out.println("Skip first 3:");
        someApples.stream()
                .skip(3)
                .forEach(System.out::println);
        System.out.println();

        System.out.println("Find first item:");
        someApples.stream()
                        .limit(1)
                        .forEach(System.out::println);
        System.out.println();

        System.out.println("Filter apples picked before March 2023:");
        someApples.stream()
                .filter(apple -> apple.datePicked().isBefore(
                LocalDate. of(2023, 3, 1)))
                .forEach(System.out::println);
        System.out.println();

        System.out.println("Best before May:");
        someApples.stream()
                .filter(apple -> apple.bestBefore().isBefore(
                LocalDate. of(2023, 5, 1)))
                .forEach(apple -> System.out.println(
                        "There is a " + apple.colour() + "apple that is best before " + apple.bestBefore()
                ));
        System.out.println();

        System.out.println("All Red apples:");
        someApples.stream()
                        .filter(apple -> apple.colour().equals(Colour.RED))
                        .forEach(System.out::println);
        System.out.println();

        //Task 7 is the same result as task 2 but:
        someApples.stream()
                .sorted(new bestBeforeComparator())
                .skip(3)
                .forEach(System.out::println);
        System.out.println();


        System.out.println("Predicate Exercises Output:");
        Counter<Apple> appleCounter = new Counter<>();
        someApples.forEach(appleCounter::add);

        System.out.println(appleCounter.getCount()); // Should be 8

        Counter<Cart<Apple>> cartCounter = new Counter<>();
        cartCounter.add(cart);

        System.out.println(cartCounter.getCount()); // Should be 2 (number of apples in the cart in total)

        Counter<Countable> anythingCounter = new Counter<>();
        someApples.forEach(anythingCounter::add);
        anythingCounter.add(cart);

        System.out.println(anythingCounter.getCount()); // Should be 10 - sum of the above
    }
}
