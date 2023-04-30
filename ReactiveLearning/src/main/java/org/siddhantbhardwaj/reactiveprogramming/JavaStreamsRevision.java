package org.siddhantbhardwaj.reactiveprogramming;

public class JavaStreamsRevision {

    public static void main(String[] args){

        // Print all numbers in the intNumbersStream stream
        StreamSources.intNumbersStream().forEach(i -> System.out.println(i));

        // Print numbers from intNumbersStream that are less than 5
        StreamSources.intNumbersStream().filter(i -> i < 5).forEach(i -> System.out.println(i));

        // Print the second and third numbers in intNumbersStream that's greater than 5
        StreamSources.intNumbersStream().filter(i -> i > 5).skip(1).limit(2).forEach(integer -> System.out.println(integer));

        //  Print the first number in intNumbersStream that's greater than 5.
        StreamSources.intNumbersStream().filter(i -> i > 5).limit(1).findAny()
                .ifPresentOrElse(i -> System.out.println(i),() -> System.out.println("-1"));

        // Print first names of all users in userStream
        StreamSources.userStream().forEach(user -> System.out.println(user.getFirstName()));

        // Print first names in userStream for users that have IDs from number stream
        StreamSources.intNumbersStream()
                .flatMap(i -> StreamSources.userStream().filter(user -> user.getId() == i))
                .map(user -> user.getFirstName())
                .forEach(name -> System.out.println(name));

        StreamSources.userStream()
                .filter(user -> StreamSources.intNumbersStream().anyMatch(i -> i == user.getId()))
                .map(user -> user.getFirstName())
                .forEach(user -> System.out.println(user));
    }

}
