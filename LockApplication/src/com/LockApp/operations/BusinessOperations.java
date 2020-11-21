/**
 * 
 */
package com.LockApp.operations;

/**
 * @author shpala
 *
 */
public interface BusinessOperations {
	public void listFiles(String Directory);
	public void addFiles(String FileName);
	public boolean deleteFile(String fileName,String directory) throws Exception;
	public boolean searchFile(String input,String directory);
}
