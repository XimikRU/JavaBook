package book;

import book.samples.interfacesXamples;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

public class Employee implements interfacesXamples.Moveable, Cloneable
{
    private static int nextId;

    private int id;
    private String name = "";
    private double salary;
    private Date hireDay;



    // Static
    {
        Random generator = new Random();
        nextId = generator.nextInt(10000);
    }

    // Блок инициализации
    {
        id = nextId;
        nextId++;
    }



    public Employee() { }

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



    public Employee clone() throws CloneNotSupportedException {
        // obj.clone()
        Employee cloned = (Employee) super.clone();

        // Изменяемые поля
        cloned.hireDay = (Date) hireDay.clone();

        return cloned;
    }

    public void move(double from, double to) {
        /* some code */
    }



    public Double getSalary() {return salary; }

    public String getName()
    {
        return name;
    }

    public Date getHireDay()
    {
        return (Date) hireDay.clone();
    }

    public void raiseSalary(double add) {
        salary += add;
    }

    public static int getNextId()
    {
        return nextId;
    }



    public static void logic(String[] args) {
        Employee e = new Employee("Romea", 5000, 2003,3,31);
        System.out.println(Employee.getNextId());
    }
}
