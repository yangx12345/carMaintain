/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2021/2/18 15:24:51                           */
/*==============================================================*/


drop table if exists attendance_record;

drop table if exists department;

drop table if exists redeploy_record;

drop table if exists salary;

drop table if exists train;

drop table if exists user;

/*==============================================================*/
/* Table: attendance_record                                     */
/*==============================================================*/
create table attendance_record
(
   record_id            int(11) not null auto_increment comment '记录id',
   user_id              int(11) not null comment '用户编号',
   real_name            varchar(12) not null comment '真实姓名',
   early_num            int(2) comment '早退次数',
   time                 date comment '时间',
   absenteeism_num      int(2) comment '缺勤天数',
   attendance_num       int(2) comment '出勤天数',
   late_num             int(2) comment '迟到次数',
   evection_num         int(2) comment '出差天数',
   entry_id             int(11) comment '录入人',
   entry_date           date comment '录入日期',
   update_id            int(11) comment '更新人',
   update_date          date comment '更新日期',
   remark               varchar(500) comment '备注',
   primary key (record_id)
);

alter table attendance_record comment '考勤记录表';

/*==============================================================*/
/* Table: department                                            */
/*==============================================================*/
create table department
(
   department_id        int(11) not null auto_increment comment '部门编号',
   department_name      varchar(30) not null comment '部门名称',
   parent_id            int(11) not null comment '父部门编号',
   remark               varchar(500) comment '备注',
   primary key (department_id)
);

alter table department comment '部门表';

/*==============================================================*/
/* Table: redeploy_record                                       */
/*==============================================================*/
create table redeploy_record
(
   redeploy_id          int(11) not null auto_increment comment '调动记录编号',
   redeploy_man_id      int(11) not null comment '调动人编号',
   redeployed_man_id    int(11) not null comment '被调动人编号',
   redeploy_man_name    varchar(30) not null comment '调动人姓名',
   redeployed_man_name  varchar(30) not null comment '被调动人姓名',
   sdepartment_id       int(11) not null comment '原部门编号',
   tdepartment_id       int(11) not null comment '调动部门编号',
   sdepartment_name     varchar(30) not null comment '原部门名称',
   tdepartment_name     varchar(30) not null comment '调动部门名称',
   redeploy_time        date not null,
   remark               varchar(500) comment '备注',
   primary key (redeploy_id)
);

alter table redeploy_record comment '调动记录表';

/*==============================================================*/
/* Table: salary                                                */
/*==============================================================*/
create table salary
(
   salary_id            int(11) not null auto_increment comment '工资编号',
   user_id              int(11) not null comment '用户编号',
   department_id        int(11) not null comment '部门编号',
   real_name            varchar(12) not null comment '真实姓名',
   department_name      varchar(30) not null comment '部门名称',
   base_salary          double comment '基础工资',
   merit_pay            double comment '绩效工资',
   full_time            double comment '全勤奖',
   insurance_pay        double comment '五险一金',
   other_pay            double comment '其他扣除',
   total                double comment '合计',
   primary key (salary_id)
);

alter table salary comment '工资表';

/*==============================================================*/
/* Table: train                                                 */
/*==============================================================*/
create table train
(
   train_id             int not null auto_increment comment '培训id',
   train_name           varchar(30) not null comment '培训人',
   train_content        varchar(500) not null comment '培训内容',
   date                 date not null comment '时间',
   place                varchar(50) not null comment '地点',
   phone                varchar(15) not null comment '联系方式',
   audience             varchar(200),
   remark               varchar(500) comment '备注',
   primary key (train_id)
);

alter table train comment '培训表';

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   user_id              int(11) not null auto_increment comment '用户编号',
   department_id        int(11) not null comment '部门编号',
   user_type            char(1) not null comment '用户类型(0管理员，1HR，2员工)',
   login_name           varchar(30) not null comment '登录名',
   password             varchar(30) not null comment '登陆密码',
   real_name            varchar(12) not null comment '真实姓名',
   sex                  char(1) comment '性别（0男，1女）',
   email                varchar(30) comment '邮箱',
   phone_number         varchar(15) not null comment '手机号',
   id_number            varchar(20) not null comment '身份证号',
   remark               varchar(500) comment '备注',
   primary key (user_id)
);

alter table user comment '用户表';

