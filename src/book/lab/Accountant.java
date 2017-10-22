package book.lab;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Accountant extends BusinessEmployee
{
    private TechnicalLead tlTeamSupport;
    //private BusinessLead Manager;

    public Accountant(String name)
    {
        super(name);
        this.setBonusBudget(0);
    }

    public TechnicalLead getTLTeamSupport()
    {
        return tlTeamSupport;
    }

    public void supportTeam(TechnicalLead lead)
    {
        tlTeamSupport = lead;
        double newBonus = lead.getEngineersManagingAmount() * 75000;
        double percent = newBonus * 0.1;
        newBonus = newBonus + percent;
        this.setBonusBudget(newBonus);
    }

    public boolean approveBonus(double bonus)
    {
        if(tlTeamSupport == null)
            return false;

        if(getBonusBudget() - bonus < 0)
            return false;
        else
            return true;
    }

    @Override
    public String employeeStatus()
    {
        return (super.employeeStatus() + " is supporting " + tlTeamSupport.getName());
    }
}
