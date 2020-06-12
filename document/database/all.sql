drop table  if exists `chapter`;
create table `chapter` (
    `id` char(8) not null comment 'ID',
    `coutse_id` char(8) comment '课程ID',
    `name` varchar(50) comment '课程名称',
    primary key (`id`)
) engine=innodb default charset=utf8mb4 comment='大章';

insert into `chapter` (id,coutse_id,name) values ('00000000', '00000000','测试大章一');
insert into `chapter` (id,coutse_id,name) values ('00000001 ','00000000','测试大章二');