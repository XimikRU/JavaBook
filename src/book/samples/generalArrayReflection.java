// 261 - ...
package book.samples;

import book.*;

import java.lang.reflect.*;
import java.util.Arrays;


public class generalArrayReflection
{
    // наращивание массива
    public static Object goodCopyOf(Object a, int newLength)
    {
        Class cl = a.getClass();
        if(!cl.isArray())
            return null;
        Class compType = cl.getComponentType();
        int length = Array.getLength(a);
        Object newArray = Array.newInstance(compType, newLength);
        System.arraycopy(a,0, newArray,0, Math.min(length, newLength));
        return newArray;
    }

    public static void classTest()
    {
        int[] a = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(a));
        a = (int[]) goodCopyOf(a,10);
        System.out.println(Arrays.toString(a));
    }

}
