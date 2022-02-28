
public class Bank
{
	// attributes
	private BankAccount1[] list; // to hold the accounts
	private int total; // to keep track of the number of accounts in the list
	
	// methods
	// the constructor
	
	public Bank(int sizeIn)
	{
		// size array with parameter
		list = new BankAccount1[sizeIn];
		total = 0;
	}
	
	// helper method to find the index of a specified account
	private int search(String accountNumberIn)
	{
		for(int i = 0; i < total; i++)
		{
			BankAccount1 tempAccount = list[i]; // find the account at index i
			String tempNumber = tempAccount.getAccountNumber(); // get account number
			if(tempNumber.equals(accountNumberIn)) // if this is the account we are looking for
			{
				return i; // return the index
			}
		}
		return -999;
	}
	
	// return the total number of accounts in the list 
	public int getTotal()
	{
	    return total;
	}
	
	// check if the list is empty 
	public boolean isEmpty()
	{
		if (total == 0)
		{
			return true; // list is empty
		}
		else
		{
			return false; // list is not empty
		}
	}
	
	// check if the list is full
	public boolean isFull()
	{
		if (total == list.length)
		{
			return true; // list is full
		}
		else
		{
			return false; // list is empty
		}
	}
	
	// add an item to the array
	public boolean add(BankAccount1 accountIn)
	{
		if (!isFull()) // check if list is full
		{
			list[total] = accountIn; // add item
			total++; // increment total
			return true; // indicate success
		}
		else
		{
			return false; // indicate failure
		}
	}
	
	// return an account at a particular place in the list
	public BankAccount1 getItem(int positionIn)
	{
		if(positionIn < 1 || positionIn > total)
		{
			return null; // indicate invalid index
		}
		else
		{
			return list[positionIn - 1];
		}
	}

	// return an account with a particular account number
	public BankAccount1 getItem(String accountNumberIn)
	{
		int index; 
		index = search(accountNumberIn);
		if(index == -999)
		{
			return null; // indicate invalid index
		}
		else
		{
			return list[index];
		}
	}



	
	// deposit money in a specified account
	public boolean depositMoney(String accountNumberIn, double amountIn)
	{
		int index = search(accountNumberIn);
		if(index == -999) // there was no such account number
		{
			return false; // indicate failure
		}
		else
		{
			list[index].deposit(amountIn);
			return true; // indicate success
		}
	}
	
	// withdraw money from a specified account
	public boolean withdrawMoney(String accountNumberIn, double amountIn)
	{
   		boolean okToWithdraw;
		int index = search(accountNumberIn);
		if(index == -999) // there was no such account number
		{
			return false; // indicate failure due to incorrect account number
		}
		else
		{
			okToWithdraw = list[index].withdraw(amountIn); // store boolean return value
			return okToWithdraw; // false if insufficient funds and true if withdraw successful
		}
	}
	
	// remove an account
	public boolean remove(String numberIn)
	{
		int index = search(numberIn); // find index of account
		if(index == -999) // if no such account
		{
			return false; // remove was unsuccessful
		}
		else
		{   // overwrite items by shifting other items along
			for(int i = index; i<= total-2; i++)
			{
				list[i] = list[i+1];
			}
	
			total--; // decrement total number of accounts
			return true; // remove was successful
	
	    }
	}
}

