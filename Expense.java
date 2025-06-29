/* tj sutton
 * FinanceAutomation v1 - expense
 * Last updated : 4.19.2025
 */

package BankFunctions;

public class Expense {
	
	private String name; // the name to store the expences under
	private double goal; // target amount the user wants to save
	private String frequency; // how often this expense occurs
	private double amountSaved; // the amount money allocated towards this expense
	private boolean paidStatus; // checks if the expense has been met for this month  
	private boolean goalMet; // checks to see if there is enough money allocated for this expense
	
	
	// class construction
	public Expense(String name, double goal) {
		
		this.name = name;
		this.goal = goal;
		//this.frequency = frequency;
		this.amountSaved = 0;
		this.paidStatus = false;
		this.goalMet = false;
		
	} // end of class constructor
	
	// getter methods ------------------------------------------------->
	public boolean getPaidStatus() {
		return this.paidStatus;
	}
	
	public boolean getGoalStatus() {
		return this.goalMet;
	}
	
	public void changeGoalStatus() {
		this.goalMet = !this.goalMet;
	}
	
	public double getGoal() {
		return this.goal;
	}
	
	public double getAmountSaved() {
		return this.amountSaved;
	}
	
	public void save(double amount) {
		this.amountSaved += amount;
	}
	
	public String getName() {
		return this.name;
	}
	
	// ------------------------------------------------------------------------------------------------------->
	
	
}
