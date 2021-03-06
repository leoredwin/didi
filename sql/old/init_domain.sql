-- Create syntax for TABLE 'tb_traffic_data'
CREATE TABLE `tb_traffic_data` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `district_hash` varchar(32) NOT NULL DEFAULT '' COMMENT '区域哈希值',
  `tj_level` varchar(64) NOT NULL DEFAULT '' COMMENT '不同拥堵程度的路段数',
  `tj_time` varchar(32) NOT NULL DEFAULT '' COMMENT '时间戳',
  `traffic_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '拥堵时间',
  PRIMARY KEY (`id`),
  KEY `idx_district_hash` (`district_hash`),
  KEY `idx_time` (`traffic_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='拥堵信息表';

-- Create syntax for TABLE 'tb_cluster_map'
CREATE TABLE `tb_cluster_map` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `district_hash` varchar(32) NOT NULL DEFAULT '' COMMENT '区域哈希值',
  `district_id` varchar(16) NOT NULL DEFAULT '' COMMENT '区域映射ID',
  PRIMARY KEY (`id`),
  KEY `idx_district_hash` (`district_hash`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='区域定义表';

-- Create syntax for TABLE 'tb_order_data'
CREATE TABLE `tb_order_data` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `order_id` varchar(64) NOT NULL DEFAULT '' COMMENT '订单id',
  `driver_id` varchar(32) DEFAULT '' COMMENT '司机id, 为空表示无人响应',
  `passenger_id` varchar(32) NOT NULL DEFAULT '' COMMENT '用户id',
  `start_district_hash` varchar(32) NOT NULL DEFAULT '' COMMENT '出发地区域哈希值',
  `dest_district_hash` varchar(32) NOT NULL DEFAULT '' COMMENT '目的地区域哈希值',
  `price` double(11,2) NOT NULL COMMENT '价格',
  `time` varchar(32) NOT NULL DEFAULT '' COMMENT '订单时间戳',
  `order_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '订单创建时间',
  PRIMARY KEY (`id`),
  KEY `idx_start_district_hash` (`start_district_hash`),
  KEY `idx_dest_district_hash` (`dest_district_hash`),
  KEY `idx_time` (`order_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单信息表';

-- Create syntax for TABLE 'tb_poi_data'
CREATE TABLE `tb_poi_data` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `district_hash` varchar(32) NOT NULL DEFAULT '' COMMENT '区域哈希值',
  `poi_class` varchar(516) NOT NULL DEFAULT '' COMMENT 'POI类目及其数量',
  PRIMARY KEY (`id`),
  KEY `idx_district_hash` (`district_hash`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='POI信息表';

-- Create syntax for TABLE 'tb_weather_data'
CREATE TABLE `tb_weather_data` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `time` varchar(32) NOT NULL DEFAULT '' COMMENT '时间戳',
  `weather` int(11) NOT NULL COMMENT '天气',
  `temperature` tinyint(11) NOT NULL COMMENT '温度',
  `PM` int(11) NOT NULL COMMENT 'pm2.5',
  `weater_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'times_weater',
  PRIMARY KEY (`id`),
  KEY `idx_string_time` (`time`),
  KEY `idx_time` (`weater_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='天气信息表';