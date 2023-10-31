/*
   1. Using Collection
   2. Using Excption
   3. Using OOP's Concept
      1. abstraction
      2. inheritance
      3. Polymorephycm
      4. Encapsulation
   4.Costractor
   5. Method's
   6. Globale And Locale Variables
 */
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
/*
This Class Is Abstract Class For Registration of user
 */
abstract class Regi
{
    abstract void signup();

    abstract void login();
}
    /*
    This is Inheriting Class of Abstract Class
    &
    This Class Is Only For User Registration
     */
class Registration extends Regi
{

    String fname;
    String lname;
    String gender;
    private long contact;
    String email = "admin";
    String password = "admin";

    /*
    I am Using Getter And seter Mathod For Contact No.
    */
    public long getContact()
    {
        return contact;
    }

    public void setContact(long contact)
    {
        this.contact = contact;
    }

    /*
    Method Overriding For signup for method
     */
    public void signup()
    {
        System.out.println("=============== Please Enter The Detail Care Fully ===========");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first name");
        fname = sc.nextLine();
        System.out.println("Enter the last name");
        lname = sc.nextLine();
        System.out.println("Enter the gender");
        gender = sc.nextLine();
        contact();
        System.out.println("Enter the Email");
        email = sc.nextLine();
        System.out.println("================= Plese Don't Share Your Password ========================");
        System.out.println("================= Plese Remember Your Password ========================");
        System.out.println("Enter the Password");
        password = sc.nextLine();
        login();
    }

    /*
   Method Overriding For Login for method
    */
    public void login()
    {
        System.out.println("============= Plese Enter The Detail's Carefully =============");
        System.out.println("Please enter the credentials to login");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the email");
        String email = sc.nextLine();
        System.out.println("Enter the password");
        String pass = sc.nextLine();
        if (email.equals(this.email) && pass.equals(this.password))
        {
            System.out.println("Successful");
        } else
        {
            System.out.println("not successful");
            login();
        }
    }
     /*
     This Method is For Check The Phone No.
     Less Then 11 Digits
     Greter Than 9 Digits
     i am Used Try Cathc Exaption For Input Missmatch
      */
    public void contact()
    {
        try
        {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the mobile number");
        long contact = sc.nextLong();
        if (contact > 999999999l && contact < 10000000000L)
        {
            this.contact = contact;
        } else
        {
            System.out.println("Enter 10 digit number");
            contact();

        }
        }
        catch (InputMismatchException e)
        {
            System.out.println("Plesss enter No. Only");
        }
    }
}
class Testile_Shoping_Center {
    static double bill;
     static ArrayList<String> a = new ArrayList<>();

    public void Shoping_Center() {
        System.out.println("Press 1 for Row Material");
        System.out.println("Press 2 for Finishing Goods");
        System.out.println("Press 3 to display bill");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        switch (n) {
            case 1:
                System.out.println("You have selected Row Material");
                System.out.println("Press 1 for Row Material");

                Material m = new Material();
                n = sc.nextInt();
                switch (n) {
                    case 1:
                        m.row_material();
                        break;
                    default:
                        Shoping_Center();
                        break;
                }
                break;
            case 2:
                System.out.println("Press 2 for  Finishing Goods");
                Material s = new Material();
                n = sc.nextInt();
                switch (n) {
                    case 2:
                        s.fenishing_goods();
                        break;
                    default:
                        Shoping_Center();
                        break;
                }

                break;

            case 3:
                bill();
                break;
            default:
                System.out.println("Please enter valid input");
                Shoping_Center();
                break;

        }
    }
    /*
    Using bill Method To Generate bill
    With List & Price
     */

    public void bill() {
        cart();

        System.out.println("Your total bill is ");
        double cgst = bill * 0.09;
        double sgst = bill * 0.09;
        System.out.println("cgst " + cgst);
        System.out.println("sgst " + sgst);
        System.out.println("Total " + (bill + cgst + sgst));
         /*
         This is Final Statement Wich Excecute in the last of the code
          */
        System.out.println("thank you");
    }
        /*
        using cart method for Create a List of Material
         */
    public void cart()
    {
        if (a.size() == 0)
        {
            System.out.println("Your order list is empty please order");
            Shoping_Center();
        }
        System.out.println("Your order is");
        for (Object o : a)
        {
            System.out.println(o);
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want to remove?");
        System.out.println("Press 1 to remove");
        System.out.println("Press 2 to continue");
        int n = sc.nextInt();
        if (n == 1) {
            System.out.println("Enter the number which you want to remove");
            n = sc.nextInt();
            a.remove(n - 1);
            cart();
        } else if (n == 2) {
            return;
        }
    }
}
    class Material  extends Testile_Shoping_Center {

        public void row_material() {
            System.out.println("Press 1 for Frees Row Material");
            System.out.println("Press 2 for Vasted Row Material");
            System.out.println("Press 3 to go back to Home Page");
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            switch (n) {
                case 1:
                    System.out.println("You have selected Frees Row Material");
                    System.out.println(" Press 1 For Gimp yarn For Rs. 100 Per Kg's ");
                    System.out.println(" Press 2 For Diamond yarn For Rs. 90 Per Kg's ");
                    System.out.println(" Press 3 For Boucle yarn For Rs. 80 Per Kg's ");
                    System.out.println(" Press 4 For Snarl yarn For Rs. 110 Per Kg's ");
                    int A = sc.nextInt();
                    if (A == 1) {
                        System.out.println("Please Enter Quantity In Kg's ");
                        int q = sc.nextInt();
                        if (q == q) {
                            bill = bill + (q * 100);
                            a.add("Frees Row Material"+q);

                        } else {
                            System.out.println("Invalid Input");
                            row_material();
                        }
                        System.out.println("Do you want to order more?");
                        System.out.println("Enter 1 to order more");
                        System.out.println("Enter 2 for bill");
                        n = sc.nextInt();
                        if (n == 1) {
                            Shoping_Center();
                        } else if (n == 2) {
                            bill();
                        }
                    }
                    if (A == 2) {
                        System.out.println("Please Enter Quantity In Kg's ");
                        int q = sc.nextInt();
                        if (q == q) {
                            bill = bill + (q * 90);
                            a.add("Frees Row Material"+q);

                        } else {
                            System.out.println("Invalid Input");
                            row_material();
                        }
                        System.out.println("Do you want to order more?");
                        System.out.println("Enter 1 to order more");
                        System.out.println("Enter 2 for bill");
                        n = sc.nextInt();
                        if (n == 1) {
                            Shoping_Center();
                        } else if (n == 2) {
                            bill();
                        }
                    }
                    if (A == 3) {
                        System.out.println("Please Enter Quantity In Kg's ");
                        int q = sc.nextInt();
                        if (q == q) {
                            bill = bill + (q * 80);
                            a.add("Frees Row Material"+q);

                        } else {
                            System.out.println("Invalid Input");
                            row_material();
                        }
                        System.out.println("Do you want to order more?");
                        System.out.println("Enter 1 to order more");
                        System.out.println("Enter 2 for bill");
                        n = sc.nextInt();
                        if (n == 1) {
                            Shoping_Center();
                        } else if (n == 2) {
                            bill();
                        }
                    }
                    if (A == 4) {
                        System.out.println("Please Enter Quantity In Kg's ");
                        int q = sc.nextInt();
                        if (q == q) {
                            bill = bill + (q * 110);
                            a.add("Frees Row Material"+q);

                        } else {
                            System.out.println("Invalid Input");
                            row_material();
                        }
                        System.out.println("Do you want to order more?");
                        System.out.println("Enter 1 to order more");
                        System.out.println("Enter 2 for bill");
                        n = sc.nextInt();
                        if (n == 1) {
                            Shoping_Center();
                        } else if (n == 2) {
                            bill();
                        }
                    }

                    break;
                case 2:
                    System.out.println("You have selected Vasted Row Material");
                    System.out.println(" Press 1 For Gimp yarn For Rs. 80 Per Kg's ");
                    System.out.println(" Press 2 For Diamond yarn For Rs. 50 Per Kg's ");
                    System.out.println(" Press 3 For Boucle yarn For Rs. 35 Per Kg's ");
                    System.out.println(" Press 4 For Snarl yarn For Rs. 55 Per Kg's ");
                    int Aa = sc.nextInt();
                    if (Aa == 1) {
                        System.out.println("Please Enter Quantity In Kg's ");
                        int q = sc.nextInt();
                        if (q == q) {
                            bill = bill + (q * 80);
                            a.add("Frees Row Material");

                        } else {
                            System.out.println("Invalid Input");
                            row_material();
                        }
                        System.out.println("Do you want to order more?");
                        System.out.println("Enter 1 to order more");
                        System.out.println("Enter 2 for bill");
                        n = sc.nextInt();
                        if (n == 1) {
                            Shoping_Center();
                        } else if (n == 2) {
                            bill();
                        }
                    }
                    if (Aa == 2) {
                        System.out.println("Please Enter Quantity In Kg's ");
                        int q = sc.nextInt();
                        if (q == q) {
                            bill = bill + (q * 50);
                            a.add("Frees Row Material"+q);

                        } else {
                            System.out.println("Invalid Input");
                            row_material();
                        }
                        System.out.println("Do you want to order more?");
                        System.out.println("Enter 1 to order more");
                        System.out.println("Enter 2 for bill");
                        n = sc.nextInt();
                        if (n == 1) {
                            Shoping_Center();
                        } else if (n == 2) {
                            bill();
                        }
                    }
                    if (Aa == 3) {
                        System.out.println("Please Enter Quantity In Kg's ");
                        int q = sc.nextInt();
                        if (q == q) {
                            bill = bill + (q * 35);
                            a.add("Frees Row Material"+q);

                        } else {
                            System.out.println("Invalid Input");
                            row_material();
                        }
                        System.out.println("Do you want to order more?");
                        System.out.println("Enter 1 to order more");
                        System.out.println("Enter 2 for bill");
                        n = sc.nextInt();
                        if (n == 1) {
                            Shoping_Center();
                        } else if (n == 2) {
                            bill();
                        }
                    }
                    if (Aa == 4) {
                        System.out.println("Please Enter Quantity In Kg's ");
                        int q = sc.nextInt();
                        if (q == q) {
                            bill = bill + (q * 55);
                            a.add("Frees Row Material"+q);

                        } else {
                            System.out.println("Invalid Input");
                            row_material();
                        }
                        System.out.println("Do you want to order more?");
                        System.out.println("Enter 1 to order more");
                        System.out.println("Enter 2 for bill");
                        n = sc.nextInt();
                        if (n == 1) {
                            Shoping_Center();
                        } else if (n == 2) {
                            bill();
                        }
                    }
            }

        }

        public void fenishing_goods() {
            System.out.println("Press 1 for Fresh Finishing_Goods");
            System.out.println("Press 2 for Vasted Finishing_Goods");
            System.out.println("Press 3 to go back to Home Page");
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            switch (n)
            {
                case 1:
                    System.out.println("You have selected Fresh Finishing_Goods  ");
                    System.out.println(" Press 1 For Cotton For Rs. 250 Per Metre ");
                    System.out.println(" Press 2 For Nay loon material For Rs. 150 Per Metre ");
                    System.out.println(" Press 3 For Silk material For Rs. 190 Per Metre ");
                    System.out.println(" Press 4 For  Anti-Fire material For Rs. 280 Per Metre ");
                    int A = sc.nextInt();
                    if (A == 1)
                    {
                        System.out.println("Please Enter Quantity In Kg's ");
                        int q = sc.nextInt();
                        if (q == q) {
                            bill = bill + (q * 250);
                            a.add("Frees Row Material"+q);

                        }
                        else
                        {
                            System.out.println("Invalid Input");
                            row_material();
                        }
                        System.out.println("Do you want to order more?");
                        System.out.println("Enter 1 to order more");
                        System.out.println("Enter 2 for bill");
                        n = sc.nextInt();
                        if (n == 1)
                        {
                            Shoping_Center();
                        } else if (n == 2)
                        {
                            bill();
                        }
                    }
                    if (A == 2)
                    {
                        System.out.println("Please Enter Quantity In Kg's ");
                        int q = sc.nextInt();
                        if (q == q) {
                            bill = bill + (q * 150);
                            a.add("Frees Row Material"+q);

                        }
                        else
                        {
                            System.out.println("Invalid Input");
                            row_material();
                        }
                        System.out.println("Do you want to order more?");
                        System.out.println("Enter 1 to order more");
                        System.out.println("Enter 2 for bill");
                        n = sc.nextInt();
                        if (n == 1)
                        {
                            Shoping_Center();
                        }
                        else if (n == 2)
                        {
                            bill();
                        }
                    }
                    if (A == 3)
                    {
                        System.out.println("Please Enter Quantity In Kg's ");
                        int q = sc.nextInt();
                        if (q == q) {
                            bill = bill + (q * 190);
                            a.add("Frees Row Material"+q);

                        }
                        else
                        {
                            System.out.println("Invalid Input");
                            row_material();
                        }
                        System.out.println("Do you want to order more?");
                        System.out.println("Enter 1 to order more");
                        System.out.println("Enter 2 for bill");
                        n = sc.nextInt();
                        if (n == 1)
                        {
                            Shoping_Center();
                        }
                        else if (n == 2)
                        {
                            bill();
                        }
                    }
                    if (A == 4)
                    {
                        System.out.println("Please Enter Quantity In Kg's ");
                        int q = sc.nextInt();
                        if (q==q)
                        {
                            bill = bill + (q * 290);
                            a.add("Frees Row Material"+q);

                        }
                        else
                        {
                            System.out.println("Invalid Input");
                            row_material();
                        }
                        System.out.println("Do you want to order more?");
                        System.out.println("Enter 1 to order more");
                        System.out.println("Enter 2 for bill");
                        n = sc.nextInt();
                        if (n == 1)
                        {
                            Shoping_Center();
                        }
                        else if (n == 2)
                        {
                            bill();
                        }
                    }

                case 2:
                    System.out.println("You have selected Fresh Finishing_Goods  ");
                    System.out.println(" Press 1 For Cotton For Rs. 125 Per Metre ");
                    System.out.println(" Press 2 For Nay loon material For Rs. 75 Per Metre ");
                    System.out.println(" Press 3 For Silk material For Rs. 95 Per Metre ");
                    System.out.println(" Press 4 For  Anti-Fire material For Rs. 140 Per Metre ");
                    int Ab = sc.nextInt();
                    if (Ab == 1)
                    {
                        System.out.println("Please Enter Quantity In Kg's ");
                        int q = sc.nextInt();
                        if (q == q) {
                            bill = bill + (q * 125);
                            a.add("Frees Row Material"+q);

                        }
                        else
                        {
                            System.out.println("Invalid Input");
                            row_material();
                        }
                        System.out.println("Do you want to order more?");
                        System.out.println("Enter 1 to order more");
                        System.out.println("Enter 2 for bill");
                        n = sc.nextInt();
                        if (n == 1)
                        {
                            Shoping_Center();
                        }
                        else if (n == 2)
                        {
                            bill();
                        }
                    }
                    if (Ab == 2)
                    {
                        System.out.println("Please Enter Quantity In Kg's ");
                        int q = sc.nextInt();
                        if (q == q) {
                            bill = bill + (q * 75);
                            a.add("Frees Row Material"+q);

                        }
                        else
                        {
                            System.out.println("Invalid Input");
                            row_material();
                        }
                        System.out.println("Do you want to order more?");
                        System.out.println("Enter 1 to order more");
                        System.out.println("Enter 2 for bill");
                        n = sc.nextInt();
                        if (n == 1)
                        {
                            Shoping_Center();
                        }
                        else if (n == 2)
                        {
                            bill();
                        }
                    }
                    if (Ab == 3)
                    {
                        System.out.println("Please Enter Quantity In Kg's ");
                        int q = sc.nextInt();
                        if (q == q)
                        {
                            bill = bill + (q * 95);
                            a.add("Frees Row Material"+q);

                        }
                        else
                        {
                            System.out.println("Invalid Input");
                            row_material();
                        }
                        System.out.println("Do you want to order more?");
                        System.out.println("Enter 1 to order more");
                        System.out.println("Enter 2 for bill");
                        n = sc.nextInt();
                        if (n == 1)
                        {
                            Shoping_Center();
                        }
                        else if (n == 2)
                        {
                            bill();
                        }
                    }
                    if (Ab == 4)
                    {
                        System.out.println("Please Enter Quantity In Kg's ");
                        int q = sc.nextInt();
                        if (q == q
                        )
                        {
                            bill = bill + (q * 140);
                            a.add("Frees Row Material"+q);

                        }
                        else
                        {
                            System.out.println("Invalid Input");
                            row_material();
                        }
                        System.out.println("Do you want to order more?");
                        System.out.println("Enter 1 to order more");
                        System.out.println("Enter 2 for bill");
                        n = sc.nextInt();
                        if (n == 1)
                        {
                            Shoping_Center();
                        }
                        else if (n == 2)
                        {
                            bill();
                        }
                    }

            }
        }
    }

        class TSC {
                /* I am using sattic bolck For Display The Massage
                Before Main method
                 */
            static
                {
                    System.out.println("=======================================");
                    System.out.println("Welcome To Textile Shopping Center");
                    System.out.println("=======================================");
                    System.out.println();
               }

            public static void main(String[] args)
            {
                Scanner sc = new Scanner(System.in);

                System.out.println("Enter 1 for Signup");
                System.out.println("Enter 2 for Login");
                System.out.println("Enter 3 for Exit");
                // I am Doing UpCasting here
                Regi r = new Registration();
                // This Object Of An Class Which is Testile_Shoping_Center();
                Testile_Shoping_Center t = new Testile_Shoping_Center();
                int n = sc.nextInt();
                switch (n)
                {
                    case 1:
                        System.out.println("=======================================");
                        System.out.println("===============Plese Signup=========== ");
                        System.out.println("=======================================");
                        r.signup();
                        System.out.println("=======================================");
                        System.out.println("============== This is Home Page ============");
                        System.out.println("=======================================");
                        t.Shoping_Center();
                        break;
                    case 2:

                        System.out.println("=======================================");
                        System.out.println("===============Please Login=========== ");
                        System.out.println("=======================================");
                        r.login();
                        System.out.println("=======================================");
                        System.out.println("============== This is Home Page ============");
                        System.out.println("=======================================");
                        t.Shoping_Center();
                        break;
                    case 3:
                        // this Statement For Terminate The Program
                        // And Here Is 0 Mens True
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Please enter the valid input");
                        main(null);
                        break;
                }

            }
        }
