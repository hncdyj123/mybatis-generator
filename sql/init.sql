/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : localhost:3306
 Source Schema         : mybatis_generator_test

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : 65001

 Date: 18/04/2019 12:37:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for test_operator_activity
-- ----------------------------
DROP TABLE IF EXISTS `test_operator_activity`;
CREATE TABLE `test_operator_activity`  (
  `id` char(19) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `activity_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '活动ID',
  `activity_desc` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '中文描述',
  `operator` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '操盘手',
  `is_down` tinyint(1) DEFAULT 0 COMMENT '是否停用(0 否  1 是)',
  `activity_cost` decimal(10, 2) DEFAULT 0.00 COMMENT '活动成本 例如：打车、买水、记者红包等等',
  `activity_remark` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '活动成本备注',
  `create_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
  `create_datetime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '修改人',
  `update_datetime` timestamp(0) NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `ams_oerator_activity_update_datetime`(`update_datetime`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '运营活动表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for test_operator_channel
-- ----------------------------
DROP TABLE IF EXISTS `test_operator_channel`;
CREATE TABLE `test_operator_channel`  (
  `id` char(19) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `channel_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '渠道ID',
  `chinese_desc` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '中文描述',
  `supplier_id` char(19) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '渠道商ID',
  `group_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '渠道分组名',
  `throw_flag` tinyint(1) DEFAULT NULL COMMENT '弃包标识(0  不弃包  1 弃包)',
  `paint_flag` tinyint(1) DEFAULT NULL COMMENT '看板标识(0 不可看 1 可看)',
  `is_down` tinyint(1) DEFAULT 0 COMMENT '是否停用(0 否  1 是)',
  `create_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
  `create_datetime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '修改人',
  `update_datetime` timestamp(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `ams_operator_channel_update_datetime`(`update_datetime`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '运营渠道表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for test_operator_originality
-- ----------------------------
DROP TABLE IF EXISTS `test_operator_originality`;
CREATE TABLE `test_operator_originality`  (
  `id` char(19) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `originality_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创意ID',
  `originality_desc` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '中文描述',
  `paint_flag` tinyint(1) DEFAULT NULL COMMENT '看板标识',
  `operator` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '操盘手',
  `is_down` tinyint(1) DEFAULT 0 COMMENT '是否停用(0 否  1 是)',
  `create_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
  `create_datetime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '修改人',
  `update_datetime` timestamp(0) NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `ams_operator_originality_update_datetime`(`update_datetime`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '运营创意表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;