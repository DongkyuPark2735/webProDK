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

























































