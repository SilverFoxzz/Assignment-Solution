//////////////////////////////////////////////////////
//class Menu                     //
//– This class contains the Menu for the system - //
//////////////////////////////////////////////////////
package ie.lyit.hotel;

import java.util.Scanner;

public class Menu {
	private int option;

	public void display(){
		System.out.println("\t1. Add");
		System.out.println("\t2. List");
		System.out.println("\t3. View");
		System.out.println("\t4. Edit");
		System.out.println("\t5. Delete");
		System.out.println("\t6. Quit");		
	}

	public void readOption(){
		Scanner kbInt = new Scanner(System.in);
		System.out.println("\n\tEnter Choice from above :");
		option=kbInt.nextInt();
		//kbInt.close();
	}

	public int getOption(){
		return option;
	}	
}