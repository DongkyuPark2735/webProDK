-- DDL, DML, DCL
-- SQL = DDL(테이블 생성, 테이블 삭제, 테이블 구조 변경, 테이블 모든 데이터 제거)
--         DML(SELECT = 데이터 검색, INSERT=추가, UPDATE=수정, DELETE = 삭제)
--         DCL(사용자 계정 생성, 사용자 권한 부여, 권한박탈, 사용자 계정 삭제, 트랜잭션 명령어 = ROLLBACK , COMMIT )



-- DDL --
-- 테이블 생성(CREATE TABLE)
CREATE TABLE BOOK(
    BOOKID NUMBER(4),       -- 도서번호 BOOKID 필드 타입은 숫자4자리
    BOOKNAME VARCHAR2(300), -- 책이름 BOOKNAME 필드는 문자 300BYTE
    PUBLISHER VARCHAR2(300),  -- 출판사 PUBLISHER 필드는 문자 300BYTE
    RDATE   DATE,                  -- 출판일 RDATE 필드는 DATE형
    PRICE   NUMBER(8),           -- 가격 PRICE 필드는 숫자 8자리
    PRIMARY KEY (BOOKID) ) ; -- 테이블 내 주키(PRIMARY KEY) 설정 - NOT NULL, 유일한 값 입력

SELECT * FROM BOOK;










