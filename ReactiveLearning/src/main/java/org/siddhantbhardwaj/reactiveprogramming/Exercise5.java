package org.siddhantbhardwaj.reactiveprogramming;
import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;

import java.io.IOException;

public class Exercise5 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

        // Subscribe to a flux using the error and completion hooks
        ReactiveSources.userFlux().subscribe(
                user -> System.out.println(user.toString()),
                (err -> System.out.println(err.getMessage())),
                () -> System.out.println("User complete event")
        );

        // Subscribe to a flux using an implementation of BaseSubscriber
        ReactiveSources.intNumbersFlux().subscribe(new MySubscribe<>());

        System.out.println("Press a key to end");
        System.in.read();
    }

}


class MySubscribe<T> extends BaseSubscriber<T>{

    public void hookOnSubscribe(Subscription subscription){
        System.out.println("Subscribe happened");
        request(2);
    }

    public void hookOnNext(T value){
        System.out.println(value.toString() + " received");
    }

}