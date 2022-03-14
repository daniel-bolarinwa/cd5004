
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBinaryFile
{
	public static void main(String[] args)
	{
        // use try-with-resources
        try(FileInputStream  picFileIn = new FileInputStream("sunset.jpg"); // open for reading
            FileOutputStream picFileOut = new FileOutputStream("sunsetCopy.jpg");)  //open for writing
        {    
            byte[] buffer = new byte[10]; // create a 10 byte buffer
            int bytesRead = picFileIn.read(buffer); // read ahead
            while(bytesRead > 0) // stop when no more data available
            {
                picFileOut.write(buffer, 0, bytesRead); // write bytesRead number of bytes
                bytesRead = picFileIn.read(buffer); 
            }    
        }
              
        // handle exceptions
        catch(FileNotFoundException e)
        {
            System.out.println("\nFile not found");
        }
            
        catch(IOException e)
        {
		     System.out.println("There was a problem writing the file");
        }
              
    }
}

                
