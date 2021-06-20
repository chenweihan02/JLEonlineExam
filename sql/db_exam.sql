/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50731
Source Host           : localhost:3306
Source Database       : db_exam

Target Server Type    : MYSQL
Target Server Version : 50731
File Encoding         : 65001

Date: 2021-06-19 15:03:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `exam`
-- ----------------------------
DROP TABLE IF EXISTS `exam`;
CREATE TABLE `exam` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `e_name` varchar(11) NOT NULL COMMENT '考试名称',
  `startTime` datetime NOT NULL COMMENT '开始时间',
  `endTime` datetime NOT NULL COMMENT '结束时间',
  `questionNum` int(11) NOT NULL COMMENT '试题总数',
  `totalScore` int(11) NOT NULL COMMENT '总分',
  `isDel` int(11) NOT NULL DEFAULT '0' COMMENT '是否是删除状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exam
-- ----------------------------
INSERT INTO `exam` VALUES ('1', '高等数学', '2021-06-16 09:57:34', '2021-06-17 09:57:37', '3', '35', '0');

-- ----------------------------
-- Table structure for `exampaper`
-- ----------------------------
DROP TABLE IF EXISTS `exampaper`;
CREATE TABLE `exampaper` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `examId` int(11) NOT NULL COMMENT '所属考试ID',
  `studentId` varchar(11) NOT NULL COMMENT '所属学生ID',
  `totalScore` int(11) DEFAULT '0' COMMENT '试卷总分',
  `score` int(11) NOT NULL DEFAULT '0' COMMENT '得分',
  PRIMARY KEY (`id`),
  KEY `exampaper_ibfk_1` (`examId`),
  KEY `exampaper_ibfk_2` (`studentId`),
  CONSTRAINT `exampaper_ibfk_1` FOREIGN KEY (`examId`) REFERENCES `exam` (`id`),
  CONSTRAINT `exampaper_ibfk_2` FOREIGN KEY (`studentId`) REFERENCES `student` (`s_id`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exampaper
-- ----------------------------

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
  CONSTRAINT `exampaperanswer_ibfk_4` FOREIGN KEY (`studentId`) REFERENCES `student` (`s_id`)
) ENGINE=InnoDB AUTO_INCREMENT=137 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exampaperanswer
-- ----------------------------

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
  `id` int(11) NOT NULL COMMENT '主键id',
  `s_id` varchar(255) NOT NULL COMMENT '学号 都为11位数',
  `s_name` varchar(255) NOT NULL COMMENT '姓名',
  `s_password` varchar(255) NOT NULL COMMENT '密码',
  PRIMARY KEY (`id`),
  KEY `s_id` (`s_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '2019111', '小明1', '123456');
INSERT INTO `student` VALUES ('2', '2019112', 'jle2', '123456');

-- ----------------------------
-- Table structure for `teacher`
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `t_id` varchar(11) NOT NULL COMMENT '工号或id，不重要了',
  `t_name` varchar(11) NOT NULL,
  `t_password` varchar(255) NOT NULL,
  `t_isadmin` int(11) NOT NULL COMMENT '是否管理员权限',
  PRIMARY KEY (`t_id`),
  KEY `t_id` (`t_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', '陈顶天', '123456', '1');
