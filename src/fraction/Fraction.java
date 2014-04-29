package fraction;

import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class Fraction {
	
	// Stores fraction data
	public int numerator;
	public int denominator;
	
	/* Default Constructor: Creates a new Fraction object and initialize 
	   it with invalid data */
	
	public Fraction()
	{
		numerator = denominator = 0;
	}
	
	/* Method Addition: Add two fractions, where 1st one is the "this" object
	 * and addit is the passed as the input parameter. The result is stored in sum.
	 */
	
	public Fraction add(Fraction addit)
	{
		// checking conditions for if denominator is 0 
		if((denominator==0) || (addit.denominator==0))
			throw new IllegalArgumentException("Invalid denominator");
		
		//find the lowest common denominator
		int common = lcd(denominator, addit.denominator);
		Fraction common1 = new Fraction();
	    Fraction common2 = new Fraction();
	    
	    common1 = convert(common);
	    common2 = addit.convert(common);
	    
	    Fraction sum = new Fraction();
	    
	    //calculate the sum of fractions
	    sum.numerator = common1.numerator + common2.numerator;
	    sum.denominator = common;
	    //reduce the resulting fraction
	    sum = sum.reduce();
	    // checking for the numerator and denominator as 1
	    if(sum.numerator ==1 && sum.denominator ==1)
			System.out.println("The result of the operation is 1");
		else
		    System.out.println("Move Ahead with the answer");
	    System.out.println("The result of the addition = " + sum.numerator + "/" + sum.denominator);
	    return sum;
		
	}
	
	/* Method Subtraction: Subtract two fractions, where 1st one is the "this" object
	 * and 2nd fraction is passed as the input parameter. The result is stored in diff. 
	 */
	
	public Fraction subtract(Fraction subit)
	{
		//checking conditions for if either of the denominator is 0
		if((denominator==0) || (subit.denominator==0))
			throw new IllegalArgumentException("Invalid denominator");
		
		//find the lowest common denominator
		int common = lcd(denominator, subit.denominator);
		
		Fraction common1 = new Fraction();
		Fraction common2 = new Fraction();
		
		common1 = convert(common);
		common2 = subit.convert(common);
		
		Fraction diff = new Fraction();
		//calculate the difference of fractions
		diff.numerator = common1.numerator - common2.numerator;
		diff.denominator = common;
		//reduce the resulting fraction
		diff = diff.reduce();
		
		if(diff.numerator == 0)
			System.out.println("The result of the operation is 0");
		System.out.println("The result of the subtraction = " + diff.numerator + "/" + diff.denominator);
		return diff;
		
	}
	
	/* Method Multiplication: Multiplies two fractions, where the 1st fraction is "this" object
	 * and the 2nd fraction is passed as the input parameter. The result is stored in product.
	 */
	
	public Fraction multiply(Fraction mult)
	{
		//int reuslt = 0;
		// checking for conditions if either of the denominator is 0
		if((denominator == 0) || (mult.numerator == 0))
			throw new IllegalArgumentException("Invalid denominatorinator");
		Fraction product = new Fraction(); 
		//calculate product
		product.numerator = numerator * mult.numerator;
		product.denominator = denominator * mult.denominator;
		//reduce the resulting fraction.
		product = product.reduce();
		
		System.out.println("The result of the multiplication = " + product.numerator + "/" + product.denominator );
		return product;
		
		
	}
	
	/* Method division: Divides two fractions, where the 1st fraction is "this" object
	 * and the 2nd fraction is passed as the input parameter. The result is stored in divResult.
	 */
	
	public Fraction division(Fraction div)
	{
		// checking conditions for if either of the denominator is 0.
		if((denominator == 0) || (div.numerator == 0))
			throw new IllegalArgumentException("Invalid denominatorinator");
		Fraction divResult = new Fraction();
		//calculate division.
		divResult.numerator = numerator * div.denominator;
		divResult.denominator = denominator * div.numerator;
		//reduce the resulting fraction.
		divResult = divResult.reduce();
		System.out.println("The result of the division = " + divResult.numerator + "/" + divResult.denominator);
		return divResult;
		
	}
	
	/* Method GreatLessThan: This method checks whether the Fraction 1 > Fraction 2 or
	 * Fraction 1 = Fraction 2 or Fraction 1 < Fraction 2.
	 */
	
	public Fraction GreatLessThan(Fraction grtlessthn)
	{
		Fraction Greater = new Fraction();
		//condition for Fraction 1 > Fraction 2.
		if(numerator * grtlessthn.denominator > denominator * grtlessthn.numerator)
		    System.out.println("The Fraction 1 is GREATER");
		
		// condition for Fraction 1 = Fraction 2.
		else if(numerator * grtlessthn.denominator == denominator * grtlessthn.numerator)
			System.out.println("The Fractions are EQUAL");
		
		// condition for Fraction 1 < Fraction 2.
		else 
			System.out.println("The Fraction 2 is GREATER");
		return Greater;
		
	}
	/* Method equals: This method checks if the two fractions are equal by checking the
	 * values of numerators and denominators of the two fractions.
	 */
	
	public void equals(Fraction f)
	{
		if(numerator == f.numerator && denominator == f.denominator)
			System.out.println("The fractions are equal");
		else
			System.out.println("The fractions are not equal");
			
	}
	
	/* Method lcd: This method finds the lowest common denominator of the two fractions.
	 * LCD is used in addition and subtraction of the fractions.
	 */
	public int lcd(int denominator1, int denominator2)
	{
		int factor = denominator1;
		// condition for calculating lcd till we get the result.
		while((denominator1 % denominator2) != 0)
			denominator1 = denominator1 + factor;
		return denominator1;
	}
	
	/* Method convert: This method is used to convert the resulting fraction to an 
	 * equivalent one based on lcd.
	 */
	
	public Fraction convert(int common)
	{
		Fraction result = new Fraction();
		int factor = common/denominator;
		
		result.numerator = numerator * factor;
		result.denominator = common;
		
		return result;
	}
	
	/* Method gcd: This method is used to calculate the greatest common denominator 
	 * which is used in reducing the fractions.
	 */
	
	public int gcd(int denom1, int denom2)
	   {
	      int factor = denom2;
	      while (denom2 != 0) {
	         factor = denom2;
	         denom2 = denom1 % denom2;
	         denom1 = factor;
	      }
	      return denom1;
	   }
	
	/* Method reduce: This method converts the resulting fraction based upon the gcd.
	 * 
	 */
	
	public Fraction reduce()
	{
		Fraction afterReduce = new Fraction();
		int flag = 0;
		//get absolute values for numerator and denominator.
		int num = Math.abs(numerator);
		int denom = Math.abs(denominator);
		//conditions for checking which is less
		if(num > denom)
			flag = gcd(num, denom);
		else if (num < denom)
			flag = gcd(denom, num);
		// condition for checking if the numerator and denominator are same. No need to call gcd.
		else
			flag = num;
		// set the resulting fraction based upon the gcd values.
		afterReduce.numerator = numerator/flag;
		afterReduce.denominator = denominator/flag;
		return afterReduce;
	}
			
    /* Method userInput: This method gets the values of the inputs from the user 
     * via keyboard for both the fractions.
     */
	public void userInput()
	{
		// prompt for entering a non-zero numerator
		System.out.println("Please enter a non-zero integer for numerator: ");
		Scanner s = new Scanner(System.in);
		
		numerator = s.nextInt();
		// prompt for entering a non-zero denominator.
		do {
		
		System.out.println("Please enter a value for denominator: ");
		denominator = s.nextInt();
		// Flagging an error message upon entering the denominator as 0.
		if(denominator==0)
		{
			JOptionPane op = new JOptionPane( "Denominator can not be 0", JOptionPane.ERROR_MESSAGE);
			JDialog dialog = op.createDialog("Error	");
			dialog.setAlwaysOnTop(true);
			dialog.setVisible(true);
		    
		}
		} while(denominator ==0);
		
	}
	
	/* Method printFrac: This method is used to print the fractions and the result of each operation
	 *  using "/". 
	 */
	
	public void printFrac(PrintWriter output){
		
		output.print(numerator + "/" + denominator);
		
	}
	
}
 