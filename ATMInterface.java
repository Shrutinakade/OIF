import java.util.*;

class BankAccount {

	private String name;
	private String Username;
	private String Pass;
	private String Account;
	public double amount = 100000;

	String transactionH = "";
	int count = 0;

	public void Register() {

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Name : ");
		name = sc.nextLine();
		System.out.print("\nEnter Username : ");
		Username = sc.next();

		System.out.print("\nEnter Password : ");
		Pass = sc.next();

		System.out.print("\nEnter Account number : ");
		Account = sc.next();

		System.out.print(" Registration complete....... \n");
	}

	public boolean checkLogin() {
		boolean islogin = false;

		while (!islogin) {
			Scanner sc = new Scanner(System.in);
			System.out.println("\nEnter Username : ");
			String n = sc.next();

			if (Username.equals(n)) {

				while (!islogin) {

					System.out.println("\nEnter password :");
					String p = sc.next();

					if (Pass.equals(p)) {
						System.out.println("You have successfully logged in");
						islogin = true;
					} else {
						System.out.print("Enter correct Password\n");
					}
				}
				// break;
			} else {
				System.out.print("Not Found\n");
			}
		}
		return islogin;
	}

	public void WithDraw() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Amount to withdrawn  : ");
		double num = sc.nextInt();

		try {
			if (num < amount) {
				System.out.println("you have successfully withdrawn your money\n");
				amount = amount - num;
				String str = num + "Rs. Withdrawn";
				transactionH = transactionH.concat(str);
				count++;
			}

			else {
				System.out.println("Enter amount within limit");
			}
		} catch (Exception e) {
		}

	}

	public void Deposit() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Amount to Deposit : ");
		double am = sc.nextInt();
		try {
			if (am < 100000f) {
				amount = amount + am;

				String str = am + "Rs. Deposit";

				transactionH = transactionH.concat(str);
				count++;
			}

			else {
				System.out.print("Sorry limit is 1000000\n");
			}
		} catch (Exception e) {
		}
	}

	public void Transfer() {

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Receipent name : ");
		String receipent = sc.nextLine();

		System.out.print("Enter Transfer amount\n");
		int t = sc.nextInt();
		try {
			if (t < 50000f) {
				amount = amount - t;
				System.out.print("Successfully transfered to " + receipent);
				String str = t + "Rs. Transfer";

				transactionH = transactionH.concat(str);
				count++;
			}

			else {
				System.out.print("Sorry limit is 100000 only\n");
			}
		}

		catch (Exception e) {
		}

	}

	public void ShowBalance() {

		System.out.print("Current Balance : " + amount);
	}

	public void showTransaction() {
		if (count > 0) {

			System.out.print(count + "\nTransaction History : " + transactionH + " \n");

		} else {
			System.out.print("No Transaction History\n");
		}
	}

}

class ATMInterface {

	public static void main(String str[]){
	
	BankAccount b=new BankAccount();
	Scanner sc=new Scanner(System.in);
     	System.out.print("\n*************Welcome to ATM************* \n\n");
	    System.out.print("1. Register\n 2. Exit\n");
		System.out.print("Enter choice\n");
		
		int c=sc.nextInt();
		if(c==1){
		b.Register();

			while(true){
			 
		        System.out.print("\n1. Login\n  2. Exit\n");
				System.out.print("Enter your choice ");

                int choice =sc.nextInt();

				  if(choice==1){

					 if(b.checkLogin()){
						 System.out.print("\n*********Welcome Back**********\n");
           	             boolean isfinished=false;
					   while(!isfinished){ 
						 System.out.println("\n 1.Show Transaction \n 2.WithDraw \n 3. Deposit\n 4. Transer\n 5. CheckBalance\n");
						 System.out.print("Enter your choice\n");
	                     int x=sc.nextInt();
	                     switch(x){
		
	     	        case 1:
                        b.showTransaction();
		
		                break;
	                case 2:
	                    b.WithDraw();
			 
		                break;  
	                case 3:
		                b.Deposit();
		                break; 
	                case 4: 
                        b.Transfer();	 
	                    break;
			        case 5:
			            b.ShowBalance();
				       break;
					case 6:
					   isfinished=true;
					   break;
	              }
			 }
		}
				  }
			else{
				System.exit(0);
			}
	}
	 
 }

else{
	System.exit(0);
}
}
}
