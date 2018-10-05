package train.main;

import java.util.Arrays;
import java.util.Comparator;

public class SampleCompare {
    public static void main(String[] args) {

        Employee[] employees = {
                new Employee(1, "A"),
                new Employee(2, "B"),
                new Employee(3, "C")
        };

       Arrays.sort(employees, new Employee<>());

    }

    static class Employee<T> implements Comparator<Employee>{
        int id;
        String name;

        public Employee() {
        }

        public Employee(int id, String name) {
            this.id = id;
            this.name = name;
        }


        @Override
        public int compare(Employee o1, Employee o2) {
            return 0;
        }
    }
}
