-- DDL, DML, DCL
-- SQL = DDL(���̺� ����, ���̺� ����, ���̺� ���� ����, ���̺� ��� ������ ����)
--         DML(SELECT = ������ �˻�, INSERT=�߰�, UPDATE=����, DELETE = ����)
--         DCL(����� ���� ����, ����� ���� �ο�, ���ѹ�Ż, ����� ���� ����, Ʈ����� ��ɾ� = ROLLBACK , COMMIT )



-- DDL --
-- ���̺� ����(CREATE TABLE)
CREATE TABLE BOOK(
    BOOKID NUMBER(4),       -- ������ȣ BOOKID �ʵ� Ÿ���� ����4�ڸ�
    BOOKNAME VARCHAR2(300), -- å�̸� BOOKNAME �ʵ�� ���� 300BYTE
    PUBLISHER VARCHAR2(300),  -- ���ǻ� PUBLISHER �ʵ�� ���� 300BYTE
    RDATE   DATE,                  -- ������ RDATE �ʵ�� DATE��
    PRICE   NUMBER(8),           -- ���� PRICE �ʵ�� ���� 8�ڸ�
    PRIMARY KEY (BOOKID) ) ; -- ���̺� �� ��Ű(PRIMARY KEY) ���� - NOT NULL, ������ �� �Է�

SELECT * FROM BOOK;










