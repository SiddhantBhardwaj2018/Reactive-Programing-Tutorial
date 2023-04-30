package org.siddhantbhardwaj.reactiveprogramming;

import java.io.IOException;

public class ReactiveStreamsExercise1 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux() and ReactiveSources.userFlux()

        // Print all numbers in the ReactiveSources.intNumbersFlux stream
        ReactiveSources.intNumbersFlux().subscribe(e -> System.out.println(e), err -> System.out.println(err.getMessage()),
                () -> System.out.println("completed event"));


        // Print all users in the ReactiveSources.userFlux stream
        ReactiveSources.userFlux().subscribe(e -> System.out.println(e));

        System.out.println("Press a key to end");
        System.in.read();
    }

}
