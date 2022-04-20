-- �ε��� : ��ȸ�� ������ �ϴ� �ε��� ����, ����

SELECT * FROM USER_INDEXES; -- ��ųʸ� �信�� SCOTT�� ������ �ε��� ����
DESC EMP; -- �����̸Ӹ�Ű �������� �ε����� ���� 

SELECT * FROM EMP; -- ���̳ʸ� Ʈ�� : B Ʈ��?? �������� ����� ����(�߰�������)���� ���� ���·�
INSERT INTO EMP VALUES (7369, 'SMITH', 'CLERK', 7902, '80/12/17', 800, NULL, 20);


DROP TABLE EMP01;
SELECT * FROM EMP01;

CREATE TABLE EMP01 AS SELECT * FROM EMP; -- EMP����� ���� EMP01����

INSERT INTO EMP01 SELECT * FROM EMP01; -- 1��(28��) 2��(56)��)  12�� ����

SELECT COUNT(*) FROM EMP01;

INSERT INTO EMP01 (EMPNO, ENAME, DEPTNO) VALUES (1111,'HONG', 40); -- �ڷ� ���� 
INSERT INTO EMP01 SELECT * FROM EMP01; -- 3�� ����(180���� ��)

SELECT TO_CHAR(COUNT(*), '9,999,999') FROM EMP01;

SELECT * FROM EMP01 WHERE ENAME='HONG'; -- �ε��� ���� �� : 0.031
SELECT * FROM EMP01 WHERE SAL >0;

-- �ε��� ���� (EMP01���̺��� ENAME)�ϰ� ��ȸ
CREATE INDEX IDX_EMP_ENAME ON EMP01(ENAME); -- �ε��� ���� ��ɾ� : 1.11��

SELECT * FROM EMP01 WHERE ENAME='HONG'; -- �ε��� ������ : 0.005
SELECT * FROM USER_INDEXES WHERE INDEX_NAME = 'IDX_EMP_ENAME'; -- ������ ��ųʸ��� �߰��� 

COMMIT; --180���� ��

INSERT INTO EMP01 SELECT * FROM EMP01; -- �ε��� ������ insert �ӵ� : 25.442
DROP INDEX IDX_EMP_ENAME;
ROLLBACK;
INSERT INTO EMP01 SELECT * FROM EMP01; -- �ε��� ������ insert �ӵ� : 3.473





























