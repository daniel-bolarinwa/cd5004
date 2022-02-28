
import java.util.Comparator;
import java.lang.*;

public class Book implements Comparable <Book> 
{ 
    private String isbn; 
    private String title;
    private String author;

    public Book(String isbnIn, String titleIn, String authorIn) 
    { 
		isbn = isbnIn; 
		title = titleIn; 
		author = authorIn; 
    }

    public String getISBN() 
    { 
		return isbn; 
    }

    public String getTitle() 
    { 
		return title; 
    }

    public String getAuthor() 
    { 
		return author; 
    } 
    
    @Override
    public String toString() 
    { 
        return "(" + isbn +", " + title + ", " + author +  ")"; 
    }
    
    @Override
    public boolean equals (Object objIn) 
    {
		Book bookIn = (Book) objIn; 
		return  isbn.equals(bookIn.isbn); 
    }
    
    @Override
    public int hashCode() 
    { 
      return isbn.hashCode(); 
    }

    @Override
    public int compareTo(Book bIn)
    {
      int length = title.length();
      int secondLength =  bIn.title.length();
      return Integer.compare(length, secondLength);
    }  
   

}

