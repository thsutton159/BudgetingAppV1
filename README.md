# BudgetingAppV1
This is a formula I used to help myself keep track of my finances.

7/16/25
Updated the distribute function within the BankAccount class. If the totalExpenses double amount is higher than the account balance, there is now an option to evenly distribute the balance across all expenses. This will also add the evenSplit amount to the emergencyFund and Spending money allocations.

The next update will include a manual distribution of expenses. I'll likely rework how the distribute function works so that the user can choose how their funds are distributed up front. 

I'll also consider updating the even split functionality so that if a goal is met, the rest of the funds can be allocated to another goal. This probably defeats the purpose? But I want to add it in as a user preference.

6/29/25
At the moment, this app is composed of 3 files: TesterV1.java, BankAccount.Java, and Expense.java.

The Expense class allows us to create a named expense, with a goal, a tracker to show how much money you have saved towards your goal. and a tracker which shows if the goal status has been met. There are getter and setter methods used to access each of the editable fields of the Expense object.

The TesterV1 class is used to "open" a bank account, enter the cash in your checking and savings account, enter the number of expenses you have, and displays the account information. 
The account information displayed includes: the total balance, expense, emergency fund, and spending money. It also currently shows a breakdown of each of the expenses. 

The BankAccount class is where most of the activity takes place. This account holds the total balance, total cost of expenses, and fields to show how much money is saved for each of the following allocations: Expenses, Emergency Fund, Spending Money. 
When the expenses function is called in TesterV1, the Bank account initializes an array of expenses, fills out their informaiton, and then distributes the money in the bank account across the expenses. 
At this time, the BankAccount class can only distribute funds across an account whos expenses are less than its total balance. The next upload will have more distribution capabilities.
