
import java.util.Scanner;

import Driver.DB;
import Driver.MySql;
import ParkingLot.ApiClient;
import ParkingLot.PlateLicenseService;


public class App {
    public static void main(String[] args) throws Exception {
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
