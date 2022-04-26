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

INSERT INTO CUSTOMER VALUES(TO_CHAR(SYSDATE,'YYYY') || TOCHAR(CUSTOMER_SQ.NEXTVAL, '0000'), 'ȫ�浿','010-9999-9999'
                                         ,10000, 1000000,)  );














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

