set names 'gbk';

CREATE DATABASE test;
use test;

CREATE TABLE cims_user (
userId int(8) not null primary key auto_increment,
userName varchar(40) not null,
userPassword varchar(40) not null,
userIsAdmin boolean not null default '0'
) DEFAULT CHARSET=gbk ;



CREATE TABLE cims_building (
buildingId int(8) not null primary key auto_increment,
buildingName varchar(40) not null,
buildingDepartment varchar(40) not null,
buildingSimpleName varchar(40),
buildingCompus varchar(40) not null,
buildingFloorNum integer(8) not null
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
foreign key (clsBuildingId) references cims_building(buildingId)
) DEFAULT CHARSET=gbk;


CREATE TABLE cims_partition (
pId int(8) not null primary key auto_increment,
pYear varchar(40) not null,
pTerm varchar(40) not null,
pBuildingId int(8) not null,
pClsId int(8) not null,
pDepartment varchar(40) not null,
pClassNum int(8) not null,
pExamNum int(8) not null,
pBeginWeek int(8) not null,
pEndWeek int(8) not null,
pIsUsed boolean default '0', 
foreign key (pBuildingId) references cims_cls(clsBuildingId),
foreign key (pClsId) references cims_cls(clsId)
) DEFAULT CHARSET=gbk;

