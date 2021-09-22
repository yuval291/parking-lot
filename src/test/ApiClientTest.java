package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Driver.MySqlMock;
import ParkingLot.*;

public class ApiClientTest {

    PlateLicenseService service;

    @Before
    public void init() {
        ApiClientMock mock = new ApiClientMock();
        MySqlMock sqlMock = new MySqlMock();
        service=new PlateLicenseService(mock,sqlMock);
    }

    @Test
    public void TestMilitaryLicensePlate()
    {
        boolean parkable =service.IsParkable("military");
        System.out.println("Expecting service to return false on military license response: "+parkable);
        assertEquals(parkable,false);
    }

    @Test
    public void TestPublicTransportationLicensePlate()
    {
        boolean parkable =service.IsParkable("public_transportation");
        System.out.println("Expecting service to return false on public_transportation license response: "+parkable);
        assertEquals(parkable,false);
    }

    @Test
    public void TestNoLettersLicensePlate()
    {
        boolean parkable =service.IsParkable("no_letters");
        System.out.println("Expecting service to return false on no_letters license response: "+parkable);
        assertEquals(parkable,false);
    }

    @Test
    public void TestGoodLicensePlate()
    {
        boolean parkable =service.IsParkable("working");
        System.out.println("Expecting service to return true on working license response: "+parkable);
        assertEquals(parkable,true);
    }


    
}
