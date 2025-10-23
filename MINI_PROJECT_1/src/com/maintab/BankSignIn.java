package com.maintab;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

import com.filemanagement.FilePath;
import com.transactions.DepositWithdrawl;

public class BankSignIn implements FilePath {
	//properties 
	String filePath = MASTER_PATH;
	FileReader fr = null;
	BufferedReader br = null;
	StringTokenizer st;
	public int signid ;
	public String signPass;
	DepositWithdrawl dw = new DepositWithdrawl();
	boolean loginSuccess = false;
	BankSignUp bsp;
	//constructor
	public BankSignIn() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//method
	public void signin(){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\t\tBANK SIGN-IN");
		System.out.println("Enter Customer ID : ");
		signid = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter PASSWORD : ");
		signPass = sc.nextLine().trim(); //trim remove extra spaces
		
		try {
			fr = new FileReader(filePath);
			br = new BufferedReader(fr);
			String data ;
			
			
			while((data = br.readLine()) != null) {
				st = new StringTokenizer(data,"#");
				int id = Integer.parseInt(st.nextToken());
				st.nextToken();
				st.nextToken();
				String password = st.nextToken();
				//System.out.print(data);
				
				if(id == signid && password.equals(signPass)) {
					loginSuccess = true;
					break;
			}
		}data = br.readLine();
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
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
		}
		if(loginSuccess) {
			System.out.println("LOGIN SUCCESSFUL");
			dw.depSwitch(signid,signPass);
		}else {
			System.out.println("LOGIN FAILED");
		}
		sc.close();
	}
		
	
		
}


