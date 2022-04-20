-- DCL (계정 생성, 권한부여, 권한박탈, 계정삭제)
-- DDL (제약조건, 시퀀스 없음)
-- DML (outer join, AND = &&, OR = || 연결연산자 없음, 일부단일행함수) 
-- java에서 쓸 데이터 넣고 연습해 보기

show databases; -- databases 테이블 보기
-- DCL(계정 생성, 권한 부여, 권한 박탈, 계정 제거) 
create user user01 identified by 'password'; -- 계정 생성 
grant all privileges on *.* to user01; -- 모든 권한 부여
revoke all on *.* from user01; -- 권한 박탈
drop user user01;
 
-- 데이터 베이스로 들어감 --데이터 베이스 안에 들어가서 만들어야함 
create database kimdb; -- 새로운 kimdb 데이터베이스 생성
use kimdb; -- kimdb 데이터베이스로 들어감 
select database(); -- 현재 접속돼 있는 데이터베이스 
use world; -- world 데이터베이스로 들엉감
show tables; -- 오라클에서의 select * from tab 과 같다;


-- DDL( 테이블 생성, 제약조건, 시퀀스 없음) 
CREATE TABLE emp (
    empno NUMERIC(4) PRIMARY KEY,
    ename VARCHAR(20) NOT NULL,
    nickname VARCHAR(20) UNIQUE,
    sal NUMERIC(7 , 2 ) CHECK (sal > 0),
    hirefate DATETIME DEFAULT now(),
    comm NUMERIC(7 , 2 ) DEFAULT 0
);
select * from emp;
drop table if exists emp;

-- Major(mCode(시퀀스 같은 숫차번호) : PK, mName, mOffice)
-- Student (sNo : PK, sName, mCode0
create table major(
	mCode int primary key auto_increment, -- uto_incrementine 일경우 int 
    mName varchar(20),
    mOffice varchar(50)
    );
 create table student(
	sNo int primary key,
    sName varchar(20),
    mcode int references major(mCode)
 );
 
 insert into major(mName, mOffice) values ('컴공', '402호');
 insert into major(mName, mOffice) values ('경영', '502호');
 insert into major(mName, mOffice) values ('경제', '401호');

select * from major;

insert into student values (1111,'홍', 1);
insert into student values (2222,'이', 2);
insert into student values (3333,'사', 3);
insert into student values (4444,'박', 4);  
select * from student;

drop table if exists student;
drop table if exists major;

create table major(
	mCode int auto_increment,
    mName varchar(30) not null,
    mOffice varchar(30),
    primary key(mCode));
    
create table student(
	sNo int,
    sName varchar(30),
    mCode int,
    primary key(sNo),
    foreign key(mCode) references major(mCode)
    );

-- 학번, 이름, 학과코드, 학과명, 사무실
select sNo, sName, s.mCode, mName, moffice
	from student s, major m
    where s.mCode = m.mcode;

-- 자바(JDBC) 자바수업시간에 쓸 테이블 
drop table if exists personal; -- emp 테이블 유사
drop table if exists division; -- dept 테이블과 유사 

create table division(
	dno int, -- 부서번호
    dname varchar(20), -- 부서 이름
    phone varchar(20), -- 부서 전화
    position varchar(20), -- 부서 위치
    primary key(dno)
);
insert into division values (10, 'finance', '02-545-5555', '강남');
insert into division values (20, 'research', '02-777-7777', '회현');
insert into division values (30, 'sales', '02-333-3333', '서초');
insert into division values (40, 'marketing', '02-666-6666', '과천');
select * from division;

create table personal(
	pno int, -- 사번
    pname varchar(20) not null, -- 사원명
    job varchar(20) not null, -- 직책
	manager int, -- 상사의 사번
    startdate date, -- 입사일
    pay int, -- 급여
    bonus int, -- 상여
	dno int, -- 부서번호
    primary key(pno),
    foreign key(dno) references division(dno)
);

insert into personal values (1111,'smith','manager', 1001, '1990-12-17', 1000, null, 10);
insert into personal values (1112,'ally', 'salesman',1116,'1991-02-20',1600,500,30);
insert into personal values (1113,'word', 'salesman',1116,'1992-02-24',1450,300,30);
insert into personal values (1114,'james','manager',1001,'1990-04-12',3975,null,20);
insert into personal values (1001,'bill', 'president',null,'1989-01-10',7000,null,10);
insert into personal values (1116,'johnson','manager',1001,'1991-05-01',3550,null,30);
insert into personal values (1118,'martin','analyst',1111,'1991-09-09',3450,null,10);
insert into personal values (1121,'kim','clerk',1114,'1990-12-08',4000,null,20);
insert into personal values (1123,'lee','salesman',1116,'1991-09-23',1200,0,30);
insert into personal values (1226,'park','analyst',1111,'1990-01-03',2500,null,10);
select * from division;
select * from personal;
commit;

-- DML(outer join, 단일행함수 일부, top-n구문, and = &&, or = ||)
-- 1. 사번, 이름, 급여를 출력
select pno, pname, pay from personal;
-- 2. 급여가 2000~5000 사이 모든 직원의 모든 필드
select * from personal where pay between 2000 and 5000;
-- 3. 부서번호가 10또는 20인 사원의 사번, 이름, 부서번호
select pno, pname, dno from personal where dno = 10 || dno=20;
-- 4. 보너스가 null인 사원의 사번, 이름, 급여 급여 큰 순정렬
select pno, pname, pay from personal 
	where bonus is null
    order by pay desc; 
-- 5. 사번, 이름, 부서번호, 급여. 부서코드 순 정렬 같으면 PAY 큰순
select pno, pname, dno, pay
	from personal 
    order by dno, pay desc;
-- 6. 사번, 이름, 부서명
select pno, pname, dname 
	from personal p, division d 
    where p.dno = d.dno;
-- 7. 사번, 이름, 상사이름
select p1.pno, p1.pname "worker", p2.pname "manager"
	from personal p1, personal p2
    where p1.manager = p2.pno;
-- 8. 사번, 이름, 상사이름(상사가 없는 사람도 출력, 상사가 없으면 null 대신 'ceo')
select p1.pno, p1.pname, ifnull(p2.pname, 'ceo') -- nvl과 같음 
	from personal p1 left outer join personal p2 -- from절과 where절 순서 같아야함
    on p1.manager = p2.pno; -- left outter join
    
select p1.pno, p1.pname, if(p2.pname is null, 'ceo', p2.pname)  
	from personal p1 left outer join personal p2 
    on p1.manager = p2.pno; 
-- 9. 이름이 s로 시작하는 사원 이름
select p.pname 
	from (select p2.pname from personal p2 where p2.pname like 's%') p;
	-- substr(pname, 1, 1) = s
-- 10. 사번, 이름, 급여, 부서명, 상사이름
select p1.pno, p1.pname, p1.pay, d.dname, ifnull(p2.pname, 'ceo')
	from personal p1, personal p2, division d
    where p1.dno = d.dno and p1.manager = p2.pno; 
-- 11. 부서코드, 급여합계, 최대급여
select dno, sum(pay), max(pay)
	from personal 
    group by dno;
-- 12. 부서명, 급여평균, 인원수
select d.dname, avg(pay), count(p.pname)
	from personal p, division d
    where p.dno = d.dno    
    group by d.dname;
-- 13. 부서코드, 급여합계, 인원수 인원수가 4명 이상인 부서만 출력
select dno, sum(pay), count(pname)
	from personal 
	group by dno
    having count(pname) >= 4;
    
select p1.dno, sum(p1.pay), p2.countpname
	from personal p1, (select dno, count(pname) "countpname" from personal group by dno) p2
 --   where p1.dno = p2.dno and count(p1.pname) > p2.countpname 
	where p1.dno = p2.dno and  count(pname) <= p2.countpname
    group by p1.dno;

-- 14. 사번, 이름, 급여 회사에서 제일 급여를 많이 받는 사람
select pno, pname, pay
	from personal 
    where pay = (select max(pay) from personal);

-- 15. 회사 평균보다 급여를 많이 받는 사람 이름, 급여, 부서번호
select pname, pay, dno
	from personal 
	where pay > (select avg(pay) from personal);

-- 16. 15번에 부서명을 추가하고 부서명순 정열 같으면 급여 큰순
select pname, pay, p.dno, d.dname
	from personal p, division d
	where p.dno = d.dno and pay > (select avg(pay) from personal)
    order by d.dname, pay desc;

-- 17. 자신이 속한 부서의 평균보다 많인 받는 사람의 이름, 금여, 부서번호, 반올림한 해당부서평균
select p1.pname, p1.pay, p1.dno, round(p2.avgpay, 2)
	from personal p1, (select dno, avg(pay) "avgpay" from personal group by dno) p2
	where p1.pay > p2.avgpay;

-- 18. 입사가 가장 빠른 사람의 이름, 급여, 부서명
select pname, pay, dname
	from personal p, division d
    where p.dno = d.dno and startdate = (select max(startdate) from personal);

-- 19. 이름, 급여, 해당부서평균
select p1.pname, p1.dno, p1.pay, p2.avgpay
	from personal p1, (select dno, avg(pay) "avgpay" from personal group by dno) p2
    where p1.dno = p2.dno;

-- 20. 이름, 급여, 부서명, 해당부서평균
select p1.pname, p1.pay, d.dname, p2.avgpay
	from personal p1, division d, (select dno, avg(pay) "avgpay" from personal group by dno) p2
    where p1.dno = d.dno and p1.dno = p2.dno;

-- oracle 에서의 단일행함수와 MySQL 컬럼함수의 다른 부분
select round(789.56,2); -- from절 생략 가능 
select pname || '은' || job || '다' from personal; -- x 
select concat(pname, '은', job, '다') from personal;

-- 날짜 관련 컬럼 함수 (personal 테이블의 startdate의 타입 : datetime)
select startdate from personal;
select year(startdate), month(startdate), date(startdate), hour(startdate), minute(startdate), second(startdate) 
	from personal;
-- date_format(날짜형이나 시간형데이터, '포멧') -- date를 문자로 변환
	-- 포멧글자 : %y : 22 (년도2자리), %Y : 2022(년도 4자리), 
    -- %M : 월이름, %b : 짧은 월이름, %m : 04월,05월, %c : 4(월수)
    -- %d : 20,01,02,03 .. (일2자리),  %e : 20,1,2,3 
    -- %H : 24시간 %h : 12시간 %p : 오전 오후, %i : 분, %s : 초
-- to_char(날짜형데이터, '포멧') : yy/mm/dd -- oracle에서

-- 시스템으로부터 현재 날짜와 시간 
select sysdate();
select now();
-- 시스템으로 현재 날짜
select current_date();
select curdate();
-- 시스템으로 부터 현재 시간 
select current_time();
select curtime();

select date_format(now() , '%Y년%m월%e일 %p %h시 %i분 %s초'); -- date를 문자로

-- format(숫자데이터) : 3자리마다 , 추가  -- 숫자를 문자형으로 
-- format(숫자데이터, 소수점자리수) : 소수점 확보되면서 3자리 , 추가 
select format(pay, 1) from personal; 

-- workbench에서 데이터 삭제하거나 수정 (where절에 primary key를 이용한 비교)
insert into personal(pno, pname, job, manager, startdate, pay, bonus, dno) 
	values (1000, 'hong', 'manager', 1001, curdate(), 9000, 900, 40);
commit;
set sql_safe_updates = 0; -- 모드 변환
delete from personal where pname = 'hong'; -- 안전모드 변환 전 pk를 이용하지않으면 데이터삭제할수없다. 

-- top-n 구문

select pname, pay from personal order by pay desc;
-- limit n (1~n등까지)
select pname, pay from personal order by pay desc limit 5; -- 1등 ~ 5등
-- limit 3,3  (4등 ~ 6등까지) 0번째부터 셈 , 3번째부터 3개  
select pname, pay from personal order by pay desc limit 3, 3; -- 4등부터 3개(4~등)
-- limit 5, 4 (6등 ~ 9등까지) 
select pname, pay from personal order by pay desc limit 5, 4;











