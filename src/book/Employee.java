package book;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

public class Employee
{
    private static int nextId;

    private int id;
    private String name = "";
    private double salary;
    private Date hireDay;

    // Stattic BI+    static
    {
        Random generator = new Random();
        nextId = generator.nextInt(10000);
    }

    // Блок инициализации
    {
        id = nextId;
        nextId++;
    }

    public Employee() {

    }

    public Employee(String n, double s, int y, int m, int d) {
        name = n;
        salary = s;
        GregorianCalendar calendar = new GregorianCalendar(y, m - 1, d);
        hireDay = calendar.getTime();
    }

    public Employee(double s) {
        // Вызов другого конструктора этого же класса
        this("Employee " + nextId, s);
        nextId++;
    }

    public Employee (String n, double s) {
        /* some code */
    }

    public String getName()
    {
        return name;
    }

    public Date getHireDay()
    {
        return (Date) hireDay.clone();
    }

    public static int getNextId()
    {
        return nextId;
    }

    public static void main(String[] args) {
        // Блочный тест.
        Employee e = new Employee("Romea", 5000, 2003,3,31);
        System.out.println(Employee.getNextId());
    }
}
