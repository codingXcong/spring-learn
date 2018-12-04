CREATE TABLE `items` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(32) NOT NULL COMMENT '商品名称',
  `price` FLOAT(10,1) NOT NULL COMMENT '商品定价',
  `detail` TEXT COMMENT '商品描述',
  `pic` VARCHAR(64) DEFAULT NULL COMMENT '商品图片',
  `createtime` DATETIME NOT NULL COMMENT '生产日期',
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

INSERT  INTO `items`(`id`,`name`,`price`,`detail`,`pic`,`createtime`) VALUES (1,'台式机',3000.0,'该电脑质量非常好！！！！',NULL,'2015-02-03 13:22:53'),(2,'笔记本',6000.0,'笔记本性能好，质量好！！！！！',NULL,'2015-02-09 13:22:57'),(3,'背包',200.0,'名牌背包，容量大质量好！！！！',NULL,'2015-02-06 13:23:02');