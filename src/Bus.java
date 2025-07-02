import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Bus {
    private int busno;
    private boolean ac;
    private boolean seats[];
    private int capacity;
    private Date date;

    public Bus(int busno, boolean ac, String date) throws Exception {
        this.busno = busno;
        this.ac = ac;
        this.seats = new boolean[40];
        this.capacity = 0;

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        this.date = formatter.parse(date);
    }

    public boolean  getSeatno(int seatno)
    {
        return seats[seatno-1];
    }

    

    public int getcapacity()
    {
        return capacity;
    }

    public Date getDate()
    {
        return date;
    }

    public void view()
    {

        printline();
        //int busno,String dat
       System.out.println("The bus  is" + busno + ": " + (ac ? "AC" : "NON AC"));
       System.err.println("The total no seats Booked:"+capacity+"/40");
       printline();
       System.err.println("B for booked and NB for non booked SEATS");

       System.out.println("_________________________________________");

        int spacer=0;
        for(int i=0;i<40;i++)
        {
            if((i+1)<=9)
            System.err.print("["+(i+1)+" "+" "+(seats[i]?"B ":"NB") + "]");
            else
            System.err.print("["+(i+1)+" "+(seats[i]?"B ":"NB") + "]");

            spacer++;
            if(spacer==2)
            System.out.print("\t");
            if((i+1)%5==0)
            {
                System.out.println();
                spacer=0;
            }


        }

        System.out.println("_________________________________________");


    }

    public int getBusNumber()
    {
        return busno;
    }

    public String getBusDate()
    {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String dateString = formatter.format(date);

        return dateString;
    }

    public boolean Booking(Bus b,int busno,int seatno)
    {
        if(capacity>=40)
        {
            System.err.println("Bus is Full check another buses....");
            printline();
            
            return false;
        }
        else if(!b.seats[seatno - 1]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("<-----Seat is Available---->");
        System.out.println("Enter your name and email to confirm booking");
        printline();

        capacity++;
        b.seats[seatno - 1] = true;
        Date date = b.date;

        printline();
        return true;
        }

        return false;
    }

    public void cancelBooking(String passangerid)
    {

        //count+"&"+busno+"&"+seatno+"&"+date
        String idcode[] =passangerid.split("&");
        int busno=Integer.parseInt(idcode[1]);
        int seatno=Integer.parseInt(idcode[2]);
        if(!seats[seatno-1])
        {
            System.out.println("No cancelation available for this credentials");
            printline();
            return;
        }
        seats[seatno-1]=false;
        
    }

    public void printline()
    {
        System.out.println("____________________________");
    }



    

}
