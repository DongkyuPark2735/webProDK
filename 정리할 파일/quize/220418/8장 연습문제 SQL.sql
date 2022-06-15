-- 연습문제 총연습문제 1

--MEMBER_LEVEL테이블 삭제
DROP TABLE MEMBER_LEVEL;

--MEMBER_LEVEL테이블 생성
CREATE TABLE MEMBER_LEVEL(
    LEVELNO NUMBER(10) PRIMARY KEY,
    LEVELNAME VARCHAR2(20) NOT NULL
);
--MEMBER_LEVEL테이블 생성확인
SELECT * FROM MEMBER_LEVEL; 

--MEMBER_LEVEL 칼럼 생성
INSERT INTO MEMBER_LEVEL VALUES(-1, 'BLACK');
INSERT INTO MEMBER_LEVEL VALUES(0, '일반');
INSERT INTO MEMBER_LEVEL VALUES(1, '실버');
INSERT INTO MEMBER_LEVEL VALUES(2, '골드');

--MEMBER테이블 삭제
DROP TABLE MEMBER;

--MEMBER테이블 생성
CREATE TABLE MEMBER(
    mNO NUMBER(4) PRIMARY KEY,
    mNAME VARCHAR2(20) NOT NULL,
    mPW VARCHAR2(8) CHECK(LENGTH(mPW) BETWEEN 1 AND 8),
    mEMAIL VARCHAR2(50) UNIQUE,
    mPOINT NUMBER(10) CHECK(mPOINT >= 0),
    mRDATE DATE DEFAULT SYSDATE,
    LEVELNO NUMBER(10) REFERENCES MEMBER_LEVEL(LEVELNO)
);
--MEMBER테이블 확인
SELECT * FROM MEMBER;

-- MEMBER_MNO_SQ시퀀스 삭제
DROP SEQUENCE MEMBER_MNO_SQ;

-- MEMBER_MNO_SQ시퀀스 생성
CREATE SEQUENCE MEMBER_MNO_SQ
    START WITH 1    
    INCREMENT BY 1
    MAXVALUE 9999
    MINVALUE 1
    NOCACHE
    NOCYCLE;

--MEMBER테이블 데이터 생성
INSERT INTO MEMBER 
    VALUES(MEMBER_MNO_SQ.NEXTVAL, '홍길동', 'AA', 'hong@hong.com', 0, TO_DATE('22/03/10','RR/MM/DD'), 0); 
INSERT INTO MEMBER(mNO, mNAME, mPW, mEMAIL, mPOINT, LEVELNO) 
    VALUES(MEMBER_MNO_SQ.NEXTVAL, '신길동', 'BB', 'sin@sin.com', 1000 , 1);

--출력
SELECT mNO, mNAME, mRDATE, mEMAIL, mPOINT "point", LEVELNAME
    FROM MEMBER M , MEMBER_LEVEL ML
    WHERE M.LEVELNO = ML.LEVELNO;
