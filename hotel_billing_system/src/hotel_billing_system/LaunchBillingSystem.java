package hotel_billing_system;

import java.util.ArrayList;
import java.util.Scanner;

class Hotel {
	String userName;
	int itemID;
	String itemName;
	int itemQuantity; 
	int itemPrice;
	int subTotal = 0; 
	String choice = "y";
	int grandTotal = 0;
	
	ArrayList <Bill> newItem = new ArrayList<Bill>();
	
	void greeting() {
		System.out.println("Welcome to Hotel S");
		System.out.println("Dear customer, please enter your name:");
		Scanner s = new Scanner(System.in);
		userName = s.nextLine();
	}
	
	void printMenu() {
		
		while (choice.equals("y")) {
			System.out.println("Dear " + userName + ", please see our menu below:\n ");
			System.out.println("------------------------------------------------\n" + 
								"ItemID           ItemName             ItemPrice\n" +
								"------------------------------------------------\n" +
								"1                  Water                   10\n" + 
								"2                  Pepsi                   25\n" +
								"3                  Pizza                   50\n" +
								"4                  Fries                   35\n" +
								"5                  Pasta                   60\n" +
								"-----------------------------------------------\n" +
								"6 - View Current Bill\n" +
								"0 - Exit\n");
			
			Scanner s = new Scanner(System.in);
			System.out.println("Please enter the Item ID");
			itemID = s.nextInt();
			s.nextLine();
			
			System.out.println("Please enter the quantity");
			itemQuantity = s.nextInt();
		
			switch (itemID) {
				case 1:
					itemName = "Water";
					itemPrice = 10;
					subTotal = itemPrice * itemQuantity;
					break;
				case 2: 
					itemName = "Pepsi";
					itemPrice = 25;
					subTotal = itemPrice * itemQuantity;
					break;
				case 3: 
					itemName = "Pizza";
					itemPrice = 50;
					subTotal = itemPrice * itemQuantity;
					break;
				case 4: 
					itemName = "Fries";
					itemPrice = 35;
					subTotal = itemPrice * itemQuantity;
					break;
				case 5: 
					itemName = "Pasta";
					itemPrice = 60;
					subTotal = itemPrice * itemQuantity;
					break;
	
				default: 
					System.out.println("Invalid selection, going back to Main Menu...\n");
					printMenu();
					break;
			}
			System.out.println("You have selected " + itemName + 
					", at the price of $" + itemPrice + 
					", and a total quantity of " + itemQuantity + 
					". Your subtotal will be: $" + subTotal);	
		
			grandTotal += subTotal;
			newItem.add(new Bill(itemName, itemPrice, itemQuantity, subTotal));
			System.out.println("Do you want to order more? Y / N");
			choice = s.next().toLowerCase();
		}
		System.out.println("_______________________________________________________");
		System.out.println("Item Name    Item Price     Item Quantity     SubTotal ");
		System.out.println("_______________________________________________________");
		for (Bill x : newItem) {
			System.out.println(x);
		}
		System.out.println("_______________________________________________________");
		System.out.println("Dear " + userName + ", your total bill is $" + grandTotal);
		System.out.println("_______________________________________________________");
	}
}


class Bill {
	String itemName; 
	int itemQuantity; 
	int itemPrice; 
	int subTotal;
	
	public Bill(String itemName, int itemQuantity, int itemPrice, int subTotal) {
		super();
		this.itemName = itemName;
		this.itemQuantity = itemQuantity;
		this.itemPrice = itemPrice;
		this.subTotal = subTotal;
	}

	@Override
	public String toString() {
		return itemName + "             " + itemPrice + "             " + itemQuantity + "           " + subTotal;
	} 	
	
	
}

public class LaunchBillingSystem {

	public static void main(String[] args) {
		Hotel s = new Hotel();
		s.greeting();
		s.printMenu();
	}

}
