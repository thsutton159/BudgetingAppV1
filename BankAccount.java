/* tj sutton
 * banking app v1 - bankaccount
 * Last updated : 9.17.2025
 */

package BankFunctions;

import java.text.DecimalFormat;
import java.util.Scanner;

public class BankAccount {

	private double balance; // the user's balance / total cash
	private double expenseAlloc; // the amount of money allocated towards a 
	private double emFundAlloc; // emergency fund split
	private double spendingMoney; // money the user can use for any reason
	private double totalExpenses; // the final sum of all the expenses currently for this account
	
	private int numExpenses; // holds a current deposit for this account
	
	private Expense myExpenses[]; // holds the expenses associated with this account
	Scanner myScan = new Scanner(System.in);
	
	DecimalFormat f = new DecimalFormat("##.00");
	
	public BankAccount() { 
		this.balance = 0.00;
		this.expenseAlloc = 0.00;
		this.emFundAlloc = 0.00;
		this.spendingMoney = 0.00;
	} 
	
	// -------------------------------------------------------------------------------------------------->
		//interface functions 
		
		public void deposit(double value) {
			// known issue : some of the numbers go to 3 or more decimal points, causing a slight discrepancy between the amounts.
			// issue typically only afffects the amount of cents left in temp 3. consider moving over to big decimal in the future
			this.balance += value;
			/*double temp = Math.round(value * 10.0) / 20.00;
			double temp2 = value - temp;
			double temp3 = Math.round(temp2 * 10.0) / 30.0;
			double temp4 = temp2 - temp3;
			
			this.expenseAlloc += temp;
			this.spendingMoney += temp3;
			this.emFundAlloc += temp4;
			
			// printing messages for troubleshooting after money divisions
			System.out.println(f.format(temp));
			System.out.println();
			System.out.println(f.format(this.balance));
			System.out.println();
			System.out.println(this.expenseAlloc);
			System.out.println();
			System.out.println(this.emFundAlloc);
			System.out.println();
			System.out.println(f.format(this.spendingMoney));
			*/
			
		}
		
		public void withdrawal(double value) {
			this.balance -= value;
		}
		
		
		public void expenses() {
			
			String temp; // temp strings to hold the name and frequency for initialization
			int tempInt; // temp variable to hold the digit for initialization
			
			myExpenses = new Expense[this.numExpenses + 1]; // initializes the expenses array
			
			// has the user manually fill in the expenses
			for(int i=0; i < this.numExpenses; i++) {
				System.out.println("Please enter the name and cost of your expense(s):");
				System.out.println();
				temp = myScan.next();
				tempInt = myScan.nextInt();
				//temp2 = myScan.next();
				myExpenses[i] = new Expense(temp, tempInt);
				totalExpenses += tempInt;
			}
			
			this.distribute();
			//myScan.close();
			
		}
		
		// distributes the current balance across expenses
		// public to be accessed by other classes
		public void distribute() {
			 
			//int tempInt; //
			
			if(this.balance > this.totalExpenses) {
				System.out.println("Your balance is greater than your total expenses.");
				System.out.println();
			} else {
				System.out.println("Your balance is less than your total expenses.\n");
				System.out.println();
			}
			
			expensesSplitMenu();
			
		}
		
		// the generic money distribution
		private void genericDistribution() {
			
			for(int i=0; i<this.numExpenses; i++) {  
				this.expenseAlloc += this.myExpenses[i].getGoal(); // sets the money being used for expenses
				this.myExpenses[i].save(this.myExpenses[i].getGoal()); // saves the money for this goal
				this.myExpenses[i].changeGoalStatus(); // marks the goal as met
			}
	
			this.spendingMoney = (this.balance - this.expenseAlloc) * 0.6; // sets the spending money
			this.emFundAlloc = this.balance - this.expenseAlloc - this.spendingMoney; // sets the emergency fund allocation
		
		}
		
		private void evenDistribution() {
			
			double evenSplit = this.balance / (this.numExpenses + 2); // ivides the balance by the number of expenses + the emergency fund and free spend allocations 
			
			for(int i=0; i<this.numExpenses; i++) { // for loop to distribute between expenses
				this.myExpenses[i].save(evenSplit); // saves the even split
				if(this.myExpenses[i].getAmountSaved() >= this.myExpenses[i].getGoal()) { // checks if the goal is met
					if(this.myExpenses[i].getGoalStatus() == false) { // checks if the goal has been met
						this.myExpenses[i].changeGoalStatus(); // marks the goal as paid
					}
				}
			}
			
			this.spendingMoney = evenSplit;
			this.emFundAlloc = evenSplit;
			
		}
		
		private void manualDistribution() {
			
			String temp; // holds the name of an expense
		}
		
		// displays current balances
		public void displayBalances() {
			System.out.println("Balance: " + this.balance); 
			System.out.println("Expense savings: " + this.expenseAlloc); 
			System.out.println("Spending money: " + this.spendingMoney);
			System.out.println("Emergency fund: " + this.emFundAlloc);
			System.out.println();
			
		}
		
		public void displayExpenses(){
			for(int i=0; i<this.numExpenses; i++) {
				System.out.println("Name: " + this.myExpenses[i].getName());
				System.out.println("Goal is met: " + this.myExpenses[i].getGoalStatus());
				System.out.println("Goal: " + this.myExpenses[i].getGoal() + " Amount saved: " + this.myExpenses[i].getAmountSaved());
				System.out.println();
			}
		}
		
		private void expensesSplitMenu() { // private method so that only bank account actions can affect bank accounts
			System.out.println("How would you like to split your balance?");
			System.out.println("1. Built in Split");
			System.out.println("2. Even split");
			System.out.println("3. Manual Split");
			System.out.println("0. Cancel Action");
			System.out.println("Please enter the number for your option.");
			System.out.println();
			
			int tempInt = myScan.nextInt();
			
			switch(tempInt){
				case 1:
					this.genericDistribution();
					break;
				case 2:
					this.evenDistribution();
					break;
				case 3:
					this.manualDistribution();
					break;
				case 0:
					break;
				default:
					System.out.println("Your input did not match an option, please try again.\n");
					break;
			}
		}

		// ----------------------------------------------------------------------------------------------------------------->
	
	// getter + setter methods -------------------------------------------------------------------------------->
	public double getBalance() {
		return this.balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public int getNumExpenses() {
		return this.numExpenses;
	}
	
	public void setNumExpenses(int expenses) {
		this.numExpenses = expenses;
	}
	
	public double getExpenseAlloc() {
		return this.expenseAlloc;
	}
	
	public double getEmergencyFund() {
		return this.emFundAlloc;
	}
	
	public double getSpendingMoney() {
		return this.spendingMoney;
	}
	// ------------------------------------------------------------------------------------------------------>
	
	
	
}

