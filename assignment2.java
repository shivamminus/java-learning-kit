import java.util.*;
class Account
{
	double money;
	double amount;
	Scanner sc=new Scanner(System.in);	
	//Scanner c=new  Scanner(System.in);
	Account(int money)
	{
		money=0;
	}
	void inquire()
	{
		System.out.println("enter your password:");
		System.out.println();
		int password=sc.nextInt();
		if(password==1809)		
		System.out.println("your account has :"+money);
		/*else 
		return 0;
		System.out.println("wrong... only last attempt");
		goto inquire();*/
	}	
	void addMoney(double amount)
	{
		money+=amount;
		System.out.println("your account has :"+money+" rupees.");
	}
	void withdraw(double amount)
	{
		if(amount>money)
		{
			money-=5;
			System.out.println("Rs 5 has been ddeducted from your account on account of withdrawl of more money than in your account");
		}
	}
	
	void mainMenu()
	{
		System.out.println("welcome to ATM");
		System.out.println();
		char ch='y';
		do
		{
		System.out.println("1.ADD");
		System.out.println("2.Inquire");
		System.out.println("3.Withdraw");
		System.out.println("4. EXIT ");		
		System.out.println("choose 1. or 2. or 3. or 4.");
		int choice=sc.nextInt(); 			
		switch (choice)
			{
				case 1: System.out.println("enter the amount to be added:");
					amount=sc.nextDouble();
					addMoney(amount);
				case 2: inquire();
					break;
				case 3: System.out.println("enter amount:");
					amount=sc.nextDouble();
					withdraw(amount);
					break;
				case 4:	break;
				default: 		
			}
		System.out.println("enter the choice:(y/n)");
		ch = sc.next().charAt(0);
		}while(ch=='y');
				
	}
	public static void main(String r[])
	{
		Account user=new Account(0);
		user.mainMenu();
	}

}
