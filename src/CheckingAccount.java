/**
 * @author Akira Morales
 * Bank Account Project
 * Period 6
 */
public class CheckingAccount extends BankAccount
{
	//Fields
	private final double OVER_DRAFT_FEE;
	private final double TRANSACTION_FEE;
	private final int FREE_TRANS;
	private int numTransactions;
	
	//Constructors
	public CheckingAccount(String n, double odf, double tf, int freeTrans)
	{
		super(name, balance, acctNumber);
		name = n;
		balance = 0;
		acctNumber = nextAccNum;
		OVER_DRAFT_FEE = odf;
		TRANSACTION_FEE = tf;
		FREE_TRANS = freeTrans;
		numTransactions = 0;
	}
	
	public CheckingAccount(String n, double b, double odf, double tf, int freeTrans)
	{
		super(name, balance, acctNumber);
		name = n;
		balance = b;
		acctNumber = nextAccNum;
		OVER_DRAFT_FEE = odf;
		TRANSACTION_FEE = tf;
		FREE_TRANS = freeTrans;
		numTransactions = 0;
	}
	
	//Methods
	/**
	 * Adds an amount to the balance of the checking account, including fees
	 * @param amt	amount
	 * @return 		Returns the balance or throws an illegal argument exception
	 */
	public double deposit(double amt)
	{
		if(amt > 0)
		{
			numTransactions ++;
			balance += amt;
			if(numTransactions > FREE_TRANS)
			{
				balance -= TRANSACTION_FEE;
			}
		}
		else throw new IllegalArgumentException();
		return balance;
	}
	/**
	 * Withdrawals an amount from the balance of the checking account, including fees
	 * @param amt	amount
	 * @return 		Returns the balance or throws an illegal arguments exception
	 */
	public double withdrawal(double amt)
	{
		if(balance >= 0 && amt > 0)
		{
			numTransactions++;
			balance -= amt;
			if(numTransactions > FREE_TRANS)
			{
				balance -= TRANSACTION_FEE;
			}
		}
		else throw new IllegalArgumentException();
		return balance;
	}
	/**
	 * Transfers an amount between the balances of a person's accounts
	 * @param other		name of another bank account
	 * @param amt		amount
	 * @return 			the balance of the checking account transferring money, or throws an illegal arguments exception
	 */
	public double transfer(BankAccount other, double amt)
	{
		if(other.getName().equals(this.getName()) && (numTransactions <= FREE_TRANS || this.balance - TRANSACTION_FEE >= 0 && amt > 0))
		{
			this.numTransactions++;
			this.balance -= amt;
			balance += amt;
			if(numTransactions > FREE_TRANS)
			{
				balance -= TRANSACTION_FEE;
			}
		}
		else throw new IllegalArgumentException();
		return balance;
	}
	/**
	 * Resets the number of transactions on the checking account to 0
	 */
	public void endOfMonthUpdate()
	{
		numTransactions = 0;
	}
	/**
	 * Returns the number of transactions on the account
	 * @return	the number of transactions
	 */
	public double getNumTransactions()
	{
		return numTransactions;
	}

}
