/*
 Navicat Premium Data Transfer

 Source Server         : 本机
 Source Server Type    : MySQL
 Source Server Version : 50720 (5.7.20)
 Source Host           : localhost:3306
 Source Schema         : easyproject

 Target Server Type    : MySQL
 Target Server Version : 50720 (5.7.20)
 File Encoding         : 65001

 Date: 31/10/2025 09:40:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for easyuser
-- ----------------------------
DROP TABLE IF EXISTS `easyuser`;
CREATE TABLE `easyuser`  (
  `update_time` datetime NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `version` int(11) NULL DEFAULT NULL,
  `id` int(24) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `role` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` tinyint(255) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of easyuser
-- ----------------------------
INSERT INTO `easyuser` VALUES ('2025-10-28 23:55:37', NULL, NULL, 1, 'cyy', '666666', 'email@qq.com', '超级管理员', 1);
INSERT INTO `easyuser` VALUES (NULL, NULL, NULL, 2, 'naughty', '888888', '456@qq.com', '普通用户', 0);
INSERT INTO `easyuser` VALUES (NULL, NULL, NULL, 3, 'flysky01', '987654', 'qwe@qq.com', '普通用户', 1);
INSERT INTO `easyuser` VALUES (NULL, NULL, NULL, 4, 'anglybirds', '321654', 'aaaa@163.com', '普通用户', 0);
INSERT INTO `easyuser` VALUES ('2025-10-29 00:02:54', NULL, NULL, 7, 'admin003', 'q123456', 'ccc@qq.com', '普通用户', 1);
INSERT INTO `easyuser` VALUES (NULL, NULL, NULL, 8, 'admin005', '123456', 'cxz@qq.com', '普通用户', 0);
INSERT INTO `easyuser` VALUES (NULL, NULL, NULL, 9, 'admin007', '123456', 'rty@qq.com', '超级管理员', 1);
INSERT INTO `easyuser` VALUES ('2025-10-29 00:01:23', '2025-10-29 00:01:23', NULL, 11, '纯音乐', '123456', '21@1.co', '普通用户', 1);
INSERT INTO `easyuser` VALUES ('2025-10-29 00:01:51', '2025-10-29 00:01:51', NULL, 12, '帅哥大', '777777', '25@lk.ks', '普通用户', 1);
INSERT INTO `easyuser` VALUES ('2025-10-29 00:02:28', '2025-10-29 00:02:28', NULL, 13, 'sgc', 'qwerty', '266@k.cq', NULL, 1);
INSERT INTO `easyuser` VALUES ('2025-10-29 12:11:00', '2025-10-29 12:11:00', NULL, 15, '张三2', '12435135', '2142@qq.com', NULL, 1);
INSERT INTO `easyuser` VALUES ('2025-10-29 12:23:09', '2025-10-29 12:23:09', NULL, 18, '奇洛李维斯', '777777', '77@qq.com', '普通用户', 1);

-- ----------------------------
-- Table structure for mainmenu
-- ----------------------------
DROP TABLE IF EXISTS `mainmenu`;
CREATE TABLE `mainmenu`  (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 201 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mainmenu
-- ----------------------------
INSERT INTO `mainmenu` VALUES (100, '权限管理', '/admin');
INSERT INTO `mainmenu` VALUES (200, '运动平台', '/use');

-- ----------------------------
-- Table structure for submenu
-- ----------------------------
DROP TABLE IF EXISTS `submenu`;
CREATE TABLE `submenu`  (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `mid` int(50) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `mid`(`mid`) USING BTREE,
  CONSTRAINT `submenu_ibfk_1` FOREIGN KEY (`mid`) REFERENCES `mainmenu` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 204 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of submenu
-- ----------------------------
INSERT INTO `submenu` VALUES (101, '用户列表', '/user', 100);
INSERT INTO `submenu` VALUES (102, '修改权限', '/rights', 100);
INSERT INTO `submenu` VALUES (103, ' 运动模块', '/sport', 100);
INSERT INTO `submenu` VALUES (104, '商品模块', '/goods', 100);
INSERT INTO `submenu` VALUES (201, '运动科普', '/Introduction', 200);
INSERT INTO `submenu` VALUES (202, '卡路里', '/calories', 200);
INSERT INTO `submenu` VALUES (203, '营养配餐', '/food', 200);

SET FOREIGN_KEY_CHECKS = 1;
