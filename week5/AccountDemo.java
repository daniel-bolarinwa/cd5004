import java.util.*;

public class AccountDemo {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("017", "Dan");
        BankAccount acc2 = new BankAccount("012", "Dean");
        BankAccount acc3 = new BankAccount("003", "Dom");
        acc1.deposit(1254);
        acc2.deposit(1130);
        acc3.deposit(1450);

        List<BankAccount> accountList = new ArrayList<>();
        accountList.add(acc1);
        accountList.add(acc2);
        accountList.add(acc3);

        System.out.println("\nAccounts Before Sort\n"+accountList.toString());
        Collections.sort(accountList); // uses the Book compareTo method
        System.out.println("\nAfter Number sort\n"+ accountList.toString());

        accountList.sort((account1,account2) -> {return account1.getAccountName().compareTo(account2.getAccountName());});       		
        System.out.println("\nAfter Name sort\n"+ accountList.toString());
        
        accountList.sort(Comparator.comparing(BankAccount::getBalance));
        System.out.println("\nAfter Balance sort\n"+ accountList.toString());

        Map<Integer, String> regNums = new HashMap<>();
        regNums.put(1,"PKKJJJK");
        regNums.put(2,"FFHKFKJ");
        regNums.put(3,"PFJKDKJ");

        regNums.remove(0);
        System.out.println("\nAfter Balance sort\n"+ regNums.toString());
    }
}
