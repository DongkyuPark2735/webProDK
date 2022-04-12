-- 4 단일행 함수 : 내장함수 .SQL 주요함수
-- 함수 = 단일행함수 + 그룹함수(집계함수)
    -- 단일행 함수 (INPUT 1행 -> OUTPUT1행)
SELECT HIREDATE, TO_CHAR(HIREDATE, 'YY"년"MM"월"DD"일"') --""는 해석하지않고 출력 
    FROM EMP;

SELECT ENAME, INITCAP(ENAME) FROM EMP; -- 단일행 함수
    --그룹함수 (INPUT N행 -> OUTPUT 1행)
SELECT SUM(SAL), AVG(SAL) FROM EMP; --전체 SAL 합
SELECT DEPTNO, SUM(SAL) FROM EMP GROUP BY DEPTNO; --부서별 SAL합

-- 단일행함수 종류 : 숫자관련 함수, 문자관련 함수, 날짜관련함수(예약어), 형변환 함수 , NVL(), ETC,... 
--1. 숫자관련 함수 
    --DUAL 테이블 : 오라클에서 제공하는 1행1열짜리 DUMMY TABLE (cf) DUMMY
SELECT -9, ABS(-9) FROM EMP; --EMP에서 한줄씩 가져와서 SELECT 뿌린다

SELECT * FROM DUMMY;
DESC DUMMY ; -- 유형 검색 
SELECT * FROM DUAL;

SELECT -9, ABS(-9) FROM DUAL; --절대값 
SELECT FLOOR(34.5678) FROM DUAL; -- 소수점에서 내림
SELECT FLOOR(34.5678*100)/100 FROM DUAL; -- 소수점 두번째자리에서 내림 
SELECT TRUNC(34.5678,2) FROM DUAL; --TRUNC( , )다음에 오는수가 소수점 내리는 자리
SELECT TRUNC(34.5678) FROM DUAL; -- 소수점에서 내림
SELECT TRUNC(34, -1) FROM DUAL; -- 일의자리에서 내림 

   --EX. EMP테이블에서 이름 ,급여(십의 자리에서 내림)
SELECT ENAME,SAL, TRUNC(SAL, -2) "내림" FROM EMP;  

SELECT CEIL(34.5678) FROM DUAL; --소수점에서 올림
SELECT CEIL(34.5678 * 100) /100 FROM DUAL; --소수점 두번째자리에서 올림

SELECT ROUND(34.5678) FROM DUAL; --소수점에서 반올림
SELECT ROUND(34.5678, 2) FROM DUAL; --소수점에서 두번째 자리에서 반올림
SELECT ROUND(34.5678, -1) FROM DUAL; --일의 자리에서 만올림

SELECT MOD(9, 2) FROM DUAL; --나머지 연산자 9%2
    --EX. 사번이 홀수인 사원의 모든 필드 출력
SELECT * 
    FROM EMP
    WHERE MOD(EMPNO, 2) != 0; 
    --EX. 홀수달에 입사한 사원의 모든 필드 출력
SELECT * 
    FROM EMP
    WHERE MOD(TO_CHAR(HIREDATE, 'MM'), 2) = 1;  --달을 추출

--2. 문자 관련 함수 
--(1) 대소문자 관련
SELECT UPPER('abcABC') FROM DUAL;
SELECT LOWER('abcABC') FROM DUAL;
SELECT INITCAP('WELCOM TO ORACLE') FROM DUAL; --단어 시작 첫단어만 대문자 나머지 소문자로 
    --EX. JOB이 'MANAGER'인 직원의 모든 필드
SELECT *
    FROM EMP
    WHERE UPPER(JOB) = 'MANAGER'; --해당필드가 대문자인지 소문자인지모를때 대문자로 변환하여 비고 예외없앰 
SELECT * FROM EMP WHERE LOWER(JOB) = 'manager';

--(2) 문자연결(COMCAT, || 연산자)
SELECT 'AB' ||'CD'||'EF'||'GH' FROM DUAL; --연결연산자는 제한이없는데
SELECT CONCAT('AB','CD','EF','GF') FROM DUAL; -- CONCAT은매개변수 2개만 가능 
SELECT CONCAT(CONCAT('AB','CD'), CONCAT('EF','GF')) FROM DUAL;
    -- 아무개(NAME)는 XX(JOB)이다 포멧으로 EMP테이블 정보 출력
SELECT CONCAT(CONCAT(ENAME, '는'), CONCAT(JOB, '이다')) 
    FROM EMP;
--(3) SUBSTR(STR, 시작위치, 문자갯수) 첫번째 위치가 1, 시작위치 음수가능 
--    SUBSTRB(STR, 시작바이트 위치, 문자 바이트수)
--  O R A C L E
--  1 2 3 4 5 6
-- -6-5-4-3-2-1
SELECT SUBSTR('ORACLE', 3,2) FROM DUAL; --3번째 글자부터 2글자 추출
SELECT SUBSTRB('ORACLE', 3,2) FROM DUAL; --3번째 바이트부터 2바이트 추출
SELECT SUBSTR('데이터베이스',4,3) FROM DUAL;--4번째 글자부터 3글자 추출
SELECT SUBSTRB('데이터베이스',4,5) FROM DUAL; --4번째 바이트부터 3바이트 추출(XE버젼에서는 한글1글자는 ㅠ바이트)
SELECT SUBSTRB('홍길동', 3,3)FROM DUAL;
SELECT SUBSTRB('ABCDEF', -1,1)FROM DUAL;
SELECT SUBSTR(123,2,1) FROM DUAL;--  숫자도 가능
--EX. 9월에 입사한 사원의 모든필드 (단, DATA출력 FORMAT'RR/MM/DD')
SELECT * FROM EMP WHERE SUBSTR(HIREDATE,4, 2)='09';
--EX 9일에 입사한 사원의 모든필드 
SELECT * FROM EMP WHERE SUBSTR(HIREDATE,-2, 2)='09';

--(4) 글자수 (LENGTH) VS 바이트수(LENGTHB)
SELECT LENGTH('ABD') FROM DUAL; --글자수 : 3
SELECT LENGTHB('ABD') FROM DUAL; -- 바이트수 :3
SELECT LENGTH('오라클') FROM DUAL; -- 글자수 : 3
SELECT LENGTHB('오라클') FROM DUAL; --바이트수 : 9

--(5)INSTR(STR, 찾을글자) : STR에서 찾을 글자의 위치(첫번째 1), 없으면 0
--    INSTR(STR , 찾을글자, 시작위치) : STR에서 시작위치부터  찾아서 찾은 글자의 위치 음수 가능 
SELECT INSTR('ABCABC' , 'B') FROM DUAL; --처음부터 찾아서 처음 나오는 B의 위치 : 2
SELECT INSTR('ABDABC' , 'B', 3) FROM DUAL; --앞 3번째 부터 찾아서 처음 나오는 B의 위치 : 5 
SELECT INSTR('ABDABC' , 'B', -3) FROM DUAL; --뒤3번째 부터 뒤에서 앞으로 찾아 처음나오는 B의 위치: 2
    --EX.9월에 입사한 사원의 모든 필드(INSTR) 
SELECT * FROM EMP WHERE INSTR(HIREDATE, '09', 4) = 4;
    --EX. 9일에 입사한 사원의 모든 필드(INSTR) 
SELECT * FROM EMP WHERE INSTR(HIREDATE,'09', 7) = 7;
    --EX 9일이 아닌날에 입사한 사원의 모든필드(INSTR) 09/09/09
SELECT * FROM EMP WHERE INSTR(HIREDATE, '09', 7) =0;
--(6) LPAD(STR, 자리수, 채울문자) STR을 자리수 만큼 확보하고 왼쪽 빈자리에 채울문자 출력
--     RPAD(STR, 자리수, 채울문자) STR을 자리수 만큼 확보하고 오른쪽 빈자리에 채울문자 출력
SELECT LPAD('ORACLE', 10, '#') FROM DUAL;
SELECT RPAD('ORACLE', 10, '#') FROM DUAL;
SELECT ENAME, SAL, RPAD(SAL, 6, '*') FROM EMP;

    --EX. 사번, 이름 (7788 S****, 7894 S****) 이름 앞 한글자만 출력하고 나머지는 *)
SELECT EMPNO, RPAD(SUBSTR(ENAME,1,1),LENGTH(ENAME), '*' )
    FROM EMP;
       --EX. 사번, 이름, 입사일
    --     7892  10자리 확보후 이름글자수 만큼 *로 채워지고 맨 마지막 글자만 출력
    -- 입사일 80/12/**
SELECT EMPNO, LPAD(LPAD(SUBSTR(ENAME,-1,1),LENGTH(ENAME), '*' ),10, ' ') "이름",
--                       RPAD(SUBSTR(HIREDATE,1, 6),LENGTH(HIREDATE), '*' ) "입사일"
                       TO_CHAR(HIREDATE, 'RR/MM/')|| '**' "HIREDATE" 
    FROM EMP;
 --이름의 세번째 자리가 R인 사원의 모든 필드(LIKE 사용, INSTR사용, SUBSTR 사용)
 SELECT * FROM EMP WHERE ENAME LIKE '__R%';
SELECT * FROM EMP WHERE INSTR(ENAME, 'R', 3) = 3;
SELECT * FROM EMP WHERE SUBSTR(ENAME, 3,1) ='R';

--(7) 여백제거
SELECT TRIM('      ORACLE   DB     ') FROM DUAL; --좌우
SELECT RTRIM('      ORACLE   DB     ') FROM DUAL;
SELECT LTRIM('      ORACLE   DB     ') FROM DUAL;

--(8) 
SELECT REPLACE(ENAME, 'A', 'XX') FROM EMP;
SELECT REPLACE(HIREDATE, '0', '  ') FROM EMP;

--3.날짜 관련
--(1) SYSDATE : 지금 
SELECT SYSDATE FROM DUAL;
ALTER SESSION SET NLS_DATE_FORMAT='RR/MM/DD DY HH24:MI:SS';

SELECT ENAME, HIREDATE FROM EMP;

ALTER SESSION SET NLS_DATE_FORMAT='RR/MM/DD';

SELECT TO_CHAR(SYSDATE, 'YYYY/MM/DD DY HH24:MI:SS') FROM DUAL;
SELECT SYSDATE-1 "어제 이시간", SYSDATE +1 "내일 이시간" FROM DUAL; --연산가능 24시간
--(2) 날짜계산 
SELECT SYSDATE+14 "반납기한일" FROM DUAL;
    --EX.이름 , 입사일, 근무일수
SELECT ENAME, HIREDATE, TRUNC(SYSDATE- HIREDATE) "근무일수" FROM EMP; 
    --EX. 이름, 입사일, 근무 주수, 근무 년수
SELECT ENAME, HIREDATE, FLOOR((SYSDATE - HIREDATE)/7) "근무주수", FLOOR((SYSDATE-HIREDATE)/365) "근무년수"
    FROM EMP;

--(3)MONTHS_BETWEEN(날짜, 날짜) : 두 날짜간의 개월수 
    -- EX.이름, 입사일, 근무월수 
SELECT ENAME, HIREDATE, TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) "근무월수" FROM EMP;
    --EX. 이름, 입사한이루 받은 급여와 상여(급여는 매달 SAL을 받고, COMM은 1년에 2회 받음)
SELECT ENAME, TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) * SAL +
                        TRUNC((SYSDATE-HIREDATE)/365) *2*NVL(COMM,0)||'달러' COST
    FROM EMP;
SELECT * FROM EMP;

--(4) ADD_MONTHS(날짜, 개월수) : 특정시점부터 몆개월 후의 날짜
    --EX. 이름, 입사일 , 수습종료일(수습기간은 입사일로부터 6개월로 한다)
SELECT ENAME, HIREDATE, ADD_MONTHS(HIREDATE, 6) FROM EMP;

--(5) LAST_DAY(날짜) : 특정날짜의 달의 말일 
SELECT LAST_DAY(SYSDATE) FROM DUAL;
    --EX 이름, 입사일, 첫월급(월급날은 말일)
SELECT ENAME, HIREDATE, LAST_DAY(HIREDATE) FROM EMP;
--(6) ROUND(날짜, XX) : 날짜 반올림 / TRUNC(날짜, XX) : 날짜버림 
SELECT ROUND(SYSDATE, 'YEAR') FROM DUAL; -- 결과 : 가까운 1월 1일
SELECT ROUND(SYSDATE + 5, 'MONTH') FROM DUAL; -- 결과 : 가까운 1일( 1~15일은 이번달 1일, 16일 이후는 다음달 1일)
SELECT ROUND(SYSDATE+1, 'DAY') FROM DUAL; -- 결과 : 가까운 일요일
SELECT ROUND(SYSDATE) FROM DUAL; --결과 : 가까운 0시
SELECT TO_CHAR(ROUND(SYSDATE), 'YYYY/MM/DD DY HH24:MI:SS') FROM DUAL;

SELECT TRUNC(SYSDATE, 'YEAR') FROM DUAL; -- 결과 : 올해 1월 1일
SELECT TRUNC(SYSDATE + 5, 'MONTH') FROM DUAL; -- 결과 : 이번달 1일
SELECT TRUNC(SYSDATE+1, 'DAY' ) FROM DUAL; -- 결과 : 지난 일요일
SELECT TRUNC(SYSDATE) FROM DUAL; --결과 :  0시

--NEXT_DAY(날짜, '수') : 특정날짜로부터 처음 도래하는 수요일
SELECT SYSDATE, NEXT_DAY(SYSDATE, '토') FROM DUAL;

--EX. 이름 , 입사일, 입사한 달의 5일 
SELECT ENAME, HIREDATE, TRUNC(HIREDATE, 'MONTH') +4 FROM EMP;
--EX. 이름, 입사일, 월급날 (월급날은 매달16일) 
SELECT ENAME, HIREDATE, ROUND(HIREDATE, 'MONTH') + 15 "월급날" 
    FROM EMP;
--EX. 이름, 입사일, 월급날 (월급날은 매달 15일 )
SELECT ENAME, HIREDATE, ROUND(HIREDATE+1, 'MONTH') + 14"월급날" FROM EMP;
--EX. 이름, 입사일, 월급날 (월급날은 매달 5일 )
SELECT ENAME, HIREDATE, ROUND(HIREDATE+11, 'MONTH') + 4"월급날" FROM EMP;
--EX. 이름, 입사일, 월급날 (월급날은 매달 20일 )
SELECT ENAME, HIREDATE, ROUND(HIREDATE-4, 'MONTH') + 19"월급날" FROM EMP;

INSERT INTO EMP VALUES (9999, '홍길동',NULL, NULL, NULL, 9000,900,50);

--4. 형변환 함수(문자, 숫자, 날짜) 문자 -> 날짜,   날짜 -> 문자,   문자 ->숫자,   숫자 ->문자 
--(1) TO_CHAR(날짜형 데이터, '출력형식')
     --YYYY(년도4자리) YY(년도 2자리) RR(년도2자리) MM(월) DD(일) DAY(요일) DY(요일 함축어)
     --AM이나 PM(오전/오후) HH12(12시간) HH23 (23시간) MI(분) SS(초)
SELECT TO_CHAR(SYSDATE, 'YY"년"MM"월"DD"일" DY"요일" HH24:MI:SS') FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'YY"년"MM"월"DD"일" DY"요일" AM HH24:MI:SS') FROM DUAL;
--(2) TO_CHAR(숫자데이터, '출력형식')
    -- 0 : 자릿수. 출력형식의 자릿수가 많으먄 0으로 채움
    -- 9 : 자릿수. 출력형식의 자릿수가 많아도 숫자만큼 출력(소수점 앞)
    -- , : 세자리마다 , 가능
    -- . : 소수점
    -- $ : 통화단위 $를 앞에 붙일수 있음 
    -- L : 지역통화단위가 앞에 붙을 수 있음
SELECT TO_CHAR(123456,'9,999,999.99') FROM DUAL;
SELECT TO_CHAR(123456,'0,000,000.00') FROM DUAL;
SELECT TO_CHAR(10000, 'L999,999')FROM DUAL;
SELECT ENAME, TO_CHAR(SAL, '$99,999') FROM EMP;
SELECT ENAME, TO_CHAR(SAL, '$00,999') FROM EMP;
DESC EMP;

--TO-DATE(문자 데이터, '패턴')
SELECT TO_DATE('20220412', 'YYYY-MMDD') FROM DUAL;
    --EX 81/5/1 ~ 53/5/1 사이에 입사한 직원의 모든필드(TO_DATA사용)
SELECT * FROM EMP WHERE HIREDATE BETWEEN TO_DATE('81/05/01', 'RR/MM/DD') AND TO_DATE('83/05/01','RR/MM/DD');

--(4)TO_NUMBER(문자, '패턴')
SELECT '1234'+1 FROM DUAL;
SELECT TO_NUMBER('1,234','9,999')+1 FROM DUAL;

--5. NVL(NULL일수도 있는 데이터, NULL이면 대신할값) - 매개변수2개는 타입 일치
SELECT ENAME, NVL(COMM, 0) FROM EMP;
    --EX.이름, 상사의 사번 (MGR)을 출력하되, 상사의 사번이 NULL일경우 'CEO'로 대신 출력
SELECT ENAME, NVL(TO_CHAR(MGR),'CEO') FROM EMP;

--6. ETC 

--(1) EXTRACT 년도나 월이나 날짜만 숫자로 추출하고자 할떄 
SELECT EXTRACT(YEAR  FROM SYSDATE) FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'YYYY') FROM DUAL;
SELECT EXTRACT(MONTH  FROM HIREDATE) FROM EMP;
SELECT EXTRACT(DAY FROM HIREDATE) FROM EMP;
    --2월에 입사한 직원의 모든 필드
SELECT * FROM EMP WHERE HIREDATE LIKE '__/02/__';
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'MM')='02';
SELECT * FROM EMP WHERE EXTRACT(MONTH FROM HIREDATE) = 2;
    --81년도에 입사한 직원의 모든필드
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'RR')='81';
SELECT * FROM EMP WHERE EXTRACT(YEAR FROM HIREDATE) = 1981;
--(2) 계층적 출력(레벨별 출력) : LEVEL,  START WITH 조건 (MGR IS NULL), CONNECT BY PRIOR 조건(EMPNO = MGR)
SELECT LEVEL, LPAD('└', LEVEL*2)|| ENAME
    FROM EMP
    START WITH MGR IS NULL
    CONNECT BY PRIOR EMPNO = MGR;
-- <총 연습문제>
-- 1. 현재 날짜를 출력하고 TITLE에 “Current Date”로 출력하는 SELECT 문장을 기술하시오.
SELECT SYSDATE "Current Date" FROM DUAL;
-- 2. EMP 테이블에서 현재 급여에 15%가 증가된 급여를 계산하여,
-- 사원번호,이름,업무,급여,증가된 급여(New Salary),증가액(Increase)를 출력하는 SELECT 문장
SELECT  EMPNO, ENAME, JOB, TRUNC((SAL *0.15) + SAL) "New Salary", TRUNC(SAL* 0.15) "Increase" 
    FROM EMP;

--3. 이름, 입사일, 입사일로부터 6개월 후 돌아오는 월요일 구하여 출력하는 SELECT 문장을 기술하시오.
SELECT ENAME, HIREDATE, TRUNC(ADD_MONTHS(HIREDATE, 6), 'DAY') 
    FROM EMP;
--4. 이름, 입사일, 입사일로부터 현재까지의 개월수, 급여, 입사일부터 현재까지의 받은 급여의 총계를 출력
SELECT ENAME, HIREDATE, TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) "개월수" , 
                    SAL , TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE))*SAL "급여총계"
    FROM EMP;
--5. 모든 사원의 이름과 급여(15자리로 출력 좌측의 빈 곳은 “*”로 대치)를 출력
SELECT ENAME, LPAD(TO_CHAR(SAL, '9,999' ), 15, '*') "급여"
    FROM EMP;
--6. 모든 사원의 정보를 이름,업무,입사일,입사한 요일을 출력하는 SELECT 문장을 기술하시오.
SELECT ENAME, JOB, HIREDATE, TO_CHAR(HIREDATE, 'DY"요일"')
    FROM EMP;
--7. 이름의 길이가 6자 이상인 사원의 정보를 이름,이름의 글자수,업무를 출력
SELECT ENAME ,JOB
    FROM EMP
    WHERE LENGTH(ENAME) >= 6;
--8. 모든 사원의 정보를 이름, 업무, 급여, 보너스, 급여+보너스를 출력
SELECT ENAME, JOB, SAL, NVL(COMM, 0) "보너스", SAL+NVL(COMM, 0) "급여+보너스"
    FROM EMP;
-- 9.사원 테이블의 사원명에서 2번째 문자부터 3개의 문자를 추출하시오. 
SELECT ENAME, SUBSTR(ENAME,2,3)
    FROM EMP;
--10. 사원 테이블에서 입사일이 12월인 사원의 사번, 사원명, 입사일을 검색하시오. 
--  시스템에 따라 DATEFORMAT 다를 수 있으므로 아래의 방법도 알아보자
SELECT EMPNO, ENAME, HIREDATE
    FROM EMP
    WHERE TO_CHAR(HIREDATE, 'MM') = 12;
--11. 다음과 같은 결과를 검색할 수 있는 SQL 문장을 작성하시오
--EMPNO		ENAME		급여
--7369		       SMITH		*******800
--7499		       ALLEN		******1600
--7521		       WARD		******1250
--……. 
SELECT EMPNO, ENAME, LPAD(SAL, LENGTH(SAL), '*')
    FROM EMP;

-- 12. 다음과 같은 결과를 검색할 수 있는 SQL 문장을 작성하시오
-- EMPNO	 ENAME 	입사일
-- 7369	  SMITH		1980-12-17
-- ….

--13. 사원 테이블에서 부서 번호가 20인 사원의 사번, 이름, 직무, 급여를 출력하시오.
    --(급여는 앞에 $를 삽입하고3자리마다 ,를 출력한다)















