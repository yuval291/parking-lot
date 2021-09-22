package ParkingLot;

import Driver.DB;
import types.Car;
import types.CarType;

public class PlateLicenseService implements ParkLotInterface {

    private ImageToTextInterface client;
    private DB dbDriver;

    public PlateLicenseService(ImageToTextInterface clientxtInterface,DB dbDriver)
    {
        this.client=clientxtInterface;
        this.dbDriver=dbDriver;
    }

    public ImageToTextInterface getClient() {
        return client;
    }

    public void setClient(ImageToTextInterface client) {
        this.client = client;
    }

    public boolean IsParkable(String url) {
        
        String licensePlate = this.client.GetImageText(url);
        Car car = new Car(licensePlate);

        //Plate numbers which have no letters at all, cannot enter.
        if(ifNoLetters(licensePlate)==true)
        {
            car.setIs_parking(false);
            return false;
        }
        
        //Public transportation vehicles
        if(ifTransportation(licensePlate)==true)
        {
            car.setType(CarType.PUBLIC.name());
            car.setIs_parking(false);
            dbDriver.AddNewCar(car);

            return false;
        }

        //Military and law enforcement vehicles
        if(ifMilitary(licensePlate)==true)
        {
            car.setType(CarType.MILITARY.name());
            car.setIs_parking(false);
            dbDriver.AddNewCar(car);
            return false;
        }

        car.setType(CarType.REGULAR.name());
        car.setIs_parking(true);
        dbDriver.AddNewCar(car);
        return true;
    }

    private boolean ifNoLetters(String licensePlate)
    {
        String noLetters = licensePlate.replaceAll("[a-zA-Z]+", "");
        if(licensePlate.length()==noLetters.length())
        {
            return true;
        }
        return false;
    }
    
    private boolean ifTransportation(String licensePlate)
    {
        int plateEnd = licensePlate.length();

        if( licensePlate.charAt(plateEnd-1)=='6' ||licensePlate.charAt(plateEnd-1)=='G')
        {
            return true;
        }
        return false;
    }

    private boolean ifMilitary(String licensePlate)
    {
        for (int i = 0; i < licensePlate.length(); i++) {
            if(licensePlate.charAt(i)=='M' ||licensePlate.charAt(i)=='L')
            {
               return true;
            }
       }
       return false;
    }

}
