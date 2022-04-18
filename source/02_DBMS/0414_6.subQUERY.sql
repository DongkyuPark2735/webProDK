-- �������� QUERY �ȿ� QUERY
-- SELECT �ʵ� 1, �ʵ� 2 (SELECT �ʵ� FROM ���̺� WHERE ����) ��κ� ���� �����ִµ� ���� WHERE���� ��
--      FROM ���̺� (SELECT �ʵ� FROM ���̺� WHERE ����)
--      WHERE ���� (SELECT �ʵ� FROM ���̺� WHERE ����)

--SELECT ���� ���� ���������� 1�� 1���� ¥����


--1 ���� ���� ����
--���������� �ʿ伺 : �޿� ���� ���� �޴� ����� ���, �̸�, ��å�� �޿�
SELECT MAX(SAL) FROM EMP;
SELECT EMPNO, MAX(SAL) FROM EMP GROUP BY EMPNO;
--�ۿ� 
SELECT MAX(SAL) FROM EMP;--��������

SELECT EMPNO, ENAME, JOB, SAL 
    FROM EMP
    WHERE SAL != (SELECT MAX(SAL) FROM EMP); -- ��������(���������� ��ȣ�� �������)

--���������� ����(1) ������ ��������(�������� ����� ������) : =, >, >= ,<,<= ,!= ������ ����
    --EX. SCOTT�� �ٹ��ϴ� �μ��̸� ��� 
SELECT DEPTNO FROM EMP WHERE ENAME = 'SCOTT'; --��������

SELECT DNAME 
    FROM DEPT 
    WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'SCOTT'); --��������
SELECT DNAME FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO AND ENAME ='SCOTT'; 
--���������� ����(2) ������ ��������(�������� ��� 2�� �̻�) : IN, ANY, ALL, EXISTS
    -- EX. JOB�� MANAGER�� ����� �μ��̸� 
SELECT DEPTNO FROM EMP WHERE JOB='MANAGER'; --��������
SELECT DNAME FROM DEPT
    WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE JOB='MANAGER');


-- 2.. ������ �������� 
-- �������� ���� ������ �׽�Ʈ �غ��� ������� �ϳ����� �ϳ��̻������� ���� �������� ����
    -- �Ʒ� ���� ��ó�� 
SELECT * FROM DEPT;
SELECT * FROM EMP;
SELECT E.DEPTNO, LOC FROM EMP E, DEPT D 
    WHERE E.DEPTNO = D.DEPTNO AND ENAME='SCOTT';
INSERT INTO DEPT VALUES(50, 'IT', 'DALLAS');
INSERT INTO EMP (EMPNO, ENAME, DEPTNO) VALUES (9999, 'ȫ�浿', 50);
ROLLBACK; --������ �߰� ���(DML -������ �߰�, ����, ����)
    -- EX. SCOTT�� ���� �μ���ȣ�� ����� �̸��� �޿� 
SELECT DEPTNO FROM EMP WHERE ENAME = 'SCOTT';
SELECT ENAME, SAL FROM EMP WHERE DEPTNO=(SELECT DEPTNO FROM EMP WHERE ENAME = 'SCOTT') AND ENAME != 'SCOTT';
    --EX.SCOTT�� ���� �ٹ����� ����� �̸��� �޿�
SELECT LOC FROM DEPT D, EMP E WHERE D.DEPTNO=E.DEPTNO AND E.ENAME = 'SCOTT';  
SELECT ENAME, SAL
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND 
               LOC=(SELECT LOC FROM DEPT D, EMP E WHERE D.DEPTNO=E.DEPTNO AND E.ENAME = 'SCOTT') AND ENAME <> 'SCOTT';

-- ���� �Ի��ϰ� ���� �Ի��� ��� �̸�
SELECT MIN(HIREDATE) FROM EMP;
SELECT HIREDATE, ENAME 
    FROM EMP
    WHERE HIREDATE = (SELECT MIN(HIREDATE) FROM EMP);
 
-- �ֱ� �Ի��ϰ� �ֱ� �Ի��� ��� �̸�  
SELECT MAX(HIREDATE) FROM EMP;
SELECT HIREDATE , ENAME 
    FROM EMP
    WHERE HIREDATE = (SELECT MAX(HIREDATE) FROM EMP);
 
-- ���� �Ի��ϰ� ���� �Ի��� ��� �̸�  �ֱ� �Ի��ϰ� �ֱ� �Ի��� ��� �̸�  
--SELECT MIN(HIREDATE) "����", MAX(HIREDATE) "�ֱ�" FROM EMP;
--SELECT (SELECT HIREDATE, ENAME  FROM EMP  WHERE HIREDATE = (SELECT MIN(HIREDATE) FROM EMP)
--            (SELECT HIREDATE , ENAME  FROM EMP WHERE HIREDATE = (SELECT MAX(HIREDATE) FROM EMP)
--               FROM DUAL;    
SELECT E1.HIREDATE, E1.ENAME, E2.HIREDATE, E2.ENAME 
        FROM EMP E1, EMP E2
        WHERE E1.HIREDATE = (SELECT MIN(HIREDATE) FROM EMP) 
            AND E2.HIREDATE = (SELECT MAX(HIREDATE) FROM EMP);

    --EX. SCOTT�� ���� �μ��� �ٹ��ϴ� ������� �޿���
SELECT DEPTNO FROM EMP WHERE ENAME = 'SCOTT';

SELECT SUM(SAL)
    FROM EMP
    WHERE DEPTNO= (SELECT DEPTNO FROM EMP WHERE ENAME = 'SCOTT');
    --EX. SCOTT�� ������ ��å(JOB)�� ���� ����� ��� �ʵ�
SELECT JOB FROM EMP WHERE ENAME='SCOTT';
SELECT *
    FROM EMP
    WHERE JOB=(SELECT JOB FROM EMP WHERE ENAME='SCOTT');
    --EX. DALLAS ���� �ٹ��ϴ� ����� �̸�, �μ���ȣ 
SELECT DEPTNO
    FROM DEPT
    WHERE LOC ='DALLAS';
SELECT ENAME, DEPTNO
    FROM EMP
    WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE LOC ='DALLAS');
    --EX KING�� ���ӻ���� ����� �̸��� �޿�
    
SELECT EMPNO FROM EMP WHERE ENAME = 'KING';

SELECT ENAME, SAL 
    FROM EMP 
    WHERE MGR = (SELECT EMPNO FROM EMP WHERE ENAME = 'KING'); 

SELECT E1.ENAME, E1.SAL
    FROM EMP E1, EMP E2
    WHERE E1.MGR = E2.EMPNO AND E2.ENAME = 'KING'; 

--EX. ��ձ޿� ���Ϸ� �޴� ����� �̸��� �޿��� ���
SELECT ENAME, SAL
    FROM EMP
    WHERE SAL <= (SELECT AVG(SAL) FROM EMP);
--EX2. ��ձ޿� ���Ϸ� �޴� ����� �̸�, �޿�, ��ձ޿� ���
SELECT ENAME, SAL, TRUNC((SELECT AVG(SAL) FROM EMP)) "��ձ޿�"
    FROM EMP
    WHERE  SAL <= (SELECT AVG(SAL) FROM EMP);

--ex3 ��ձ޿� ���Ϸ� �޴� ����� �̸�, �޿�, ��հ� ���̸� ���
SELECT ENAME, SAL, ROUND((SELECT AVG(SAL) FROM EMP), 2) "���",ROUND((SELECT AVG(SAL) FROM EMP) - SAL, 1)"��ձ޿�����"  --���������� �ѹ��� ����� �װ��� ���
FROM EMP
WHERE SAL <= (SELECT AVG(SAL) FROM EMP);



--2. ������ ���߿� �������� : SCOTT�̶� JOB�� DEPTNO�� ���� ������ ��� �ʵ� ���
SELECT JOB, DEPTNO FROM EMP WHERE ENAME = 'SCOTT'; -- ������ ���߿�

SELECT * 
    FROM EMP
    WHERE (JOB, DEPTNO) = (SELECT JOB, DEPTNO FROM EMP WHERE ENAME = 'SCOTT') AND ENAME <> 'SCOTT';
    -- ���߿��϶� ��ȣ�� �־ ������ �� �����ϰ� ���ϴµ�  ���� ���� �ؾ��� �񱳱� ���� 


-- �� �� ��������
--1. ������̺��� ���� ���� �Ի��� ����� �̸�, �޿�, �Ի���
SELECT ENAME, SAL 
    FROM EMP
    WHERE HIREDATE = (SELECT MIN(HIREDATE) FROM EMP);   
-- 2. ȸ�翡�� ���� �޿��� ���� ����� �̸�, �޿�
SELECT ENAME, SAL 
    FROM EMP
    WHERE SAL = (SELECT MIN(SAL) FROM EMP);
-- 3. ȸ�� ��պ��� �޿��� ���� �޴� ����� �̸�, �޿�, �μ��ڵ�
SELECT ENAME, SAL, DEPTNO
    FROM EMP
    WHERE SAL >=(SELECT TRUNC(AVG(SAL)) FROM EMP);
--4. ȸ�� ��� ������ �޿��� �޴� ����� �̸�, �޿�, �μ���
SELECT ENAME, SAL, DNAME
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND SAL <=(SELECT TRUNC(AVG(SAL)) FROM EMP);
--5. SCOTT���� ���� �Ի��� ����� �̸�, �޿�, �Ի���, �޿� ���
SELECT ENAME, SAL, HIREDATE, GRADE
    FROM EMP, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL AND HIREDATE < (SELECT HIREDATE FROM EMP WHERE ENAME='SCOTT') AND ENAME <> 'SCOTT' ;
--6. 5��(SCOTT���� ���� �Ի��� ����� �̸�, �޿�, �Ի���, �޿� ���)�� �μ��� �߰��ϰ� �޿��� ū �� ����
SELECT ENAME, SAL, HIREDATE, GRADE, DNAME
    FROM EMP E, SALGRADE, DEPT D 
    WHERE SAL BETWEEN LOSAL AND HISAL AND E.DEPTNO = D.DEPTNO
            AND HIREDATE < (SELECT HIREDATE FROM EMP WHERE ENAME='SCOTT') AND ENAME <> 'SCOTT'
    ORDER BY SAL DESC;
    SELECT * FROM EMP;
--7. BLAKE ���� �޿��� ���� ������� ���, �̸�, �޿�
SELECT EMPNO, ENAME, SAL
    FROM EMP
    WHERE SAL >=(SELECT SAL FROM EMP WHERE ENAME='BLAKE') AND ENAME <> 'BLAKE';
--8. MILLER���� �ʰ� �Ի��� ����� ���, �̸�, �Ի���
SELECT EMPNO, ENAME, HIREDATE
    FROM EMP
    WHERE HIREDATE >=(SELECT HIREDATE FROM EMP WHERE ENAME='MILLER') AND ENAME <> 'MILLER';
--9. �����ü ��� �޿����� �޿��� ���� ������� ���, �̸�, �޿�
SELECT EMPNO, ENAME, SAL
    FROM EMP
    WHERE SAL >= (SELECT AVG(SAL) FROM EMP);
--10. CLARK�� ���� �μ���ȣ�̸�, ����� 7698�� ������ �޿����� ���� �޿��� �޴� ����� ���, �̸�, �޿�
SELECT EMPNO, ENAME, SAL  --������ �������� �������� �ΰ� ������ 
    FROM EMP                    --������ �ϳ��� ����� �������̸� �����༭������
    WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'CLARK') 
        AND SAL >=  (SELECT SAL FROM EMP WHERE EMPNO = '7698');
--11.  �����ȭ. CLARK�� ���� �μ����̸�, ����� 7698�� ������ �޿����� ���� �޿��� �޴� ����� ���, �̸�, �޿�
SELECT EMPNO, ENAME, SAL 
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND DNAME = (SELECT DNAME FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO AND ENAME = 'CLARK') 
        AND SAL >=  (SELECT SAL FROM EMP WHERE EMPNO = '7698'); 
--12. BLAKE�� ���� �μ��� �ִ� ��� ����� �̸��� �Ի�����
SELECT ENAME, HIREDATE 
    FROM EMP
    WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME ='BLAKE');
--13. ��� �޿� �̻��� �޴� ��� �������� ���ؼ� �����ȣ�� �̸� �� �޿��� ���� ������ ���)
SELECT EMPNO, ENAME
    FROM EMP
    WHERE SAL >= (SELECT AVG(SAL) FROM EMP)
    ORDER BY SAL DESC;
-- ���������� �񱳱� �����ʿ� ��ġ�ؾ��� 

-- 24. �μ����� ������ ��� ���޺��� ���� ����� ���, �̸�, �޿�, �μ���ȣ
SELECT EMPNO, ENAME, SAL, DEPTNO
    FROM EMP
    WHERE  (SELECT AVG(SAL) FROM EMP);
    


-- 3. ������ �������� : IN, ALL, ANY=SOME, EXUSTS
-- (1) IN : �������� ����� �ϳ��� ��ġ�ϸ� �� 
    -- EX. �μ����� �Ի����� ���� ���� ����� �̸�, �Ի���, �μ���ȣ

SELECT DEPTNO, MAX(HIREDATE) FROM EMP GROUP BY DEPTNO; -- ��������(������ ���߿�)
SELECT ENAME, HIREDATE, DEPTNO
    FROM EMP
    WHERE (DEPTNO, HIREDATE) IN (SELECT DEPTNO, MAX(HIREDATE) FROM EMP GROUP BY DEPTNO);

-- EX. �޿� 3000�̻� �޴� ����� �Ҽӵ� �μ����� �ٹ��ϴ� ����� ��� ���� 
SELECT DEPTNO FROM EMP WHERE SAL>= 3000; --������ 
SELECT * FROM EMP WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE SAL>= 3000);

--(2) ALL : �������� ����� ��� �����ؾ� ��
    --EX.30�� �μ��� �ִ� �ִ�޿����� ū �޿��� ����� ��� �ʵ� 
SELECT SAL FROM EMP WHERE DEPTNO = 30; -- �������� (������)
SELECT * FROM EMP WHERE SAL > ALL (SELECT SAL FROM EMP WHERE DEPTNO = 30);-- > ALL ���� ��� ������ Ŀ���Ѵ� 

-- ���� ������ ���������� ������ ����������
SELECT MAX(SAL) FROM EMP WHERE DEPTNO=30; --��������
SELECT * FROM EMP WHERE SAL > (SELECT MAX(SAL) FROM EMP WHERE DEPTNO=30); 

-- (3) ANY=SOME : �������� ����� �ϳ��� �����ϸ� ��
    -- EX. 30�� �μ� �޿��� �� ��� �ϳ��� ������ ū��� (�ּұ޿����� ū���) ������ ����ʵ�
SELECT SAL FROM EMP WHERE DEPTNO = 30; --�������� (������)
SELECT * FROM EMP WHERE SAL > ANY (SELECT SAL FROM EMP WHERE DEPTNO = 30); --�������� 
    --���������� ������ �����������
SELECT * FROM EMP WHERE SAL > (SELECT MIN(SAL) FROM EMP WHERE DEPTNO=30);

--(4) EXISTS : �������� ����� �����ϸ� �� 
    --EX. ���Ӻ��ϰ� �ִ� �������� ���, �̸�, �޿�

SELECT EMPNO, ENAME, SAL 
    FROM EMP MANAGER
    WHERE EXISTS (SELECT * FROM EMP WHERE MANAGER.EMPNO=MGR);

SELECT DISTINCT M.EMPNO, M.ENAME, M.SAL  --SELF JOIN
    FROM EMP W, EMP M
    WHERE W.MGR= M.EMPNO ;


    -- EX. ���� ����� ��� �ʵ� ���
SELECT * 
    FROM EMP MANAGER 
    WHERE NOT EXISTS (SELECT *FROM EMP WHERE MANAGER.EMPNO = MGR);

SELECT M.*
    FROM EMP W, EMP M
    WHERE W.MGR(+) = M.EMPNO AND W.ENAME IS NULL; -- SELF JOIN �̿�

--źź1.�μ����� ���� �޿��� ���� �޴� ����� ����(��� ��ȣ, ����̸�, �޿�, �μ���ȣ)�� ���(IN ������ �̿�)
SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO; -- ��������
SELECT EMPNO, ENAME, SAL, DEPTNO
    FROM EMP
    WHERE (DEPTNO, SAL) IN (SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO);

--źź2. ����(JOB)�� MANAGER�� ����� ���� �μ��� �μ� ��ȣ�� �μ���� ������ ���(IN)
SELECT DEPTNO FROM EMP WHERE JOB = 'MANAGER';
SELECT DEPTNO, DNAME, LOC 
    FROM DEPT
    WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE JOB = 'MANAGER');

--źź3. SAL�� 3000�̻��� ����� �� SAL ����� ����� 
--         �ش� ��޺� �ְ� ������ �޴� ������� ���, �̸�, ����, �Ի���, �޿�, �޿������ ���

SELECT ENAME, GRADE
    FROM EMP, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL AND SAL >= 3000;

SELECT EMPNO, ENAME, JOB, HIREDATE, SAL, GRADE
    FROM EMP, SALGRADE
    WHERE (GRADE, SAL) IN (SELECT GRADE, MAX(SAL) FROM EMP, SALGRADE 
                                  WHERE SAL BETWEEN LOSAL AND HISAL GROUP BY GRADE) AND SAL >= 3000;

-- źź4. �����ȭ : �Ի��� �б⺰�� ���� ���� ������ �޴� ������� �б�, ���, �̸�, JOB, �����, �Ի���, �޿�, �󿩸� ����ϼ���
-- �б� ������ MM/3�� �ø�
SELECT HIREDATE, CEIL(EXTRACT(MONTH FROM HIREDATE)/3) "QUARTER" FROM EMP;
SELECT HIREDATE, CEIL(TO_CHAR(HIREDATE, 'MM')/3) "QUARTER" FROM EMP;
SELECT HIREDATE, TO_CHAR(HIREDATE, 'Q') "QUARTER" FROM EMP;

SELECT CEIL(EXTRACT(MONTH FROM HIREDATE)/3), MAX(SAL) 
    FROM EMP 
    GROUP BY CEIL(EXTRACT(MONTH FROM HIREDATE)/3);

SELECT CEIL(EXTRACT(MONTH FROM HIREDATE)/3) "QUARTER", EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM
    FROM EMP
    WHERE (CEIL(EXTRACT(MONTH FROM HIREDATE)/3), SAL) IN 
             (SELECT CEIL(EXTRACT(MONTH FROM HIREDATE)/3), MAX(SAL)
                FROM EMP
                GROUP BY CEIL(EXTRACT(MONTH FROM HIREDATE)/3))
    ORDER BY "QUARTER";

-- źź 5. SALESMAN ��� ����� ���� �޿��� ���� �޴� ������� �̸��� �޿��� ����(��� ����)�� ����ϵ� ���� ����� ������� �ʴ´�.(ALL�̿�
SELECT SAL FROM EMP WHERE JOB = 'SALESMAN';
SELECT ENAME, SAL, JOB
    FROM EMP
    WHERE SAL > ALL (SELECT SAL FROM EMP WHERE JOB='SALESMAN') AND JOB != 'SALESMAN'; 
SELECT ENAME, SAL, JOB
    FROM EMP
    WHERE SAL >(SELECT MAX(SAL) FROM EMP WHERE JOB='SALESMAN') AND JOB != 'SALEMAN';

--źź6. SALESMAN����� � �� ������� �޿��� ���� �޴� ������� �̸��� �޿��� ����(��� ����)�� ����ϵ� ���� �����  ��������ʴ´�.(ANY)
SELECT SAL FROM EMP WHERE JOB = 'SALESMAN';
SELECT ENAME, SAL, JOB
    FROM EMP
    WHERE SAL > ANY (SELECT SAL FROM EMP WHERE JOB='SALESMAN') AND JOB != 'SALESMAN'; 
SELECT ENAME, SAL, JOB
    FROM EMP
    WHERE SAL > (SELECT MIN(SAL) FROM EMP WHERE JOB='SALESMAN') AND JOB != 'SALESMAN';

-- źź7  ������ 3000�̸��� ��� �߿� ���� �ֱٿ� �Ի��� ����� �����ȣ�� �̸�, ����, �Ի����� ���
SELECT MAX(HIREDATE) FROM EMP WHERE SAL<3000;
SELECT EMPNO, ENAME, SAL, HIREDATE
    FROM EMP
    WHERE HIREDATE = (SELECT MAX(HIREDATE) FROM EMP WHERE SAL <3000); -- �������� 

-- źź 8 ������ ��SALESMAN���� ����� �޴� �޿��� �ּ� �޿����� ���� �޴� ������� �̸�, �޿�, ����, �μ���ȣ�� ����ϵ�
-- �μ���ȣ�� 20���� ����� �����Ѵ�(ANY ������ �̿�)
SELECT SAL FROM EMP WHERE JOB = 'SALESMAN'; --��������
SELECT ENAME, SAL, JOB, DEPTNO
    FROM EMP
    WHERE SAL > ANY(SELECT SAL FROM EMP WHERE JOB = 'SALESMAN')AND DEPTNO != 20;

--����
-- 14.  �̸��� ��T���� �ִ� ����� �ٹ��ϴ� �μ����� �ٹ��ϴ� ��� ������ ��� ��ȣ,�̸�,�޿�(�� ��� �� ���)
SELECT DEPTNO FROM EMP WHERE ENAME LIKE '%T%';
SELECT EMPNO, ENAME, SAL 
    FROM EMP
    WHERE DEPTNO =ANY (SELECT DEPTNO FROM EMP WHERE ENAME LIKE '%T%')
    ORDER BY EMPNO;
SELECT * FROM EMP;
-- 15. �μ� ��ġ�� Dallas�� ��� �������� ���� �̸�,����,�޿�
SELECT DEPTNO FROM DEPT WHERE LOC = 'DALLAS'; 
SELECT ENAME, JOB, SAL 
    FROM EMP
    WHERE DEPTNO =  (SELECT DEPTNO FROM DEPT WHERE LOC = 'DALLAS');
-- 16. EMP ���̺��� King���� �����ϴ� ��� ����� �̸��� �޿�
SELECT ENAME, SAL
    FROM EMP
    WHERE MGR =(SELECT EMPNO FROM EMP WHERE ENAME='KING');
-- 17. SALES�μ� ����� �̸�, ����
SELECT ENAME, JOB
    FROM EMP
    WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE DNAME = 'SALES'); 
-- 18. ������ �μ� 30�� ���� ���޺��� ���� ����� ��� �ʵ�
SELECT *
    FROM EMP
    WHERE SAL >= (SELECT MIN(SAL) FROM EMP WHERE DEPTNO = 30);
-- 19. �μ� 10���� �μ� 30�� ����� ���� ������ �ð� �ִ� ����� �̸��� ����
SELECT ENAME, JOB
    FROM EMP 
    WHERE JOB IN (SELECT JOB FROM EMP WHERE DEPTNO = '30' ) AND DEPTNO = '10'; 
-- 20.  FORD�� ������ ���޵� ���� ����� ��� �ʵ�
SELECT *
    FROM EMP
    WHERE (JOB, SAL) IN (SELECT JOB, SAL FROM EMP WHERE ENAME = 'FORD');
-- 21. �̸��� JONES�� ������ JOB�� ���ų�R FORD�� SAL �̻��� �޴� ����� ������ �̸�, ����, �μ���ȣ, �޿�
    -- ��, ������ ���ĺ� ��, ������ ���� ������ ���
SELECT ENAME, JOB, DEPTNO, SAL 
    FROM EMP
    WHERE JOB = (SELECT JOB FROM EMP WHERE ENAME = 'JONES') 
       OR SAL > (SELECT SAL FROM EMP WHERE ENAME = 'FORD')   
    ORDER BY JOB, SAL DESC;
-- 22. SCOTT �Ǵ� WARD�� ������ ���� ����� ������ �̸�,����,�޿�
SELECT ENAME, JOB, SAL
    FROM EMP
    WHERE SAL IN (SELECT SAL FROM EMP WHERE ENAME = 'SCOTT' OR ENAME ='WARD') AND ENAME NOT IN ('SCOTT', 'WARD'); 
-- 23. CHICAGO���� �ٹ��ϴ� ����� ���� ������ �ϴ� ������� �̸�,����
SELECT ENAME, JOB
    FROM EMP
    WHERE JOB = ANY (SELECT JOB FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO AND LOC = 'CHICAGO');
-- 24. �μ������ ���޺��� ���� ����� ���, �̸�, �޿�, �μ���ȣ
SELECT E.EMPNO, E.ENAME, E.SAL, E.DEPTNO 
    FROM EMP E
    WHERE SAL > (SELECT AVG(SAL) 
                            FROM EMP E2 
                            WHERE E.DEPTNO = E2.DEPTNO); -- �������� �̿� 
    --���� �񱳱��� �μ���ȣ�� ������� 
SELECT EMPNO, ENAME, SAL, A.DEPTNO, A.AVG
    FROM EMP E, (SELECT DEPTNO, AVG(SAL) "AVG" FROM EMP GROUP BY DEPTNO) A
    WHERE E.DEPTNO = A.DEPTNO AND SAL > AVG; -- INLINE VIEW �̿�

 -- �ش� �μ� ��պ��� ���� ����� ���� - ���, �̸�, �޿�, �μ���ȣ, �ش� �μ��� ���(�Ҽ��� 2�ڸ�)
SELECT EMPNO, ENAME, SAL, DEPTNO,ROUND((SELECT AVG(SAL) FROM EMP WHERE DEPTNO=E.DEPTNO),2) "AVG" 
    FROM EMP E
    WHERE SAL > (SELECT AVG(SAL) FROM EMP WHERE DEPTNO=E.DEPTNO); --�������� 

SELECT EMPNO, ENAME, SAL, E.DEPTNO "AVG"
    FROM EMP E, (SELECT DEPTNO, AVG(SAL) "AVG" FROM EMP GROUP BY DEPTNO) A
    WHERE E.DEPTNO = A.DEPTNO AND SAL>AVG; -- INLINVE VIEW �̿�
 
    
-- 25. �������� ��� ���޺��� ���� ������ �޴� ����� �μ���ȣ, �̸�, �޿�
SELECT E.EMPNO, E.ENAME, E.SAL, E.DEPTNO 
    FROM EMP E
    WHERE SAL < (SELECT AVG(SAL) 
                            FROM EMP E2 
                            WHERE E2.JOB = E.JOB); --��������

                            
-- 26. ��� �� �� �̻����κ��� ���� ���� �� �ִ� ����� ����, �̸�, ���, �μ���ȣ�� ���(��, �μ���ȣ ������ �������� ����)
SELECT DISTINCT E.ENAME, E.JOB, E.ENAME, E.EMPNO, E.DEPTNO 
    FROM EMP E, EMP E2
    WHERE E.EMPNO IN (SELECT E.EMPNO FROM EMP WHERE E.EMPNO = E2.MGR);
--IN = OR������ 



SELECT JOB, ENAME, EMPNO, DEPTNO 
    FROM EMP M
    WHERE EXISTS (SELECT * FROM EMP WHERE MGR=M.EMPNO);
    
-- 27.  ���� ����� ���, �̸�, ����, �μ���ȣ
SELECT E.ENAME, E2.EMPNO, E2.ENAME, E2.JOB, E2.DEPTNO 
    FROM EMP E, EMP E2 
    WHERE E.MGR(+) = E2.EMPNO AND E.ENAME IS NULL;

SELECT * FROM EMP;

SELECT JOB, ENAME, EMPNO, DEPTNO
    FROM EMP
    WHERE EMPNO NOT IN (SELECT NVL(MGR,0) FROM EMP);



















