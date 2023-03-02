package ATM_PACKAGE;
import java.util.*;
import java.text.*;
class Account
{
	DecimalFormat df = new DecimalFormat("'Rupee '###,##0.00");
	Scanner sc = new Scanner(System.in);
	private int CN;
	private int PN;
	private double CB = 2000;
	private double SB = 1000;
	void setCustomerNumber(int a)
	{
		CN = a;
	}
	void setPinNumber(int b)
	{
		PN = b;
	}
	int getCustomerNumber()
	{
		return CN;
	}
	int getPinNumber()
	{
		return PN;
	}
    double getCurrentBalance()
    {
    	return CB;
    }
    double getSavingBalance()
    {
    	return SB;
    }
    void getCurrentWithdrawInput()
    {
    	System.out.println("Your Saving Balnace is :"+ df.format(CB));
    	System.out.print("Please Enter the Amount You Want to Withdraw: ");
        double amount = sc.nextDouble();
        
        if((CB-amount) >= 0)
        {
         calcCurrentWithdraw(amount);
         System.out.println("Your New Current Account Balance is :" + df.format(CB));
        }
        else
        {
        System.out.println("Sorry, Your Balance is insufficient for this Transaction.");	
        }
    }
    double calcCurrentWithdraw(double amount)
    {
    	CB = CB - amount;
    	return CB;
    }
    void getSavingWithdrawInput()
    {
    	System.out.println("Your Current Balnace is :"+ df.format(SB));
    	System.out.print("Please Enter the Amount You Want to Withdraw: ");
        double amount = sc.nextDouble();
        
        if((SB-amount) >= 0)
        {
         calcSavingWithdraw(amount);
         System.out.println("Your New Current Account Balance is :" + df.format(SB));
        }
        else
        {
        System.out.println("Sorry, Your Balance is insufficient for this Transaction.");	
        }
    }
    double calcSavingWithdraw(double amount)
    {
    	SB = SB - amount;
    	return SB;
    }
    void getCurrentDepositInput()
    {
    	System.out.println("Your Current Balnace is :"+ df.format(CB));
    	System.out.print("Please Enter the Amount You Want to Deposit: ");
        double amount = sc.nextDouble();
        
        if((CB-amount) >= 0)
        {
         calcCurrentDeposit(amount);
         System.out.println("Your New Current Account Balance is :" + df.format(CB));
        }
        else
        {
        System.out.println("Please Enter the Valid Amount.");	
        }
    }
    double calcCurrentDeposit(double amount)
    {
    	CB = CB + amount;
    	return CB;
    }
    void getSavingDepositInput()
    {
    	System.out.println("Your Saving Balnace is :"+ df.format(SB));
    	System.out.print("Please Enter the Amount You Want to Deposit: ");
        double amount = sc.nextDouble();
        
        if((SB-amount) >= 0)
        {
         calcSavingDeposit(amount);
         System.out.println("Your New Saving Account Balance is :" + df.format(SB));
        }
        else
        {
        System.out.println("Please Enter the Valid Amount.");	
        }
    }
    double calcSavingDeposit(double amount)
    {
    	SB = SB + amount;
    	return SB;
    }
}
class OptionMenu extends Account
{
	Scanner sc = new Scanner(System.in);
	HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
	DecimalFormat df = new DecimalFormat("'Rupee '###,##0.00"); 
	void getLogin()
	{
		int x = 1;
		do
		{
			try
			{
				hm.put(11111, 111);
				hm.put(22222, 222);
				hm.put(33333, 333);
				hm.put(44444, 444);
				hm.put(55555, 555);
				
				System.out.println("Welcome to the ATM......!");
				System.out.print("Enter your Customer number: ");
				setCustomerNumber(sc.nextInt());
				System.out.print("Enter your Pin number: ");
				setPinNumber(sc.nextInt());
				int p = getCustomerNumber();
				int q = getPinNumber();
				
				if(hm.containsKey(p) && hm.get(p) == q)
				{
					getAccountType();
				}
				else
				{
					System.out.println("Wrong Customer Number or Pin Number.");
					System.out.println("Please try again with valid Account Number & Pin Number."+"\n");
				}
			}
			catch(InputMismatchException e)
			{
				System.out.println("\n"+"Please Enter Only Numbers.Characters and Symbols are not allowed."+"\n");
				x = 2;
			}
		}
		while(x == 1);	
	}
	void getAccountType()
	{   
		System.out.print("\n");
		System.out.println("Select the Account Type you Want to Access: ");
		System.out.println("Type 1-Currenet Account");
		System.out.println("Type 2-Saving Account");
		System.out.println("Type 3-Exit");
		System.out.print("Enter your Choice: ");
		int choice = sc.nextInt();
		switch(choice)
		{
		case 1:
			getCurrent();
			break;
		case 2:
			getSaving();
			break;
		case 3:
			System.out.println("Thank You for using this ATM, Visit again.....!"+"\n");
			break;
		default:
			System.out.println("Invalid Choice. Please Enter Your Choice again");
			break;
		}
	}
	void getCurrent()
	{
		System.out.print("\n");
		System.out.println("Current Account");
		System.out.println("Type 1-View Balance");
		System.out.println("Type 2-Withdraw Funds");
		System.out.println("Type 3-Deposit Funds");
		System.out.println("Type 4-Exit");
		System.out.print("Enter your Choice: ");
		int choice = sc.nextInt();
		switch(choice)
		{
		case 1:
			System.out.println("Your Current Account Balance: "+ df.format(getCurrentBalance()));
			getAccountType();
			break;
		case 2:
			getCurrentWithdrawInput();
			getAccountType();
			break;
        case 3:
			getCurrentDepositInput();
			getAccountType();
			break;	
		case 4:
			System.out.println("Thank You for using this ATM, Visit again.....!");
			getAccountType();
			break;
		default:
			System.out.println("Invalid Choice. Please Enter Your Choice again");
			break;
		}
	}
	void getSaving()
	{
		System.out.print("\n");
		System.out.println("Saving Account");
		System.out.println("Type 1-View Balance");
		System.out.println("Type 2-Withdraw Funds");
		System.out.println("Type 3-Deposit Funds");
		System.out.println("Type 4-Exit");
		System.out.print("Enter your Choice: ");
		int choice = sc.nextInt();
		switch(choice)
		{
		case 1:
			System.out.println("Your Saving Account Balance: "+ df.format(getSavingBalance()));
			getAccountType();
			break;
		case 2:
			getSavingWithdrawInput();
			getAccountType();
			break;
        case 3:
			getSavingDepositInput();
			getAccountType();
			break;	
		case 4:
			System.out.println("Thank You for using this ATM, Visit again.....!");
			getAccountType();
			break;
		default:
			System.out.println("Invalid Choice. Please Enter Your Choice again");
			break;
		}
	}
}
public class ATM extends OptionMenu
{
	public static void main(String[] args) 
	{
		OptionMenu om = new OptionMenu();
		om.getLogin();
	}
}