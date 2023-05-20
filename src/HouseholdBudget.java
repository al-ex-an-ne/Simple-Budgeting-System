

public class HouseholdBudget {
	
	// HouseholdBudget attributes
	private Fund fund;
	private Expense[] expenses;
	
	// Default constructor
	public HouseholdBudget() {}
	
	// Constructor with all attributes of houdeholdBudget as parameters
	public HouseholdBudget(Fund fund, Expense[] expenses) {
		if (fund == null)
			this.fund = null;
		else
			this.fund = new Fund(fund);
		if (expenses == null)
			this.expenses = null;
		else {
			this.expenses = new Expense[expenses.length];
			for (int i = 0; i < this.expenses.length; i++)
				this.expenses[i] = new Expense(expenses[i]);
		}
	}
	
	// Method to check if another householdBudget has the same amount of money in its fund 
	public boolean equalsFundTotal(HouseholdBudget otherHouseholdBudget) {
		if (this.fund.fundTotal() == otherHouseholdBudget.fund.fundTotal())
			return true;
		else
			return false;
	}
	
	// Method to check if another householdBudget's fund has the same breakdown 
	public boolean equalsFundType(HouseholdBudget otherBudget) {
		if (this.fund.equals(otherBudget.fund))
			return true;
		else 
			return false;
	}
	
	// Method to get the total amount of money in the householdBudget's fund
	public int getFundTotal() {
		return fund.fundTotal();
	}
	
	// Method to get the amount of expenses in the householdBudget
	public int getNbOfExpenses() {
		if (expenses != null)
			return expenses.length;
		else
			return 0;
	}
	
	// Method to add an expense to the householdBudget
	public int addExpense(String type, double amount, String business, int dueMonth, int dueDay) {
		Expense[] updatedExpenses;
		if (this.expenses == null)
			updatedExpenses = new Expense[1];
		else
			updatedExpenses = new Expense[expenses.length+1];
		for (int i = 0; i < updatedExpenses.length - 1; i++)
			updatedExpenses[i] = expenses[i];
		updatedExpenses[updatedExpenses.length-1] = new Expense(type, amount, business, dueMonth, dueDay);
		expenses = new Expense[updatedExpenses.length];
		for (int i = 0; i < expenses.length; i++)
			expenses[i] = updatedExpenses[i];
		return expenses.length;
	}
	
	// Method to remove an expense from the householdBudget
	public boolean removeExpense (int index) {
		if (expenses == null)
			return false;
		else if (expenses.length == 1) {
			expenses = null;
			return true;
		}
		else {
			Expense[] updatedExpenses = new Expense[expenses.length-1];
			for (int i = 0; i < updatedExpenses.length; i++) {
				if (i < index)
					updatedExpenses[i] = new Expense(expenses[i]);
				else if(i >= index)
					updatedExpenses[i] = new Expense(expenses[i+1]);
			}
		expenses = new Expense[updatedExpenses.length];
		for (int i = 0; i < expenses.length; i++)
			expenses[i] = updatedExpenses[i];
		return true;
		}
	}
	
	// Method to update the due month and the due day of an expense in the householdBudget
	public void updateDueDate(int i, int dueMonth, int dueDay) {
		expenses[i].setDueMonth(dueMonth);
		expenses[i].setDueDay(dueDay);
	}
	
	// Method to add certain amounts of currency to the householdBudget's fund
	public int addFund(int addLoonies, int addToonies, int addB5, int addB10, int addB20) {
		fund.addFund(addLoonies, addToonies, addB5, addB10, addB20);
		return getFundTotal();
	}
	
	// Method to check if another householdBudget has the same amount of expenses and the same total amount of money
	public boolean equals(HouseholdBudget otherBudget) {
		if(this.equalsFundTotal(otherBudget) && this.getNbOfExpenses() == otherBudget.getNbOfExpenses())
			return true;
		else
			return false;
	}
	
	// Method to get the householdBudget's fund and expenses as a string
	public String toString() {
		String Budget = this.fund.toString()+ "\n";
		if (expenses != null)
			for (int i = 0; i < expenses.length; i++) 
				Budget += expenses[i].toString() + "\n";
		else
			Budget += "No expenses" + "\n";
		return Budget;
	}
	
	// Method to get the householdBudget's fund breakdown as a string
	public String getFund() {
		String fundBreakdown = fund.toString();
		return fundBreakdown;
	}
}
			
				
	

