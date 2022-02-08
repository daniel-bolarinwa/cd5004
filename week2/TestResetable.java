public class TestResetable {
    public static void main (String[] args) {
        Oblong testOblong = new Oblong (8,8); 
        System.out.println("resetting oblong height and length from current values " + testOblong.getHeight() + " " + testOblong.getLength());
        resetObject(() ->{
            testOblong.setHeight(1);
            testOblong.setLength(1);
        });

        System.out.println("oblong height and length after reset is now " + testOblong.getHeight() + " " + testOblong.getLength());
    }

    public static void resetObject(Resetable objectIn) {
        objectIn.reset();
    }
}
