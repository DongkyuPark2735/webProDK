DROP TABLE STUDENT;
DROP TABLE MAJOR;

CREATE TABLE MAJOR(
    MNO NUMBER(2) PRIMARY KEY,
    MNAME VARCHAR2(20) UNIQUE NOT NULL
);

CREATE TABLE STUDENT(
    SNO NUMBER(7) PRIMARY KEY, 
    SNAME VARCHAR2(20) NOT NULL,
    MNO NUMBER(2) REFERENCES MAJOR(MNO),
    SCORE NUMBER(3) DEFAULT 0 CHECK (SCORE BETWEEN 1 AND 100),
    EXPEL NUMBER(1) DEFAULT 0 CHECK  (EXPEL IN (0,1))
);
DROP SEQUENCE STUDENT_SQ;

CREATE SEQUENCE STUDENT_SQ
    NOCYCLE
    NOCACHE;


INSERT INTO MAJOR VALUES (10, '�ΰ�������' );
INSERT INTO MAJOR VALUES (20, '��������' );
INSERT INTO MAJOR VALUES (30, '�濵������' );
INSERT INTO MAJOR VALUES (40, '��ǻ�Ͱ���' );

SELECT * FROM MAJOR;

INSERT INTO STUDENT VALUES (TO_CHAR(SYSDATE, 'YYYY')||TRIM(TO_CHAR(STUDENT_SQ.NEXTVAL, '000')), 'ȫ�浿', 10, 90, 0);
INSERT INTO STUDENT VALUES (TO_CHAR(SYSDATE, 'YYYY')||TRIM(TO_CHAR(STUDENT_SQ.NEXTVAL, '000')), '��浿', 20, 80, 0);
INSERT INTO STUDENT VALUES (TO_CHAR(SYSDATE, 'YYYY')||TRIM(TO_CHAR(STUDENT_SQ.NEXTVAL, '000')), '�ڱ浿', 20, 70, 0);
INSERT INTO STUDENT VALUES (TO_CHAR(SYSDATE, 'YYYY')||TRIM(TO_CHAR(STUDENT_SQ.NEXTVAL, '000')), '��浿', 10, 60, 0);
INSERT INTO STUDENT VALUES (TO_CHAR(SYSDATE, 'YYYY')||TRIM(TO_CHAR(STUDENT_SQ.NEXTVAL, '009')), '���浿', 10, 50, 0);

SELECT * FROM STUDENT;

--
-- 0. ùȭ�鿡 �����̸��� �޺��ڽ��� �߰�(mName)
-- :  public Vector<String> getMNamelist()
SELECT MNAME FROM MAJOR;
-- 1. �й��˻� (sNo, sName, mName, score)
-- : public StudentDto sNogetStudent(String sNo)
SELECT SNO, SNAME, MNAME, SCORE
    FROM STUDENT S, MAJOR M 
    WHERE S.MNO = M.MNO;
-- 2. �̸��˻� (sNo, sName, mName, score)
-- :  public ArrayList<StudentDto> sNamegetStudent(String sName)
SELECT SNO, SNAME, MNAME, SCORE
    FROM STUDENT S, MAJOR M 
    WHERE S.MNO = M.MNO AND SNO = 2022001;
-- 3. �����˻� (rank, sName(sNo����), mName(mNo����), score)
-- : public ArrayList<StudentDto> mNamegetStudent(String mName)
SELECT ROWNUM R, A.*
    FROM (SELECT SNAME||'('||SNO||')' NAME, MNAME||'('||M.MNO||')' MAJOR, SCORE
                FROM MAJOR M, STUDENT S WHERE S.MNO = M.MNO AND MNAME = '�ΰ�������' ORDER BY SCORE DESC) A; 
            
-- 4. �л��Է�
-- : public int insertStudent(StudentDto dto)
INSERT INTO STUDENT VALUES (TO_CHAR(SYSDATE, 'YYYY')||TRIM(TO_CHAR(STUDENT_SQ.NEXTVAL, '000')), 'ȫ�浿', 10, 90, 0);
INSERT INTO STUDENT VALUES (TO_CHAR(SYSDATE, 'YYYY')||TRIM(TO_CHAR(STUDENT_SQ.NEXTVAL, '000')), 'ȫ�浿',
    (SELECT MNO FROM MAJOR WHERE MNAME = '�ΰ�������'), 90, 0);
-- 5. �л�����
-- : public int updateStudent(StudentDto dto)
UPDATE STUDENT SET SNO = 2022010, SNAME = '�����', MNO = 20, SCORE = 80
    WHERE SNO = 2022001;
-- 6. �л���� (rank, sName(sNo����), mName(mNo����), score)
-- : public ArrayList<StudentDto> getStudents()
SELECT ROWNUM, A.*
    FROM (SELECT SNAME, MNAME, SCORE FROM STUDENT S, MAJOR M WHERE S.MNO = M.MNO AND EXPEL != 1 ORDER BY SCORE DESC) A;
-- 7. ��������� (rank, sName(sNo����), mName(mNo����), score)
-- : public ArrayList<StudentDto> getStudentsExpel()
SELECT ROWNUM, A.*
    FROM (SELECT SNAME, MNAME, SCORE FROM STUDENT S, MAJOR M WHERE S.MNO = M.MNO AND EXPEL != 0 ORDER BY SCORE DESC) A;
-- 8. ����ó�� : public int sNoExpel(String sNo)
UPDATE STUDENT SET EXPEL = 1 WHERE SNO = 2022002;






--