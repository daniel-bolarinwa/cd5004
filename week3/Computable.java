public interface Computable<DT extends Number, A extends Number, B extends Number>
{
    public DT compute(A firstParam, B secondParam);
}