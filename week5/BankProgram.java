public class BankProgram
{
	public static void main(String[] args)
	{
		char choice;
		int size;
		System.out.print("Maximum number of accounts? ");
		size = EasyScanner2.nextInt();
		// create Bank object
		Bank myBank = new Bank(size);
		
		// offer menu
		do
		{
			System.out.println();
			System.out.println("1. Create new account");
			System.out.println("2. Remove an account");
			System.out.println("3. Deposit money");
			System.out.println("4. Withdraw money");
			System.out.println("5. Check account details");
			System.out.println("6. Quit");
			System.out.println();
			System.out.print("Enter choice [1-6]: ");
			
			// get choice
			choice = EasyScanner2.nextChar();
			System.out.println();
			
			// process menu options
			switch (choice)
			{
				case '1': option1(myBank);
				break;
				case '2': option2(myBank);
				break;
				case '3': option3(myBank);
				break;
				case '4': option4(myBank);
				break;
				case '5': option5(myBank);
				break;
				case '6': break;
				default: System.out.println("Invalid entry");
			}
		}
		while (choice != '6');
	}
	
	// add account 
	static void option1(Bank bankIn)
	{
		// get details from user
		System.out.print("Enter account number: ");
		String number = EasyScanner2.nextString();
		System.out.print("Enter account name: ");
		String name = EasyScanner2.nextString();
		// create new account
		BankAccount1 account = new BankAccount1(number, name);
		// add account to list
		boolean ok = bankIn.add(account); if (!ok)
		{
			System.out.println("The list is full");
		}
		else
		{
			System.out.println("Account created");
		}
	}
	
	// remove account
	static void option2(Bank bankIn)
	{
		// get account number of account to remove
		System.out.print("Enter account number: ");
		String number = EasyScanner2.nextString();
		// delete item if it exists
		boolean ok = bankIn.remove(number); if (!ok)
		{
			System.out.println("No such account number");
		}
		else
		{
			System.out.println("Account removed");
		}
	}
	
	// deposit money in an account
	static void option3(Bank bankIn)
	{
	// get details from user
		System.out.print("Enter account number: ");
		String number = EasyScanner2.nextString();
		System.out.print("Enter amount to deposit: ");
		double amount = EasyScanner2.nextDouble();
		boolean ok = bankIn.depositMoney(number, amount); // attempt to deposit 
		if (!ok)
		{
			System.out.println("No such account number");
		}
		else
		{
			System.out.println("Money deposited");
		}
	}
	
	// withdraw money from an account
	static void option4(Bank bankIn)
	{
		// get details from user
		System.out.print("Enter account number: ");
		String number = EasyScanner2.nextString();
		System.out.print("Enter amount to withdraw: ");
		double amount = EasyScanner2.nextDouble();
		boolean ok = bankIn.withdrawMoney(number, amount); // attempt to withdraw 
		if (!ok)
		{
			System.out.println("No such account number or insufficient funds");
		}
		else
		{
			System.out.println("Money withdrawn");
		}
	}
	
	// check account details
	static void option5(Bank bankIn)
	{
		// get details from user
		System.out.print("Enter account number ");
		String number = EasyScanner2.nextString();
		BankAccount1 account = bankIn.getItem(number);
		if (account == null)
		{
			System.out.println("No such account number");
		}
		else
		{
			System.out.println("Account number: " + account.getAccountNumber());
			System.out.println("Account name: " + account.getAccountName());
			System.out.println("Balance: " + account.getBalance());
			System.out.println();
		}
	}
}
