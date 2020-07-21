/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.17-log : Database - db1
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db1` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `db1`;

/*Table structure for table `blog` */

CREATE TABLE `blog` (
  `id` varchar(50) DEFAULT NULL COMMENT '博客id',
  `title` varchar(100) DEFAULT NULL COMMENT '博客标题',
  `author` varchar(30) DEFAULT NULL COMMENT '博客作者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `views` int(30) DEFAULT NULL COMMENT '浏览量',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `blog` */

insert  into `blog`(`id`,`title`,`author`,`create_time`,`views`,`update_time`) values (NULL,'1',NULL,'2020-05-24 18:45:38',NULL,NULL),(NULL,'1',NULL,NULL,NULL,'2020-05-24 18:45:54');

/*Table structure for table `stu` */

CREATE TABLE `stu` (
  `id` int(11) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `score` double(5,2) DEFAULT NULL,
  `initData` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `stu` */

/*Table structure for table `student` */

CREATE TABLE `student` (
  `id` int(11) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `score` double(5,2) DEFAULT NULL,
  `initData` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `student` */

insert  into `student`(`id`,`name`,`birthday`,`score`,`initData`) values (1,'李梅','1998-05-12',12.00,'2020-02-03 00:40:59'),(2,'李离','1997-05-12',13.00,'2020-02-03 00:41:30'),(3,'李梅','1998-05-12',NULL,'2020-02-03 00:41:57');

/*Table structure for table `stus` */

CREATE TABLE `stus` (
  `id` int(11) DEFAULT NULL,
  `phone_number` varchar(20) DEFAULT NULL,
  UNIQUE KEY `phone_number` (`phone_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `stus` */

insert  into `stus`(`id`,`phone_number`) values (1,'张超'),(2,NULL),(3,NULL);

/*Table structure for table `user_temp` */

CREATE TABLE `user_temp` (
  `NAME` varchar(20) DEFAULT NULL,
  `math` int(11) DEFAULT NULL,
  `sex` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user_temp` */

insert  into `user_temp`(`NAME`,`math`,`sex`) values ('lili',12,'女'),('lise',13,'女'),('liase',14,'男'),('laerli',15,'女'),('liaefi',16,'女'),('lasdf',20,'男');

/*Table structure for table `usr` */

CREATE TABLE `usr` (
  `id` int(11) DEFAULT NULL COMMENT '用户Id',
  `username` varchar(20) DEFAULT NULL COMMENT '用户名称',
  `sex` varchar(1) DEFAULT NULL COMMENT '性别',
  `address` varchar(20) DEFAULT NULL COMMENT '住址',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `usr` */

insert  into `usr`(`id`,`username`,`sex`,`address`,`create_time`,`update_time`) values (1,'丽丽','女','上海市黄浦区大世界','2020-07-17 00:00:00','2020-07-17 00:00:00'),(2,'莉莉','女','上海市黄浦区大世界','2020-07-17 00:00:00','2020-07-17 00:00:00'),(3,'隶书','女','上海市黄浦区大世界','2020-07-17 00:00:00','2020-07-17 00:00:00'),(4,'丽丽','女','上海市黄浦区大世界','2020-07-17 00:00:00','2020-07-17 00:00:00'),(5,'李丽','女','上海市黄浦区大世界','2020-07-17 00:00:00','2020-07-17 00:00:00'),(6,'粒粒','女','上海市黄浦区大世界','2020-07-17 00:00:00','2020-07-17 00:00:00'),(7,'李黎','女','上海市黄浦区大世界','2020-07-17 00:00:00','2020-07-17 00:00:00');

/* Function  structure for function  `ferao1` */

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` FUNCTION `ferao1`() RETURNS int(11)
begin
	declare c int default 0;
	select count(*) into c
	from usr;
	return c;
end */$$
DELIMITER ;

/* Function  structure for function  `ferao2` */

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` FUNCTION `ferao2`(beautyName varchar(20)) RETURNS double
BEGIN
	set @sal=0;
	SELECT  id INTO @sal
	FROM usr;
	RETURN  @sal;
END */$$
DELIMITER ;

/* Function  structure for function  `ferao3` */

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` FUNCTION `ferao3`(beautyName varchar(20)) RETURNS double
BEGIN
	set @sal=0;
	SELECT  id INTO @sal
	FROM usr 
	where username=beautyName;
	RETURN  @sal;
END */$$
DELIMITER ;

/* Procedure structure for procedure `ferao_case1` */

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `ferao_case1`(in score int)
begin 
	case 
	
	when score>=90 and score<=100 then select 'A';
	when score>=80 then select 'B';
	when score>=60 then select 'C';
	else select 'D';
	end case;
END */$$
DELIMITER ;

/* Procedure structure for procedure `myp2` */

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `myp2`(in beautyName varchar(20))
begin
	select * from usr u where u.username=beautyName;
	
end */$$
DELIMITER ;

/* Procedure structure for procedure `myp3` */

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `myp3`(in ids int(10),IN beautyName VARCHAR(20))
BEGIN
	SELECT * FROM usr u WHERE u.id=ids  and u.username=beautyName;
	
END */$$
DELIMITER ;

/* Procedure structure for procedure `myp4` */

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `myp4`(in ids int(10),IN beautyName VARCHAR(20))
BEGIN
	declare result varchar(20) default '';  #声明并初始化
	SELECT count(*) into result  FROM usr u WHERE u.id=ids  and u.username=beautyName;
	
	
	select result; #使用
	
END */$$
DELIMITER ;

/* Procedure structure for procedure `myp5` */

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `myp5`(in ids int(10),IN beautyName VARCHAR(20))
BEGIN
	declare result varchar(20) default '';  #声明并初始化
	SELECT count(*) into result  FROM usr u WHERE u.id=ids  and u.username=beautyName;
	
	
	select if (result>0,'成功','失败'); #使用
	
END */$$
DELIMITER ;

/* Procedure structure for procedure `myp6` */

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `myp6`(IN ids INT(10),out beautyName VARCHAR(20))
BEGIN
	SELECT u.username  INTO beautyName  FROM usr u WHERE u.id=ids ;
	
END */$$
DELIMITER ;

/* Procedure structure for procedure `myp7` */

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `myp7`(inout a int,inout b int)
begin
set a=a*2;
set b=b*2;
end */$$
DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
