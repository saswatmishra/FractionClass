package fraction;

import java.io.PrintWriter;
//import java.util.Scanner;

public class FractionTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//boolean equal = false;
		// Using PrintWriter to print formatted representations of objects to a text-output stream
		PrintWriter stdout = new PrintWriter(System.out, true);	
		Fraction f1 = new Fraction(); // local function object
		Fraction f2 = new Fraction(); // 2nd fraction for testing methods.
		
		// Storing the result of each operation. 
		Fraction result = new Fraction();
		
		
		System.out.println("Fraction 1: ");
		f1.userInput();
		System.out.println("-------------------------------");
		
		System.out.println("Fraction 2: ");
		f2.userInput();
		System.out.println("-------------------------------");
		
		result = f1.add(f2);
		result.printFrac(stdout);
		stdout.println();
		System.out.println("-------------------------------");
		
		result = f1.subtract(f2);
		result.printFrac(stdout);
		stdout.println();
		System.out.println("--------------------------------");
		
		result = f1.multiply(f2);
		result.printFrac(stdout);
		stdout.println();
		System.out.println("-------------------------------");
		
		f1.GreatLessThan(f2);
		System.out.println("-------------------------------");
		
		result = f1.division(f2);
		result.printFrac(stdout);
		stdout.println();
		System.out.println("-------------------------------");
		
		f1.equals(f2);
		
		}

}
