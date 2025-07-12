package org.example;

public class RecordFeatureDemo {

    public static void main(String[] args) {
        beforeScenario();
        afterScenario();
    }

    private static void beforeScenario() {
        PersonBefore person = new PersonBefore("Alice", 30, "Bangalore");
        System.out.println("Before record:");
        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
        System.out.println("City: " + person.getCity());
        System.out.println("ToString: " + person);
    }

    private static void afterScenario() {
        Person person = new Person("Alice", 30, "Bangalore");
        System.out.println("\nAfter record:");
        System.out.println("Name: " + person.name());
        System.out.println("Age: " + person.age());
        System.out.println("City: " + person.city());
        System.out.println("ToString: " + person);
    }

    // 👎 Traditional POJO class (lots of boilerplate)
    static class PersonBefore {
        private final String name;
        private final int age;
        private final String city;

        public PersonBefore(String name, int age, String city) {
            this.name = name;
            this.age = age;
            this.city = city;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getCity() {
            return city;
        }

        @Override
        public String toString() {
            return "PersonBefore{name='" + name + "', age=" + age + ", city='" + city + "'}";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof PersonBefore)) return false;
            PersonBefore that = (PersonBefore) o;
            return age == that.age &&
                    name.equals(that.name) &&
                    city.equals(that.city);
        }

        @Override
        public int hashCode() {
            return java.util.Objects.hash(name, age, city);
        }
    }

    record Person(String name, int age, String city) {
    }
}
