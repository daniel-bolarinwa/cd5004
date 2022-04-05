import java.util.Scanner;

public class EasyScanner
{
	public static int nextInt()
	{
		
		Scanner sc = new Scanner(System.in);

		while (!sc.hasNextInt()) {
			System.out.println("That is not an integer! Please try again entering a valid integer");
			sc.next();
		}
		int i = sc.nextInt();
		return i;
	}
	
	public static String nextString()
	{
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		return s;
	}
}
