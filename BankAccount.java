//javadoc comments
public abstract class BankAccount
{
	static int nextAccNum;
	String name;
	int acctNumber;
	double balance;
	
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
	
	public double deposit(double amt)
	{
		balance += amt;
		return balance;
	}
	
	public double withdrawal(double amt)
	{
		balance -= amt;
		return balance;
	}
	
	public String getName()
	{
		return name;
	}
	
	public double getBalance()
	{
		return balance;
	}
	
	public abstract void endOfMonthUpdate();
	
	
}
