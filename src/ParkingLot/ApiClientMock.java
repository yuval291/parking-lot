package ParkingLot;

import java.util.HashMap;

public class ApiClientMock implements ImageToTextInterface{
    
    private HashMap<String, String> map; 
    public ApiClientMock() {
        map = new HashMap<>(); 
        map.put("military", "931M22018");
        map.put("public_transportation", "001A7832G");
        map.put("no_letters", "123657822");
        map.put("working", "301245RT2");
    }

    public String GetImageText(String URL) 
    {
        String licensePlate="";

        if (map.containsKey(URL))
        {
            return map.get(URL);
        }
        return licensePlate;
    }
}
