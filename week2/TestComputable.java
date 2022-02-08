
public class TestComputable
{
    public static void main(String[] args)
    {
        printResult((x,y) -> x+y);
    }
    
    public static void printResult(Computable compIn)
    {
        System.out.println(compIn.compute(10, 5));
    }
    
}

