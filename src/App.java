
import java.util.Scanner;

import Driver.DB;
import Driver.MySql;
import ParkingLot.ApiClient;
import ParkingLot.PlateLicenseService;


public class App {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        // Response tests = new Response();
        // System.out.println("Hello, World! end");

        //7772b2854f88957
        // Print to the user to put URL in the Console ( ask user to insert url)
        // Take the URL that inserted(scanf) send it to the service
        ApiClient client;
        PlateLicenseService service;

        client = new ApiClient("7772b2854f88957");
        DB dbDriver = new MySql("jdbc:mysql://localhost:3306/test","root","1234");
        service=new PlateLicenseService(client,dbDriver);

        System.out.println("Please enter the URL you want");
        Scanner sc=new Scanner(System.in); 
        String url= sc.nextLine(); 
        
        
        System.out.println("PARK="+service.IsParkable(url));

    }
}
