package book.lab;

public abstract class Employee
{
    private int id;
    private String name;
    private double salary;
    private String status;
    private Employee manager;

    public static int amountOfEmp = 0;
    public static int nextID = 1;

    public Employee(String name, double baseSalary)
    {
        this.id = nextID;
        this.name = name;
        this.salary = baseSalary;

        nextID++;
        amountOfEmp++;
    }

    public int getEmployeeID()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public double getBaseSalary()
    {
        return salary;
    }

    public String employeeStatus()
    {
        return status;
    }

    public Employee getManager()
    {
        return manager;
    }

    public void setManager(Employee manager)
    {
        this.manager = manager;
    }

    public double setSalary(double newSalary)
    {
        salary = newSalary;
        return salary;
    }

    @Override
    public String toString()
    {
        return(this.id + " " + this.name);
    }

    public boolean equals(Employee obj)
    {
        return this.id == obj.id;
    }
}
