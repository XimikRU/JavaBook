package book.lab;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class SoftwareEngineer extends TechnicalEmployee
{
    private boolean codeAccess;

    public SoftwareEngineer(String name)
    {
        super(name);
        this.setCheckIns(0);
        codeAccess = false;
    }

    public boolean getCodeAccess()
    {
        return codeAccess;
    }

    public void setCodeAccess(boolean codeAccess)
    {
        this.codeAccess = codeAccess;
    }

    public int getSuccessfulCheckIns()
    {
        return this.getCheckIns();
    }

    public boolean checkInCode()
    {
        TechnicalLead tl = (TechnicalLead)this.getManager();
        boolean approved = tl.approveCheckIn(this);
        if(approved)
        {
            this.incrementCheckIns();
            return true;
        }
        else
        {
            this.setCodeAccess(false);
            return false;
        }
    }

}
