package book.lab;

import java.util.ArrayList;
import java.util.List;

public class BusinessLead extends BusinessEmployee
{
    private int headCount;
    private ArrayList<Accountant> reports = new ArrayList<Accountant>();

    public BusinessLead(String name)
    {
        super(name);
        this.setSalary(super.getBaseSalary() * 2);
        headCount = 10;
    }

    public boolean hasHeadCount()
    {
        if(headCount > 0)
            return true;
        else
            return false;
    }

    public boolean addReport(Accountant e, TechnicalLead supportTeam)
    {
        if(hasHeadCount())
        {
            reports.add(e);
            headCount--;
            double curBudget = this.getBonusBudget();
            double newBudget = curBudget + e.getBaseSalary() * 1.1;
            this.setBonusBudget(newBudget);
            e.supportTeam(supportTeam);
            return true;
        }
        else
            return false;
    }

    public boolean requestBonus(Employee e, double bonus)
    {
        double curBudget = this.getBonusBudget();
        if(curBudget - bonus > 0)
        {
            double newBudget = curBudget - bonus;
            this.setBonusBudget(newBudget);
            return true;
        }
        else
            return false;
    }

    public boolean approveBonus(Employee e, double bonus)
    {
        for (Accountant ac : reports)
        {
            if(ac.getTLTeamSupport().equals((TechnicalLead)e));
            ac.approveBonus(bonus);
            return true;
        }
        return false;
    }

    public String getTeamStatus()
    {
        if(reports.size() > 0)
        {
            String res = super.employeeStatus() + " (BL) and is managing:\n";
            for (Accountant e : reports)
                res += e.employeeStatus() + "\n";
            return res;
        }
        else
            return super.employeeStatus() + " and no direct reports\n";
    }
}
