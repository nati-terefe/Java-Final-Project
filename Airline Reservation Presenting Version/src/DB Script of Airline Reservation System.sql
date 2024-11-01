-- Written by: 	1. Nahom Wondesen 	ID PY0761
-- 				2. Samuel Messeret 	ID SV9461
-- 				3. Michael Getu 	ID ml2612
-- 				4. Nathnael Terefe 	ID LF2669
-- 				5. Temesgan Fekadu 	ID ZT2452
-- 				6. Mohammed Hussen 	ID QB7718
-- Written due: 29/05/2022
                
-- -----------------------------------------------------------------------------------------------------------------------------------                
                
-- Creating and using Airline database
create database Airline;
use Airline;

-- -----------------------------------------------------------------------------------------------------------------------------------

-- Creating table for storing login info
create table login(
usr varchar(30) Not NUll,
psw varchar(30) Not NUll
);

-- Initializing login info of users
Insert into login values('admin','admin');
Insert into login values('mike','12345');
Insert into login values('nati', 'admin');
Insert into login values('nahom','admin');
Insert into login values('teme','admin');
Insert into login values('sami','admin');
Insert into login values('moh','admin');

-- ------------VARIABLES AND FACTORS----------------------------------------------------------------------------------------------------

-- Creating a table to store Class factors that affect the price
create table classfactor(
class varchar(60) not null,
baseprice double not null,
cfactor double not null
);

-- Initializing Class Factors
Insert into classfactor values ('Economy Class',900,1);
Insert into classfactor values ('Buissness Class',900,1.4);
Insert into classfactor values ('First Class',900,1.8);

-- -----------------------------------------------------------------------------------------------------------------------------------

-- Creating a table to store Seat factors that affect the price
create table seatfactor(
seat varchar(60) not null,
sfactor double not null
); 

-- Initializing Seat Factors
Insert into seatfactor values ('Middle Seat',1);
Insert into seatfactor values ('Side Seat',1.2);
Insert into seatfactor values ('Window Seat',1.5);

-- -----------------------------------------------------------------------------------------------------------------------------------

-- Creating table for storing destination cities info
create table destinations(
city varchar(50)
);

-- Initializing destinations list
Insert into destinations values ('--City--');
Insert into destinations values ('Dubai');
Insert into destinations values ('Istanbul');
Insert into destinations values ('Jakarta');
Insert into destinations values ('New York');
Insert into destinations values ('Paris');
Insert into destinations values ('Rome');

-- -----------------------------------------------------------------------------------------------------------------------------------

-- Creating table for storing planes info
create table planes(
id int auto_increment,
aircraft varchar(50) Not NUll,
totseat int Not NUll,
Primary Key(id)
);

-- Making planes id auto increase starting 1000
ALTER TABLE planes AUTO_INCREMENT=1000; 

-- Initializing planes list
Insert into planes(aircraft, totseat) values('Boeing-777',400);
Insert into planes(aircraft, totseat) values('Boeing-737',300);
Insert into planes(aircraft, totseat) values('Boeing-767',400);
Insert into planes(aircraft, totseat) values('Boeing-777x',500);
Insert into planes(aircraft, totseat) values('Airbus-A330',300);
Insert into planes(aircraft, totseat) values('Airbus-A340',300);
Insert into planes(aircraft, totseat) values('Airbus-A350',400);
Insert into planes(aircraft, totseat) values('Airbus-A380',500);
Insert into planes(aircraft, totseat) values('Airbus-A444',500);
Insert into planes(aircraft, totseat) values('Airbus-A391',500);

-- -----------------------------------------------------------------------------------------------------------------------------------

-- Creating table for storing flights info
create table flights(
id int primary key, 
dep varchar(30) Not NUll,
des varchar(30) Not NUll,
datandtime datetime Not NUll,
pilot varchar(70) Not NUll unique,  
copilot1 varchar(70) Not NUll unique,
copilot2 varchar(70) unique,
host1 varchar(70) Not NUll unique,
host2 varchar(70) Not NUll unique,
host3 varchar(70) unique,
availseat int,
planeref int,
CONSTRAINT fk_planereff
FOREIGN KEY (planeref) 
        REFERENCES planes(id)
);

-- Initializing flights list
Insert into flights values('1010', 'Addis Ababa', 'Dubai', '2022-05-26 03:14:00', 'Capt. Abebe Zeleke', 
							'Hailu Girum', 'Zelalem Haile', 'Sara Abel', 'Saron Damtew', 'Seble Nahom', 34, 1000);
Insert into flights values('1111', 'Addis Ababa', 'Dubai', '2022-06-26 02:14:00', 'Capt. Zerihun Zeleke', 
							'Abel Girum', Null, 'Sara Zewde', 'Saron Kebede', 'Seble Abebe', 14, 1001);
Insert into flights values('1212', 'Addis Ababa', 'Istanbul', '2022-05-26 07:20:07', 'Capt. Abebe Haile', 
							'Hailu Kaleb', 'Zelalem Zewde', 'Kidist Abel', 'Bitaniya Damtew', null , 86, 1002);
Insert into flights values('1313', 'Addis Ababa', 'Istanbul', '2022-07-26 09:15:07', 'Capt. Zeleke Belay', 
							'Hailu Tamrat', 'Yonas Haile', 'Sara Tewdros', 'Saron Abebe', 'Seble Natnael', 100, 1003);
Insert into flights values('1414', 'Addis Ababa', 'New York', '2022-06-26 09:20:00', 'Capt. Abebe Kebede', 
							'Ayub Girum', 'Enku Haile', 'Sara Amir', 'Saron Robel', 'Seble Bereket', 120, 1004);
Insert into flights values('1515', 'Addis Ababa', 'New York', '2022-07-26 06:14:07', 'Capt. Kebedech Girum', 
							'Barkot Girum', 'Selihom Haile', 'Yordanos Abel', 'Yanet Damtew', 'Nuriya Nahom', 80, 1005);
Insert into flights values('1616', 'Addis Ababa', 'Paris', '2022-08-26 03:14:07', 'Capt. Tamrat Zewdee', 
							'Bereket Girum', 'Teferi Haile', 'Tsion Abel', 'Hana Damtew', 'Feven Nahom', 60, 1006);
Insert into flights values('1717', 'Addis Ababa', 'Paris', '2022-05-26 04:14:07', 'Capt. Eyob Nahom', 
							'Gemechu Girum', 'Chaltu Haile', 'Mieraf Abel', 'Selam Damtew', 'Seble Yoakin', 50, 1007);
Insert into flights values('1818', 'Addis Ababa', 'Jakarta', '2022-06-26 01:14:07', 'Capt. Abel Yonas', 
							'Tarekeg Girum', 'Yeabsira Haile', 'Rediet Abel', 'Tsinat Damtew', null , 340, 1008);
Insert into flights values('1919', 'Addis Ababa', 'Rome', '2022-08-26 02:14:07', 'Capt. Bamlak Kidus', 
							'Sofonias Girum', null, 'Sara Michael', 'Tsionawit Damtew', 'Seblewengel Nahom', 1, 1009);

-- -----------------------------------------------------------------------------------------------------------------------------------

-- Creating table for storing passenger info
create table passengers(
id int auto_increment,
fname varchar(50) not null,
lname varchar(50) not null,
gender varchar(30) not null,
age varchar(30) not null,
tel varchar(90),
class varchar(30) not null,
seat varchar(10) not null,
seattp varchar(20) not null,
flightnum int,
CONSTRAINT fk_fnpassg
FOREIGN KEY (flightnum) 
        REFERENCES flights(id),
Primary Key(id)
);

-- Making passengers id auto increase starting 1000
ALTER TABLE passengers AUTO_INCREMENT=1000;

-- Initializing passengers list
Insert into passengers (fname,lname,gender,age,tel,class,seat, seattp, flightnum) 
			values ('Abebe', 'Kebede', 'Male', '18+', '+251911132343',  'Economy Class', 'A-a-A', 'Col A Window Seat', '1010');
Insert into passengers (fname,lname,gender,age,tel,class,seat, seattp, flightnum) 
			values ('Hailu', 'Lema', 'Male', '18+', '+251911987655',  'Buissness Class', 'A-b-A', ' Col A Middle Seat', '1010');
Insert into passengers (fname,lname,gender,age,tel,class,seat,seattp,flightnum) 
			values ('Getu', 'Tessema', 'Male', '18+', '+251987657689',  'Economy Class', 'A-c-A', 'Col A Side Seat', '1212');
Insert into passengers (fname,lname,gender,age,tel,class,seat,seattp,flightnum) 
			values ('Sara', 'Zewde', 'Female', '18+', '+121913542365',  'Buissness Class', 'B-a-A', 'Col B Window Seat', '1313');
Insert into passengers (fname,lname,gender,age,tel,class,seat,seattp,flightnum) 
			values ('Helen', 'Berhe', 'Female', '18+', '+234909568734',  'Economy Class', 'B-b-A', 'Col B Middle Seat', '1313');
Insert into passengers (fname,lname,gender,age,tel,class,seat,seattp,flightnum) 
			values ('Jacob', 'Tesfa', 'Male', '18+', '+111914765687',  'First Class', 'B-c-A', 'Col B Side Seat', '1313');
Insert into passengers (fname,lname,gender,age,tel,class,seat,seattp,flightnum) 
			values ('Yoakin', 'Girum', 'Male', '18+', '+789911828070',  'Economy Class', 'C-a-A', 'Col C Window Seat', '1313');
Insert into passengers (fname,lname,gender,age,tel,class,seat,seattp,flightnum) 
			values ('Jack', 'Kaleb', 'Male', 'Under 18', '+873967435698',  'Buissness Class', 'C-b-A', 'Col C Middle Seat', '1414');
Insert into passengers (fname,lname,gender,age,tel,class,seat,seattp,flightnum) 
			values ('Ela', 'Pit', 'Female', 'Under 18', '+251923215875',  'First Class', 'C-c-A','Col C Side Seat', '1515');
Insert into passengers (fname,lname,gender,age,tel,class,seat,seattp,flightnum) 
			values ('Tsinat', 'Assefa', 'Female', 'Under 18', '+251987543546',  'Buissness Class', 'A-a-B', 'Col A Window Seat', '1616');
Insert into passengers (fname,lname,gender,age,tel,class,seat,seattp,flightnum) 
			values ('Rediet', 'Assfaw', 'Female', 'Under 18', '+251954654534',  'First Class', 'A-b-B', 'Col A Middle Seat', '1616');
Insert into passengers (fname,lname,gender,age,tel,class,seat,seattp,flightnum) 
			values ('Seifu', 'Melaku', 'Male', 'Under 18', '+147997896578',  'Economy Class', 'A-c-B', 'Col A Side Seat', '1717');
Insert into passengers (fname,lname,gender,age,tel,class,seat,seattp,flightnum) 
			values ('David', 'Blake', 'Male', 'Under 18', '+251976456734',  'First Class', 'B-a-B', 'Col B Window Seat', '1818');
Insert into passengers (fname,lname,gender,age,tel,class,seat,seattp,flightnum) 
			values ('Brian', 'Rashford', 'Male', 'Under 18', '+251955678943',  'Buissness Class', 'B-a-B', 'Col B Window Seat', '1919');
            
-- -----------------------------------------------------------------------------------------------------------------------------------

Create view displayall as SELECT * from passengers;
Create view rowcounting as SELECT COUNT(*) FROM passengers