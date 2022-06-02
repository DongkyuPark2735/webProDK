-- 테이블 drop & create
DROP TABLE BOARD;
CREATE TABLE BOARD(
    NUM NUMBER(5, 0)  PRIMARY KEY,  -- 글번호
    WRITER VARCHAR2(30) NOT NULL, -- 글쓴이
    SUBJECT VARCHAR2(100) NOT NULL, -- 글 제목
    CONTENT VARCHAR2(4000) NOT NULL, -- 본문
    EMAIL VARCHAR2(30), -- 작성자 이메일
    READCOUNT NUMBER(5, 0) DEFAULT 0, -- 글 조회수
    PW VARCHAR2(30) NOT NULL, -- 글 삭제시 쓸 비밀번호
    REF NUMBER(5, 0) NOT NULL, -- 글 그룹( 원글일경우 글번호로/ 답변글일경우 원글의 글번호로) 
    RE_STEP NUMBER(5) NOT NULL, -- 그룹내 출력 순서(원글 0)
    RE_INDENT NUMBER(5) NOT NULL, -- 글 LIST출력시 제목 들여쓰기 정도(원글0)
    IP VARCHAR2(20) NOT NULL, -- 글 작성시 컴퓨터 IP주소 
    RDATE DATE DEFAULT SYSDATE); -- 글쓴 시점 (날짜+시간)
);

--

