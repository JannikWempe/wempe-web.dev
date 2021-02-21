import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
  public static void main(String[] args) {
    Collection<Integer> numbers = Arrays.asList(1, 2, 3);

    // imperative -> How?
    int sum1 = 0;
    for(int number : numbers) {
      sum1 += number;
    }

    // declarative -> What?
    int sum2 = numbers.stream().reduce(0, Integer::sum);

    System.out.println(sum1); // 6
    System.out.println(sum2); // 6


    Set<Book> books = new HashSet<>();
    books.add(new Book("Clean Code", 464));
    books.add(new Book("The Pragmatic Programmer", 352));
    books.add(new Book("Design Patterns", 416));

    Predicate<Book> longBook = book -> book.getNumPages() > 400;
    Comparator<Book> compareByTitle = Comparator.comparing(Book::getTitle);


    books.stream()
      .sorted(compareByTitle)
      .forEach(System.out::println);

    Stream<Double> randomGenerator = Stream.generate(Math::random);
    randomGenerator.limit(3).forEach(System.out::println);

    Set<String> titles = books.stream()
      .map(Book::getTitle)
      .collect(Collectors.toSet());

    System.out.println(titles);

    System.out.println(Runtime.getRuntime().availableProcessors());
  }
}
