import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TextFileTesterVersion2
{
	public static void main(String[] args)
	{
		char choice;
		List<Car> carList = new ArrayList<>();

		System.out.print("How many cars? ");             
		int numberOfCars = EasyScanner.nextInt();

		int counter = 1;

		// menu options
		// for ( int i = 0; i <= numberOfCars; i++); {
			do
			{
				counter++;
				System.out.println("1. Add a car");
				System.out.println("4. Quit\n");
				choice = EasyScanner.nextChar();
				System.out.println(); switch(choice)
				{
					case '1' :	addCar(carList);
								break;
					case '4' :	writeList(carList); // write to the file
								break;
					default : System.out.print("\nPlease choose a number from 1 - 4 only\n ");
				}
			}while(choice != '4' && counter <= numberOfCars);
		// }
	
		/* 
		Get the information about each car from the user. You can use a for loop that 
		iterates the number of times that the user has specified for the number of cars
		to be entered. Look at the addCar method of the original TextFileTester to help 
		you
		*/

		writeList(carList);
    }
        
	// method for writing the file
	static void writeList(List<Car> carListIn)
	{
		// Rewrite the original method of TextFileTester to produce the output shown above 
		// use try-with-resources to ensure file is closed safely
		try(
				/* create a FileWriter object, carFile, that handles the low-level details of writing 
              the list to a file which we have called "Cars.txt" */
			    FileWriter carFile = new FileWriter("Cars.txt");
			    /* now create a PrintWriter object to wrap around carFile; this allows us to user 
              high-level functions such as println */
			    PrintWriter carWriter = new PrintWriter(carFile);
		   )
		{	
			// write each element of the list to the file 
			for(Car item : carListIn)
			{
			   carWriter.printf("Registration Number: %s %n", item.getRegistration());
			   carWriter.println("Make: " + item.getMake());
			   carWriter.println("Price: £" + item.getPrice()); // println can accept a double, and write it as a string
			   carWriter.println("");
		   }
		}
		// handle the exception thrown by the FileWriter methods
		catch(IOException e)
		{
			System.out.println("There was a problem writing the file");
		}
	}
	
	// method for adding a new car to the list
	static void addCar(List<Car> carListIn)
	{
		String tempReg;
		String tempMake;
		double tempPrice;
		
		System.out.print("Please enter the registration number: ");
		tempReg = EasyScanner.nextString();
		System.out.print("Please enter the make: ");
		tempMake = EasyScanner.nextString();
		System.out.print("Please enter the price: ");
		tempPrice = EasyScanner.nextDouble();
		carListIn.add(new Car(tempReg, tempMake, tempPrice));
	}
}
