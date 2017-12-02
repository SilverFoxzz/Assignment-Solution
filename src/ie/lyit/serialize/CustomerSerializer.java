package ie.lyit.serialize;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.nio.file.*;


import ie.lyit.hotel.Customer;

public class CustomerSerializer {

	// Declare ArrayList called customers - for storing a list of books
	private ArrayList<Customer> customers;
	
	// Constant FILENAME for the file to be created
	private final String FILENAME = "customers.ser";
	
	// p references the Path object returned by Paths.get()
	Path p = Paths.get(FILENAME);
	
	// Default Constructor
	public CustomerSerializer(){
		// Construct CustomerList ArrayList
		customers = new ArrayList<Customer>();
	}
	
	//////////////////////////////////////////////////////////
	// Method Name : add()									//
	// Return Type : void									//
	// Parameters : None									//
	// Purpose : Reads in customer details from user and	//
	//			 and adds it to the ArrayList customers		//
	//////////////////////////////////////////////////////////
	public void add() {
		// Create customer object
		Customer customer = new Customer();
		
		customer.setNumber(customers.size()+1);
		// Read the customer details
		customer.read();                ////////// No read method in customer - add
		// And add it to the customers ArrayList
		customers.add(customer);
	}
	
	//////////////////////////////////////////////////////////
	// Method Name : list()									//
	// Return Type : void									//
	// Parameters : None									//
	// Purpose : Lists all customers details in ArrayList	//
	//////////////////////////////////////////////////////////
	public void list() {
		// for every customer object in customers
		for(Customer tmpCustomer:customers) {
			//display it
			System.out.println(tmpCustomer);
		}
	}
	
	//////////////////////////////////////////////////////////////////
	// Method Name : view()											//
	// Return Type : void											//
	// Parameters : None											//
	// Purpose : Displays the required customer details on screen	//
	//		   : And Returns it, or null if not found 				//
	//////////////////////////////////////////////////////////////////
	public Customer view() {
		Scanner keyboard = new Scanner(System.in);
		
		// Read the Customer number to be viewed from the user
		System.out.println("Enter Customer Number: ");
		int customerToView = keyboard.nextInt();
		
		// for every customer in customers
		for(Customer tmpCustomer:customers) {
			// if the name equals name of the customer to view
			if(tmpCustomer.getNumber() == customerToView){
				// display it
				System.out.println(tmpCustomer);
				return tmpCustomer;
			}
		}
		// if we reach this code the book was not found so return null
		return null;
	}
	
	//////////////////////////////////////////////////////////////////
	// Method Name : edit()			  					    		//
	// Return Type : void											//
	// Parameters : None											//
	// Purpose : Edits the required Customer details in customers	//
	//////////////////////////////////////////////////////////////////	
	
	public void edit() {
		// call view() to find, display, & return the customer to edit
		Customer tempCustomer = view();
		// if the customer != null, i.e it was found then
		if(tempCustomer != null) {
			// get its index
			int index = customers.indexOf(tempCustomer);
			// read in the new customer and
			tempCustomer.read();                ////////// No read method in customer - add
			// reset the object in customers
			customers.set(index, tempCustomer);
		}
	}
	
	//////////////////////////////////////////////////////////////////////
	// Method Name : delete()								 			//
	// Return Type : void									 			//
	// Parameters : None												//
	// Purpose : Deletes the required Customer record from customers	//
	//			 Also sets the customer Number back by 1 for all		//
	//           customers above the deleted customer and also makes    //
	//			 sure the next customer is the next on in the sequence	//
	//////////////////////////////////////////////////////////////////////	
	
	public void delete() {
		// call view() to find, display, & return the book to delete
		Customer tempCustomer = view();
		// if the book != null, i.e it was found then
		if(tempCustomer != null) {
			// remove it from customers
			customers.remove(tempCustomer);
		}
		for(Customer tmpCustomer:customers) {
			if(tmpCustomer.getNumber() > tempCustomer.getNumber()) {
				tmpCustomer.setNumber(tmpCustomer.getNumber()-1);
			}
			
		}
	}
	
	//////////////////////////////////////////////////////////////
	// Method Name : writeRecordsToFile()    			 		//
	// Return Type : void										//
	// Parameters : None								 		//
	// Purpose : Writes the ArrayList customers to the   		//
	//		     File Customers.bin before closing the File  	//
	//////////////////////////////////////////////////////////////	
	
	public void writeRecordsToFile() {
		try{
			// Serialize the ArrayList...
			// Call Files static exists() method to ensure p exists
			if(Files.exists(p)) {
			FileOutputStream fileStream = new FileOutputStream(FILENAME);
	
			ObjectOutputStream os = new ObjectOutputStream(fileStream);
	
			os.writeObject(customers);
	
			os.close();
			}
			else {	// file doesn't exist
				System.out.println("File" + p.getFileName() + " doesn't exist");
			}
		}
		//catch(FileNotFoundException fNFE){
		//	System.out.println("Cannot create file to store books.");
		//}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	///////////////////////////////////////////////////////
	// Method Name : readRecordsFromFile()    			 //
	// Return Type : void								 //
	// Parameters : None								 //
	// Purpose : Reads the ArrayList from the File back  //
	//		     into customers before closing the File  //
	///////////////////////////////////////////////////////	
	
	public void readRecordsFromFile() {
		try{
			// Deserialize the ArrayList...
			FileInputStream fis = new FileInputStream(FILENAME);
			
			ObjectInputStream is = new ObjectInputStream(fis);
			
			customers = (ArrayList<Customer>)is.readObject();

			is.close();
		}
		catch(FileNotFoundException fNFE){
			System.out.println("Cannot find books file.");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
