 -- 
 INSERT INTO DEPT VALUES(50, 'it', 'SEOUL');
 select * from dept;
 rollback;
 commit;
 delete from dept where dname = 'asd';
 
 
 -- �μ���ȣ �ߺ�üũ 
 SELECT * FROM DEPT WHERE DEPTNO = 70; 
 -- rs.next()����� true(�ߺ����) / false(�μ���/ �μ���ġ �Է¹޾� �Է�)
 SELECT COUNT(*) CNT FROM DEPT WHERE DEPTNO = 70;
 -- �Է� 
INSERT INTO DEPT VALUES(70, 'it', 'SEOUL');
 
-- 
SELECT * FROM DEPT;
UPDATE DEPT SET DNAME = 'ABC' WHERE DEPTNO = 55;
DELETE FROM DNAME WHERE DEPTNO = 55;

UPDATE DEPT SET DNAME= 'ACCOUNTING', LOC= 'NEW YORK' WHERE DEPTNO = 10;



-- ���� 

DELETE FROM DEPT WHERE DEPTNO = 50;



--�μ��� �Է¹޾� �ش�μ� ��� ����
SELECT EMPNO, ENAME, JOB, SAL FROM EMP E, DEPT D 
    WHERE E.DEPTNO = D.DEPTNO AND DNAME=UPPER('SALES'); 

desc emp;







