/*
 Navicat Premium Data Transfer

 Source Server         : yang
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : localhost:3306
 Source Schema         : carmaintain

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 15/04/2021 21:09:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for car_info
-- ----------------------------
DROP TABLE IF EXISTS `car_info`;
CREATE TABLE `car_info`  (
  `car_id` int(11) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT COMMENT '车辆编号',
  `customer_id` int(11) NOT NULL COMMENT '客户编号',
  `car_code` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '车辆编码(车厂区分车辆的编码)',
  `name` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '客户姓名',
  `car_number` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '车牌号',
  `car_model` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '车型',
  `car_type` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '车类型',
  `car_brand` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '车品牌',
  `engine_number` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发动机号码',
  `chassis_number` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '底牌号码',
  `use_unit` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '使用单位',
  `duty_person` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '责任人',
  `maintain_time` datetime(0) NULL DEFAULT NULL COMMENT '最近保养时间',
  `createTime` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '录入时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`car_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '车辆信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of car_info
-- ----------------------------

-- ----------------------------
-- Table structure for customer_info
-- ----------------------------
DROP TABLE IF EXISTS `customer_info`;
CREATE TABLE `customer_info`  (
  `customer_id` int(11) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT COMMENT '客户编号',
  `username` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `name` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `car_id` int(11) NULL DEFAULT NULL COMMENT '车辆信息编号',
  `car_code` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '车辆编码',
  `gender` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '性别 0男 1女',
  `birthday` date NULL DEFAULT NULL COMMENT '生日',
  `phone` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手机号码',
  `email` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱地址',
  `address` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `idcard` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '身份证号码',
  `createTime` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '录入日期',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '备注',
  PRIMARY KEY (`customer_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '客户信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of customer_info
-- ----------------------------

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `id` int(11) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门名称',
  `enabled` tinyint(1) NULL DEFAULT 1 COMMENT '部门状态',
  `createTime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 116 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES (00000000001, '股东会', 1, NULL, NULL);
INSERT INTO `department` VALUES (00000000004, '董事会', 1, NULL, NULL);
INSERT INTO `department` VALUES (00000000005, '总办', 1, NULL, NULL);
INSERT INTO `department` VALUES (00000000008, '财务部', 1, NULL, NULL);
INSERT INTO `department` VALUES (00000000078, '市场部', 1, NULL, NULL);
INSERT INTO `department` VALUES (00000000081, '华北市场部', 1, NULL, NULL);
INSERT INTO `department` VALUES (00000000082, '华南市场部', 1, NULL, NULL);
INSERT INTO `department` VALUES (00000000085, '石家庄市场部', 1, NULL, NULL);
INSERT INTO `department` VALUES (00000000086, '西北市场部', 1, NULL, NULL);
INSERT INTO `department` VALUES (00000000087, '西安市场', 1, NULL, NULL);
INSERT INTO `department` VALUES (00000000089, '莲湖区市场', 1, NULL, NULL);
INSERT INTO `department` VALUES (00000000091, '技术部', 1, NULL, NULL);
INSERT INTO `department` VALUES (00000000092, '运维部', 1, NULL, NULL);
INSERT INTO `department` VALUES (00000000093, '运维1部', 1, NULL, NULL);
INSERT INTO `department` VALUES (00000000094, '运维2部', 1, NULL, NULL);
INSERT INTO `department` VALUES (00000000096, 'bbb', 1, NULL, NULL);
INSERT INTO `department` VALUES (00000000104, '111', 1, NULL, NULL);
INSERT INTO `department` VALUES (00000000105, '测试1', 1, NULL, NULL);
INSERT INTO `department` VALUES (00000000114, '213', 1, NULL, NULL);
INSERT INTO `department` VALUES (00000000115, '123', 1, NULL, NULL);

-- ----------------------------
-- Table structure for factory
-- ----------------------------
DROP TABLE IF EXISTS `factory`;
CREATE TABLE `factory`  (
  `id` int(11) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT COMMENT '出入厂记录编号',
  `car_id` int(11) NOT NULL COMMENT '车辆信息编号',
  `car_code` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '车辆编码',
  `costomer_id` int(11) NOT NULL COMMENT '客户编号',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户姓名',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '车辆状态 0待入厂1已入场2已出厂',
  `in_time` datetime(0) NULL DEFAULT NULL COMMENT '入厂时间',
  `out_time` datetime(0) NULL DEFAULT NULL COMMENT '出厂时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '出入厂记录管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of factory
-- ----------------------------

-- ----------------------------
-- Table structure for maintain_dispatch
-- ----------------------------
DROP TABLE IF EXISTS `maintain_dispatch`;
CREATE TABLE `maintain_dispatch`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '派工编号',
  `user_id` int(11) NOT NULL COMMENT '技工编号',
  `user_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '技工名字',
  `order_id` int(11) NULL DEFAULT NULL COMMENT '订单编号',
  `customer_id` int(11) NULL DEFAULT NULL COMMENT '客户编号',
  `customer_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户名称',
  `car_id` int(11) NULL DEFAULT NULL COMMENT '车辆编号',
  `car_code` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '车辆编码',
  `time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '派工时间',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '状态 0进行中1已完成',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '保养派工管理表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of maintain_dispatch
-- ----------------------------

-- ----------------------------
-- Table structure for maintain_project
-- ----------------------------
DROP TABLE IF EXISTS `maintain_project`;
CREATE TABLE `maintain_project`  (
  `project_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '保养项目编号',
  `project_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '保养项目名称',
  `description` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目描述',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '保养价格',
  `order_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '预定定金',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`project_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '保养项目表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of maintain_project
-- ----------------------------

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `order_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单编号',
  `customer_id` int(11) NOT NULL COMMENT '客户编号',
  `customer_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户姓名',
  `project_id` int(11) NOT NULL COMMENT '保养项目编号',
  `project_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '保养项目名称',
  `order_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '预付定金',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '保养费用',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单状态  1已发起(已支付定金)2进行中3已完成 4已取消',
  `maintain_time` datetime(0) NULL DEFAULT NULL COMMENT '到店保养时间',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '预定时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for performance
-- ----------------------------
DROP TABLE IF EXISTS `performance`;
CREATE TABLE `performance`  (
  `id` int(11) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT COMMENT '记录id',
  `user_id` int(11) NOT NULL COMMENT '用户编号',
  `name` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '真实姓名',
  `work_id` char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '员工工号',
  `early_num` int(2) NULL DEFAULT NULL COMMENT '早退次数',
  `time` date NULL DEFAULT NULL COMMENT '时间',
  `absenteeism_num` int(2) NULL DEFAULT NULL COMMENT '缺勤天数',
  `attendance_num` int(2) NULL DEFAULT NULL COMMENT '出勤天数',
  `late_num` int(2) NULL DEFAULT NULL COMMENT '迟到次数',
  `work_num` int(2) NULL DEFAULT NULL COMMENT '出工次数',
  `entry_id` int(11) NULL DEFAULT NULL COMMENT '录入人',
  `entry_date` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '录入日期',
  `update_id` int(11) NULL DEFAULT NULL COMMENT '更新人',
  `update_date` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新日期',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '绩效管理表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of performance
-- ----------------------------

-- ----------------------------
-- Table structure for reception
-- ----------------------------
DROP TABLE IF EXISTS `reception`;
CREATE TABLE `reception`  (
  `reception_id` int(11) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT COMMENT '接待编号',
  `user_id` int(11) NOT NULL COMMENT '接待员编号',
  `work_id` char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '接待员工号',
  `user_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '接待员姓名',
  `order_id` int(11) NULL DEFAULT NULL COMMENT '订单编号',
  `customer_id` int(11) NOT NULL COMMENT '客户编号',
  `customer_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户姓名',
  `reception_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '接待时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`reception_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '接待管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of reception
-- ----------------------------

-- ----------------------------
-- Table structure for settle
-- ----------------------------
DROP TABLE IF EXISTS `settle`;
CREATE TABLE `settle`  (
  `settle_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '结算编号',
  `user_id` int(11) NOT NULL COMMENT '结算员编号',
  `work_id` char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '结算员工号',
  `user_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '结算员姓名',
  `customer_id` int(11) NULL DEFAULT NULL COMMENT '客户编号',
  `customer_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户名字',
  `order_id` int(11) NULL DEFAULT NULL COMMENT '订单编号',
  `project_id` int(11) NULL DEFAULT NULL COMMENT '保养编号',
  `project_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '保养名字',
  `project_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '保养价格',
  `goods` json NULL COMMENT '商品json [{\'id\':\'\',\'name\':\'\',\'price\':\'\'}]',
  `goods_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '商品总价格',
  `total_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '总价格',
  `settle_time` datetime(0) NULL DEFAULT NULL COMMENT '结算时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`settle_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of settle
-- ----------------------------

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `user_id` int(11) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `role` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色 0系统管理员 1接待员 2技工',
  `name` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `departId` int(11) NOT NULL COMMENT '员工部门Id',
  `gender` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '性别 0男 1女',
  `birthday` date NULL DEFAULT NULL COMMENT '生日',
  `phone` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手机号码',
  `email` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱地址',
  `address` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `idcard` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '身份证号码',
  `work_id` char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '员工工号',
  `workstatus` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '工作状态 0正常 1已出工',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `uqe_username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_info
-- ----------------------------

-- ----------------------------
-- Table structure for warehouse
-- ----------------------------
DROP TABLE IF EXISTS `warehouse`;
CREATE TABLE `warehouse`  (
  `id` int(11) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT COMMENT '仓库管理编号',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品名称',
  `model` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '型号',
  `number` int(11) NULL DEFAULT 0 COMMENT '剩余数量',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品描述',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '商品价格',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '仓库商品管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of warehouse
-- ----------------------------

-- ----------------------------
-- Table structure for warehouse_record
-- ----------------------------
DROP TABLE IF EXISTS `warehouse_record`;
CREATE TABLE `warehouse_record`  (
  `id` int(11) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT COMMENT '出入库记录编号',
  `user_id` int(11) NOT NULL COMMENT '操作员编号',
  `work_id` char(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '操作员工号',
  `user_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作员姓名',
  `warehouse_id` int(11) NOT NULL COMMENT '商品编号',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品名称',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '状态 0入库 1出库',
  `time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '出入库时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品出入库记录编号' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of warehouse_record
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
