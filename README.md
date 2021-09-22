## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).


# Parking Lot Project
## Description
The project is checking and validating license numbers by using API that takes the photo of the license plate and translate it to string.
After translating it to string it checks if the car can enter the parking lot and if its matching the parameters.
The result of every license plate that tries to enter the parking lot is saved in MySQL.

## Important Class Description
### ApiClient
This class is responsible of handeling the request to the 3rd party API,
the class has a function that called GetImageText that receives the image URL and sending the request to `https://ocr.space/ocrapi` , after getting the response the license number is being extracted from the json and returned to the function caller.

### PlateLicenseService
Implements ParkLotInterface, the class is receiving the DB Driver and the ApiClient in the constructor and by that `Dependency Injection` is implemented so it will be easy to use another Api if needed without touching existing code.
The main function is ``IsParkable`` that receives the URL to the image and sending it to `GetImageText` in the ApiClient, After response is returned the object `Car` is being generated and inserted to the DB after checking if the car is Approved or Declined to get into the parking lot.

### MySQL
Class that implements the DB interface and receives from the main the info of the MySQL connection.
The class has the function `AddNewCar` that receives the car, establishing connection to the DB and inserting the car info.
 
****

## MySQL
### Create Statement:
`` CREATE TABLE `parkinglot` (
  `license_plate` varchar(45) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `type_car` varchar(45) DEFAULT NULL,
  `is_parking` tinyint DEFAULT NULL,
  PRIMARY KEY (`license_plate`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
``

Thats the create statement , The code expect the table to be under `test.parkinglot`


## Packages
The project is using external packages, in order to download pick the jar.
* https://mvnrepository.com/artifact/org.apache.httpcomponents/httpclient/4.5.5 
* https://mvnrepository.com/artifact/org.junit.platform/junit-platform-console-standalone/1.8.0-RC1
* https://mvnrepository.com/artifact/org.json/json/20210307
Download them if needed and add them as reference to the project., the repo already contains them so it shouldn't be neccesery.


## Image example
Not all the images were working so here are links to working images.
* https://www.pngitem.com/pimgs/m/164-1646560_authentic-eec-euro-plate-european-license-plate-png.png
* https://www.rishayon.com/wp-content/uploads/2017/06/car_plate.png


