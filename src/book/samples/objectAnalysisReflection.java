// 256 - ...
package book.samples;

import book.Employee;

import java.lang.reflect.*;

public class objectAnalysisReflection
{
    public void logic()
    {
        Employee harry = new Employee("harry",3500,10,1,1989);
        Class cl = harry.getClass();

        Field f = null;
        try {
            f = cl.getDeclaredField("name");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        f.setAccessible(true);
        try {
            Object v = f.get(harry);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    // @Override
    public String toString(Object obj) {
        Class cl = obj.getClass();
        String r = cl.getName();

        do
        {

        }while(cl != null);


        return super.toString();
    }
}
