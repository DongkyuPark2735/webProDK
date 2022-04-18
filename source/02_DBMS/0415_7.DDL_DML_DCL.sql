-- DDL, DML, DCL
-- SQL = DDL(테이블 생성, 테이블 삭제, 테이블 구조 변경, 테이블 모든 데이터 제거)
--         DML(SELECT = 데이터 검색, INSERT=추가, UPDATE=수정, DELETE = 삭제)
--         DCL(사용자 계정 생성, 사용자 권한 부여, 권한박탈, 사용자 계정 삭제, 트랜잭션 명령어 = ROLLBACK , COMMIT )



-- DDL --
-- 테이블 생성(CREATE TABLE)
CREATE TABLE BOOK(
    BOOKID NUMBER(4),       -- 도서번호 BOOKID 필드 타입은 숫자4자리
    BOOKNAME VARCHAR2(300), -- 책이름 BOOKNAME 필드는 문자 300BYTE
    PUBLISHER VARCHAR2(300),  -- 출판사 PUBLISHER 필드는 문자 300BYTE
    RDATE   DATE,                  -- 출판일 RDATE 필드는 DATE형
    PRICE   NUMBER(8),           -- 가격 PRICE 필드는 숫자 8자리
    PRIMARY KEY (BOOKID) ) ; -- 테이블 내 주키(PRIMARY KEY) 설정 - NOT NULL, 유일한 값 입력, 제약조건 
    -- PRIMARY KEY 유일한 값 분류를 위한 NULL값을 넣을수 없다
    --PRIMARU KEY 생성되면 인덱스 만들어짐 트리 형식으로? 검색이 빨라짐 
    
SELECT * FROM BOOK;

DROP TABLE BOOK; -- 테이블 삭제 

CREATE TABLE BOOK(
    BOOKID NUMBER(4) PRIMARY KEY, -- 제약조건 필드 선언하면서 해도됨
    BOOKNAME VARCHAR2(20),
    PUBLISHER VARCHAR2(20),
    RDATE DATE,
    PRICE NUMBER(8));

DESC EMP;
SELECT ROWNUM, EMPNO, ENAME FROM EMP; -- ROWNUM : 맨 처음 테이블에서 읽어들인 논리 순서
SELECT ROWNUM, EMPNO, ENAME FROM EMP WHERE DEPTNO = 20 ORDER BY ENAME;-- ROWNUM이 먼저 실행 ORDER BY 보다 

--EMP 테이블과 유사한 EMP01: EMPNO(숫자4), ENAME(문자20), SAL(숫자 7,2)
CREATE TABLE EMP01(
    EMPNO NUMBER(4),
    ENAME VARCHAR2(20),
    SAL NUMBER(7,2)
);
DESC EMP01;
-- DEPT와 유사한 DEPT01 : DEPTNO(숫자2, PK), ENAME(문자14), LOC(문자13)
CREATE TABLE DEPT01(
    DEPTNO NUMBER(2),
    DNAME VARCHAR2(14), --4000BYTE 넘길때만 CLOB
    LOC VARCHAR(13),
    PRIMARY KEY(DEPTNO));
    
DESC DEPT01;
-- 서브쿼리를 이용한 테이블 생성
SELECT * FROM EMP;
SELECT * FROM TAB; -- SCOTT이 생성한 테이블 LIST

CREATE TABLE EMP02
    AS SELECT * FROM EMP; --서브쿼리 AS다음에 SELECT 구문 
        -- 서브쿼리 결과만 EMP02테이블 생성후 들어감 (제약조건은 들어가지않음)
SELECT * FROM EMP05;
DESC EMP02;

--EX. EMP03 : EMP테이블에서 EMPNO, ENAME, DEPTNO 만 추출한 데이터로 테이블 
CREATE TABLE EMP03 
    AS SELECT EMPNO, ENAME, DEPTNO FROM EMP;
    
--EX.EMP04 : EMP테이블에서 10번 부서만 추출한 데이터로 테이블
CREATE TABLE EMP04
    AS SELECT * FROM EMP WHERE DEPTNO =10;

--EX.EMP05 : EMP테이블 구조(필드와 그의 타입)만 추출
CREATE TABLE EMP05 
    AS SELECT * FROM EMP WHERE 1 = 0; 
    --1=0; -- 참일수가 없는 조건 = 데이터가 올수 없는 조건 
    -- 실행 자체가 안되는게 아닌가 
DROP TABLE EMP05;    
DESC EMP05; 
--DESC구문은 같은 행에 주석이 있으면 실행오류

--2. 테이블 구조 변경(ALTER TABLE)   -- DDL구문은 ROLLBACK 안됨
-- ALTER TABLE 테이블 명 ADD || MODIFY || DROP ~
--(1) 필드 추가 (ADD) : 추가된 필드의 데이터는 NULL
SELECT * FROM EMP03; -- EMPNO, ENAME, DEPTNO / JOB와 SAL와 COMM는 NULL 
ALTER TABLE EMP03 ADD (JOB VARCHAR2(20), SAL NUMBER(7,2));
ALTER TABLE EMP03 ADD (COMM NUMBER(7,2));

-- (2) 필드 수정(MODIFY)
SELECT * FROM EMP03; -- EMPNO(숫4), ENAME(문10), DEPTNO(숫2) / JOB와 SAL와 COMM는 NULL 
DESC EMP03; 
ALTER TABLE EMP03 MODIFY (EMPNO VARCHAR2(4)); -- 숫자 데이터가 들어 있는 상태에서는 숫자로만 변경 가능 
ALTER TABLE EMP03 MODIFY (EMPNO NUMBER(3)); -- 에러
ALTER TABLE EMP03 MODIFY (EMPNO NUMBER(5)); -- 가능
ALTER TABLE EMP03 MODIFY (ENAME NUMBER(5)); -- 문자데이터가 들어있는 상태에서는 문자로만 변경 가능 
SELECT MAX(LENGTH(ENAME)) FROM EMP;
ALTER TABLE EMP03 MODIFY (ENAME VARCHAR2(3000)); --데이터가 들어있을때 들어있는 기준으로 늘릴수있다. 줄이거나
ALTER TABLE EMP03 MODIFY (ENAME VARCHAR2(5)); -- 6자리 데이터가 있으므로 5자리로 못줄임 
ALTER TABLE EMP03 MODIFY (JOB VARCHAR2(2));-- NULL이면 데이터가 없으면 제약없이 변경가능 
ALTER TABLE EMP03 MODIFY (JOB NUMBER(2)); 

-- (3) 필드 삭제 (DROP)
ALTER TABLE EMP03 DROP COLUMN JOB; 
-- 논리적으로 특정 필드를 접근 못하도록 (낮에?)
ALTER TABLE EMP03 SET UNUSED(DEPTNO);
SELECT * FROM EMP03;
-- 논리적으로 접근 불가 했던 필드를 물리적으로 삭제 (새벽)
ALTER TABLE EMP03 DROP UNUSED COLUMNS;
--왜 굳이??????????

--3. 테이블 삭제 (DROP TABLE)
DROP TABLE EMP01;
DROP TABLE DEPT; -- DROP불가 
SELECT * FROM EMP; --테이블안의 데이터를 다른 테이블에서 참조하고 있어서 바로 DROP 불가 

--4. 테이블의 모든 행을 제거(TRUNCATE)
SELECT * FROM EMP03;
TRUNCATE TABLE EMP03; --EMP03안의 데이터 제거(취소 불가) 잘렸다

--5. 테이블 명 변경 (RENAME 기존이름 TO 바꿀이름)
SELECT * FROM EMP02;
RENAME EMP02 TO EMP2;
SELECT * FROM EMP2;

--.6 데이터 딕셔너리  -- 접근할수없다 (권한이 없다)  VS 데이터 딕셔너리 뷰 (사용자접근용)
-- 종류 
--USER_XXX : 현 계정이 소유하고 있는 객체(테이블, 인덱스, 제약조건, 뷰) 
    -- EX. USER_TABLES, USER_INDEXES, USER_CONSTRAINTS, USER_VIEWS
--ALL_XXX : 현계정이 접근 가능한 객체(테이블, 인덱스, 제약조건, 뷰)
    -- EX. ALL_TABLES, ALL_INDEXES, ALL_CONSTRAINTS, ALL_VIEWS
--DBA_XXX : DBA 권한자만 접근 가능, DBMS의 모든 객체
    -- EX. DBA_TABLES, DBA_INDEXES, DBA_CONSTRAINTS, DBA_VIEWS

SELECT * FROM ALL_TABLES;
SELECT * FROM ALL_INDEXES;
SELECT * FROM ALL_CONSTRAINTS;
SELECT * FROM ALL_VIEWS;

SELECT * FROM DBA_TABLES;
SELECT * FROM DBA_INDEXES;
SELECT * FROM DBA_CONSTRAINTS;
SELECT * FROM DBA_VIEWS;

SELECT * FROM USER_TABLES; -- 뷰 내 계정이 소유한 테이블 객체 정보 
SELECT * FROM USER_INDEXES; -- 내 계정이 소유한 인덱스 정보   PRIMAY KEY있는 테이블은 인덱스생성됨
SELECT * FROM USER_CONSTRAINTS; --내 계정이 소유한 제약조건들
SELECT * FROM USER_VIEWS; -- 내 계정이 소유한 뷰 정보

-- DCL(사용자 계정 생성, 사용자 권한부여, 권한 박탈, 사용자 계정 삭제)
-- SCOTT2 계정 생성
CREATE USER SCOTT2 IDENTIFIED BY 1234; --시스템계정으로 들어가서 만들어야함, 지금 접속된 계정이 관리자라 가능
-- 권한부여(세션권한, SCOTT.EMP, SCOTT.DEPT 테이블에 대해 모든 권한 
GRANT CREATE SESSION TO SCOTT2; -- 세션권한부여
GRANT ALL ON EMP TO SCOTT2; --EMP테이블에 대한 모든 권한(검색, 추가, 수정, 삭제) 부여
GRANT ALL ON DEPT TO SCOTT2; 
SHOW USER;
-- 권한 박탈 (권한박탈할 사용자 계정이 접속 해제되야 가능)
REVOKE ALL ON EMP FROM SCOTT2; --SCOTT2의 EMP테이블에 대한 모든 권한 박탈
REVOKE ALL ON DEPT FROM SCOTT2;
SHOW USER;
--사용자 계정 삭제 (접속중인 계정 삭제 불가)

DROP USER SCOTT2 CASCADE; 

-- DML(SELECT, INSERT, UPDATE, DELETE)
-- 1. INSERT INTO 테이블명 VALUES (값1, 값2, 값3...) 
--    INSERT INTO 테이블명 (필드명1, 필드명2 ,...) VALUES (값1, 값2, 값3..)
SELECT * FROM DEPT01;
INSERT INTO DEPT01 VALUES (50, 'ACCOUNTING', 'NEW YORK'); --순서 지키면서 아니면 명시해서
INSERT INTO DEPT01 (DEPTNO, DNAME, LOC) VALUES (60, 'IT', 'SEOUL');
INSERT INTO DEPT01 (DEPTNO, DNAME) VALUES (70, 'OPERATION'); --묵시적으로 LOC에 NULL추가
INSERT INTO DEPT01 (DEPTNO, DNAME, LOC) VALUES (80, 'HR', NULL);
INSERT INTO DEPT01 VALUES (90, 'SALES', NULL);
--서브쿼리를 이용한 INSERT
INSERT INTO DEPT01 SELECT * FROM DEPT;
-- 트랜잭션 명령어(DML 명령어만)
COMMIT; 



CREATE TABLE SAM01 (
    EMPNO NUMBER(4),
    ENAME VARCHAR2(10),
    JOB VARCHAR2(9),
    SAL NUMBER(7,2),
    CONSTRAINT SAMPK PRIMARY KEY (EMPNO)); --제약조건 이름 설정 

SELECT * FROM SAM01;
SELECT * FROM USER_CONSTRAINTS;

DROP TABLE SAM01;

INSERT INTO SAM01 VALUES (1000, 'APPLE', 'POLICE', 10000);
INSERT INTO SAM01 (EMPNO,ENAME,JOB,SAL) VALUES (1010, 'BANANA', 'NURSE', 15000);
INSERT INTO SAM01 VALUES (1020, 'ORANGE', 'DOCTOR', 25000);
INSERT INTO SAM01 (EMPNO, ENAME, SAL) VALUES (1030, 'VERY', 25000);
INSERT INTO SAM01 VALUES (1040, 'CAT', NULL, 2000);
INSERT INTO SAM01 SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE DEPTNO = 10; --INSERT 절에는 서브쿼리 괄호 안함 

-- 트랜잭션 명령어
ROLLBACK; -- INSERT만 취소됨 DML문만 , DDL은 취소안됨
COMMIT;

-- 2. UPDATE 테이블명 SET 필드명 1= 값1 {, 필드명2 = 값2 ,...} {WHERE 조건};
CREATE TABLE EMP01 AS SELECT * FROM EMP;
--EMP01테이블의 부서번호를 30으로 수정(WHERE 절 없이는 모든 행이 수정) 
UPDATE EMP01 SET DEPTNO = 30; 

ROLLBACK; -- 트랜잭션 INSERT만 취소됨 DML문만 , DDL은 취소안됨

SELECT * FROM EMP01;

-- EMP01 테이블의 모든 자원의 급여를 10%인상 
UPDATE EMP01 SET SAL = SAL*1.1;
SELECT * FROM EMP01;

--10번 부서의 직원의 입사일을 오늘로, 부서번호는 30번으로 수정
UPDATE EMP01 
    SET HIREDATE = SYSDATE,  
        DEPTNO = 30
        WHERE DEPTNO = 10;
-- SAL이 3000이상인 사원만 SAL을 10%인상 
UPDATE EMP01 SET SAL = SAL * 1.1 WHERE SAL >= 3000;
-- 'DALLAS" 에 근무하는 직원의 급여를 1000$씩 인상(서브쿼리 사용)
UPDATE EMP01 SET SAL = SAL + 1000
    WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE LOC = 'DALLAS');
-- SCOTT의부서번호를 20으로 JOB을 MANAGER로, SAL과 COMM을 500씩 인상, 상사를 KING으로 수정 
UPDATE EMP01 
    SET DEPTNO = 20,
        JOB = 'MANAGER',
        SAL = SAL + 500,
        COMM = NVL(COMM, 0 )+ 500,
        MGR = (SELECT EMPNO FROM EMP WHERE ENAME ='KING')
    WHERE ENAME = 'SCOTT';
SELECT * FROM EMP01 WHERE ENAME = 'SCOTT';
SELECT * FROM DEPT01;
-- DEPT01 에서 20부서의 지역명을 DEPT 테이블의 60번 부서의 지역명으로 변경 

UPDATE DEPT01
    SET LOC = (SELECT LOC FROM DEPT WHERE DEPTNO = 60)
    WHERE DEPTNO >=20; --DEPT테이블의 60번 부서가 없어서 NULL값으로 수정

-- EMP01 테이블의 모든 사원의 급여와 입사일 KING의 급여와 입사일로 수정
COMMIT;
SELECT * FROM EMP01; 
UPDATE EMP01 
    SET SAL = (SELECT SAL FROM EMP WHERE ENAME = 'KING'),
         HIREDATE = (SELECT HIREDATE FROM EMP WHERE ENAME = 'KING');
    
UPDATE EMP01 -- 한번에 
    SET (SAL, HIREDATE) = (SELECT SAL, HIREDATE FROM EMP WHERE ENAME = 'KING'); 

--DEPT01 테이블의 20번 부서의 지역명과 부서명을 40번 부서의 지역명과 부서명으로 변경
UPDATE DEPT01
    SET (DNAME, LOC) = (SELECT DNAME, LOC FROM DEPT01 WHERE DEPTNO=40)
    WHERE DEPTNO = 20;
COMMIT;

--3. DELETE FROM 테이블명 (WHERE 조건);
SELECT * FROM EMP01;
DELETE FROM EMP01; --조건절 없을시 전체행이 삭제( 롤백 가능) 
ROLLBACK;

-- EMP01테이블에서 'FORD'인 사원을 삭제 
DELETE FROM EMP01 WHERE ENAME = 'FORD'; 

-- EMP01테이블에서 30번 부서 직원을 삭제 
DELETE FROM EMP01 WHERE DEPTNO = 30; 

-- EMP01테이블에서 부서명이 RESEATCH 부서의 직원을 삭제 
DELETE FROM EMP01 
    WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE DNAME = 'RESEARCH');
-- SAM01 테이블에서 JOB이 정해지지않은 사원을 삭제 
SELECT * FROM SAM01;
DELETE FROM SAM01
    WHERE JOB IS NULL;
--SAM01 테이블에서 ENAME이 ORANGE인 사원을 삭제하시오
DELETE FROM SAM01
    WHERE ENAME = 'ORANGE';


--연습문제 PDF 1페이지 
--1. 아래의 구조를 만족하는 MY_DATA 테이블을 생성하시오. 단 ID가 PRIMARY KEY이다.
CREATE TABLE MY_DATA(
    ID NUMBER(4) PRIMARY KEY,
    NAME VARCHAR2(10),
    USERID VARCHAR2(30),
    SALARY NUMBER(10,2));
--2. 생성된 테이블에 위의 도표와 같은 값을 입력하는 SQL문을 작성하시오.
INSERT INTO MY_DATA VALUES(1, 'Scott','sscott', 10000) ; 
INSERT INTO MY_DATA VALUES(2, 'Ford','fford', 13000) ; 
INSERT INTO MY_DATA VALUES(3, 'Patel','ppatel', 33000) ; 
INSERT INTO MY_DATA VALUES(4, 'Report','rreport', 23500) ; 
INSERT INTO MY_DATA VALUES(5, 'Good','ggood', 44450) ; 
--TO_CHAR 내장 함수를 이용하여 입력한 자료를 위의 도표와 같은 형식으로 출력하는SQL문을 작성하시오.
SELECT ID, NAME, USERID, TO_CHAR(SALARY, '99,999.00') FROM MY_DATA;
--4. 자료를 영구적으로 데이터베이스에 등록하는 명령어를 작성하시오.
COMMIT;
--ID가 3번인 사람의 급여를 65000.00으로 갱신하고 영구적으로 데이터베이스에 반영하라.
UPDATE MY_DATA
    SET SALARY = 65000
    WHERE ID = 3;
COMMIT;
--6. NAME이 Ford인 사람을 삭제하고 영구적으로 데이터베이스에 반영하라.
DELETE FROM MY_DATA WHERE NAME = 'Ford';
COMMIT;
--7. SALARY가 15,000.00 이하인 사람의 급여를 15,000.00으로 변경하라
UPDATE MY_DATA
    SET SALARY  = 15000
    WHERE SALARY < 15000;
--8. 위에서 생성한 테이블을 삭제하라
DROP TABLE MY_DATA;




-- 제약조건 : 부적합한 데이터가 테이블에 삽입, 수정되는것을 방지하기위해 
-- PRIMAY KEY값은 수정 삽입 불가 

SELECT * FROM EMP; 
INSERT INTO EMP VALUES(7369, '홍', NULL, NULL, SYSDATE, NULL, NULL, 40); -- SMITH 
UPDATE EMP SET EMPNO = 7369 WHERE ENAME = 'ALLEN'; --SMITH 사번과 중복 에러
-- (1) RRIMARY KEY : 유일하게 테이블의 각행을 식별. NOT NULL
--주키가 두개면 하나가 중복이어도 다른 하나가 중복이 아니면 됨 
INSERT INTO EMP(EMPNO , ENAME, DEPTNO) VALUES(7369, '홍', 40); -- 중복된 사번 입력 불가 

-- (2) NOT NULL : NULL값을 포함하지 않음 

-- (3) UNIQUE : 모든 행에 대해 유일해야, NULL값을 허용(NULL은 여러행 입력가능)

-- (4) FOREIGN KEY : 테이블의 열은 다른 테이블의 열을 참조 (EX. EMP테이블의 DEPTNO는 DEPT 테이블의 DEPTNO를 참조)
    -- 비식별관계 : 부모테이블의 PRIMARY KEY가 자식테이블의 일반속성에 속한 필드로(exERD에서 빨간점선 화살표) 
    -- 식별관계 : 부모테이블의 PRIMARY KEY가 자식테이블의 PRIMARY KEY(주키군)에 속한 필드로 관계(exERD에서 초록점선 화살표) 
INSERT INTO EMP (EMPNO, ENAME, DEPTNO)VALUES (1111, '홍', 90); --  외래키 -- DEPT테이블에 90번 부서가 없음 -- 기준에 있는 값을 넣어야함  
                                                                                    
                                                                                
                                                                                


-- (5) CHEK(조건) : 해당 조건이 만족해야 INSERT( NULL값 허용)

-- DEFAULT : 해당 열의 데이터 입력값이 없으면 NULL이 들어가나 NULL값대신에 기본값 --제약조건은 아니다  






DROP TABLE DEPT1; -- 같은 이름의 테이블이 있는지 삭제해서 확인 
CREATE TABLE DEPT1(
    DEPTNO NUMBER(2) PRIMARY KEY,
    DNAME VARCHAR2(14) UNIQUE,  --똑같은 이름 불가 NULL값은 가능 
    LOC VARCHAR2(13) NOT NULL
);
-- DEPT1은 EMP1의 부모PARENT 테이블 EMP1이 DEPT1을참고하고있음 
-- 부모테이블은 자식테이블을 먼저 지워야 DROP가능 

DROP TABLE EMP1;
CREATE TABLE EMP1(
    EMPNO      NUMBER(4)     PRIMARY KEY,
    ENAME       VARCHAR2(10) NOT NULL,
    JOB           VARCHAR2(9)  NOT NULL,
    MGR          NUMBER(4),
    HIREDATE    DATE            DEFAULT SYSDATE, -- 입력하지않으면 지금날짜 기본값으로 들어감
    SAL           NUMBER(7,2)   CHECK(SAL>0),
    COMM       NUMBER(7,2),
    DEPTNO      NUMBER(2)     REFERENCES DEPT1(DEPTNO) -- 반드시 DEPT의 DEPTNO 값에 해당하는 값을 넣어야함  
);

DROP TABLE EMP1; -- 자식테이블 먼저 DROP
DROP TABLE DEPT1; -- EMP1테이블이 참조하고 있어서 삭제 불가 
DROP TABLE DEPT1 CASCADE CONSTRAINTS; -- 권장하지않음 (참조하는 테이블이 있어도 무시하고 DROP)

CREATE TABLE DEPT1(
    DEPTNO NUMBER(2),
    DNAME VARCHAR2(14),
    LOC VARCHAR2(13) NOT NULL, --NOT NULL은 밑에 불가
    PRIMARY KEY(DEPTNO),
    UNIQUE(DNAME));
    
CREATE TABLE EMP1(
    EMPNO NUMBER(4), 
    ENAME VARCHAR2(10) NOT NULL,
    JOB VARCHAR2(9),
    MGR NUMBER(4),
    HIREDATE DATE DEFAULT SYSDATE,
    SAL NUMBER(7,2),
    COMM NUMBER(7,2),
    DEPTNO NUMBER(2), -- 부모테이블로부터 DEPTNO를 외래키로 받음, 외래키로 받아진 PRIMARY키는 NULL가능함 
    PRIMARY KEY(EMPNO),
    CHECK(SAL >0),
    FOREIGN KEY(DEPTNO) REFERENCES DEPT1(DEPTNO));

SELECT * FROM DEPT1;
SELECT * FROM EMP1;

INSERT INTO DEPT1 SELECT * FROM DEPT;
INSERT INTO DEPT1 VALUES (40, 'IT', 'SEOUL'); -- PK 위배
INSERT INTO DEPT1 VALUES (50, 'SALES', 'SEOUL'); -- UNIQUE 위배
INSERT INTO DEPT1 VALUES (50, 'IT', NULL); -- NOT NULL 위배

INSERT INTO EMP1(EMPNO, ENAME, DEPTNO)
    VALUES (1001, '홍', 10); --HIREDATE에 설정된 기본값 들어감 
INSERT INTO EMP1(EMPNO, ENAME, DEPTNO)
    VALUES (1001, '김', 10); -- PK 위배
INSERT INTO EMP1 (EMPNO, DEPTNO)
    VALUES (1002, 20); --ENAME인 NOT NULL위배 
INSERT INTO EMP1(EMPNO, ENAME, SAL)
    VALUES (1002, '박', -1); -- SAL>0 위배
INSERT INTO EMP1 VALUES (1002, '윤', NULL, NULL, TO_DATE('95/01/01', 'YY/MM/DD'), 900, NULL, 99); --FK 위배


-- 연습문제 (PDF 4,5 PAGE)

--4 PAGE
-- BOOKCATEGORY 삭제 및 생성
DROP TABLE BOOKCATEGORY; 

CREATE TABLE BOOKCATEGORY(
    CATEGORY_CODE NUMBER(3) PRIMARY KEY,
    CATEGORY_NAME VARCHAR2(50) UNIQUE,
    OFFICE_LOC VARCHAR2(50) NOT NULL
);
SELECT * FROM BOOKCATEGORY;

-- BOOK 삭제 및 생성
DROP TABLE BOOK; 

CREATE TABLE BOOK(
    CATEGORY_CODE NUMBER(3) REFERENCES BOOKCATEGORY(CATEGORY_CODE),
    BOOKNO VARCHAR2(20) NOT NULL,
    BOOKNAME VARCHAR2(50),
    PUBLISHER VARCHAR2(50),
    PUBYEAR NUMBER(4) DEFAULT EXTRACT(YEAR FROM SYSDATE) 
);
SELECT * FROM BOOK;

-- BOOKCATEGORY 데이터 생성
INSERT INTO BOOKCATEGORY VALUES (100, '철학', '3층 인문실');
INSERT INTO BOOKCATEGORY VALUES (200, '인문', '3층 인문실');
INSERT INTO BOOKCATEGORY VALUES (300, '자연과학', '4층 과학실');
INSERT INTO BOOKCATEGORY VALUES (400, 'IT', '4층 과학실');
-- BOOK 데이터 생성
INSERT INTO BOOK VALUES(100, '100A01', '철학자의 삶', '더존출판' ); -- 오류 디폴트값빼고 행을 명시해줘야??
INSERT INTO BOOK(CATEGORY_CODE, BOOKNO, BOOKNAME, PUBLISHER) 
    VALUES(100, '100A01', '철학자의 삶', '더존출판' );
INSERT INTO BOOK
    VALUES(400, '400A01', '이것이 DB다', '더존출판', 2018 );
    
DELETE FROM BOOK WHERE BOOKNO = '400A01' AND PUBYEAR = 2022;
    

--5PAGE 
-- MAJOR 삭제 및 생성
DROP TABLE MAJOR;

CREATE TABLE MAJOR(
    MAJOR_CODE NUMBER(1) PRIMARY KEY,
    MAJOR_NAME VARCHAR2(30) UNIQUE,
    MAJOR_OFFICE_LOC VARCHAR2(30) NOT NULL
);
SELECT * FROM MAJOR;

-- MAJOR 데이터 생성
INSERT INTO MAJOR VALUES( 1, '경영정보', '경영관 305호');
INSERT INTO MAJOR VALUES( 2, '소프트웨어 공학', '정보관 808호');
INSERT INTO MAJOR VALUES( 3, '디자인', '예술관 606호');
INSERT INTO MAJOR VALUES( 4, '경제', '경상관 202호');

-- STUDENT 삭제 및 생성
DROP TABLE STUDENT; 

CREATE TABLE STUDENT(
    STUDENT_CODE VARCHAR2(10),
    STUDENT_NAME VARCHAR2(20),
    SCORE NUMBER(3) CHECK(SCORE BETWEEN 0 AND 100),
    MAJOR_CODE NUMBER(1) REFERENCES MAJOR(MAJOR_CODE)
);

SELECT * FROM STUDENT;

-- STUDENT 데이터 생성
INSERT INTO STUDENT VALUES('A01', '김길동', 100, 1);
INSERT INTO STUDENT VALUES('A02', '문길동', 90, 2);
INSERT INTO STUDENT VALUES('A03', '홍길동', 95, 1);
INSERT INTO STUDENT VALUES('A03', '홍길동', 101, 1); --에러 





