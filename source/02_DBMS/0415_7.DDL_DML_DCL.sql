-- DDL, DML, DCL
-- SQL = DDL(���̺� ����, ���̺� ����, ���̺� ���� ����, ���̺� ��� ������ ����)
--         DML(SELECT = ������ �˻�, INSERT=�߰�, UPDATE=����, DELETE = ����)
--         DCL(����� ���� ����, ����� ���� �ο�, ���ѹ�Ż, ����� ���� ����, Ʈ����� ��ɾ� = ROLLBACK , COMMIT )



-- DDL --
-- ���̺� ����(CREATE TABLE)
CREATE TABLE BOOK(
    BOOKID NUMBER(4),       -- ������ȣ BOOKID �ʵ� Ÿ���� ����4�ڸ�
    BOOKNAME VARCHAR2(300), -- å�̸� BOOKNAME �ʵ�� ���� 300BYTE
    PUBLISHER VARCHAR2(300),  -- ���ǻ� PUBLISHER �ʵ�� ���� 300BYTE
    RDATE   DATE,                  -- ������ RDATE �ʵ�� DATE��
    PRICE   NUMBER(8),           -- ���� PRICE �ʵ�� ���� 8�ڸ�
    PRIMARY KEY (BOOKID) ) ; -- ���̺� �� ��Ű(PRIMARY KEY) ���� - NOT NULL, ������ �� �Է�, �������� 
    -- PRIMARY KEY ������ �� �з��� ���� NULL���� ������ ����
    --PRIMARU KEY �����Ǹ� �ε��� ������� Ʈ�� ��������? �˻��� ������ 
    
SELECT * FROM BOOK;

DROP TABLE BOOK; -- ���̺� ���� 

CREATE TABLE BOOK(
    BOOKID NUMBER(4) PRIMARY KEY, -- �������� �ʵ� �����ϸ鼭 �ص���
    BOOKNAME VARCHAR2(20),
    PUBLISHER VARCHAR2(20),
    RDATE DATE,
    PRICE NUMBER(8));

DESC EMP;
SELECT ROWNUM, EMPNO, ENAME FROM EMP; -- ROWNUM : �� ó�� ���̺��� �о���� �� ����
SELECT ROWNUM, EMPNO, ENAME FROM EMP WHERE DEPTNO = 20 ORDER BY ENAME;-- ROWNUM�� ���� ���� ORDER BY ���� 

--EMP ���̺�� ������ EMP01: EMPNO(����4), ENAME(����20), SAL(���� 7,2)
CREATE TABLE EMP01(
    EMPNO NUMBER(4),
    ENAME VARCHAR2(20),
    SAL NUMBER(7,2)
);
DESC EMP01;
-- DEPT�� ������ DEPT01 : DEPTNO(����2, PK), ENAME(����14), LOC(����13)
CREATE TABLE DEPT01(
    DEPTNO NUMBER(2),
    DNAME VARCHAR2(14), --4000BYTE �ѱ涧�� CLOB
    LOC VARCHAR(13),
    PRIMARY KEY(DEPTNO));
    
DESC DEPT01;
-- ���������� �̿��� ���̺� ����
SELECT * FROM EMP;
SELECT * FROM TAB; -- SCOTT�� ������ ���̺� LIST

CREATE TABLE EMP02
    AS SELECT * FROM EMP; --�������� AS������ SELECT ���� 
        -- �������� ����� EMP02���̺� ������ �� (���������� ��������)
SELECT * FROM EMP05;
DESC EMP02;

--EX. EMP03 : EMP���̺��� EMPNO, ENAME, DEPTNO �� ������ �����ͷ� ���̺� 
CREATE TABLE EMP03 
    AS SELECT EMPNO, ENAME, DEPTNO FROM EMP;
    
--EX.EMP04 : EMP���̺��� 10�� �μ��� ������ �����ͷ� ���̺�
CREATE TABLE EMP04
    AS SELECT * FROM EMP WHERE DEPTNO =10;

--EX.EMP05 : EMP���̺� ����(�ʵ�� ���� Ÿ��)�� ����
CREATE TABLE EMP05 
    AS SELECT * FROM EMP WHERE 1 = 0; 
    --1=0; -- ���ϼ��� ���� ���� = �����Ͱ� �ü� ���� ���� 
    -- ���� ��ü�� �ȵǴ°� �ƴѰ� 
DROP TABLE EMP05;    
DESC EMP05; 
--DESC������ ���� �࿡ �ּ��� ������ �������

--2. ���̺� ���� ����(ALTER TABLE)   -- DDL������ ROLLBACK �ȵ�
-- ALTER TABLE ���̺� �� ADD || MODIFY || DROP ~
--(1) �ʵ� �߰� (ADD) : �߰��� �ʵ��� �����ʹ� NULL
SELECT * FROM EMP03; -- EMPNO, ENAME, DEPTNO / JOB�� SAL�� COMM�� NULL 
ALTER TABLE EMP03 ADD (JOB VARCHAR2(20), SAL NUMBER(7,2));
ALTER TABLE EMP03 ADD (COMM NUMBER(7,2));

-- (2) �ʵ� ����(MODIFY)
SELECT * FROM EMP03; -- EMPNO(��4), ENAME(��10), DEPTNO(��2) / JOB�� SAL�� COMM�� NULL 
DESC EMP03; 
ALTER TABLE EMP03 MODIFY (EMPNO VARCHAR2(4)); -- ���� �����Ͱ� ��� �ִ� ���¿����� ���ڷθ� ���� ���� 
ALTER TABLE EMP03 MODIFY (EMPNO NUMBER(3)); -- ����
ALTER TABLE EMP03 MODIFY (EMPNO NUMBER(5)); -- ����
ALTER TABLE EMP03 MODIFY (ENAME NUMBER(5)); -- ���ڵ����Ͱ� ����ִ� ���¿����� ���ڷθ� ���� ���� 
SELECT MAX(LENGTH(ENAME)) FROM EMP;
ALTER TABLE EMP03 MODIFY (ENAME VARCHAR2(3000)); --�����Ͱ� ��������� ����ִ� �������� �ø����ִ�. ���̰ų�
ALTER TABLE EMP03 MODIFY (ENAME VARCHAR2(5)); -- 6�ڸ� �����Ͱ� �����Ƿ� 5�ڸ��� ������ 
ALTER TABLE EMP03 MODIFY (JOB VARCHAR2(2));-- NULL�̸� �����Ͱ� ������ ������� ���氡�� 
ALTER TABLE EMP03 MODIFY (JOB NUMBER(2)); 

-- (3) �ʵ� ���� (DROP)
ALTER TABLE EMP03 DROP COLUMN JOB; 
-- �������� Ư�� �ʵ带 ���� ���ϵ��� (����?)
ALTER TABLE EMP03 SET UNUSED(DEPTNO);
SELECT * FROM EMP03;
-- �������� ���� �Ұ� �ߴ� �ʵ带 ���������� ���� (����)
ALTER TABLE EMP03 DROP UNUSED COLUMNS;
--�� ����??????????

--3. ���̺� ���� (DROP TABLE)
DROP TABLE EMP01;
DROP TABLE DEPT; -- DROP�Ұ� 
SELECT * FROM EMP; --���̺���� �����͸� �ٸ� ���̺��� �����ϰ� �־ �ٷ� DROP �Ұ� 

--4. ���̺��� ��� ���� ����(TRUNCATE)
SELECT * FROM EMP03;
TRUNCATE TABLE EMP03; --EMP03���� ������ ����(��� �Ұ�) �߷ȴ�

--5. ���̺� �� ���� (RENAME �����̸� TO �ٲ��̸�)
SELECT * FROM EMP02;
RENAME EMP02 TO EMP2;
SELECT * FROM EMP2;

--.6 ������ ��ųʸ�  -- �����Ҽ����� (������ ����)  VS ������ ��ųʸ� �� (��������ٿ�)
-- ���� 
--USER_XXX : �� ������ �����ϰ� �ִ� ��ü(���̺�, �ε���, ��������, ��) 
    -- EX. USER_TABLES, USER_INDEXES, USER_CONSTRAINTS, USER_VIEWS
--ALL_XXX : �������� ���� ������ ��ü(���̺�, �ε���, ��������, ��)
    -- EX. ALL_TABLES, ALL_INDEXES, ALL_CONSTRAINTS, ALL_VIEWS
--DBA_XXX : DBA �����ڸ� ���� ����, DBMS�� ��� ��ü
    -- EX. DBA_TABLES, DBA_INDEXES, DBA_CONSTRAINTS, DBA_VIEWS

SELECT * FROM ALL_TABLES;
SELECT * FROM ALL_INDEXES;
SELECT * FROM ALL_CONSTRAINTS;
SELECT * FROM ALL_VIEWS;

SELECT * FROM DBA_TABLES;
SELECT * FROM DBA_INDEXES;
SELECT * FROM DBA_CONSTRAINTS;
SELECT * FROM DBA_VIEWS;

SELECT * FROM USER_TABLES; -- �� �� ������ ������ ���̺� ��ü ���� 
SELECT * FROM USER_INDEXES; -- �� ������ ������ �ε��� ����   PRIMAY KEY�ִ� ���̺��� �ε���������
SELECT * FROM USER_CONSTRAINTS; --�� ������ ������ �������ǵ�
SELECT * FROM USER_VIEWS; -- �� ������ ������ �� ����

-- DCL(����� ���� ����, ����� ���Ѻο�, ���� ��Ż, ����� ���� ����)
-- SCOTT2 ���� ����
CREATE USER SCOTT2 IDENTIFIED BY 1234; --�ý��۰������� ���� ��������, ���� ���ӵ� ������ �����ڶ� ����
-- ���Ѻο�(���Ǳ���, SCOTT.EMP, SCOTT.DEPT ���̺� ���� ��� ���� 
GRANT CREATE SESSION TO SCOTT2; -- ���Ǳ��Ѻο�
GRANT ALL ON EMP TO SCOTT2; --EMP���̺� ���� ��� ����(�˻�, �߰�, ����, ����) �ο�
GRANT ALL ON DEPT TO SCOTT2; 
SHOW USER;
-- ���� ��Ż (���ѹ�Ż�� ����� ������ ���� �����Ǿ� ����)
REVOKE ALL ON EMP FROM SCOTT2; --SCOTT2�� EMP���̺� ���� ��� ���� ��Ż
REVOKE ALL ON DEPT FROM SCOTT2;
SHOW USER;
--����� ���� ���� (�������� ���� ���� �Ұ�)

DROP USER SCOTT2 CASCADE; 

-- DML(SELECT, INSERT, UPDATE, DELETE)
-- 1. INSERT INTO ���̺�� VALUES (��1, ��2, ��3...) 
--    INSERT INTO ���̺�� (�ʵ��1, �ʵ��2 ,...) VALUES (��1, ��2, ��3..)
SELECT * FROM DEPT01;
INSERT INTO DEPT01 VALUES (50, 'ACCOUNTING', 'NEW YORK'); --���� ��Ű�鼭 �ƴϸ� ����ؼ�
INSERT INTO DEPT01 (DEPTNO, DNAME, LOC) VALUES (60, 'IT', 'SEOUL');
INSERT INTO DEPT01 (DEPTNO, DNAME) VALUES (70, 'OPERATION'); --���������� LOC�� NULL�߰�
INSERT INTO DEPT01 (DEPTNO, DNAME, LOC) VALUES (80, 'HR', NULL);
INSERT INTO DEPT01 VALUES (90, 'SALES', NULL);
--���������� �̿��� INSERT
INSERT INTO DEPT01 SELECT * FROM DEPT;
-- Ʈ����� ��ɾ�(DML ��ɾ)
COMMIT; 



CREATE TABLE SAM01 (
    EMPNO NUMBER(4),
    ENAME VARCHAR2(10),
    JOB VARCHAR2(9),
    SAL NUMBER(7,2),
    CONSTRAINT SAMPK PRIMARY KEY (EMPNO)); --�������� �̸� ���� 

SELECT * FROM SAM01;
SELECT * FROM USER_CONSTRAINTS;

DROP TABLE SAM01;

INSERT INTO SAM01 VALUES (1000, 'APPLE', 'POLICE', 10000);
INSERT INTO SAM01 (EMPNO,ENAME,JOB,SAL) VALUES (1010, 'BANANA', 'NURSE', 15000);
INSERT INTO SAM01 VALUES (1020, 'ORANGE', 'DOCTOR', 25000);
INSERT INTO SAM01 (EMPNO, ENAME, SAL) VALUES (1030, 'VERY', 25000);
INSERT INTO SAM01 VALUES (1040, 'CAT', NULL, 2000);
INSERT INTO SAM01 SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE DEPTNO = 10; --INSERT ������ �������� ��ȣ ���� 

-- Ʈ����� ��ɾ�
ROLLBACK; -- INSERT�� ��ҵ� DML���� , DDL�� ��Ҿȵ�
COMMIT;

-- 2. UPDATE ���̺�� SET �ʵ�� 1= ��1 {, �ʵ��2 = ��2 ,...} {WHERE ����};
CREATE TABLE EMP01 AS SELECT * FROM EMP;
--EMP01���̺��� �μ���ȣ�� 30���� ����(WHERE �� ���̴� ��� ���� ����) 
UPDATE EMP01 SET DEPTNO = 30; 

ROLLBACK; -- Ʈ����� INSERT�� ��ҵ� DML���� , DDL�� ��Ҿȵ�

SELECT * FROM EMP01;

-- EMP01 ���̺��� ��� �ڿ��� �޿��� 10%�λ� 
UPDATE EMP01 SET SAL = SAL*1.1;
SELECT * FROM EMP01;

--10�� �μ��� ������ �Ի����� ���÷�, �μ���ȣ�� 30������ ����
UPDATE EMP01 
    SET HIREDATE = SYSDATE,  
        DEPTNO = 30
        WHERE DEPTNO = 10;
-- SAL�� 3000�̻��� ����� SAL�� 10%�λ� 
UPDATE EMP01 SET SAL = SAL * 1.1 WHERE SAL >= 3000;
-- 'DALLAS" �� �ٹ��ϴ� ������ �޿��� 1000$�� �λ�(�������� ���)
UPDATE EMP01 SET SAL = SAL + 1000
    WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE LOC = 'DALLAS');
-- SCOTT�Ǻμ���ȣ�� 20���� JOB�� MANAGER��, SAL�� COMM�� 500�� �λ�, ��縦 KING���� ���� 
UPDATE EMP01 
    SET DEPTNO = 20,
        JOB = 'MANAGER',
        SAL = SAL + 500,
        COMM = NVL(COMM, 0 )+ 500,
        MGR = (SELECT EMPNO FROM EMP WHERE ENAME ='KING')
    WHERE ENAME = 'SCOTT';
SELECT * FROM EMP01 WHERE ENAME = 'SCOTT';
SELECT * FROM DEPT01;
-- DEPT01 ���� 20�μ��� �������� DEPT ���̺��� 60�� �μ��� ���������� ���� 

UPDATE DEPT01
    SET LOC = (SELECT LOC FROM DEPT WHERE DEPTNO = 60)
    WHERE DEPTNO >=20; --DEPT���̺��� 60�� �μ��� ��� NULL������ ����

-- EMP01 ���̺��� ��� ����� �޿��� �Ի��� KING�� �޿��� �Ի��Ϸ� ����
COMMIT;
SELECT * FROM EMP01; 
UPDATE EMP01 
    SET SAL = (SELECT SAL FROM EMP WHERE ENAME = 'KING'),
         HIREDATE = (SELECT HIREDATE FROM EMP WHERE ENAME = 'KING');
    
UPDATE EMP01 -- �ѹ��� 
    SET (SAL, HIREDATE) = (SELECT SAL, HIREDATE FROM EMP WHERE ENAME = 'KING'); 

--DEPT01 ���̺��� 20�� �μ��� ������� �μ����� 40�� �μ��� ������� �μ������� ����
UPDATE DEPT01
    SET (DNAME, LOC) = (SELECT DNAME, LOC FROM DEPT01 WHERE DEPTNO=40)
    WHERE DEPTNO = 20;
COMMIT;

--3. DELETE FROM ���̺�� (WHERE ����);
SELECT * FROM EMP01;
DELETE FROM EMP01; --������ ������ ��ü���� ����( �ѹ� ����) 
ROLLBACK;

-- EMP01���̺��� 'FORD'�� ����� ���� 
DELETE FROM EMP01 WHERE ENAME = 'FORD'; 

-- EMP01���̺��� 30�� �μ� ������ ���� 
DELETE FROM EMP01 WHERE DEPTNO = 30; 

-- EMP01���̺��� �μ����� RESEATCH �μ��� ������ ���� 
DELETE FROM EMP01 
    WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE DNAME = 'RESEARCH');
-- SAM01 ���̺��� JOB�� ������������ ����� ���� 
SELECT * FROM SAM01;
DELETE FROM SAM01
    WHERE JOB IS NULL;
--SAM01 ���̺��� ENAME�� ORANGE�� ����� �����Ͻÿ�
DELETE FROM SAM01
    WHERE ENAME = 'ORANGE';


--�������� PDF 1������ 
--1. �Ʒ��� ������ �����ϴ� MY_DATA ���̺��� �����Ͻÿ�. �� ID�� PRIMARY KEY�̴�.
CREATE TABLE MY_DATA(
    ID NUMBER(4) PRIMARY KEY,
    NAME VARCHAR2(10),
    USERID VARCHAR2(30),
    SALARY NUMBER(10,2));
--2. ������ ���̺� ���� ��ǥ�� ���� ���� �Է��ϴ� SQL���� �ۼ��Ͻÿ�.
INSERT INTO MY_DATA VALUES(1, 'Scott','sscott', 10000) ; 
INSERT INTO MY_DATA VALUES(2, 'Ford','fford', 13000) ; 
INSERT INTO MY_DATA VALUES(3, 'Patel','ppatel', 33000) ; 
INSERT INTO MY_DATA VALUES(4, 'Report','rreport', 23500) ; 
INSERT INTO MY_DATA VALUES(5, 'Good','ggood', 44450) ; 
--TO_CHAR ���� �Լ��� �̿��Ͽ� �Է��� �ڷḦ ���� ��ǥ�� ���� �������� ����ϴ�SQL���� �ۼ��Ͻÿ�.
SELECT ID, NAME, USERID, TO_CHAR(SALARY, '99,999.00') FROM MY_DATA;
--4. �ڷḦ ���������� �����ͺ��̽��� ����ϴ� ��ɾ �ۼ��Ͻÿ�.
COMMIT;
--ID�� 3���� ����� �޿��� 65000.00���� �����ϰ� ���������� �����ͺ��̽��� �ݿ��϶�.
UPDATE MY_DATA
    SET SALARY = 65000
    WHERE ID = 3;
COMMIT;
--6. NAME�� Ford�� ����� �����ϰ� ���������� �����ͺ��̽��� �ݿ��϶�.
DELETE FROM MY_DATA WHERE NAME = 'Ford';
COMMIT;
--7. SALARY�� 15,000.00 ������ ����� �޿��� 15,000.00���� �����϶�
UPDATE MY_DATA
    SET SALARY  = 15000
    WHERE SALARY < 15000;
--8. ������ ������ ���̺��� �����϶�
DROP TABLE MY_DATA;




