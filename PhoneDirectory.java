import java.util.Scanner;

public class PhoneDirectory
{private long[] numrat;
 private String[] emrat;
   private Scanner x;
   
   
   public PhoneDirectory(int num)
   {numrat =new long[num];
    emrat=new String[num]; }
 
   public void callContact(String name)
   {int i=-1;
    for(int a=0; a<emrat.length; a++)
    {if(emrat[a]==null){System.out.println(name +" -(is not registered) ");
                        i=-2;
                        break;}
     if(emrat[a].toLowerCase().equals(name.toLowerCase())){i=a;
     break;}}
     
     if(i==-2){}
     else{
    if(i==-1);
    
   else{System.out.println(name +" Is calling");}
   }
   }
   
   public  void saveContact(String name, long number)
   {
           
      
    for(int i=0; i<numrat.length; i++)
    {if(numrat[i]==number){System.out.println("This number is registered - " +"(" + number+" is registered "+emrat[i]+")");
                            break;}
     
     if(numrat[i]==0){numrat[i]=number;
                      emrat[i]=name;
                      System.out.println("The contact has been saved - " +"("  + name + ":" + (number)+")");
                      break;}
    } 
    
   }  
  
   public  void findNumber(String name)
    {long a =-1  ;    
     for(int i=0; i<emrat.length; i++)
    {if(emrat[i]==null){
                        a=-2;
                        break;}
    
     if(emrat[i].toLowerCase().equals(name.toLowerCase())){a=numrat[i];
                                                           break;}
    } 
    if(a==-2){System.out.println(name+" -(This conctact isn't in your phonebook)");}
    else{System.out.println(name+"-(" +"The number is "+a +")");}
    }
       
   public void deleteContact(String name)
   {
       
   
    for(int i=0; i<emrat.length; i++)
    {
       if(emrat[i]==null){System.out.println(name +" -(is not registered) ");
                         break;}    
    
       if(emrat[i].equals(name)){System.out.println("The contact with name " +emrat[i]+" and number "+numrat[i]+" has been deleted");
                              emrat[i]=null;
                              numrat[i]=0;
                            break;}
                            
     }
   }

   
   public static void exit()
   {
      System.exit(0);
   }
   
   public  void displayMenu()
   {
      Scanner in = new Scanner(System.in);
      String name;
         
      System.out.println("What would you like to do? (1,2,3,4)");
      System.out.println("1.Call Contact");
      System.out.println("2.Save Contact");
      System.out.println("3.Find Number");
      System.out.println("4.Delete Contact");
      System.out.println("5.Exit");
 
      int choice = in.nextInt();
      in.nextLine();
    
      switch(choice)
      { 
         case 1:
            System.out.println("Who would you like to call? (Firsname Lastname)");
            name = in.nextLine();
            
            callContact(name);
            displayMenu();
            break;
      
         case 2:
            System.out.println("What is the name of the person you would like to save? (Firstname Lastname)");
            name = in.nextLine();  
                   
            System.out.println("What is the phone number of the person you are saving?");
            long number = in.nextLong();
            in.nextLine();
            
            saveContact(name, number);
            displayMenu();
            break;
      
         case 3:
         
            System.out.println("What is the name of person whose phone number you are searching? (Firstname Lastname)");
            findNumber(in.nextLine());
            displayMenu();
            break;
            
         case 4 :
         
            System.out.println("Which contact would you like to delete? (Firsname Lastname)");
            name = in.nextLine();

            deleteContact(name);
            displayMenu();
            break;
            
         case 5 :
         System.out.println("Good Bye!");
         in.close();
         default:
         
            break;
      }
      
      
   }
   
}