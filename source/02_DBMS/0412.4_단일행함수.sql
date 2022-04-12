-- 4 ������ �Լ� : �����Լ� .SQL �ֿ��Լ�
-- �Լ� = �������Լ� + �׷��Լ�(�����Լ�)
    -- ������ �Լ� (INPUT 1�� -> OUTPUT1��)
SELECT HIREDATE, TO_CHAR(HIREDATE, 'YY"��"MM"��"DD"��"') --""�� �ؼ������ʰ� ��� 
    FROM EMP;

SELECT ENAME, INITCAP(ENAME) FROM EMP; -- ������ �Լ�
    --�׷��Լ� (INPUT N�� -> OUTPUT 1��)
SELECT SUM(SAL), AVG(SAL) FROM EMP; --��ü SAL ��
SELECT DEPTNO, SUM(SAL) FROM EMP GROUP BY DEPTNO; --�μ��� SAL��

-- �������Լ� ���� : ���ڰ��� �Լ�, ���ڰ��� �Լ�, ��¥�����Լ�(�����), ����ȯ �Լ� , NVL(), ETC,... 
--1. ���ڰ��� �Լ� 
    --DUAL ���̺� : ����Ŭ���� �����ϴ� 1��1��¥�� DUMMY TABLE (cf) DUMMY
SELECT -9, ABS(-9) FROM EMP; --EMP���� ���پ� �����ͼ� SELECT �Ѹ���

SELECT * FROM DUMMY;
DESC DUMMY ; -- ���� �˻� 
SELECT * FROM DUAL;

SELECT -9, ABS(-9) FROM DUAL; --���밪 
SELECT FLOOR(34.5678) FROM DUAL; -- �Ҽ������� ����
SELECT FLOOR(34.5678*100)/100 FROM DUAL; -- �Ҽ��� �ι�°�ڸ����� ���� 
SELECT TRUNC(34.5678,2) FROM DUAL; --TRUNC( , )������ ���¼��� �Ҽ��� ������ �ڸ�
SELECT TRUNC(34.5678) FROM DUAL; -- �Ҽ������� ����
SELECT TRUNC(34, -1) FROM DUAL; -- �����ڸ����� ���� 

   --EX. EMP���̺��� �̸� ,�޿�(���� �ڸ����� ����)
SELECT ENAME,SAL, TRUNC(SAL, -2) "����" FROM EMP;  

SELECT CEIL(34.5678) FROM DUAL; --�Ҽ������� �ø�
SELECT CEIL(34.5678 * 100) /100 FROM DUAL; --�Ҽ��� �ι�°�ڸ����� �ø�

SELECT ROUND(34.5678) FROM DUAL; --�Ҽ������� �ݿø�
SELECT ROUND(34.5678, 2) FROM DUAL; --�Ҽ������� �ι�° �ڸ����� �ݿø�
SELECT ROUND(34.5678, -1) FROM DUAL; --���� �ڸ����� ���ø�

SELECT MOD(9, 2) FROM DUAL; --������ ������ 9%2
    --EX. ����� Ȧ���� ����� ��� �ʵ� ���
SELECT * 
    FROM EMP
    WHERE MOD(EMPNO, 2) != 0; 
    --EX. Ȧ���޿� �Ի��� ����� ��� �ʵ� ���
SELECT * 
    FROM EMP
    WHERE MOD(TO_CHAR(HIREDATE, 'MM'), 2) = 1;  --���� ����

--2. ���� ���� �Լ� 
--(1) ��ҹ��� ����
SELECT UPPER('abcABC') FROM DUAL;
SELECT LOWER('abcABC') FROM DUAL;
SELECT INITCAP('WELCOM TO ORACLE') FROM DUAL; --�ܾ� ���� ù�ܾ �빮�� ������ �ҹ��ڷ� 
    --EX. JOB�� 'MANAGER'�� ������ ��� �ʵ�
SELECT *
    FROM EMP
    WHERE UPPER(JOB) = 'MANAGER'; --�ش��ʵ尡 �빮������ �ҹ��������𸦶� �빮�ڷ� ��ȯ�Ͽ� ��� ���ܾ��� 
SELECT * FROM EMP WHERE LOWER(JOB) = 'manager';

--(2) ���ڿ���(COMCAT, || ������)
SELECT 'AB' ||'CD'||'EF'||'GH' FROM DUAL; --���Ῥ���ڴ� �����̾��µ�
SELECT CONCAT('AB','CD','EF','GF') FROM DUAL; -- CONCAT���Ű����� 2���� ���� 
SELECT CONCAT(CONCAT('AB','CD'), CONCAT('EF','GF')) FROM DUAL;
    -- �ƹ���(NAME)�� XX(JOB)�̴� �������� EMP���̺� ���� ���
SELECT CONCAT(CONCAT(ENAME, '��'), CONCAT(JOB, '�̴�')) 
    FROM EMP;
--(3) SUBSTR(STR, ������ġ, ���ڰ���) ù��° ��ġ�� 1, ������ġ �������� 
--    SUBSTRB(STR, ���۹���Ʈ ��ġ, ���� ����Ʈ��)
--  O R A C L E
--  1 2 3 4 5 6
-- -6-5-4-3-2-1
SELECT SUBSTR('ORACLE', 3,2) FROM DUAL; --3��° ���ں��� 2���� ����
SELECT SUBSTRB('ORACLE', 3,2) FROM DUAL; --3��° ����Ʈ���� 2����Ʈ ����
SELECT SUBSTR('�����ͺ��̽�',4,3) FROM DUAL;--4��° ���ں��� 3���� ����
SELECT SUBSTRB('�����ͺ��̽�',4,5) FROM DUAL; --4��° ����Ʈ���� 3����Ʈ ����(XE���������� �ѱ�1���ڴ� �й���Ʈ)
SELECT SUBSTRB('ȫ�浿', 3,3)FROM DUAL;
SELECT SUBSTRB('ABCDEF', -1,1)FROM DUAL;
SELECT SUBSTR(123,2,1) FROM DUAL;--  ���ڵ� ����
--EX. 9���� �Ի��� ����� ����ʵ� (��, DATA��� FORMAT'RR/MM/DD')
SELECT * FROM EMP WHERE SUBSTR(HIREDATE,4, 2)='09';
--EX 9�Ͽ� �Ի��� ����� ����ʵ� 
SELECT * FROM EMP WHERE SUBSTR(HIREDATE,-2, 2)='09';

--(4) ���ڼ� (LENGTH) VS ����Ʈ��(LENGTHB)
SELECT LENGTH('ABD') FROM DUAL; --���ڼ� : 3
SELECT LENGTHB('ABD') FROM DUAL; -- ����Ʈ�� :3
SELECT LENGTH('����Ŭ') FROM DUAL; -- ���ڼ� : 3
SELECT LENGTHB('����Ŭ') FROM DUAL; --����Ʈ�� : 9

--(5)INSTR(STR, ã������) : STR���� ã�� ������ ��ġ(ù��° 1), ������ 0
--    INSTR(STR , ã������, ������ġ) : STR���� ������ġ����  ã�Ƽ� ã�� ������ ��ġ ���� ���� 
SELECT INSTR('ABCABC' , 'B') FROM DUAL; --ó������ ã�Ƽ� ó�� ������ B�� ��ġ : 2
SELECT INSTR('ABDABC' , 'B', 3) FROM DUAL; --�� 3��° ���� ã�Ƽ� ó�� ������ B�� ��ġ : 5 
SELECT INSTR('ABDABC' , 'B', -3) FROM DUAL; --��3��° ���� �ڿ��� ������ ã�� ó�������� B�� ��ġ: 2
    --EX.9���� �Ի��� ����� ��� �ʵ�(INSTR) 
SELECT * FROM EMP WHERE INSTR(HIREDATE, '09', 4) = 4;
    --EX. 9�Ͽ� �Ի��� ����� ��� �ʵ�(INSTR) 
SELECT * FROM EMP WHERE INSTR(HIREDATE,'09', 7) = 7;
    --EX 9���� �ƴѳ��� �Ի��� ����� ����ʵ�(INSTR) 09/09/09
SELECT * FROM EMP WHERE INSTR(HIREDATE, '09', 7) =0;
--(6) LPAD(STR, �ڸ���, ä�﹮��) STR�� �ڸ��� ��ŭ Ȯ���ϰ� ���� ���ڸ��� ä�﹮�� ���
--     RPAD(STR, �ڸ���, ä�﹮��) STR�� �ڸ��� ��ŭ Ȯ���ϰ� ������ ���ڸ��� ä�﹮�� ���
SELECT LPAD('ORACLE', 10, '#') FROM DUAL;
SELECT RPAD('ORACLE', 10, '#') FROM DUAL;
SELECT ENAME, SAL, RPAD(SAL, 6, '*') FROM EMP;

    --EX. ���, �̸� (7788 S****, 7894 S****) �̸� �� �ѱ��ڸ� ����ϰ� �������� *)
SELECT EMPNO, RPAD(SUBSTR(ENAME,1,1),LENGTH(ENAME), '*' )
    FROM EMP;
       --EX. ���, �̸�, �Ի���
    --     7892  10�ڸ� Ȯ���� �̸����ڼ� ��ŭ *�� ä������ �� ������ ���ڸ� ���
    -- �Ի��� 80/12/**
SELECT EMPNO, LPAD(LPAD(SUBSTR(ENAME,-1,1),LENGTH(ENAME), '*' ),10, ' ') "�̸�",
--                       RPAD(SUBSTR(HIREDATE,1, 6),LENGTH(HIREDATE), '*' ) "�Ի���"
                       TO_CHAR(HIREDATE, 'RR/MM/')|| '**' "HIREDATE" 
    FROM EMP;
 --�̸��� ����° �ڸ��� R�� ����� ��� �ʵ�(LIKE ���, INSTR���, SUBSTR ���)
 SELECT * FROM EMP WHERE ENAME LIKE '__R%';
SELECT * FROM EMP WHERE INSTR(ENAME, 'R', 3) = 3;
SELECT * FROM EMP WHERE SUBSTR(ENAME, 3,1) ='R';

--(7) ��������
SELECT TRIM('      ORACLE   DB     ') FROM DUAL; --�¿�
SELECT RTRIM('      ORACLE   DB     ') FROM DUAL;
SELECT LTRIM('      ORACLE   DB     ') FROM DUAL;

--(8) 
SELECT REPLACE(ENAME, 'A', 'XX') FROM EMP;
SELECT REPLACE(HIREDATE, '0', '  ') FROM EMP;

--3.��¥ ����
--(1) SYSDATE : ���� 
SELECT SYSDATE FROM DUAL;
ALTER SESSION SET NLS_DATE_FORMAT='RR/MM/DD DY HH24:MI:SS';

SELECT ENAME, HIREDATE FROM EMP;

ALTER SESSION SET NLS_DATE_FORMAT='RR/MM/DD';

SELECT TO_CHAR(SYSDATE, 'YYYY/MM/DD DY HH24:MI:SS') FROM DUAL;
SELECT SYSDATE-1 "���� �̽ð�", SYSDATE +1 "���� �̽ð�" FROM DUAL; --���갡�� 24�ð�
--(2) ��¥��� 
SELECT SYSDATE+14 "�ݳ�������" FROM DUAL;
    --EX.�̸� , �Ի���, �ٹ��ϼ�
SELECT ENAME, HIREDATE, TRUNC(SYSDATE- HIREDATE) "�ٹ��ϼ�" FROM EMP; 
    --EX. �̸�, �Ի���, �ٹ� �ּ�, �ٹ� ���
SELECT ENAME, HIREDATE, FLOOR((SYSDATE - HIREDATE)/7) "�ٹ��ּ�", FLOOR((SYSDATE-HIREDATE)/365) "�ٹ����"
    FROM EMP;

--(3)MONTHS_BETWEEN(��¥, ��¥) : �� ��¥���� ������ 
    -- EX.�̸�, �Ի���, �ٹ����� 
SELECT ENAME, HIREDATE, TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) "�ٹ�����" FROM EMP;
    --EX. �̸�, �Ի����̷� ���� �޿��� ��(�޿��� �Ŵ� SAL�� �ް�, COMM�� 1�⿡ 2ȸ ����)
SELECT ENAME, TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) * SAL +
                        TRUNC((SYSDATE-HIREDATE)/365) *2*NVL(COMM,0)||'�޷�' COST
    FROM EMP;
SELECT * FROM EMP;

--(4) ADD_MONTHS(��¥, ������) : Ư���������� �p���� ���� ��¥
    --EX. �̸�, �Ի��� , ����������(�����Ⱓ�� �Ի��Ϸκ��� 6������ �Ѵ�)
SELECT ENAME, HIREDATE, ADD_MONTHS(HIREDATE, 6) FROM EMP;

--(5) LAST_DAY(��¥) : Ư����¥�� ���� ���� 
SELECT LAST_DAY(SYSDATE) FROM DUAL;
    --EX �̸�, �Ի���, ù����(���޳��� ����)
SELECT ENAME, HIREDATE, LAST_DAY(HIREDATE) FROM EMP;
--(6) ROUND(��¥, XX) : ��¥ �ݿø� / TRUNC(��¥, XX) : ��¥���� 
SELECT ROUND(SYSDATE, 'YEAR') FROM DUAL; -- ��� : ����� 1�� 1��
SELECT ROUND(SYSDATE + 5, 'MONTH') FROM DUAL; -- ��� : ����� 1��( 1~15���� �̹��� 1��, 16�� ���Ĵ� ������ 1��)
SELECT ROUND(SYSDATE+1, 'DAY') FROM DUAL; -- ��� : ����� �Ͽ���
SELECT ROUND(SYSDATE) FROM DUAL; --��� : ����� 0��
SELECT TO_CHAR(ROUND(SYSDATE), 'YYYY/MM/DD DY HH24:MI:SS') FROM DUAL;

SELECT TRUNC(SYSDATE, 'YEAR') FROM DUAL; -- ��� : ���� 1�� 1��
SELECT TRUNC(SYSDATE + 5, 'MONTH') FROM DUAL; -- ��� : �̹��� 1��
SELECT TRUNC(SYSDATE+1, 'DAY' ) FROM DUAL; -- ��� : ���� �Ͽ���
SELECT TRUNC(SYSDATE) FROM DUAL; --��� :  0��

--NEXT_DAY(��¥, '��') : Ư����¥�κ��� ó�� �����ϴ� ������
SELECT SYSDATE, NEXT_DAY(SYSDATE, '��') FROM DUAL;

--EX. �̸� , �Ի���, �Ի��� ���� 5�� 
SELECT ENAME, HIREDATE, TRUNC(HIREDATE, 'MONTH') +4 FROM EMP;
--EX. �̸�, �Ի���, ���޳� (���޳��� �Ŵ�16��) 
SELECT ENAME, HIREDATE, ROUND(HIREDATE, 'MONTH') + 15 "���޳�" 
    FROM EMP;
--EX. �̸�, �Ի���, ���޳� (���޳��� �Ŵ� 15�� )
SELECT ENAME, HIREDATE, ROUND(HIREDATE+1, 'MONTH') + 14"���޳�" FROM EMP;
--EX. �̸�, �Ի���, ���޳� (���޳��� �Ŵ� 5�� )
SELECT ENAME, HIREDATE, ROUND(HIREDATE+11, 'MONTH') + 4"���޳�" FROM EMP;
--EX. �̸�, �Ի���, ���޳� (���޳��� �Ŵ� 20�� )
SELECT ENAME, HIREDATE, ROUND(HIREDATE-4, 'MONTH') + 19"���޳�" FROM EMP;

INSERT INTO EMP VALUES (9999, 'ȫ�浿',NULL, NULL, NULL, 9000,900,50);

--4. ����ȯ �Լ�(����, ����, ��¥) ���� -> ��¥,   ��¥ -> ����,   ���� ->����,   ���� ->���� 
--(1) TO_CHAR(��¥�� ������, '�������')
     --YYYY(�⵵4�ڸ�) YY(�⵵ 2�ڸ�) RR(�⵵2�ڸ�) MM(��) DD(��) DAY(����) DY(���� �����)
     --AM�̳� PM(����/����) HH12(12�ð�) HH23 (23�ð�) MI(��) SS(��)
SELECT TO_CHAR(SYSDATE, 'YY"��"MM"��"DD"��" DY"����" HH24:MI:SS') FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'YY"��"MM"��"DD"��" DY"����" AM HH24:MI:SS') FROM DUAL;
--(2) TO_CHAR(���ڵ�����, '�������')
    -- 0 : �ڸ���. ��������� �ڸ����� ������ 0���� ä��
    -- 9 : �ڸ���. ��������� �ڸ����� ���Ƶ� ���ڸ�ŭ ���(�Ҽ��� ��)
    -- , : ���ڸ����� , ����
    -- . : �Ҽ���
    -- $ : ��ȭ���� $�� �տ� ���ϼ� ���� 
    -- L : ������ȭ������ �տ� ���� �� ����
SELECT TO_CHAR(123456,'9,999,999.99') FROM DUAL;
SELECT TO_CHAR(123456,'0,000,000.00') FROM DUAL;
SELECT TO_CHAR(10000, 'L999,999')FROM DUAL;
SELECT ENAME, TO_CHAR(SAL, '$99,999') FROM EMP;
SELECT ENAME, TO_CHAR(SAL, '$00,999') FROM EMP;
DESC EMP;

--TO-DATE(���� ������, '����')
SELECT TO_DATE('20220412', 'YYYY-MMDD') FROM DUAL;
    --EX 81/5/1 ~ 53/5/1 ���̿� �Ի��� ������ ����ʵ�(TO_DATA���)
SELECT * FROM EMP WHERE HIREDATE BETWEEN TO_DATE('81/05/01', 'RR/MM/DD') AND TO_DATE('83/05/01','RR/MM/DD');

--(4)TO_NUMBER(����, '����')
SELECT '1234'+1 FROM DUAL;
SELECT TO_NUMBER('1,234','9,999')+1 FROM DUAL;

--5. NVL(NULL�ϼ��� �ִ� ������, NULL�̸� ����Ұ�) - �Ű�����2���� Ÿ�� ��ġ
SELECT ENAME, NVL(COMM, 0) FROM EMP;
    --EX.�̸�, ����� ��� (MGR)�� ����ϵ�, ����� ����� NULL�ϰ�� 'CEO'�� ��� ���
SELECT ENAME, NVL(TO_CHAR(MGR),'CEO') FROM EMP;

--6. ETC 

--(1) EXTRACT �⵵�� ���̳� ��¥�� ���ڷ� �����ϰ��� �ҋ� 
SELECT EXTRACT(YEAR  FROM SYSDATE) FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'YYYY') FROM DUAL;
SELECT EXTRACT(MONTH  FROM HIREDATE) FROM EMP;
SELECT EXTRACT(DAY FROM HIREDATE) FROM EMP;
    --2���� �Ի��� ������ ��� �ʵ�
SELECT * FROM EMP WHERE HIREDATE LIKE '__/02/__';
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'MM')='02';
SELECT * FROM EMP WHERE EXTRACT(MONTH FROM HIREDATE) = 2;
    --81�⵵�� �Ի��� ������ ����ʵ�
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'RR')='81';
SELECT * FROM EMP WHERE EXTRACT(YEAR FROM HIREDATE) = 1981;
--(2) ������ ���(������ ���) : LEVEL,  START WITH ���� (MGR IS NULL), CONNECT BY PRIOR ����(EMPNO = MGR)
SELECT LEVEL, LPAD('��', LEVEL*2)|| ENAME
    FROM EMP
    START WITH MGR IS NULL
    CONNECT BY PRIOR EMPNO = MGR;
-- <�� ��������>
-- 1. ���� ��¥�� ����ϰ� TITLE�� ��Current Date���� ����ϴ� SELECT ������ ����Ͻÿ�.
SELECT SYSDATE "Current Date" FROM DUAL;
-- 2. EMP ���̺��� ���� �޿��� 15%�� ������ �޿��� ����Ͽ�,
-- �����ȣ,�̸�,����,�޿�,������ �޿�(New Salary),������(Increase)�� ����ϴ� SELECT ����
SELECT  EMPNO, ENAME, JOB, TRUNC((SAL *0.15) + SAL) "New Salary", TRUNC(SAL* 0.15) "Increase" 
    FROM EMP;

--3. �̸�, �Ի���, �Ի��Ϸκ��� 6���� �� ���ƿ��� ������ ���Ͽ� ����ϴ� SELECT ������ ����Ͻÿ�.
SELECT ENAME, HIREDATE, TRUNC(ADD_MONTHS(HIREDATE, 6), 'DAY') 
    FROM EMP;
--4. �̸�, �Ի���, �Ի��Ϸκ��� ��������� ������, �޿�, �Ի��Ϻ��� ��������� ���� �޿��� �Ѱ踦 ���
SELECT ENAME, HIREDATE, TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) "������" , 
                    SAL , TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE))*SAL "�޿��Ѱ�"
    FROM EMP;
--5. ��� ����� �̸��� �޿�(15�ڸ��� ��� ������ �� ���� ��*���� ��ġ)�� ���
SELECT ENAME, LPAD(TO_CHAR(SAL, '9,999' ), 15, '*') "�޿�"
    FROM EMP;
--6. ��� ����� ������ �̸�,����,�Ի���,�Ի��� ������ ����ϴ� SELECT ������ ����Ͻÿ�.
SELECT ENAME, JOB, HIREDATE, TO_CHAR(HIREDATE, 'DY"����"')
    FROM EMP;
--7. �̸��� ���̰� 6�� �̻��� ����� ������ �̸�,�̸��� ���ڼ�,������ ���
SELECT ENAME ,JOB
    FROM EMP
    WHERE LENGTH(ENAME) >= 6;
--8. ��� ����� ������ �̸�, ����, �޿�, ���ʽ�, �޿�+���ʽ��� ���
SELECT ENAME, JOB, SAL, NVL(COMM, 0) "���ʽ�", SAL+NVL(COMM, 0) "�޿�+���ʽ�"
    FROM EMP;
-- 9.��� ���̺��� ������� 2��° ���ں��� 3���� ���ڸ� �����Ͻÿ�. 
SELECT ENAME, SUBSTR(ENAME,2,3)
    FROM EMP;
--10. ��� ���̺��� �Ի����� 12���� ����� ���, �����, �Ի����� �˻��Ͻÿ�. 
--  �ý��ۿ� ���� DATEFORMAT �ٸ� �� �����Ƿ� �Ʒ��� ����� �˾ƺ���
SELECT EMPNO, ENAME, HIREDATE
    FROM EMP
    WHERE TO_CHAR(HIREDATE, 'MM') = 12;
--11. ������ ���� ����� �˻��� �� �ִ� SQL ������ �ۼ��Ͻÿ�
--EMPNO		ENAME		�޿�
--7369		       SMITH		*******800
--7499		       ALLEN		******1600
--7521		       WARD		******1250
--����. 
SELECT EMPNO, ENAME, LPAD(SAL, LENGTH(SAL), '*')
    FROM EMP;

-- 12. ������ ���� ����� �˻��� �� �ִ� SQL ������ �ۼ��Ͻÿ�
-- EMPNO	 ENAME 	�Ի���
-- 7369	  SMITH		1980-12-17
-- ��.

--13. ��� ���̺��� �μ� ��ȣ�� 20�� ����� ���, �̸�, ����, �޿��� ����Ͻÿ�.
    --(�޿��� �տ� $�� �����ϰ�3�ڸ����� ,�� ����Ѵ�)















