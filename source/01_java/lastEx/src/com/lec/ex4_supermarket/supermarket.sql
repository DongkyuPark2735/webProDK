DROP TABLE CUS_LEVEL;
DROP TABLE CUSTOMER;

CREATE TABLE CUSLEVEL(
    LEVELNO NUMBER(1) PRIMARY KEY,
    LEVELNAME VARCHAR(20) NOT NULL,
    LOW NUMBER(9,2) NOT NULL,
    HIGH NUMBER(9,2) NOT NULL
);
SELECT * FROM CUSLEVEL;
CREATE TABLE CUSTOMER(
    CUSID NUMBER(9) PRIMARY KEY,
    CUSNAME VARCHAR2(20) NOT NULL,
    CUSTEL VARCHAR(20) NOT NULL UNIQUE,
    CUSPOINT NUMBER(9),
    CUSAMOUNT NUMBER(9),
    LEVELNO REFERENCES CUSLEVEL(LEVELNO) NOT NULL
);
SELECT * FROM CUSTOMER;

INSERT INTO CUSLEVEL VALUES(1, 'BRONZE', 1000,10000);
INSERT INTO CUSLEVEL VALUES(2, 'SILVER', 10001,100000);
INSERT INTO CUSLEVEL VALUES(3, 'GOLD', 100001,300000);
INSERT INTO CUSLEVEL VALUES(4, 'DIAMOND', 300001,9999999);

DROP SEQUENCE CUSTOMER_SQ;
CREATE SEQUENCE CUSTOMER_SQ
    NOCACHE
    NOCYCLE

INSERT INTO CUSTOMER VALUES(TO_CHAR(SYSDATE,'YYYY') || TOCHAR(CUSTOMER_SQ.NEXTVAL, '0000'), '홍길동','010-9999-9999'
                                         ,10000, 1000000,)  );














-- 0. 레벨이름들 검색 : public Vector<String> getLevelNames()
-- 1. cId로 검색 : public CustomerDto cIdGetCustomer(int cId)
-- 2. 폰뒤4자리(FULL) 검색 - CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, 레벨업을 위한 쓸 돈
-- public ArrayList<CustomerDto> cTelGetCustomers(String cTel);
-- 3. 고객이름검색 - CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, 레벨업을 위한 쓸 돈
-- public ArrayList<CustomerDto> cNameGetCustomers(String cName);
-- 4. 포인트로만 구매(1000원짜리를 포인트로만 구매) : public int buyWithPoint(int cAmount, int cId)
-- 5. 물품구매 (1000000원짜리를 구매할 경우. 포인트는 구매금액의 5%)
-- 물품구매시 UPDATE 2회 필요(구매누적금액 UPDATE와 LEVELNO UPDATE)
-- public int buy(int cAmount, int cId)
-- 6. 등급별출력 - CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, 레벨업을위한쓸돈
-- public ArrayList<CustomerDto> levelNameGetCustomers(String levelName)
-- 7.전체출력 - CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, 레벨업을위한쓸돈
-- public ArrayList<CustomerDto> getCustomers()
-- 8. 회원가입(고객전화와 고객이름은 입력받아 INSERT)
-- public int insertCustomer(String cTel, String cName)
-- 9. 번호수정 : public int updateCustomer(String cTel, int cId)
-- 10. 회원탈퇴 : public int deleteCustomer(String cTel

