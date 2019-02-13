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
		
		while(!in.equals("terminate"))
		{
			String input;
			System.out.println("Welcome, would you like to add an account, make a transaction, or terminate the program?\nPlease enter a command (\"add,\" \"transaction,\" or \"terminate\").");
			input = in.nextLine();
			while(!input.equals("add") || !input.equals("transaction") || !input.equals("terminate"))
			{
				System.out.println("Invalid input, please enter a valid command.");
				in.nextLine();
			}
			switch (input)
			{
			case "add":
			{
				System.out.println("What type of account would you like to open?/nPlease type \"checking\" for a checking account and \"savings\" for a savings account.");
				in.nextLine();
				switch (input)
				{
				case "checking":
				{
					System.out.println("Please enter your name.");
					in.nextLine();
					bankAccounts.add(new CheckingAccount(input, OVER_DRAFT_FEE, TRANSACTION_FEE, FREE_TRANSACTIONS));
					break;
				}
				case "savings":
				{
					System.out.println("Please enter your name");
					in.nextLine();
					bankAccounts.add(new SavingsAccount(input, RATE, MIN_BAL, MIN_BAL_FEE));
					break;
				}
				default:
					System.out.println("Invalid response, please enter \"checking\" or \"savings\" to create an account.");
					in.nextLine();
				}
			}
			case "transaction":
			{
				System.out.println("Please enter your card number");
				in.nextLine();
				int accIndex = 0;
				for(BankAccount acc : bankAccounts)
				{
					while(!input.equals(acc))
					{
						System.out.println("This account does not exist, please enter a valid account number");
						in.nextLine();
					}
					accIndex = Integer.parseInt(input) - 1;
				}
				System.out.println("Would you like to deposit, withdraw, or transfer?");
				in.nextLine();
				switch (input)
				{
				case "deposit":
				{
					System.out.println("Please enter the amount you would like to deposit");
					in.nextLine();
					boolean isNumeric;
					try
					{
						Double.parseDouble(input);
						isNumeric = true;
					}
					catch(IllegalArgumentException e)
					{
						isNumeric = false;
					}
					double amt = Double.parseDouble(input);
					bankAccounts.get(accIndex).deposit(amt);
					break;	
				}
				case "withdraw":
				{
					try
					{
						System.out.println("Please enter the amount you would like to withdraw");
						in.nextLine();
						boolean isNumeric;
						try
						{
							Double.parseDouble(input);
							isNumeric = true;
						}
						catch(IllegalArgumentException e)
						{
							isNumeric = false;
						}
						double amt = Double.parseDouble(input);
						bankAccounts.get(accIndex).withdraw(amt);
					}
					catch(IllegalArgumentException noAuth)
					{
						System.out.println("Transaction not authorized.");
					}
					break;
				}
				case "transfer":
				{
					try
					{
						System.out.println("Please enter the number of the account you are transferring money to");
						in.nextLine();
						int otherAcc = 0;
						for(BankAccount acc : bankAccounts)
						{
							while(!input.equals(acc))
							{
								System.out.println("This account does not exist, please enter a valid account number");
								in.nextLine();
							}
						otherAcc = Integer.parseInt(input);
						}
						System.out.println("Please enter the amount you would like to transfer");
						in.nextLine();
						boolean isNumeric;
						try
						{
							Double.parseDouble(input);
							isNumeric = true;
						}
						catch(IllegalArgumentException e)
						{
							isNumeric = false;
						}
						double amt = Double.parseDouble(input);
						bankAccounts.get(accIndex).transfer(bankAccounts.get(otherAcc), amt);
					}
					catch(IllegalArgumentException noAuth)
					{
						System.out.println("Transaction not authorized.");
					}
					break;
				}
				default:
					System.out.println("Invalid response, please enter \"deposit,\" \"withdraw,\" or \"transfer\" to make a transaction.");
					in.nextLine();
				}
			}
			}
		}
	}
}