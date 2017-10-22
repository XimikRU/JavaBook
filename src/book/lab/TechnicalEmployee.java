package book.lab;

public abstract class TechnicalEmployee extends Employee
{
    private int checkIns;

    public TechnicalEmployee(String name)
    {
        super(name, 75000);
    }

    @Override
    public String employeeStatus()
    {
        return (super.toString() + " has " + checkIns + " successful check ins");
    }

    public int getCheckIns()
    {
        return checkIns;
    }

    protected void setCheckIns(int checkIns)
    {
        this.checkIns = checkIns;
    }

    protected void incrementCheckIns()
    {
        this.checkIns++;
    }
}
