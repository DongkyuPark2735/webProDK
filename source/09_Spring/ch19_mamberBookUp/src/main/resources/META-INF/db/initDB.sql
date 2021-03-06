-- SEQUENCE & TABLE DROP / CREATE
DROP TABLE BOOK;

DROP TABLE MEMBER;

DROP SEQUENCE BOOK_SQ;

CREATE TABLE MEMBER(
    MID VARCHAR2(100) PRIMARY KEY,
    MPW VARCHAR2(100) NOT NULL,
    MNAME VARCHAR2(100) NOT NULL,
    MMAIL VARCHAR2(100) NOT NULL,
    MPOST VARCHAR2(100),
    MADDR VARCHAR2(100)
    );

CREATE SEQUENCE BOOK_SQ MAXVALUE 999999999 NOCYCLE NOCACHE;
CREATE TABLE BOOK(
    BNUM NUMBER(8) PRIMARY KEY,
    BTITLE VARCHAR2(100) NOT NULL,
    BWRITER VARCHAR2(100) NOT NULL,
    BRDATE DATE DEFAULT SYSDATE NOT NULL,
    BIMG1  VARCHAR(1000) DEFAULT 'noImg.png' NOT NULL,
    BIMG2  VARCHAR(1000) DEFAULT'noImg.png' NOT NULL,
    BINFO VARCHAR2(4000)
);


-- DUMMY DATA INSERT
INSERT INTO MEMBER VALUES('AAA', '1', '홍길동', 'HONG@NAVER.COM', '123450', '서울');

INSERT INTO BOOK VALUES(BOOK_SQ.NEXTVAL, 'SPRING', '김작가', SYSDATE, 'noImg.png', 'noImg.png', '스프링 개념서');

INSERT INTO BOOK(BNUM, BTITLE, BWRITER, BRDATE, BIMG1, BINFO) 
    VALUES(BOOK_SQ.NEXTVAL, 'JSP', '박제이', SYSDATE, 'noImg.png', '스프링 개념서');
INSERT INTO BOOK(BNUM, BTITLE, BWRITER, BRDATE, BIMG2, BINFO) 
    VALUES(BOOK_SQ.NEXTVAL, 'SPRING', '김제이', SYSDATE, 'noImg.png', '스프링 개념서');
INSERT INTO BOOK(BNUM, BTITLE, BWRITER, BRDATE, BIMG1, BIMG2, BINFO) 
    VALUES(BOOK_SQ.NEXTVAL, 'ORACLE', '최제이', SYSDATE, 'noImg.png', 'noImg.png', 'ORACLE 개념서');

select * from member;
commit;
-- DUMMY DATA INSERT
















-- admin
DROP TABLE DVADMIN;
CREATE TABLE DVADMIN(
    ADID VARCHAR2(10) PRIMARY KEY,
    ADPW VARCHAR2(30) NOT NULL,
    ADNAME VARCHAR2(15) NOT NULL
    
);



















