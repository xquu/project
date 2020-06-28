drop table  if exists `chapter`;
create table `chapter` (
    `id` char(8) not null comment 'ID',
    `course_id` char(8) comment '课程ID',
    `name` varchar(50) comment '课程名称',
    primary key (`id`)
) engine=innodb default charset=utf8mb4 comment='大章';

insert into `chapter` (id,course_id,name) values ('00000000', '00000000','测试大章0');
insert into `chapter` (id,course_id,name) values ('00000001 ','00000001','测试大章1');
insert into `chapter` (id,course_id,name) values ('00000002', '00000002','测试大章2');
insert into `chapter` (id,course_id,name) values ('00000003 ','00000003','测试大章3');
insert into `chapter` (id,course_id,name) values ('00000004', '00000004','测试大章4');
insert into `chapter` (id,course_id,name) values ('00000005 ','00000005','测试大章5');
insert into `chapter` (id,course_id,name) values ('00000006', '00000006','测试大章6');
insert into `chapter` (id,course_id,name) values ('00000007 ','00000007','测试大章7');