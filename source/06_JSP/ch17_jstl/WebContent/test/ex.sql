DROP TABLE CUSTOMER CASCADE CONSTRAINTS;

DROP TABLE BOARD CASCADE CONSTRAINTS;

DROP TABLE USERLEVEL;

CREATE TABLE USERLEVEL(
    USERGRADE NUMBER(1) PRIMARY KEY,
    GRADENAME VARCHAR2(20) NOT NULL
);

CREATE TABLE CUSTOMER(
    CID VARCHAR2(50) PRIMARY KEY,
    CPW VARCHAR2(50) NOT NULL,
    CNAME VARCHAR2(20) NOT NULL,
    CEMAIL VARCHAR2(50) NOT NULL,
    CFILE VARCHAR2(50),
    CBIRTH DATE,
    CADDRESS VARCHAR2(50),
    CRDATE DATE DEFAULT SYSDATE,
    USERGRADE NUMBER(1) REFERENCES USERLEVEL(USERGRADE)
);

CREATE TABLE BOARD(
    FNO NUMBER(5) PRIMARY KEY,
    CID VARCHAR2(50) REFERENCES CUSTOMER(CID),
    FTITLE VARCHAR2(100) NOT NULL,
    FCONTENT VARCHAR2(2000),
    FFILENAME VARCHAR2(100),
    FREADCOUNT NUMBER(7) DEFAULT 0 NOT NULL,
    FDATE DATE DEFAULT SYSDATE,
    FIP VARCHAR2(50) NOT NULL,
    FREF NUMBER(5) NOT NULL,
    FRE_STEP NUMBER(5) NOT NULL,
    FRE_LEVEL NUMBER(5) DEFAULT 0 NOT NULL
);

DROP SEQUENCE BOARD_SQ;

CREATE SEQUENCE BOARD_SQ
    NOCACHE
    NOCYCLE;

SELECT * FROM CUSTOMER;

INSERT INTO USERLEVEL VALUES(0, '사용자');
INSERT INTO USERLEVEL VALUES(1, '관리자');


-- 회원가입
INSERT INTO CUSTOMER(CID, CPW, CNAME, CEMAIL, CFILE, CBIRTH, CADDRESS, USERGRADE)
    VALUES ('BBB', '111', '홍길동', 'AAA@HONG.COM', NULL,  TO_DATE('1991-11-04'), '서울시', 0);

-- 로그인 
SELECT * FROM CUSTOMER WHERE CID = 'BBB' AND CPW = '111';

-- 회원정보 수정
UPDATE CUSTOMER 
    SET CPW = '111',
         CNAME = '김길동',
         CEMAIL = 'BBB@HONG.COM',
         CFILE = 'FILE.JPG',
         CBIRTH = '1991-11-05',
         CADDRESS = '남양주'
    WHERE CID = 'AAA';

-- 글쓰기
INSERT INTO BOARD(FNO, CID, FTITLE, FCONTENT, FFILENAME, FIP, FREF, FRE_STEP, FRE_LEVEL)
    VALUES(BOARD_SQ.NEXTVAL, 'BBB', '글2', '글내용1', NULL,'123.123.123.12', BOARD_SQ.CURRVAL,0,0 );
INSERT INTO BOARD(FNO, CID, FTITLE, FCONTENT, FFILENAME, FIP, FREF, FRE_STEP, FRE_LEVEL)
    VALUES(BOARD_SQ.NEXTVAL, 'BBB', '글3', '글내용1', NULL,'123.123.123.12', BOARD_SQ.CURRVAL,0,0 );
INSERT INTO BOARD(FNO, CID, FTITLE, FCONTENT, FFILENAME, FIP, FREF, FRE_STEP, FRE_LEVEL)
    VALUES(BOARD_SQ.NEXTVAL, 'BBB', '글4', '글내용1', NULL,'123.123.123.12', BOARD_SQ.CURRVAL,0,0 );
INSERT INTO BOARD(FNO, CID, FTITLE, FCONTENT, FFILENAME, FIP, FREF, FRE_STEP, FRE_LEVEL)
    VALUES(BOARD_SQ.NEXTVAL, 'BBB', '글5', '글내용1', NULL,'123.123.123.12', BOARD_SQ.CURRVAL,0,0 );
INSERT INTO BOARD(FNO, CID, FTITLE, FCONTENT, FFILENAME, FIP, FREF, FRE_STEP, FRE_LEVEL)
    VALUES(BOARD_SQ.NEXTVAL, 'BBB', '글6', '글내용1', NULL,'123.123.123.12', BOARD_SQ.CURRVAL,0,0 );

-- 답글쓰기 
UPDATE BOARD SET FRE_STEP = FRE_STEP +1 WHERE FREF=8 AND FRE_STEP>0;

INSERT INTO BOARD(FNO, CID, FTITLE, FCONTENT, FFILENAME, FIP, FREF, FRE_STEP, FRE_LEVEL)
    VALUES(BOARD_SQ.NEXTVAL, 'BBB', '글6', '글내용1', NULL,'123.123.123.12', BOARD_SQ.CURRVAL,1,1 );

    
-- 글 목록
    SELECT *
        FROM(SELECT ROWNUM RN, A.* 
                    FROM (SELECT B.FNO, C.CNAME, B.FTITLE, B.FREADCOUNT, B.FDATE, B.FIP 
                                FROM BOARD B, CUSTOMER C 
                                    WHERE C.CID= B.CID) A) WHERE RN BETWEEN 3 AND 5 ;

-- 글 보기
SELECT * FROM BOARD WHERE FNO = 1;

-- 글 수정 
UPDATE BOARD 
    SET FTITLE = '글2',
         FCONTENT = '글내용2',
         FFILENAME = 'FILE.JPG', 
         FIP = '123.123.123.12'
    WHERE CID = 'BBB';

-- 글 삭제
DELETE FROM BOARD WHERE FNO = 3;

-- 관리자 등록 
INSERT INTO CUSTOMER(CID, CPW, CNAME, CEMAIL, CFILE, CBIRTH, CADDRESS, USERGRADE)
    VALUES ('관리자ID', '111', '관리자', 'AAA@HONG.COM', NULL,  NULL, NULL, 1);

--관리자 로그인 
SELECT * FROM CUSTOMER WHERE CID = '관리자ID' AND CPW ='111';














