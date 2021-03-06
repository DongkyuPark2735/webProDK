-- 오라클은 --스페이스가 주석 
-- DDL : 테이블 생성
-- DML : 입력, 수정, 삭제, 검색
-- DCL : 권한부여 트랜젝션 명령
-- [ll]SELECT문 - 가장 많이 쓰이는 DML(date Manipulation Language); 검색기능 
-- 1.SQL SELECT 문장 작성법 
-- 현재 계정(실행 : Ctrl + Enter) 실행시 주석이 있으면 안됨?
-- 해당 라인 로직만 실행, 파일 확장자가 sql 이어야함 
SHOW USER;
SELECT*FROM TAB; -- 현 계정(scott)이 가지고 있는 테이블
SELECT*FROM EMP; -- EMP 테이블의 모든 열(필드), 모든 행
SELECT*FROM DEPT; -- DEPT테이블의 모든열, 모든행
    -- EMP테이블의 구조
DESC EMP; 
DESC DEPT;

    -- 2.SELECT문 실행(특정 열만 출력) SELECL문 다음엔 무조건 FORM 
SELECT EMPNO, ENAME, SAL, JOB FROM EMP;
SELECT EMPNO AS "사번", ENAME AS "이름", SAL AS "급여", JOB FROM EMP;-- AS 대신
SELECT EMPNO AS 사번, ENAME AS 이름, SAL AS 급여, JOB FROM EMP; -- SPACE들어가면 ""
SELECT EMPNO 사번, ENAME 이름, SAL 급여, JOB FROM EMP;
SELECT EMPNO "사 번", ENAME "이 름", SAL "급 여", JOB FROM EMP;
SELECT EMPNO NO, ENAME NAME, SAL SALARY FROM EMP; --TITLE : NO, NAME, SALARY
    --3. 특정행 출력 : WHERE절(조건) ; 비교연산자 같다(=), 크거나 같다(>=).. 다르다(!=, ^=, <>) 
SELECT EMPNO "사번", ENAME "이름", SAL "급여" FROM EMP WHERE SAL = 3000; --같다
SELECT EMPNO "사번", ENAME "이름", SAL "급여" FROM EMP WHERE SAL != 3000; --다르다
SELECT EMPNO "사번", ENAME "이름", SAL "급여" FROM EMP WHERE SAL ^= 3000; --다르다
SELECT EMPNO "사번", ENAME "이름", SAL "급여" FROM EMP WHERE SAL <> 3000; --다르다
    -- 비교 연산자는 숫자, 문자, 날짜형 모두 가능
    -- 오라클에서 ""는 별칭
    -- 사원이름(ENAME)이 'A','B','C'로 시작하는 사원의 모든 필드
SELECT * FROM EMP WHERE ENAME <'D';
    -- ex.81년도 이전에 입사한 사원의 모든필드
SELECT * FROM EMP WHERE HIREDATE < '81/01/01';--형변환 자동으로 해줌ㅈ
    -- ex.부서번호가 10번 (DEPTNO)인 사원의 모든 필드 출력
SELECT * FROM EMP WHERE DEPTNO = 10;
    -- ex. 이름(ENAME)이 FORD인 직원의 ENPNO, ENAME, MGR(상사의 사번)을 출력
SELECT EMPNO,ENAME, MGR FROM EMP WHERE ENAME = 'FORD'; --데이터는 대소문자 구분

    --4. 논리연산자 : AND, OR
    --ex. 급여(SAL)가 2000이상 3000이하인 직원의 모든 필드 
SELECT * FROM EMP WHERE SAL >= 2000 AND SAL<=3000;
    --ex. 82년도에 입사한 사원의 모든 필드
SELECT * FROM EMP WHERE HIREDATE >= '82/01/01' AND HIREDATE <= '82/12/31';
    --날짜 표기법 셋팅(현재 : YY/MM/DD OR RR/MM/DD) 
ALTER SESSION SET NLS_DATE_FORMAT = 'MM-DD-RR';
ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD'; --한글윈도우 위에 INSTALL
SELECT ENAME, HIREDATE FROM EMP;

    --연봉이 2400 이상인 직원의 ENAME, SAL, 연봉 출력(연봉 = SAL*12)
SELECT ENAME, SAL, SAL*12 "연봉" FROM EMP WHERE SAL*12 > 2400;
 -- SELECT ENAME, SAL, SAL*12 "연봉" FROM EMP WHERE 연봉 > 2400; -- WHERE절에는 별칭을 쓸수 없다. SELECT절에만 쓸수있음 
--연봉을 인식못함 제일 마지막에 실행되기때문
SELECT ENAME, SAL, SAL*12 "연봉" --3번실행 
    FROM EMP  --1번 실행 
    WHERE SAL*12>2400  -- 2번실행 
    ORDER BY 연봉; -- ORDER BY절은 별칭사용가능    
    -- 10번 부서(DEPTNO)이거나 직책이 MANEGER인 사람의 모든 필드
SELECT * FROM EMP WHERE DEPTNO =10 OR JOB = 'MANEGER';
    -- 부서번호가 10번이 아닌 사람의 모든 필드
SELECT * FROM EMP WHERE DEPTNO != 10;
SELECT * FROM EMP WHERE NOT DEPTNO != 10;

    --5. 산술표현식 
SELECT ENAME, SAL "현재급여", SAL+100 "올릴급여" FROM EMP WHERE DEPTNO=10;
    -- EX. 모든 사원의 이름(ENAME), 월급(SAL), 상여(COMM), 연봉(SAL*12+COMM)
    --산술연산의 결과는 NULL포함하면 결과도 NULL
    --NVL(NULL 일수도 있는 필드명, 대치값) 반드시 매개변수 둘은 타입이 같아야함 
SELECT ENAME, SAL,COMM,SAL*12+COMM FROM EMP;
SELECT ENAME, SAL,COMM,SAL*12+NVL(COMM, 0) FROM EMP;
    --모든사원의 사원명(ENAME), 상사의 사번(MGR)을 출력(상사없으면 0) 타입이 같아야함
SELECT ENAME "사원명",NVL(MGR , 0) FROM EMP;
--SELECT ENAME "사원명",NVL(MGR , "없음") FROM EMP; --NVL 매개변수 타입 불일치 에러

--6.연결연산자(||) : 열이나 문자를 연결 
SELECT ENAME || '은' || JOB "EMPLOYEES" FROM EMP;
    -- EX. "SMITH: 연봉 = XXX"과 같이 모든 행 출력(연봉 = SAL*12+COMM)
SELECT ENAME || ' : 연봉 = ' || (SAL*12+NVL(COMM,0)) FROM EMP;    
    --7.중복제거 (DISTINCT)
SELECT JOB FROM EMP;
SELECT DEPTNO FROM EMP;
SELECT DISTINCT JOB FROM EMP;
SELECT DISTINCT DEPTNO FROM EMP;


--연습문제 
--1. emp 테이블의 구조 출력
--SELECT * FROM EMP
--2. emp 테이블의 모든 내용을 출력 
SELECT * FROM EMP;
--3. 현 scott 계정에서 사용가능한 테이블 출력
SELECT * FROM TAB;
--4. emp 테이블에서 사번, 이름, 급여, 업무, 입사일 출력
SELECT EMPNO, ENAME, SAL, JOB, HIREDATE FROM EMP;
--5. emp 테이블에서 급여가 2000미만인 사람의 사번, 이름, 급여 출력
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL <2000;
--6. 입사일이 81/02이후에 입사한 사람의 사번, 이름, 업무, 입사일 출력
SELECT EMPNO, ENAME, JOB, HIREDATE FROM EMP WHERE HIREDATE > '81/02/01';
--7. 업무가 SALESMAN인 사람들 모든 자료 출력
SELECT * FROM EMP WHERE JOB ='SALESMAN';
--8. 업무가 CLERK이 아닌 사람들 모든 자료 출력
SELECT * FROM EMP WHERE JOB <>'CLERK';
--9. 급여가 1500이상이고 3000이하인 사람의 사번, 이름, 급여 출력
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL >= 1500 AND SAL <=3000;
--10. 부서코드가 10번이거나 30인 사람의 사번, 이름, 업무, 부서코드 출력
SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP WHERE DEPTNO = '10' OR DEPTNO = '30';
--11. 업무가 SALESMAN이거나 급여가 3000이상인 사람의 사번, 이름, 업무, 부서코드 출력
SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP WHERE JOB = 'SALESMANE' OR SAL >= 3000;
--12. 급여가 2500이상이고 업무가 MANAGER인 사람의 사번, 이름, 업무, 급여 출력
SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE SAL >= 2500 AND JOB = 'MANAGER';
--13.“ename은 XXX 업무이고 연봉은 XX다” 스타일로 모두 출력(연봉은 SAL*12+COMM)
SELECT 








                                                                                                                                                                                                                                                                                                                                                                                                                                          
