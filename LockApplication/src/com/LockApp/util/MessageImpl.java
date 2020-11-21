package com.LockApp.util;

import com.LockApp.operations.Message;

public class MessageImpl implements Message {

	@Override

	public void displayExitMsg()
	{
		System.out.println("Existing LockerApplication");
		
		
	}



	@Override
	public void displayMainMsg()
	{
	
		System.out.println("||\t\t************Main Menu****************\t\t||");	
		System.out.println("||\t\tSelect 1 To List all Files in User Account\t\t||");
		System.out.println("||\t\tSelect 2 To Do Business Level Operation   \t\t||");
		System.out.println("||\t\tSelect 9 To Exit LockApplication          \t\t||");
			
	}
	@Override
	public void displayOpsMsg()
	{
		System.out.println("\t******Select below option for respective business operations*****\t");
		System.out.println("||\t\tSelect 1 To Add new file in  the User Account\t\t||");
		System.out.println("||\t\tSelect 2 To Delete the file in Application   \t\t||");
		System.out.println("||\t\tSelect 3 To Search file in Application       \t\t||");
		System.out.println("||\t\tSelect \"B\" To go Back to Main Menu         \t\t||");
		System.out.println("||\t\tSelect \"9\" To Exit LockApplication         \t\t||");
		

	}
	

}
