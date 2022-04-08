import java.util.Scanner;

public class EasyScanner
{
	/** wrapper for using scanner to retrieve integer user input
	 *  This now includes user input validation to ensure user only inputs integer
	 * @return the integer the user inputted
     */
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
	
	/** wrapper for using scanner to retrieve string user input
	 * @return the string the user inputted
     */
	public static String nextString()
	{
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		return s;
	}
}
