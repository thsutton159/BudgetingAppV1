/* tj sutton
 * Budgeting app v1 - testerv1
 * Last updated : 6.29.2025
 */

package BankFunctions;

// imports

//import java.math.BigDecimal;
import java.util.Scanner;


public class TesterV1 {
	
	public static void main(String [] args) {
		
		BankAccount acc1 = new BankAccount();
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
		
		//acc1.deposit(deposit);
		acc1.displayBalances();
		acc1.displayExpenses();
		myScan.close();
		
	}
	
}
