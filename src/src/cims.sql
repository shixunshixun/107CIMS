set names 'gbk';

CREATE DATABASE test;
use test;

CREATE TABLE cims_user (
userId int(8) not null primary key auto_increment,
userName varchar(40) not null,
userPassword varchar(40) not null,
userIsAdmin boolean not null default '0',
unique key (userName)
) DEFAULT CHARSET=gbk ;



CREATE TABLE cims_building (
buildingId int(8) not null primary key auto_increment,
buildingName varchar(40) not null,
buildingDepartment varchar(40) not null,
buildingSimpleName varchar(40),
buildingCompus varchar(40) not null,
buildingFloorNum integer(8) not null,
unique key (buildingName, buildingCompus)
) DEFAULT CHARSET=gbk;

CREATE TABLE cims_cls (
clsId int(8) not null primary key auto_increment,
clsType varchar(40) not null,
clsFloor int(8),
clsBuildingId int(8) not null,
clsSerialNumber varchar(40) not null,
clsClassNum int(8) not null,
clsExamNum int(8),
clsArea int(8),
clsLocation varchar(40),
clsIsAmphi boolean default '0',
clsShape varchar(40), 
clsHasMicrophone boolean default '1', 
clsUsage varchar(40) not null, 
clsIsUsed boolean default '0', 
clsSeatNum int(8) not null, 
clsAvailableSeatNum int(8) not null,
clsMaxCol int(8),
clsMaxRow int(8),
clsVCorridorLocate varchar(40),
clsHCorridorLocate varchar(40),
foreign key (clsBuildingId) references cims_building(buildingId),
unique key (clsSerialNumber, clsBuildingId)
) DEFAULT CHARSET=gbk;


CREATE TABLE cims_partition (
pId int(8) not null primary key auto_increment,
pYear varchar(40) not null,
pTerm varchar(40) not null,
pClsId int(8) not null,
pDepartment varchar(40) not null,
pClassNum int(8) not null,
pExamNum int(8) not null,
pBeginWeek int(8),
pEndWeek int(8),
pBeginLession int(8) not null,
pEndLession int(8) not null,
pWhichDay varchar(40) not null,
pIsUsed boolean default '0',
pBeginDate varchar(40),
pEndDate varchar(40),
foreign key (pClsId) references cims_cls(clsId)
) DEFAULT CHARSET=gbk;

CREATE TABLE cims_seat(
seatId int(8) not null primary key auto_increment,
seatClsId int(8) not null,
seatRow int(8) not null,
seatCol int(8) not null,
seatProperty boolean default '1',
foreign key (seatClsId) references cims_cls(clsId)
) DEFAULT CHARSET=gbk;

CREATE TABLE cims_department(
departmentId varchar(40) not null,
departmentName varchar(40) not null,
unique key (departmentId), 
unique key (departmentName)
) DEFAULT CHARSET=gbk;

CREATE TABLE cims_record(
recordId int(8) not null  primary key auto_increment,
recordTimestamp TIMESTAMP,
recordMessage varchar(255)
)  DEFAULT CHARSET=gbk;

insert into cims_user values('', 'sysu1', 'sysu1', '0');
insert into cims_user values('', 'sysu2', 'sysu2', '');	
insert into cims_user values('', 'cims', 'cims', '0');
insert into cims_user values('', 'cims_admin', 'cims_admin', '1');
insert into cims_user values('', 'admin', 'admin', '1');

insert into cims_building values('', '公共教学楼A栋', '教务处', '公教楼A', '东校区', '5');
insert into cims_building values('', '南实验楼B栋', '教务处', '南实验楼B栋', '东校区', '5');
insert into cims_building values('', '公共教学楼D栋', '医教处', '公教楼D', '南校区', '5');
insert into cims_building values('', '公共教学楼B栋', '医教处', '公教楼B', '珠海校区', '5');
insert into cims_building values('', '第一教学楼', '教务处', '一教', '南校区', '5');
insert into cims_building values('', '第二教学楼', '教务处', '二教', '南校区', '5');

insert into cims_cls values('', '多媒体教室', '1', '1', 'ggjxlad001', '45', '43', '140', '东南', '1', '矩形', '1', '上课', '1', '50', '45', '9', '6', '1,2;5,6', '3,4;5,6'); 
insert into cims_cls values('', '语音室', '2', '1', 'ggjxlad002', '45', '43', '140', '东北', '1', '扇形', '1', '语音', '1', '50', '45', '9', '6', '2,3;5,6', '3,4');
insert into cims_cls values('', '实验室', '3', '2', 'nsyl001', '45', '43', '140', '西南', '0', '矩形', '1', '做实验', '1', '50', '45', '9', '6', '1,2', '3,4'); 
insert into cims_cls values('', '多媒体教室', '2', '3', 'ggjxldd001', '45', '43', '140', '西北', '0', '矩形', '1', '上课', '1', '50', '45', '9', '6', '1,2;2,3', '3,4;4,5'); 
insert into cims_cls values('', '语音室', '1', '5', 'dyjxl001', '45', '43', '140', '西北', '1', '扇形', '1', '语音', '1', '50', '45', '9', '6', '1,2', '3,4');
insert into cims_cls values('', '多媒体教室', '4', '5', 'dejxl001', '45', '43', '140', '西南', '1', '矩形', '1', '上课', '1', '50', '45', '9', '6', '1,2', '3,4'); 

insert into cims_partition values('', '2014-2015', '第二学期', '1', '教务处', '45', '43', '1', '3', '6', '8', '1,2,3', '2', '', '');
insert into cims_partition values('', '2013-2014', '第一学期', '2', '学生会', '45', '43', '', '', '4', '6', '1,2,3,4', '1', '2014-07-01', '2014-07-04');
insert into cims_partition values('', '2011-2012', '第二学期', '3', '教务处', '45', '43', '1', '3', '2', '4', '2,3', '2', '', '');
insert into cims_partition values('', '2013-2014', '第二学期', '4', '学生会', '45', '43', '', '', '4', '6', '4', '1', '2014-05-11', '2014-05-13');

insert into cims_department values('jwc', '教务处');
insert into cims_department values('ruanjianxueyuan', '软件学院');
insert into cims_department values('yjc', '医教处');
insert into cims_department values('xinke', '信息科学技术学院');
insert into cims_department values('xsh', '学生会');