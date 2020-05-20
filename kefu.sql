/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50562
Source Host           : localhost:3306
Source Database       : kefu

Target Server Type    : MYSQL
Target Server Version : 50562
File Encoding         : 65001

Date: 2020-05-20 14:28:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cs_chatbot
-- ----------------------------
DROP TABLE IF EXISTS `cs_chatbot`;
CREATE TABLE `cs_chatbot` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clientId` varchar(50) NOT NULL COMMENT '机器人id',
  `secret` varchar(50) NOT NULL COMMENT '机器人密钥',
  `status` tinyint(1) NOT NULL COMMENT '机器人状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of cs_chatbot
-- ----------------------------
INSERT INTO `cs_chatbot` VALUES ('1', '5ea52d57bd822e0017eea710', 'cdb521f58430612f2986dd38989437e0', '1');

-- ----------------------------
-- Table structure for cs_chatmsg
-- ----------------------------
DROP TABLE IF EXISTS `cs_chatmsg`;
CREATE TABLE `cs_chatmsg` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `toid` varchar(10) DEFAULT NULL,
  `toname` varchar(255) DEFAULT NULL,
  `fromid` int(10) DEFAULT NULL,
  `fromname` varchar(255) DEFAULT NULL,
  `sendtime` int(10) DEFAULT NULL,
  `content` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of cs_chatmsg
-- ----------------------------
INSERT INTO `cs_chatmsg` VALUES ('1', '2', '小美', '1', '访客1', '1589574676', '你好');
INSERT INTO `cs_chatmsg` VALUES ('2', '2', '小美', '1', '访客1', '1589574793', 'hello');
INSERT INTO `cs_chatmsg` VALUES ('3', '1', '访客1', '2', '小美', '1589574804', '欢迎来到simplekefu');
INSERT INTO `cs_chatmsg` VALUES ('4', '1', '访客1', '2', '小美', '1589574805', '你好！有什么需要帮助的？');
INSERT INTO `cs_chatmsg` VALUES ('5', '1', '访客1', '2', '小美', '1589574814', '🤣');
INSERT INTO `cs_chatmsg` VALUES ('6', '1', '访客1', '2', '小美', '1589574823', 'ヾ(≧▽≦*)o');
INSERT INTO `cs_chatmsg` VALUES ('7', '1', '访客1', '2', '小美', '1589574828', '<img class=\"layui-kefu-photos\" src=\"/upload/images/06e1eae6d63948fe8546503ebbf9e5b9.png\" width=\"100px\" height=\"100px\">');
INSERT INTO `cs_chatmsg` VALUES ('8', '2', '小美', '1', '访客1', '1589574837', '<img class=\"layui-kefu-photos\" src=\"/upload/images/0c68acdd4cc1431cb451f4191cfa9efb.png\" width=\"100px\" height=\"100px\">');
INSERT INTO `cs_chatmsg` VALUES ('9', '2', '小美', '37', '访客37', '1589574929', '2');
INSERT INTO `cs_chatmsg` VALUES ('10', '2', '小美', '37', '访客37', '1589574935', '345');
INSERT INTO `cs_chatmsg` VALUES ('11', '2', '小美', '37', '访客37', '1589574948', '测试数据');
INSERT INTO `cs_chatmsg` VALUES ('12', '1', '访客1', '2', '小美', '1589575114', '你好！有什么需要帮助的？');
INSERT INTO `cs_chatmsg` VALUES ('13', '1', '访客1', '2', '小美', '1589575116', '欢迎来到simplekefu');
INSERT INTO `cs_chatmsg` VALUES ('14', '1', '访客1', '2', '小美', '1589575205', '😁😂🤣ヾ(≧▽≦*)o');
INSERT INTO `cs_chatmsg` VALUES ('15', '2', '小美', '37', '访客37', '1589575221', '22');
INSERT INTO `cs_chatmsg` VALUES ('16', '37', '访客37', '2', '小美', '1589575226', '22');
INSERT INTO `cs_chatmsg` VALUES ('17', '2', '小美', '38', '访客38', '1589586694', '1');
INSERT INTO `cs_chatmsg` VALUES ('18', '2', '小美', '38', '访客38', '1589587489', '2');
INSERT INTO `cs_chatmsg` VALUES ('19', null, '', '2', '小美', '1589587514', '1');
INSERT INTO `cs_chatmsg` VALUES ('20', '2', '小美', '38', '访客38', '1589587521', '22');
INSERT INTO `cs_chatmsg` VALUES ('21', '2', '小美', '38', '访客38', '1589587524', '33');
INSERT INTO `cs_chatmsg` VALUES ('22', '38', '访客38', '2', '小美', '1589587557', '222');
INSERT INTO `cs_chatmsg` VALUES ('23', '2', '小美', '38', '访客38', '1589587564', '<img class=\"layui-kefu-photos\" src=\"/upload/images/d3aaf7cf60ac4bdf89eb80b642cb774e.png\" width=\"100px\" height=\"100px\">');
INSERT INTO `cs_chatmsg` VALUES ('24', '2', '小美', '39', '访客39', '1589612385', '13');
INSERT INTO `cs_chatmsg` VALUES ('25', '2', '小美', '39', '访客39', '1589612457', '你好');
INSERT INTO `cs_chatmsg` VALUES ('26', '39', '访客39', '2', '小美', '1589612479', '有什么需要帮助的吗');
INSERT INTO `cs_chatmsg` VALUES ('27', '2', '小美', '39', '访客39', '1589612499', '111😁😂🤣');
INSERT INTO `cs_chatmsg` VALUES ('28', '2', '小美', '39', '访客39', '1589612508', 'ヾ(≧▽≦*)o');
INSERT INTO `cs_chatmsg` VALUES ('29', '2', '小美', '39', '访客39', '1589612524', '<img class=\"layui-kefu-photos\" src=\"/upload/images/cc3219c7e7fe40f884589933a0ca9db7.jpg\" width=\"100px\" height=\"100px\">');
INSERT INTO `cs_chatmsg` VALUES ('30', '39', '访客39', '2', '小美', '1589612560', '欢迎来到simplekefu');
INSERT INTO `cs_chatmsg` VALUES ('31', '39', '访客39', '2', '小美', '1589612564', '你好！有什么需要帮助的？');
INSERT INTO `cs_chatmsg` VALUES ('32', '2', '小美', '40', '访客40', '1589612908', '222');
INSERT INTO `cs_chatmsg` VALUES ('33', '2', '小美', '40', '访客40', '1589612935', '222');
INSERT INTO `cs_chatmsg` VALUES ('34', '2', '小美', '40', '访客40', '1589612941', '<img class=\"layui-kefu-photos\" src=\"/upload/images/362a8515ade04f0c8e2c711ec90bb849.png\" width=\"100px\" height=\"100px\">');
INSERT INTO `cs_chatmsg` VALUES ('35', '40', '访客40', '2', '小美', '1589612958', '欢迎来到simplekefu');

-- ----------------------------
-- Table structure for cs_company
-- ----------------------------
DROP TABLE IF EXISTS `cs_company`;
CREATE TABLE `cs_company` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `company` varchar(255) NOT NULL COMMENT '公司名称',
  `website` varchar(255) DEFAULT NULL COMMENT '官网链接',
  `phone` varchar(50) DEFAULT NULL COMMENT '联系电话',
  `present` varchar(255) DEFAULT NULL COMMENT '公司介绍',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of cs_company
-- ----------------------------
INSERT INTO `cs_company` VALUES ('1', 'simple客服', 'localhost:8080/simpleKefu', '123456789', '一个简单的客服系统，包含人工客服和机器人客服。');

-- ----------------------------
-- Table structure for cs_message
-- ----------------------------
DROP TABLE IF EXISTS `cs_message`;
CREATE TABLE `cs_message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL DEFAULT '' COMMENT '姓名',
  `phone` varchar(255) NOT NULL DEFAULT '' COMMENT '电话',
  `email` varchar(255) NOT NULL COMMENT '电子邮箱',
  `content` varchar(255) NOT NULL COMMENT '留言内容',
  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '状态 0未处理  1已处理',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of cs_message
-- ----------------------------
INSERT INTO `cs_message` VALUES ('1', '小李', '123456789', '123@outlook.com', '这是一条测试数据', '1');
INSERT INTO `cs_message` VALUES ('3', '张三', '123456789', '123@qq.com', '这是一条测试数据', '1');
INSERT INTO `cs_message` VALUES ('4', '李四', '123456789', '123@qq.com', '你们的客服系统多少钱一套？', '0');
INSERT INTO `cs_message` VALUES ('5', '王五', '123456789', '123@qq.com', '测试数据', '0');

-- ----------------------------
-- Table structure for cs_user
-- ----------------------------
DROP TABLE IF EXISTS `cs_user`;
CREATE TABLE `cs_user` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '自动编号',
  `account` varchar(50) NOT NULL COMMENT '用户账号',
  `username` varchar(50) NOT NULL COMMENT '用户姓名',
  `password` varchar(250) NOT NULL COMMENT '用户密码',
  `regtime` int(10) NOT NULL COMMENT '注册时间',
  `auth` tinyint(1) NOT NULL COMMENT '权限 1管理员 2普通客服',
  `online` tinyint(1) NOT NULL DEFAULT '0' COMMENT '在线状态 0离线 1在线',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '用户状态 0禁用 1启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of cs_user
-- ----------------------------
INSERT INTO `cs_user` VALUES ('1', 'admin', '小王', '123456', '1587539514', '1', '0', '1');
INSERT INTO `cs_user` VALUES ('2', '12345', '小美', '123456', '1587651121', '2', '1', '1');
INSERT INTO `cs_user` VALUES ('7', '001', '测试001', '123456', '1588136061', '2', '0', '1');
INSERT INTO `cs_user` VALUES ('8', '002', '测试002', '123456', '1588136085', '2', '0', '1');
INSERT INTO `cs_user` VALUES ('9', '003', '111111111', '123456', '1588136103', '2', '0', '0');
INSERT INTO `cs_user` VALUES ('10', '004', '测试004', '123456', '1588147305', '2', '0', '1');
INSERT INTO `cs_user` VALUES ('11', '005', '测试005', '123456', '1588147334', '2', '0', '1');
INSERT INTO `cs_user` VALUES ('12', '123', '123', '123', '1589612746', '2', '0', '1');

-- ----------------------------
-- Table structure for cs_visitor
-- ----------------------------
DROP TABLE IF EXISTS `cs_visitor`;
CREATE TABLE `cs_visitor` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `visitid` varchar(255) NOT NULL COMMENT '访客编号',
  `ip` varchar(255) DEFAULT '' COMMENT '访客网络地址',
  `address` varchar(255) DEFAULT '' COMMENT '访客地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of cs_visitor
-- ----------------------------
INSERT INTO `cs_visitor` VALUES ('1', '访客1', '123.139.254.159', '陕西省榆林市');
INSERT INTO `cs_visitor` VALUES ('2', '访客2', '123.139.254.159', '陕西省榆林市');
INSERT INTO `cs_visitor` VALUES ('3', '访客3', '123.139.254.159', '陕西省榆林市');
INSERT INTO `cs_visitor` VALUES ('4', '访客4', '123.139.254.159', '陕西省榆林市');
INSERT INTO `cs_visitor` VALUES ('5', '访客5', '123.139.254.159', '陕西省榆林市');
INSERT INTO `cs_visitor` VALUES ('6', '访客6', '123.139.254.159', '陕西省榆林市');
INSERT INTO `cs_visitor` VALUES ('7', '访客7', '123.139.254.159', '陕西省榆林市');
INSERT INTO `cs_visitor` VALUES ('8', '访客8', '123.139.254.159', '陕西省榆林市');
INSERT INTO `cs_visitor` VALUES ('9', '访客9', '123.139.254.159', '陕西省榆林市');
INSERT INTO `cs_visitor` VALUES ('10', '访客10', '123.139.254.159', '陕西省榆林市');
INSERT INTO `cs_visitor` VALUES ('11', '访客11', '123.139.254.159', '陕西省榆林市');
INSERT INTO `cs_visitor` VALUES ('12', '访客12', '123.139.254.159', '陕西省榆林市');
INSERT INTO `cs_visitor` VALUES ('13', '访客13', '123.139.254.159', '陕西省榆林市');
INSERT INTO `cs_visitor` VALUES ('14', '访客14', '123.139.254.159', '陕西省榆林市');
INSERT INTO `cs_visitor` VALUES ('15', '访客15', '123.139.254.159', '陕西省榆林市');
INSERT INTO `cs_visitor` VALUES ('16', '访客16', '123.139.254.159', '陕西省榆林市');
INSERT INTO `cs_visitor` VALUES ('17', '访客17', '123.139.254.159', '陕西省榆林市');
INSERT INTO `cs_visitor` VALUES ('18', '访客18', '123.139.254.159', '陕西省榆林市');
INSERT INTO `cs_visitor` VALUES ('19', '访客19', '123.139.254.159', '陕西省榆林市');
INSERT INTO `cs_visitor` VALUES ('20', '访客20', '123.139.254.159', '陕西省榆林市');
INSERT INTO `cs_visitor` VALUES ('21', '访客21', '123.139.254.159', '陕西省榆林市');
INSERT INTO `cs_visitor` VALUES ('22', '访客22', '123.139.254.159', '陕西省榆林市');
INSERT INTO `cs_visitor` VALUES ('23', '访客23', '123.139.254.159', '陕西省榆林市');
INSERT INTO `cs_visitor` VALUES ('24', '访客24', '123.139.254.159', '陕西省榆林市');
INSERT INTO `cs_visitor` VALUES ('25', '访客25', '123.139.254.159', '陕西省榆林市');
INSERT INTO `cs_visitor` VALUES ('26', '访客26', '123.139.254.159', '陕西省榆林市');
INSERT INTO `cs_visitor` VALUES ('27', '访客27', '123.139.254.159', '陕西省榆林市');
INSERT INTO `cs_visitor` VALUES ('28', '访客28', '123.139.254.159', '陕西省榆林市');
INSERT INTO `cs_visitor` VALUES ('29', '访客29', '123.139.255.2', '陕西省榆林市');
INSERT INTO `cs_visitor` VALUES ('30', '访客30', '123.139.255.2', '陕西省榆林市');
INSERT INTO `cs_visitor` VALUES ('31', '访客31', '123.139.255.2', '陕西省榆林市');
INSERT INTO `cs_visitor` VALUES ('32', '访客32', '123.139.255.2', '陕西省榆林市');
INSERT INTO `cs_visitor` VALUES ('33', '访客33', '123.139.255.2', '陕西省榆林市');
INSERT INTO `cs_visitor` VALUES ('34', '访客34', '123.139.255.2', '陕西省榆林市');
INSERT INTO `cs_visitor` VALUES ('35', '访客35', '123.139.255.2', '陕西省榆林市');
INSERT INTO `cs_visitor` VALUES ('36', '访客36', '124.89.114.244', '陕西省宝鸡市');
INSERT INTO `cs_visitor` VALUES ('37', '访客37', '124.89.114.244', '陕西省宝鸡市');
INSERT INTO `cs_visitor` VALUES ('38', '访客38', '124.89.114.244', '陕西省宝鸡市');
INSERT INTO `cs_visitor` VALUES ('39', '访客39', '124.89.114.244', '陕西省宝鸡市');
INSERT INTO `cs_visitor` VALUES ('40', '访客40', '124.89.114.244', '陕西省宝鸡市');

-- ----------------------------
-- Table structure for cs_words
-- ----------------------------
DROP TABLE IF EXISTS `cs_words`;
CREATE TABLE `cs_words` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) NOT NULL COMMENT '常用语内容',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of cs_words
-- ----------------------------
INSERT INTO `cs_words` VALUES ('1', '你好！有什么需要帮助的？', '0');
INSERT INTO `cs_words` VALUES ('5', '顾客您好，有什么可以帮您的吗？', '1');
INSERT INTO `cs_words` VALUES ('6', '欢迎来到simplekefu', '1');
INSERT INTO `cs_words` VALUES ('7', '这是一条测试语句', '0');
INSERT INTO `cs_words` VALUES ('10', '11111111', '0');
