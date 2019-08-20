/*
SQLyog Enterprise Trial - MySQL GUI v7.11 
MySQL - 5.5.62 : Database - techchefs_db_test_boot
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`techchefs_db_test_boot` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `techchefs_db_test_boot`;

/*Table structure for table `department_info` */

DROP TABLE IF EXISTS `department_info`;

CREATE TABLE `department_info` (
  `dept_id` int(11) NOT NULL,
  `dept_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`dept_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `department_info` */

/*Table structure for table `employee_addressinfo` */

DROP TABLE IF EXISTS `employee_addressinfo`;

CREATE TABLE `employee_addressinfo` (
  `address_type` varchar(255) NOT NULL,
  `address1` varchar(255) DEFAULT NULL,
  `address2` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `landmark` varchar(255) DEFAULT NULL,
  `pin` int(11) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `id` int(11) NOT NULL,
  PRIMARY KEY (`address_type`,`id`),
  KEY `FKi68wg3swrf520i2obr6k8cltx` (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `employee_addressinfo` */

insert  into `employee_addressinfo`(`address_type`,`address1`,`address2`,`city`,`country`,`landmark`,`pin`,`state`,`id`) values ('Permanent','3trtr','rftret','45rgfret','dfgsdg','dfgdfg',4,'erterwt',103),('Temporary','dfgdfg','fgdfg','gregt','sdfgdfsg','fdgsdfg',6,'fdgsg',103);

/*Table structure for table `employee_educationinfo` */

DROP TABLE IF EXISTS `employee_educationinfo`;

CREATE TABLE `employee_educationinfo` (
  `educational_type` varchar(255) NOT NULL,
  `college_nm` varchar(255) DEFAULT NULL,
  `degree_type` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `percentage` varchar(255) DEFAULT NULL,
  `university` varchar(255) DEFAULT NULL,
  `yop` varchar(255) DEFAULT NULL,
  `id` int(11) NOT NULL,
  PRIMARY KEY (`educational_type`,`id`),
  KEY `FKl9eoji4dbbtb657ho42yr6vbg` (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `employee_educationinfo` */

insert  into `employee_educationinfo`(`educational_type`,`college_nm`,`degree_type`,`location`,`percentage`,`university`,`yop`,`id`) values ('fdgfdg','dfgfdg','fgsdfg','fgdfgfsd','89','dfgsdg','2013-03-03',103),('fgdfg','acet','dfgdf','fgdfg','78','dfgdfg','2018-03-03',103);

/*Table structure for table `employee_experienceinfo` */

DROP TABLE IF EXISTS `employee_experienceinfo`;

CREATE TABLE `employee_experienceinfo` (
  `company_name` varchar(255) NOT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `joining_date` datetime DEFAULT NULL,
  `releaving_date` datetime DEFAULT NULL,
  `id` int(11) NOT NULL,
  PRIMARY KEY (`company_name`,`id`),
  KEY `FKd6dubcw4b3f7rfcxvn7vv7n2f` (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `employee_experienceinfo` */

insert  into `employee_experienceinfo`(`company_name`,`designation`,`joining_date`,`releaving_date`,`id`) values ('fghfsdfg','ghghfg','2019-12-31 00:00:00','2019-12-31 00:00:00',103),('gfhgfdhf','ghgfh','2019-12-31 00:00:00','2019-12-31 00:00:00',103);

/*Table structure for table `employee_info` */

DROP TABLE IF EXISTS `employee_info`;

CREATE TABLE `employee_info` (
  `id` int(11) NOT NULL,
  `account_number` bigint(20) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `dob` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `joining_date` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` bigint(20) DEFAULT NULL,
  `salary` double DEFAULT NULL,
  `department_id` int(11) DEFAULT NULL,
  `mngr_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9nilvpg2ofma71bkn6q4xqa6x` (`department_id`),
  KEY `FKhg74nlq3fefqxufct3oopx22l` (`mngr_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `employee_info` */

insert  into `employee_info`(`id`,`account_number`,`age`,`designation`,`dob`,`email`,`gender`,`joining_date`,`name`,`password`,`phone`,`salary`,`department_id`,`mngr_id`) values (103,5645614,12,'SD','2019-08-21 00:00:00','abhishekmahajan0312@gmail.com','male','2019-08-09 00:00:00','abhishek','123',4564,4564,NULL,NULL);

/*Table structure for table `employee_otherinfo` */

DROP TABLE IF EXISTS `employee_otherinfo`;

CREATE TABLE `employee_otherinfo` (
  `other_infoid` int(11) NOT NULL,
  `adhar` bigint(20) DEFAULT NULL,
  `blood_grp` varchar(255) DEFAULT NULL,
  `emergency_contact_number` bigint(20) DEFAULT NULL,
  `emergency_contact_person` varchar(255) DEFAULT NULL,
  `father_nm` varchar(255) DEFAULT NULL,
  `ischallenged` bit(1) DEFAULT NULL,
  `ismarried` bit(1) DEFAULT NULL,
  `mother_nm` varchar(255) DEFAULT NULL,
  `nationality` varchar(255) DEFAULT NULL,
  `pan` varchar(255) DEFAULT NULL,
  `passport` varchar(255) DEFAULT NULL,
  `religion` varchar(255) DEFAULT NULL,
  `spouse_nm` varchar(255) DEFAULT NULL,
  `id` int(11) NOT NULL,
  PRIMARY KEY (`other_infoid`),
  UNIQUE KEY `UK_7ql8x3aweacfm50kbbnywbwwf` (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `employee_otherinfo` */

insert  into `employee_otherinfo`(`other_infoid`,`adhar`,`blood_grp`,`emergency_contact_number`,`emergency_contact_person`,`father_nm`,`ischallenged`,`ismarried`,`mother_nm`,`nationality`,`pan`,`passport`,`religion`,`spouse_nm`,`id`) values (1,3453454,'o+',12045,'Abhishek','456gfgtgf','\0','\0','gfhdf','india','58456456','123456789','hindu','gfhfd',103);

/*Table structure for table `employee_traininginfo` */

DROP TABLE IF EXISTS `employee_traininginfo`;

CREATE TABLE `employee_traininginfo` (
  `course_id` int(11) NOT NULL,
  `id` int(11) NOT NULL,
  KEY `FKn0dv9nw5o6uwnttpicute2qyp` (`id`),
  KEY `FKq075vbbqmtshht34jj9ap2199` (`course_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `employee_traininginfo` */

/*Table structure for table `hibernate_sequence` */

DROP TABLE IF EXISTS `hibernate_sequence`;

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `hibernate_sequence` */

insert  into `hibernate_sequence`(`next_val`) values (2);

/*Table structure for table `training_info` */

DROP TABLE IF EXISTS `training_info`;

CREATE TABLE `training_info` (
  `course_id` int(11) NOT NULL,
  `course_name` varchar(255) DEFAULT NULL,
  `course_type` varchar(255) DEFAULT NULL,
  `duration` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`course_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `training_info` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
