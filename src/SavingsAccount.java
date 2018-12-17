/**
 * @author Akira Morales
 * Bank Account Project
 * Period 6
 */
public class SavingsAccount extends BankAccount
{
	//Fields
	private double intRate;
	private final double MIN_BAL;
	private final double MIN_BAL_FEE;
	
	//Constructors
	public SavingsAccount(String n, double r, double mb, double mbf)
	{
		super(name, balance, acctNumber);
		name = n;
		balance = 0;
		acctNumber = nextAccNum;
		intRate = r;
		MIN_BAL = mb;
		MIN_BAL_FEE = mbf;
	}
	
	public SavingsAccount(String n, double b, double r, double mb, double mbf)
	{
		super(name, balance, acctNumber);
		name = n;
		balance = b;
		acctNumber = nextAccNum;
		intRate = r;
		MIN_BAL = mb;
		MIN_BAL_FEE = mbf;
	}
	
	/**
	 * Withdrawals an amount from the savings account, including fees
	 * @param amt	amount
	 * @return 		the balance of the account, or throws an illegal argument exception
	 */
	public double withdrawal(double amt)
	{
		if(balance - amt >= 0 && amt > 0)
		{
			balance -= amt;
			if(balance < MIN_BAL)
			{
				balance -= MIN_BAL_FEE;
			}
		}
		else throw new IllegalArgumentException();
		return balance;
	}
	/**
	 * Transfers an amount between a person's accounts and applies a transaction fee if applicable
	 * @param other		name of another bank account
	 * @param amt		amount
	 * @return 			the balance of the account, or throws an illegal arguments exception
	 */
	public double transfer(BankAccount other, double amt)
	{
		if(other.getName().equals(this.getName()) && this.balance - amt >= 0 && amt > 0)
		{
			this.balance -= amt;
			balance += amt;
			if(other == (CheckingAccount)other)
			{
				other.numTransactions++;
				if(other.numTransactions > FREE_TRANS)
				{
					other.balance -= TRANSACTION_FEE;
				}
			}
		}
		else throw new IllegalArgumentException();
		return balance;
	}
	/**
	 * Calculates and adds interest to the balance
	 */
	public void addInterest()
	{
		balance += balance * intRate;
	}
	/**
	 * Adds interest
	 */
	public void endOfMonthUpdate()
	{
		addInterest();
	}
}
