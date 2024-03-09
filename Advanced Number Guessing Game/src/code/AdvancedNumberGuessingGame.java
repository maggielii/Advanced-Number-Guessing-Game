package code;

import java.util.Scanner;

public class AdvancedNumberGuessingGame {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int level = 0, guess, number, min = 1, max, win = 0, lose = 0, attempts, restart = 0, range; 
	
		do
		{
		attempts = 0;
		
		System.out.println("1-Easy 2-Medium 3-Hard");
		do 
		{
			try
			{
				System.out.print("Enter the level you want: ");
				level = input.nextInt();
			}
			catch(Exception e)
			{
				System.out.println("Invalid input");
				input.next();
				level = 0;
			}	
		}while(level != 1 && level != 2 && level != 3);
		System.out.println("______________________________");
		if(level == 1)
		{
			max = 10;
		}
		else if(level == 2)
		{
			max = 100;
		}	
		else 
		{
			max = 1000;
		}			
		
		number = (int)(Math.random()*(max-min + 1)+ min);
		
		do 
		{
			do 
			{
				try
				{
					System.out.print("Enter a number from " + min + " to " + max + ": ");	
					guess = input.nextInt();
				}
				catch(Exception e)
				{
					System.out.println("Invalid input");
					input.next();
					guess = 0;
				}
				
			}while(guess > max || guess < min);
			
			if(guess == number)
			{
				System.out.println("Correct");
				win++;
			}
			else
			{
				range = number/2; 
				if(guess < (number-range) || guess > (number+range))
				{
					System.out.println("Incorrect: Cold");
				}
				else if(guess == (number-range) || guess == (number+range))
				{
					System.out.println("Incorrect: Warm");
				}
				else 
				{
					System.out.println("Incorrect: Hot");
				}
			}
			attempts++;
		}while(attempts < 3 && guess != number);
		
		if(guess != number)
		{
			System.out.println("The correct answer was: " + number);
			lose++;
		}

		System.out.println("______________________________");
		System.out.println("Rounds lost: " + lose);
		System.out.println("Rounds won: " + win);	

		System.out.println("______________________________");
		System.out.println("1-Yes 2-No");		
		do 
		{
			try
			{
				System.out.print("Would you like to play again?: ");
				restart = input.nextInt();
			}
			catch(Exception e)
			{
				System.out.println("Invalid input");
				input.next();
				restart = 0;
			}	
		}while(restart != 1 && restart != 2);
		System.out.println("******************************");
		System.out.println("******************************");
		}while(restart == 1);
		
	}


}
