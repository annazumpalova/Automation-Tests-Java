package Task1And2;

public class Person {
    private String name;
    private int age;
    private double salary;

    final int youngerAge = 30;

    public Person(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    public Person(String name, int age, double salary) {
        this(name, age);
        this.setSalary(salary);
    }

    private void setName(String pName) {
        if (pName != null && !pName.isEmpty()) {
            this.name = pName;
        }
    }

    private void setAge(int pAge) {
        if (pAge > 0 && pAge != 0) {
            this.age = pAge;
        }
    }

    private void setSalary(double pSalary) {
        if (pSalary > 0 && pSalary != 0) {
            this.salary = pSalary;
        }
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public double getSalary() {
        return this.salary;
    }

    public double increaseSalary(double percentage) {
        double bonus;
        if (this.getAge() < youngerAge) {
            bonus = this.getSalary() * ((percentage / 2) / 100);
        } else {
            bonus = this.getSalary() * (percentage / 100);
        }
        return bonus;
    }

    @Override
    public String toString() {
        return "TaskTwo.Task1.Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
