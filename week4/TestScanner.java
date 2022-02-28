public class TestScanner extends EasyScanner1 {
    public static void main(String[] args) {
        try {
            System.out.println("Please enter an integer");
            nextInt();
        } catch (Exception e) {
            System.out.println("Error: this is not a valid integer");
            e.printStackTrace();
        }
        System.out.println("End of program");
    }

}
