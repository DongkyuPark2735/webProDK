--[5��] �׷��Լ� : SUM, AVG, MIN, MAX, COUNT, STDDEV(ǥ������), VARIANCE(�л�)

SELECT ENAME, ROUND(SAL, -3) FROM EMP; -- ������ �Լ�
SELECT MAX(SAL) FROM EMP;                     -- �׷��Լ�  EMP���̺��� SAL ���� ���� ������ 
SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO; -- �׷��Լ� �׷캰�� �������� �ݵ�� GROUP BY�Լ� 
--SELECT ENAME, MAX(SAL) FROM EMP; --����(������� ������) �ִ�޿��� �޴»���� �̸�(6�� ��������)   GROUP BY ENAME; 


--1. �׷��Լ� �ǽ�

SELECT ROUND(AVG(SAL),2) FROM EMP; --�׷��� �Լ� ����� ������
SELECT COUNT (*) FROM EMP; -- EMP���̺��� ��(�ο�ROW)�� --�׷��Լ��� �Ű����� �ݵ�� 
SELECT AVG(SAL), SUM(SAL)/COUNT(SAL) FROM EMP;
SELECT COMM FROM EMP;   --300+500+1400+0 (2200) 1. 2200/14 = 157.XX  2. 2200/4 = 550
SELECT SUM(COMM), AVG(COMM), COUNT(COMM), MIN(COMM), MAX(COMM) FROM EMP; -- ��� �׷��Լ��� NULL�� �����ϰ� ���
--SAL�� ���, ��, �ּұ޿�, �ִ�޿�, �޿��л�, �޿�ǥ������, ����
SELECT AVG(SAL), SUM(SAL), MIN(SAL), MAX(SAL), VARIANCE(SAL), STDDEV(SAL) FROM EMP;
-- 2100 - 1200 ~ 2100 + 1200(68%)
SELECT SQRT(VARIANCE(SAL)), STDDEV(SAL) FROM EMP; 




-- �׷��Լ� MIN, MAX, COUNT�� ������, ������, ��¥�� ����
SELECT MIN(ENAME), MAX(ENAME), COUNT(ENAME), COUNT(COMM) FROM EMP;

-- źź 1. �����ֱٿ� �Ի��� ����� �Ի��ϰ�, ���� �����Ի��� ����� �Ի��� 
SELECT MIN(HIREDATE), MAX(HIREDATE), COUNT(HIREDATE) FROM EMP;
-- źź 2. 83/01/12 �ֱ��Ի��� : XX, XXX�� �ٹ�, 80/12/17 �����Ի��� : XX,XXX�� �ٹ� 
SELECT MAX(HIREDATE) || ' �ֱ��Ի��� : '|| TO_CHAR(SYSDATE-MAX(HIREDATE), '999,999') || '�� �ٹ�' "�Ի���",
           MIN(HIREDATE) || ' �����Ի��� : '|| TO_CHAR(TRUNC(SYSDATE-MIN(HIREDATE)), '999,999') ||'�� �ٹ�' "�Ի���"
    FROM EMP;
SELECT MAX(HIREDATE) || '�ֱ��Ի��� : ' || TO_CHAR(MIN(SYSDATE-HIREDATE), 999,999) || '�� �ٹ� ' 
|| MIN(HIREDATE) || ' ���� �Ի��� : ' || TO_CHAR(MAX(SYSDATE-HIREDATE), 999,999) || '�� �ٹ� '
FROM EMP;
--10�� �μ��Ҽ��� ��� �޿� ���
SELECT TRUNC(AVG(SAL)) FROM EMP WHERE DEPTNO = 10; 


-- 2. GROUP BY ��
-- �μ���ȣ�� �ִ�޿�, �ּұ޿�, �޿����, �޿��� 
--�������Լ��� �׷��Լ� ���̾����� GROUP BY�� ����� �������Լ��̸��� �׷���� �� �̸� ���ƾ���
--�׷�������� ����� (��Ī) ���Ұ� 
SELECT DEPTNO "�μ�", MAX(SAL), MIN(SAL), TRUNC(AVG(SAL)) FROM EMP GROUP BY DEPTNO;
    --EX. SAL�� 5000�̸��� ����� ���ؼ��� �μ���ȣ�� �����, �ִ�޿�, �ּұ޿�, ��ձ޿�(�μ���ȣ�� ����)
SELECT DEPTNO "�μ�", COUNT(*), MAX(SAL), MIN(SAL), TRUNC(AVG(SAL)) -- SELECT �������� �ʵ� ��Ī ��밡��
    FROM EMP 
    WHERE SAL<5000  -- WHERE�������� �ʵ� ��Ī ��� �Ұ�
    GROUP BY DEPTNO -- GROUP BY�������� �ʵ� ��Ī ���Ұ�
    ORDER BY "�μ�"; -- ORDER BY�������� �ʵ� ��Ī ��밡��
    --EX. �μ��� �����, �ִ�޿�, �ּұ޿�, ��ձ޿� (����� ���� ������ ����)
SELECT DNAME, COUNT(*), MAX(SAL), MIN(SAL), TRUNC(AVG(SAL)) 
    FROM EMP E, DEPT D 
    WHERE E.DEPTNO = D.DEPTNO
    GROUP BY DNAME
    ORDER BY COUNT(*) DESC;


-- 3. HAVING�� : �׷��Լ� ����� ����, ��Ī ���Ұ� 
-- �μ���ȣ�� ��� �޿� (��ձ޿��� 2000�̻��� �μ��� ���)
SELECT DEPTNO, TRUNC(AVG(SAL)) "AVG"
    FROM EMP
--  WHERE AVG(SAL)>= 2000 --WHERE������ �׷��Լ� ���� ����. SELECT �������� �׷��Լ� ���� 
    GROUP BY DEPTNO
    HAVING AVG(SAL) >= 2000
    ORDER BY "AVG";

--SAL�� 5000�̸��� ����� ���� �μ��� �ּұ޿�, �ִ�޿�, 
--��ձ޿�(��, ��ձ޿��� 1800�̻��� �μ��� ���ؼ� ��ձ޿������� ���� ���) 
SELECT D.DNAME, MIN(SAL), MAX(SAL), TRUNC(AVG(SAL))
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND SAL < 5000 
    GROUP BY DNAME 
    HAVING AVG(SAL) > 1800
    ORDER BY AVG(SAL);



--4. ��� ������ �� ���谪 ���� ROLLUP ���� �׷��׸� 
SELECT DEPTNO, SUM(SAL) FROM EMP GROUP BY ROLLUP(DEPTNO);
    -- �μ���, JOB�� �޿���
SELECT DEPTNO, JOB, SUM(SAL) 
    FROM EMP 
    GROUP BY DEPTNO, JOB 
    ORDER BY DEPTNO;
    --�μ���, JOB�� �޿���( �Ұ�� ��ü�� ����)
SELECT DEPTNO, NVL(JOB ,'��'), SUM(SAL) 
    FROM EMP
    GROUP BY ROLLUP(DEPTNO, JOB);


-- ��<�� ��������>

-- 1. �ο���,�ִ� �޿�,�ּ� �޿�,�޿��� ���� ���
SELECT COUNT(*), MAX(SAL), MIN(SAL), SUM(SAL)
    FROM EMP;
-- 2. ������ �ο����� ���Ͽ� ���
SELECT JOB, COUNT(*)
    FROM EMP
    GROUP BY JOB;
--- 3. �ְ� �޿��� �ּ� �޿��� ���̴� ���ΰ� ���
SELECT MAX(SAL), MIN(SAL), MAX(SAL)-MIN(SAL)
    FROM EMP;
-- 4. �� �μ����� �ο���, �޿� ���, ���� �޿�, �ְ� �޿�, �޿��� ���� ���(�޿��� ���� ���� ������)
SELECT DEPTNO, COUNT(*), TRUNC(AVG(SAL)), MIN(SAL), MAX(SAL), SUM(SAL) 
    FROM EMP E
    GROUP BY DEPTNO
    ORDER BY SUM(SAL);
-- 5. �μ���, ������ �׷��Ͽ� ����� �μ���ȣ, ����, �ο���, �޿��� ���, �޿��� ���� ���(�μ���ȣ, ���������� �������� ����)
SELECT DEPTNO, JOB, COUNT(*), AVG(SAL), SUM(SAL)
    FROM EMP
    GROUP BY DEPTNO, JOB
    ORDER BY DEPTNO, JOB;
-- 6. ������, �μ��� �׷��Ͽ� �����  ����, �μ���ȣ, �ο���, �޿��� ���, �޿��� ���� ���(��°���� ������, �μ���ȣ �� �������� ����)
SELECT JOB, DEPTNO, COUNT(*), TRUNC(AVG(SAL)), SUM(SAL)
    FROM EMP
    GROUP BY JOB, DEPTNO
    ORDER BY JOB, DEPTNO;
--7. ������� 5���̻� �Ѵ� �μ���ȣ�� ������� ���
SELECT DEPTNO, COUNT(*)
    FROM EMP
    GROUP BY DEPTNO
    HAVING COUNT(*) >= 5;
    
-- 8. ������� 5���̻� �Ѵ� �μ���� ������� ���
SELECT DNAME, COUNT(*)
    FROM DEPT D, EMP E
    WHERE D.DEPTNO = E.DEPTNO
    GROUP BY DNAME
    HAVING COUNT(*) >= 5;
    
--9. ������ �޿��� ����� 3000�̻��� ������ ���ؼ� ������, ��� �޿�, �޿��� ���� ���
SELECT JOB, AVG(SAL), SUM(SAL)
    FROM EMP 
    GROUP BY JOB
    HAVING AVG(SAL)>= 3000;    
--10. �޿� ���� 5000�� �ʰ��ϴ� �� ������ ���ؼ� ������ �޿����� ���(�޿� �հ�� �������� ����)
SELECT JOB, SUM(SAL)
    FROM EMP
    GROUP BY JOB
    HAVING SUM(SAL) > 5000
    ORDER BY SUM(SAL);

--11. �μ��� �޿����, �μ��� �޿��հ�, �μ��� �ּұ޿��� ���
SELECT  DEPTNO, TRUNC(AVG(SAL)), SUM(SAL), MIN(SAL) 
    FROM EMP
    GROUP BY DEPTNO;
    
--12. ���� 11���� �����Ͽ�, �μ��� �޿���� �ִ�ġ, �μ��� �޿����� �ִ�ġ, �μ��� �ּұ޿��� �ִ�ġ�� ���
SELECT MAX(TRUNC(AVG(SAL))), MAX(SUM(SAL)), MAX(MIN(SAL))
    FROM EMP
    GROUP BY DEPTNO;
    
--13. ��� ���̺��� �Ʒ��� ����� ���
--   H_YEAR	COUNT(*)	MIN(SAL)	MAX(SAL)	AVG(SAL)	SUM(SAL)
    --     80	  1		          800		        800		     800	       800
    --	   81	 10		    950		         5000	          2282.5	     22825
    --	    82	  2	     	    1300	           3000	           2150		 4300
     --  	83	  1		      1100	            1100	          1100	    1100
SELECT TO_CHAR(HIREDATE, 'YY'), COUNT(*), MIN(SAL), MAX(SAL), AVG(SAL), SUM(SAL)
    FROM EMP
    GROUP BY TO_CHAR(HIREDATE, 'YY')
    ORDER BY TO_CHAR(HIREDATE, 'YY');
    
-- 14.  �Ʒ��� ����� ���(�Ի�⵵�� �����)
--  1980     1	
--  1981     10
--  1982     2
--  1983     1
--  total    14	
SELECT NVL(TO_CHAR(HIREDATE, 'YYYY'), 'TOTAL') "�⵵", COUNT(*)
    FROM EMP
    GROUP BY ROLLUP(TO_CHAR(HIREDATE, 'YYYY'));
    
--15. �ִ�޿�, �ּұ޿�, ��ü�޿���, ����� ���
SELECT MAX(SAL), MIN(SAL), SUM(SAL), TRUNC(AVG(SAL)) 
    FROM EMP;
    
--16. �μ��� �ο��� ���
SELECT DEPTNO, COUNT(*)
    FROM EMP
    GROUP BY DEPTNO;
--17. �μ��� �ο����� 6���̻��� �μ���ȣ ���
SELECT DEPTNO, COUNT(*)
    FROM EMP
    GROUP BY DEPTNO
    HAVING COUNT(*) >= 6;
--18. �޿��� ���� ������� ����� �ο��Ͽ� ������ ���� ����� ������ �Ͻÿ�. 
-- (��Ʈ self join, group by, count���)
--ENAME	    ���
--________________________
--KING		1
--SCOTT		2
--����
SELECT E1.ENAME,E1.SAL, COUNT(E1.SAL) "���"
    FROM EMP E1, EMP E2
    WHERE E1.SAL < E2.SAL
    GROUP BY E1.ENAME, E1.SAL
    ORDER BY E1.SAL DESC;

SELECT E1.ENAME, E1.SAL, E2.ENAME, E2.SAL
    FROM EMP E1, EMP E2
    WHERE  E1.SAL < E2.SAL(+); -- 1�ܰ� : SELFP JOIN /OUTER JOIN

SELECT E1.ENAME, E1.SAL, COUNT(E2.ENAME)+1 "���� ���� �޴� �����"
    FROM EMP E1, EMP E2
    WHERE  E1.SAL < E2.SAL(+) 
    GROUP BY E1.ENAME, E1.SAL
    ORDER BY COUNT(E2.ENAME)+1;

SELECT ENAME, RANK() OVER(ORDER BY SAL DESC) "���" ,
        DENSE_RANK() OVER(ORDER BY SAL DESC)"DENSE_RANK",
        ROW_NUMBER() OVER(ORDER BY SAL DESC) "ROW_NUMBER"
        FROM EMP;






























