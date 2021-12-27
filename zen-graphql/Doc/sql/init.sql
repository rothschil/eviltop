SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for author
-- ----------------------------
DROP TABLE IF EXISTS `author`;
CREATE TABLE `author` (
                          `id` varchar(64) NOT NULL,
                          `first_name` varchar(255) NOT NULL,
                          `last_name` varchar(255) NOT NULL,
                          `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                          `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of author
-- ----------------------------
INSERT INTO `author` VALUES ('author-1', 'Joanne', 'Rowling', '2019-05-22 17:03:59', '2019-05-22 17:04:30');
INSERT INTO `author` VALUES ('author-2', 'Herman', 'Melville', '2019-05-22 17:03:59', '2019-05-22 17:04:30');
INSERT INTO `author` VALUES ('author-3', 'Anne', 'Rice', '2019-05-22 17:03:59', '2019-05-22 17:04:30');
INSERT INTO `author` VALUES ('author-5', '莫言', '黄花', '2019-05-22 17:03:59', '2019-05-22 17:04:30');

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
                        `id` varchar(255) NOT NULL,
                        `name` varchar(255) NOT NULL,
                        `page_count` int(32) NOT NULL,
                        `author_id` varchar(64) NOT NULL,
                        `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                        `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='books';

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('book-1', '哈利波特与死亡圣器', '101', 'author-1', '2019-05-22 17:05:33', '2019-05-22 17:05:33');
INSERT INTO `book` VALUES ('book-3', '人生', '500', 'author-3', '2019-05-22 17:05:33', '2019-05-22 17:05:33');
INSERT INTO `book` VALUES ('book-4', '平凡的世界', '1000', 'author-4', '2019-05-22 17:05:33', '2019-05-22 17:05:33');
INSERT INTO `book` VALUES ('book-5', '草原', '500', 'author-5', '2019-05-22 17:05:33', '2019-05-22 17:05:33');
INSERT INTO `book` VALUES ('book-6', '原野', '576', 'author-6', '2019-05-22 17:05:33', '2019-05-22 17:05:33');
INSERT INTO `book` VALUES ('book-7', '原来如初', '666', 'author-7', '2019-05-22 17:05:33', '2019-05-22 17:05:33');
INSERT INTO `book` VALUES ('book-8', '穆斯林的葬礼', '999', 'author-8', '2019-05-22 17:05:33', '2019-05-22 17:05:33');
INSERT INTO `book` VALUES ('book-9', '草根成长记（3）', '789', 'author-9', '2019-05-22 17:09:17', '2019-05-22 17:13:17');