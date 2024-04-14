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

 Date: 14/04/2024 13:48:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for apply_node
-- ----------------------------
DROP TABLE IF EXISTS `apply_node`;
CREATE TABLE `apply_node`  (
  `apply_node_id` bigint(0) NOT NULL COMMENT '申请节点的唯一标识',
  `apply_id` bigint(0) NULL DEFAULT NULL COMMENT '申请的唯一标识',
  `node_status` int(0) NULL DEFAULT NULL COMMENT '节点的状态',
  `operator` bigint(0) NULL DEFAULT NULL COMMENT '操作者的用户ID',
  `node_type` int(0) NULL DEFAULT NULL COMMENT '节点的类型',
  `work_flow_node_id` bigint(0) NULL DEFAULT NULL COMMENT '工作流节点的唯一标识',
  `work_flow_node_handle_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '工作流节点的操作名称',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`apply_node_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of apply_node
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
