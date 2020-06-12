drop table  if exists `chapter`;
create table `chapter` (
    `id` char(8) not null comment 'ID',
    `coutse_id` char(8) comment '课程ID',
    `name` varchar(50) comment '课程名称',
    primary key (`id`)
) engine=innodb default charset=utf8mb4 comment='大章';