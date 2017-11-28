create tablespace MTL01 datafile 'D:\app\mutongli\oradata\mtl01.ora'
	size 500M reuse autoextend on maxsize unlimited
	default storage(
	initial 320k
	next 320k
	minextents 1
	maxextents unlimited
	pctincrease 0
);

create user realmlearn identified by realm123 default tablespace MTL01;
grant connect,resource,dba to realmlearn;

create table users (
  id number(20),
  username varchar2(100),
  password varchar2(100),
  password_salt varchar2(100),
  constraint pk_users primary key(id)
);
comment on table users is '用户表';
comment on column users.id is '用户id';
comment on column users.username is '用户名';
comment on column users.password is '密码';
comment on column users.password_salt is '密码密钥';
create unique index idx_users_username on users(username);

create table user_roles(
  id number(20),
  username varchar2(100),
  role_name varchar2(100),
  constraint pk_user_roles primary key(id)
);
comment on table user_roles is '用户角色表';
comment on column user_roles.username is '用户名';
comment on column user_roles.role_name is '角色名';
create unique index idx_user_roles on user_roles(username, role_name);


create table roles_permissions(
  id number(20),
  role_name varchar(100),
  permission varchar(100),
  constraint pk_roles_permissions primary key(id)
);
comment on table roles_permissions is '角色权限表';
comment on column roles_permissions.id is '权限id';
comment on column roles_permissions.role_name is '角色名';
comment on column roles_permissions.permission is '权限';
create unique index idx_roles_permissions on roles_permissions(role_name, permission);

insert into users(id,username,password)values(seq_users_id.nextval,'zhang','123');