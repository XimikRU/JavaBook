package book.samples;

public class staticSome
{
    public static double cnt = 0;

    public void logic()
    {
        System.out.println(cnt++);
        System.out.println(cnt + "\n");
        cnt = Math.random() * 100;
    }

    public static void staticLogic()
    {
        System.out.println("st: " + cnt);
    }
}
