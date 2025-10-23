package com.maintab;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.filemanagement.FilePath;
import com.filemanagement.IdUpdation;

public class BankSignUp implements FilePath{
		
	//properties 
	
	String name;
	String sname;
	String password;
	int age;
	Long phonenum;
	int minBal;
	//FilePath interface
	String filePath = FILE_PATH;
	//Object created of IdUpdation class
	IdUpdation idgen = new IdUpdation();
	Scanner sc = new Scanner(System.in);
	int custid;
	FileWriter fw =	null ;

	
	//constructor
	public BankSignUp() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public void signUpData() {
		
		try {
			custid  = idgen.updateId(filePath); 
			System.out.println("\t\tBANK SIGN-UP");
			System.out.println("Enter  Name : ");
			name = sc.nextLine();
			System.out.println("Enter Surname : ");
			sname = sc.nextLine();
			System.out.println("Enter PASSWORD : ");
			password = sc.nextLine();
			System.out.println("Enter Age : ");
			age = sc.nextInt();
			System.out.println("Enter Phone Number : ");
			phonenum = sc.nextLong();
			System.out.println("Enter Minimum Balance to add : ");
			System.out.print("Rs ");
			minBal = sc.nextInt();
			
			
			String contact = String.valueOf(phonenum);
			
			fw = new FileWriter("masterfile.txt",true);
			
			fw.write(String.valueOf(custid));
			fw.write("#");
			fw.write(name);
			fw.write("#");
			fw.write(sname);
			fw.write("#");
			fw.write(password);
			fw.write("#");
			fw.write(String.valueOf(age));
			fw.write("#");
			fw.write(contact);
			fw.write("#");
			fw.write(String.valueOf(minBal));
			fw.write("\n");
			System.out.println("SIGN-UP SUCCESSFUL");
			System.out.println("Your Customer ID : "+custid+"\n\n");
		//	System.out.println("PLEASE RUN THE PROGRAM AGAIN TO SIGN-IN");
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//sc.close();		
		}
		
	
	}
}
