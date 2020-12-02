package com.LockApp.util;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import com.LockApp.operations.BusinessOperations;
import com.LockApp.operations.LockAppConstansts;

public class BusinessOperationsImpl implements BusinessOperations {

	@Override
	
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
	

	@Override
	public void addFiles(String fileName)
	{
		//System.out.println("---To Add Files ----");
		
		File fin=new File(LockAppConstansts.Directory.concat(File.separator).concat(fileName));
		try {
			
			if(fin.exists())
				
			{
				System.out.println("File Exist already "+fin.getName()+",Choose another file name");
			}else
			{
			if(fin.createNewFile()) {
				System.out.println(fin.getName()+" File got created Sucessfully");
				
				//StringBuilder strb=new StringBuilder();
				
				
			
			}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean deleteFile(String fileName,String directory) throws Exception
	{
				boolean sFlag=false;
		File fin=new File(directory.concat(File.separator).concat(fileName));
		
		try {
			System.out.println("Deleting file ----"+fin.getAbsolutePath());
			if(fin.exists()) {
				if(fin.delete()) {
				System.out.println("File got deleted Sucessfully: "+fin.getName());
				sFlag=true;
				return sFlag;
				}else {
					return sFlag;
				}
			}else {
				fin=new File(directory);
				File [] listFiles=fin.listFiles();
		for(File fn:listFiles)
		{
		
			if(fn.isDirectory())
			{
				sFlag=deleteFile(fileName,fn.getAbsolutePath());
			}
			
		}
		}
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception("Error in File Deletion");
		}
		return sFlag;
	}
	

	@Override
	public boolean searchFile(String input,String directory) {
		boolean sFlag=false;
		//System.out.println("--To Search File ---");
		
		File fin=new File(directory);
		
		File [] listFile=fin.listFiles();
		
		for(File fn:listFile)
		{
			if(fn.isDirectory())
			{
				sFlag=searchFile(input,fn.getAbsolutePath());
				}else
			{
				if(fn.getName().contains(input))
				{
					System.out.println("Got  the  File successfully : "+fn.getAbsolutePath());
					sFlag=true;
					break;
				}
			}
			
			
		}
		/*for(String fName:fin.list())
		{
			if(fName.contains(input))
			{
				System.out.println("Got  the  File successfully : "+fName);
				sFlag=true;
				break;
			}
			
			
		}*/
		
		return sFlag;
	}

}
