package book.lab;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

public class TechnicalLead extends TechnicalEmployee
{
    private ArrayList<SoftwareEngineer> reports = new ArrayList<SoftwareEngineer>();
    private int headCount;
    //private BusinessLead financeManager;
    //protected static final int maxHeadCount = 4;

    public TechnicalLead(String name)
    {
        super(name);
        this.setSalary(getBaseSalary() * 1.3);
        headCount = 4;
    }

    public boolean hasHeadCount()
    {
        if(headCount > 0)
            return true;
        else
            return false;
    }

    public boolean addReport(SoftwareEngineer e)
    {
        if(headCount > 0)
        {
            reports.add(e);
            headCount--;
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean approveCheckIn(SoftwareEngineer e)
    {
        if(reports.contains(e) && e.getCodeAccess())
            return true;
        else
            return false;
    }

    public int getEngineersManagingAmount()
    {
        return reports.size();
    }

    // TODO: implement
    public boolean requestBonus(Employee e, double bonus)
    {
        BusinessLead bl = (BusinessLead) this.getManager();
        boolean approved = bl.requestBonus(this, bonus);
        if(approved)
            return true;
        else
            return false;
    }

    public String getTeamStatus()
    {
        if(reports.size() > 0)
        {
            String res = super.employeeStatus() + " (TL) and is managing:\n";
            for (SoftwareEngineer e : reports)
                res += e.employeeStatus() + "\n";
            return res;
        }
        else
            return super.employeeStatus() + " and no direct reports\n";
    }
}
