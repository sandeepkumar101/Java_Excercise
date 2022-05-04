public class Employee {
    private String name;
    private int salary;
    private int bonus;
    private String lastname;
    private int id;

    public Employee(int id,String name, String lastname, int salary) {
        this.name = name;
        this.salary = salary;
        this.lastname = lastname;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }


    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee [bonus=" + bonus + ", id=" + id + ", lastname=" + lastname + ", name=" + name + ", salary="
                + salary + "]";
    }

}
