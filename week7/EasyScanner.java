import  java.util.Scanner;

public class EasyScanner
{
    public static int nextInt()
    {
        Scanner keyboard = new Scanner(System.in);
        int i = keyboard.nextInt();
        keyboard.close();
        return i;
    }

    public static double nextDouble()
    {
        Scanner keyboard = new Scanner(System.in);
        double d = keyboard.nextDouble();
        keyboard.close();
        return d;
    }

    public static String nextString()
    {
        Scanner keyboard = new Scanner(System.in);
        String s = keyboard.nextLine();
        keyboard.close();
        return s;
    }

    public static char nextChar()
    {
        Scanner keyboard = new Scanner(System.in);
        char c = keyboard.next().charAt(0);
        keyboard.close();
        return c;
    }
}
