DROP TABLE MVCMEMBER;

CREATE TABLE MVCMEMBER(
    MID VARCHAR2(30) PRIMARY KEY,
    MPW VARCHAR2(30) NOT NULL,
    MNAME VARCHAR2(30) NOT NULL,
    MEMAIL VARCHAR2(30),
    MPHOTO VARCHAR2(30) NOT NULL,
    MBIRTH DATE, 
    MADDRESS VARCHAR2(300),
    MRDATE DATE DEFAULT SYSDATE
);
-- 파일첨부 안했을때 QURY문이 다름 ? 파일첨부 디폴트값 파일명 넣으면 


-- 로그인
SELECT * FROM MVCMEMBER WHERE MID = 'AAA' AND MPW = '111';

-- 회원가입시 중복체크 
SELECT * FROM MVCMEMBER WHERE MID = 'AAA';

-- 회원가입
INSERT INTO MVCMEMBER(MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS) 
    VALUES('BBB', '111', '홍길동', 'EE@EE.COM', 'NOTHING.JPG', TO_DATE('1991-11-04', 'YYYY/MM/DD'), '서울시' );

SELECT * FROM MVCMEMBER;
-- 정보수정
UPDATE MVCMEMBER SET MNAME = '김길동',
                                MEMAIL = 'EE@EE.COM',
                                MPHOTO = 'NOTHING.JPG',
                                MBIRTH = '1991-10-04',
                                MADDRESS = '남양주시' WHERE MID = 'BBB';
-- 회원 리스트
SELECT *  FROM (SELECT ROWNUM RN, A.*
                         FROM(SELECT * 
                                    FROM MVCMEMBER ORDER BY MRDATE DESC) A)
                                          WHERE RN BETWEEN 2 AND 3;
                                                
-- MID로 DTO가져오기 
SELECT * FROM MVCMEMBER WHERE MID = 'AAA';


-- 회원수 
SELECT COUNT(*) FROM MVCMEMBER;



-- DUMMY 
INSERT INTO MVCMEMBER (mID, mPw, mName, mEmail, mPhoto, mBirth, mAddress)
    VALUES ('gayun','1','김가연','gayun@naver.com','gayun.jpg','1972/09/09','광주광역시');
INSERT INTO MVCMEMBER (mID, mPw, mName, mEmail, mPhoto, mBirth, mAddress)
    VALUES ('gico','1','지코','gico@naver.com','gico.jpg','1992/09/14','서울시');
INSERT INTO MVCMEMBER (mID, mPw, mName, mEmail, mPhoto, mBirth, mAddress)
    VALUES ('go','1','고소영','go@naver.com','go.jpg','1972/10/06','서울시');
INSERT INTO MVCMEMBER (mID, mPw, mName, mEmail, mPhoto, mBirth, mAddress)
    VALUES ('ham','1','함소원','ham@naver.com','ham.jpg','1976/06/16','서울시');
INSERT INTO MVCMEMBER (mID, mPw, mName, mEmail, mPhoto, mBirth, mAddress)
    VALUES ('han','1','한지민','han@naver.com','han.jpg','1982/11/05','서울시');
    
commit;
    