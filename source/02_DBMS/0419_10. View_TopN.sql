-- VIEW, INLINE VIEW,  TOP-N  ����
-- 1. VEIW : ������ ���̺�  (1) �ܼ��� (2) ���պ� 

-- (1) �ܼ��� : �ϳ��� ���̺�� ������ ��  - ������ ���̺�

-- EMPv0�̶�� VIEW ���� �Ǵ� ���� = EMP���̺� �Ϻ� �ʵ带 ���� ������ ���̺� 
-- �丸��� �����ͻ��� ������?
SELECT * FROM USER_VIEWS; -- ������ ��ųʸ� �� Ȯ��
CREATE OR REPLACE VIEW EMPv0
    AS SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, DEPTNO FROM EMP; -- DDL�� �����ϸ� ������ ��ųʸ� �ڵ� ���� 

SELECT * FROM EMPv0; -- �����͸� �����ؼ� ���ϴ� �κи� ��� �� 
-- ������ ���̺� 
INSERT INTO EMPv0 VALUES (1111, 'ȫ', 'ITMANAGER', '7369', SYSDATE, 40); -- �信 INSERT�ϸ� EMP���̺��� INSERT 
SELECT * FROM EMPv0;
SELECT * FROM EMP; -- �信 ������ ������ ���� ���̺��� ������ ��

UPDATE EMPv0 SET JOB = 'MANAGER' WHERE EMPNO = 1111; --  �� UPDATE�ϸ� EMP���̺� UPDATE 
SELECT * FROM EMPv0;
SELECT * FROM EMP;

DELETE FROM EMPv0 WHERE EMPNO = 1111; -- �� DELETE �ϸ� EMP���̺� DELETE
SELECT * FROM EMPv0;
SELECT * FROM EMP;




-- EMPv0�̶�� VIEW : EMP���̺� 30�� �μ��� 
CREATE OR REPLACE VIEW EMPv0 
    AS SELECT * FROM EMP WHERE DEPTNO =30;

DESC EMPv0;

SELECT * FROM EMPv0;

INSERT INTO EMPv0 VALUES (1111, 'ȫ', NULL,NULL,SYSDATE,9000, 900, 30); --30�� �μ� INSERT 

SELECT * FROM EMP; --���� ���̺��� INSERT


-- 40�� �μ� �Է��� ���� 
INSERT INTO EMPv0 VALUES(1112, '��', NULL,NULL,SYSDATE, 8000,800,40); --�ٸ� �μ� �����͸� �Է��� �����ϳ� �ش� �信 ���࿡ ���� ������ ����
SELECT * FROM EMPv0; --30�� �μ��� ����ϴ� ���� �� �ֱ⶧���� �������� 

DELETE FROM EMPv0 WHERE EMPNO IN (1111,1112); --30 �� �μ��� �ִٰ� ������? ���ؿ� 

DELETE FROM EMP WHERE EMPNO = 1112; --40�� �μ��� EMP���� ����


-- EMPv0 �� ���� : ENAME, JOB, GHIREDATE ������ �� 
CREATE OR REPLACE VIEW EMPv0
    AS SELECT ENAME, JOB, HIREDATE FROM EMP;
    
INSERT INTO EMPv0 VALUES('ȫ', 'SALESMAN', SYSDATE);
-- �� ���鶧 �μ�Ʈ ���ɰ� �Ϸ��� 
COMMIT; 



-- VIEW�� �������� (1) ���� ���� (2) �б� ���� 
-- WITH CHECK OPTION �� ������ ��� ���� ���ǿ� �ش�Ǵ� �����͸� ����, ����, ���� ����
-- WITH READ ONLY�� ������ ��� �б� ���� �� 

-- EMPv0 : EMP ���̺��� 30�� �μ��� 
CREATE OR REPLACE VIEW EMPv0
    AS SELECT * FROM EMP WHERE DEPTNO = 30
    WITH CHECK OPTION; --�ش� ���ǿ� �����Ǵ� �׸� DML����
    
INSERT INTO EMPv0 VALUES(1111, 'ȫ', NULL, NULL, SYSDATE, 9000, 900, 30); -- 30�� �μ��� INSERT
INSERT INTO EMPv0 VALUES(1112, 'ȫ', NULL, NULL, SYSDATE, 9000, 900, 40); -- WHERE ���ǿ� �������� ������ �Ұ�
SELECT * FROM EMP;
SELECT * FROM EMPv0;
DELETE FROM EMPv0 WHERE ENAME = 'SMITH'; -- 20�� �μ� SMITH
DELETE FROM EMPv0 WHERE EMPNO = 1111; --30�� �μ� DELETE

-- EMPv0 : �б� ���� �� 
CREATE OR REPLACE VIEW EMPv0
    AS SELECT EMPNO, ENAME, JOB, MGR, DEPTNO FROM EMP
    WITH READ ONLY;
INSERT INTO EMPv0 VALUES (1111, 'ȫ', NULL, NULL, 40); -- ����(�б����� ��)
SELECT * FROM EMPv0;

-- (2) ���պ� : 2�� �̻��� ���̺�� ������ ���̰ų� ������ �ʵ�� �並 ������. DML���� ���������� ��� 

-- 1. 2�� �̻��� ���̺�� �� ����
CREATE OR REPLACE VIEW EMPv0
    AS SELECT EMPNO, ENAME, JOB, DNAME, LOC
    FROM EMP E, DEPT D 
    WHERE E.DEPTNO = D.DEPTNO;
    
SELECT * FROM EMPv0;

INSERT INTO EMPv0 VALUES(1111, 'HONG', 'MANAGER', 'RESERCH', 'DALLAS'); -- ���պ�� ���źҰ�

--2. ������ �ʵ�� �並 ���� -- �����ڳ� �Լ������� �������ʵ�
    -- �÷��� ��Ī(�����ڷ� ����, ����, _ , 30���̳��� )�� �̿��Ͽ� �並 �����ؾ��Ѵ�. 
CREATE OR REPLACE VIEW EMPv0
    AS SELECT EMPNO, ENAME, SAL *12 FROM EMP WHERE DEPTNO = 10; -- SAL*12��� �ʵ�� ��� ���� 
CREATE OR REPLACE VIEW EMPv0
    AS SELECT EMPNO, ENAME, SAL *12 "YEAR" FROM EMP WHERE DEPTNO = 10; -- ��Ī���� ���� 
    
SELECT * FROM EMPv0;

CREATE OR REPLACE VIEW EMPv0
    AS SELECT EMPNO, ENAME, ROUND(SAL, -2) FROM EMP WHERE DEPTNO = 10; -- ���� 
CREATE OR REPLACE VIEW EMPv0(EMPNO, ENAME, YEAR_SAL)    -- ��Ī�鸸 ���� ����  -- ��� �ʵ带 ����� ����������� 
    AS SELECT EMPNO, ENAME, ROUND(SAL, -2) FROM EMP WHERE DEPTNO = 10;

INSERT INTO EMPv0 VALUES(1111, 'ȫ', 2400); -- ���պ�� ���źҰ� 

-- EX. �μ���ȣ, �ּұ޿�, �ִ�޿�, �μ���� �޿��� ������ DEPTv1 �並 ����
CREATE OR REPLACE VIEW DEPTv1
    AS SELECT DEPTNO, MIN(SAL) "MINSAL", MAX(SAL) "MAXSAL" , TRUNC(AVG(SAL)) "AVGSAL"
        FROM EMP 
        GROUP BY DEPTNO;
SELECT * FROM DEPTv1;

-- EX. ��å �μ��� ������ EMPv0�並 ���� : DISTINCT�� ������ ��� �б� ����
CREATE OR REPLACE VIEW EMPv0
    AS SELECT DISTINCT JOB, DEPTNO FROM EMP ORDER BY DEPTNO;

SELECT * FROM EMPv0;

INSERT INTO EMPv0 VALUES ('CLERK', 10); -- �б� �����̶� ���� 





-- 2. INLINE VIEW : FROM �� ���� ���������� INLINE VIEW�� �ϸ�, FROM ���� ���� ���������� VIEWó�� �ۿ� 

--EX. �޿��� 2000�� �ʰ��ϴ� ����� ��� �޿�
SELECT AVG(SAL) FROM EMP WHERE SAL>2000;

SELECT AVG(SAL) FROM (SELECT SAL FROM EMP WHERE SAL>2000);

--EX. �μ� ��� ���޺��� ���� ����� ���, �̸�, �޿�(�������� �������� 24,25)
SELECT EMPNO, ENAME, SAL 
    FROM EMP E
    WHERE SAL > (SELECT AVG(SAL) FROM EMP WHERE DEPTNO= E.DEPTNO); 
SELECT EMPNO, ENAME, AVGSAL
    FROM EMP E, (SELECT DEPTNO, AVG(SAL) "AVGSAL" FROM EMP GROUP BY DEPTNO) A
    WHERE E.DEPTNO = A.DEPTNO AND SAL > AVGSAL; -- INLINE VIEW



--3. TOP-N ����(TOP 1~10�� / TOP 11~20�� / TOP 6~10��)

-- ROWNUM : FROM�� ���̺�κ��� ������ ���� 
SELECT ROWNUM, ENAME FROM EMP WHERE DEPTNO = 20; 
SELECT ROWNUM, ENAME FROM EMP WHERE DEPTNO = 20 ORDER BY ENAME;
-- ���, �̸�, SAL(��ü�࿡ ����)
SELECT ROWNUM, ENAME, SAL FROM EMP ORDER BY SAL DESC; -- ROWNUM�� ����� �ƴϰ� ���̺�� ���� ������ ���� 
SELECT ROWNUM, ENAME, SAL FROM (SELECT * FROM EMP ORDER BY SAL DESC); --��� ��¿����� ����
-- INLIN ��� ���� ���ĵȰ��� ROWNUM���� ��ȣ�Űܼ� ����� ����

--�Լ��� �̿��� RANK��� (������������)
SELECT RANK() OVER(ORDER BY SAL DESC) RANK,
    DENSE_RANK() OVER(ORDER BY SAL DESC) DENSE_RANK,
    ROW_NUMBER() OVER(ORDER BY SAL DESC) ROW_NUMBER,
    ENAME, SAL FROM EMP;

-- SAL �������� 1~5 �� 
SELECT ROWNUM, ENAME, SAL FROM (SELECT ENAME, SAL FROM EMP ORDER BY SAL DESC)
    WHERE ROWNUM <= 5;
-- SAL �������� 6~10 
SELECT ROWNUM, ENAME, SAL FROM (SELECT ENAME, SAL FROM EMP ORDER BY SAL DESC)
    WHERE ROWNUM BETWEEN 6 AND 10; -- ����� ������ �ʴ´�.
SELECT ENAME, SAL 
FROM (SELECT ROWNUM, ENAME, SAL FROM (SELECT ENAME, SAL FROM EMP ORDER BY SAL DESC))
;
-- TOP - N ���� 1�ܰ�
SELECT ROWNUM RN, ENAME, SAL FROM (SELECT ENAME, SAL FROM EMP ORDER BY SAL DESC);
-- TOP - N ���� 2�ܰ� (�ϼ��� TOP-N ����)
SELECT ROWNUM, RN, ENAME, SAL 
    FROM (SELECT ROWNUM RN, ENAME, SAL FROM (SELECT ENAME, SAL FROM EMP ORDER BY SAL DESC)) A
    WHERE RN BETWEEN 6 AND 10; --�ζ��κ� ������ ROWNUM�� ��Ī�� �־ �����������


--�̸��� ���ĺ� ������� �����ؼ� 6~10��° ���� ���(���, �̸�, ���, JOB, MGR, HIREDATE)
SELECT RN, ENAME, EMPNO, JOB, MGR, HIREDATE
    FROM(SELECT ROWNUM RN, ENAME, EMPNO, JOB, MGR, HIREDATE FROM(SELECT * FROM EMP ORDER BY ENAME))
    WHERE RN BETWEEN 6 AND 10;
    
    
    
    
    
    
-- 1. �μ���� ������� ����ϴ� �뵵�� ��, DNAME_ENAME_VU �� �ۼ��Ͻÿ�
CREATE OR REPLACE VIEW DNAME_ENAME_VU
    AS SELECT DNAME, ENAME FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO;
    
SELECT * FROM DNAME_ENAME_VU;

-- 2. ������ ���ӻ������ ����ϴ� �뵵�� ��,  WORKER_MANAGER_VU�� �ۼ��Ͻÿ�
CREATE OR REPLACE VIEW WORKER_MANAGER_VU
    AS SELECT E1.ENAME "���", E2.ENAME "���ӻ��" FROM EMP E1, EMP E2 WHERE E1.MGR = E2.EMPNO
    WITH READ ONLY; -- �ʵ� �̸��� �����Ҽ�����. ��Ī �ݵ��

SELECT * FROM WORKER_MANAGER_VU;

-- 3. �μ��� �޿��հ� ����� ����Ͻÿ�(�μ���ȣ, �޿��հ�, ���). 
SELECT DEPTNO, SUMSAL, ROWNUM
    FROM(SELECT DEPTNO, SUM(SAL) "SUMSAL" FROM EMP GROUP BY DEPTNO ORDER BY SUMSAL DESC);   

-- 3-1. �μ��� �޿��հ� ����� 2~3���� �μ���ȣ, �޿��հ�, ����� ����Ͻÿ�. -- �л� ����
SELECT DEPTNO, SUMSAL, RN 
    FROM (SELECT DEPTNO, SUMSAL, ROWNUM "RN"
                FROM(SELECT DEPTNO, SUM(SAL) "SUMSAL" FROM EMP GROUP BY DEPTNO ORDER BY SUMSAL DESC))
    WHERE RN BETWEEN 2 AND 3;
    
-- 4. ������̺��� ���, �����, �Ի����� �Ի����� �ֽſ��� ������ ��� ������ �����Ͻÿ�
SELECT * FROM EMP ORDER BY HIREDATE DESC;
SELECT EMPNO, ENAME, HIREDATE FROM EMP ORDER BY HIREDATE DESC;

-- 5. ������̺��� ���, �����, �Ի����� �Ի����� �ֽſ��� ������ ��� 5���� ����Ͻÿ�
SELECT RN, EMPNO, ENAME, HIREDATE
FROM ( SELECT ROWNUM "RN", EMPNO, ENAME, HIREDATE 
            FROM (SELECT EMPNO, ENAME, HIREDATE FROM EMP ORDER BY HIREDATE DESC))
WHERE RN BETWEEN 1 AND 5;
        
SELECT * 
    FROM (SELECT EMPNO, ENAME, HIREDATE FROM EMP ORDER BY HIREDATE DESC) A
    WHERE ROWNUM BETWEEN 1 AND 5;

-- 6. ��� ���̺��� ���, �����, �Ի����� �ֽź��� ������ ������ 6��°�� ���� ������� 10��° ������� ���
SELECT RN, EMPNO, ENAME, HIREDATE
FROM ( SELECT ROWNUM "RN", EMPNO, ENAME, HIREDATE 
            FROM (SELECT EMPNO, ENAME, HIREDATE FROM EMP ORDER BY HIREDATE DESC))
WHERE RN BETWEEN 6 AND 10;



















