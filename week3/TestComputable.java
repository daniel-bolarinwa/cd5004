public class TestComputable
{
    public static void main(String[] args)
    {
        Computable<Integer, Integer, Integer> comp = (x, y) -> x + y ;
        printResult(comp);
    }
    
    public static void printResult(Computable<Integer, Integer, Integer> compIn)
    {
        System.out.println(compIn.compute(1, 2));
    }
    
}

