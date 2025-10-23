package com.maintab;

import java.util.Scanner;

public class SwitchMain {
	//properties
	
	
	Scanner sc = new Scanner(System.in);
	int val;
	//constructor
	public SwitchMain() {
		super();
		// TODO Auto-generated constructor stub
	}
	//method
	public void mainCon() {
	while(true) {
		System.out.println("\t\tBANK");
		System.out.println("1)SIGN-UP");
		System.out.println("2)SIGN-IN");
		System.out.println("3)EXIT");
		System.out.println("ENTER YOUR CHOICE : ");
		val = sc.nextInt();
		sc.nextLine();
		switch(val) {
		case 1:
			BankSignUp bsup = new BankSignUp();
			bsup.signUpData();
			break;
		case 2:
			BankSignIn bsi= new BankSignIn();
			bsi.signin();
			//create a switch case and in that switch add method for deposit / withdrwal (create class) 
			//call the methods for deposit,withdrawal and exit
			System.exit(0);
			break;
		case 3:
			System.out.println("Exited Succesfully");
			System.exit(0);
		default: 
			System.out.println("Invalid Choice");
			
			
		}

	}
	}

}
