package org.siddhantbhardwaj.reactiveprogramming;
import java.io.IOException;
import java.util.Optional;

public class Exercise4 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono()

        // Print the value from intNumberMono when it emits
        ReactiveSources.intNumberMono().subscribe(e -> System.out.println(e),
                err -> System.out.println(err.toString()),
                () -> System.out.println("Completed event"));

        // Get the value from the Mono into an integer variable
        Integer mono = ReactiveSources.intNumberMono().block();
        Optional<Integer> monoOptional = ReactiveSources.intNumberMono().blockOptional();

        System.out.println("Press a key to end");
        System.in.read();
    }

}
