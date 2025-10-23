package com.transactions;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

import com.filemanagement.FilePath;

public class DepositWithdrawl implements FilePath{
	Scanner sc = new Scanner(System.in);
	String masterPath = MASTER_PATH;
	FileReader fr = null;
	BufferedReader br = null;
	BufferedWriter bw = null;
	FileWriter fw = null;
	
	StringTokenizer st;
	String transPath = TRANS_PATH;
	int choice;
	int depAmt;
	int witAmt;
	long phonenum;
	
	boolean didTransaction;
	//constructor
	public DepositWithdrawl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void depSwitch(int id,String pass) {
		System.out.println("1)DEPOSIT");
		System.out.println("2)WITHDRAWAL");
		System.out.println("3)TRANSACTION REPORT");
		System.out.println("4)EXIT");
		System.out.println("ENTER YOUR CHOICE : ");
		choice = sc.nextInt();
		
		didTransaction = false;
		switch(choice) {
		case 1:
			System.out.println("ENTER DEPOSIT AMOUNT : ");
			depAmt = sc.nextInt();
			didTransaction = true;
			//sc.close();
			break;
		case 2: 
			System.out.println("ENTER WITHDRAWAL AMOUNT : ");
			witAmt = sc.nextInt();
			didTransaction = true;
			//sc.close();
			break;
			
		case 3:
			TransactionReports tr = new TransactionReports();
			DispMinBal dmb = new DispMinBal();
			dmb.dispBal(id, pass);
			tr.viewTransaction(id, pass);
			//return;//prevent so that useless data is not enterd in trans.txt
			break;
		case 4:
			System.exit(0);
		default : 
			System.out.println("INVALID CHOICE");
		//	return;
			
		}
		
		if(didTransaction) {
		transfile(id, pass, depAmt, witAmt);
		//System.out.println("trans text");
		try {
		updateMaster(id, pass, depAmt, witAmt);
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("Transaction successful");
		}
	}
	
	public void transfile(int id ,String pass,int add,int minus) {
		try {
			fw = new FileWriter(transPath,true);
			
			fw.write(String.valueOf(id));
			fw.write("#");
			fw.write(pass);
			fw.write("#");
			fw.write(String.valueOf(add));
			fw.write("#");
			fw.write(String.valueOf(minus));
			fw.write("\n");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public void updateMaster(int id,String pass,int depAmt,int witAmt) {
		File oldFile = new File(masterPath);
		File tempFile = new File("temp_master.txt");
		
		try {
			fr = new FileReader(oldFile);
			br = new BufferedReader(fr);
			fw = new FileWriter(tempFile);
			bw = new BufferedWriter(fw);
			String data = br.readLine();
			
			String contact = String.valueOf(phonenum);
			while(data !=null) {
				st = new StringTokenizer(data,"#");
				int custId = Integer.parseInt(st.nextToken());
				String name = st.nextToken();
				String sname = st.nextToken();
				String password = st.nextToken();
				int age = Integer.parseInt(st.nextToken());
				contact = st.nextToken();
				int minBal = Integer.parseInt(st.nextToken());
				
				if(custId == id && password.equals(pass)) {
					minBal += depAmt;
					minBal -= witAmt;
				}
				data=br.readLine();
				
				fw.write(String.valueOf(custId));
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
				//data = br.readLine();
				/*
				bw.write(String.valueOf(custId)+"#"+name+"#"+sname+"#"+password+"#"+String.valueOf(age)+"#"+contact+"#"+String.valueOf(minBal));
				bw.newLine();
				//data = br.readLine();
				*/
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//Replacing oldfile with newfile
		System.gc();
		
		/*
		boolean deleted = oldFile.delete();
	    boolean renamed = tempFile.renameTo(oldFile);

	    System.out.println("Delete success: " + deleted);
	    System.out.println("Rename success: " + renamed);

	    if (deleted && renamed) {
	        System.out.println("Master file updated successfully.");
	    } else {
	       
	}*/
		if(oldFile.delete() && tempFile.renameTo(oldFile)) {
			System.out.println("Successfully Updated");
		}else {
			System.out.println("failed");
		}
		
		/*
		oldFile.delete();
		tempFile.renameTo(oldFile);*/
		
	
}
	}
