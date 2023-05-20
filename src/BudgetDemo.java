
//-------------------------------------------------------
//A system containing household budgets that comprise of
//a fund and multiple expenses, which can be modified by 
//the user and compared amongst each other.
//--------------------------------------------------------

import java.util.Scanner;
public class BudgetDemo {
	
	// Create Scanner object to be used by static methods as well
	private static Scanner sc = new Scanner (System.in);

	public static void main(String[] args) {
		
		// Print a welcome message
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++" + "\n");
		System.out.println("Welcome to COMP248 Geek's HouseholdBudget2022_Application" + "\n");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		// Create an array containing all the householdBudgets funds
		Fund[] allFunds = new Fund[5];
		allFunds[0] = new Fund(0,1,0,2,1);
		allFunds[1] = new Fund(0,1,0,2,1);
		allFunds[2] = new Fund(2,0,2,1,1);
		allFunds[3] = new Fund(2,1,2,1,5);
		allFunds[4] = new Fund(2,1,2,1,5);
		
		// Create a 2D array containing all the householdBudgets array of expenses
		Expense[][] allExpenses = new Expense[5][];
		allExpenses[0] = new Expense[2];
		allExpenses[0][0] = new Expense("Purchase", 85.5, "IGA", 11, 25);
		allExpenses[0][1] = new Expense("Bill", 122.75, "Videotron", 12, 2);
		allExpenses[1] = new Expense[2];
		allExpenses[1][0] = new Expense("Purchase", 85.5, "IGA", 11, 25);
		allExpenses[1][1] = new Expense("Bill", 16.2, "Costco", 11, 23);
		allExpenses[2] = new Expense[3];
		allExpenses[2][0] = new Expense("Purchase", 50.75, "Pharmaprix", 12, 1);
		allExpenses[2][1] = new Expense("Purchase", 16.2, "TheBay", 12, 16);
		allExpenses[2][2] = new Expense("Bill", 65.85, "Fido", 1, 5);
		
		// Create 5 householdBudgets
		HouseholdBudget[] allHouseholdBudgets = new HouseholdBudget[5];
		for(int i = 0; i < allHouseholdBudgets.length; i++)
			allHouseholdBudgets[i] = new HouseholdBudget(allFunds[i], allExpenses[i]);
		
		// Declare variables
		int userChoice;
		
		do {
			
			// Display commands available to the user
			System.out.println("\nWhat would you like to do?\n" 
								+ " 1. See the possessions of all householdBudgets\n" 
								+ " 2. See the possessions of one householdBudget\n" 
								+ " 3. List householdBudgets with same total amount of fund\n" 
								+ " 4. List householdBudgets with same fund denomination(s)\n" 
								+ " 5. List householdBudgets with same total amount of fund and same number of expenses\n" 
								+ " 6. Add an expense to an existing householdBudget\n" 
								+ " 7. Remove existing expense from householdBudget\n" 
								+ " 8. Update the payment due date of an existing expense\n" 
								+ " 9. Add fund to a householdBudget\n" 
								+ " 0. To quit\n");
			
			// Prompt user to input a command and process it
			System.out.print("Please enter your choice and press <Enter>: ");
			userChoice = sc.nextInt();
			
			switch (userChoice){
				
				// Print all of the householdBudgets
				case 1:
					System.out.println("Content of each HouseholdBudget:");
					System.out.println("---------------------");
					
					for (int i = 0; i < allHouseholdBudgets.length; i++) {
						System.out.println("Household #" + i + ":");
						System.out.print(allHouseholdBudgets[i].toString() + "\n");
					}
					break;
				
				// Print the householdBudget of the user's choice
				case 2:
					System.out.print("Which HouseholdBudget do you want to see the possessions of? "
									+ "(Enter number 0 to 4): ");
					int index = sc.nextInt();
					if (index < 0 || index >= allHouseholdBudgets.length) 
						index = tryAgain(index, allHouseholdBudgets.length, "HouseholdBudget");
					
					System.out.println(allHouseholdBudgets[index].toString());
					
					break;
				
				// List the householdBudgets with the same amount of money in their funds
				case 3:
					System.out.println("List of HouseholdBudgets with same total fund:\n");
					
					for (int i = 0; i < allHouseholdBudgets.length - 1; i++)
						for (int j = i + 1; j < allHouseholdBudgets.length; j++)
							if (allHouseholdBudgets[i].equalsFundTotal(allHouseholdBudgets[j]))
								System.out.println("\tHouseholdBudgets " + i + " and " + j + " both have $" +
													allHouseholdBudgets[i].getFundTotal());
					System.out.println();
					
					break;
				
				// List the householdBudgets with the same fund breakdown
				case 4:
					System.out.println("List of HouseholdBudgets with same fund:\n");
					
					for (int i = 0; i < allHouseholdBudgets.length - 1; i++)
						for (int j = i + 1; j < allHouseholdBudgets.length; j++)
							if (allHouseholdBudgets[i].equalsFundType(allHouseholdBudgets[j]))
								System.out.println("HouseholdBudgets " + i + " and " + j + " both have " +
													allHouseholdBudgets[i].getFund());
					System.out.println();
					
					break;
				
				// List the householdBudgets with the same amount of money in their fund and the same amount of expenses
				case 5:
					System.out.println("List of HouseholdBudgets with same amount of money and "
										+ "same number of expenses:\n");
					
					for (int i = 0; i < allHouseholdBudgets.length - 1; i++)
						for (int j = i + 1; j < allHouseholdBudgets.length; j++)
							if (allHouseholdBudgets[i].equals(allHouseholdBudgets[j]))
								System.out.println("HouseholdBudgets " + i + " and " + j);
					
					System.out.println();
					
					break;
				
				// Allow the user to add any expense to any householdBudget
				case 6:
					System.out.print("Which HouseholdBudget do you want to add an expense to? "
									+ "(Enter number 0 to " + (allHouseholdBudgets.length - 1) + "): ");
					index = sc.nextInt();
					if (index < 0 || index >= allHouseholdBudgets.length)
						index = tryAgain(index, allHouseholdBudgets.length, "HouseholdBudget");
					
					System.out.println("Please enter the following information so that we may complete the expense.");
					System.out.print("--> Type of expense (Bill, Purchase, etc..): ");
					String newExpenseType = sc.next();
					System.out.print("--> Amount of the expense: ");
					double newExpenseAmount = sc.nextDouble();
					System.out.print("--> Name of the business: ");
					String newExpenseBusiness = sc.next();
					System.out.print("--> Payment due day number and month (separated by a space): ");
					int newExpenseDueDay = sc.nextInt();
					int newExpenseDueMonth = sc.nextInt();
					
					if (allHouseholdBudgets[index].getNbOfExpenses() == 0)
						System.out.println(" You now have " 
											+ allHouseholdBudgets[index].addExpense(newExpenseType, newExpenseAmount, newExpenseBusiness, newExpenseDueMonth, newExpenseDueDay) 
											+ " expense");
					else
						System.out.println(" You now have " + 
											allHouseholdBudgets[index].addExpense(newExpenseType, newExpenseAmount, newExpenseBusiness, newExpenseDueMonth, newExpenseDueDay) +
											" expenses");
					
					break;
				
				// Allow the user to remove any expense from any householdBudget
				case 7:
					System.out.print("Which HouseholdBudget do you want to remove an expense from? "
									+ "(Enter number 0 to " + (allHouseholdBudgets.length - 1) + "): ");
					index = sc.nextInt();
					if (index < 0 || index >= allHouseholdBudgets.length)
						index = tryAgain(index, allHouseholdBudgets.length, "HouseholdBudget");
					
					if (allHouseholdBudgets[index].getNbOfExpenses() == 0) {
						System.out.println("Sorry, that HouseholdBudget has no expenses.");
						break;
					}
					
					System.out.print("Which expense do you want to remove? (Enter number 0 to " + (allHouseholdBudgets[index].getNbOfExpenses()-1) + "): ");
					int expenseToRemove = sc.nextInt();
					if (expenseToRemove < 0 || expenseToRemove >= allHouseholdBudgets[index].getNbOfExpenses()) 
						expenseToRemove = tryAgain(expenseToRemove, allHouseholdBudgets[index].getNbOfExpenses(), "expense");
					
					if (allHouseholdBudgets[index].removeExpense(expenseToRemove))
						System.out.println("Expense was removed successfully");
					
					break;
				
				// Allow the user to change the due day and due month of any expense in any householdBudget
				case 8:
					System.out.print("Which HouseholdBudget do you want to update an expense from? "
									+ "(Enter number 0 to " + (allHouseholdBudgets.length - 1) + "): ");
					
					index = sc.nextInt();
					if (index < 0 || index >= allHouseholdBudgets.length)
						index = tryAgain(index, allHouseholdBudgets.length, "HouseholdBudget");
					
					System.out.print("Which expense do you want to update? (Enter number 0 to " + (allHouseholdBudgets[index].getNbOfExpenses()-1) + "): ");
					int expenseToUpdate = sc.nextInt();
					if (expenseToUpdate < 0 || expenseToUpdate >= allHouseholdBudgets[index].getNbOfExpenses())
						expenseToUpdate = tryAgain(expenseToUpdate, allHouseholdBudgets[index].getNbOfExpenses(), "expense");
					
					System.out.print("--> Enter new payment due day number and month (separated by a space): ");
					int newDueDay = sc.nextInt();
					int newDueMonth = sc.nextInt();
					
					allHouseholdBudgets[index].updateDueDate(expenseToUpdate, newDueMonth, newDueDay);
					System.out.println("Due Date updated");
					
					break;
				
				// Allows the user to add any amounts of currency to any householdBudget's fund
				case 9:
					System.out.print("Which HouseholdBudget do you want to add funds to? "
									+ "(Enter number 0 to " + (allHouseholdBudgets.length - 1) + "): ");
					index = sc.nextInt();
					if (index < 0 || index >= allHouseholdBudgets.length)
						index = tryAgain(index, allHouseholdBudgets.length, "expense");
					
					System.out.print("How many loonies, toonies, $5, $10 and $20 bills do you want to add? "
									+ "\n(Enter 5 numbers separated by a space): " );
					int addLoonies = sc.nextInt();
					int addToonies = sc.nextInt();
					int addB5 = sc.nextInt();
					int addB10 = sc.nextInt();
					int addB20 = sc.nextInt();
					System.out.println("You now have $"
										+ allHouseholdBudgets[index].addFund(addLoonies, addToonies, addB5, addB10, addB20));
					
					break;
				
				case 0:
					break;
				
				// Displays message if user has entered invalid command
				default:
					System.out.println("Sorry, that is not a valid choice. Try again.");
					break;
			}
			
			
		}
		while(userChoice != 0);
		
		// Display thank you message after user has input 0
		System.out.println("Thank you for using COMP248 Geek's HouseholdBudget application!");
		
		// Close the Scanner object
		sc.close();
	}
	
	// Static method to insure user enters a valid input
	public static int tryAgain(int index, int lengthOfArray, String no) {
		System.out.println("Sorry, but there is no " + no + " number " + index);
		do {
			System.out.print("--> Try again, (Enter number 0 to " + (lengthOfArray - 1) + "): ");
			index = sc.nextInt();
		} while (index < 0 || index >= lengthOfArray);
		return index;
	}
	

}
