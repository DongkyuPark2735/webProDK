DROP TABLE MVC2MEMBER;

DROP TABLE FILEBOARD;

DROP TABLE ADMIN;

-- member

CREATE TABLE MVC2MEMBER(
    MID VARCHAR2(30) PRIMARY KEY,
    MPW VARCHAR2(30) NOT NULL,
    MNAME VARCHAR2(30) NOT NULL,
    MEMAIL VARCHAR2(30) UNIQUE,
    MPHOTO VARCHAR2(30) NOT NULL,
    MBIRTH DATE, 
    MADDRESS VARCHAR2(300),
    MRDATE DATE DEFAULT SYSDATE
);
select * from MVC2MEMBER;
-- DUMMY DATA
INSERT INTO MVC2MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('gayun','1','김가연','gayun@naver.com','gayun.jpg','1972/09/09','광주광역시');
INSERT INTO MVC2MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('gico','1','지코','gico@naver.com','gico.jpg','1992/09/14','서울시');
INSERT INTO MVC2MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('go','1','고소영','go@naver.com','go.jpg','1972/10/06','서울시');
INSERT INTO MVC2MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('ham','1','함소원','ham@naver.com','ham.jpg','1976/06/16','서울시');
INSERT INTO MVC2MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('han','1','한지민','han@naver.com','han.jpg','1982/11/05','서울시');
INSERT INTO MVC2MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('jang','1','장동건',null,'jang.jpg',null,null);
INSERT INTO MVC2MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('jo','1','조현우',null,'jo.jpg',null,null);
INSERT INTO MVC2MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('kang','1','강동원',null,'kang.jpg',null,null);
INSERT INTO MVC2MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('kim','1','김태희',null,'kim.jpg',null,null);
INSERT INTO MVC2MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('lee','1','이선빈',null,'lee.jpg',null,null);
INSERT INTO MVC2MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('lim','1','임요한',null,'lim.jpg',null,null);
INSERT INTO MVC2MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('park','1','박보검',null,'park.jpg',null,null);
INSERT INTO MVC2MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('rain','1','비',null,'rain.jpg',null,null);
INSERT INTO MVC2MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('s','1','송가연',null,'s.jpg',null,null);
INSERT INTO MVC2MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('son','1','손흥민',null,'son.jpg',null,null);
INSERT INTO MVC2MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('song','1','송중기',null,'song.jpg',null,null);
INSERT INTO MVC2MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)
    VALUES ('song2','1','송혜교',null,'song2.jpg',null,null);

-- FILEBOARD
DROP SEQUENCE FILEBOARD_SEQ;
CREATE SEQUENCE FILEBOARD_SEQ MAXVALUE 999999 NOCACHE NOCYCLE;


CREATE TABLE FILEBOARD(
    FID NUMBER(6) PRIMARY KEY,
    MID VARCHAR2(30) REFERENCES MVC2MEMBER(MID),
    FTITLE VARCHAR2(100) NOT NULL,
    FCONTENT VARCHAR2(4000),
    FFILENAME VARCHAR2(100),
    FRDATE DATE DEFAULT SYSDATE,
    FHIT NUMBER(6) DEFAULT 0,
    FGROUP NUMBER(6) NOT NULL,
    FSTEP NUMBER(6) NOT NULL,
    FINDENT NUMBER(6) NOT NULL,
    FIP VARCHAR2(30) NOT NULL  
);


CREATE TABLE ADMIN(
    AID VARCHAR2(20) PRIMARY KEY,
    APW VARCHAR2(30) NOT NULL,
    ANAME VARCHAR2(30) NOT NULL
);

-- 더미데이터(원글)
INSERT INTO FILEBOARD (FID, MID, FTITLE, FCONTENT, FFILENAME,  
        FGROUP, FSTEP, FINDENT, FIP)
    VALUES (FILEBOARD_SEQ.NEXTVAL, 'go','title','content',null, 
        FILEBOARD_SEQ.CURRVAL, 0, 0, '192.168.20.31');
        
SELECT * FROM FILEBOARD ORDER BY FGROUP DESC, FSTEP;
-- 더미데이터(위의 1번글에 대한 첫번째 답변글)
INSERT INTO FILEBOARD (FID, MID, FTITLE, FCONTENT, FFILENAME,
        FGROUP, FSTEP, FINDENT, FIP)
    VALUES (FILEBOARD_SEQ.NEXTVAL, 'gico','reply1','content', null,
        1, 1, 1, '192.168.20.31');
-- 더미데이터 (위의 1번글에 대한 두번째 답변글)
--    답변글 추가전 STEP a 수행
UPDATE FILEBOARD SET FSTEP = FSTEP+1 
    WHERE FGROUP = 1 AND FSTEP>0;
INSERT INTO FILEBOARD (FID, MID, FTITLE, FCONTENT, FFILENAME,
        FGROUP, FSTEP, FINDENT, FIP)
    VALUES (FILEBOARD_SEQ.NEXTVAL, 'jang','reply2','content', null,
        1, 1, 1, '192.168.10.151');
SELECT * FROM FILEBOARD ORDER BY FGROUP DESC, FSTEP;


INSERT INTO ADMIN VALUES ('admin','111','김관리');
SELECT * FROM ADMIN;


