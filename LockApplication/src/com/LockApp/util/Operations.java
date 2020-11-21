package com.LockApp.util;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import com.LockApp.operations.LockAppConstansts;

public class Operations {
	Scanner scan=new Scanner(System.in);
	//private int invalid=3;
	
	
	public void init()
	{
		File fin =new File(LockAppConstansts.Directory);
		if(fin.isDirectory())
		{
			System.out.println("Directory already exist");
		}else
		{
			if(fin.mkdir())
			{
				System.out.println("Directory created");
			}
			
		}
	}
	public void listFiles(String Directory)
	{
		File fin =new File(Directory);
		
		int iCounter=1;
		String [] listFileNames=fin.list();
		Arrays.sort(listFileNames);
		if(listFileNames.length>0)
		{
			System.out.println("List of Files ");
		for(String fileName:listFileNames)
		{
			System.out.println(iCounter+". "+fileName);
			iCounter++;
		}
		
		}else
		{
			System.out.println("No Files to Return,Add files through Business operations");
		}
	}
	
	public void displayMainMsg()
	{
	
		System.out.println("||\t\t************Main Menu****************\t\t||");	
		System.out.println("||\t\tSelect 1 To List all Files in User Account\t\t||");
		System.out.println("||\t\tSelect 2 To Do Business Level Operation   \t\t||");
		System.out.println("||\t\tSelect 9 To Exit LockApplication          \t\t||");
			
	}
	
	public void displayOpsMsg()
	{
		System.out.println("\t******Select below option for respective business operations*****\t");
		System.out.println("||\t\tSelect 1 To Add new file in  the User Account\t\t||");
		System.out.println("||\t\tSelect 2 To Delete the file in Application   \t\t||");
		System.out.println("||\t\tSelect 3 To Search file in Application       \t\t||");
		System.out.println("||\t\tSelect \"B\" To go Back to Main Menu         \t\t||");
		System.out.println("||\t\tSelect \"9\" To Exit LockApplication         \t\t||");
		

	}
	
	public String getInput(String Msg )
	{
		System.out.print(Msg+"->");
		
		//Scanner scan=new Scanner(System.in);
		String readOption=scan.nextLine();
		return readOption;
	}
	
	public boolean mainMenu(String readOption)
	{
		int invalid=3;
		
		switch(readOption)
		{
		case "1":listFiles(LockAppConstansts.Directory);
		
		return true;
					
		case "2":
			String input="";
			displayOpsMsg();
				while(!(input=getInput("Enter Options for Business-Level Ops")).equalsIgnoreCase("9")) {
					if(input.equalsIgnoreCase("B"))
					{
						System.out.println("Going Back to Main Menu");
						displayMainMsg();
						break;
					}
				if(!businessOperations(input))
					break;
				
			}
				return input.equalsIgnoreCase("9")?false:true;
			

		default:
			
			if(invalid>0)
			{
			
			System.out.println("Invalid option, you have "+invalid+" chances to enter correct option \n"+ "Choose from belwo options");
			displayMainMsg();
		invalid--;
		return true;
			}else		{
			System.out.println("Selected Invalid Options");
			return false;
			
			
			
		}
			


		}
	}
	
	public void addFiles()
	{
		//System.out.println("---To Add Files ----");
		
		File fin=new File(LockAppConstansts.Directory.concat(File.separator).concat(getInput("Enter FileName to Add")));
		try {
			if(fin.createNewFile()) {
				System.out.println(fin.getName()+" File got created Sucessfully");
				
				//StringBuilder strb=new StringBuilder();
				
				
			
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteFile()
	{
				
		File fin=new File(LockAppConstansts.Directory.concat(File.separator).concat(getInput("Enter File Name to Delete")));
		try {
			if(fin.exists()&&fin.delete()) {
				System.out.println("File got deleted Sucessfully: "+fin.getName());
				
				//StringBuilder strb=new StringBuilder();
				
				
			
			}
			else {
				System.out.println("File Name does not exist"+fin.getName());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public boolean searchFile()
	{
		boolean sFlag=false;
		//System.out.println("--To Search File ---");
		String userName=getInput("Enter Filename to Search");
		File fin=new File(LockAppConstansts.Directory);
		for(String fName:fin.list())
		{
			if(fName.contains(userName))
			{
				System.out.println("Got  the  File successfully : "+fName);
				sFlag=true;
				break;
			}
			
		}
		
		return sFlag;
	}
	public boolean businessOperations(String readOption)
	{
		int invalid=3;
		switch(readOption)
		{
		case "1":addFiles();	
		System.out.println("End of option 1");
					return true;
					
		case "2":
			System.out.println("Start of Option 2");
			 deleteFile();
			 return true;
	
		case "3":
			
			if(!searchFile())
				System.out.println("File not Found");
		return true;

		default:
			
			if(invalid>0)
			{
				
			System.out.println("Invalid option, you have "+invalid+" chances to enter correct option \n"+ "Choose from belwo options");
			displayOpsMsg();
			invalid--;
			return true;
			}else
		
		{
			System.out.println("Selected Invalid Options");
						return false;
		}


		}
	}
	
	
	public void displayExitMsg()
	{
		System.out.println("Existing LockApplication");
		
		
	}

}
