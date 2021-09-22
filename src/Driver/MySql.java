package Driver;

import java.sql.*;
import types.Car;

public class MySql implements DB {

    private Connection con;
    private String dbConnectionUrl;
    private String dbUserName;
    private String dbPassword;

    public MySql(String url , String userName , String pass) {
        this.dbConnectionUrl = url;
        this.dbUserName = userName;
        this.dbPassword = pass;

    }

    public void AddNewCar(Car car) {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con = DriverManager.getConnection(this.dbConnectionUrl, this.dbUserName, this.dbPassword);
            Statement stmt = con.createStatement();
            stmt.executeUpdate(
                    String.format("insert into parkinglot (license_plate, type_car, is_parking) VALUES ('%s','%s', Incorrect integer value: 'true' for column 'is_parking' at row 1%b)", car.getLicensNumber(),car.getType(), car.getIs_parking()));
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
