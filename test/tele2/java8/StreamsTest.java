package tele2.java8;

import lv.tele2.java8.Person;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;


public class StreamsTest {

    private static List<Person> persons = Arrays.asList(new Person("Vasja", 15), new Person("Vasja", 19), new Person("Masha", 24),
            new Person("Anna", 43), new Person("Oleg", 65), new Person("Petja", 30), new Person("Olja", 28));

    @Test
    public void filterPersons() {
        List<Person> overTwenties = persons
                .stream()
                .filter(person -> person.getAge() > 20)
                .collect(Collectors.toList());

        assertEquals(5, overTwenties.size());

        List<Person> threePersonOverTwenties = persons
                .stream()
                .filter(person -> person.getAge() > 20)
                .limit(3)
                .collect(Collectors.toList());
        assertEquals(3, threePersonOverTwenties.size());
    }

    @Test
    public void mapPersons() {
        List<String> names = persons
                .stream()
                .map(Person::getName)
                .collect(Collectors.toList());

        assertEquals(7, names.size());
        assertTrue(names.contains("Oleg"));

        List<String> distinctNames = persons
                .stream().map(Person::getName)
                .distinct()
                .collect(Collectors.toList());

        assertEquals(6, distinctNames.size());
        assertTrue(distinctNames.contains("Vasja"));

    }

    @Test
    public void findFirstPerson() {
        Optional<Person> first = persons
                .stream()
                .filter(person -> person.getAge() > 20 && person.getAge() < 40)
                .findFirst();
        assertTrue(first.isPresent());
        assertEquals("Masha", first.get().getName());
    }


    @Test
    public void reducePersonsAge() {
        Integer sumOfAges = persons.stream().map(Person::getAge).reduce(0, (a, b) -> a + b);

        assertEquals(Integer.valueOf(224), sumOfAges);
    }

    @Test
    public void intStream() {
        IntStream intStream = persons.stream().mapToInt(Person::getAge);
        int sum = intStream.sum();
        assertEquals(224, sum);
    }

}
