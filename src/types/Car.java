package types;

public class Car {

    private String licensNumber;
    private String type;
    private Boolean is_parking;

 
    public Car(String licensNumber) {
        this.licensNumber = licensNumber;
    }

    public Car(String licensNumber, String type , Boolean isParking) {
        this.licensNumber = licensNumber;
        this.type = type;
        this.is_parking = isParking;
    }
    public String getLicensNumber() {
        return licensNumber;
    }
    public void setLicensNumber(String licensNumber) {
        this.licensNumber = licensNumber;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public Boolean getIs_parking() {
        return is_parking;
    }

    public void setIs_parking(Boolean is_parking) {
        this.is_parking = is_parking;
    }
    

    
    
}
