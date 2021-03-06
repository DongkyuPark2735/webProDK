-- CUS_LEVEL테이블 삭제 
DROP TABLE CUS_LEVEL;
-- CUS_LEVEL테이블 생성
CREATE TABLE CUS_LEVEL(
    LEVELNO NUMBER(2) PRIMARY KEY,
    LEVELNAME VARCHAR2(20) NOT NULL
);
-- CUSTOMER 테이블 삭제
DROP TABLE CUSTOMER;
-- CUSTOMER 테이블 생성
CREATE TABLE CUSTOMER(
    CNO NUMBER(2) PRIMARY KEY,
    CNAME VARCHAR2(20) NOT NULL,
    JOINDATE DATE DEFAULT SYSDATE,
    POINT NUMBER(20),
    PHONE VARCHAR2(20) UNIQUE NOT NULL,
    LEVELNO NUMBER(2) REFERENCES CUS_LEVEL(LEVELNO)
);
-- CUS_SQ 시퀀스 생성
DROP SEQUENCE CUS_SQ;
CREATE SEQUENCE CUS_SQ
    NOCACHE
    NOCYCLE
    MAXVALUE 99;
    
-- CUS_LEVEL 정보 입력
INSERT INTO CUS_LEVEL VALUES(1, 'VVIP');
INSERT INTO CUS_LEVEL VALUES(2, 'VIP');
INSERT INTO CUS_LEVEL VALUES(3, 'NORMAL');
INSERT INTO CUS_LEVEL VALUES(4, 'BLACK');

SELECT * FROM CUS_LEVEL;

-- CUSTOMER 정보 입력
INSERT INTO CUSTOMER VALUES(CUS_SQ.NEXTVAL, '홍길동', TO_DATE('2022-03-10', 'YYYY-MM-DD'), 0, '010-9999-9999', 1);
INSERT INTO CUSTOMER(CNO, CNAME, PHONE, LEVELNO) VALUES(CUS_SQ.NEXTVAL, '이철수',  '010-8888-8888', 2);

SELECT * FROM CUSTOMER;

-- 출력
SELECT CNO, CNAME, TO_DATE(JOINDATE, 'YYYY-MM-DD') "JOINDATE" , PHONE, POINT, LEVELNAME
    FROM CUSTOMER C, CUS_LEVEL CL
    WHERE C.LEVELNO = CL.LEVELNO;


