package com.transactions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import com.filemanagement.FilePath;

public class TransactionReports implements FilePath {



String transPath = TRANS_PATH;

//cons
public TransactionReports() {
	super();
	// TODO Auto-generated constructor stub
}

//method
public void viewTransaction(int id,String pass) {
	ArrayList<String> transactionList = new ArrayList<String>();
	FileReader fr = null;
	BufferedReader br = null;
	transactionList.clear();//clears previous data
	
	
	try {
		fr = new FileReader(transPath);
		br = new BufferedReader(fr);
		String data = br.readLine();
		while(data!=null){
		StringTokenizer st = new StringTokenizer(data,"#");
		
		//System.out.println(data);
		int transId = Integer.parseInt(st.nextToken());
		String transPass = st.nextToken();
		String deposit = st.nextToken();
		String withdrawal = st.nextToken();
		
		if(transId == id && transPass.trim().equals(pass)) {
			transactionList.add("Deposit : "+deposit+", Withdrawal : "+withdrawal);
			}
		data = br.readLine();
		}
		//data = br.readLine();
	}catch(IOException ioe) {
		ioe.printStackTrace();
	}finally {
		try {
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	if(transactionList.isEmpty()) {
		System.out.println("No Transaction Found for this User");
	}else {
		System.out.println("\nTRANSACTION HISTORY : \n");
		for(String history : transactionList) {
			System.out.println(history);
		}
	}
	
}




}
