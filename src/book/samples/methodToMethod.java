package book.samples;

import book.Employee;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.*;

public class methodToMethod
{
    public static void classTest()
    {
        Employee emp = new Employee("NameSSS",20002,1921,11,24);

        Method m1 = null;
        try {
            m1 = Employee.class.getMethod("getName");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        Method m2 = null;
        try {
            m2 = Employee.class.getMethod("getHireDay");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        try {
            logic(emp, m1);
            logic(emp, m2);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void logic(Employee e, Method f){
        System.out.println(f);
        //Class fReturnType =  f.getReturnType();
        //Object inst = fReturnType.newInstance();
        Object inst = null;
        try {
            inst = f.invoke(e);
        } catch (IllegalAccessException e1) {
            e1.printStackTrace();
        } catch (InvocationTargetException e1) {
            e1.printStackTrace();
        }
        System.out.println(inst);
    }
}
