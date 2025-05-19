import java.sql.*;
import java.util.*;

   public class Home
   {
   int docid;
   static String name;
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver"; 
   static final String DB_URL = "jdbc:mysql://localhost:3306/hospital";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "";
   static String insurance;

   public static void main(String[] args) {
   Connection conn = null;
   Statement stmt = null;
   ResultSet rs;// Declare ResultSet

   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.cj.jdbc.Driver");
      //STEP 3: Open a connection
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("--------------------------------------");
      System.out.println("|__-_-HOSPITAL MANAGEMENT SYSTEM-_-__|");
      System.out.println("--------------------------------------");
      System.out.println();
      //STEP 4: Execute a query
      stmt = conn.createStatement();
      
      System.out.println("Id   |"  + " \t Name");
      String sql1 = "Select id, Dept_name from dept";
      rs = stmt.executeQuery(sql1);
      while(rs.next()){
         //Retrieve by column name
         int code  = rs.getInt("ID");
         String name = rs.getString("Dept_name");
         System.out.println(code+"    | \t "+name); 
      }
      rs.close();
      // Logic for doctor retrieval
   int Dept_ID;
   Scanner sc=new Scanner(System.in);
   System.out.print("\nEnter ID of department : ");   
   Dept_ID=sc.nextInt();
   System.out.println();
   String sql = "Select Name,Doc_id from doctor where Dept_ID="+Dept_ID;
   rs = stmt.executeQuery(sql);
      
      System.out.println("Doctor ID  |"  + " Name\t");
      while(rs.next()){
         //Retrieve by column name
         int doc_id = rs.getInt("Doc_id");
         String name = rs.getString("Name");
         System.out.println(doc_id+" \t   | "+name);
      }
      rs.close();

      int docid;
      Scanner sc1=new Scanner(System.in);
      System.out.print("\nEnter doctor's id : ");  
      docid=sc1.nextInt();
      System.out.println();
      sql = "Select * from patients where Doc_id="+docid;
      rs = stmt.executeQuery(sql);
         while(rs.next())
         {
         //Retrieve by column name
            name = rs.getString("Patientname");
            //this.name=name;
            String illness = rs.getString("Illness");
            String time = rs.getString("Appointmenttime");
            String date = rs.getString("Datecalled");
            insurance = rs.getString("Insurance");
            System.out.println("Patient's name      : " +name+"\n"+"Illness to be cured : "+illness+"\n"+"Appoinment time     : "+time+"\n"+"Appoinment date     : "+date+"\n");
         }
         if (name == null) {
    System.out.println("No patient information found for the given doctor ID");
    return; // Exit if no patient found
}
      rs.close();
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }
   Appt ap = new Appt();
   ap.checkPatient();
   BillSurance b = new BillSurance();
   b.calIns();

   }
   String sendInsurance()
   {
        return insurance;
   }
}//end main
//end JDBCExample
class SetApts extends Home {
    Scanner sc = new Scanner(System.in);

    void SetSecApt() { // for second appointment 
       try {
                System.out.print("Which day do you want to schedule the appointment to : ");
                String day = sc.next();
                System.out.print("What time do you want to set the NEXT appointment : ");
                int t=sc.nextInt();
                System.out.println();
                System.out.println("Your next appointment is scheduled for : ");
                System.out.println("Day : "+day);
                if(t<=12)
                {
                    System.out.println("Time : "+t+" am");
                }
                else
                {
                    System.out.println("Time : "+t+" pm");
                }
                System.out.println(); 
                try
                {
                    System.out.print("Is surgery necessary?");
                    String yn = sc.next();
                    if (yn.equalsIgnoreCase("yes"))
                    {
                        System.out.println("WHAT SURGERY IS RECOMMENDED?");
                        sc.nextLine();
                        String rec = sc.nextLine();

                        System.out.println("When do you want to perform the surgery?");
                        String sch = sc.next();

                        System.out.println("Your surgery is scheduled for " + sch);
                    } 
                    else
                    {
                        System.out.println("No surgery is required.");
                    }
                } 
                catch (Exception e)
                {
                    System.out.println("Please enter a valid input");
                }

            } 
            catch (Exception e)
            {
                System.out.println("Please enter a valid input");
            }
        } 
    }

   class Appt extends SetApts
   {
        SetApts s = new SetApts();
        void checkPatient() {

        if (Home.name == null) {  // Add this null check
            System.out.println("No patient information available");
            return;
        }
        if (Home.name.equals("Dan Layman"))
        {
             System.out.print("Do you want to set a second appointment soon? - ");
             String str = sc.next();
         if(str.equals("yes"))
         { 
             s.SetSecApt();
         }
         else
         {
          System.out.println("Medication : In case of severe pain take Fluoride pills or apply colgate paste");
         }
        }
   else if(Home.name.equals("Hermoine Granger"))
   {
    System.out.print("Do you want to set a second appointment soon? - ");
    String str = sc.next();
    System.out.println();
         if(str.equals("yes"))
         { 
             s.SetSecApt();
         }
         else
         {
          System.out.println("Medication : Take depakote or sedatives");
         }
   }
   else if(Home.name.equals("Megan Hart"))
   {
    System.out.print("Do you want to set a second appointment soon? - ");
    String str = sc.next();
    System.out.println();
         if(str.equals("yes"))
         { 
             s.SetSecApt();
         }
         else
         {
          System.out.println("Medication : In case of severe pain take Fluoride pills or apply coldgate paste");
         }
   }
   else if(Home.name.equals("Harry Potter"))
   {
    System.out.print("Do you want to set a second appointment soon? - ");
    String str = sc.next();
    System.out.println();
         if(str.equals("yes"))
         { 
             s.SetSecApt();
         }
         else
         {
          System.out.println("Medication : In case of severe pain take Fluoride pills or apply coldgate paste");
         }
   }
   else if(Home.name.equals("Wendy Coleman"))
   {
    System.out.print("Do you want to set a second appointment soon? - ");
    String str = sc.next();
    System.out.println();
         if(str.equals("yes"))
         { 
             s.SetSecApt();
         }
         else
         {
          System.out.println("Medication :Take ORS, crocin pain relief and don't forget to stay hydrated");
         }
   }
   else if(Home.name.equals("Wendy Coleman"))
   {
    System.out.print("Do you want to set a second appointment soon? - ");
    String str = sc.next();
    System.out.println();
         if(str.equals("yes"))
         { 
             s.SetSecApt();
         }
         else
         {
          System.out.println("Medication : Take cisplatin vePepsid get");
          System.out.println("Reports:PET/CT  scan and MRI");
         }
   }
   else if(Home.name.equals("Kyle Wong"))
   {
    System.out.print("Do you want to set a second appointment soon? - ");
    String str = sc.next();
    System.out.println();
         if(str.equals("yes"))
         { 
             s.SetSecApt();
         }
         else
         {
          System.out.println("Tooth extracted. Medication : Pain killers like Crocin or higher dosage if need");
         }
   }   
   else if(Home.name.equals("Una Gill"))
   {
    System.out.print("Do you want to set a second appointment soon? - ");
    String str = sc.next();
    System.out.println();
         if(str.equals("yes"))
         { 
             s.SetSecApt();
         }
         else
         {
          System.out.println("Reports:MRI");
          System.out.println("Medication : None released as of yet, However use a cane while walking");
         }
   }
   else if(Home.name.equals("Adrian Sutherland"))
   {
    System.out.print("Do you want to set a second appointment soon? - ");
    String str = sc.next();
    System.out.println();
         if(str.equals("yes"))
         { 
             s.SetSecApt();
         }
         else
         {
          System.out.println("Medication : Apply relispray and volini and take painkillers Physio if reqd.");
         }
   }   
   else if(Home.name.equals("April Newton"))
   {
    System.out.print("Do you want to set a second appointment soon? - ");
    String str = sc.next();
    System.out.println();
         if(str.equals("yes"))
         { 
             s.SetSecApt();
         }
         else
         {
          System.out.println("Medication : Take cisplatin vePepsid get");
          System.out.println("Reports:PET/CT  scan and MRI");
         }
   }
   else if(Home.name.equals("Sally Mackay"))
   {
    System.out.print("Do you want to set a second appointment soon? - ");
    String str = sc.next();
    System.out.println();
         if(str.equals("yes"))
         { 
             s.SetSecApt();
         }
         else
         {
          System.out.println("Medication : Vitamin E pills");
          System.out.println("Surgery:Not recommended");
          System.out.println("Theraphy:Physical,Drug");
         }
   }
   else if(Home.name.equals("Andrea Wright"))
   {
    System.out.print("Do you want to set a second appointment soon? - ");
    String str = sc.next();
    System.out.println();
         if(str.equals("yes"))
         { 
             s.SetSecApt();
         }
         else
         {
          System.out.println("Not Curable but Treatable");
          System.out.println("Medication : Calcium and Vitamin D3");
         }
   }   
   else if(Home.name.equals("Olivia Morrison"))
   {
    System.out.print("Do you want to set a second appointment soon? - ");
    String str = sc.next();
    System.out.println();
         if(str.equals("yes"))
         { 
             s.SetSecApt();
         }
         else
         {
          System.out.println("Medication : Anti inflamatory drugs");
          System.out.println("Reports:Xrays,Blood reports  if necessary");
         }
   }
   else if(Home.name.equals("Christan Welch"))
   {
    System.out.print("Do you want to set a second appointment soon? - ");
    String str = sc.next();
    System.out.println();
         if(str.equals("yes"))
         { 
             s.SetSecApt();
         }
         else
         {
          System.out.println("Meds:Volini,Relispray,Lotion");
          System.out.println("Exercise,Bandage if necessary");
         }
   }
   else if(Home.name.equals("Grace Kerr"))
   {
    System.out.print("Do you want to set a second appointment soon? - ");
    String str = sc.next();
    System.out.println();
         if(str.equals("yes"))
         { 
             s.SetSecApt();
         }
         else
         {
          System.out.println("Meds:Antihypertensive drug,Vasodilator");
          System.out.println("Take very less to no stress");
         }
   }
   else if(Home.name.equals("Liam Randall"))
   {
    System.out.print("Do you want to set a second appointment soon? - ");
    String str = sc.next();
    System.out.println();
         if(str.equals("yes"))
         { 
             s.SetSecApt();
         }
         else
         {
          System.out.println("Medication :  Beta Bloacker,Statin");
          System.out.println("Reports:Heart byopsy,2D echo");
         }
   }
   else if(Home.name.equals("David Rutherford"))
   {
    System.out.print("Do you want to set a second appointment soon? - ");
    String str = sc.next();
    System.out.println();
         if(str.equals("yes"))
         { 
             s.SetSecApt();
         }
         else
         {
          System.out.println("Meicines:Take blood thinners like klopivas aur stratum");
          System.out.println("Reports:MRI");
         }
   }
   else if(Home.name.equals("Sebastan Hodges"))
   {
    System.out.print("Do you want to set a second appointment soon? - ");
    String str = sc.next();
    System.out.println();
         if(str.equals("yes"))
         { 
             s.SetSecApt();
         }
         else
         {
          System.out.println("Meds:Calcium channel blockrs,Digoxin");
          System.out.println("Reports:2D Echo");
         }
   }
   else if(Home.name.equals("Austin Vance"))
   {
    System.out.print("Do you want to set a second appointment soon? - ");
    String str = sc.next();
    System.out.println();
         if(str.equals("yes"))
         { 
             s.SetSecApt();
         }
         else
         {
          System.out.println("Meds:Statin,Vasodilator,Excercise and Quit smoking");
          System.out.println("If pain persists we can go for Surgery");
         }
   }
   else if(Home.name.equals("Ron Weasley"))
   {
    System.out.print("Do you want to set a second appointment soon? - ");
    String str = sc.next();
    System.out.println();
         if(str.equals("yes"))
         { 
             s.SetSecApt();
         }
         else
         {
          System.out.println("Meds:SSRIs and Antipsychotic");
          System.out.println("Theraphy:Counselling,Pyschology");
         }
   }
   else if(Home.name.equals("Amelia Edmunds"))
   {
    System.out.print("Do you want to set a second appointment soon? - ");
    String str = sc.next();
    System.out.println();
         if(str.equals("yes"))
         { 
             s.SetSecApt();
         }
         else
         {
          System.out.println("Medication : SSRIs");
          System.out.println("Treatment:Avoid having any edibles around while performing a brainless task");
         }
   } 
   else if(Home.name.equals("Draco Malfoy"))
   {
    System.out.print("Do you want to set a second appointment soon? - ");
    String str = sc.next();
    System.out.println();
         if(str.equals("yes"))
         { 
             s.SetSecApt();
         }
         else
         {
          System.out.println("Treatment:Avoid having any edible around while watching Television or scrolling mindlessly");
          System.out.println("Evertime you binge eat think of the side effects");
         }
   }
   else if(Home.name.equals("Rebeus Hagrid"))
   {
    System.out.print("Do you want to set a second appointment soon? - ");
    String str = sc.next();
    System.out.println();
         if(str.equals("yes"))
         { 
             s.SetSecApt();
         }
         else
         {
          System.out.println("Meds:Pavlok Wristband");
          System.out.println("Treatment:Replace the activity of doing it by Scribbling on a peice of paper");
         }
   }
   else if(Home.name.equals("Elizabeth Kelly"))
   {
    System.out.print("Do you want to set a second appointment soon? - ");
    String str = sc.next();
    System.out.println();
         if(str.equals("yes"))
         { 
             s.SetSecApt();
         }
         else
         {
          System.out.println("Meds:Zoloft,Paxil");
          System.out.println("Treatment:Recongise when youre ruminating and stop immediately");
         }
   }
   else if(Home.name.equals("Salman Khan"))
   {
    System.out.print("Do you want to set a second appointment soon? - ");
    String str = sc.next();
    System.out.println();
         if(str.equals("yes"))
         { 
             s.SetSecApt();
         }
         else
         {
          System.out.println("Apply Orajel Instant Pain Relief Cream");
         }
   }
   else if(Home.name.equals("Victor Harris"))
   {
    System.out.print("Do you want to set a second appointment soon? - ");
    String str = sc.next();
    System.out.println();
         if(str.equals("yes"))
         { 
             s.SetSecApt();
         }
         else
         {
          System.out.println("Medication : Chemotherapy and steriods");
          System.out.println("Theraphy:Acupuncture,Physical Theraphy");
         }
   }
   }
}
class CalBill
{
    double tot=2000; // instance variable to store total
    double finalBill; // instance variable to store the final amount after calculations
    double calc(String insurance)
    {
        Scanner sc=new Scanner(System.in);
        double disc;
        System.out.println("For each appointment the cost is = $"+tot);
        System.out.println();
        Home temph = new Home();
        insurance = temph.sendInsurance();
        if(insurance != null && insurance.equalsIgnoreCase("Yes"))
        {
            System.out.println("According to the stored data patient has insurance :)");
            System.out.println();
            System.out.println("Which insurance has the patient bought?");
            System.out.println();
            System.out.println("1. LIC Premium Hospital Insurance");
            System.out.println("2. Acko Insurance");
            System.out.println("3. HDFC Prime Insurance");
            System.out.println("4. Tata Gold Insurance");
            System.out.println();
            System.out.print("Enter your choice : ");
            int choice=sc.nextInt();
            System.out.println();
            System.out.print("Do they wish to go cashless with the insurance? - ");
            String s=sc.next();
            System.out.println();
            if(s.equalsIgnoreCase("yes"))
            {
                System.out.println("--Your insurance is cashless. NO NEED TO PAY--");
            System.out.println();
                switch(choice)
                {
                    case 1:
                        System.out.println("--------------------------------------------------------------");
                        System.out.println("Congrats, you get a discount of 3% with LIC Premium Insurance");
                        disc=0.03*tot;
                        break;
                    case 2:
                    System.out.println("--------------------------------------------------------------");
                        System.out.println("Congrats, you get a discount of 2.5% with Acko Insurance");
                        disc=0.025*tot;
                        break;
                    case 3:
                    System.out.println("--------------------------------------------------------------");
                        System.out.println("Congrats, you get a discount of 3% with HDFC Prime Insurance");
                        disc=0.03*tot;
                        break;
                    case 4:
                    System.out.println("--------------------------------------------------------------");
                        System.out.println("Congrats, you get a discount of 4% with Tata Gold Insurance");
                        disc=0.04*tot;
                        break;
                    default:
                        System.out.println("Invalid insurance choice.");
                        disc=0;
                }
                finalBill=tot-disc;
                System.out.println("Your discount is = $"+disc);
                System.out.println("Final bill after coverage comes to = $"+finalBill);
            }
            else{
                System.out.println("Not going cashless no problem.");
                finalBill=tot; // No changes
            }
        }
        else
        {
            System.out.println("How do patient wish to pay?");
            System.out.println("1. CASH");
            System.out.println("2. AMERICAN EXPRESS PREMIUM CARD");
            System.out.println("3. STATEBANK OF INDIA PLATINUM CARD");
            System.out.println("4. CHEQUE");
            System.out.print("Please enter the method of payment from above : ");
            int mop=sc.nextInt();
            System.out.println();
            double discountp;
            switch(mop)
            {
                case 1:
                System.out.println("--------------------------------------------------------------");
                    System.out.println("Sorry, no discount on payment by cash. Thus total = $"+tot);
                    finalBill=tot;
                    break;
                case 2:
                System.out.println("--------------------------------------------------------------");
                    System.out.println("On using the American Express Premium Card, you get a discount of 1% on your total bill.");
                    discountp=0.01*tot;
                    finalBill=tot-discountp;
                    System.out.println("Your discount is = $"+discountp);
                    System.out.println("Your bill after for each appointment after discount is = $"+finalBill); 
                    break;
                case 3:
                System.out.println("--------------------------------------------------------------");
                    System.out.println("On using the State Bank of India Platinum Card, you get a discount of 1.5%.");
                    discountp=0.015*tot;
                    finalBill=tot-discountp;
                    System.out.println("Your discount is = $"+discountp);
                    System.out.println("Your bill after for each appointment after discount is = $"+finalBill);
                    break;
                case 4:
                System.out.println("--------------------------------------------------------------");
                    System.out.println("Sorry!! No discount on payment by cheque. Total = $"+tot);
                    finalBill=tot;
                    break;
                default:
                    System.out.println("Invalid payment method.");
                    finalBill=tot;
            }
        }
        return finalBill; // Return the final calculated total
    }
}
class BillSurance extends CalBill
{
    int i=0;
   CalBill cb = new CalBill();

        void calIns()
        {
         Scanner sc = new Scanner(System.in);
        double sum=0; // Initialize sum
        System.out.print("\nHow many appoinments did you take for "+Home.name+"- ");
        int n=sc.nextInt();
        System.out.println();
        /*CalBill cb[]=new CalBill[n];
        cb[0]=new CalBill();
        for(i=0;i<n;i++)
        {
            sum=(cb[i].calc())*n; // Accumulate the total bill for all appointments
        }*/
        CalBill cb = new CalBill();
        sum=(cb.calc(Home.insurance))*n;
        System.out.println("Total Money paid via the insurance = $"+sum);
        System.out.println("--------------------------------------------------------------");
        System.out.println();
        System.out.print("Please rate our service out of 5 -> ");
        int rating=sc.nextInt();
        System.out.println();
        if(rating<3)
        {
            System.out.println("Please let us know how we can improve :");
            String msg=sc.next();
            System.out.println();
        }
        System.out.println("GET WELL SOON!!");
     }
    }
