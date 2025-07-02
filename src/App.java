import java.text.SimpleDateFormat;
import java.util.*;
 

public class App {
    public static void printline()
    {
        System.err.println("__________________________________");
        System.out.println();
    }


    public static void cancelBooking(BookingManager bookman, ArrayList<Bus> b,String id,int busno,String date)
    {
        // System.out.print("Enter passanger ID");
        //                 String passangerId=sc.next();
        //                 System.out.print("/nEnter Bus No");
        //                 int busno=sc.nextInt();
        //                 System.out.println("/nEnter the date");
        //                 String Datee=sc.next(
        
        boolean msg=true;
        for(int i=0;i<b.size();i++)
        {
            printline();
            Bus temp = b.get(i);
            int tempno=temp.getBusNumber();
            
            String tempdate=temp.getBusDate();
            if(busno==tempno&& tempdate.equals(date) )
            {
                msg=false;
                temp.cancelBooking(id);
                bookman.cancelBooking(id);
                
                
                break;

            }

            
            
        }

        if(msg)
            {
                printline();
                System.out.println("No field match");
                System.out.println("Check for another date or bus");
                printline();
            }


    }

    
    
    public static boolean booktheseat(ArrayList<Bus> b,int busno,String date,int seatno)
    {
        boolean msg=false;
        for(int i=0;i<b.size();i++)
        {
            Bus temp = b.get(i);
            int tempno=temp.getBusNumber();
            boolean seatavl=temp.getSeatno(seatno);
            
            String tempdate=temp.getBusDate();
            if(busno==tempno&& tempdate.equals(date) &&  seatavl ==false)
            {
                msg=false;
                printline();
                if(b.get(i).Booking(temp,busno, seatno))
                return true;

            }

            
            
        }

        if(!msg)
            {
                printline();
                System.out.println("NO bus is available at the particular date");
                System.out.println("Check for another date or bus");
                printline();
            }

            return msg;
        
    }
  
    public static boolean isAvilable(ArrayList<Bus> b,int busno,String date)
    {
        
        for(int i=0;i<b.size();i++)
        {
            Bus temp = b.get(i);
            int tempno=temp.getBusNumber();
            String tempdate=temp.getBusDate();
            if(busno==tempno&& tempdate.equals(date) )
            return true;
        }

        return false;
    }

    public static void searchShow(int busno,ArrayList<Bus> b)
    {
        for(int i=0;i<b.size();i++)
        {   
            Bus temp = b.get(i);
            int tempno=temp.getBusNumber();
            if(busno==tempno)
            {
                temp.view();
            }

        }
    }
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        

        //.....intializing objects......

        String username="1";
        String password="1";


        ArrayList<Bus> buses= new ArrayList<Bus>();
        BookingManager manager=new BookingManager();

        








        //..............user input code..................//
        printline();
        System.err.println("\t \t Welcome");
        System.out.println("\t \t<------->");
        
        int userop;
        while(true)
        {
            System.err.println("1:Admin");
            System.err.println("2:Booking");
            System.out.println("3:Exit booking");
            System.out.print("---->Enter the option:");
            userop=sc.nextInt();
            printline();


            
            if(userop==1)                                                                           //admin
            {
                
                Admin:
                while (true) 
                { 
                    System.out.print("Enter username:");
                    String user=sc.next();
                    System.out.print("\nEnter password:");
                    String pass=sc.next();
                    
                
                    if(username.equals(user) && pass.equals(password))                              //checking username password validity
                    {
                        printline();
                        
                        while (true) {                                                              //add bus option for admin or exit
                            
                            System.err.println("Enter 1 to add Buses and 2 to view Bookings:");
                            System.out.println("Enter 3 to previous menu");
                            System.err.print("Enter your option:");
                            int busexit =sc.nextInt();
                            if(busexit==1)
                            {

                                // BUS NO 
                                        //AC
                                        // CPACITY
                                        System.err.print("Enter bus no:");
                                        int no= sc.nextInt();
                                        
                                        System.out.print("\nEnter Ac or NOT( 1 for ac 2 for non ac):");
                                        int ac=sc.nextInt();
                                        boolean acornot=ac==1?true:false;
                                        System.out.print("Enter the date of available of Bus(dd-mm-yyyy):");
                                        String tdate=sc.next();

                                        if(isAvilable(buses, no, tdate))
                                        {
                                            System.err.println("The particular Bus field already exists\nselect another bus no or date");
                                            printline();
                                        }
                                        else{
                                        
                                        buses.add(new Bus(no, acornot,tdate));

                                        printline();   
                                        
                                        }
                                
                            }
                            else if(busexit==2)
                            {
                                
                                manager.showAllBookings();
                                
                                 
                            }
                            
                            else if(busexit==3)
                            {
                                System.out.println("Exiting....bus add option");
                                printline();
                                break Admin;
                            }
                            else
                            {
                                System.out.println("Invalid option try again:");
                                printline();
                            }
                            
                        }
                        
           
                        
                    }else
                    {
                        System.out.println("Username or password is wrong.....");
                        System.err.print("Enter 1 for retry and 2 to exit menu:");
                    }
                }
                

            }
            
            else if(userop==2)
            {

                System.out.println("\t Booking....");
                printline();

                Booking:                                                                           //option for view seat and book seat
                while (true)
                {
                    
                    System.out.println("1:View seats");
                    System.out.println("2:Book seat");
                    System.out.println("3:Cancel Booking");
                    System.out.println("4:View Booking"); 
                    System.out.println("5:previous menu");
                    System.out.print("Enter option ");
                    int bookingop=sc.nextInt();

                    if(bookingop==1)
                    {
                        System.out.print("Enter bus no:");
                        int booking_busno=sc.nextInt();
                        System.out.print("Enter date(dd-mm-yy)");
                        String date=sc.next();
                        
                        if(isAvilable(buses, booking_busno, date))
                        {
                            searchShow(booking_busno, buses);
                        }
                        else
                        {
                            System.err.println("No bus is avilable at the particular date.");
                            System.out.println("Serach for another bus no or for another Date");

                        }

                    }
                    else if(bookingop==2)
                    {
                        printline();
                        System.out.println("\t select your journey....");
                        printline();

                        System.out.print("\nEnter bus no:");
                        int bookingop_busnp=sc.nextInt();
                        System.out.print("\nEnter Seat No");
                        int bookingop_seatnno=sc.nextInt();
                        System.out.print("\nEnter Date (dd-mm-yyyy):");
                        String bookingop_date=sc.next();

                        if(booktheseat(buses,bookingop_busnp , bookingop_date,bookingop_seatnno ))
                        {
                             System.out.print("Enter name:");
                            String usernames=sc.next();
                            System.out.print("\nEnter Email:");
                            String email=sc.next();
                            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                            Date date = formatter.parse(bookingop_date);
                            //rrayList<Bus> b,int busno,String date,int seatno

                            manager.addBooking(usernames, email, bookingop_busnp, bookingop_seatnno, date);

                        }


                       
                        


                    }else if(bookingop==3)
                    {
                        printline();
                        System.out.print("Enter passanger ID:");
                        String passangerId=sc.next();
                        System.out.print("\nEnter Bus No:");
                        int busno=sc.nextInt();
                        System.out.print("\nEnter the date:");
                        String Datee=sc.next();

                    //   ArrayList<Bus> b,String id,int busno,String date)
                        cancelBooking(manager, buses, passangerId, busno, Datee);


                    }

                    else if(bookingop==4)
                    {
                        BookingManager b = new BookingManager();
                        System.out.print("\n Enter the Booking id:");
                        String bookingidview=sc.next();
                        printline();
                        b.showBooking(bookingidview,manager);
                    }
                    else if(bookingop==5){

                        printline();
                        System.out.println("Previous menu............");
                        printline();
                        break Booking;

                    }
                }
            }
            else if(userop==3)
            {
                System.out.println("\t Exit booking..........");
               
                printline();
                break;

            }

        }


        sc.close();
    }
}
