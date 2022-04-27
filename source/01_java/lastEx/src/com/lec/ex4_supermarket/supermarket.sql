-- ���̺� ���� 
DROP TABLE CUSLEVEL;
DROP TABLE CUSTOMER; -- ���� ���̺� ���� ���� 
-- DROP TABLE CUS_LEVEL CASCADE CONSTRAINTS; -- ����, ���� �����ϰ� ���� 
DROP SEQUENCE CUSTOMER_SQ;

-- ���̺� ���� 
CREATE TABLE CUSLEVEL(
    LEVELNO NUMBER(1,0) PRIMARY KEY,
    LEVELNAME VARCHAR(20) NOT NULL,
    LOW NUMBER(9,0) NOT NULL,
    HIGH NUMBER(9,0) NOT NULL
);
SELECT * FROM CUSLEVEL;
CREATE TABLE CUSTOMER(
    CUSID NUMBER(6) PRIMARY KEY,
    CUSNAME VARCHAR2(20) NOT NULL,
    CUSTEL VARCHAR(20) NOT NULL UNIQUE, -- ��ȭ��ȣ�� �ݵ�� VARCHAR2 0�� ���󰡱⶧��
    CUSPOINT NUMBER(9) DEFAULT 1000, 
    CUSAMOUNT NUMBER(9) DEFAULT 0,
    LEVELNO  NUMBER(1,0) DEFAULT 1,
    FOREIGN KEY(LEVELNO) REFERENCES CUSLEVEL(LEVELNO)
);

CREATE SEQUENCE CUSTOMER_SQ
    MAXVALUE 999999
    NOCACHE
    NOCYCLE;

SELECT * FROM CUSTOMER;

INSERT INTO CUSLEVEL VALUES(1, 'BRONZE', 0,999999);
INSERT INTO CUSLEVEL VALUES(2, 'SILVER', 1000000,1999999);
INSERT INTO CUSLEVEL VALUES(3, 'GOLD', 2000000,2999999);
INSERT INTO CUSLEVEL VALUES(4, 'DIAMOND', 3000000,3999999);
INSERT INTO CUSLEVEL VALUES(5, 'VVIP', 4000000,999999999);

--INSERT INTO CUSTOMER VALUES((TO_CHAR(SYSDATE,'YYYY')||TRIM(TO_CHAR(CUSTOMER_SQ.NEXTVAL, '0000'))), 'ȫ�浿','010-9999-9999'
--                                         ,10000, 1000000, 1);
--INSERT INTO CUSTOMER VALUES((TO_CHAR(SYSDATE,'YYYY')||TRIM(TO_CHAR(CUSTOMER_SQ.NEXTVAL, '0000'))), '�̱浿','010-9786-9559'
--                                         ,20000, 3000000, 3);
--INSERT INTO CUSTOMER VALUES((TO_CHAR(SYSDATE,'YYYY')||TRIM(TO_CHAR(CUSTOMER_SQ.NEXTVAL, '0000'))), '��浿','010-9719-9111'
--                                         ,30000, 4000000, 4);

INSERT INTO CUSTOMER (CUSID, CUSNAME, CUSTEL) VALUES (CUSTOMER_SQ.NEXTVAL,  'ȫ�浿','010-9999-9999');
INSERT INTO CUSTOMER VALUES (CUSTOMER_SQ.NEXTVAL,  '�ڱ浿','010-8888-9999', 0 ,4000000 , 5);
INSERT INTO CUSTOMER VALUES (CUSTOMER_SQ.NEXTVAL, '�ű浿','010-7777-7777' , 0 ,100000 , 1);


SELECT * FROM CUSTOMER;
-- 0. ���� �̸��� �˻� : Vector<String> getLevelNames()
SELECT LEVELNAME FROM CUSLEVEL;
-- 1. ���̵� �˻� : CustomerDTO cidGetCustomer( int )
    -- CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, forLevelUp
(SELECT CUSID FROM CUSTOMER  WHERE CUSID = 99);
SELECT CUSID, CUSTEL, CUSNAME, CUSPOINT, CUSAMOUNT, LEVELNAME,
        (SELECT HIGH +1 - CUSAMOUNT FROM CUSTOMER WHERE CUSID = C.CUSID AND LEVELNO != 5)  forLevelUp
    FROM CUSTOMER C, CUSLEVEL L
    WHERE C.LEVELNO = L.LEVELNO AND CUSID = 1;
-- 2. ��4�ڸ� �˻� : ArrayList<CustomerDTO> cTelGetCustomer(String cTel);
    -- CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, forLevelUp
SELECT CUSID, CUSTEL, CUSNAME, CUSPOINT, CUSAMOUNT, LEVELNAME,
        (SELECT HIGH +1 - CUSAMOUNT FROM CUSTOMER WHERE CUSID = C.CUSID AND LEVELNO != 5)  forLevelUp
    FROM CUSTOMER C, CUSLEVEL L
    WHERE C.LEVELNO = L.LEVELNO AND CUSTEL LIKE '%'||'9999';
-- 3. �� �̸� �˻� :  ArrayList<CustomerDTO> cNameGetCustomer(String cName);
    -- CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, forLevelUp
SELECT CUSID, CUSTEL, CUSNAME, CUSPOINT, CUSAMOUNT, LEVELNAME,
        (SELECT HIGH +1 - CUSAMOUNT FROM CUSTOMER WHERE CUSID = C.CUSID AND LEVELNO != 5)  forLevelUp
    FROM CUSTOMER C, CUSLEVEL L
    WHERE C.LEVELNO = L.LEVELNO AND CUSNAME = 'ȫ�浿' ORDER BY CUSAMOUNT DESC;
-- 4. ����Ʈ�θ� ���� : Int buyWithPoint(int cId, int cAmoint) (1�� ID�� 100�� ����)
    -- 
UPDATE CUSTOMER SET CUSPOINT = CUSPOINT - 100 WHERE CUSID = 1  ;
UPDATE CUSTOMER SET CUSPOINT = CUSPOINT +300000 WHERE CUSID = 3  ;

COMMIT;
-- 5. ��ǰ ���� : int buy(int cId, int cAmount ) 
    -- ��ǰ���� update���� cpoint, cAmount, levelNo�� ���� �Ǿ���� 
    -- 5-1 CUSPOINT, CUSAMOUNT ����
UPDATE CUSTOMER SET CUSPOINT = CUSPOINT + (1000000*0.05), CUSAMOUNT = CUSAMOUNT + 1000000 WHERE CUSID = 1  ;

SELECT * FROM CUSTOMER;
    -- 5-2 LEVELNO �����ϱ� �� �� ������ȣ�� ������ ���� ��ȣ
SELECT CUSID, CUSNAME,CUSAMOUNT, C.LEVELNO , L.LEVELNO 
    FROM CUSTOMER C, CUSLEVEL L
    WHERE CUSAMOUNT BETWEEN LOW AND HIGH AND CUSID = 1;
    -- 5-3 LEVELNO
UPDATE CUSTOMER SET LEVELNO = (
SELECT L.LEVELNO �����ҷ��� 
    FROM CUSTOMER C, CUSLEVEL L
    WHERE CUSAMOUNT BETWEEN LOW AND HIGH AND CUSID = 1)
    WHERE CUSID = 1;
    -- 5-1�� 5-3�� �ѹ��忡 
UPDATE CUSTOMER SET CUSPOINT = CUSPOINT + (1000000*0.05), CUSAMOUNT = CUSAMOUNT + 1000000,
    LEVELNO = (SELECT L.LEVELNO �����ҷ��� 
                     FROM CUSTOMER C, CUSLEVEL L
                     WHERE CUSAMOUNT+1000000 BETWEEN LOW AND HIGH AND CUSID = 1)
                     WHERE CUSID = 1; -- DAO�� �� ����  -- �ٱ��� CUSID ��� ��?
    
-- 6. ��޺� ��� : ArrayList<CustomerDTO> levelNameGetCustomer(String levelName) 
        -- CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, forLevelUp
SELECT CUSID, CUSTEL, CUSNAME, CUSPOINT, CUSAMOUNT, LEVELNAME,
        (SELECT HIGH +1 - CUSAMOUNT FROM CUSTOMER WHERE CUSID = C.CUSID AND LEVELNO != 5)  forLevelUp
    FROM CUSTOMER C, CUSLEVEL L
    WHERE C.LEVELNO = L.LEVELNO AND LEVELNAME = 'BRONZE' ORDER BY CUSAMOUNT DESC;
-- 7. ��ü ��� : ArrayList<CustomerDTO>getCustomers() 
        -- CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, forLevelUp
SELECT CUSID, CUSTEL, CUSNAME, CUSPOINT, CUSAMOUNT, LEVELNAME,
        (SELECT HIGH +1 - CUSAMOUNT FROM CUSTOMER WHERE CUSID = C.CUSID AND LEVELNO != 5)  forLevelUp
    FROM CUSTOMER C, CUSLEVEL L
    WHERE C.LEVELNO = L.LEVELNO ORDER BY CUSAMOUNT DESC;
-- 8. ȸ������ : int insertCustomer(String cTel,Stirng cName)
                -- int insertCustomer(CustomerDTO dto)
INSERT INTO CUSTOMER(CUSID, CUSTEL, CUSNAME)
    VALUES (CUSTOMER_SQ.NEXTVAL, '010-6666-6666', '���浿');
    SELECT * FROM CUSTOMER;
-- 9. ��ȣ ���� : int updateCustomer(int cId, String cTel) 
 UPDATE CUSTOMER SET CUSTEL = '010-5555-5555' WHERE CUSID = 4;
-- 10. ȸ�� Ż�� :  int deleteCustomer(String cTel)
DELETE FROM CUSTOMER WHERE CUSTEL = '010-5555-5555';
COMMIT;








-- 0. �����̸��� �˻� : public Vector<String> getLevelNames()
-- 1. cId�� �˻� : public CustomerDto cIdGetCustomer(int cId)
-- 2. ����4�ڸ�(FULL) �˻� - CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, �������� ���� �� ��
-- public ArrayList<CustomerDto> cTelGetCustomers(String cTel);
-- 3. ���̸��˻� - CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, �������� ���� �� ��
-- public ArrayList<CustomerDto> cNameGetCustomers(String cName);
-- 4. ����Ʈ�θ� ����(1000��¥���� ����Ʈ�θ� ����) : public int buyWithPoint(int cAmount, int cId)
-- 5. ��ǰ���� (1000000��¥���� ������ ���. ����Ʈ�� ���űݾ��� 5%)
-- ��ǰ���Ž� UPDATE 2ȸ �ʿ�(���Ŵ����ݾ� UPDATE�� LEVELNO UPDATE)
-- public int buy(int cAmount, int cId)
-- 6. ��޺���� - CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, �����������Ѿ���
-- public ArrayList<CustomerDto> levelNameGetCustomers(String levelName)
-- 7.��ü��� - CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, �����������Ѿ���
-- public ArrayList<CustomerDto> getCustomers()
-- 8. ȸ������(����ȭ�� ���̸��� �Է¹޾� INSERT)
-- public int insertCustomer(String cTel, String cName)
-- 9. ��ȣ���� : public int updateCustomer(String cTel, int cId)
-- 10. ȸ��Ż�� : public int deleteCustomer(String cTel

