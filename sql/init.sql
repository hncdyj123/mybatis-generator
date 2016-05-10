-- ----------------------------
-- Table structure for ams_operator_activity
-- ----------------------------
DROP TABLE IF EXISTS `ams_operator_activity`;
CREATE TABLE `ams_operator_activity` (
  `id` char(19) NOT NULL COMMENT '主键',
  `activity_id` varchar(100) DEFAULT NULL COMMENT '活动ID',
  `activity_desc` varchar(200) DEFAULT NULL COMMENT '中文描述',
  `operator` varchar(20) DEFAULT NULL COMMENT '操盘手',
  `is_down` tinyint(1) DEFAULT '0' COMMENT '是否停用(0 否  1 是)',
  `activity_cost` decimal(10,2) DEFAULT '0.00' COMMENT '活动成本 例如：打车、买水、记者红包等等',
  `activity_remark` varchar(200) DEFAULT NULL COMMENT '活动成本备注',
  `create_name` varchar(20) DEFAULT NULL COMMENT '创建人',
  `create_datetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_name` varchar(20) DEFAULT NULL COMMENT '修改人',
  `update_datetime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `ams_oerator_activity_update_datetime` (`update_datetime`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='运营活动表';

-- ----------------------------
-- Table structure for ams_operator_channel
-- ----------------------------
DROP TABLE IF EXISTS `ams_operator_channel`;
CREATE TABLE `ams_operator_channel` (
  `id` char(19) NOT NULL COMMENT '主键',
  `channel_id` varchar(100) DEFAULT NULL COMMENT '渠道ID',
  `chinese_desc` varchar(100) DEFAULT NULL COMMENT '中文描述',
  `supplier_id` char(19) DEFAULT NULL COMMENT '渠道商ID',
  `group_name` varchar(20) DEFAULT NULL COMMENT '渠道分组名',
  `throw_flag` tinyint(1) DEFAULT NULL COMMENT '弃包标识(0  不弃包  1 弃包)',
  `paint_flag` tinyint(1) DEFAULT NULL COMMENT '看板标识(0 不可看 1 可看)',
  `is_down` tinyint(1) DEFAULT '0' COMMENT '是否停用(0 否  1 是)',
  `create_name` varchar(20) DEFAULT NULL COMMENT '创建人',
  `create_datetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_name` varchar(20) DEFAULT NULL COMMENT '修改人',
  `update_datetime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `ams_operator_channel_update_datetime` (`update_datetime`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='运营渠道表';

-- ----------------------------
-- Table structure for ams_operator_originality
-- ----------------------------
DROP TABLE IF EXISTS `ams_operator_originality`;
CREATE TABLE `ams_operator_originality` (
  `id` char(19) NOT NULL COMMENT '主键',
  `originality_id` varchar(100) DEFAULT NULL COMMENT '创意ID',
  `originality_desc` varchar(200) DEFAULT NULL COMMENT '中文描述',
  `paint_flag` tinyint(1) DEFAULT NULL COMMENT '看板标识',
  `operator` varchar(20) DEFAULT NULL COMMENT '操盘手',
  `is_down` tinyint(1) DEFAULT '0' COMMENT '是否停用(0 否  1 是)',
  `create_name` varchar(20) DEFAULT NULL COMMENT '创建人',
  `create_datetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_name` varchar(20) DEFAULT NULL COMMENT '修改人',
  `update_datetime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `ams_operator_originality_update_datetime` (`update_datetime`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='运营创意表';
