/* tj sutton
 * Budgeting app v1 - testerv1
 * Last updated : 9.17.2025
 */

package BankFunctions;

// imports

//import java.math.BigDecimal;
import java.util.Scanner;


public class TesterV1 {
	
	public static void main(String [] args) {
		
		BankAccount acc1 = new BankAccount();
		int menuOption;
		double checking, saving, deposit;
		Scanner myScan = new Scanner(System.in);
		
		System.out.println("Please enter the amount of money in your checking account:");
		checking = myScan.nextDouble();
		System.out.println("Please enter the amount of money in your savings account:");
		saving = myScan.nextDouble();
		
		acc1.setBalance(checking + saving);
		System.out.println("The total amount of money you have available currently is: " + acc1.getBalance());
		
		System.out.println("How many expenses do you have?");
		acc1.setNumExpenses(myScan.nextInt());
		acc1.expenses();
		
		//System.out.println("Please enter the deposit amount");
		//deposit = myScan.nextDouble();
		
		do {
			acc1.displayBalances();
			System.out.println("Which of the following actions would you like to take in your account?");
			System.out.println("Please enter the number for your option.");
			//System.out.println("1. Display Account Balances.");
			//System.out.println("2. Display Expenses.");
			System.out.println("1. Deposit.");
			System.out.println("2. Withdrawal.");
			System.out.println("3. Distrubite Funds");
			//System.out.println("5. Make a Savings Plan");
			System.out.println("0. Exit");
			System.out.println();
			menuOption = myScan.nextInt();
			
			switch(menuOption){
				case 1:
					System.out.println("Please enter your deposit amount");
					System.out.println();
					acc1.deposit(myScan.nextDouble());
					acc1.distribute();
					break;
				case 2:
					System.out.println("Please enter your withdrawl amount:");
					System.out.println();
					acc1.withdrawal(myScan.nextDouble());
					acc1.distribute();
					break;
				case 3: 
					acc1.distribute();
					break;
				case 0:
					menuOption = 0;
					break;
				default:
					System.out.println("Please enter a valid option.");
					System.out.println();
					break;
			}
		
		}while(menuOption != 0);
		
		System.out.println("Thank you, and have a nice day!");
		/*
			//acc1.deposit(deposit);
			acc1.displayBalances();
			System.out.println();
			acc1.displayExpenses();
			System.out.println();
		*/
		
			myScan.close();
		
		
	}
	
}

