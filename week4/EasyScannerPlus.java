import java.util.InputMismatchException;
import java.util.Scanner;

public class EasyScannerPlus {
    public static int nextInt() {
        int i = 0; 
        boolean repeat = false;
        Scanner sc = new Scanner(System.in);

        do {
            try {
                i = sc.nextInt();
                return i;
            } catch(InputMismatchException e) {
                System.out.println("You entered wrong data type, try again!");
                sc.nextLine();
                repeat = true;
            }
        }while(repeat == true);
        
        sc.close();
        return i;
    }

    public static double nextDouble() {
        double d = 0; 
        boolean repeat = false;
        Scanner sc = new Scanner(System.in);

        do {
            try {
                d = sc.nextDouble();
                return d;
            } catch(InputMismatchException e) {
                System.out.println("You entered wrong data type, try again!");
                sc.nextLine();
                repeat = true;
            }
        }while(repeat == true);
        
        sc.close();
        return d;
    }

    public static String nextString() {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        return s;
    }

    public static char nextChar() {
        Scanner sc = new Scanner(System.in);
        char c = sc.next().charAt(0);
        sc.close();
        return c;
    }
}
