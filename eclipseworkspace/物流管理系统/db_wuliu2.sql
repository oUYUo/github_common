/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.1.49-community : Database - db_wuliu
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_wuliu` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `db_wuliu`;

/*Table structure for table `tb_carmessage` */

DROP TABLE IF EXISTS `tb_carmessage`;

CREATE TABLE `tb_carmessage` (
  `Code` int(11) NOT NULL AUTO_INCREMENT,
  `TradeMark` varchar(20) DEFAULT NULL,
  `Brand` varchar(50) DEFAULT NULL,
  `Style` varchar(30) DEFAULT NULL,
  `CarLoad` varchar(10) DEFAULT NULL,
  `UsedTime` varchar(50) DEFAULT NULL,
  `DriverName` varchar(30) DEFAULT NULL,
  `DriverTime` varchar(50) DEFAULT NULL,
  `LicenceNumber` varchar(50) DEFAULT NULL,
  `LicenceStyle` varchar(20) DEFAULT NULL,
  `TranspotStyle` varchar(20) DEFAULT NULL,
  `LinkMan` varchar(20) DEFAULT NULL,
  `LinkPhone` varchar(50) DEFAULT NULL,
  `Remark` varchar(100) DEFAULT NULL,
  `IssueDate` datetime DEFAULT NULL,
  `UserName` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Code`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

/*Data for the table `tb_carmessage` */

insert  into `tb_carmessage`(`Code`,`TradeMark`,`Brand`,`Style`,`CarLoad`,`UsedTime`,`DriverName`,`DriverTime`,`LicenceNumber`,`LicenceStyle`,`TranspotStyle`,`LinkMan`,`LinkPhone`,`Remark`,`IssueDate`,`UserName`) values (4,'吉AH432**','解放','车','34','3','张*明','6','452945934**','A类','长途','张先生','0431577*****','  经验丰富','2013-07-26 14:02:58','jjjj'),(11,'吉A-36**','捷达','轿车','200','3','张*军','5','220159357***','B类','短途','杨*洋','0431-4593****','  三成新的车','2013-07-26 14:02:58','杨*丽'),(17,'吉A-37**','面包','小车','200','3','付*春','35','2201258593***','A类','短途','杨*丽','130091****','  111111111','2013-07-26 14:02:58','bbbb'),(25,'吉A-7***','长挂141','大车','200','12','杨*小','5','220147258***','B','短途','吕*小','0431-4593***','车辆已经快要报废。','2013-07-26 14:02:58','mmmmmm'),(26,'吉AH5***','一气*威','重卡','90','2','王*民','5','jlc4127','A','长途','王先生','13152******','经验丰富','2013-07-26 14:02:58','ggg'),(27,'吉QT4***','平柴','141','40','4','庄*续平','5','吉4236**','A','长途','庄先生','1835*******','无','2013-07-26 14:02:58','ggg'),(28,'吉AW1***','一汽平柴','141','50','8','张*续','8','JLD46**','A','长途','张先生','0431-577****','经验丰富','2013-07-26 14:02:58','ggg'),(33,'吉A11','K货车','普通货车','100','1','在一','2','32','A','长途','上地','5353','  再接再厉 ','2013-07-26 14:02:58','00');

/*Table structure for table `tb_customer` */

DROP TABLE IF EXISTS `tb_customer`;

CREATE TABLE `tb_customer` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(20) DEFAULT NULL,
  `Password` varchar(16) DEFAULT NULL,
  `Email` varchar(30) DEFAULT NULL,
  `Sex` varchar(10) DEFAULT NULL,
  `Phone` varchar(50) DEFAULT NULL,
  `Question` varchar(50) DEFAULT NULL,
  `Result` varchar(50) DEFAULT NULL,
  `IssueDate` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `tb_customer` */

insert  into `tb_customer`(`ID`,`Name`,`Password`,`Email`,`Sex`,`Phone`,`Question`,`Result`,`IssueDate`) values (1,'tsoft','111','wy*#@1*3.com','man','131@@@@@','你是哪个学校毕业的','吉林大学','2007年12月10日 星期一'),(2,'00','000000','88@**.com','moman','10101','你好','你好','2007年12月12日 星期三');

/*Table structure for table `tb_enterprise` */

DROP TABLE IF EXISTS `tb_enterprise`;

CREATE TABLE `tb_enterprise` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `EnterpriseSort` varchar(50) DEFAULT NULL,
  `EnterpriseName` varchar(100) DEFAULT NULL,
  `Operation` varchar(100) DEFAULT NULL,
  `WorkArea` varchar(50) DEFAULT NULL,
  `Address` varchar(100) DEFAULT NULL,
  `Phone` varchar(200) DEFAULT NULL,
  `LinkMan` varchar(30) DEFAULT NULL,
  `HandSet` varchar(30) DEFAULT NULL,
  `Fax` varchar(30) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `Http` varchar(50) DEFAULT NULL,
  `Intro` varchar(200) DEFAULT NULL,
  `IssueDate` varchar(80) DEFAULT NULL,
  `UserName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

/*Data for the table `tb_enterprise` */

insert  into `tb_enterprise`(`ID`,`EnterpriseSort`,`EnterpriseName`,`Operation`,`WorkArea`,`Address`,`Phone`,`LinkMan`,`HandSet`,`Fax`,`Email`,`Http`,`Intro`,`IssueDate`,`UserName`) values (13,'股份制','乐*思服饰','服装','中国','长春市','0431-5772***','王女士','13844******','12345-522-***','w*@1*3.com','www.*f.com.cn','无','2005-02-08','11'),(14,'旅*社','亚*风情','旅*业','长春市','长春市','0431-657****','邓女士','13156******','231-564-***','d*@y*o.com.cn','www.c*c.com','无','2007-12-12','11'),(19,'通*公司','巨**科技有限公司','通*','长春市','长春市','0431-577****','王先生','13756******','123-741-*****','www.w*@y*o.com','www.g*w.com','暂无','2006-02-11','11'),(20,'制药','敦***集团公司','生产销售药品','吉林省','敦化市','0433-62*****','刘女士','13862******','325-890-******','ao*g@1*3.com','www.a*g.com','暂无','2006-02-11','11'),(21,'会计公司','红*公司','代理公司账务','吉林省','长春市吉林大路','0431-45*****','计*雅','13009******','0431-497****','m*@1*3.com','www.hon*i.com','无','2006-02-11','mmmmmm'),(22,'药业','千*药业公司','消炎药','吉林省','长春市','0431-49*****','李*冉','13009******','0431-497****','q*@1*.com','www.qi**n.com','无','2006-02-11','mmmmmm'),(24,'建筑','XX建筑公司','所有','长春','长春市二道区','8977','刘先生','13666**','0431-88**','88@**.com','http://www.o*.com','各种建材料均销售','2007-12-12','00');

/*Table structure for table `tb_goodsmeg` */

DROP TABLE IF EXISTS `tb_goodsmeg`;

CREATE TABLE `tb_goodsmeg` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `GoodsStyle` varchar(50) DEFAULT NULL,
  `GoodsName` varchar(100) DEFAULT NULL,
  `GoodsNumber` varchar(50) DEFAULT NULL,
  `GoodsUnit` varchar(50) DEFAULT NULL,
  `StartProvince` varchar(100) DEFAULT NULL,
  `StartCity` varchar(20) DEFAULT NULL,
  `EndProvince` varchar(30) DEFAULT NULL,
  `EndCity` varchar(30) DEFAULT NULL,
  `Style` varchar(50) DEFAULT NULL,
  `TransportTime` varchar(50) DEFAULT NULL,
  `Phone` varchar(50) DEFAULT NULL,
  `Link` varchar(200) DEFAULT NULL,
  `IssueDate` datetime DEFAULT NULL,
  `Remark` varchar(800) DEFAULT NULL,
  `Request` varchar(50) DEFAULT NULL,
  `UserName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;

/*Data for the table `tb_goodsmeg` */

insert  into `tb_goodsmeg`(`ID`,`GoodsStyle`,`GoodsName`,`GoodsNumber`,`GoodsUnit`,`StartProvince`,`StartCity`,`EndProvince`,`EndCity`,`Style`,`TransportTime`,`Phone`,`Link`,`IssueDate`,`Remark`,`Request`,`UserName`) values (11,'优质煤','优质煤','400',' 吨','山西省','大同市','吉林省','长春市','普通','2012-02-06','13756******','王先生','2013-07-26 13:12:55','注意安全','车况好','312'),(14,'煤','优质煤','400','吨','山西省','大同市','吉林省','长春市','快速','2012-03-03','13756******','王先生','2013-07-26 13:12:55','注意安全','车况好','11'),(16,'汽运','洗衣机','200','个','吉林省','长春','辽宁省','大连','快速','2012-02-13','0431-459****','杨*冉','2013-07-26 13:12:55','一定按时送达。','要求速度快，不要损坏货物','11'),(18,'建设用品','水泥','2000','吨','吉林省','长春','辽宁省','沈阳','普通','2012-02-13','0431-459****','杨*山','2013-07-26 13:12:55','运输途中一定要保证安全','快速行驶，','11'),(25,'鳄*鱼','混凝土','20000000','斤','吉林省','长春','黑龙江','黑河','普通','2012-03-03','0435-458****','李*阳','2013-07-26 13:12:55','注意安全','慢开慢走','11'),(26,'铁类物品','钢筋','30000','斤','黑龙江省','黑河','吉林省','长春','普通','2012-02-13','0435-589****','李*欣','2013-07-26 13:12:55','注意安全12\n156666','加速行驶','11'),(30,'精品红木','木头','2000','斤','吉林省','长春','辽宁省','沈阳','普通','2012-02-13','0431-45*****','杨*丽','2013-07-26 13:12:55','运输过程中一定要小心安全。','车辆一定要两成新。','11'),(34,'电子','手机','3000','个','吉林省','吉林市','黑龙江省','乌鲁木齐','加急','2012-02-11','0431-45*****','郭*威','2013-07-26 13:12:55','途中一定要注意安全。','要求车速加快，三天内一定要到达，否则予以罚款。','gggggg'),(35,' 电子','计算器','200',' 个','吉林省','长春市','辽宁省','长春市','普通','2012-03-05','0431-45*****','杨*心','2013-07-26 13:12:55','一定注意安全','一定注意','gggggg'),(37,' 建筑','楼房','200','栋','吉林省','长春市','黑龙江省','梅河市','普通','2012-02-11','0431-45*****','杨*阳','2013-07-26 13:12:55','途中一定要注意安全。','一定要快速到达目的地。','mmmmmm'),(40,'  药品','米*来宁','100','  盒','吉林省','吉林市','辽宁省','沈阳市','普通','2012-02-13','0431-45*****','吕*萌','2013-07-26 13:12:55','途中一定要保证药业不被淋湿。','车辆一定要慢行驶。','mmmmmm');

/*Table structure for table `tb_knowledge` */

DROP TABLE IF EXISTS `tb_knowledge`;

CREATE TABLE `tb_knowledge` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Title` varchar(50) DEFAULT NULL,
  `Content` varchar(2000) DEFAULT NULL,
  `IssueDate` datetime DEFAULT NULL,
  `Reside` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

/*Data for the table `tb_knowledge` */

insert  into `tb_knowledge`(`ID`,`Title`,`Content`,`IssueDate`,`Reside`) values (27,'车辆最近紧缺','      因天气变化，车辆最近出现紧缺情况，请各部分做好应急准备。','2013-07-26 13:09:55','车辆'),(28,'车辆停运','      因天气变化，最近的车辆一切暂时停运，具体的信息另行通知。','2013-07-26 13:09:55','车辆'),(29,'货物减少','      最近因天气变化，货物的发行情况不得很好，所以提醒各位，发货时一定要加小心，以免路滑发生意外情况。','2013-07-26 13:09:55','货物'),(32,'77','7777777777777777777777','2013-07-26 13:09:55','77');

/*Table structure for table `tb_logistics` */

DROP TABLE IF EXISTS `tb_logistics`;

CREATE TABLE `tb_logistics` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Title` varchar(50) DEFAULT NULL,
  `Content` varchar(2000) DEFAULT NULL,
  `Author` varchar(50) DEFAULT NULL,
  `IssueDate` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

/*Data for the table `tb_logistics` */

insert  into `tb_logistics`(`ID`,`Title`,`Content`,`Author`,`IssueDate`) values (9,'车辆紧缺','      近日，过年临近，各条线路均出现车辆紧缺的情况。望各有关部分做好应急准备。','刘刘','2013-07-26 13:08:30'),(12,'长途停运','      由于最近年期临近，加上最近天所变化，路面道滑，所有长途车辆暂时停时运行，运行日期另行通知。','无语','2013-07-26 13:08:30'),(13,'路面','   路面道滑','无语','2013-07-26 13:08:30'),(18,'车辆急缺','由于最近天气不好，一直下雪，所以长途车辆急缺，很多业主因天气状况不愿出行。','小草','2013-07-26 13:08:30');

/*Table structure for table `tb_manager` */

DROP TABLE IF EXISTS `tb_manager`;

CREATE TABLE `tb_manager` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) DEFAULT NULL,
  `Password` varchar(50) DEFAULT NULL,
  `Phone` varchar(50) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `tb_manager` */

insert  into `tb_manager`(`ID`,`Name`,`Password`,`Phone`,`Email`) values (1,'tsoft','111','55','dd'),(2,'tsdddd','ddd','01431-4972***213','tttt');

/*Table structure for table `tb_placard` */

DROP TABLE IF EXISTS `tb_placard`;

CREATE TABLE `tb_placard` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Title` varchar(50) DEFAULT NULL,
  `Content` varchar(1000) DEFAULT NULL,
  `Author` varchar(20) DEFAULT NULL,
  `IssueDate` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8;

/*Data for the table `tb_placard` */

insert  into `tb_placard`(`ID`,`Title`,`Content`,`Author`,`IssueDate`) values (16,'招聘管理员','  要求:\n      大专以上学历,有过相关工作经验.\n      有意者请与我们联系:\n         电话:0431-4972266\n         Email:mingrisoft@mingrisoft.com','11','2013-07-26 13:06:09'),(17,'关于我们的下一步计划','         HHHHHHHHHHH','11','2013-07-26 13:06:09'),(18,'寻求合作伙伴共同发展','     ssssss','m11','2013-07-26 13:06:09'),(20,'招聘开发人','      我想招聘一名VB的程序员，工资2000元，有意者面试','1','2013-07-26 13:06:09'),(31,'招聘经理','   1111','1','2013-07-26 13:06:09'),(50,'技术支持','代数式','1','2013-07-26 13:06:09'),(51,'学习百度','   事实上','1','2013-07-26 13:06:09'),(52,'我们需要您的支持','生生世世 ','1','2013-07-26 13:06:09'),(55,'网站公告','网站公告信息','Tsoft','2013-07-26 13:06:09');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
