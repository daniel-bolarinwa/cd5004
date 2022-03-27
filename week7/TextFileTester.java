import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.List;

public class TextFileTester
{
	public static void main(String[] args)
	{
		char choice;

		// create an empty list to hold Cars
		List<Car> carList = new ArrayList<>();

		// read the list from file when the program starts
		readList(carList);

		// menu options
		do
		{
			System.out.println("\nText File Tester");
			System.out.println("1. Add a car");
			System.out.println("2. Remove a car");
			System.out.println("3. List all cars");
			System.out.println("4. Quit\n");
			choice = EasyScanner4.nextChar();
			System.out.println(); switch(choice)
			{
				case '1' :	addCar(carList);
							break;
				case '2' :	removeCar(carList);
							break;
				case '3' :	listAll(carList);
							break;
				case '4' :	writeList(carList); // write to the file
							break;
				default : System.out.print("\nPlease choose a number from 1 - 4 only\n ");
			}
		}while(choice != '4');
	}
	
	// method for adding a new car to the list
	static void addCar(List<Car> carListIn)
	{
		String tempReg;
		String tempMake;
		double tempPrice;
		
		System.out.print("Please enter the registration number: ");
		tempReg = EasyScanner4.nextString();
		System.out.print("Please enter the make: ");
		tempMake = EasyScanner4.nextString();
		System.out.print("Please enter the price: ");
		tempPrice = EasyScanner4.nextDouble();
		carListIn.add(new Car(tempReg, tempMake, tempPrice));
	}
	
	/* method for removing a car from the list - in a real application this would need to include 
      some validation */
	static void removeCar(List<Car> carListIn)
	{
		int pos;
		System.out.print("Enter the position of the car to be removed: ");
		pos = EasyScanner4.nextInt();
		carListIn.remove(pos - 1);
	}
	
	// method for listing details of all cars in the list
	static void listAll(List<Car> carListIn)
	{
		for(Car item : carListIn)
		{
			System.out.println(item.getRegistration()
			+ " "
			+ item.getMake()
			+ " "
			+ item.getPrice());
		}
	}
	
	// method for writing the file
	static void writeList(List<Car> carListIn)
	{
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
			   carWriter.println(item.getRegistration());
			   carWriter.println(item.getMake());
			   carWriter.println(item.getPrice()); // println can accept a double, and write it as a string
		   }
		}
		// handle the exception thrown by the FileWriter methods
		catch(IOException e)
		{
			System.out.println("There was a problem writing the file");
		} 
         
	}
	
	// method for reading the file
	
    static void readList(List<Car> carListIn)
    {
         boolean endOfFile = false;
         Car tempCar;
         
         // use try-with-resources to ensure file is closed safely
         try( 
               // create a FileInputStream object, carFile
               FileInputStream carFile = new FileInputStream("Vehicles.bin");
               // create an ObjectInputStream object to wrap around carFile
               ObjectInputStream carStream = new ObjectInputStream(carFile);
            )
         {
           
            // read the first (whole) object with the readObject method
            tempCar =  (Car) carStream.readObject();
            while(endOfFile != true)
            {
                try
                 {
                     carListIn.add(tempCar);
                    // read the next (whole) object 
                    tempCar = (Car) carStream.readObject();
                }

                /* use the fact that readObject throws an EOFException to
                   check whether the end of the file has been reached */
                catch(EOFException  e)
                {
                    endOfFile = true;
                }
            }
           
         }

         catch(FileNotFoundException e)
         {
            System.out.println("\nNo file was read");
         }

         catch(ClassNotFoundException e) // thrown by readObject
         {
            System.out.println("\nTrying to read an object of an unknown class");
         }

         catch(StreamCorruptedException e) // thrown by the constructor
         {
            System.out.println("\nUnreadable file format");
         }

         catch(IOException e)
         {
            System.out.println("There was a problem reading the file");
         }

    }

}

