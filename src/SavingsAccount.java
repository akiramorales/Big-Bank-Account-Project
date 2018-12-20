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
	/**
	 * Creates a savings account with a balance initialized as 0
	 * @param n		name
	 * @param r		interest rate
	 * @param mb	minimum balance
	 * @param mbf	minimum balance fee
	 */
	public SavingsAccount(String n, double r, int mb, int mbf)
	{
		super(n);
		name = n;
		balance = 0;
		acctNumber = nextAccNum;
		intRate = r;
		MIN_BAL = mb;
		MIN_BAL_FEE = mbf;
	}
	/**
	 * Creates a savings account with a balanced initialized as a specified value
	 * @param n		name
	 * @param b		balance
	 * @param r		interest rate
	 * @param mb	minimum balance
	 * @param mbf	minimum balance fee
	 */
	public SavingsAccount(String n, int b, double r, int mb, int mbf)
	{
		super(n, b);
		name = n;
		balance = b;
		acctNumber = nextAccNum;
		intRate = r;
		MIN_BAL = mb;
		MIN_BAL_FEE = mbf;
	}
	
	/**
	 * Withdraws an amount from the savings account, including fees
	 * @param amt	amount
	 * @return 		the balance of the account, or throws an illegal argument exception
	 */
	public double withdraw(double amt)
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
