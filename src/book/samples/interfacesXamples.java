// 280 - ...
package book.samples;

import book.*;

public class interfacesXamples
{
    public interface Moveable
    {
        void move(double x, double y);
    }

    public interface Powered extends Moveable
    {
        double someCode();
        double LIMIT = 100; // ~ public static final
    }

    public static void logicClone()
    {
        try
        {
            Employee orig = new Employee("Johny", 50000, 1990,3,5);
            Employee copy = orig.clone();
            copy.raiseSalary(100);
            System.out.println("orig = " + orig.getSalary());
            System.out.println("copy = " + copy.getSalary());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
