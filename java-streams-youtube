# Java Streams API
https://amigoscode.com/p/java-streams
![cover](https://user-images.githubusercontent.com/40702606/137604079-5a73276f-a32a-4f03-adca-752f9a01adc2.png)

# Course Description
Functional programming is becoming very popular and it focuses around pure functions. Functional applications avoid the shared state, and tend to be more concise and predictable than those using object-oriented code. In this course Nelson will teach you how to move away from imperative to declarative programming allowing you to write less code and focus on what is important when build applications.

## List of topics for this course
- What is functional programming
- Stream API
- Transformations with Map
- Reduce
- Filter
- Collectors
- Statistics
- Grouping
- Parallel steams
- Exercises


**Estructura:**

-Beans: models we use, Cars, Person and PersonDTO
-mockData: list of list of Person and Car, from dir **resources**.
-resources: we found cars.json and people.json
-examples: examples of streams over resources jsons


# Functional Programming with Java Streams API
**Course Java-Streams , amigosCode youtube**
https://www.youtube.com/watch?v=f5j1TaJlc0w&ab_channel=Amigoscode
>Java Streams API

**IMPERATIVE TO FUNCTIONAL PROGRAMMING**

>How to use Java Streams

1-Start with a collection:
-arrays, set, lists, maps
2-list.stream(), collection.stream(), and we can call methods as: filter, map, reduce, etc, these are **Intermediate Operators**
3-After filter, map, reduce, etc we must **Back to concrete**: a list, int, object, optional,string, **and any other data type**, there are methods available as: sum(), collect(Collectors.toList()), average(), collect(Collectors.groupingBy()) and so forth. These methods are called to back to a concrete class or type, **they are terminal operators** ,they end the stream.

>Map and FlatMap, transform a type to another type

>Filter
```
    List<Person> females = people.stream()
        .filter(person -> person.getGender().equals(Gender.FEMALE))
        .collect(Collectors.toList());
```
> Sort
```
    List<Person> sorted = people.stream()
        .sorted(Comparator.comparing(Person::getAge) //First compare age
                .thenComparing(Person::getGender) //Second compare gender
                .reversed()) //Sorted reversed
        .collect(Collectors.toList());
 ```
  >All match
```
 boolean allMatch = people.stream()
        .allMatch(person -> person.getAge() > 8); //Every people, age>8
```
 >Any match
 ```
    boolean anyMatch = people.stream()
        .anyMatch(person -> person.getAge() > 121); //Every people, age >121
   ```
>None match
```
    boolean noneMatch = people.stream()
        .noneMatch(person -> person.getName().equals("Antonio")); //No name equals Antonio
```
> Max
```
    people.stream()
        .max(Comparator.comparing(Person::getAge))
        .ifPresent(System.out::println);//if there is a max, print it
```

> Min
```

    people.stream()
        .min(Comparator.comparing(Person::getAge))
        .ifPresent(System.out::println);//if there is a min, print it
```

> Group
```
//map of type gender, and then a list of people
    Map<Gender, List<Person>> groupByGender = people.stream()
        .collect(Collectors.groupingBy(Person::getGender));//Group by a field, Gender
        
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
   
```
>Chain streams methods:
    // 1st: find out every single female (filter) +
    // 2nd: find out the oldest female (max) +
    // 3rd: return the first name of the oldest female (map(Person::getName)
```

    Optional<String> oldestFemaleAge = people.stream()
        .filter(person -> person.getGender().equals(Gender.FEMALE)) //1st
        .max(Comparator.comparing(Person::getAge))//2nd
        .map(Person::getName);//3rd

    oldestFemaleAge.ifPresent(System.out::println);
```