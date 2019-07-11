/*
SQLyog Enterprise Trial - MySQL GUI v7.11 
MySQL - 5.7.22 : Database - techchefs_db_rds
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`techchefs_db` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `techchefs_db`;

/*Table structure for table `department_info` */

DROP TABLE IF EXISTS `department_info`;

CREATE TABLE `department_info` (
  `DEPT_ID` int(11) DEFAULT NULL,
  `DEPT_NAME` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `department_info` */

insert  into `department_info`(`DEPT_ID`,`DEPT_NAME`) values (1,'HR'),(2,'RECRUITMENT'),(3,'ACCOUNTS'),(4,'IT');

/*Table structure for table `emp_tranning` */

DROP TABLE IF EXISTS `emp_tranning`;

CREATE TABLE `emp_tranning` (
  `ID` int(11) DEFAULT NULL,
  `COURSE_ID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `emp_tranning` */

/*Table structure for table `employee_addressinfo` */

DROP TABLE IF EXISTS `employee_addressinfo`;

CREATE TABLE `employee_addressinfo` (
  `id` int(11) DEFAULT NULL,
  `ADDRESS_TYPE` varchar(50) DEFAULT NULL,
  `ADDRESS1` varchar(50) DEFAULT NULL,
  `ADDRESS2` varchar(50) DEFAULT NULL,
  `LANDMARK` varchar(50) DEFAULT NULL,
  `CITY` varchar(25) DEFAULT NULL,
  `STATE` varchar(50) DEFAULT NULL,
  `COUNTRY` varchar(50) DEFAULT NULL,
  `PIN` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `employee_addressinfo` */

insert  into `employee_addressinfo`(`id`,`ADDRESS_TYPE`,`ADDRESS1`,`ADDRESS2`,`LANDMARK`,`CITY`,`STATE`,`COUNTRY`,`PIN`) values (1,'Present','Colive',NULL,'naer','Bangalore','Karnataka','India',120354);

/*Table structure for table `employee_educational_info` */

DROP TABLE IF EXISTS `employee_educational_info`;

CREATE TABLE `employee_educational_info` (
  `ID` int(11) NOT NULL,
  `EDUCATIONAL_TYPE` varchar(50) DEFAULT NULL,
  `COLLEGE_NM` varchar(50) DEFAULT NULL,
  `UNIVERSITY` varchar(50) DEFAULT NULL,
  `YOP` varchar(50) DEFAULT NULL,
  `PERCENTAGE` varchar(50) DEFAULT NULL,
  `LOCATION` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `employee_educational_info` */

/*Table structure for table `employee_experience_info` */

DROP TABLE IF EXISTS `employee_experience_info`;

CREATE TABLE `employee_experience_info` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `COMPANY_NAME` varchar(25) DEFAULT NULL,
  `DESIGNATION` varchar(25) DEFAULT NULL,
  `JOINING_DATE` date DEFAULT NULL,
  `RELEAVING_DATE` date DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `employee_experience_info` */

/*Table structure for table `employee_info` */

DROP TABLE IF EXISTS `employee_info`;

CREATE TABLE `employee_info` (
  `id` int(11) NOT NULL,
  `Name` varchar(20) DEFAULT NULL,
  `Age` int(11) DEFAULT NULL,
  `Gender` varchar(10) DEFAULT NULL,
  `salary` double DEFAULT NULL,
  `phone` bigint(20) DEFAULT NULL,
  `joining_date` date DEFAULT NULL,
  `account_number` bigint(20) DEFAULT NULL,
  `email` varchar(32) DEFAULT NULL,
  `designation` varchar(20) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `dept_id` int(11) DEFAULT NULL,
  `mngr_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `employee_info` */

insert  into `employee_info`(`id`,`Name`,`Age`,`Gender`,`salary`,`phone`,`joining_date`,`account_number`,`email`,`designation`,`dob`,`dept_id`,`mngr_id`) values (1,'Abhishek',28,'Male',20000,9876543210,'2019-06-29',545456476514864,'abhi@gmail.com','Software Developer','1990-12-03',1,1),(2,'Megha',22,'Female',25000,9875642130,'2019-06-28',456156456434516,'megha@gmail.com','Software Developer','1992-02-01',2,2),(3,'Akash',25,'Male',40000,4489566236,'2014-05-05',564123456561788,'akash@gmail.com','Hardware Developer','1993-02-05',4,2),(4,'Raman',14,'Male',20000,7894561222,'2015-12-25',564125612514444,'raman@gmail.com','Manager','1991-01-25',3,3),(5,'Rahul',45,'Male',12000,9876542310,'2015-11-12',550022552200444,'rahul@gmail.com','HR','1992-12-05',1,4),(6,'Harish',56,'Male',21222,1125552236,'2015-11-13',502245214455233,'harish@gmail.com','Hardware Engineer','1976-04-11',2,4),(7,'Maninder',23,'Male',14552,1414774114,'2015-11-14',552236655544125,'maninder@gmail.com','Software Engineer','1996-07-05',4,1),(8,'Varun',32,'Male',44557,7894456116,'2015-11-15',788994562134545,'varun@gmail.com','HR','1986-02-05',1,5),(9,'Mohit',56,'Male',44125,7845569855,'2015-11-01',789254621311215,'mohit@gmail.com','Software Developer','1974-11-17',4,5),(10,'Ramith',41,'Male',44102,7455899658,'2015-11-11',784456544566122,'ramith@gmail.com','Software Developer','1988-09-28',3,7),(11,'Rakesh',34,'Male',100000,9876543210,'2019-02-02',12345678901,'rakesh@gmail.com','Software Developer','2000-02-01',2,3),(12,'Rakesh',34,'Male',100000,9876543210,'2019-02-02',12345678901,'rakesh@gmail.com','Software Developer','2000-02-01',2,3),(13,'Rakesh',34,'Male',100000,9543210,'2019-02-02',12345678901,'rakesh@gmail.com','Software_Developer','2014-02-02',2,3),(14,'Rakesh',34,'Male',100000,9543210,'2019-02-02',12345678901,'rakesh@gmail.com','Software_Developer','2014-02-02',2,3),(15,'Rakesh',34,'Male',100000,9543210,'2019-02-02',12345678901,'rakesh@gmail.com','Software Developer','2014-02-02',2,3),(16,'Rakesh',34,'Male',100000,9876543210,'2019-02-02',12345678901,'rakesh@gmail.com','Software Developer','2000-02-01',2,3);

/*Table structure for table `employee_otherinfo` */

DROP TABLE IF EXISTS `employee_otherinfo`;

CREATE TABLE `employee_otherinfo` (
  `id` int(11) DEFAULT NULL,
  `pan` varchar(15) DEFAULT NULL,
  `ismarried` tinyint(1) DEFAULT NULL,
  `blood_grp` varchar(5) DEFAULT NULL,
  `ischallenged` tinyint(1) DEFAULT NULL,
  `emergency_contact_number` bigint(20) DEFAULT NULL,
  `emergency_contact_person` varchar(25) DEFAULT NULL,
  `nationality` varchar(20) DEFAULT NULL,
  `religion` varchar(20) DEFAULT NULL,
  `father_nm` varchar(20) DEFAULT NULL,
  `mother_nm` varchar(20) DEFAULT NULL,
  `spouse_nm` varchar(20) DEFAULT NULL,
  `passport` varchar(20) DEFAULT NULL,
  `adhar` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `employee_otherinfo` */

insert  into `employee_otherinfo`(`id`,`pan`,`ismarried`,`blood_grp`,`ischallenged`,`emergency_contact_number`,`emergency_contact_person`,`nationality`,`religion`,`father_nm`,`mother_nm`,`spouse_nm`,`passport`,`adhar`) values (1,'81sf451',0,'b+',0,89789789789,'HK','Indian','Hindu','GK','Mk','Sm','fsdaf546',345345345),(2,'fd4564vgfd',0,'b-',0,897896786,'GD','Indian','Hindu','GD','MS','AM','sdfhi45345',467654345),(3,'sdf345er',0,'ab+',0,45345345,'Hari','Indian','Hindu','Hari','Madhu','JAck','dhfj34d',2545415415);

/*Table structure for table `tranning_info` */

DROP TABLE IF EXISTS `tranning_info`;

CREATE TABLE `tranning_info` (
  `COURSE_ID` int(11) DEFAULT NULL,
  `COURSE_NAME` varchar(30) DEFAULT NULL,
  `DURATION` varchar(30) DEFAULT NULL,
  `COURSE_TYPE` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tranning_info` */

insert  into `tranning_info`(`COURSE_ID`,`COURSE_NAME`,`DURATION`,`COURSE_TYPE`) values (1,'JAVA','3 MONTHS','CLASSROOM'),(2,'REACT','1 WEEK','CLASSROOM');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
