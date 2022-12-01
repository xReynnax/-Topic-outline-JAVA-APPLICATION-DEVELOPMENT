package lv.tsi.lamda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ListProcessingWithStreams {
    public static <T> T getFirstElementInStream(Stream<T> stream) {
        return stream
                .findFirst()
                .orElse(null);
    }
    public static void main(String[] args) {
        {
            // Get the stream
            Stream<String> stream = Stream.of("a1", "c3", "a2", "a3","b3", "b2", "c1", "c2","b1");
            System.out.println(
                    "First Element: "
                            + getFirstElementInStream(stream));

            List<String> arr = Arrays.asList("a1", "c3", "a2", "a3","b3", "b2", "c1", "c2","b1");
            arr.stream().map(String::toUpperCase)
                    .forEach(name -> System.out.print(name + " "));
            System.out.println("\t");
            arr.stream().filter(str -> str.startsWith("b"))
                    .forEach(str -> System.out.print(str + " "));
            System.out.println("\t");
            arr.stream().filter(s -> s.startsWith("c"))
                    .map(String::toUpperCase)
                    .sorted()
                    .forEach(s -> System.out.print(s + " "));


        }
    }
}
