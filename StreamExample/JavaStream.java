package streamexample;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import Common.Employee;

//https://stackify.com/streams-guide-java-8/

public class JavaStream {
        public static void main(String[] args) {

                JavaStream js = new JavaStream();
                // TODO Auto-generated method stub
                Stream<String> strstm = Stream.of("wer", "er", "ert", "dss");
                Stream<Integer> intstm = Stream.of(1, 2, 3, 4, 5);

                // ForEach
                // strstm.forEach(System.out::println);
                // intstm.forEach(t -> System.out.println(t));
                // intstm.map(i -> i *2).forEach(t -> System.out.println(t));
                // intstm.filter(i -> i % 2 == 0).forEach(t -> System.out.println(t));
                // intstm.sorted().forEach(t -> System.out.println(t));
                // intstm.sorted((i1,i2) -> i1 - i2).forEach(t -> System.out.println(t));
                // intstm.map(i -> i *2).collect(Collectors.toList()).forEach(t ->
                // System.out.println(t));

                // intstm.map(i -> i *2).filter(l -> l % 2
                // ==0).collect(Collectors.toList()).forEach(t -> System.out.println(t));
                // intstm.map(i -> i *2).filter(l -> l % 2 ==0).findFirst().ifPresent(t ->
                // System.out.println(t));
                // int first = intstm.map(i -> i *2).filter(l -> l % 2
                // ==0).findFirst().orElse(0);
                // System.out.println(first);
                // intstm.map(i -> i * 2).filter(l -> l % 2 == 0).toArray(g -> new Integer[g]);
                // intstm.map(i -> i *2).filter(l -> l % 2 ==0).toArray(Integer[]::new);

                // List<List<String>> list = new ArrayList<>();
                List<List<Object>> list = Arrays.asList(
                                Arrays.asList("a1", "a2"),
                                Arrays.asList(1, 3),
                                Arrays.asList("c1", "c2"));
                // list.stream().flatMap(l -> l.stream()).forEach(System.out::println);
                list.stream().flatMap(Collection::stream).forEach(System.out::println);

                Employee[] employees = new Employee[] {
                                new Employee(1, "Pom", "Smith", 5000),
                                new Employee(2, "Tom", "Doe", 10000),
                                new Employee(3, "Jpok", "Doe", 7000)
                };
                // Stream.of(employees).peek(e -> e.setBonus(200)).peek(action ->
                // System.out.println(action)).forEach(System.out::println);
                // Stream.of(employees).forEach(e -> {e.setBonus(200);System.out.println(e);});

                Stream.of(employees).sorted((e1, e2) -> e1.getName().compareTo(e2.getName()))
                                .collect(Collectors.toList())
                                .forEach(System.out::println);

                List<Employee> empList = Arrays.asList(employees);
                Employee emp = empList.stream().min((e1, e2) -> e1.getSalary() - e2.getSalary()).orElse(null);
                System.out.println(emp);
                empList.stream().min((e1, e2) -> e1.getSalary() - e2.getSalary()).orElse(null).setBonus(210);
                Employee emp1 = empList.stream().min((e1, e2) -> e1.getSalary() - e2.getSalary())
                                .orElseThrow(NoSuchElementException::new);
                System.out.println(emp1);

                List<Integer> intList = Arrays.asList(2, 5, 3, 2, 4, 3);
                List<Integer> distinctIntList = intList.stream().distinct().collect(Collectors.toList());

                List<Integer> intList1 = Arrays.asList(2, 4, 5, 6, 8);

                boolean allEven = intList1.stream().allMatch(i -> i % 2 == 0);
                boolean oneEven = intList1.stream().anyMatch(i -> i % 2 == 0);
                boolean noneMultipleOfThree = intList1.stream().noneMatch(i -> i % 3 == 0);

                Integer latestEmpId = empList.stream()
                                .mapToInt(Employee::getId)
                                .max()
                                .orElseThrow(NoSuchElementException::new);
                System.out.println(latestEmpId);

                /**
                 * reduce
                 * 
                 * The most common form of reduce() is:
                 * 
                 * T reduce(T identity, BinaryOperator<T> accumulator)
                 */

                Integer sumSal = empList.stream()
                                .map(Employee::getSalary)
                                .reduce(0, Integer::sum);

                System.out.println(sumSal);

                System.out.println(intstm.reduce(0, (i1, i2) -> i1 + i2));

                String empNames = empList.stream()
                                .map(Employee::getName)
                                .collect(Collectors.joining(", "))
                                .toString();

                System.out.println(empNames);

                // partitioningBy
                List<Integer> intList2 = Arrays.asList(2, 4, 5, 6, 8);
                Map<Boolean, List<Integer>> isEven = intList2.stream().collect(
                                Collectors.partitioningBy(i -> i % 2 == 0));

                System.out.println(isEven.get(true));
                System.out.println(isEven.get(false));

                // groupingBy

                Map<Character, List<Employee>> groupByAlphabet = empList.stream().collect(
                                Collectors.groupingBy(e -> Character.valueOf(e.getName().charAt(0))));

                System.out.println(groupByAlphabet.get('J').get(0).getName());

                Map<Character, List<Integer>> idGroupedByAlphabet = empList.stream().collect(
                                Collectors.groupingBy(e -> Character.valueOf(e.getName().charAt(0)),
                                                Collectors.mapping(Employee::getId, Collectors.toList())));

                System.out.println(idGroupedByAlphabet.get('J').get(0));

                String key = "";
                Map<String, String> container = new HashMap<>();
                Map<String, String> result = new HashMap<>();
                container.entrySet()
                                .stream()
                                .filter(entry -> entry.getKey().equals(key))
                                .forEach(entry -> result.put(entry.getKey(), entry.getValue()));

                List<Staff> staff = Arrays.asList(
                                js.new Staff("mkyong", 30, new BigDecimal(10000)),
                                js.new Staff("jack", 27, new BigDecimal(20000)),
                                js.new Staff("lawrence", 33, new BigDecimal(30000)));

                // convert inside the map() method directly.
                List<StaffPublic> result2 = staff.stream().map(temp -> {
                        StaffPublic obj = js.new StaffPublic();
                        obj.setName(temp.getName());
                        obj.setAge(temp.getAge());
                        if ("mkyong".equals(temp.getName())) {
                                obj.setExtra("this field is for mkyong only!");
                        }
                        return obj;
                }).collect(Collectors.toList());

                System.out.println(result2);

        }

        public class Citi{
                String name;
                
        }

        public class StaffPublic {

                private String name;
                private int age;
                private String extra;

                public StaffPublic() {

                }

                // ...
                public StaffPublic(String name, int age, String extra) {
                        this.name = name;
                        this.age = age;
                        this.extra = extra;
                }

                public String getName() {
                        return name;
                }

                public void setName(String name) {
                        this.name = name;
                }

                public int getAge() {
                        return age;
                }

                public void setAge(int age) {
                        this.age = age;
                }

                public String getExtra() {
                        return extra;
                }

                public void setExtra(String extra) {
                        this.extra = extra;
                }
        }

        public class Staff {

                private String name;
                private int age;
                private BigDecimal salary;

                // ...
                public Staff(String name, int age, BigDecimal salary) {
                        this.name = name;
                        this.age = age;
                        this.salary = salary;
                }

                public String getName() {
                        return name;
                }

                public void setName(String name) {
                        this.name = name;
                }

                public int getAge() {
                        return age;
                }

                public void setAge(int age) {
                        this.age = age;
                }

                public BigDecimal getSalary() {
                        return salary;
                }

                public void setSalary(BigDecimal salary) {
                        this.salary = salary;
                }
        }
}
