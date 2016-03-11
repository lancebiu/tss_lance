CREATE TABLE student (
  uid VARCHAR (10) NOT NULL ,
  password VARCHAR (20) NOT NULL ,
  uname VARCHAR (15) NOT NULL ,
  department VARCHAR (10) NOT NULL ,
  PRIMARY KEY (uid)
);

INSERT INTO student VALUES
("131250114", "lance", "朱方圆", "软件学院"),
("131250115", "lance", "景诗维", "软件学院"),
("131250116", "lance", "王静漪", "软件学院"),
("131250117", "lance", "黄振豪", "软件学院"),
("131250118", "lance", "罗会祥", "软件学院"),
("131250119", "lance", "贺加贝", "软件学院"),
("131250120", "lance", "窦文蓬", "软件学院"),
("131250122", "lance", "卫羿霖", "软件学院"),
("131250123", "lance", "张波", "软件学院"),
("131250124", "lance", "张晨", "软件学院"),
("131250125", "lance", "贺登科", "软件学院"),
("131250126", "lance", "姚怡斌", "软件学院"),
("131250128", "lance", "唐珊珊", "软件学院"),
("131250129", "lance", "梁思宇", "软件学院"),
("131250130", "lance", "丁能熙", "软件学院"),
("131250131", "lance", "陈圣超", "软件学院"),
("131250132", "lance", "刘星宇", "软件学院"),
("131250133", "lance", "朱加宏", "软件学院"),
("131250134", "lance", "王智成", "软件学院"),
("131250135", "lance", "高瑜琦", "软件学院"),
("131250136", "lance", "严青伟", "软件学院"),
("131250137", "lance", "邵振宇", "软件学院"),
("131250138", "lance", "李灏宇", "软件学院"),
("131250139", "lance", "郭慧玲", "软件学院"),
("131250140", "lance", "尹旦", "软件学院"),
("131250141", "lance", "陈鹏", "软件学院"),
("131250142", "lance", "徐陈", "软件学院");

CREATE TABLE teacher (
  tid VARCHAR (10) NOT NULL ,
  password VARCHAR (20) NOT NULL ,
  tname VARCHAR (10) NOT NULL ,
  department VARCHAR (10) NOT NULL ,
  PRIMARY KEY (tid)
);

INSERT INTO teacher VALUES
("th0250001", "lance", "丁二玉", "软件学院"),
("th0250002", "lance", "任桐炜", "软件学院"),
("th0250003", "lance", "汤恩义", "软件学院"),
("th0250004", "lance", "刘钦", "软件学院"),
("th0250005", "lance", "陈振宇", "软件学院"),
("th0250006", "lance", "王浩然", "软件学院"),
("th0250007", "lance", "刘嘉", "软件学院");

CREATE TABLE course (
  cid VARCHAR (10) NOT NULL ,
  cname VARCHAR (30) NOT NULL ,
  credit INT NOT NULL ,
  PRIMARY KEY (cid)
);

INSERT INTO course VALUES
("c001", "Linux程序设计", 3),
("c002", "电子商务", 2),
("c003", "J2EE与中间件", 3),
("c004", "商务智能", 2),
("c005", "软件体系结构", 3),
("c006", "数据结构与算法", 3),
("c007", "Linux程序设计", 3),
("c008", "软件工程与计算 II", 3),
("c009", "软件工程与计算 I", 3),
("c010", "软件构造", 2),
("c011", "软件需求工程", 3);


CREATE TABLE course_schedule (
  csid INT NOT NULL AUTO_INCREMENT,
  cid VARCHAR (10) NOT NULL ,
  tid VARCHAR (10) ,
  term  VARCHAR (15) NOT NULL ,
  PRIMARY KEY (csid)
);

CREATE VIEW complete_course_schedule AS
select cs.*, c.cname, c.credit, t.tname from course_schedule cs, course c, teacher t
  where cs.cid = c.cid
  and cs.tid = t.tid
  order by cs.cid;