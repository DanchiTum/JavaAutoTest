package task5;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
//Serialization-Deserialization:
//a) Make some complex models using your variant.
//b) Make it serializable.
//c) Read JSON from “input.json”
//d) and deserialize it to POJO.
//e) Then change a few fields and save it to “output.json”.
//f) Do the same for XML.
//
//Stream:
//a) Generate 10 random objects using a class from a previous task
//b) Sort it using any two fields using stream.
//c) Filter it by any two fields custom filter.
//d) Collect it to List with *main field(s).
//
//Write a maven command for executing one of your tasks with arguments (number of elements).
//{
//  "name": "Jane",
//  "age": 27,
//  "address": {
//    "street": "456 Elm St",
//    "city": "Portland",
//    "state": "OR"
//  }
//}
//<person>
//  <name>Jane</name>
//  <age>27</age>
//  <address>
//    <street>456 Elm St</street>
//    <city>Portland</city>
//    <state>OR</state>
//  </address>
//</person>
public class Main {
    public static void main(String[] args) {
        int count = (args.length > 0) ? Integer.parseInt(args[0]) : 10;
        List<Person> people = generateRandomPeople(count);
        System.out.println("Generated People:");
        people.forEach(p -> System.out.println(p.getName() + " - " + p.getAge() + " - " + p.getAddress().getCity()));

        List<Person> sorted = people.stream()
                .sorted(Comparator.comparing(Person::getAge)
                        .thenComparing(Person::getName))
                .collect(Collectors.toList());
        System.out.println("Sorted People:");
        sorted.forEach(p -> System.out.println(p.getAge() + " - " + p.getName()));

        List<Person> filtered = sorted.stream()
                .filter(p -> p.getAge() > 25)
                .filter(p -> "Seattle".equals(p.getAddress().getCity()))
                .collect(Collectors.toList());
        System.out.println("Filtered People(25 & Seattle):");
        filtered.forEach(p -> System.out.println(p.getName() + " - " + p.getAge()));

        List<String> collected = filtered.stream()
                .map(p -> p.getName() + " (" + p.getAge() + ")")
                .collect(Collectors.toList());

        System.out.println("Collected main fields:");
        collected.forEach(System.out::println);
        if (!people.isEmpty()) {
            process(new ObjectMapper(), people.get(0), "output.json");
            process(new XmlMapper(), people.get(0), "output.xml");
        }
    }
    private static List<Person> generateRandomPeople(int count) {
        Random rand = new Random();
        String[] names = {"Danyl", "Bogdan", "Max", "Victoria", "Mari", "Jane", "Gigachad", "Sofi", "Ivan", "Khristina"};
        String[] cities = {"Seattle", "Dolyna", "Lviv", "Ivano-Frankivsk", "Kyiv"};
        String[] states = {"AB", "BC", "CD", "DE", "EF"};
        String[] streets = {"15 Independence st.", "10 Gazova st.", "1 Zamarstynivska st.", "2 Khreshchatyk st.", "456 Elm St"};
        return IntStream.range(0, count)
                .mapToObj(i -> {
                    Person p = new Person();
                    p.setName(names[rand.nextInt(names.length)]);
                    p.setAge(rand.nextInt(50) + 18); // від 18 до 67 років

                    Address addr = new Address();
                    addr.setCity(cities[rand.nextInt(cities.length)]);
                    addr.setState(states[rand.nextInt(states.length)]);
                    addr.setStreet(streets[rand.nextInt(streets.length)]);
                    p.setAddress(addr);

                    return p;
                }).collect(Collectors.toList());
    }
    private static void process(ObjectMapper mapper, Person person, String outFilename) {
        try {
            File outFile = new File(outFilename);
            mapper.writerWithDefaultPrettyPrinter().writeValue(outFile, person);
            String type = (mapper instanceof XmlMapper) ? "XML" : "JSON";
            System.out.println(type + " written to: " + outFile.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
