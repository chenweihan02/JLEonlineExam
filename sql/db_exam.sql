/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50731
Source Host           : localhost:3306
Source Database       : db_exam

Target Server Type    : MYSQL
Target Server Version : 50731
File Encoding         : 65001

Date: 2021-06-24 16:55:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `exam`
-- ----------------------------
DROP TABLE IF EXISTS `exam`;
CREATE TABLE `exam` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `examName` varchar(11) NOT NULL COMMENT '考试名称',
  `startTime` datetime NOT NULL COMMENT '开始时间',
  `endTime` datetime NOT NULL COMMENT '结束时间',
  `questionNum` int(11) NOT NULL DEFAULT '0' COMMENT '试题总数',
  `totalScore` int(11) NOT NULL DEFAULT '0' COMMENT '总分',
  `isDel` int(11) NOT NULL DEFAULT '0' COMMENT '是否是删除状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exam
-- ----------------------------
INSERT INTO `exam` VALUES ('1', '高等数学', '2021-06-16 09:57:34', '2021-06-17 09:57:37', '3', '35', '0');
INSERT INTO `exam` VALUES ('2', '大学英语', '2021-06-08 21:00:54', '2021-06-24 21:00:57', '0', '0', '0');
INSERT INTO `exam` VALUES ('3', '体育', '2021-06-17 21:01:07', '2021-06-18 21:01:14', '0', '0', '0');
INSERT INTO `exam` VALUES ('4', 'JavaWeb', '2021-06-04 21:01:24', '2021-06-11 21:01:27', '0', '0', '0');
INSERT INTO `exam` VALUES ('5', '商业统计', '2021-06-08 21:01:40', '2021-07-01 21:01:44', '0', '0', '0');
INSERT INTO `exam` VALUES ('6', '大学语文', '2021-06-23 07:38:56', '2021-06-26 07:39:01', '0', '0', '0');

-- ----------------------------
-- Table structure for `exampaper`
-- ----------------------------
DROP TABLE IF EXISTS `exampaper`;
CREATE TABLE `exampaper` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `examId` int(11) NOT NULL COMMENT '所属考试ID',
  `studentId` varchar(11) NOT NULL COMMENT '所属学生ID',
  `totalScore` int(11) NOT NULL DEFAULT '0' COMMENT '试卷总分',
  `score` int(11) NOT NULL DEFAULT '0' COMMENT '得分',
  PRIMARY KEY (`id`),
  KEY `exampaper_ibfk_1` (`examId`),
  KEY `exampaper_ibfk_2` (`studentId`),
  CONSTRAINT `exampaper_ibfk_1` FOREIGN KEY (`examId`) REFERENCES `exam` (`id`),
  CONSTRAINT `exampaper_ibfk_2` FOREIGN KEY (`studentId`) REFERENCES `student` (`studentId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exampaper
-- ----------------------------
INSERT INTO `exampaper` VALUES ('1', '1', '2019111', '40', '20');
INSERT INTO `exampaper` VALUES ('2', '1', '2019112', '100', '80');

-- ----------------------------
-- Table structure for `exampaperanswer`
-- ----------------------------
DROP TABLE IF EXISTS `exampaperanswer`;
CREATE TABLE `exampaperanswer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `examId` int(11) NOT NULL COMMENT '所属考试ID',
  `studentId` varchar(11) NOT NULL COMMENT '学生学号',
  `examPaperId` int(11) NOT NULL COMMENT '所属试卷ID',
  `questionId` int(11) NOT NULL COMMENT '所属试题ID',
  `answer` varchar(32) DEFAULT NULL COMMENT '提交的答案',
  `isCorrent` int(2) DEFAULT NULL COMMENT '是否正确',
  PRIMARY KEY (`id`),
  KEY `exampaperanswer_ibfk_1` (`examId`),
  KEY `exampaperanswer_ibfk_2` (`examPaperId`),
  KEY `exampaperanswer_ibfk_3` (`questionId`),
  KEY `exampaperanswer_ibfk_4` (`studentId`),
  CONSTRAINT `exampaperanswer_ibfk_1` FOREIGN KEY (`examId`) REFERENCES `exam` (`id`),
  CONSTRAINT `exampaperanswer_ibfk_2` FOREIGN KEY (`examPaperId`) REFERENCES `exampaper` (`id`),
  CONSTRAINT `exampaperanswer_ibfk_3` FOREIGN KEY (`questionId`) REFERENCES `question` (`id`),
  CONSTRAINT `exampaperanswer_ibfk_4` FOREIGN KEY (`studentId`) REFERENCES `student` (`studentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exampaperanswer
-- ----------------------------

-- ----------------------------
-- Table structure for `log`
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) NOT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of log
-- ----------------------------
INSERT INTO `log` VALUES ('18', '学生李一一2019111登录成功', '2021-06-24 15:11:43');
INSERT INTO `log` VALUES ('19', '学生李一一2019111登录成功', '2021-06-24 15:18:21');
INSERT INTO `log` VALUES ('20', '学生李一一2019111登录成功', '2021-06-24 15:51:24');
INSERT INTO `log` VALUES ('21', '老师陈顶天1001登录成功', '2021-06-24 15:51:41');
INSERT INTO `log` VALUES ('22', '管理员陈顶天1001登录成功', '2021-06-24 16:17:52');
INSERT INTO `log` VALUES ('23', '管理员陈顶天1001登录成功', '2021-06-24 16:18:56');
INSERT INTO `log` VALUES ('24', '老师陈顶天1001登录成功', '2021-06-24 16:20:05');
INSERT INTO `log` VALUES ('25', '学生李一一2019111登录成功', '2021-06-24 16:20:22');
INSERT INTO `log` VALUES ('26', '老师陈顶天1001登录成功', '2021-06-24 16:50:53');
INSERT INTO `log` VALUES ('27', '学生李一一2019111登录成功', '2021-06-24 16:51:05');

-- ----------------------------
-- Table structure for `question`
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(255) NOT NULL COMMENT '问题题目',
  `score` int(3) NOT NULL COMMENT '分值',
  `attrA` varchar(255) NOT NULL COMMENT '选项A',
  `attrB` varchar(255) NOT NULL COMMENT '选项B',
  `attrC` varchar(255) NOT NULL COMMENT '选项C',
  `attrD` varchar(255) NOT NULL COMMENT '选项D',
  `answer` varchar(255) NOT NULL COMMENT '该题正确答案',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES ('1', '1 -1 ', '5', '0', '1', '2', '3', 'A');
INSERT INTO `question` VALUES ('2', '5 * 5', '10', '12', '14', '20', '25', 'D');
INSERT INTO `question` VALUES ('3', '15 * 15', '20', '100', '225', '355', '500', 'B');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `studentId` varchar(255) NOT NULL COMMENT '学号 都为11位数',
  `name` varchar(255) NOT NULL COMMENT '姓名',
  `password` varchar(255) NOT NULL COMMENT '密码',
  PRIMARY KEY (`id`),
  KEY `s_id` (`studentId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '2019111', '李一一', '123456');
INSERT INTO `student` VALUES ('2', '2019112', '韩朵朵', '123456');

-- ----------------------------
-- Table structure for `subject`
-- ----------------------------
DROP TABLE IF EXISTS `subject`;
CREATE TABLE `subject` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of subject
-- ----------------------------
INSERT INTO `subject` VALUES ('1', '软件工程');
INSERT INTO `subject` VALUES ('2', '自动化');
INSERT INTO `subject` VALUES ('3', '经济学');

-- ----------------------------
-- Table structure for `teacher`
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键自增ID',
  `teacherId` varchar(11) NOT NULL COMMENT '工号',
  `name` varchar(11) NOT NULL,
  `password` varchar(255) NOT NULL,
  `isAdmin` int(11) NOT NULL COMMENT '是否管理员权限',
  PRIMARY KEY (`id`),
  KEY `t_id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', '1001', '陈顶天', '123456', '1');
INSERT INTO `teacher` VALUES ('2', '1002', 'cdt', '123456', '0');
