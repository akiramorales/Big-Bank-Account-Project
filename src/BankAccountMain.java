import java.util.ArrayList;
import java.util.Scanner;

public class BankAccountMain
{
	public static void main(String[] args)
	{
		ArrayList <BankAccount> bankAccounts = new ArrayList <BankAccount>();
		final int OVER_DRAFT_FEE = 15;
		final double RATE = .0025;
		final double TRANSACTION_FEE = 1.5;
		final int MIN_BAL = 300;
		final int MIN_BAL_FEE = 10;
		final int FREE_TRANSACTIONS = 10;
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		
		while(!input.equals("terminate") || !input.equals("Terminate"))
		{
			System.out.println("Welcome, would you like to add an account, make a transaction, or terminate the program?/nPlease enter a command (\"add,\" \"transaction,\" or \"terminate\").");
			in.nextLine();
			while(!(input.equals("add") && input.equals("Add") && input.equals("transaction") && input.equals("Transaction") && input.equals("terminate") && input.equals("Terminate")))
			{
				System.out.println("Invalid input, please enter a valid command.");
				in.nextLine();
			}
			if(input.equals("add") || input.equals("Add"))
			{
				System.out.println("Would you like to withdraw, deposit, or transfer?\nPlease enter a command (\"withdraw,\" \"deposit,\" or \"transfer,\").");
			}
		}
	}
}