DROP TABLE STUDENT;
DROP TABLE MAJOR;

CREATE TABLE MAJOR(
    MNO NUMBER(2) PRIMARY KEY,
    MNAME VARCHAR2(20) UNIQUE NOT NULL
);

CREATE TABLE STUDENT(
    SNO NUMBER(7) PRIMARY KEY, 
    SNAME VARCHAR2(20) NOT NULL,
    MNO NUMBER(2) REFERENCES MAJOR(MNO) NOT NULL,
    SCORE NUMBER(3) DEFAULT 0 CHECK (SCORE BETWEEN 1 AND 100),
    EXPEL NUMBER(1) DEFAULT 0 CHECK  (EXPEL IN (0,1))
);
DROP SEQUENCE STUDENT_SQ;

CREATE SEQUENCE STUDENT_SQ
    NOCYCLE
    NOCACHE;


INSERT INTO MAJOR VALUES (10, '인공지능학' );
INSERT INTO MAJOR VALUES (20, '빅데이터학' );
INSERT INTO MAJOR VALUES (30, '경영정보학' );
INSERT INTO MAJOR VALUES (40, '컴퓨터공학' );

SELECT * FROM MAJOR;

INSERT INTO STUDENT VALUES (TO_CHAR(SYSDATE, 'YYYY')||TRIM(TO_CHAR(STUDENT_SQ.NEXTVAL, '000')), '홍길동', 10, 90, 0);
INSERT INTO STUDENT VALUES (TO_CHAR(SYSDATE, 'YYYY')||TRIM(TO_CHAR(STUDENT_SQ.NEXTVAL, '000')), '김길동', 20, 80, 0);
INSERT INTO STUDENT VALUES (TO_CHAR(SYSDATE, 'YYYY')||TRIM(TO_CHAR(STUDENT_SQ.NEXTVAL, '000')), '박길동', 20, 70, 0);
INSERT INTO STUDENT VALUES (TO_CHAR(SYSDATE, 'YYYY')||TRIM(TO_CHAR(STUDENT_SQ.NEXTVAL, '000')), '장길동', 10, 60, 0);
INSERT INTO STUDENT VALUES (TO_CHAR(SYSDATE, 'YYYY')||TRIM(TO_CHAR(STUDENT_SQ.NEXTVAL, '009')), '윤길동', 10, 50, 0);

SELECT * FROM STUDENT;
commit;


-- 0. 첫화면에 전공이름들 콤보박스에 추가(mName)
-- :  public Vector<String> getMNamelist()
SELECT MNAME FROM MAJOR;
-- 1. 학번검색 (sNo, sName, mName, score)
-- : public StudentDto sNogetStudent(String sNo)
    SELECT SNO, SNAME, MNAME, SCORE
        FROM STUDENT S, MAJOR M 
        WHERE S.MNO = M.MNO AND SNO = 2022002;
-- 2. 이름검색 (sNo, sName, mName, score)
-- :  public ArrayList<StudentDto> sNamegetStudent(String sName)
SELECT SNO, SNAME, MNAME, SCORE
    FROM STUDENT S, MAJOR M 
    WHERE S.MNO = M.MNO AND SNAME = '홍길동';
-- 3. 전공검색 (rank, sName(sNo포함), mName(mNo포함), score)
-- : public ArrayList<StudentDto> mNamegetStudent(String mName)
SELECT ROWNUM R, A.*
    FROM (SELECT SNAME||'('||SNO||')' NAME, MNAME||'('||M.MNO||')' MAJOR, SCORE
                FROM MAJOR M, STUDENT S WHERE S.MNO = M.MNO AND MNAME = '인공지능학' ORDER BY SCORE DESC) A; 
            
-- 4. 학생입력
-- : public int insertStudent(StudentDto dto)
INSERT INTO STUDENT VALUES (TO_CHAR(SYSDATE, 'YYYY')||TRIM(TO_CHAR(STUDENT_SQ.NEXTVAL, '000')), '홍길동', 10, 90, 0);
INSERT INTO STUDENT VALUES (TO_CHAR(SYSDATE, 'YYYY')||TRIM(TO_CHAR(STUDENT_SQ.NEXTVAL, '000')), '홍길동',
    (SELECT MNO FROM MAJOR WHERE MNAME = '인공지능학'), 90, 0);
-- 5. 학생수정
-- : public int updateStudent(StudentDto dto)
UPDATE STUDENT SET SNAME = '윤장열',MNO = (SELECT MNO FROM MAJOR WHERE MNAME = '인공지능학'), SCORE = 80
    WHERE SNO = 2022010;
-- 6. 학생출력 (rank, sName(sNo포함), mName(mNo포함), score)
-- : public ArrayList<StudentDto> getStudents()
SELECT ROWNUM R, A.*
    FROM (SELECT SNAME||'('||SNO||')' NAME, MNAME||'('||S.MNO||')' MNAME, SCORE FROM STUDENT S, MAJOR M
    WHERE S.MNO = M.MNO AND EXPEL != 1 ORDER BY SCORE DESC) A;
-- 7. 제적자출력 (rank, sName(sNo포함), mName(mNo포함), score)
-- : public ArrayList<StudentDto> getStudentsExpel()
SELECT ROWNUM R, A.*
    FROM (SELECT SNAME||'('||SNO||')' NAME, MNAME||'('||S.MNO||')' MNAME, SCORE FROM STUDENT S, MAJOR M
    WHERE S.MNO = M.MNO AND EXPEL != 0 ORDER BY SCORE DESC) A;

-- 8. 제적처리 : public int sNoExpel(String sNo)
UPDATE STUDENT SET EXPEL = 1 WHERE SNO = 2022002 AND SNAME = '윤장열' AND MNAME = '인공지능학' AND SCORE = 80;






--