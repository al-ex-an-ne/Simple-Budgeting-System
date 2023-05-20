

public class Expense {
	
	// Expense attributes
	private String type;
	private double amount;
	private String business;
	private int dueMonth;
	private int dueDay;
	
	// Default constructor
	public Expense() {}
	
	// Constructor with all attributes of expense as parameters
	public Expense (String type, double amount, String business, int dueMonth, int dueDay) {
		this.type = type;
		this.amount = amount;
		this.business = business;
		if (dueMonth < 1 || dueMonth > 12)
			this.dueMonth = 0;
		else
			this.dueMonth = dueMonth;
		if (dueDay < 1 || dueDay > 31)
			this.dueDay = 0;
		else
			this.dueDay = dueDay;
	}
	
	// Copy constructor
	public Expense (Expense otherExpense) {
		type = otherExpense.type;
		amount = otherExpense.amount;
		business = otherExpense.business;
		dueMonth = otherExpense.dueMonth;
		dueDay = otherExpense.dueDay;
	}
	
	// Mutator for the due month of the expense
	public void setDueMonth(int dueMonth) {
		if (dueMonth < 1 || dueMonth > 12)
			this.dueMonth = 0;
		else
			this.dueMonth = dueMonth;
	}
	
	// Mutator for the due day of the expense
	public void setDueDay(int dueDay) {
		if (dueDay < 1 || dueDay > 31)
			this.dueDay = 0;
		else
			this.dueDay = dueDay;
	}
	
	// Accessor for the type of the expense
	public String getType() {
		return type;
	}
	
	// Accessor for the amount of the expense
	public double getAmount() {
		return amount;
	}
	
	// Accessor for the recipient of the expense
	public String getBusiness() {
		return business;
	}
	
	// Accessor for the due month of the expense
	public int getDueMonth() {
		return dueMonth;
	}
	
	// Accessor for the due day of the expense
	public int getDueDay() {
		return dueDay;
	}
	
	// Method to get the expense details as a string
	public String toString() {
		String expenseDetails = type + " - $" + amount + " - " + business +
								" - " + String.format("%02d/%02d.", dueDay, dueMonth);
		return expenseDetails;
	}
	
	// Method to check if another expense has the exact same attributes
	public boolean equals(Expense otherExpense) {
		if (type.equals(otherExpense.type) && amount == otherExpense.amount &&
			business.equals(otherExpense.business) && dueMonth == otherExpense.dueMonth && dueDay == otherExpense.dueMonth)
			return true;
		else
			return false;
	}
	
}
