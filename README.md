# 数据库管理课程设计
实验平台: Window 10 x86_64 英特尔i7八核处理器

数据库: Postgresql

编程语言: Java

架构：Postgresql数据库+Java调用+图形界面

## 1.需求分析

### 1.1 数据需求描述
(1)学校设置了各专业，在专业下开设班级，每个班级包含若干学生，学生 信息至少需要包含学号、姓名、性别、年龄、生源所在地、已修学分总数等数据 项；另外，需要有地区信息，用于统计某一地区的学生数； 
(2)课程信息表至少需包含课程编号、课程名称、任课教师、开课学期、学 时、考试或考查、学分等数据项，课程根据班级开设。 
(3)教师信息至少需要包含教师编号、姓名、性别、年龄、职称、联系电话
等数据项；
(4)学生成绩至少需要学号，学期，课程名称，成绩，任课老师等数据项；
###1.2 系统功能需求
学生成绩按每学年成绩统计  
学生成绩名次排定  
每门课程平均成绩统计  
学生所学课程及学分统计  
对每个学生输入成绩的时候，自动生成学生的已修学分总数  
学生成绩查询  
教师任课查询  
班级课程开设查询
### 1.3 性能需求
### 1.4 数据字典
* 数据字典的用途：进行详细的数据收集和数据分析所获得的主要结果
* 数据字典的内容
  * 数据项
  * 数据结构
  * 数据流
  * 数据存储
  * 处理过程

例：学生学籍管理子系统的数据字典。
数据项，以“学号”为例
数据项 
学号
含义说明
唯一标识每个学生
别名
学生编号
类型
字符型
长度
## 8
取值范围
00000000至99999999
取值含义
前两位标别该学生所在年级，后六位按顺序编号
与其他数据项的逻辑关系



数据结构，以“学生”为例
“学生”是该系统中的一个核心数据结构：
数据结构
学生
含义说明
是学籍管理子系统的主体数据结构，定义了一个学生的有关信息
**组成**
学号、姓名、性别、年龄、生源所在地、已修学分总数

数据结构
课程
含义说明
是学籍管理子系统的主体数据结构，定义了一个课程的有关信息
组成
课程信息表至少需包含课程编号、课程名称、任课教师、开课学期、开课学时、考核方式(考试或考查)、学分、开设班级

数据结构
教师
含义说明
是学籍管理子系统的主体数据结构，定义了一个教师的有关信息
组成
教师编号、姓名、性别、年龄、职称、联系电话

数据结构
学生成绩
含义说明
是学籍管理子系统的主体数据结构，定义了一个学生的有关信息
组成
学号，学期，课程名称，成绩，任课老师

数据流，“学生成绩按每学年成绩统计”可如下描述：
数据流：学生成绩按每学年成绩统计
说明：学生成绩按每学年成绩统计
数据流来源：成绩
数据流去向：查询
组成：学年，学号，统计成绩
平均流量：1000
高峰期流量：10000
数据流，“学生成绩名次排定”可如下描述：
数据流：学生成绩名次排定
说明：学生成绩名次排定
数据流来源：成绩
数据流去向：查询
组成：课程号，平均成绩
平均流量：1000
高峰期流量：10000

数据流，“学生所学课程及学分统计”可如下描述：
数据流：学生所学课程及学分统计
说明：学生所学课程及学分统计
数据流来源：成绩
数据流去向：查询
组成：学号，统计成绩
平均流量：1000
高峰期流量：10000

数据流，“学生成绩查询”可如下描述：
数据流：学生成绩查询
说明：学生成绩查询
数据流来源：成绩
数据流去向：查询
组成：学号，课程号，统计成绩
平均流量：1000
高峰期流量：10000

数据流，“班级课程开设查询”可如下描述：
数据流：班级课程开设查询
说明：班级课程开设查询
数据流来源：课程
数据流去向：查询
组成：课程号，课程名，班级号
平均流量：1000
高峰期流量：10000

数据流，“教师任课查询”可如下描述：
数据流：教师任课查询
说明：教师任课查询
数据流来源：课程
数据流去向：查询
组成：教师号，课程号，课程名
平均流量：1000
高峰期流量：10000

数据存储，“自动生成学生的已修学分总数”可如下描述：
数据存储：学生个人信息表
说明：记录学生的总学分
流入数据流：学生成绩
流出数据流：学生学分
组成：总学分
数据量：每年3000张
存取方式：随机存取
## 2 概念结构设计
在需求分析的基础上，建立系统的E-R模型，即首先建立局部E-R图，然后合并局部E-R图，形成初步的全局E-R图，最后优化全局E-R图。理解概念结构设计是数据库应用系统设计和实现中的关键步骤，特别掌握冲突的处理方法。


采用合适工具画，如ERWIN，office visio，Power Designer等。

    • 自底向上设计概念结构的步骤 
	第1步：抽象数据并设计局部视图
	第2步：集成局部视图，得到全局概念结构

图 4自底向上设计概念结构的步骤
### 2.1 局部E-R图

### 2.2 全局E-R图


### 2.3 优化后的全局E-R图

## 3 逻辑结构设计
利用E-R模型到关系模式的转换方法，将E-R图转换为关系模式，并对关系模式进行优化，并根据数据字典和第三节的个性化要求，设计数据库中的基本表。

掌握概念结构转换为某个具体DBMS支持的逻辑结构的方法，学会逻辑结构优化与规范化的矛盾折中技巧。
### 3.1 关系模式设计
学生(学号、姓名、性别、年龄、生源所在地、已修学分)
课程(课程编号、课程名称、任课教师、开课学期、学 时、考试或考查、学分、班级)
教师(教师编号、姓名、性别、年龄、职称、联系电话)
学生成绩(学号，学期，课程名称，成绩，任课老师)
### 3.2 数据类型定义
学生(学号 文本、姓名 文本、性别 文本、年龄 数字、生源所在地 文本、已修学分 数字)
课程(课程编号 文本、课程名称 文本、任课教师 文本、开课学期 文本、学时 数字、考试或考查 文本、学分 数字、班级号 文本)
教师(教师编号 文本、姓名 文本、性别 文本、年龄 数字、职称 文本、联系电话 文本)
学生成绩(学号 文本，学期 文本，课程名称 文本，成绩 数字，任课老师编号 文本)

### 3.3 关系模式的优化
每个表中增加外键递归删除和默认值以及非空的约束条件
create table zhangbingyang_students(zby_sno text primary key, zby_sname text not null, zby_ssex text check(zby_ssex='男' or zby_ssex='女'),zby_address text,zby_value smallint check(zby_value >= 0) default 0);
create table zhangbingyang_teachers(zby_tno text primary key, zby_tname text not null, zby_tsex text check(zby_tsex='男' or zby_tsex='女'),zby_tage smallint check(zby_tage > 0), zby_position text, zby_phone text unique);
create table zhangbingyang_courses(zby_cno text , zby_name text, zby_tno text references zhangbingyang_teachers(zby_tno) on delete cascade, zby_term text not null, zby_time smallint check(zby_time >= 0), zby_exam text check(zby_exam = '考试' or zby_exam = '考查'), zby_csno text not null,zby_value smallint check(zby_value > 0), primary key(zny,cno, zby_tno), unique(zby_cno, zby_tno, zby_csno));
create table zhangbingyang_reports(zby_sno text references zhangbingyang_students(zby_sno) on delete cascade, zby_term text ,zby_cno text references zhangbingyang_courses(zby_cno) on delete cascade, zby_score smallint check(zby_score  >= 0), zby_tno text references zhangbingyang_teachers(zby_tno) on delete cascade, zby_zsno text, primary key (zby_sno,zby_cno,zby_term, zby_score),foreign key (zby_cno, zby_tno, zby_csno) references zhangbingyang_courses(zby_cno, zby_tno, zby_csno) on delete cascade);
## 4 物理结构设计

图 5数据库的物理设计

### 4.1 聚簇设计
聚簇索引，实际存储的循序结构与数据存储的物理机构是一致的，所以通常来说物理顺序结构只有一种，那么一个表的聚簇索引也只能有一个，通常默认都是主键，设置了主键，系统默认就为你加上了聚簇索引。
### 4.2 索引设计
学生(学号)
课程(课程编号)
教师(教师编号)
学生成绩(学号，课程名称，任课老师编号)

### 4.3 分区设计
数据分区是一种物理数据库的设计技术，它的目的是为了在特定的SQL操作中减少数据读写的总量以缩减响应时间。分区并不是生成新的数据表，而是将表的数据均衡分摊到不同的硬盘，系统或是不同服务器存储介子中，实际上还是一张表。另外，分区可以做到将表的数据均衡到不同的地方，提高数据检索的效率，降低数据库的频繁IO压力值，分区的优点如下：
1. 相对于单个文件系统或是硬盘，分区可以存储更多的数据；
2. 数据管理比较方便，比如要清理或废弃某年的数据，就可以直接删除该日期的分区数据即可；
3. 精准定位分区查询数据，不需要全表扫描查询，大大提高数据检索效率；
4. 可跨多个分区磁盘查询，来提高查询的吞吐量；
5. 在涉及聚合函数查询时，可以很容易进行数据的合并；

## 5 数据库实施

### 5.1 基本表建立
   
### 5.2 索引的建立
   
### 5.3 触发器建立
create trigger autoupdate_value after insert on zhangbingyang_reports FOR EACH ROW EXECUTE PROCEDURE update_value();

### 5.4 存储过程建立
create or replace function update_value() returns trigger as $example_table$
	begin
		update zhangbingyang_students set zby_value = zby_value + (select zby_value from zhangbingyang_courses where zby_cno = new.zby_cno) 
		where zby_sno = new.zby_sno;
		raise notice 'done %', new.zby_sno;
		return null;
	end; 
$example_table$ LANGUAGE plpgsql;

## 6 应用系统开发与试运行

### 6.1 开发平台和开发环境介绍
操作系统环境:Windows 10 x86_64专业版
开发语言:Java
开发IDE: IntelliJ IDEA Community Edition 2020.1.1 x64
### 6.2 系统功能图
系统存在命令行和图形界面两种运行方式。命令行中未增加参数则调用图形界面，反之则为终端输出。
#### 6.2.1 图形界面和逻辑分离
图形界面类Design,由图形界面函数实现图形界面的布局，主类Psqlbase继承图形界面类，构造函数中实现按键功能。二者分离有效增加程序模块化，便于将来维护与和运行。
#### 6.2.2 命令行和图形界面共存
为了增加运行效率，该程序增加了命令行操作方法，实现命令行和图形界面共用。图形界面主要容器borderlayout布局，占据north和center部分，north的panel使用流布局，方便图形界面伸缩式保持所有部件可视化。
学生成绩按每学年成绩统计
终端输出：
 
图形界面：





学生成绩名次排定 
终端输出：
 
图形界面：



 每门课程平均成绩统计 
终端输出：
 
图形界面：











 学生所学课程及学分统计 
终端输出：
 
图形界面：

 对每个学生输入成绩的时候，自动生成学生的已修学分总数 
 学生成绩查询
 
图形界面：














 教师任课查询
终端输出：
 
图形界面：














 班级课程开设查询
 图形界面：

## 7 实验总结

### 7.1 遇到的问题和解决的办法
    1. Java中存在乱码
解决方法：
(1)替换成英文字符
(2)修改java的配置，使用utf-8编码
(3)gradle build.gradle中增加编译中utf-8的配置(花费将近5天时间排查)
### 2.sql语句查询的结果存在空值会报错
增加表的约束，拒绝空值，同时增加默认值
### 7.2 系统设计的不足 
Java字符乱码未得到完美的解决，终端输出中还是存在小部分乱码