public class TestScannerPlus extends EasyScannerPlus {
    public static void main(String[] args) {
        try {
            System.out.println("Please enter an integer");
            nextInt();
        } catch (Exception e) {
            System.out.println("Error: this is not a valid integer");
            e.printStackTrace();
        }

        try {
            System.out.println("Please enter a double");
            nextDouble();
        } catch (Exception e) {
            System.out.println("Error: this is not a valid double");
            e.printStackTrace();
        }
        
        System.out.println("End of program");
    }
}
