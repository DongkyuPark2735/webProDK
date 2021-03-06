SELECT E.MGR, MG.ENAME FROM EMP E, EMP MG WHERE E.MGR = MG.EMPNO;

-- DEPT.XML ID=DEPLIST
SELECT * FROM DEPT;

-- EMP.XML ID=EMPLIST
-- SELECT * FROM EMP ORDER BY EMPNO; -- 출력조건
SELECT * FROM 
    (SELECT ROWNUM RN, A.* FROM
        (SELECT * FROM EMP ORDER BY EMPNO) A)
            WHERE RN BETWEEN 6 AND 10;

-- Emp.xml id = empDeptList
-- SELECT E.*, DNAME, LOC FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO ORDER BY EMPNO;
SELECT * FROM (SELECT ROWNUM RN, A.* FROM 
    (SELECT E.*, DNAME, LOC FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO ORDER BY EMPNO) A)
        WHERE RN BETWEEN 6 AND 10;

-- EMP.XML ID=TOTCNT           
SELECT COUNT(*) FROM EMP;

-- EMP.XML ID=DETAIL
SELECT * FROM EMP WHERE EMPNO = 7698;

-- EMP.XML ID=MANAGERLIST
SELECT * FROM EMP WHERE EMPNO IN (SELECT MGR FROM EMP);

-- EMP.XML ID=INSERT
DESC EMP;
INSERT INTO EMP VALUES (9001, '홍길동', 'IT', 7902, '22/07/20', 6000, 800, 40);

-- EMP.XML ID=UPDATE
UPDATE EMP SET ENAME = '홍홍홍',
                      JOB='MANAGER',
                      MGR = 7839,
                     HIREDATE = '21/07/20',
                     SAL = 7000,
                     COMM = 500
                     WHERE EMPNO = 9000;
                     
-- EMP.XML ID=DELETE
DELETE FROM EMP WHERE EMPNO = 9000;

commit;                     
                     
                     


            
            






