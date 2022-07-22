-- Dept.xml id = deptList
SELECT * FROM DEPT;
-- Emp.xml의 id=empList 
-- AND의 부분적으로 올수있는 조건을 만족하기위해 WHERE 1 = 1 을 넣는다.
SELECT * FROM EMP WHERE 1 = 1 
    AND ENAME LIKE '%'||'A'||'%' 
    AND JOB LIKE '%'||'E'||'%'
    AND DEPTNO = 20;

    


