package com.LockApp.Apps;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import com.LockApp.operations.BusinessOperations;
import com.LockApp.operations.LockAppConstansts;
import com.LockApp.operations.Message;
import com.LockApp.util.BusinessOperationsImpl;
import com.LockApp.util.MessageImpl;

public class LockApplication {
	int boptions;
	int moptions;
	Scanner scan=new Scanner(System.in);
	Message msg=new MessageImpl();
	BusinessOperations ops=new BusinessOperationsImpl();
	void resetOptions()
	{
		boptions=3;
		moptions=3;
	}
	
	 void init()
	{
		File fin =new File(LockAppConstansts.Directory);
		if(fin.isDirectory())
		{
			//System.out.println("Directory already exist");
		}else
		{
			if(fin.mkdir())
			{
				System.out.println("Root Directory Created for  : "+fin.getAbsolutePath());
			}
			
		}
	}
	public LockApplication()
	{
		init();
		resetOptions();
	}
	
	 String getInput(String Msg )
	{
		System.out.print(Msg+"->");
		
		//Scanner scan=new Scanner(System.in);
		String readOption=scan.nextLine();
		return readOption;
	}
	
	 boolean mainMenu(String readOption) throws Exception
	{
		
		
		switch(readOption)
		{
		case "1":ops.listFiles(LockAppConstansts.Directory);
		resetOptions();
		
		return true;
					
		case "2":
			resetOptions();
			String input="";
			msg.displayOpsMsg();
				while(!(input=getInput("Enter Options for Business-Level Ops")).equalsIgnoreCase("9")) {
					if(input.equalsIgnoreCase("B"))
					{
						System.out.println("Going Back to Main Menu");
						msg.displayMainMsg();
						break;
					}
				if(!businessOperations(input))
					break;
				
			}
				return input.equalsIgnoreCase("9")?false:true;
			

		default:
			
			if(moptions>0)
			{
			
			System.out.println("Invalid option, you have "+moptions+" chances to enter correct option \n"+ "Choose from belwo options");
			msg.displayMainMsg();
			moptions--;
		return true;
			}else		{
			System.out.println("Selected Invalid Options");
			return false;
			
			
			
		}
			


		}
	}
	
	private boolean businessOperations(String readOption) throws Exception
	{
		
		switch(readOption)
		{
		case "1":
			resetOptions();
			ops.addFiles(getInput("Enter FileName to Add"));	
			return true;
					
		case "2":
			resetOptions();
			if(!ops.deleteFile(getInput("Enter File Name to Delete"),LockAppConstansts.Directory))
			System.out.println("No file exist to delete"); 
			return true;
	
		case "3":
			resetOptions();
			if(!ops.searchFile(getInput("Enter Filename to Search"),LockAppConstansts.Directory))
				System.out.println("File not Found");
		return true;

		default:
			
			if(boptions>0)
			{
				
			System.out.println("Invalid option, you have "+boptions+" chances to enter correct option \n"+ "Choose from belwo options");
			msg.displayOpsMsg();
			boptions--;
			return true;
			}else
		
		{
			System.out.println("Selected Invalid Options");
						return false;
		}


		}
	}
	
	public void runApplication()
	{
		System.out.println("******** Welcome to Company Lockers Pvt. Ltd ********");
		System.out.println("******** Developed by Shiva Kumar Pala********");
		System.out.println("========================================================");
		System.out.println("\t******Select below options to Navigate LockApp********");
		String readOption="";
			msg.displayMainMsg();
			
			try
			{
			while(!(readOption=getInput("Enter Options for Main Menu")).equalsIgnoreCase("9"))
			{
				
				if(!mainMenu(readOption))
				{
					msg.displayExitMsg();
					break;
				}
				
			}
			}catch(Exception ex)
			{
				System.out.println("Got Error while processing the Application: "+ex.getMessage());
			ex.printStackTrace();
			}
		System.out.println("End of Lock Application , Rerun the Application");
			
			
	}
	

}
