import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) {
    List<Person> people = getPeople();

    // Imperative approach ❌

    /*

    List<Person> females = new ArrayList<>();

    for (Person person : people) {

      if (person.getGender().equals(Gender.FEMALE)) {
        females.add(person);
      }
    }

    females.forEach(System.out::println);

    */

    // Declarative approach ✅

    // Filter
    List<Person> females = people.stream()
        .filter(person -> person.getGender().equals(Gender.FEMALE))
        .collect(Collectors.toList());

//    females.forEach(System.out::println);

    // Sort
    List<Person> sorted = people.stream()
        .sorted(Comparator.comparing(Person::getAge) //First compare age
                .thenComparing(Person::getGender) //Second compare gender
                .reversed()) //Sorted reversed
        .collect(Collectors.toList());

//    sorted.forEach(System.out::println);

    // All match
    boolean allMatch = people.stream()
        .allMatch(person -> person.getAge() > 8); //Every people, age>8

//    System.out.println(allMatch);
    // Any match
    boolean anyMatch = people.stream()
        .anyMatch(person -> person.getAge() > 121); //Every people, age >121

//    System.out.println(anyMatch);
    // None match
    boolean noneMatch = people.stream()
        .noneMatch(person -> person.getName().equals("Antonio")); //No name equals Antonio

//    System.out.println(noneMatch);

    // Max
    people.stream()
        .max(Comparator.comparing(Person::getAge))
        .ifPresent(System.out::println);//if there is a max, print it

    // Min
    people.stream()
        .min(Comparator.comparing(Person::getAge))
        .ifPresent(System.out::println);//if there is a min, print it

    // Group
    Map<Gender, List<Person>> groupByGender = people.stream()
        .collect(Collectors.groupingBy(Person::getGender));
    //Now we print every group and the list with people that match
    groupByGender.forEach((gender, people1) -> {
     System.out.println(gender);
     people1.forEach(System.out::println);
     System.out.println();
    });
    //the output is:
    /*FEMALE
    Person{name='Alina Smith', age=33, gender=FEMALE}
    Person{name='Helen White', age=57, gender=FEMALE}
    Person{name='Anna Cook', age=7, gender=FEMALE}
    Person{name='Zelda Brown', age=120, gender=FEMALE}

    MALE
    Person{name='Antonio', age=20, gender=MALE}
    Person{name='Alex Boz', age=14, gender=MALE}
    Person{name='Jamie Goa', age=99, gender=MALE}
    */


  }

  private static List<Person> getPeople() {
    return List.of(
        new Person("Antonio", 20, Gender.MALE),
        new Person("Alina Smith", 33, Gender.FEMALE),
        new Person("Helen White", 57, Gender.FEMALE),
        new Person("Alex Boz", 14, Gender.MALE),
        new Person("Jamie Goa", 99, Gender.MALE),
        new Person("Anna Cook", 7, Gender.FEMALE),
        new Person("Zelda Brown", 120, Gender.FEMALE)
    );
  }

}
