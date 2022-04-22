--1. ������ ���̺��� ����� ����ϴ� SQL���� �ۼ��Ͻÿ�(5��).
SELECT * FROM TAB;
--2. TO_DATE �������Լ��� �̿��Ͽ� EMP ���̺����� HIREDATE�� 1981�� 2�� 20�Ϻ��� 1981�� 5�� 1�� ���̿� �Ի��� ����� �����, ��å, �Ի�����
--�����Ի��Ϻ��� �ֱ��Ի��� ������ �����Ͽ� ����ϴ� SQL���� �ۼ��Ͻÿ�(5��).
SELECT ENAME, JOB, TO_DATE(HIREDATE, 'YY/MM/DD' ) "�Ի���"
    FROM EMP
    WHERE HIREDATE BETWEEN '81/02/20' AND '81/05/01' ORDER BY HIREDATE DESC;
    
SELECT ENAME, JOB, TO_DATE(HIREDATE, 'YYYY/MM/DD' )
    FROM EMP
    WHERE TO_DATE(HIREDATE, 'YYYY/MM/DD') <= '81/02/20' AND 
            TO_DATE(HIREDATE, 'YYYY/MM/DD') >= '81/05/01'
    ORDER BY HIREDATE DESC;
    
--3. EMP���̺��� DEPT���̺��� self join�� outer join�� �̿��Ͽ� �����, �޿�, �μ���ȣ, �μ���, �ٹ���, ���ӻ����� ��簡 ���� �������� ��ü ���� �� ����ϴ� SQL���� �ۼ��Ͻÿ�. ��, ��簡 ���� ��� ���� ��� ���������� ����Ѵ�(5��).
SELECT W.ENAME, W.SAL, W.DEPTNO, DNAME, LOC, NVL(M.ENAME, '����') "���"
    FROM EMP W, EMP M, DEPT D
    WHERE W.MGR= M.EMPNO(+) AND W.DEPTNO = D.DEPTNO;
--4. SALGRADE ���̺��� LOSAL�� ������� �޿�, HISAL�� ��� �ְ� �޿��� �̿��Ͽ�, EMP ���̺��� ����� ���, �����, ��å, �޿�, �޿������
--�޿� ���� ������������ �����Ͽ� ����ϴ� SQL���� �ۼ��Ͻÿ�(5��).
SELECT EMPNO, ENAME, JOB, SAL, GRADE
    FROM EMP, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL
    ORDER BY SAL DESC;
--5. EMP ���̺����� �μ���ȣ�� 20���� ����� ���, �����, �޿��� ����ϵ� �޿� �տ��� $�� ���̰�, ���ڴ� 3�ڸ����� �޸�( , )�� �߰��Ͽ� ����ϴ� SQL���� �ۼ��Ͻÿ�. 
--�� �޿�(SAL)�� Ÿ���� NUMBER(7,2)�� �Ѵ�(5��).
SELECT EMPNO, ENAME, TO_CHAR(SAL, '$999,999.99') "SAL"
    FROM EMP 
    WHERE DEPTNO = 20;
--6. EMP ���̺����� ��å�� �޿� ����� 3000�̻��� ��å�� ���Ͽ� �����, ��ձ޿�, �ݿ��� ���� ����ϴ� SQL���� �ۼ��Ͻÿ�(5��).
SELECT JOB, AVGSAL, SUMSAL 
    FROM(SELECT JOB, AVG(SAL) "AVGSAL", SUM(SAL) "SUMSAL" FROM EMP GROUP BY JOB)
    WHERE AVGSAL >= 3000;
--7. EMP���̺����� ������� ��FORD���� ������ ��å(JOB)�� �޿�(SAL)�� ���� ����� ��� ������ ����ϴ� SQL���� �ۼ��Ͻÿ�(5��).
SELECT *
    FROM EMP
    WHERE (JOB, SAL)IN(SELECT JOB, SAL FROM EMP WHERE ENAME = 'FORD');
--8. EMP ���̺����� ������� ��FORD���� ����� �����ϴ� SQL���� �ۼ��Ͻÿ�(5��).
DELETE FROM EMP WHERE ENAME = 'FORD';
ROLLBACK;
COMMIT;
--9. �����ͺ��̽����� Ʈ������� ������ ó���� �� ������ ���Ѵ�. �����͸� �����ϱ� ���� INSERT, UPDATE, DELETE ���� ���ɵ��� ����ʰ� ���ÿ� Ʈ������� ����Ǵµ�
-- , �̵� INSERT, UPDATE, DELETE�۾��� ���������� �����ͺ��̽��� �ݿ���ó���ǵ��� ���ɾ �ۼ��Ͻÿ�(5��).
COMMIT;
--10. EMP���̺����� ��������� ��ȸ�ϴ� �ð��� �����ϱ� ���� ���Ǵ� �ε��� ���� ���ɾ �ۼ��Ͻÿ�. ������ �ε����� �̸��� IDX_EMP_ENAME���� �Ѵ�(10��).
CREATE INDEX IDX_EMP_ENAME ON EMP(ENAME);
--11. ���� ���� ������ ���̺��� ���� ������ ������ ������ ��ųʸ��並 ���캸�� SQL���� �ۼ��Ͻÿ�(5��).
SELECT * FROM USER_VIEWS;