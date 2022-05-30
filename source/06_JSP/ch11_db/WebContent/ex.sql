SELECT * FROM EMP; -- 실행은 알트 x
SELECT * FROM DEPT;

SELECT * FROM EMP WHERE ENAME LIKE '%'||UPPER('al')||'%';

desc emp;