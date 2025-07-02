import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


class Bookingblock {
    private String passName;
    private String passangerid;
    private String email;
    private int busno;
    private int seatno;
    private Date date;
    private boolean status;
    private static int count = 0;

    public Bookingblock(String passName, String email, int busno, int seatno, Date date) {
        count++;
        this.passName = passName;
        this.email = email;
        this.busno = busno;
        this.seatno = seatno;
        this.date = date;
        this.status = true;

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String dateString = formatter.format(date);
        
        this.passangerid = count + "&" + busno + "&" + seatno + "&" + dateString;
        System.out.println("Booking confirmed for " + passName + "!");
        System.err.println("Save the Following ID for future use: " + this.passangerid);
        printLine1();
        System.err.println("\n\tThanks for Booking");
        printLine1();
    }

    public String getPassName() { return passName; }
    public String getPassangerId() { return passangerid; }
    public String getEmail() { return email; }
    public int getBusno() { return busno; }
    public int getSeatno() { return seatno; }
    public Date getDate() { return date; }
    public boolean getStatus() { return status; }
    public void setStatus(boolean status) { this.status = status; }

    private void printLine() {
        System.err.println("_____________________________");
    }
    private void printLine1()
    {
        System.err.println("__________________________________________________________");
    }
}


 

public class BookingManager {
    private ArrayList<Bookingblock> bookings = new ArrayList<>();


    public int getsize()
    {
        return bookings.size();
    }

    public Bookingblock getBookingBlock(int i)
    {
        return bookings.get(i);
    }

    public void addBooking(String name, String email, int busno, int seatno, Date date) {
        System.err.println();
        Bookingblock b = new Bookingblock(name, email, busno, seatno, date);
        bookings.add(b);
    }

    public void showAllBookings() {
        printLine();
        System.out.println("ALL BOOKINGS:");
        for (Bookingblock b : bookings) {
            printBooking(b);
        }
    }

    public void cancelBooking(String passengerId) {
        boolean found = false;
        for (Bookingblock b : bookings) {
            if (b.getPassangerId().equals(passengerId)) {
                b.setStatus(false);
                System.out.println("Booking Canceled Successfully!");
                printLine();
                printBooking(b);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Booking ID not found.");
            printLine();
        }
    }

    public void showBooking(String passengerId,BookingManager bm) {

        Bookingblock b;
        
        for (int i=0;i<bm.getsize();i++) {

            b=bm.getBookingBlock(i);
            System.out.println("Passanger id:"+b.getPassangerId());
            if (b.getPassangerId().equals(passengerId)) {
                printBooking(b);
                return;
            }
        }
        System.out.println("No booking found with ID: " + passengerId);
    }

    private void printBooking(Bookingblock b) {
        printLine();
        System.out.println("Name: " + b.getPassName());
        System.out.println("Email: " + b.getEmail());
        System.out.println("Bus No: " + b.getBusno());
        System.out.println("Seat No: " + b.getSeatno());
        System.out.println("Date: " + b.getDate());
        System.out.println("Status: " + (b.getStatus() ? "Booked" : "Canceled"));
        System.out.println("Booking ID: " + b.getPassangerId());
        printLine();
    }

    private void printLine() {
        System.out.println("___________________________");
    }
}
