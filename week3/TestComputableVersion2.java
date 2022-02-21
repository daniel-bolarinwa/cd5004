import java.util.function.Predicate;


public class TestComputableVersion2
{
    public static void main(String[] args)
    {
        printResult (a -> a.length()>10);
    }
    
    public static void printResult(Predicate<String> compIn)
    { 
        System.out.println(compIn.test("hello"));
    }
    
}

