package book.samples;

import book.Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class talkingClockLocalClasses
{
    private int interval;
    private boolean beep;

    public talkingClockLocalClasses(int interval, boolean beep)
    {
        this.interval = interval;
        this.beep = beep;
    }

    public void startTimer()
    {
        ActionListener listener = new TimePrinter();
        Timer t = new Timer(interval, listener);
        t.start();
    }

    // Локальный класс
    public void localClassLogic(int interval, final boolean beep)
    {
        // доступен только в logicCL()
        class LocalTimerPrinter implements ActionListener
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Date now = new Date();
                System.out.println("now  = " + now);
                // Получен доступ к локальной перемнной 'beep'
                if (beep) Toolkit.getDefaultToolkit().beep();
            }
        }

        ActionListener listener = new LocalTimerPrinter();
        Timer t = new Timer(interval, listener);
        t.start();

        /*
        Если (FINAL var) - нужна как изменяемая, то можно сделать массив из 1 элмнт
            final int[] var = new int[1];
            var[0]++;
        Тогда массив нельзя будет заставить ссылаться на другой.
         */
    }

    // Анонимынй класс / интерфейс
    public void anonClassLogic(final String adress, final int interval, final boolean beep)
    {
        // Объект внтр. класса, расширяющий класс Employee (dnt work)
        Employee rock = new Employee("ROCK", 42152, 1990, 3, 23)
        {
            private String Adress;

            public void addAdress(String adress)
            {
                adress += " // Adress";
                this.Adress = adress;
            }

            public String getAdress()
            {
                return Adress;
            }
        };

        // Или интерфейс
        ActionListener listener = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Date now = new Date();
                System.out.println("now + " + now);
                if (beep) Toolkit.getDefaultToolkit().beep();
            }
        };
        new Timer(interval, listener).start();

        // Базовый пример
        Employee exp = new Employee()
        {
            void someMethod()
            {
                System.out.println("Method");
            }
        };

        // Базовое применение анон классов
        new Thread(new Runnable(){
            public void run()
            {
                System.out.println("Anon");
            }
        }).start();
    }

    // Внутренний класс
    public class TimePrinter implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            Date now = new Date();
            System.out.println("Now = " + now);
            if (talkingClockLocalClasses.this.beep) Toolkit.getDefaultToolkit().beep(); // или (beep)
        }

        // Если ссылка на внутр. класс делается за пределами внешнего класса, to:
        /*
        talkingClockLocalClasses jagger = new talkingClockLocalClasses(5000, true);
        talkingClockLocalClasses.TimePrinter listener = jagger.new TimePrinter();
        */
    }


}
