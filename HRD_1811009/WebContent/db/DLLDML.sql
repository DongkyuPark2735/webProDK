DROP TABLE MEMBER_TBL_02;
CREATE TABLE MEMBER_TBL_02(
	CUSTNO NUMBER(6) PRIMARY KEY NOT NULL,
	CUSTNAME VARCHAR2(20),
	PHONE VARCHAR2(13),
	ADDRESS VARCHAR2(60),
	JOINDATE DATE,
	GRADE CHAR(1),
	CITY CHAR(2)
);
DROP SEQUENCE MEMBER_SEQ;

CREATE SEQUENCE MEMBER_SEQ NOCYCLE NOCACHE;
SELECT * FROM MEMBER_TBL_02;
INSERT INTO MEMBER_TBL_02(CUSTNO, CUSTNAME, PHONE, ADDRESS, JOINDATE, GRADE, CITY) 
	VALUES(MEMBER_SEQ.NEXTVAL, '김행복', '010-1111-2222', '서울 동대문구 휘경1동', TO_DATE('20151202','YYYYMMDD'), 'A', '01' ); 
INSERT INTO MEMBER_TBL_02(CUSTNO, CUSTNAME, PHONE, ADDRESS, JOINDATE, GRADE, CITY) 
	VALUES(MEMBER_SEQ.NEXTVAL, '이축복', '010-1111-3333', '서울 동대문구 휘경2동', TO_DATE('20151206','YYYYMMDD'), 'B', '01' ); 
INSERT INTO MEMBER_TBL_02(CUSTNO, CUSTNAME, PHONE, ADDRESS, JOINDATE, GRADE, CITY) 
	VALUES(MEMBER_SEQ.NEXTVAL, '장믿음', '010-1111-4444', '울른궁 울릉읍 독도 1리', TO_DATE('20151001','YYYYMMDD'), 'B', '30' ); 
INSERT INTO MEMBER_TBL_02(CUSTNO, CUSTNAME, PHONE, ADDRESS, JOINDATE, GRADE, CITY) 
	VALUES(MEMBER_SEQ.NEXTVAL, '최사랑', '010-1111-5555', '울릉군 울릉읍 독도2리', TO_DATE('20151113','YYYYMMDD'), 'A', '30' ); 
INSERT INTO MEMBER_TBL_02(CUSTNO, CUSTNAME, PHONE, ADDRESS, JOINDATE, GRADE, CITY) 
	VALUES(MEMBER_SEQ.NEXTVAL, '진평화', '010-1111-6666', '제주도 제주시 외나무골', TO_DATE('20151225','YYYYMMDD'), 'B', '60' ); 
INSERT INTO MEMBER_TBL_02(CUSTNO, CUSTNAME, PHONE, ADDRESS, JOINDATE, GRADE, CITY) 
	VALUES(MEMBER_SEQ.NEXTVAL, '차공단', '010-1111-7777', '제주도 제주시 감나무골', TO_DATE('20151211','YYYYMMDD'), 'C', '60' ); 


	
	
DROP TABLE MONEY_TBL_02;

CREATE TABLE MONEY_TBL_02(
	CUSTNO NUMBER(6), 
	SALENOL NUMBER(8) PRIMARY KEY NOT NULL,
	PCOST NUMBER(8),
	AMOUNT NUMBER(4),
	PRICE NUMBER(8),
	PCODE VARCHAR2(4),
	SDATE DATE
);

INSERT INTO MONEY_TBL_02(CUSTNO, SALENOL, PCOST, AMOUNT, PRICE, PCODE, SDATE)
	VALUES(100001, 2016001, 500, 5, 2500, 'A001', TO_DATE('20160101','YYYYMMDD'));
INSERT INTO MONEY_TBL_02(CUSTNO, SALENOL, PCOST, AMOUNT, PRICE, PCODE, SDATE)
	VALUES(100001, 2016002, 1000, 4, 4000, 'A002', TO_DATE('20160101','YYYYMMDD'));
INSERT INTO MONEY_TBL_02(CUSTNO, SALENOL, PCOST, AMOUNT, PRICE, PCODE, SDATE)
	VALUES(100001, 2016003, 500, 3, 1500, 'A008', TO_DATE('20160101','YYYYMMDD'));
INSERT INTO MONEY_TBL_02(CUSTNO, SALENOL, PCOST, AMOUNT, PRICE, PCODE, SDATE)
	VALUES(100002, 2016004, 2000, 1, 2000, 'A001', TO_DATE('20160102','YYYYMMDD'));
	
INSERT INTO MONEY_TBL_02(CUSTNO, SALENOL, PCOST, AMOUNT, PRICE, PCODE, SDATE)
	VALUES(100002, 2016005, 500, 1, 500, 'A001', TO_DATE('20160103','YYYYMMDD'));
	
INSERT INTO MONEY_TBL_02(CUSTNO, SALENOL, PCOST, AMOUNT, PRICE, PCODE, SDATE)
	VALUES(100003, 2016006, 1500, 2, 3000, 'A003', TO_DATE('20160103','YYYYMMDD'));

INSERT INTO MONEY_TBL_02(CUSTNO, SALENOL, PCOST, AMOUNT, PRICE, PCODE, SDATE)
	VALUES(100004, 2016007, 500, 2, 1000, 'A001', TO_DATE('20160104','YYYYMMDD'));
INSERT INTO MONEY_TBL_02(CUSTNO, SALENOL, PCOST, AMOUNT, PRICE, PCODE, SDATE)
	VALUES(100004, 2016008, 300, 1, 300, 'A005', TO_DATE('20160104','YYYYMMDD'));
INSERT INTO MONEY_TBL_02(CUSTNO, SALENOL, PCOST, AMOUNT, PRICE, PCODE, SDATE)
	VALUES(100004, 2016009, 600, 1, 600, 'A006', TO_DATE('20160104','YYYYMMDD'));
INSERT INTO MONEY_TBL_02(CUSTNO, SALENOL, PCOST, AMOUNT, PRICE, PCODE, SDATE)
	VALUES(100004, 2016010, 3000, 1, 3000, 'A007', TO_DATE('20160106','YYYYMMDD'));

SELECT * FROM MONEY_TBL_02;


	
-- 회원등록
INSERT INTO MEMBER_TBL_02(CUSTNO, CUSTNAME, PHONE, ADDRESS, JOINDATE, GRADE, CITY) 
	VALUES(MEMBER_SEQ.NEXTVAL, '김등록', '010-1111-2222', '서울 동대문구 휘경1동', TO_DATE('20151202','YYYYMMDD'), 'A', '01' ); 
-- 회원 리스트 
SELECT CUSTNO, CUSTNAME, PHONE, ADDRESS, TO_DATE(JOINDATE, 'YY-MM-DD') JOINDATE, GRADE, CITY 
	FROM MEMBER_TBL_02 
		ORDER BY CUSTNO;
commit;
-- 회원 dto 가져오기 
SELECT CUSTNO, CUSTNAME, PHONE, ADDRESS, TO_DATE(JOINDATE, 'YY-MM-DD'), GRADE, CITY
	FROM MEMBER_TBL_02
	 WHERE CUSTNO = '1';
-- 회원 매출 조회  == 회원별 매출 합계  매출 높은순 없으면 출력 x
SELECT * FROM MONEY_TBL_02;

SELECT MO.CUSTNO, CUSTNAME, GRADE, SUM(PRICE) SUM 
	FROM MONEY_TBL_02 MO, MEMBER_TBL_02 ME
	WHERE MO.CUSTNO = ME.CUSTNO
		GROUP BY MO.CUSTNO ORDER BY SUM DESC; 










	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	