-- DAO query

SELECT * FROM EMP ORDER BY HIREDATE;

SELECT * FROM EMP WHERE ENAME LIKE '%'||UPPER('a')||'%' AND JOB LIKE '%'||'a'||'%';