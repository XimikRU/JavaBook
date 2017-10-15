package book.samples;

public class staticInnerClass
{
    public static class Pair
    {
        private double first;
        private double second;

        public Pair(double f, double s)
        {
            first = f;
            second = s;
        }

        public double getFirst()
        {
            return first;
        }

        public double getSecond()
        {
            return second;
        }
    }

    public static Pair minmax(double[] values)
    {
        double min = Double.MIN_VALUE;
        double max = Double.MAX_VALUE;

        for(double v : values)
        {
            if(min > v) min = v;
            if(max < v) max = v;
        }

        return new Pair(min, max);
    }

    public static void logic()
    {
        double d[] = new double[100];
        for (int i = 0; i < d.length; i++)
            d[i] = 100 * Math.random();
        staticInnerClass.Pair p = staticInnerClass.minmax(d);
        System.out.println("Min = " + p.first);
        System.out.println("Max = " + p.second);
    }
}
