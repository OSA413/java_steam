import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String args[]) {
        var stream = new Random().ints(1000, 10, 10000);

        var collected = stream.toArray();
        var countEven = stream.filter(x -> x%2 == 0).count();
        var reduce = stream.reduce((accum, x) -> accum + x);
        stream.forEach(x -> System.out.println(x));
        var collectedMap = stream.boxed().collect(Collectors.toMap(x -> x, x -> x*x));

        var lorem = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
        var stream2 = Arrays.stream(lorem.split(""));

        var longWords = stream2.filter(x -> x.length() > 7).toList();
        var stats = stream2.collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        var averageLen = stream2.map(String::length).mapToInt(x -> x).average();
        var dots = stream2.filter(x -> x.endsWith(".") || x.endsWith(",")).count();
    }
}
