2016 1 29
/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.1.66-community : Database - db_fsba
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_fsba` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `db_fsba`;

/*Table structure for table `tb_arean` */

DROP TABLE IF EXISTS `tb_arean`;

CREATE TABLE `tb_arean` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '场地ID',
  `arean_title` varchar(200) DEFAULT NULL COMMENT '场地标题',
  `arean_title_img` varchar(200) DEFAULT NULL COMMENT '场地略缩图',
  `arean_introduce` varchar(1000) DEFAULT NULL COMMENT '场地介绍内容',
  `arean_linkman` varchar(50) DEFAULT NULL COMMENT '场地联系人姓名',
  `arean_phone_number` varchar(15) DEFAULT NULL COMMENT '场地联系号码',
  `arean_url` varchar(100) DEFAULT NULL COMMENT '场地url',
  `arean_address` varchar(100) DEFAULT NULL COMMENT '场地地址',
  `create_date` datetime DEFAULT NULL COMMENT '数据创建时间',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `update_date` datetime DEFAULT NULL COMMENT '数据修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人ID',
  `order_by` bigint(20) DEFAULT '100' COMMENT '排序字段',
  `delete_state` char(2) DEFAULT 'N' COMMENT '删除标记:N=未删除; Y=删除. 默认N',
  `delete_date` datetime DEFAULT NULL COMMENT '删除时间',
  `is_valid` char(2) DEFAULT 'Y' COMMENT '有效标记:Y=有效; N=无效. 默认Y',
  `version` int(11) DEFAULT '1' COMMENT '版本',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `tb_arean` */

insert  into `tb_arean`(`id`,`arean_title`,`arean_title_img`,`arean_introduce`,`arean_linkman`,`arean_phone_number`,`arean_url`,`arean_address`,`create_date`,`create_user_id`,`update_date`,`update_user_id`,`order_by`,`delete_state`,`delete_date`,`is_valid`,`version`) values (1,'FSBA篮球馆-长宁区绥宁路','A001.jpg',NULL,'阿飞','13011118888','view/arean/index.html','长宁区绥宁路628号','2016-01-21 11:37:15',NULL,NULL,NULL,100,'N',NULL,'Y',1),(2,'FSBA篮球馆-长宁区虹桥路','A002.jpg',NULL,'杰克','13866668888','view/arean/index.html','长宁区水城路628号','2016-01-21 11:40:58',NULL,NULL,NULL,100,'N',NULL,'Y',1);

/*Table structure for table `tb_ball_team` */

DROP TABLE IF EXISTS `tb_ball_team`;

CREATE TABLE `tb_ball_team` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '球队ID',
  `team_name` varchar(50) DEFAULT NULL COMMENT '球队名字',
  `team_occupant` varchar(50) DEFAULT NULL COMMENT '球队拥有者',
  `team_coach` varchar(50) DEFAULT NULL COMMENT '现任主教练',
  `team_chinese_name` varchar(30) DEFAULT NULL COMMENT '球队中文名',
  `team_english_name` varchar(50) DEFAULT NULL COMMENT '球队英文名',
  `team_nationality` varchar(30) DEFAULT NULL COMMENT '所属地区',
  `team_city` varchar(20) DEFAULT NULL COMMENT '所属城市',
  `team_declaration` varchar(200) DEFAULT NULL COMMENT '球队宣言',
  `team_birthdate` datetime DEFAULT NULL COMMENT '球队成立日期',
  `team_population` int(11) DEFAULT '0' COMMENT '球队人数',
  `team_photo_path` varchar(100) DEFAULT NULL COMMENT '球队头像路径',
  `champion_number` int(11) DEFAULT NULL COMMENT '获取冠军次数',
  `is_official_team` char(2) DEFAULT 'N' COMMENT '是否官方球队:N=不是官方球队; Y=是. 默认N',
  `approve_state` char(2) DEFAULT 'N' COMMENT '审核状态:N=未审核; NY=已申请审核; Y=已审核. 默认N',
  `is_disband` char(2) DEFAULT 'N' COMMENT '是否解散:N=未解散; NY=已申请解散; Y=已解散. 默认N',
  `team_honour` varchar(500) DEFAULT NULL COMMENT '主要荣誉备注',
  `team_remark` varchar(500) DEFAULT NULL COMMENT '详细备注',
  `sportswear_color` varchar(30) DEFAULT NULL COMMENT '球衣颜色',
  `create_date` datetime DEFAULT NULL COMMENT '数据创建时间',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `update_date` datetime DEFAULT NULL COMMENT '数据修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人ID',
  `order_by` bigint(20) DEFAULT NULL COMMENT '排序字段',
  `delete_state` char(2) DEFAULT 'N' COMMENT '删除标记:N=未删除; Y=删除. 默认N',
  `delete_date` datetime DEFAULT NULL COMMENT '删除时间',
  `is_valid` char(2) DEFAULT 'Y' COMMENT '有效标记:Y=有效; N=无效. 默认Y',
  `version` int(11) DEFAULT '1' COMMENT '版本',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `tb_ball_team` */

insert  into `tb_ball_team`(`id`,`team_name`,`team_occupant`,`team_coach`,`team_chinese_name`,`team_english_name`,`team_nationality`,`team_city`,`team_declaration`,`team_birthdate`,`team_population`,`team_photo_path`,`champion_number`,`is_official_team`,`approve_state`,`is_disband`,`team_honour`,`team_remark`,`sportswear_color`,`create_date`,`create_user_id`,`update_date`,`update_user_id`,`order_by`,`delete_state`,`delete_date`,`is_valid`,`version`) values (1,'亚特兰大老鹰队','迈克尔·吉隆和斯蒂文·普莱斯','迈克·布登霍尔泽','亚特兰大老鹰队','Atlanta Hawks','美国','城市',NULL,'2015-11-19 15:37:54',9,'teamDefault.jpg',44,'N','N','N','1958年得冠军','1958年得冠军','黄色','2015-11-19 15:39:01',5,'2015-12-04 18:12:50',5,1,'N',NULL,'Y',1),(4,'洛杉矶湖人队','吉姆·巴斯（Jim Buss）','拜伦·斯科特','洛杉矶湖人','L.A. Lakers','加利福尼亚州洛杉矶市','加利福尼亚州洛杉矶市',NULL,'2015-11-19 17:24:21',10,'teamDefault.jpg',55,'N','N','N','1951-1954年获得队史第一个三连冠','2008-2010年获得两连冠','','2015-11-19 17:24:21',NULL,'2015-11-19 17:24:21',NULL,NULL,'N',NULL,'Y',1),(10,'亚特兰大老鹰队2','杰里·雷恩斯多夫','汤姆·锡伯杜','芝加哥公牛队','','美国1','美国1',NULL,'1941-01-01 01:01:11',291,'teamDefault.jpg',1511,'N','N','N','1996-1998连续三个总冠军1','95-96赛季常规赛中取得72胜10负1','91','2015-11-19 17:24:21',10,'2015-12-02 17:18:51',10,NULL,'N',NULL,'Y',3),(11,'芝加哥公牛队1','杰里·雷恩斯多夫','汤姆·锡伯杜','芝加哥公牛队','Chicago Bulls','美国','美国',NULL,'1946-01-01 01:01:11',20,'teamDefault.jpg',155,'N','N','N','1996-1998连续三个总冠军','95-96赛季常规赛中取得72胜10负','','2015-12-08 16:47:54',6,'2015-12-08 16:47:54',6,100,'N',NULL,'Y',1),(13,'公牛队','','','','','美国','美国',NULL,'1946-01-01 01:01:11',NULL,'teamDefault.jpg',100,'N','N','N','','','','2015-12-15 11:52:51',5,'2015-12-15 11:52:51',5,100,'N',NULL,'Y',1),(14,'公牛aaaa队',NULL,'安东尼',NULL,NULL,NULL,'上海','要努力的',NULL,1,'teamDefault.jpg',NULL,'N','N','N',NULL,NULL,'红色','2016-01-04 15:27:17',5,'2016-01-04 15:27:17',5,100,'N',NULL,'Y',1);

/*Table structure for table `tb_ball_team_applicant` */

DROP TABLE IF EXISTS `tb_ball_team_applicant`;

CREATE TABLE `tb_ball_team_applicant` (
  `applicant_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '球员申请加入球队表ID(保存球员申请加入球队的数据)',
  `applicant_from_user_id` bigint(20) NOT NULL COMMENT '发起申请的用户ID',
  `applicant_from_alias_name` varchar(50) NOT NULL COMMENT '发起申请的用户昵称',
  `applicant_team_id` bigint(20) NOT NULL COMMENT '被申请的球队ID',
  `applicant_team_name` varchar(50) NOT NULL COMMENT '球队名字',
  `applicant_place` varchar(20) DEFAULT NULL COMMENT '发起申请事件的机器所在地',
  `applicant_ip` varchar(27) NOT NULL COMMENT '发起申请事件的机器IP',
  `is_official_team` char(2) DEFAULT 'N' COMMENT '是否官方球队:N=不是官方球队; Y=是. 默认N',
  `agree_state` char(2) NOT NULL DEFAULT 'N' COMMENT '同意状态:N=不同意; Y=同意; G=忽略. 默认N',
  `approve_state` char(2) DEFAULT 'N' COMMENT '审核状态:N=未审核; NY=已申请审核; Y=已审核. 默认N',
  `is_disband` char(2) DEFAULT 'N' COMMENT '是否解散:N=未解散; NY=已申请解散; Y=已解散. 默认N',
  `create_date` datetime DEFAULT NULL COMMENT '数据创建时间',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `update_date` datetime DEFAULT NULL COMMENT '数据修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人ID',
  `order_by` bigint(20) DEFAULT NULL COMMENT '排序字段',
  `delete_state` char(2) DEFAULT 'N' COMMENT '删除标记:N=未删除; Y=删除. 默认N',
  `delete_date` datetime DEFAULT NULL COMMENT '删除时间',
  `is_valid` char(2) DEFAULT 'Y' COMMENT '有效标记:Y=有效; N=无效. 默认Y',
  `version` int(11) DEFAULT '1' COMMENT '版本',
  PRIMARY KEY (`applicant_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `tb_ball_team_applicant` */

insert  into `tb_ball_team_applicant`(`applicant_id`,`applicant_from_user_id`,`applicant_from_alias_name`,`applicant_team_id`,`applicant_team_name`,`applicant_place`,`applicant_ip`,`is_official_team`,`agree_state`,`approve_state`,`is_disband`,`create_date`,`create_user_id`,`update_date`,`update_user_id`,`order_by`,`delete_state`,`delete_date`,`is_valid`,`version`) values (8,7,'cc',1,'亚特兰大老鹰队','ShangHai','0:0:0:0:0:0:0:1','N','N','N','N','2015-12-17 19:52:47',7,'2015-12-17 19:52:47',7,100,'N',NULL,'Y',1);

/*Table structure for table `tb_ball_team_invite` */

DROP TABLE IF EXISTS `tb_ball_team_invite`;

CREATE TABLE `tb_ball_team_invite` (
  `invite_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '邀请加入球队信息表ID(向球员发起的邀请)',
  `invite_from_user_id` bigint(20) NOT NULL COMMENT '邀请发起人ID',
  `invite_user_id` bigint(20) NOT NULL COMMENT '被邀请的用户ID',
  `invite_alias_name` varchar(50) NOT NULL COMMENT '被邀请的用户昵称',
  `invite_team_id` bigint(20) NOT NULL COMMENT '球队ID',
  `invite_team_name` varchar(50) NOT NULL COMMENT '球队名字',
  `invite_place` varchar(20) DEFAULT NULL COMMENT '发起邀请事件的机器所在地',
  `invite_ip` varchar(27) NOT NULL COMMENT '发起邀请事件的机器IP',
  `is_official_team` char(2) DEFAULT 'N' COMMENT '是否官方球队:N=不是官方球队; Y=是. 默认N',
  `agree_state` char(2) NOT NULL DEFAULT 'N' COMMENT '同意状态:N=不同意; Y=同意; G=忽略. 默认N',
  `approve_state` char(2) DEFAULT 'N' COMMENT '审核状态:N=未审核; NY=已申请审核; Y=已审核. 默认N',
  `is_disband` char(2) DEFAULT 'N' COMMENT '是否解散:N=未解散; NY=已申请解散; Y=已解散. 默认N',
  `create_date` datetime DEFAULT NULL COMMENT '数据创建时间',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `update_date` datetime DEFAULT NULL COMMENT '数据修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人ID',
  `order_by` bigint(20) DEFAULT NULL COMMENT '排序字段',
  `delete_state` char(2) DEFAULT 'N' COMMENT '删除标记:N=未删除; Y=删除. 默认N',
  `delete_date` datetime DEFAULT NULL COMMENT '删除时间',
  `is_valid` char(2) DEFAULT 'Y' COMMENT '有效标记:Y=有效; N=无效. 默认Y',
  `version` int(11) DEFAULT '1' COMMENT '版本',
  PRIMARY KEY (`invite_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `tb_ball_team_invite` */

insert  into `tb_ball_team_invite`(`invite_id`,`invite_from_user_id`,`invite_user_id`,`invite_alias_name`,`invite_team_id`,`invite_team_name`,`invite_place`,`invite_ip`,`is_official_team`,`agree_state`,`approve_state`,`is_disband`,`create_date`,`create_user_id`,`update_date`,`update_user_id`,`order_by`,`delete_state`,`delete_date`,`is_valid`,`version`) values (8,5,7,'cc',1,'亚特兰大老鹰队',NULL,'0:0:0:0:0:0:0:1','N','Y','N','N','2015-12-17 17:41:59',5,'2015-12-17 18:16:51',7,100,'N',NULL,'Y',2),(9,5,8,'liwu',1,'亚特兰大老鹰队',NULL,'0:0:0:0:0:0:0:1','N','N','N','N','2015-12-17 18:20:22',5,'2015-12-17 18:20:22',5,100,'N',NULL,'Y',1);

/*Table structure for table `tb_ball_team_ref` */

DROP TABLE IF EXISTS `tb_ball_team_ref`;

CREATE TABLE `tb_ball_team_ref` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '球队与球员关系表 ID',
  `team_id` bigint(20) NOT NULL COMMENT '球队ID',
  `ball_player_id` bigint(20) NOT NULL COMMENT '球员ID',
  `approve_state` char(2) NOT NULL DEFAULT 'N' COMMENT '审核状态:N=未审核; NY=已申请审核; Y=已审核. 默认N',
  `is_disband` char(2) NOT NULL DEFAULT 'N' COMMENT '是否解散:N=未解散; NY=已申请解散; Y=已解散. 默认N',
  `is_detach` char(2) NOT NULL DEFAULT 'N' COMMENT '移除球队标记:N=未移除; Y=移除. 默认N',
  `remark` varchar(30) DEFAULT NULL COMMENT '备注',
  `create_date` datetime DEFAULT NULL COMMENT '数据创建时间',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `update_date` datetime DEFAULT NULL COMMENT '数据修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人ID',
  `order_by` bigint(20) DEFAULT NULL COMMENT '排序字段',
  `delete_state` char(2) NOT NULL DEFAULT 'N' COMMENT '删除标记:N=未删除; Y=删除. 默认N',
  `delete_date` datetime DEFAULT NULL COMMENT '删除时间',
  `is_valid` char(2) NOT NULL DEFAULT 'Y' COMMENT '有效标记:Y=有效; N=无效. 默认Y',
  `version` int(11) DEFAULT '1' COMMENT '版本',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

/*Data for the table `tb_ball_team_ref` */

insert  into `tb_ball_team_ref`(`id`,`team_id`,`ball_player_id`,`approve_state`,`is_disband`,`is_detach`,`remark`,`create_date`,`create_user_id`,`update_date`,`update_user_id`,`order_by`,`delete_state`,`delete_date`,`is_valid`,`version`) values (21,11,6,'N','N','N',NULL,'2015-12-08 16:47:54',NULL,'2015-12-08 16:47:54',NULL,100,'N',NULL,'Y',1),(24,13,5,'N','N','N',NULL,'2015-12-15 11:52:51',5,'2015-12-15 11:52:51',5,100,'N',NULL,'Y',1),(25,1,5,'N','N','N',NULL,NULL,NULL,NULL,NULL,NULL,'N',NULL,'Y',1),(26,14,5,'N','N','N',NULL,'2016-01-04 15:27:17',5,'2016-01-04 15:27:17',5,100,'N',NULL,'Y',1),(27,1,6,'N','N','N',NULL,'2016-01-06 15:12:26',6,'2016-01-06 15:12:29',NULL,100,'N',NULL,'Y',1),(28,11,5,'N','N','N',NULL,'2016-01-24 19:27:28',5,'2016-01-24 19:27:37',5,NULL,'N',NULL,'Y',1);

/*Table structure for table `tb_basketball_player` */

DROP TABLE IF EXISTS `tb_basketball_player`;

CREATE TABLE `tb_basketball_player` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `position` varchar(20) DEFAULT NULL COMMENT '位置',
  `lively_degree` int(11) DEFAULT '0' COMMENT '活力度',
  `passion_degree` int(11) DEFAULT '0' COMMENT '热情度',
  `attack_degree` int(11) DEFAULT '0' COMMENT '攻击',
  `defend_degree` int(11) DEFAULT '0' COMMENT '防守',
  `hit_degree` int(11) DEFAULT '0' COMMENT '命中率',
  `talent_degree` int(11) DEFAULT '0' COMMENT '天赋',
  `player_photo_path` varchar(100) DEFAULT NULL COMMENT '球星卡图片路径',
  `grade` int(11) DEFAULT '1' COMMENT '等级',
  `dynamic_count` int(11) DEFAULT '0' COMMENT '动态数:发表了多少条动态',
  `focus_count` int(11) DEFAULT '0' COMMENT '关注数:关注了多少人',
  `goal_focus_count` int(11) DEFAULT '0' COMMENT '被关注数:被关注人数',
  `focus_team_count` int(11) DEFAULT '0' COMMENT '关注球队数:关注了多少个球队',
  `medal_config` varchar(600) DEFAULT NULL COMMENT '勋章配置',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `tb_basketball_player` */

insert  into `tb_basketball_player`(`id`,`user_id`,`position`,`lively_degree`,`passion_degree`,`attack_degree`,`defend_degree`,`hit_degree`,`talent_degree`,`player_photo_path`,`grade`,`dynamic_count`,`focus_count`,`goal_focus_count`,`focus_team_count`,`medal_config`) values (1,5,'SG',60,70,80,90,90,88,NULL,1,3,0,0,1,'md_001,md_002,md_003'),(2,6,'SG',64,55,11,16,70,45,NULL,1,2,0,1,0,'md_001,md_002'),(3,7,'SG',34,2,22,56,75,42,NULL,1,0,0,0,0,'md_001,md_002'),(4,8,'SG',45,64,83,38,53,35,NULL,1,0,0,0,0,'md_001,md_002'),(5,10,'SG',0,0,0,0,0,0,NULL,1,0,0,0,0,'md_001,md_002'),(6,12,'SG',0,0,0,0,0,0,NULL,1,0,0,0,0,'md_001,md_002'),(7,9,NULL,0,0,0,0,0,0,NULL,1,0,0,0,0,'md_001,md_002'),(8,13,NULL,0,0,0,0,0,0,NULL,NULL,0,0,0,NULL,NULL);

/*Table structure for table `tb_focus` */

DROP TABLE IF EXISTS `tb_focus`;

CREATE TABLE `tb_focus` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '关注个人表ID',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID(tb_user.id)',
  `user_focus_id` bigint(20) NOT NULL COMMENT '用户关注ID(tb_user.id)',
  `focus_date` datetime DEFAULT NULL COMMENT '关注时间',
  `is_valid` char(2) DEFAULT 'Y' COMMENT '有效标记:Y=有效; N=无效. 默认Y',
  `remark` varchar(20) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `tb_focus` */

insert  into `tb_focus`(`id`,`user_id`,`user_focus_id`,`focus_date`,`is_valid`,`remark`) values (10,5,6,'2015-12-29 14:24:31','Y',NULL),(12,13,13,'2016-01-20 11:36:51','Y',NULL),(13,5,5,'2016-01-20 17:11:28','Y',NULL);

/*Table structure for table `tb_machine_temp` */

DROP TABLE IF EXISTS `tb_machine_temp`;

CREATE TABLE `tb_machine_temp` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `machine_title` varchar(100) DEFAULT NULL COMMENT '机器标题',
  `machine_udid` varchar(100) DEFAULT NULL COMMENT '机器udid',
  `p1` varchar(100) DEFAULT NULL COMMENT 'p1',
  `p2` varchar(100) DEFAULT NULL COMMENT 'p1',
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '数据创建时间',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `order_by` bigint(20) DEFAULT '100' COMMENT '排序字段',
  `delete_state` char(2) DEFAULT 'N' COMMENT '删除标记:N=未删除; Y=删除. 默认N',
  `delete_date` datetime DEFAULT NULL COMMENT '删除时间',
  `is_valid` char(2) DEFAULT 'Y' COMMENT '有效标记:Y=有效; N=无效. 默认Y',
  `version` int(11) DEFAULT '1' COMMENT '版本',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_machine_temp` */

/*Table structure for table `tb_manager_user` */

DROP TABLE IF EXISTS `tb_manager_user`;

CREATE TABLE `tb_manager_user` (
  `manager_user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) NOT NULL COMMENT '用户名',
  `chinese_name` varchar(30) DEFAULT NULL COMMENT '中文名',
  `english_name` varchar(50) DEFAULT NULL COMMENT '英文名',
  `alias_name` varchar(50) DEFAULT NULL COMMENT '别名',
  `user_sex` char(2) NOT NULL DEFAULT 'M' COMMENT '性别:M=男; F=女. 默认M',
  `nationality` varchar(30) DEFAULT NULL COMMENT '国籍',
  `birthpace` varchar(30) DEFAULT NULL COMMENT '出生地',
  `birthdate` date DEFAULT NULL COMMENT '出生日期',
  `graduate_school` varchar(50) DEFAULT NULL COMMENT '毕业院校',
  `stature` int(11) DEFAULT NULL COMMENT '身高',
  `weight` int(11) DEFAULT NULL COMMENT '体重',
  `user_password` varchar(100) NOT NULL COMMENT '密码',
  `user_phone_number` varchar(15) NOT NULL COMMENT '手机号码',
  `user_identity_card` varchar(22) DEFAULT NULL COMMENT '身份证号码',
  `user_identity_card_img` varchar(100) DEFAULT NULL COMMENT '身份证件照片',
  `user_ic_photo` varchar(100) DEFAULT NULL COMMENT '身份证与本人的合照',
  `user_email` varchar(50) DEFAULT NULL COMMENT '电子邮箱',
  `user_photo_path` varchar(100) DEFAULT NULL COMMENT '用户头像路径',
  `user_address` varchar(100) DEFAULT NULL COMMENT '地址',
  `user_city` varchar(10) DEFAULT NULL COMMENT '城市',
  `dept_id` int(11) DEFAULT NULL COMMENT '部门ID',
  `post_id` int(11) DEFAULT NULL COMMENT '职位ID',
  `job_date` datetime DEFAULT NULL COMMENT '入职日期',
  `regedit_date` datetime DEFAULT NULL COMMENT '注册时间',
  `create_date` datetime DEFAULT NULL COMMENT '数据创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '数据修改时间',
  `order_by` bigint(20) DEFAULT NULL COMMENT '排序字段',
  `delete_state` char(2) DEFAULT 'N' COMMENT '删除标记:N=未删除; Y=删除. 默认N',
  `delete_date` datetime DEFAULT NULL COMMENT '删除时间',
  `is_valid` char(2) DEFAULT 'Y' COMMENT '有效标记:Y=有效; N=无效. 默认Y',
  `version` int(11) DEFAULT '1' COMMENT '版本',
  PRIMARY KEY (`manager_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_manager_user` */

/*Table structure for table `tb_news_comment` */

DROP TABLE IF EXISTS `tb_news_comment`;

CREATE TABLE `tb_news_comment` (
  `comment_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '评论表ID',
  `news_id` bigint(20) NOT NULL COMMENT '动态id(tb_player_news.id)',
  `user_id` bigint(20) NOT NULL COMMENT '评论人ID',
  `dialogue_user_id` bigint(20) DEFAULT NULL COMMENT '回复某用户的ID',
  `comment_content` varchar(500) DEFAULT NULL COMMENT '评论内容',
  `like_state` char(2) DEFAULT 'N' COMMENT '点赞标记:N=取消赞; Y=点赞. 默认N',
  `create_date` datetime DEFAULT NULL COMMENT '数据创建时间',
  `delete_state` char(2) DEFAULT 'N' COMMENT '删除标记:N=未删除; Y=删除. 默认N',
  `delete_date` datetime DEFAULT NULL COMMENT '删除时间',
  `is_valid` char(2) DEFAULT 'Y' COMMENT '有效标记:Y=有效; N=无效. 默认Y',
  PRIMARY KEY (`comment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `tb_news_comment` */

insert  into `tb_news_comment`(`comment_id`,`news_id`,`user_id`,`dialogue_user_id`,`comment_content`,`like_state`,`create_date`,`delete_state`,`delete_date`,`is_valid`) values (11,22,5,NULL,NULL,'Y','2016-01-23 16:47:36','N',NULL,'Y'),(12,21,5,NULL,NULL,'Y','2016-01-23 16:47:37','N',NULL,'Y'),(13,20,5,NULL,NULL,'Y','2016-01-23 16:47:39','N',NULL,'Y');

/*Table structure for table `tb_player_detail_score` */

DROP TABLE IF EXISTS `tb_player_detail_score`;

CREATE TABLE `tb_player_detail_score` (
  `score_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '个人得分详情ID',
  `player_id` bigint(20) DEFAULT NULL COMMENT '球员ID',
  `player_name` varchar(50) DEFAULT NULL COMMENT '球员姓名',
  `player_position` varchar(10) DEFAULT NULL COMMENT '球员位置',
  `tournament_id` bigint(20) DEFAULT NULL COMMENT '所属比赛ID',
  `tnt_process_id` bigint(20) DEFAULT NULL COMMENT '赛程ID',
  `player_team_id` bigint(20) DEFAULT NULL COMMENT '所属球队ID',
  `skill_enter_time` smallint(6) DEFAULT '0' COMMENT '上场时间',
  `skill_backboard` smallint(6) DEFAULT '0' COMMENT '篮板',
  `skill_assist` smallint(6) DEFAULT '0' COMMENT '助攻',
  `skill_foul` smallint(6) DEFAULT '0' COMMENT '犯规',
  `skill_steal` smallint(6) DEFAULT '0' COMMENT '抢断',
  `skill_fault` smallint(6) DEFAULT '0' COMMENT '失误',
  `skill_blocking` smallint(6) DEFAULT '0' COMMENT '盖帽',
  `skill_score` smallint(6) DEFAULT '0' COMMENT '得分',
  `ratio_shooting` varchar(10) DEFAULT NULL COMMENT '投篮.比如5-10',
  `ratio_third` varchar(10) DEFAULT NULL COMMENT '三分.比如5-10',
  `ratio_penalty` varchar(10) DEFAULT NULL COMMENT '罚球.比如5-10',
  `p1` varchar(10) DEFAULT NULL COMMENT 'p1',
  `p2` varchar(10) DEFAULT NULL COMMENT 'p2',
  `p3` varchar(10) DEFAULT NULL COMMENT 'p3',
  `create_date` datetime NOT NULL COMMENT '数据创建时间',
  `update_date` datetime NOT NULL COMMENT '数据修改时间',
  `order_by` bigint(20) DEFAULT NULL COMMENT '排序字段',
  `delete_state` char(2) NOT NULL DEFAULT 'N' COMMENT '删除标记:N=未删除; Y=删除. 默认N',
  `delete_date` datetime DEFAULT NULL COMMENT '删除时间',
  `is_valid` char(2) NOT NULL DEFAULT 'Y' COMMENT '有效标记:Y=有效; N=无效. 默认Y',
  `version` int(11) NOT NULL DEFAULT '1' COMMENT '版本',
  PRIMARY KEY (`score_id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

/*Data for the table `tb_player_detail_score` */

insert  into `tb_player_detail_score`(`score_id`,`player_id`,`player_name`,`player_position`,`tournament_id`,`tnt_process_id`,`player_team_id`,`skill_enter_time`,`skill_backboard`,`skill_assist`,`skill_foul`,`skill_steal`,`skill_fault`,`skill_blocking`,`skill_score`,`ratio_shooting`,`ratio_third`,`ratio_penalty`,`p1`,`p2`,`p3`,`create_date`,`update_date`,`order_by`,`delete_state`,`delete_date`,`is_valid`,`version`) values (1,11,'迈克-康利','G',1,1,1,23,0,32,2,54,4,9,0,'6-77','6-6','5-9',NULL,NULL,NULL,'2016-01-22 17:07:00','2016-01-22 17:07:02',NULL,'N',NULL,'Y',1),(2,12,'杰夫-格林','SG',1,1,1,23,0,3,25,3,7,9,0,'6-77','6-6','5-9',NULL,NULL,NULL,'2016-01-22 17:07:27','2016-01-22 17:07:27',NULL,'N',NULL,'Y',1),(3,13,'考特尼-李','C',1,1,1,23,0,3,4,2,67,9,0,'6-77','6-6','5-9',NULL,NULL,NULL,'2016-01-22 17:10:26','2016-01-22 17:10:31',NULL,'N',NULL,'Y',1),(4,14,'扎克-兰多夫','PG',1,1,1,23,56,2,4,3,46,6,0,'6-77','6-6','5-9',NULL,NULL,NULL,'2016-01-22 17:10:56','2016-01-22 17:10:56',NULL,'N',NULL,'Y',1),(5,15,'马克-加索尔','G/F',1,1,1,23,0,5,2,56,0,0,0,'6-77','6-6','5-9',NULL,NULL,NULL,'2016-01-22 17:11:00','2016-01-22 17:10:56',NULL,'N',NULL,'Y',1),(6,21,'泰-劳森','PG',1,1,4,23,3,255,2,56,65,56,0,'6-77','6-6','5-9',NULL,NULL,NULL,'2016-01-22 17:13:03','2016-01-22 17:13:05',NULL,'N',NULL,'Y',1),(7,22,'特雷沃-阿里扎','G/F',1,1,4,23,2,2,0,56,31,5,0,'6-77','6-6','5-9',NULL,NULL,NULL,'2016-01-22 17:13:03','2016-01-22 17:13:03',NULL,'N',NULL,'Y',1),(8,23,'詹姆斯-哈登','G/F',1,1,4,23,2,33,5,56,3,5,0,'6-77','6-6','5-9',NULL,NULL,NULL,'2016-01-22 17:13:03','2016-01-22 17:13:03',NULL,'N',NULL,'Y',1),(9,24,'特伦斯-琼斯','F',1,1,4,23,0,2,4,56,13,5,0,'6-77','6-6','5-9',NULL,NULL,NULL,'2016-01-22 17:13:03','2016-01-22 17:13:03',NULL,'N',NULL,'Y',1),(10,25,'德怀特-霍华德','F/C',1,1,4,23,5,2,6,56,1,5,0,'6-77','6-6','5-9',NULL,NULL,NULL,'2016-01-22 17:13:03','2016-01-22 17:13:03',NULL,'N',NULL,'Y',1),(12,31,'迈克-康利','G',1,2,1,23,5,7,58,71,55,6,0,'6-77','6-6','5-9',NULL,NULL,NULL,'2016-01-22 17:07:00','2016-01-22 17:07:02',NULL,'N',NULL,'Y',1),(13,32,'杰夫-格林','SG',1,2,1,23,8,8,8,5,5,5,0,'6-77','6-6','5-9',NULL,NULL,NULL,'2016-01-22 17:07:27','2016-01-22 17:07:27',NULL,'N',NULL,'Y',1),(14,33,'考特尼-李','C',1,2,1,23,7,9,9,56,0,5,0,'6-77','6-6','5-9',NULL,NULL,NULL,'2016-01-22 17:10:26','2016-01-22 17:10:31',NULL,'N',NULL,'Y',1),(15,34,'扎克-兰多夫','PG',1,2,1,23,4,6,0,56,4,23,0,'6-77','6-6','5-9',NULL,NULL,NULL,'2016-01-22 17:10:56','2016-01-22 17:10:56',NULL,'N',NULL,'Y',1),(16,35,'马克-加索尔','G/F',1,2,1,23,6,3,0,56,4,16,0,'6-77','6-6','5-9',NULL,NULL,NULL,'2016-01-22 17:11:00','2016-01-22 17:10:56',NULL,'N',NULL,'Y',1),(17,41,'泰-劳森','PG',1,2,10,23,3,2,5,64,78,78,0,'6-77','6-6','5-9',NULL,NULL,NULL,'2016-01-22 17:13:03','2016-01-22 17:13:05',NULL,'N',NULL,'Y',1),(18,42,'特雷沃-阿里扎','G/F',1,2,10,23,3,33,36,5,9,45,0,'6-77','6-6','5-9',NULL,NULL,NULL,'2016-01-22 17:13:03','2016-01-22 17:13:03',NULL,'N',NULL,'Y',1),(19,43,'詹姆斯-哈登','G/F',1,2,10,23,2,7,3,65,3,45,0,'6-77','6-6','5-9',NULL,NULL,NULL,'2016-01-22 17:13:03','2016-01-22 17:13:03',NULL,'N',NULL,'Y',1),(20,44,'特伦斯-琼斯','F',1,2,10,23,0,4,0,0,1,6,0,'6-77','6-6','5-9',NULL,NULL,NULL,'2016-01-22 17:13:03','2016-01-22 17:13:03',NULL,'N',NULL,'Y',1),(21,45,'德怀特-霍华德','F/C',1,2,10,23,4,33,25,96,3,0,0,'6-77','6-6','5-9',NULL,NULL,NULL,'2016-01-22 17:13:03','2016-01-22 17:13:03',NULL,'N',NULL,'Y',1),(22,51,'迈克-康利','G',1,3,4,23,77,3,5,9,2,36,0,'6-77','6-6','5-9',NULL,NULL,NULL,'2016-01-22 17:07:00','2016-01-22 17:07:02',NULL,'N',NULL,'Y',1),(23,52,'杰夫-格林','SG',1,3,4,23,1,6,58,8,1,1,0,'6-77','6-6','5-9',NULL,NULL,NULL,'2016-01-22 17:07:27','2016-01-22 17:07:27',NULL,'N',NULL,'Y',1),(24,53,'考特尼-李','C',1,3,4,23,0,5,8,0,2,1,0,'6-77','6-6','5-9',NULL,NULL,NULL,'2016-01-22 17:10:26','2016-01-22 17:10:31',NULL,'N',NULL,'Y',1),(25,54,'扎克-兰多夫','PG',1,3,4,23,2,33,0,8,3,0,0,'6-77','6-6','5-9',NULL,NULL,NULL,'2016-01-22 17:10:56','2016-01-22 17:10:56',NULL,'N',NULL,'Y',1),(26,55,'马克-加索尔','G/F',1,3,4,23,0,8,0,8,5,0,0,'6-77','6-6','5-9',NULL,NULL,NULL,'2016-01-22 17:11:00','2016-01-22 17:10:56',NULL,'N',NULL,'Y',1),(27,61,'泰-劳森','PG',1,3,10,23,7,7,6,8,4,5,0,'6-77','6-6','5-9',NULL,NULL,NULL,'2016-01-22 17:13:03','2016-01-22 17:13:05',NULL,'N',NULL,'Y',1),(28,62,'特雷沃-阿里扎','G/F',1,3,10,23,7,46,6,96,8,5,0,'6-77','6-6','5-9',NULL,NULL,NULL,'2016-01-22 17:13:03','2016-01-22 17:13:03',NULL,'N',NULL,'Y',1),(29,63,'詹姆斯-哈登','G/F',1,3,10,23,7,46,32,6,6,5,0,'6-77','6-6','5-9',NULL,NULL,NULL,'2016-01-22 17:13:03','2016-01-22 17:13:03',NULL,'N',NULL,'Y',1),(30,64,'特伦斯-琼斯','F',1,3,10,23,4,5,32,6,3,5,0,'6-77','6-6','5-9',NULL,NULL,NULL,'2016-01-22 17:13:03','2016-01-22 17:13:03',NULL,'N',NULL,'Y',1),(31,65,'德怀特-霍华德','F/C',1,3,10,23,22,2,3,65,2,2,0,'6-77','6-6','5-9',NULL,NULL,NULL,'2016-01-22 17:13:03','2016-01-22 17:13:03',NULL,'N',NULL,'Y',1);

/*Table structure for table `tb_player_focus_team` */

DROP TABLE IF EXISTS `tb_player_focus_team`;

CREATE TABLE `tb_player_focus_team` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '关注球队表ID',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID(tb_user.id)',
  `team_id` bigint(20) NOT NULL COMMENT '球队ID(tb_ball_team.id)',
  `team_name` varchar(50) NOT NULL COMMENT '球队名称',
  `focus_date` datetime NOT NULL COMMENT '关注时间',
  `is_valid` char(2) NOT NULL COMMENT '是否取消关注标记。Y = 取消关注; 默认N',
  `remark` varchar(20) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `tb_player_focus_team` */

insert  into `tb_player_focus_team`(`id`,`user_id`,`team_id`,`team_name`,`focus_date`,`is_valid`,`remark`) values (5,5,1,'亚特兰大老鹰队','2015-12-29 14:59:04','N',NULL),(6,5,4,'洛杉矶湖人队','2015-12-29 14:59:19','Y',NULL);

/*Table structure for table `tb_player_news` */

DROP TABLE IF EXISTS `tb_player_news`;

CREATE TABLE `tb_player_news` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '球员发布动态表ID',
  `player_id` bigint(20) NOT NULL COMMENT '发布动态的球员',
  `from_news_id` bigint(20) DEFAULT NULL COMMENT '转发动态-引用的动态数据ID',
  `from_news_convey` varchar(100) DEFAULT NULL COMMENT '转发动态-表达文本',
  `news_source` varchar(50) DEFAULT NULL COMMENT '动态来源',
  `machine_place` varchar(20) DEFAULT NULL COMMENT '终端设备所在地',
  `machine_ip` varchar(27) NOT NULL COMMENT '终端设备IP',
  `news_content` varchar(500) DEFAULT NULL COMMENT '发布的文本内容',
  `news_bmiddle_Image` varchar(800) DEFAULT NULL COMMENT '中等尺寸图片地址',
  `news_original_Image` varchar(800) DEFAULT NULL COMMENT '原始图片地址',
  `news_thumbnail_Image` varchar(800) DEFAULT NULL COMMENT '缩略图片地址',
  `transpond_count` bigint(20) DEFAULT '0' COMMENT '转发次数',
  `comments_count` bigint(20) DEFAULT '0' COMMENT '评论数',
  `browse_count` bigint(20) DEFAULT '0' COMMENT '浏览次数',
  `praise_count` bigint(20) DEFAULT '0' COMMENT '点赞次数',
  `public_state` char(2) DEFAULT 'Y' COMMENT '公开状态:N=不公开; Y=公开. 默认Y',
  `assign_state` char(2) DEFAULT 'N' COMMENT '是否指定人看动态:N=不指定; Y=指定. 默认N',
  `create_date` datetime DEFAULT NULL COMMENT '数据创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人ID',
  `update_date` datetime DEFAULT NULL COMMENT '数据修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人ID',
  `order_by` bigint(20) DEFAULT '100' COMMENT '排序字段',
  `delete_state` char(2) DEFAULT 'N' COMMENT '删除标记:N=未删除; Y=删除. 默认N',
  `delete_date` datetime DEFAULT NULL COMMENT '删除时间',
  `approve_state` char(2) DEFAULT 'N' COMMENT '审核状态:N=未审核; NY=已申请审核; Y=已审核. 默认N',
  `is_valid` char(2) DEFAULT 'Y' COMMENT '有效标记:Y=有效; N=无效. 默认Y',
  `version` int(11) DEFAULT '1' COMMENT '版本',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

/*Data for the table `tb_player_news` */

insert  into `tb_player_news`(`id`,`player_id`,`from_news_id`,`from_news_convey`,`news_source`,`machine_place`,`machine_ip`,`news_content`,`news_bmiddle_Image`,`news_original_Image`,`news_thumbnail_Image`,`transpond_count`,`comments_count`,`browse_count`,`praise_count`,`public_state`,`assign_state`,`create_date`,`create_user_id`,`update_date`,`update_user_id`,`order_by`,`delete_state`,`delete_date`,`approve_state`,`is_valid`,`version`) values (13,5,NULL,NULL,NULL,NULL,'0:0:0:0:0:0:0:1','1111111这个app挺好玩，我们先去比赛了，你在家宅着看电视吧',NULL,'1450870826940_0.jpg;',NULL,0,4,0,3,'Y','N','2015-12-23 19:40:53',5,'2015-12-23 19:40:53',5,100,'Y','2015-12-29 14:23:32','N','Y',2),(14,10,NULL,NULL,NULL,'sasasa','192.168.0.105','Qqqqqqqqq ',NULL,'1450870982490_0.png;1450870982492_1.png;',NULL,0,0,0,0,'Y','N','2015-12-23 19:43:44',10,'2015-12-23 19:43:44',10,100,'N',NULL,'N','Y',1),(15,5,NULL,NULL,NULL,NULL,'0:0:0:0:0:0:0:1','1229这个app挺好玩，我们先去比赛了，你在家宅着看电视吧',NULL,NULL,NULL,0,0,0,0,'Y','N','2015-12-29 14:07:48',5,'2015-12-29 14:07:48',5,100,'N',NULL,'N','Y',1),(16,5,NULL,NULL,NULL,NULL,'0:0:0:0:0:0:0:1','1229这个app挺好玩，我们先去比赛了，你在家宅着看电视吧',NULL,NULL,NULL,0,0,0,0,'Y','N','2015-12-29 14:09:22',5,'2015-12-29 14:09:22',5,100,'N',NULL,'N','Y',1),(17,5,NULL,NULL,NULL,NULL,'0:0:0:0:0:0:0:1','1111这个app挺好玩，我们先去比赛了，你在家宅着看电视吧',NULL,'89369D1EF_29EAFC8#D#F9078A#D3039_0.jpg;',NULL,1,0,0,0,'Y','N','2015-12-29 15:28:29',5,'2015-12-29 15:28:29',5,100,'N',NULL,'N','Y',1),(18,5,NULL,NULL,NULL,NULL,'0:0:0:0:0:0:0:1','2016这个app挺好玩，我们先去比赛了，你在家宅着看电视吧',NULL,'726C7BE0BFE_G02891C71C_DE26FE2FC_0.jpg;',NULL,0,0,0,0,'Y','N','2016-01-04 12:19:45',5,'2016-01-04 12:19:45',5,100,'N',NULL,'N','Y',1),(19,6,NULL,NULL,NULL,NULL,'0:0:0:0:0:0:0:1','120这个app挺好玩，我们先去比赛了，你在家宅着看电视吧',NULL,NULL,NULL,0,0,0,0,'Y','N','2016-01-20 15:57:35',6,'2016-01-20 15:57:35',6,100,'N',NULL,'N','Y',1),(20,6,NULL,NULL,NULL,NULL,'0:0:0:0:0:0:0:1','2016120这个app挺好玩，我们先去比赛了，你在家宅着看电视吧',NULL,NULL,NULL,1,0,0,2,'Y','N','2016-01-20 15:57:53',6,'2016-01-20 15:57:53',6,100,'N',NULL,'N','Y',1),(21,5,20,'测试转发',NULL,NULL,'0:0:0:0:0:0:0:1',NULL,NULL,NULL,NULL,0,0,0,1,'Y','N','2016-01-20 17:10:54',5,'2016-01-20 17:10:54',5,100,'N',NULL,'N','Y',1),(22,5,17,'转发1111',NULL,NULL,'0:0:0:0:0:0:0:1',NULL,NULL,NULL,NULL,0,0,0,1,'Y','N','2016-01-20 17:56:19',5,'2016-01-20 17:56:19',5,100,'N',NULL,'N','Y',1);

/*Table structure for table `tb_team_tactic` */

DROP TABLE IF EXISTS `tb_team_tactic`;

CREATE TABLE `tb_team_tactic` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '战术ID',
  `tactic_title` varchar(200) DEFAULT NULL COMMENT '战术标题',
  `tactic_title_img` varchar(200) DEFAULT NULL COMMENT '战术略缩图',
  `tactic_body` varchar(1000) DEFAULT NULL COMMENT '战术文字内容',
  `tactic_video_path` varchar(200) DEFAULT NULL COMMENT '战术视频地址',
  `create_date` datetime DEFAULT NULL COMMENT '数据创建时间',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `update_date` datetime DEFAULT NULL COMMENT '数据修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人ID',
  `order_by` bigint(20) DEFAULT '100' COMMENT '排序字段',
  `delete_state` char(2) DEFAULT 'N' COMMENT '删除标记:N=未删除; Y=删除. 默认N',
  `delete_date` datetime DEFAULT NULL COMMENT '删除时间',
  `is_valid` char(2) DEFAULT 'Y' COMMENT '有效标记:Y=有效; N=无效. 默认Y',
  `version` int(11) DEFAULT '1' COMMENT '版本',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `tb_team_tactic` */

insert  into `tb_team_tactic`(`id`,`tactic_title`,`tactic_title_img`,`tactic_body`,`tactic_video_path`,`create_date`,`create_user_id`,`update_date`,`update_user_id`,`order_by`,`delete_state`,`delete_date`,`is_valid`,`version`) values (1,'掩护配合战术','tc001.png','是破坏掩护配合的一种方法。进攻队员利用掩护已经摆脱防守时，防掩护的队员及时发出换防的信号，与同伴互换各自的对手',NULL,'2016-01-15 15:43:48',NULL,'2016-01-15 15:43:58',NULL,100,'N',NULL,'Y',1),(2,'交换防守配合战术','tc002.png','是破坏掩护配合的一种方法。进攻队员利用掩护已经摆脱防守时，防掩护的队员及时发出换防的信号，与同伴互换各自的对手。在适当时候在换防原来的对手。',NULL,'2016-01-15 15:44:25',NULL,'2016-01-15 15:44:28',NULL,100,'N',NULL,'Y',1);

/*Table structure for table `tb_tnt_applicant` */

DROP TABLE IF EXISTS `tb_tnt_applicant`;

CREATE TABLE `tb_tnt_applicant` (
  `tnt_alt_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '申请参赛表ID',
  `from_user_id` bigint(20) NOT NULL COMMENT '发起申请的用户ID',
  `tnt_id` bigint(20) NOT NULL COMMENT '赛事ID',
  `alt_team_id` bigint(20) NOT NULL COMMENT '申请的球队ID',
  `alt_team_name` varchar(50) NOT NULL COMMENT '球队名字',
  `applicant_place` varchar(20) DEFAULT NULL COMMENT '发起申请事件的机器所在地',
  `applicant_ip` varchar(27) NOT NULL COMMENT '发起申请事件的机器IP',
  `is_official_team` char(2) DEFAULT 'N' COMMENT '是否官方球队:N=不是官方球队; Y=是. 默认N',
  `agree_state` char(2) NOT NULL DEFAULT 'N' COMMENT '同意状态:N=未处理状态; Y=同意; G=忽略. 默认N',
  `approve_state` char(2) DEFAULT 'N' COMMENT '审核状态:N=未处理状态; NY=已申请审核; Y=已审核. 默认N',
  `create_date` datetime DEFAULT NULL COMMENT '数据创建时间',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `update_date` datetime DEFAULT NULL COMMENT '数据修改时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人ID',
  `order_by` bigint(20) DEFAULT NULL COMMENT '排序字段',
  `delete_state` char(2) DEFAULT 'N' COMMENT '删除标记:N=未删除; Y=删除. 默认N',
  `delete_date` datetime DEFAULT NULL COMMENT '删除时间',
  `is_valid` char(2) DEFAULT 'Y' COMMENT '有效标记:Y=有效; N=无效. 默认Y',
  `version` int(11) DEFAULT '1' COMMENT '版本',
  PRIMARY KEY (`tnt_alt_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `tb_tnt_applicant` */

insert  into `tb_tnt_applicant`(`tnt_alt_id`,`from_user_id`,`tnt_id`,`alt_team_id`,`alt_team_name`,`applicant_place`,`applicant_ip`,`is_official_team`,`agree_state`,`approve_state`,`create_date`,`create_user_id`,`update_date`,`update_user_id`,`order_by`,`delete_state`,`delete_date`,`is_valid`,`version`) values (1,5,1,1,'亚特兰大老鹰队','上海','0:0:0:0:0:0:0:1','N','N','N','2016-01-29 11:28:34',5,'2016-01-29 11:28:34',5,100,'N',NULL,'Y',1);

/*Table structure for table `tb_tournament` */

DROP TABLE IF EXISTS `tb_tournament`;

CREATE TABLE `tb_tournament` (
  `tournament_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '赛事ID',
  `tournament_code` varchar(200) DEFAULT NULL COMMENT '赛事编码',
  `tournament_name` varchar(60) NOT NULL COMMENT '赛事名称',
  `tournament_chinese_name` varchar(60) DEFAULT NULL COMMENT '中文名',
  `tournament_english_name` varchar(60) DEFAULT NULL COMMENT '英文名',
  `tournament_alias_name` varchar(60) DEFAULT NULL COMMENT '别名',
  `tournament_major_sponsor` varchar(60) DEFAULT NULL COMMENT '主办方',
  `tournament_sponsor` varchar(800) DEFAULT NULL COMMENT '赞助商',
  `tournament_pace` varchar(30) NOT NULL COMMENT '举办地点',
  `tournament_city` varchar(10) NOT NULL COMMENT '举办所在城市',
  `tournament_date` datetime NOT NULL COMMENT '举办时间',
  `enroll_start_date` datetime NOT NULL COMMENT '报名开始时间',
  `enroll_end_date` datetime NOT NULL COMMENT '报名结束时间',
  `tournament_start_date` datetime NOT NULL COMMENT '比赛开始时间',
  `tournament_end_date` datetime NOT NULL COMMENT '比赛结束时间',
  `tournament_phone_number` varchar(15) DEFAULT NULL COMMENT '赛事咨询电话号码',
  `tournament_qq_number` varchar(15) DEFAULT NULL COMMENT '赛事咨询QQ号码',
  `tournament_weix_number` varchar(40) DEFAULT NULL COMMENT '赛事咨询微信号码',
  `tournament_weib_number` varchar(40) DEFAULT NULL COMMENT '赛事咨询微博号码',
  `tournament_photo_path` varchar(100) DEFAULT NULL COMMENT '赛事Logo',
  `tournament_remark` varchar(2000) DEFAULT NULL COMMENT '赛事备注',
  `p1` varchar(100) DEFAULT NULL COMMENT '扩展字段',
  `p2` varchar(100) DEFAULT NULL COMMENT '扩展字段',
  `p3` varchar(100) DEFAULT NULL COMMENT '扩展字段',
  `tournament_state` char(2) NOT NULL DEFAULT 'W' COMMENT '比赛状态: W=系统待办;E=接受报名;C=审核;S=已开赛;D=比赛已结束',
  `enroll_valid` char(2) NOT NULL DEFAULT 'Y' COMMENT '报名是否在有效日期内:Y=有效期内;N=已过期. 默认Y',
  `create_date` datetime NOT NULL COMMENT '数据创建时间',
  `update_date` datetime NOT NULL COMMENT '数据修改时间',
  `order_by` bigint(20) DEFAULT NULL COMMENT '排序字段',
  `delete_state` char(2) NOT NULL DEFAULT 'N' COMMENT '删除标记:N=未删除; Y=删除. 默认N',
  `delete_date` datetime DEFAULT NULL COMMENT '删除时间',
  `is_valid` char(2) NOT NULL DEFAULT 'Y' COMMENT '有效标记:Y=有效; N=无效. 默认Y',
  `version` int(11) NOT NULL DEFAULT '1' COMMENT '版本',
  PRIMARY KEY (`tournament_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `tb_tournament` */

insert  into `tb_tournament`(`tournament_id`,`tournament_code`,`tournament_name`,`tournament_chinese_name`,`tournament_english_name`,`tournament_alias_name`,`tournament_major_sponsor`,`tournament_sponsor`,`tournament_pace`,`tournament_city`,`tournament_date`,`enroll_start_date`,`enroll_end_date`,`tournament_start_date`,`tournament_end_date`,`tournament_phone_number`,`tournament_qq_number`,`tournament_weix_number`,`tournament_weib_number`,`tournament_photo_path`,`tournament_remark`,`p1`,`p2`,`p3`,`tournament_state`,`enroll_valid`,`create_date`,`update_date`,`order_by`,`delete_state`,`delete_date`,`is_valid`,`version`) values (1,'','上海熊猫杯',NULL,NULL,NULL,NULL,NULL,'上海市长宁区水城南路88号球场','上海','2016-02-01 14:18:36','2016-02-02 14:18:49','2016-02-04 14:18:58','2016-02-04 14:19:02','2016-02-06 14:19:07',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'E','Y','2016-01-22 14:20:06','2016-01-22 14:20:08',100,'N',NULL,'Y',1),(2,NULL,'上海FSBA荣誉杯',NULL,NULL,NULL,NULL,NULL,'北京门头沟区XXX号','北京','2016-02-02 14:22:18','2016-02-04 14:22:32','2016-02-06 14:22:37','2016-02-08 14:22:41','2016-02-12 14:22:52',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'W','Y','2016-01-22 14:23:04','2016-01-22 14:23:07',100,'N',NULL,'Y',1);

/*Table structure for table `tb_tournament_process` */

DROP TABLE IF EXISTS `tb_tournament_process`;

CREATE TABLE `tb_tournament_process` (
  `process_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '赛程ID',
  `tournament_id` bigint(20) DEFAULT NULL COMMENT '赛事ID',
  `tournament_host_team_id` bigint(20) DEFAULT NULL COMMENT '主队球队ID',
  `tournament_host_team_name` varchar(50) DEFAULT NULL COMMENT '主队球队名称',
  `tournament_guest_team_id` bigint(20) DEFAULT NULL COMMENT '客队球队ID',
  `tournament_guest_team_name` varchar(50) DEFAULT NULL COMMENT '客队球队名称',
  `host_team_score` varchar(50) DEFAULT NULL COMMENT '主队球队每局总分-格式用,隔开',
  `guest_team_score` varchar(50) DEFAULT NULL COMMENT '客队球队每局总分-格式用,隔开',
  `tournament_start_date` datetime NOT NULL COMMENT '比赛开始时间',
  `tournament_end_date` datetime NOT NULL COMMENT '比赛结束时间',
  `tournament_state` char(2) NOT NULL DEFAULT 'W' COMMENT '比赛状态: W=准备中;S=进行中;E=已结束',
  `remark` varchar(1000) DEFAULT NULL COMMENT '赛事备注',
  `p1` varchar(100) DEFAULT NULL COMMENT 'p1',
  `p2` varchar(100) DEFAULT NULL COMMENT 'p2',
  `p3` varchar(100) DEFAULT NULL COMMENT 'p3',
  `create_date` datetime NOT NULL COMMENT '数据创建时间',
  `update_date` datetime NOT NULL COMMENT '数据修改时间',
  `order_by` bigint(20) DEFAULT NULL COMMENT '排序字段',
  `delete_state` char(2) NOT NULL DEFAULT 'N' COMMENT '删除标记:N=未删除; Y=删除. 默认N',
  `delete_date` datetime DEFAULT NULL COMMENT '删除时间',
  `is_valid` char(2) NOT NULL DEFAULT 'Y' COMMENT '有效标记:Y=有效; N=无效. 默认Y',
  `version` int(11) NOT NULL DEFAULT '1' COMMENT '版本',
  PRIMARY KEY (`process_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `tb_tournament_process` */

insert  into `tb_tournament_process`(`process_id`,`tournament_id`,`tournament_host_team_id`,`tournament_host_team_name`,`tournament_guest_team_id`,`tournament_guest_team_name`,`host_team_score`,`guest_team_score`,`tournament_start_date`,`tournament_end_date`,`tournament_state`,`remark`,`p1`,`p2`,`p3`,`create_date`,`update_date`,`order_by`,`delete_state`,`delete_date`,`is_valid`,`version`) values (1,1,1,'亚特兰大老鹰队',4,'洛杉矶湖人队','19,32,12,31,23','18,62,42,12,23','2016-03-04 16:14:09','2016-03-04 16:14:26','W',NULL,NULL,NULL,NULL,'2016-02-04 16:14:34','2016-02-04 16:14:37',NULL,'N',NULL,'Y',1),(2,1,1,'亚特兰大老鹰队',10,'亚特兰大老鹰队2','81,29,12,42,23','51,62,12,32,23','2016-02-05 16:15:08','2016-02-05 16:15:11','W',NULL,NULL,NULL,NULL,'2016-02-05 16:15:18','2016-02-05 16:15:22',NULL,'N',NULL,'Y',1),(3,1,4,'洛杉矶湖人队',10,'亚特兰大老鹰队2','71,22,12,32,23','31,72,12,32,23','2016-02-06 16:15:54','2016-02-06 16:15:54','W',NULL,NULL,NULL,NULL,'2016-02-06 16:15:54','2016-02-06 16:15:54',NULL,'N',NULL,'Y',1);

/*Table structure for table `tb_tournament_team_ref` */

DROP TABLE IF EXISTS `tb_tournament_team_ref`;

CREATE TABLE `tb_tournament_team_ref` (
  `tm_ref_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '参赛数据关联ID',
  `tournament_id` bigint(20) NOT NULL COMMENT '比赛ID',
  `tournament_team_id` bigint(20) NOT NULL COMMENT '球队ID',
  `tournament_linkman` varchar(15) DEFAULT NULL COMMENT '赛事球队联系人',
  `linkman_phone_number` varchar(15) DEFAULT NULL COMMENT '赛事咨询电话号码',
  `linkman_qq_number` varchar(15) DEFAULT NULL COMMENT '赛事咨询QQ号码',
  `linkman_weix_number` varchar(40) DEFAULT NULL COMMENT '赛事咨询微信号码',
  `linkman_weib_number` varchar(40) DEFAULT NULL COMMENT '赛事咨询微博号码',
  `remark` varchar(200) DEFAULT NULL COMMENT '赛事备注',
  `enroll_state` char(2) DEFAULT 'N' COMMENT '报名审核通过状态:N=未通过; Y=通过. 默认N',
  `p1` varchar(100) DEFAULT NULL COMMENT '扩展字段',
  `p2` varchar(100) DEFAULT NULL COMMENT '扩展字段',
  `p3` varchar(100) DEFAULT NULL COMMENT '扩展字段',
  `p4` varchar(100) DEFAULT NULL COMMENT '扩展字段',
  `create_date` datetime DEFAULT NULL COMMENT '数据创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '数据修改时间',
  `order_by` bigint(20) DEFAULT NULL COMMENT '排序字段',
  `delete_state` char(2) DEFAULT 'N' COMMENT '删除标记:N=未删除; Y=删除. 默认N',
  `delete_date` datetime DEFAULT NULL COMMENT '删除时间',
  `is_valid` char(2) DEFAULT 'Y' COMMENT '有效标记:Y=有效; N=无效. 默认Y',
  `version` int(11) DEFAULT '1' COMMENT '版本',
  PRIMARY KEY (`tm_ref_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `tb_tournament_team_ref` */

insert  into `tb_tournament_team_ref`(`tm_ref_id`,`tournament_id`,`tournament_team_id`,`tournament_linkman`,`linkman_phone_number`,`linkman_qq_number`,`linkman_weix_number`,`linkman_weib_number`,`remark`,`enroll_state`,`p1`,`p2`,`p3`,`p4`,`create_date`,`update_date`,`order_by`,`delete_state`,`delete_date`,`is_valid`,`version`) values (1,1,4,NULL,NULL,NULL,NULL,NULL,NULL,'N',NULL,NULL,NULL,NULL,'2016-01-22 14:46:58','2016-01-22 14:47:03',NULL,'N',NULL,'Y',1),(2,1,1,NULL,NULL,NULL,NULL,NULL,NULL,'N',NULL,NULL,NULL,NULL,'2016-01-22 14:47:00','2016-01-22 14:47:05',NULL,'N',NULL,'Y',1),(3,1,10,NULL,NULL,NULL,NULL,NULL,NULL,'N',NULL,NULL,NULL,NULL,'2016-01-22 14:47:02','2016-01-22 14:47:07',NULL,'N',NULL,'Y',1);

/*Table structure for table `tb_user` */

DROP TABLE IF EXISTS `tb_user`;

CREATE TABLE `tb_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) NOT NULL COMMENT '用户姓名',
  `chinese_name` varchar(30) DEFAULT NULL COMMENT '中文名',
  `english_name` varchar(50) DEFAULT NULL COMMENT '英文名',
  `alias_name` varchar(50) NOT NULL COMMENT '别名',
  `nationality` varchar(30) DEFAULT NULL COMMENT '国籍',
  `birthpace` varchar(30) DEFAULT NULL COMMENT '出生地',
  `birthdate` date DEFAULT NULL COMMENT '出生日期',
  `graduate_school` varchar(50) DEFAULT NULL COMMENT '毕业院校',
  `stature` int(11) DEFAULT NULL COMMENT '身高',
  `weight` int(11) DEFAULT NULL COMMENT '体重',
  `user_password` varchar(100) NOT NULL COMMENT '密码',
  `user_phone_number` varchar(15) DEFAULT NULL COMMENT '手机号码',
  `user_identity_card` varchar(22) DEFAULT NULL COMMENT '身份证号码',
  `user_identity_card_img` varchar(100) DEFAULT NULL COMMENT '身份证件照片',
  `user_ic_photo` varchar(100) DEFAULT NULL COMMENT '身份证与本人的合照',
  `user_email` varchar(50) DEFAULT NULL COMMENT '电子邮箱',
  `user_photo_path` varchar(100) DEFAULT NULL COMMENT '用户头像路径',
  `user_address` varchar(100) DEFAULT NULL COMMENT '地址',
  `user_city` varchar(10) DEFAULT NULL COMMENT '城市',
  `regedit_date` datetime DEFAULT NULL COMMENT '注册时间',
  `create_date` datetime DEFAULT NULL COMMENT '数据创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '数据修改时间',
  `order_by` bigint(20) DEFAULT NULL COMMENT '排序字段',
  `delete_state` char(2) DEFAULT 'N' COMMENT '删除标记:N=未删除; Y=删除. 默认N',
  `delete_date` datetime DEFAULT NULL COMMENT '删除时间',
  `is_valid` char(2) DEFAULT 'Y' COMMENT '有效标记:Y=有效; N=无效. 默认Y',
  `version` int(11) DEFAULT '1' COMMENT '版本',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `tb_user` */

insert  into `tb_user`(`id`,`user_name`,`chinese_name`,`english_name`,`alias_name`,`nationality`,`birthpace`,`birthdate`,`graduate_school`,`stature`,`weight`,`user_password`,`user_phone_number`,`user_identity_card`,`user_identity_card_img`,`user_ic_photo`,`user_email`,`user_photo_path`,`user_address`,`user_city`,`regedit_date`,`create_date`,`update_date`,`order_by`,`delete_state`,`delete_date`,`is_valid`,`version`) values (5,'aaa',NULL,NULL,'aaa',NULL,NULL,NULL,NULL,NULL,NULL,'032UjfBXYrfi+WxQObkd5g==','15844447277',NULL,NULL,NULL,NULL,'userDefault.jpg','南京',NULL,NULL,NULL,'2015-12-15 14:23:05',NULL,'N',NULL,'Y',7),(6,'liliang','阿亮','leeliang','liliang','中国',NULL,NULL,NULL,185,90,'032UjfBXYrfi+WxQObkd5g==','15844447777',NULL,NULL,NULL,NULL,'userDefault.jpg',NULL,'南京',NULL,NULL,NULL,NULL,'N',NULL,'Y',1),(7,'cc','小陈','Mr.Chen','cc','美国',NULL,NULL,NULL,192,96,'032UjfBXYrfi+WxQObkd5g==','13211115555',NULL,NULL,NULL,NULL,'userDefault.jpg',NULL,'苏州',NULL,NULL,NULL,NULL,'N',NULL,'Y',1),(8,'liwu','小武','leeWu','liwu','德国',NULL,NULL,NULL,188,99,'032UjfBXYrfi+WxQObkd5g==','15966664444',NULL,NULL,NULL,NULL,'userDefault.jpg',NULL,'宁波',NULL,NULL,NULL,NULL,'N',NULL,'Y',1),(9,'liu',NULL,NULL,'liu',NULL,NULL,NULL,NULL,NULL,NULL,'032UjfBXYrfi+WxQObkd5g==',NULL,NULL,NULL,NULL,NULL,'userDefault.jpg',NULL,NULL,'2015-11-17 17:49:40','2015-11-17 17:49:40','2015-11-17 17:49:40',NULL,'N',NULL,'Y',1),(10,'zz','蛋蛋','sasdf','zz','阿拉伯','印度','1999-12-26','清华大学',188,90,'032UjfBXYrfi+WxQObkd5g==','13312315555',NULL,NULL,NULL,NULL,'userDefault.jpg','南京那里','长沙','2015-11-30 14:50:51','2015-11-30 14:50:51','2015-11-30 15:57:45',NULL,'N',NULL,'Y',4),(12,'abc',NULL,NULL,'abc',NULL,NULL,NULL,NULL,NULL,NULL,'032UjfBXYrfi+WxQObkd5g==','13312315544',NULL,NULL,NULL,NULL,'userDefault.jpg',NULL,NULL,'2015-12-07 20:08:57','2015-12-07 20:08:57','2015-12-07 20:08:57',NULL,'N',NULL,'Y',1),(13,'dddd','dddd','dddd','dddd',NULL,NULL,NULL,NULL,NULL,NULL,'032UjfBXYrfi+WxQObkd5g==','13312315556',NULL,NULL,NULL,NULL,'userDefault.jpg',NULL,NULL,'2016-01-20 11:36:50','2016-01-20 11:36:50','2016-01-20 11:36:50',NULL,'N',NULL,'Y',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
