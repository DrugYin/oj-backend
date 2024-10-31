/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80401 (8.4.1)
 Source Host           : localhost:3306
 Source Schema         : x_oj

 Target Server Type    : MySQL
 Target Server Version : 80401 (8.4.1)
 File Encoding         : 65001

 Date: 31/10/2024 14:57:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_carousel
-- ----------------------------
DROP TABLE IF EXISTS `sys_carousel`;
CREATE TABLE `sys_carousel`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '图片id',
  `imgUrl` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '图片地址',
  `gmt_create` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `title` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '标题',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_carousel
-- ----------------------------
INSERT INTO `sys_carousel` VALUES (1, 'https://fuss10.elemecdn.com/a/3f/3302e58f9a181d2509f3dc0fa68b0jpeg.jpeg', '2024-10-10 13:28:27', '2024-10-10 13:28:28', '无');
INSERT INTO `sys_carousel` VALUES (2, 'https://fuss10.elemecdn.com/1/34/19aa98b1fcb2781c4fba33d850549jpeg.jpeg', '2024-10-10 13:28:41', '2024-10-10 13:28:42', '无');
INSERT INTO `sys_carousel` VALUES (3, 'https://fuss10.elemecdn.com/0/6f/e35ff375812e6b0020b6b4e8f9583jpeg.jpeg', '2024-10-10 13:28:56', '2024-10-10 13:28:57', '无');
INSERT INTO `sys_carousel` VALUES (4, 'https://fuss10.elemecdn.com/9/bb/e27858e973f5d7d3904835f46abbdjpeg.jpeg', '2024-10-10 13:29:07', '2024-10-10 13:29:08', '无');
INSERT INTO `sys_carousel` VALUES (11, '\\api/image/carousel/ce9f5816-1955-44ac-b158-dd34e97c74062024-10-30.png', '2024-10-21 14:56:44', '2024-10-30 14:25:15', '111');
INSERT INTO `sys_carousel` VALUES (16, '\\api/image/carousel/ee1063f0-3ceb-4507-8c58-14f11450a6142024-10-21.png', '2024-10-21 16:27:37', '2024-10-21 18:41:49', 'mc');

-- ----------------------------
-- Table structure for sys_language
-- ----------------------------
DROP TABLE IF EXISTS `sys_language`;
CREATE TABLE `sys_language`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '语言id',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '语言',
  `submitId` int NULL DEFAULT NULL COMMENT '提交id',
  `enable` tinyint(1) NULL DEFAULT NULL COMMENT '是否可选',
  `gmt_create` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_language
-- ----------------------------
INSERT INTO `sys_language` VALUES (1, 'C++', 54, 1, '2024-10-10 19:53:24', '2024-10-10 19:53:25');
INSERT INTO `sys_language` VALUES (2, 'Java', 62, 1, '2024-10-10 19:53:32', '2024-10-10 19:53:31');
INSERT INTO `sys_language` VALUES (3, 'C', 50, 1, '2024-10-10 19:53:53', '2024-10-10 19:53:56');
INSERT INTO `sys_language` VALUES (5, 'Python3', 71, 1, '2024-10-10 19:54:23', '2024-10-10 19:54:24');
INSERT INTO `sys_language` VALUES (7, 'Python2', 70, 0, '2024-10-23 13:21:18', '2024-10-23 13:21:18');

-- ----------------------------
-- Table structure for sys_notice
-- ----------------------------
DROP TABLE IF EXISTS `sys_notice`;
CREATE TABLE `sys_notice`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '公告id',
  `title` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '标题',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '内容',
  `gmt_create` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_notice
-- ----------------------------
INSERT INTO `sys_notice` VALUES (1, 'aaaa', 'aaaaaa\naaaaaa\naaaaaa\naaaaaa', '2024-07-21 19:20:37', '2024-10-22 18:38:23');
INSERT INTO `sys_notice` VALUES (6, 'test', '111111111111111\n11111111111111\n1\n1111111111\n11111\n111111111\n111111111\n11111\n1111111111\n111111\n111111111\n111111', '2024-10-22 19:04:07', '2024-10-22 19:04:07');

-- ----------------------------
-- Table structure for sys_problem
-- ----------------------------
DROP TABLE IF EXISTS `sys_problem`;
CREATE TABLE `sys_problem`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '题目id',
  `title` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NULL DEFAULT NULL COMMENT '题目名称',
  `author` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NULL DEFAULT NULL COMMENT '作者',
  `custom_id` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NULL DEFAULT NULL COMMENT '自定义编号',
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NULL COMMENT '题目描述',
  `input_description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NULL COMMENT '输入描述',
  `output_description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NULL COMMENT '输出描述',
  `test_sample` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NULL COMMENT '测试数据',
  `limit_time` int NULL DEFAULT 1000 COMMENT '限制时间(ms)',
  `limit_memory` int NULL DEFAULT 64 COMMENT '限制内存(MB)',
  `submit_count` bigint NULL DEFAULT 0 COMMENT '提交数量',
  `accept_count` bigint NULL DEFAULT 0 COMMENT '通过数量',
  `visible` int NOT NULL DEFAULT 1 COMMENT '是否可见',
  `gmt_create` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_520_ci COMMENT = '题目信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_problem
-- ----------------------------
INSERT INTO `sys_problem` VALUES (1, 'hello world', 'none', 'YY100001', '输出“hello world”', '无', 'hello world', '[\n  {\n    \"id\": 1,\n    \"input\": \"\",\n    \"output\": \"hello world\"\n  }\n]', 1000, 32, 35, 22, 1, '2024-10-30 19:46:54', '2024-10-28 18:40:32');
INSERT INTO `sys_problem` VALUES (2, 'a+b', '1', 'YY100002', '给你两个整数a和b，请输入他们得和', '两个正整数a和b', 'a+b的和', '[\n  {\n    \"id\": 1,\n    \"input\": \"1 1\",\n    \"output\": \"2\"\n  },\n  {\n    \"id\": 2,\n    \"input\": \"10 5\",\n    \"output\": \"15\"\n  }\n]', 1000, 32, 40, 33, 1, '2024-10-30 19:23:20', '2024-10-28 18:40:02');
INSERT INTO `sys_problem` VALUES (6, 'a*b', 'wu', 'YY100003', '  求两个整数a和b的乘积', '两个正整数a和b', '输入它们的乘积', '[{\"id\":1,\"input\":\"1 2\",\"output\":\"2\"},{\"id\":2,\"input\":\"2 4\",\"output\":\"8\"}]', 1000, 32, 10, 9, 1, '2024-10-31 11:10:16', '2024-10-26 16:54:32');

-- ----------------------------
-- Table structure for sys_problem_tag
-- ----------------------------
DROP TABLE IF EXISTS `sys_problem_tag`;
CREATE TABLE `sys_problem_tag`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '题目id',
  `problem_id` bigint NULL DEFAULT NULL,
  `tag_id` bigint NULL DEFAULT NULL COMMENT '标签',
  `gmt_create` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_problem_tag
-- ----------------------------
INSERT INTO `sys_problem_tag` VALUES (10, 1, 1, '2024-10-27 19:35:34', '2024-10-27 19:35:34');
INSERT INTO `sys_problem_tag` VALUES (11, 1, 5, '2024-10-27 19:35:34', '2024-10-27 19:35:34');
INSERT INTO `sys_problem_tag` VALUES (16, 2, 5, '2024-10-27 19:37:10', '2024-10-27 19:37:10');
INSERT INTO `sys_problem_tag` VALUES (17, 2, 6, '2024-10-27 19:37:10', '2024-10-27 19:37:10');
INSERT INTO `sys_problem_tag` VALUES (22, 6, 5, '2024-10-28 18:41:07', '2024-10-28 18:41:07');
INSERT INTO `sys_problem_tag` VALUES (23, 6, 6, '2024-10-28 18:41:07', '2024-10-28 18:41:07');
INSERT INTO `sys_problem_tag` VALUES (24, 6, 1, '2024-10-28 18:41:07', '2024-10-28 18:41:07');

-- ----------------------------
-- Table structure for sys_problem_test
-- ----------------------------
DROP TABLE IF EXISTS `sys_problem_test`;
CREATE TABLE `sys_problem_test`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '题目id',
  `content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '内容',
  `gmt_create` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_problem_test
-- ----------------------------
INSERT INTO `sys_problem_test` VALUES (1, '[\n  {\n    \"id\": 1,\n    \"input\": \"\",\n    \"output\": \"hello world\"\n  }\n]', '2024-08-01 15:28:02', '2024-10-28 18:40:32');
INSERT INTO `sys_problem_test` VALUES (2, '[\n  {\n    \"id\": 1,\n    \"input\": \"1 1\",\n    \"output\": \"2\"\n  },\n  {\n    \"id\": 2,\n    \"input\": \"1 1\",\n    \"output\": \"2\"\n  },\n  {\n    \"id\": 3,\n    \"input\": \"7 8\",\n    \"output\": \"15\"\n  },\n  {\n    \"id\": 4,\n    \"input\": \"1 1\",\n    \"output\": \"2\"\n  },\n  {\n    \"id\": 5,\n    \"input\": \"13 14\",\n    \"output\": \"27\"\n  },\n  {\n    \"id\": 6,\n    \"input\": \"1 1\",\n    \"output\": \"2\"\n  },\n  {\n    \"id\": 7,\n    \"input\": \"5 6\",\n    \"output\": \"11\"\n  },\n  {\n    \"id\": 8,\n    \"input\": \"7 2\",\n    \"output\": \"9\"\n  },\n  {\n    \"id\": 9,\n    \"input\": \"1 9\",\n    \"output\": \"10\"\n  }\n]', '2024-08-01 15:26:55', '2024-10-28 18:40:02');
INSERT INTO `sys_problem_test` VALUES (6, '[{\"id\":1,\"input\":\"10 10\",\"output\":\"100\"},{\"id\":2,\"input\":\"50 2\",\"output\":\"100\"},{\"id\":3,\"input\":\"6 4\",\"output\":\"24\"},{\"id\":4,\"input\":\"3 8 \",\"output\":\"24\"},{\"id\":5,\"input\":\"5 5\",\"output\":\"25\"},{\"id\":6,\"input\":\"6 6\",\"output\":\"36\"},{\"id\":7,\"input\":\"7 7\",\"output\":\"49\"},{\"id\":8,\"input\":\"4 4\",\"output\":\"16\"},{\"id\":9,\"input\":\"9 9\",\"output\":\"81\"},{\"id\":10,\"input\":\"100 100\",\"output\":\"10000\"},{\"id\":11,\"input\":\"9 9\",\"output\":\"81\"},{\"id\":12,\"input\":\"1 1\",\"output\":\"1\"},{\"id\":13,\"input\":\"1 2\",\"output\":\"2\"},{\"id\":14,\"input\":\"3 3 \",\"output\":\"9\"},{\"id\":15,\"input\":\"5 5\",\"output\":\"25\"},{\"id\":16,\"input\":\"3 5\",\"output\":\"15\"},{\"id\":17,\"input\":\"3 8\",\"output\":\"24\"},{\"id\":18,\"input\":\"3 9\",\"output\":\"27\"},{\"id\":19,\"input\":\"500 5\",\"output\":\"2500\"}]', '2024-08-01 16:54:41', '2024-09-10 16:31:40');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色名称',
  `code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '角色编码',
  `state` int NULL DEFAULT NULL COMMENT '是否启用',
  `gmt_create` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '管理员', 'admin', 1, '2024-10-11 14:38:35', '2024-10-29 18:35:20');
INSERT INTO `sys_role` VALUES (2, '测试角色', 'testRole', 1, '2024-10-17 19:23:27', '2024-10-30 13:49:55');

-- ----------------------------
-- Table structure for sys_submission
-- ----------------------------
DROP TABLE IF EXISTS `sys_submission`;
CREATE TABLE `sys_submission`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '测评id',
  `problem_id` bigint NOT NULL COMMENT '题目id',
  `user_id` bigint NOT NULL COMMENT '用户id',
  `code` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NULL COMMENT '提交的代码',
  `submit_time` date NULL DEFAULT NULL COMMENT '提交时间',
  `run_time` int NOT NULL DEFAULT 0 COMMENT '运行时间(ms)',
  `run_memory` int NOT NULL DEFAULT 0 COMMENT '运行内存(MB)',
  `input` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NULL COMMENT '测试输入数据',
  `output` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NULL COMMENT '测试输出数据',
  `status` tinyint NULL DEFAULT 0 COMMENT '测评结果(0: 等待测评, 1: 测评中, 100:答案正确, 101: 答案错误)',
  `gmt_create` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `case_number` int NULL DEFAULT 0 COMMENT '测试样例数量',
  `ac_number` int NULL DEFAULT 0 COMMENT '通过样例数量',
  `language_id` int NOT NULL DEFAULT 54 COMMENT '代码语言',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 130 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_520_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_submission
-- ----------------------------
INSERT INTO `sys_submission` VALUES (106, 1, 7, '#include <bits/stdc++.h>\r\nusing namespace std;\r\n\r\nint main() {\r\n  cout << \"hello world\" << endl;\r\n}', '2024-10-09', 8, 1732, NULL, '', 100, '2024-10-09 18:18:55', '2024-10-09 18:18:55', 1, 1, 54);
INSERT INTO `sys_submission` VALUES (107, 1, 9, '#include <bits/stdc++.h>\r\nusing namespace std;\r\n\r\nint main() {\r\n  cout << \"hello world11\" << endl;\r\n}', '2024-10-09', 8, 1556, NULL, 'hello world11\n', 101, '2024-10-09 18:20:53', '2024-10-09 18:20:53', 1, 0, 54);
INSERT INTO `sys_submission` VALUES (108, 1, 7, '#include <bits/stdc++.h>\r\nusing namespace std;\r\n\r\nint main() {\r\n  cout << \"hello world\" << endl;\r\n}', '2024-10-09', 8, 1592, NULL, '', 100, '2024-10-09 18:23:15', '2024-10-09 18:23:15', 1, 1, 54);
INSERT INTO `sys_submission` VALUES (109, 1, 7, '#include <bits/stdc++.h>\r\nusing namespace std;\r\n\r\nint main() {\r\n  cout << \"hello world11\" << endl;\r\n}', '2024-10-09', 8, 1524, NULL, 'hello world11\n', 101, '2024-10-09 18:23:28', '2024-10-09 18:23:28', 1, 0, 54);
INSERT INTO `sys_submission` VALUES (112, 1, 7, '#include <bits/stdc++.h>\r\nusing namespace std;\r\n\r\nint main() {\r\n  cout << \"hello world\" << endl;\r\n}', '2024-10-09', 5, 1540, NULL, '', 100, '2024-10-09 18:27:19', '2024-10-09 18:27:19', 1, 1, 54);
INSERT INTO `sys_submission` VALUES (113, 1, 9, '#include <bits/stdc++.h>\r\nusing namespace std;\r\n\r\nint main() {\r\n  cout << \"hello world11\" << endl;\r\n}', '2024-10-09', 6, 3572, NULL, 'hello world11\n', 101, '2024-10-09 18:27:51', '2024-10-09 18:27:51', 1, 0, 54);
INSERT INTO `sys_submission` VALUES (114, 1, 7, '#include <bits/stdc++.h>\r\nusing namespace std;\r\n\r\nint main() {\r\n  cout << \"hello world\" << endl;\r\n}', '2024-10-09', 7, 1464, NULL, '', 100, '2024-10-09 18:33:56', '2024-10-09 18:33:56', 1, 1, 54);
INSERT INTO `sys_submission` VALUES (115, 1, 9, '#include <bits/stdc++.h>\r\nusing namespace std;\r\n\r\nint main() {\r\n  cout << \"hello world111\" << endl;\r\n}', '2024-10-09', 6, 1392, NULL, 'hello world111\n', 101, '2024-10-09 18:34:12', '2024-10-09 18:34:12', 1, 0, 54);
INSERT INTO `sys_submission` VALUES (116, 1, 7, '#include <bits/stdc++.h>\r\nusing namespace std;\r\n\r\nint main() {\r\n  cout << \"hello world\" << endl;\r\n}', '2024-10-09', 7, 1464, NULL, '', 100, '2024-10-09 18:35:03', '2024-10-09 18:35:03', 1, 1, 54);
INSERT INTO `sys_submission` VALUES (117, 1, 7, '#include <bits/stdc++.h>\r\nusing namespace std;\r\n\r\nint main() {\r\n  cout << \"hello world111\" << endl;\r\n}', '2024-10-09', 6, 1524, NULL, 'hello world111\n', 101, '2024-10-09 18:37:21', '2024-10-09 18:37:21', 1, 0, 54);
INSERT INTO `sys_submission` VALUES (118, 1, 7, '#include <bits/stdc++.h>\r\nusing namespace std;\r\n\r\nint main() {\r\n  while (true) {\r\n    \r\n  }\r\n  cout << \"hello world111\" << endl;\r\n}', '2024-10-09', 1082, 1500, NULL, NULL, 102, '2024-10-09 19:26:35', '2024-10-09 19:26:35', 1, 0, 54);
INSERT INTO `sys_submission` VALUES (119, 2, 7, '#include <bits/stdc++.h>\r\nusing namespace std;\r\n\r\nint main() {\r\n  int a, b;\r\n  cout << a + b << endl;\r\n}', '2024-10-09', 7, 15644, NULL, '0\n', 101, '2024-10-09 20:05:54', '2024-10-09 20:05:54', 8, 0, 54);
INSERT INTO `sys_submission` VALUES (120, 2, 7, '#include <bits/stdc++.h>\r\nusing namespace std;\r\n\r\nint main() {\r\n  int a, b;\r\n  cout << a + b << endl;\r\n}', '2024-10-10', 6, 9808, NULL, '0\n', 101, '2024-10-10 13:14:30', '2024-10-10 13:14:30', 8, 0, 54);
INSERT INTO `sys_submission` VALUES (121, 2, 7, '#include <bits/stdc++.h>\r\nusing namespace std;\r\n\r\nint main() {\r\n  int a, b;\r\n  cin >> a >> b;\r\n  cout << a + b << endl;\r\n}', '2024-10-10', 7, 1442, NULL, '', 100, '2024-10-10 13:15:45', '2024-10-10 13:15:45', 8, 8, 54);
INSERT INTO `sys_submission` VALUES (122, 6, 9, '#include <bits/stdc++.h>\r\nusing namespace std;\r\n\r\nint main() {\r\n  int a, b;\r\n  cin >> a >> b;\r\n  cout << a * b << endl;\r\n}', '2024-10-10', 6, 1435, NULL, '', 100, '2024-10-10 13:16:15', '2024-10-10 13:16:15', 19, 19, 54);
INSERT INTO `sys_submission` VALUES (123, 1, 7, '#include <bits/stdc++.h>\r\nusing namespace std;\r\n\r\nint main() {\r\n  while (true) {\r\n    \r\n  }\r\n  cout << \"hello world111\" << endl;\r\n}', '2024-10-10', 0, 0, NULL, NULL, -1, '2024-10-10 20:11:28', '2024-10-10 20:11:28', 1, 0, 62);
INSERT INTO `sys_submission` VALUES (124, 1, 7, '#include <bits/stdc++.h>\r\nusing namespace std;\r\n\r\nint main() {\r\n  cout << \"hello world\" << endl;\r\n}', '2024-10-30', 8, 1600, NULL, '', 100, '2024-10-30 10:37:34', '2024-10-11 10:37:34', 1, 1, 54);
INSERT INTO `sys_submission` VALUES (125, 1, 7, '#include <bits/stdc++.h>\r\nusing namespace std;\r\n\r\nint main() {\r\n  cout << \"hello world\" << endl;\r\n}', '2024-10-30', 3, 864, NULL, '', 100, '2024-10-30 19:22:04', '2024-10-30 19:22:04', 1, 1, 54);
INSERT INTO `sys_submission` VALUES (126, 2, 9, '#include <bits/stdc++.h>\r\nusing namespace std;\r\n\r\nint main(){\r\n  int a, b;\r\n  cin >> a >> b;\r\n  cout << a + b << endl;\r\n}', '2024-10-30', 3, 977, NULL, '', 100, '2024-10-30 19:23:15', '2024-10-30 19:23:15', 9, 9, 54);
INSERT INTO `sys_submission` VALUES (127, 6, 9, '#include <bits/stdc++.h>\r\nusing namespace std;\r\n\r\nint main() {\r\n  int a, b;\r\n  cin >> a >> b;\r\n  cout << a * b << endl;\r\n}', '2024-10-30', 4, 973, NULL, '', 100, '2024-10-30 19:45:33', '2024-10-30 19:45:33', 19, 19, 54);
INSERT INTO `sys_submission` VALUES (128, 1, 9, '#include <bits/stdc++.h>\r\nusing namespace std;\r\n\r\nint main() {\r\n  cout << \"hello world111\" << endl;\r\n}', '2024-10-30', 3, 1156, NULL, 'hello world111\n', 101, '2024-10-30 19:46:50', '2024-10-30 19:46:50', 1, 0, 54);
INSERT INTO `sys_submission` VALUES (129, 6, 8, '#include <bits/stdc++.h>\r\nusing namespace std;\r\n\r\nint main() {\r\n  int a, b;\r\n  cin >> a >> b;\r\n  cout << a * b << endl;\r\n}', '2024-10-31', 3, 968, NULL, '', 100, '2024-10-31 11:10:10', '2024-10-31 11:10:10', 19, 19, 54);

-- ----------------------------
-- Table structure for sys_tags
-- ----------------------------
DROP TABLE IF EXISTS `sys_tags`;
CREATE TABLE `sys_tags`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '标签id',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '标签名字',
  `color` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '标签颜色',
  `gmt_create` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_tags
-- ----------------------------
INSERT INTO `sys_tags` VALUES (1, '输入输出', 'rgba(114, 200, 144, 1)', '2024-10-10 18:59:03', '2024-10-30 14:28:18');
INSERT INTO `sys_tags` VALUES (5, '测试', 'rgba(112, 224, 221, 1)', '2024-10-24 13:26:28', '2024-10-28 19:29:34');
INSERT INTO `sys_tags` VALUES (6, '运算', 'rgba(252, 110, 110, 1)', '2024-10-27 19:37:04', '2024-10-27 19:37:04');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NULL DEFAULT NULL COMMENT '用户账号',
  `password` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NULL DEFAULT NULL COMMENT '密码',
  `avatar` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NULL COMMENT '头像',
  `submit_count` int NULL DEFAULT 0 COMMENT '提交次数',
  `accept_count` int NULL DEFAULT 0 COMMENT '通过次数',
  `gmt_create` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_520_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (7, 'a', '25d55ad283aa400af464c76d713c07ad', 'image/avatar/微信图片_20240521142337.jpg', 21, 12, '2024-10-30 11:03:45', '2024-10-30 13:00:47');
INSERT INTO `sys_user` VALUES (8, 'b', '25d55ad283aa400af464c76d713c07ad', 'image/avatar/8b080d787-aa5b-4f98-9307-3649bb24e883.jpg', 2, 2, '2024-10-30 11:03:46', '2024-10-30 11:30:24');
INSERT INTO `sys_user` VALUES (9, 'admin', '0192023a7bbd73250516f069df18b500', 'image/avatar/小羊肖恩.png', 3, 2, '2024-10-30 11:03:47', '2024-10-30 11:03:50');

-- ----------------------------
-- Table structure for sys_user_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_info`;
CREATE TABLE `sys_user_info`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `submit_problem` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NULL COMMENT '提交过的题目',
  `signature` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NULL COMMENT '用户个性签名',
  `biography` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NULL COMMENT '个人简介',
  `email` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NULL DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NULL DEFAULT NULL COMMENT '手机号',
  `user_name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_520_ci NULL DEFAULT NULL COMMENT '用户名',
  `birthday` date NULL DEFAULT NULL COMMENT '生日',
  `gmt_create` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_520_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_info
-- ----------------------------
INSERT INTO `sys_user_info` VALUES (7, '{\"0\":\"true\",\"1\":1,\"2\":1,\"6\":1}', 'aaaaaa', NULL, NULL, '00000000000', '测试账号A', '2000-01-01', NULL, '2024-10-31 10:35:53');
INSERT INTO `sys_user_info` VALUES (8, '{\"0\":\"true\",\"1\":1,\"6\":1}', NULL, NULL, NULL, '00000000000', '测试账号B', '2000-01-01', NULL, NULL);
INSERT INTO `sys_user_info` VALUES (9, '{\"0\":\"true\",\"1\":0,\"2\":1,\"6\":1}', NULL, NULL, NULL, '00000000000', '管理员账号', '2000-01-01', NULL, NULL);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` bigint NOT NULL COMMENT '用户id',
  `role_id` bigint NOT NULL COMMENT '角色id',
  `gmt_create` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, 7, 1, '2024-10-11 14:38:56', '2024-10-11 14:38:56');
INSERT INTO `sys_user_role` VALUES (2, 9, 1, '2024-10-17 19:13:18', '2024-10-17 19:13:19');
INSERT INTO `sys_user_role` VALUES (3, 9, 2, '2024-10-30 11:32:24', '2024-10-30 11:32:24');
INSERT INTO `sys_user_role` VALUES (5, 8, 2, '2024-10-30 13:24:47', '2024-10-30 13:24:47');

SET FOREIGN_KEY_CHECKS = 1;
