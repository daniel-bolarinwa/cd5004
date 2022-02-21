
public class TestComputable1
{
    public static void main(String[] args)
    {
        printResult((x,y) -> x+y);
    }
    
    public static void printResult(Computable1 compIn)
    {
        System.out.println(compIn.compute(10, 5));
    }
    
}

