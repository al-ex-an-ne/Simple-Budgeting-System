

public class Fund {
	
	// Fund attributes
	private int nbOfLoonies;
	private int nbOfToonies;
	private int nbOfB5;
	private int nbOfB10;
	private int nbOfB20;
	private static int loonies = 1;
	private static int toonies = 2;
	private static int b5 = 5;
	private static int b10 = 10;
	private static int b20 = 20;
	
	// Default constructor
	public Fund() {}
	
	// Constructor with all attributes of fund as parameters
	public Fund(int nbOfLoonies, int nbOfToonies, int nbOfB5, int nbOfB10, int nbOfB20) {
		this.nbOfLoonies = nbOfLoonies;
		this.nbOfToonies = nbOfToonies;
		this.nbOfB5 = nbOfB5;
		this.nbOfB10 = nbOfB10;
		this.nbOfB20 = nbOfB20;
	}
	
	// Copy constructor
	public Fund(Fund otherFund) {
		nbOfLoonies = otherFund.nbOfLoonies;
		nbOfToonies = otherFund.nbOfToonies;
		nbOfB5 = otherFund.nbOfB5;
		nbOfB10 = otherFund.nbOfB10;
		nbOfB20 = otherFund.nbOfB20;
	}
	
	// Mutator for the amount of loonies in the fund
	public void setNbOfLoonies(int nbOfLoonies) {
		this.nbOfLoonies = nbOfLoonies;
	}
	
	// Mutator for the amount of toonies in the fund
	public void setNbOfToonies(int nbOfToonies) {
		this.nbOfToonies = nbOfToonies;
	}
	
	// Mutator for the amount of 5$ bills in the fund
	public void setNbOfB5(int nbOfB5) {
		this.nbOfB5 = nbOfB5;
	}
	
	// Mutator for the amount of 10$ bills in the fund
	public void setNbOfB10(int nbOfB10) {
		this.nbOfB10 = nbOfB10;
	}
	
	// Mutator for set the amount of 20$ bills in the fund
	public void setNbOfB20(int nbOfB20) {
		this.nbOfB20 = nbOfB20;
	}
	
	// Accessor for the amount of loonies in the fund
	public int getNbOfLoonies() {
		return nbOfLoonies;
	}
	
	// Accessor for the amount of toonies in the fund
	public int getNbOfToonies() {
		return nbOfToonies;
	}
	
	// Accessor for the amount of 5$ in the fund
	public int getNbOfB5() {
		return nbOfB5;
	}
	
	// Accessor for the amount of 10$ in the fund
	public int getNbOfB10() {
		return nbOfB10;
	}
	
	// Accessor for the amount of 20$ in the fund
	public int getNbOfB20() {
		return nbOfB20;
	}
	
	// Method to add certain amounts of currency to the fund
	public void addFund(int nbOfLoonies, int nbOfToonies, int nbOfB5, int nbOfB10, int nbOfB20) {
		this.nbOfLoonies += nbOfLoonies;
		this.nbOfToonies += nbOfToonies;
		this.nbOfB5 += nbOfB5;
		this.nbOfB10 += nbOfB10;
		this.nbOfB20 += nbOfB20;
	}
	
	// Method to get the total amount of money in the fund
	public int fundTotal() {
		int total = (nbOfLoonies*loonies)+(nbOfToonies*toonies)+(nbOfB5*b5)+(nbOfB10*b10)+(nbOfB20*b20);
		return total;
	}
	
	// Method to get the fund breakdown as a string
	public String toString() {
		String fundDenomination = "(" + nbOfLoonies + " x $" + loonies + ") + (" +  
								nbOfToonies + " x $" + toonies + ") + (" + nbOfB5 + " x $" + b5 +
								") + (" + nbOfB10 + " x $" + b10 + ") + (" + nbOfB20 + " x $" + b20 + ")";
		return fundDenomination;
	}
	
	// Method to check if another fund has the same fund breakdown
	public boolean equals(Fund otherFund) {
		if (nbOfLoonies == otherFund.nbOfLoonies && nbOfToonies == otherFund.nbOfToonies &&
				nbOfB5 == otherFund.nbOfB5 && nbOfB10 == otherFund.nbOfB10 && nbOfB20 == otherFund.nbOfB20)
			return true;
		else
			return false;
	}

}
