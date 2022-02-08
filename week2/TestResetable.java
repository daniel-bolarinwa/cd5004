public class TestResetable {
    public static void main (String[] args) {
        BankAccount testAccount = new BankAccount("122222122", "Daniel");
        testAccount.deposit(550);
        System.out.println("current bank account balance for " + testAccount.getAccountName() + " is" + testAccount.getBalance());
        Oblong testOblong = new Oblong (8,8); 
        System.out.println("oblong height and length current values are height: " + testOblong.getHeight() + " and length: " + testOblong.getLength());
        resetObject(() ->{
            testOblong.setHeight(1);
            testOblong.setLength(1);
        });

        resetObject(() ->{
            testAccount.withdraw(testAccount.getBalance());
        });

        System.out.println("oblong height and length after resetting is now height: " + testOblong.getHeight() + " and length: " + testOblong.getLength());
        System.out.println("current bank account balance for " + testAccount.getAccountName() + " is" + testAccount.getBalance() + " after resetting the account balance");
    }

    public static void resetObject(Resetable objectIn) {
        objectIn.reset();
    }
}
