/** 
 * @author Akira Morales
 * Bank Account Project
 * Period 6
 */

public abstract class BankAccount
{
	//Fields
	static int nextAccNum;
	String name;
	int acctNumber;
	double balance;
	
	//Constructors
	public BankAccount(String n)
	{
		name = n;
		acctNumber = nextAccNum;
		balance = 0;
		nextAccNum++;
	}
	
	public BankAccount(String n, double b)
	{
		name = n;
		acctNumber = nextAccNum;
		balance = b;
		nextAccNum ++;
	}
	
	//Methods
	/**
	 * Adds an amount to the balance of a bank account
	 * @param amt	amount
	 * @return		the balance of the account after an amount is deposited
	 */
	public double deposit(double amt)
	{
		balance += amt;
		return balance;
	}
	/**
	 * Withdrawals an amount of the balance of a bank account
	 * @param amt	amount
	 * @return		the balance of the account after an amount is withdrawn
	 */
	public double withdrawal(double amt)
	{
		balance -= amt;
		return balance;
	}
	/**
	 * Returns the name of the owner of the bank account
	 * @return	the name of the bank account owner
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * Returns the balance of the bank account
	 * @return	the balance of the bank account
	 */
	public double getBalance()
	{
		return balance;
	}
	/**
	 * 
	 */
	public abstract void endOfMonthUpdate();
	/**
	 * Transfers an amount from the balance of one bank account to another
	 * @param other		another bank account
	 * @param amt		the amount transferred to the other account
	 * @return			the balance of the bank account transferring money
	 */
	public double transfer(BankAccount other, double amt)
	{
		this.balance -= amt;
		balance += amt;
		return balance;
	}
	/**
	 * Returns the number, name, and balance associated with the bank account
	 */
	public String toString()
	{
		return "" + acctNumber +"\t" + name + "\t$" + balance;
	}
}
