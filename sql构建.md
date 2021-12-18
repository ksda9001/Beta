All of the source code to this product is available under gpl-v3
Copyright© 2021 谈翰文

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>.
#SQL创建  

###创建speed表  
``  
CREATE TABLE `speed` (
`id` int NOT NULL AUTO_INCREMENT,
`customerId` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '乘客号',
`clazzId` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '等级',
`speed` varchar(20) NOT NULL COMMENT '时速',
PRIMARY KEY (`id`,`customerId`,`clazzId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=173 DEFAULT CHARSET=utf8;
``  
---  
###创建customer表  
``  
CREATE TABLE `customer` (
`customerId` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
`customerName` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
`customerSex` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
`customerAge` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '',
`customerBirthday` date DEFAULT NULL,
`customerDept` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
`customerMajor` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
`customerClazzId` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
`customerCellPhone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
`customerpad` varchar(20) DEFAULT '123456',
PRIMARY KEY (`customerId`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
``  
---  
###创建user表  
``
CREATE TABLE `user` (
`name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
`password` varchar(20) DEFAULT NULL,
PRIMARY KEY (`name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
``  
---  
###创建clazz表  

``
CREATE TABLE `clazz` (
`id` int NOT NULL AUTO_INCREMENT,
`clazzId` varchar(10) NOT NULL COMMENT '等级id',
`clazzName` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '等级',
`buyYear` varchar(255) NOT NULL COMMENT '购买日期',
`selectHour` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '时长',
`driver` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '司机',
PRIMARY KEY (`id`,`clazzId`,`clazzName`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;
``