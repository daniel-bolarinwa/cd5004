public class ExceptionsQ {
    public static void main(String[] args) {
        int[] someArray = { 12, 9, 3, 11 };

        try {
            int position = getPosition();
            display(someArray, position);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: this number is not within the range of the array.");
        } catch (NumberFormatException e) {
            System.out.println("Error: this is not a valid integer.");
        } catch (InvalidPositionException e) {
            System.out.println("hello");
        } catch (Exception e) {
            System.out.println("Error: ");
            e.printStackTrace();
        }
        System.out.println("End of program");
    }

    static int getPosition() {
        System.out.println("Enter array position to display");
        String positionEntered = EasyScanner1.nextString(); // requires EasyScanner class
        return Integer.parseInt(positionEntered);
    }

    static void display(int[] arrayIn, int posIn) throws InvalidPositionException {

        if (posIn < 0 || posIn > 3) {
            throw new InvalidPositionException();
        }

        System.out.println("Item at this position is: " + arrayIn[posIn]);
    }
}
