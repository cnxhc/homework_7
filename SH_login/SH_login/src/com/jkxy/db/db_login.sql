/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50519
Source Host           : localhost:3306
Source Database       : db_login

Target Server Type    : MYSQL
Target Server Version : 50519
File Encoding         : 65001

Date: 2016-06-07 10:37:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(16) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `real_name` varchar(32) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `phone_num` varchar(32) DEFAULT NULL,
  `isadmin` tinyint(1) unsigned zerofill NOT NULL DEFAULT '0',
  `address` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'admin', 'admin123', '管理员', '26', '158889988', '1', '北京');
INSERT INTO `users` VALUES ('2', 'suning', '123456', '苏宁', '27', '1586889886', '0', '南京');
INSERT INTO `users` VALUES ('3', 'lisi', '1234', '李思', '23', '1505086858', '0', '杭州');
INSERT INTO `users` VALUES ('4', 'jd', '54321', '京东', '44', '1545454544', '0', '北京');
INSERT INTO `users` VALUES ('7', '小米', 'xiaomi123', '雷军', '38', '1546047448', '0', '北京');
INSERT INTO `users` VALUES ('8', 'meizu', 'meizu123', '黄章', '37', '1587868588', '0', '珠海');
INSERT INTO `users` VALUES ('9', 'taobao', '123', '淘宝', '32', '1587869588', '0', '杭州');
INSERT INTO `users` VALUES ('10', 'zhangsan', '123', '张三', '21', '152544998', '0', '上海');
INSERT INTO `users` VALUES ('11', 'wangwu', '123456', '王五', '22', '1528899843', '0', '苏州');
