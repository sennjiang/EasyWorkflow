/*
 Navicat Premium Data Transfer

 Source Server         : root
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : workflow

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 14/04/2024 13:49:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for workflow_node_link
-- ----------------------------
DROP TABLE IF EXISTS `workflow_node_link`;
CREATE TABLE `workflow_node_link`  (
  `id` bigint(0) NOT NULL,
  `workflow_node_pre` bigint(0) NULL DEFAULT NULL,
  `workflow_node_next` bigint(0) NULL DEFAULT NULL,
  `pre_status` tinyint(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
