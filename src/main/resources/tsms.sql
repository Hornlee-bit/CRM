/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50550
Source Host           : localhost:3306
Source Database       : tsms

Target Server Type    : MYSQL
Target Server Version : 50550
File Encoding         : 65001

Date: 2017-05-23 18:07:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_attachment_info
-- ----------------------------
DROP TABLE IF EXISTS `tb_attachment_info`;
CREATE TABLE `tb_attachment_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `taskId` int(11) DEFAULT NULL,
  `illustrate` varchar(128) DEFAULT NULL,
  `url` varchar(64) DEFAULT NULL,
  `recordDate` date DEFAULT NULL,
  `recordUserId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKinfo_sourceID` (`taskId`),
  KEY `FKinfo_userID` (`recordUserId`),
  CONSTRAINT `FKinfo_sourceID` FOREIGN KEY (`taskId`) REFERENCES `tb_tax_source` (`id`),
  CONSTRAINT `FKinfo_userID` FOREIGN KEY (`recordUserId`) REFERENCES `tb_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_attachment_info
-- ----------------------------

-- ----------------------------
-- Table structure for tb_image_link
-- ----------------------------
DROP TABLE IF EXISTS `tb_image_link`;
CREATE TABLE `tb_image_link` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `taskId` int(11) DEFAULT NULL,
  `illustrate` varchar(128) DEFAULT NULL,
  `url` varchar(64) DEFAULT NULL,
  `recordDate` date DEFAULT NULL,
  `recordUserId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKimage_sourceID` (`taskId`),
  KEY `FKinfo_userID` (`recordUserId`),
  CONSTRAINT `FKimage_sourceID` FOREIGN KEY (`taskId`) REFERENCES `tb_tax_source` (`id`),
  CONSTRAINT `FKimage_userID` FOREIGN KEY (`recordUserId`) REFERENCES `tb_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_image_link
-- ----------------------------

-- ----------------------------
-- Table structure for tb_industry
-- ----------------------------
DROP TABLE IF EXISTS `tb_industry`;
CREATE TABLE `tb_industry` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `industryName` varchar(64) DEFAULT NULL,
  `recordDate` date DEFAULT NULL,
  `recordUserId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKindustry_userID` (`recordUserId`),
  CONSTRAINT `FKindustry_userID` FOREIGN KEY (`recordUserId`) REFERENCES `tb_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_industry
-- ----------------------------
INSERT INTO `tb_industry` VALUES ('1', '计算机应用相关', '2017-05-01', '1');
INSERT INTO `tb_industry` VALUES ('2', '房地产', '2017-05-03', '2');
INSERT INTO `tb_industry` VALUES ('3', '生物医药', '2017-05-03', '2');
INSERT INTO `tb_industry` VALUES ('4', '金融', '2017-05-06', '1');
INSERT INTO `tb_industry` VALUES ('5', '汽车工业', '2017-05-06', '1');
INSERT INTO `tb_industry` VALUES ('6', '通讯工程', '2017-05-06', '1');

-- ----------------------------
-- Table structure for tb_taxer
-- ----------------------------
DROP TABLE IF EXISTS `tb_taxer`;
CREATE TABLE `tb_taxer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `taxerCode` varchar(12) NOT NULL,
  `taxerName` varchar(32) DEFAULT NULL,
  `mobile` varchar(12) DEFAULT NULL,
  `address` varchar(128) DEFAULT NULL,
  `sex` varchar(2) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `email` varchar(64) DEFAULT NULL,
  `organId` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT '0',
  `mgr` int(11) DEFAULT NULL,
  `admin` int(11) DEFAULT '0',
  `recordDate` date DEFAULT NULL,
  `recordUserId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `taxerCode` (`taxerCode`),
  KEY `FKtaxer_userID` (`recordUserId`),
  KEY `FKtaxer_organID` (`organId`),
  CONSTRAINT `FKtaxer_organID` FOREIGN KEY (`organId`) REFERENCES `tb_tax_organ` (`id`),
  CONSTRAINT `FKtaxer_userID` FOREIGN KEY (`recordUserId`) REFERENCES `tb_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_taxer
-- ----------------------------
INSERT INTO `tb_taxer` VALUES ('1', '201701', '章莉', '111', '武汉', '女', '2010-02-02', '986432727@qq.com', '1', '0', null, '0', '2017-05-01', '1');
INSERT INTO `tb_taxer` VALUES ('2', '201702', '程维', '111', '北京', '男', '2010-05-04', '988432727@qq.com', '1', '0', '1', '0', '2017-05-04', '2');

-- ----------------------------
-- Table structure for tb_tax_organ
-- ----------------------------
DROP TABLE IF EXISTS `tb_tax_organ`;
CREATE TABLE `tb_tax_organ` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `organName` varchar(64) DEFAULT NULL,
  `parentId` int(11) DEFAULT NULL,
  `address` varchar(128) DEFAULT NULL,
  `phone` varchar(12) DEFAULT NULL,
  `faxPhone` varchar(12) DEFAULT NULL,
  `email` varchar(32) DEFAULT NULL,
  `leaderId` int(11) DEFAULT NULL,
  `taxTypeCode` varchar(12) DEFAULT NULL,
  `state` int(11) DEFAULT '0',
  `recordDate` date DEFAULT NULL,
  `recordUserId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKorgan_userID` (`recordUserId`),
  KEY `FKorgan_leaderID` (`leaderId`),
  CONSTRAINT `FKorgan_leaderID` FOREIGN KEY (`leaderId`) REFERENCES `tb_taxer` (`id`),
  CONSTRAINT `FKorgan_userID` FOREIGN KEY (`recordUserId`) REFERENCES `tb_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_tax_organ
-- ----------------------------
INSERT INTO `tb_tax_organ` VALUES ('1', '中国国税局', null, '北京朝阳', '13389988724', '1001', '1061416549@qq.com', '1', '1000215', '0', '2017-05-03', '1');
INSERT INTO `tb_tax_organ` VALUES ('2', '北京市国税局', '1', '北京', '15083458687', '1001', '1067866023@qq.com', '1', '1000210', '0', '2017-05-10', '1');
INSERT INTO `tb_tax_organ` VALUES ('3', '天津市国税局', '1', '天津', '13547828790', '1001', '899912773@qq.com', '1', '1000210', '0', '2017-05-10', '2');
INSERT INTO `tb_tax_organ` VALUES ('4', '上海市国税局', '1', '上海', '13689378081', '1001', '982737472@qq.com', '1', '1000210', '0', '2017-05-10', '2');
INSERT INTO `tb_tax_organ` VALUES ('5', '深圳市国税局', '1', '深圳', '13390678966', '1001', '197298364@qq.com', '1', '1000210', '0', '2017-05-10', '2');
INSERT INTO `tb_tax_organ` VALUES ('6', '武汉市国税局', '1', '武汉', '15077654720', '1001', '82638768@qq.com', '1', '1000210', '0', '2017-05-05', '2');
INSERT INTO `tb_tax_organ` VALUES ('7', '杭州市国税局', '1', '杭州', '13309880999', '1001', '212331313@qq.com', '1', '1000210', '0', '2017-05-05', '2');

-- ----------------------------
-- Table structure for tb_tax_payer
-- ----------------------------
DROP TABLE IF EXISTS `tb_tax_payer`;
CREATE TABLE `tb_tax_payer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `payerCode` varchar(32) NOT NULL,
  `payerName` varchar(64) NOT NULL,
  `bizAddress` varchar(128) NOT NULL,
  `taxOrganId` int(11) NOT NULL,
  `industryId` int(11) DEFAULT NULL,
  `bizScope` varchar(128) DEFAULT NULL,
  `invoiceType` varchar(12) DEFAULT NULL,
  `legalPerson` varchar(32) DEFAULT NULL,
  `legalIdCard` varchar(20) DEFAULT NULL,
  `legalMobile` varchar(12) DEFAULT NULL,
  `legalIdCardImageURL` varchar(64) DEFAULT NULL,
  `finaceName` varchar(32) DEFAULT NULL,
  `finaceIdCard` varchar(20) DEFAULT NULL,
  `finaceMobile` varchar(12) DEFAULT NULL,
  `finaceIdCardImageURL` varchar(64) DEFAULT NULL,
  `taxerName` varchar(32) DEFAULT NULL,
  `taxerIdCard` varchar(20) DEFAULT NULL,
  `taxerMobile` varchar(12) DEFAULT NULL,
  `taxerIdCardImageURL` varchar(64) DEFAULT NULL,
  `bizAddressPhone` varchar(12) DEFAULT NULL,
  `recordDate` date DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `removeState` int(255) DEFAULT '0' COMMENT 'o表示未删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `payerCode` (`payerCode`),
  KEY `FKpayer_organID` (`taxOrganId`),
  KEY `FKpayer_industryID` (`industryId`),
  KEY `FKpayer_userID` (`userId`),
  CONSTRAINT `FKpayer_industryID` FOREIGN KEY (`industryId`) REFERENCES `tb_industry` (`id`),
  CONSTRAINT `FKpayer_organID` FOREIGN KEY (`taxOrganId`) REFERENCES `tb_tax_organ` (`id`),
  CONSTRAINT `FKpayer_userID` FOREIGN KEY (`userId`) REFERENCES `tb_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=115 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_tax_payer
-- ----------------------------
INSERT INTO `tb_tax_payer` VALUES ('101', '1001', '智递科技有限公司', '北京', '2', '1', '计算机应用', '增值税专用发票', '张近东', '420911198010194545', null, null, '马云', '420911198010194545', null, null, '李飞', null, null, null, '13038889078', '2017-05-23', '2', '0');
INSERT INTO `tb_tax_payer` VALUES ('102', '1002', '捷瑞生物工程', '上海', '4', '3', '生物工程', '增值税专用发票', '周武', '420911198010194545', '13038889029', 'img', '向欣', '420911198010194545', '13038889029', 'imgf', '刘东', '420921199510295527', '13565878733', 'imgt', '13038889078', '2017-05-04', '2', '0');
INSERT INTO `tb_tax_payer` VALUES ('103', '1003', '智云科技有限公司', '上海', '4', '1', '自动化与智能', '增值税专用发票', '周武', '420911198010194545', '13038889029', 'img', '向欣', '420911198010194545', null, null, '刘东', null, null, null, '13038889078', '2017-05-20', '2', '0');
INSERT INTO `tb_tax_payer` VALUES ('104', '1004', '小米科技', '北京', '2', '1', '互联网企业', '增值税普通发票', '周武', '420911198010194545', '13038889029', 'img', '向欣', '420911198010194545', '13038889029', 'imgf', '刘东', '420921199510295527', '13565878733', 'imgt', '13038889078', '2017-05-04', '2', '0');
INSERT INTO `tb_tax_payer` VALUES ('105', '1005', '绿地集团', '上海', '4', '2', '房地产', '增值税专用发票', '周武', '420911198010194545', '13038889029', 'img', '向欣', '420911198010194545', '13038889029', 'imgf', '刘东', '420921199510295527', '13565878733', 'imgt', '13038889078', '2017-05-04', '2', '0');
INSERT INTO `tb_tax_payer` VALUES ('106', '1006', '万科集团', '深圳', '5', '2', '房地产', '增值税专用发票', '周武', '420911198010194545', '13038889029', 'img', '向欣', '420911198010194545', '13038889029', 'imgf', '刘东', '420921199510295527', '13565878733', 'imgt', '13038889078', '2017-05-05', '2', '0');
INSERT INTO `tb_tax_payer` VALUES ('107', '1007', '哇哈哈食品有限公司', '杭州', '7', '3', '食品药品', '增值税专用发票', '周武', '420911198010194545', '13038889029', 'img', '向欣', '420911198010194545', '13038889029', 'imgf', '李飞', '420921199510295527', '13565878733', 'imgt', '13038889078', '2017-05-05', '2', '0');
INSERT INTO `tb_tax_payer` VALUES ('108', '1008', '中国建设银行', '北京', '2', '4', '金融', '增值税普通发票', '周武', '420911198010194545', '13038889029', 'img', '向欣', '420911198010194545', '13038889029', 'imgf', '李飞', '420921199510295527', '13565878733', 'imgt', '13038889078', '2017-05-05', '2', '0');
INSERT INTO `tb_tax_payer` VALUES ('109', '1009', '中国农业银行', '北京', '2', '4', '金融', '增值税专用发票', '周武', '420911198010194545', '13038889029', 'img', '向欣', '420911198010194545', '13038889029', 'imgf', '李飞', '420921199510295527', '13565878733', 'imgt', '13038889078', '2017-05-05', '2', '0');
INSERT INTO `tb_tax_payer` VALUES ('110', '10010', '华为科技有限公司', '深圳', '5', '6', '通讯', '增值税专用发票', '周武', '420911198010194545', '13038889029', 'img', '向fei', '420911198010194545', null, null, '李飞', null, null, null, '13038889078', '2017-05-20', '2', '0');
INSERT INTO `tb_tax_payer` VALUES ('111', '10011', '东风汽车集团', '武汉', '6', '5', '汽车工业', '增值税普通发票', '周武', '420911198010194545', '13038889029', 'img', '向欣', '420911198010194545', '13038889029', 'imgf', '李飞', '420921199510295527', '13565878733', 'imgt', '13038889078', '2017-05-06', '2', '0');
INSERT INTO `tb_tax_payer` VALUES ('112', '10012', '中国第一汽车集团', '上海', '4', '5', '汽车工业', '增值税普通发票', '周武', '420911198010194545', '13038889029', 'img', '向欣', '420911198010194545', null, null, '李飞', null, null, null, '13038889078', '2017-05-20', '2', '0');
INSERT INTO `tb_tax_payer` VALUES ('113', '10013', '上海医药集团', '上海', '4', '3', '生物工程', '增值税普通发票', '周武', '420911198010194545', '13038889029', 'img', '向欣', '420911198010194545', '13038889029', 'imgf', '李飞', '420921199510295527', '13565878733', 'imgt', '13038889078', '2017-05-06', '1', '0');
INSERT INTO `tb_tax_payer` VALUES ('114', '10014', '华润置地', '北京', '2', '2', '房地产', null, '刘强东', '420932199806297600', null, null, '章程', '420932199908025472', null, null, '范明明', null, null, null, '13049493978', '2017-05-23', '1', '1');

-- ----------------------------
-- Table structure for tb_tax_source
-- ----------------------------
DROP TABLE IF EXISTS `tb_tax_source`;
CREATE TABLE `tb_tax_source` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `payerId` int(11) NOT NULL,
  `taskName` varchar(128) DEFAULT NULL,
  `subOrganId` int(11) DEFAULT NULL,
  `approverId` int(11) DEFAULT NULL,
  `executeId` int(11) DEFAULT NULL,
  `executeTime` date DEFAULT NULL,
  `taskFrom` varchar(12) DEFAULT NULL,
  `taskState` varchar(128) DEFAULT NULL,
  `idea` varchar(512) DEFAULT NULL,
  `riskLevel` int(11) DEFAULT '0',
  `recordTaskDate` date DEFAULT NULL,
  `recordUserId` int(11) DEFAULT NULL,
  `removeState` int(255) DEFAULT '0' COMMENT 'o表示未删除',
  PRIMARY KEY (`id`),
  KEY `FKsource_approverID` (`approverId`),
  KEY `FKsource_executeID` (`executeId`),
  KEY `FKsource_payerID` (`payerId`),
  KEY `FKsource_userID` (`recordUserId`),
  KEY `FKsource_organID` (`subOrganId`),
  CONSTRAINT `FKsource_approverID` FOREIGN KEY (`approverId`) REFERENCES `tb_taxer` (`id`),
  CONSTRAINT `FKsource_executeID` FOREIGN KEY (`executeId`) REFERENCES `tb_taxer` (`id`),
  CONSTRAINT `FKsource_organID` FOREIGN KEY (`subOrganId`) REFERENCES `tb_tax_organ` (`id`),
  CONSTRAINT `FKsource_payerID` FOREIGN KEY (`payerId`) REFERENCES `tb_tax_payer` (`id`),
  CONSTRAINT `FKsource_userID` FOREIGN KEY (`recordUserId`) REFERENCES `tb_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_tax_source
-- ----------------------------
INSERT INTO `tb_tax_source` VALUES ('1', '101', '税源信息采集', '2', '1', '2', '2017-05-03', '上级分配', '良好', '无', '0', '2017-05-04', '2', '1');
INSERT INTO `tb_tax_source` VALUES ('2', '102', '税源信息采集', '2', '1', '2', '2017-05-03', '上级分配', '良好', '无', '1', '2017-05-04', '2', '0');
INSERT INTO `tb_tax_source` VALUES ('3', '103', '税源信息采集', '4', '1', '2', '2017-05-03', '上级分配', '良好', '无', '2', '2017-05-04', '2', '0');
INSERT INTO `tb_tax_source` VALUES ('4', '104', '税源信息采集', '2', '1', '2', '2017-05-03', '上级分配', '良好', '无', '1', '2017-05-04', '2', '0');
INSERT INTO `tb_tax_source` VALUES ('5', '105', '税源信息采集', '4', '1', '1', '2017-05-03', '上级分配', '良好', '无', '0', '2017-05-04', '2', '0');
INSERT INTO `tb_tax_source` VALUES ('6', '101', '税源处理', '2', '2', '2', '2017-05-03', '上级分配', '通过', '无', '1', '2017-05-20', '2', '0');
INSERT INTO `tb_tax_source` VALUES ('7', '102', '税源处理', '4', '2', '2', '2017-05-03', '上级分配', '良好', '无', '0', '2017-05-04', '1', '0');
INSERT INTO `tb_tax_source` VALUES ('8', '103', '税源处理', '4', '2', '1', '2017-05-03', '上级分配', '良好', '无', '1', '2017-05-04', '1', '0');
INSERT INTO `tb_tax_source` VALUES ('9', '104', '税源处理', '2', '2', '2', '2017-05-03', '上级分配', '良好', '无', '0', '2017-05-04', '1', '0');
INSERT INTO `tb_tax_source` VALUES ('10', '101', '税费提交', '2', '2', '2', '2017-05-03', '上级分配', '完成', '无', '0', '2017-05-04', '1', '0');
INSERT INTO `tb_tax_source` VALUES ('11', '102', '税费提交', '4', '2', '2', '2017-05-03', '上级分配', '完成', '无', '0', '2017-05-04', '1', '0');
INSERT INTO `tb_tax_source` VALUES ('15', '112', '税费缴纳', '4', '2', '1', '2017-05-03', '上级分配', '通过', '无', '1', '2017-05-20', '2', '0');
INSERT INTO `tb_tax_source` VALUES ('16', '101', '税源信息采集', '2', '2', '1', '2017-05-22', null, '顺利', '无', '2', '2017-05-23', '2', '0');
INSERT INTO `tb_tax_source` VALUES ('17', '102', '税源信息采集', '3', '1', '1', '2017-05-24', null, '顺利', '无', '2', '2017-05-23', '2', '0');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(16) NOT NULL,
  `password` varchar(32) NOT NULL,
  `taxerId` int(11) DEFAULT NULL,
  `salt` varchar(32) NOT NULL,
  `permissionId` int(11) NOT NULL DEFAULT '1',
  `state` int(11) NOT NULL DEFAULT '1',
  `email` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `email` (`email`),
  KEY `FKuser_taxerID` (`taxerId`),
  CONSTRAINT `FKuser_taxerID` FOREIGN KEY (`taxerId`) REFERENCES `tb_taxer` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', 'zhangsan', '594f803b380a41396ed63dca39503542', '1', 'aaa', '1', '1', '986432727@qq.com');
INSERT INTO `tb_user` VALUES ('2', 'zhangsi', '0b4e7a0e5fe84ad35fb5f95b9ceeac79', '2', 'aaa', '2', '1', '898272727@qq.com');
INSERT INTO `tb_user` VALUES ('3', 'zhangwu', '594f803b380a41396ed63dca39503542', '1', 'aaa', '3', '1', '283768761@qq.com');
