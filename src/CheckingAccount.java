//java doc comments
public class CheckingAccount extends BankAccount
{
	private final double OVER_DRAFT_FEE;
	private final double TRANSACTION_FEE;
	private final int FREE_TRANS;
	private int numTransactions;
	
	public CheckingAccount(String n, double odf, double tf, int freeTrans)
	{
		name = n;
		balance = 0;
		OVER_DRAFT_FEE = odf;
		TRANSACTION_FEE = tf;
		FREE_TRANS = freeTrans;
		numTransactions = 0;
	}
	
	public CheckingAccount(String n, double b, double odf, double tf, int freeTrans)
	{
		name = n;
		balance = b;
		OVER_DRAFT_FEE = odf;
		TRANSACTION_FEE = tf;
		FREE_TRANS = freeTrans;
		numTransactions = 0;
	}
	
	public double deposit(double amt)
	{
		if(balance > 0)
		{
			balance += amt;
			numTransactions ++;
			if(numTransactions > FREE_TRANS)
			{
				balance -= TRANSACTION_FEE;
			}
		}
		else throw new IllegalArgumentException();
		return balance;
	}
	
	public void endOfMonthUpdate()
	{
		numTransactions = 0;
	}

}
