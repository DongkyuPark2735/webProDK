 -- 
 INSERT INTO DEPT VALUES(50, 'it', 'SEOUL');
 select * from dept;
 rollback;
 commit;
 delete from dept where dname = 'asd';
 
 
 -- 부서번호 중복체크 
 SELECT * FROM DEPT WHERE DEPTNO = 70; 
 -- rs.next()결과가 true(중복출력) / false(부서명/ 부서위치 입력받아 입력)
 SELECT COUNT(*) CNT FROM DEPT WHERE DEPTNO = 70;
 -- 입력 
INSERT INTO DEPT VALUES(70, 'it', 'SEOUL');
 
-- 
SELECT * FROM DEPT;
UPDATE DEPT SET DNAME = 'ABC' WHERE DEPTNO = 55;
DELETE FROM DNAME WHERE DEPTNO = 55;

UPDATE DEPT SET DNAME= 'ACCOUNTING', LOC= 'NEW YORK' WHERE DEPTNO = 10;

