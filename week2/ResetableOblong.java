
public class ResetableOblong extends Oblong implements Resetable{
    //override the constructor
    public ResetableOblong(double lengthIn, double heightIn)
    {
        super(lengthIn, heightIn);
    }
    
    @Override
    public void reset(){ // the check method of Resetable must be overridden
        // the length and height must both be reset to one
	    setLength(1);
        setHeight(1);
    }
}


