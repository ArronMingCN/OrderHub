/*
Navicat MySQL Data Transfer

Source Server         : OrderHub
Source Server Version : 50619
Source Host           : localhost:3306
Source Database       : orderhub

Target Server Type    : MYSQL
Target Server Version : 50619
File Encoding         : 65001

Date: 2018-08-13 16:54:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for askorders
-- ----------------------------
DROP TABLE IF EXISTS `askorders`;
CREATE TABLE `askorders` (
  `OrderID` int(10) NOT NULL AUTO_INCREMENT,
  `UserID` int(5) NOT NULL,
  `Symbol` varchar(15) NOT NULL,
  `OrderType` varchar(5) NOT NULL,
  `Status` varchar(10) NOT NULL DEFAULT '1',
  `Qty` int(10) NOT NULL,
  `Remainder` int(10) NOT NULL DEFAULT '0',
  `Price` decimal(10,2) DEFAULT NULL,
  `FOK` tinyint(1) DEFAULT NULL,
  `Time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`OrderID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of askorders
-- ----------------------------
INSERT INTO `askorders` VALUES ('1', '1', 'IBM', 'LMT', '1', '125', '125', '211.72', '0', '2018-08-08 01:02:56');
INSERT INTO `askorders` VALUES ('2', '2', 'IBM', 'LMT', '1', '129', '129', '210.75', '0', '2018-08-08 01:03:01');
INSERT INTO `askorders` VALUES ('3', '3', 'IBM', 'LMT', '1', '90', '90', '209.98', '0', '2018-08-13 13:38:59');
INSERT INTO `askorders` VALUES ('4', '4', 'IBM', 'LMT', '1', '43', '43', '208.13', '0', '2018-08-13 13:39:48');
INSERT INTO `askorders` VALUES ('5', '5', 'IBM', 'LMT', '1', '121', '121', '207.53', '0', '2018-08-13 13:40:40');
INSERT INTO `askorders` VALUES ('6', '6', 'IBM', 'LMT', '1', '89', '89', '206.92', '0', '2018-08-13 13:41:15');
INSERT INTO `askorders` VALUES ('7', '1', 'C', 'LMT', '1', '90', '90', '74.23', '0', '2018-08-13 13:42:04');
INSERT INTO `askorders` VALUES ('8', '2', 'C', 'LMT', '1', '43', '43', '73.21', '0', '2018-08-13 13:42:42');
INSERT INTO `askorders` VALUES ('9', '3', 'C', 'LMT', '1', '121', '121', '72.45', '0', '2018-08-13 13:43:05');
INSERT INTO `askorders` VALUES ('10', '1', 'SNY', 'LMT', '1', '129', '129', '123.45', '0', '2018-08-13 13:43:25');
INSERT INTO `askorders` VALUES ('11', '2', 'SNY', 'LMT', '1', '90', '90', '122.32', '0', '2018-08-13 13:43:43');
INSERT INTO `askorders` VALUES ('12', '3', 'SNY', 'LMT', '1', '43', '43', '121.99', '0', '2018-08-13 13:44:01');
INSERT INTO `askorders` VALUES ('13', '1', 'AAPL', 'LMT', '1', '90', '90', '1023.32', '0', '2018-08-13 13:44:20');
INSERT INTO `askorders` VALUES ('14', '2', 'AAPL', 'LMT', '1', '43', '43', '1022.43', '0', '2018-08-13 13:44:35');
INSERT INTO `askorders` VALUES ('15', '3', 'AAPL', 'LMT', '1', '121', '0', '1021.21', '0', '2018-08-13 13:44:54');

-- ----------------------------
-- Table structure for bidorders
-- ----------------------------
DROP TABLE IF EXISTS `bidorders`;
CREATE TABLE `bidorders` (
  `OrderID` int(10) NOT NULL AUTO_INCREMENT,
  `UserID` int(5) NOT NULL,
  `Symbol` varchar(15) NOT NULL,
  `OrderType` varchar(5) NOT NULL,
  `Status` varchar(10) NOT NULL,
  `Qty` int(10) NOT NULL,
  `Remainder` int(10) NOT NULL,
  `Price` decimal(10,2) DEFAULT NULL,
  `FOK` tinyint(1) DEFAULT NULL,
  `Time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`OrderID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of bidorders
-- ----------------------------
INSERT INTO `bidorders` VALUES ('1', '7', 'IBM', 'LMT', '1', '120', '120', '206.23', '0', '2018-08-13 13:45:46');
INSERT INTO `bidorders` VALUES ('2', '8', 'IBM', 'LMT', '1', '150', '150', '205.32', '0', '2018-08-13 13:46:06');
INSERT INTO `bidorders` VALUES ('3', '9', 'IBM', 'LMT', '1', '45', '45', '204.55', '0', '2018-08-13 13:46:22');
INSERT INTO `bidorders` VALUES ('4', '10', 'IBM', 'LMT', '1', '170', '170', '203.87', '0', '2018-08-13 13:46:39');
INSERT INTO `bidorders` VALUES ('5', '11', 'IBM', 'LMT', '1', '69', '69', '202.99', '0', '2018-08-13 13:47:05');
INSERT INTO `bidorders` VALUES ('6', '12', 'IBM', 'LMT', '1', '74', '74', '201.55', '0', '2018-08-13 13:47:22');
INSERT INTO `bidorders` VALUES ('7', '4', 'C', 'LMT', '1', '89', '89', '71.39', '0', '2018-08-13 13:47:41');
INSERT INTO `bidorders` VALUES ('8', '5', 'C', 'LMT', '1', '120', '120', '71.35', '0', '2018-08-13 13:47:59');
INSERT INTO `bidorders` VALUES ('9', '6', 'C', 'LMT', '1', '150', '150', '69.87', '0', '2018-08-13 13:48:16');
INSERT INTO `bidorders` VALUES ('10', '4', 'SNY', 'LMT', '1', '121', '121', '121.58', '0', '2018-08-13 13:48:38');
INSERT INTO `bidorders` VALUES ('11', '5', 'SNY', 'LMT', '1', '89', '89', '121.45', '0', '2018-08-13 13:49:00');
INSERT INTO `bidorders` VALUES ('12', '6', 'SNY', 'LMT', '1 ', '74', '74', '121.34', '0', '2018-08-13 13:49:17');
INSERT INTO `bidorders` VALUES ('13', '4', 'AAPL', 'LMT', '1', '89', '89', '1021.12', '0', '2018-08-13 13:49:33');
INSERT INTO `bidorders` VALUES ('14', '5', 'AAPL', 'LMT', '1', '120', '120', '1020.97', '0', '2018-08-13 13:49:49');
INSERT INTO `bidorders` VALUES ('15', '6', 'AAPL', 'LMT', '1', '150', '150', '1020.34', '0', '2018-08-13 13:50:11');
INSERT INTO `bidorders` VALUES ('16', '3', 'APPL', 'MKT', '1', '100', '100', null, '0', '2018-08-13 16:51:27');

-- ----------------------------
-- View structure for askorderbook
-- ----------------------------
DROP VIEW IF EXISTS `askorderbook`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER  VIEW `askorderbook` AS SELECT
askorders.OrderID,
askorders.UserID,
askorders.Symbol,
askorders.Remainder,
askorders.Price,
askorders.Time
FROM
askorders ;

-- ----------------------------
-- View structure for bidorderbook
-- ----------------------------
DROP VIEW IF EXISTS `bidorderbook`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost`  VIEW `bidorderbook` AS SELECT
bidorders.OrderID,
bidorders.UserID,
bidorders.Symbol,
bidorders.Remainder,
bidorders.Price,
bidorders.Time
FROM
bidorders ;
