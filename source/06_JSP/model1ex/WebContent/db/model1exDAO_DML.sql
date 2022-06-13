-- 고객(CUSTOMER) 테이블 DAO
-- 1. 회원가입시 CID중복 체크
SELECT * FROM CUSTOMER WHERE CID = 'bbb';

-- 2. 회원가입
INSERT INTO CUSTOMER (CID, CPW, CNAME, CTEL, CEMAIL, CADDRESS, CGENDER, CBIRTH) 
    VALUES ('ggg','111','홍마동','010-1234-1234', 'G@g.com', '서울시 용산구','m','1991-01-01');

-- 3. 로그인(CID/CPW)
SELECT * FROM CUSTOMER WHERE CID = 'bbb' AND CPW = '111';

-- 4. CID로 DTO가져오기
SELECT * FROM CUSTOMER WHERE CID = 'ggg';

-- 5. 회원정보 수정
UPDATE CUSTOMER 
    SET CPW='111',
         CNAME='홍홍홍',
         CTEL='010-1111-0000',
         CEMAIL = 'GG@G.COM',
         CADDRESS = '부산',
         CGENDER = 'M',
         CBIRTH = '1999-12-12'
       WHERE CID='ggg';

-- 6. 회원리스트 출력(첫화면) 페이징위한 TOP N구문
SELECT * 
    FROM(SELECT ROWNUM RN, A.CID, A.CPW, A.CNAME, A.CEMAIL, A.CADDRESS
        FROM(SELECT * FROM CUSTOMER ORDER BY CID) A) WHERE RN BETWEEN  3 AND 5;

-- 7. 등록된 회원수 
SELECT COUNT(*) CNT FROM CUSTOMER;


-- 도서(BOOK)테이블 DAO
-- 책 등록
INSERT INTO BOOK(BID, BTITLE, BPRICE, BIMAGE1, BIMAGE2, BCONTENT, BDISCOUNT) 
    VALUES(BOOK_SEQ.NEXTVAL, '이것은 자바다', 30000, 'noImg.png', 'NOTHING.jpg', '책설명', 20);

INSERT INTO BOOK(BID, BTITLE, BPRICE, BIMAGE1, BIMAGE2, BCONTENT, BDISCOUNT) 
    VALUES(BOOK_SEQ.NEXTVAL, 'JSP도서', 23000, 'noImg.png', 'NOTHING.jpg', '책설명', 10);

INSERT INTO BOOK(BID, BTITLE, BPRICE, BIMAGE1, BIMAGE2, BCONTENT, BDISCOUNT) 
    VALUES(BOOK_SEQ.NEXTVAL, 'Spring', 30000, 'noImg.png', 'NOTHING.jpg', '책설명', 5);

INSERT INTO BOOK(BID, BTITLE, BPRICE, BIMAGE1, BIMAGE2, BCONTENT, BDISCOUNT) 
    VALUES(BOOK_SEQ.NEXTVAL, '봄', 40000, 'noImg.png', 'NOTHING.jpg', '책설명', 20);

-- 책 목록(전체LIST)
SELECT * FROM BOOK ORDER BY BRDATE DESC;
 
-- 책 목록(TOP-N구문)
SELECT * 
    FROM (SELECT ROWNUM RN, B.*
                FROM (SELECT * FROM BOOK ORDER BY BRDATE DESC) B)
                    WHERE RN BETWEEN 2 AND 3;
                    
-- 등록된 책 갯수
SELECT COUNT(*) CNT FROM BOOK;

-- 책 상세보기(BID로 DTO 가져오기)
SELECT * FROM BOOK WHERE BID = 1;



-- 파일첨부게시판(FILEBOARD) 테이블 DAO
-- 1. 글목록 TOP N
SELECT *
    FROM(SELECT ROWNUM RN, A.*
         FROM ( SELECT F.*, CNAME, CEMAIL
                         FROM FILEBOARD F, CUSTOMER C
                             WHERE F.CID = C.CID ORDER BY FREF DESC, FRE_STEP)A )    
            WHERE RN BETWEEN 2 AND 4;

-- 2. 등록된 글 수
SELECT COUNT(*) CNT FROM FILEBOARD;
-- 3. 원글쓰기 
INSERT INTO FILEBOARD (FNUM, CID, FSUBJECT, FCONTENT, FFILENAME, FPW, FREF, FRE_STEP, FRE_LEVEL, FIP)
    VALUES (FILEBOARD_SQ.nextval, 'bbb', '글1', '본문1', NULL, '111', FILEBOARD_SQ.CURRVAL, 0,0,'126.12.12.1');
SELECT * FROM FILEBOARD WHERE FNUM = 8; -- 방금 쓴 원글 8번글

-- 4. 답변글 전 SETP A -- 8번글에 대한 답변글 쓰기 전작업
UPDATE FILEBOARD SET FRE_STEP = FRE_STEP +1 WHERE FREF=8 AND FRE_STEP>0;
-- 5. 답변글 쓰기 --
INSERT INTO FILEBOARD(FNUM, CID, FSUBJECT, FCONTENT, FFILENAME, FPW, FREF, FRE_STEP, FRE_LEVEL, FIP)
    VALUES (FILEBOARD_SQ.NEXTVAL, 'bbb', '글1-1', '답', NULL, '111', 5,1,1,'192.168.10.10');
SELECT * FROM FILEBOARD WHERE FREF=5
    ORDER BY FRE_STEP;

-- 6. 글 상세보기(FNUM으로 DTO가져오기)
SELECT F.*, CNAME, CEMAIL FROM FILEBOARD F, CUSTOMER C WHERE F.CID = C.CID AND FNUM = 6;

select * from customer;

-- 조회수 올리기
UPDATE FILEBOARD SET FHIT = FHIT +1 WHERE FNUM= 4;
SELECT * FROM FILEBOARD;
-- 7. 글 수정하기
UPDATE FILEBOARD 
    SET FSUBJECT = '수정된 제목',
        FCONTENT = '수정된 본문',
        FFILENAME = NULL,
        FPW = '111',
        FIP = '192.168.10.10'
    WHERE FNUM = 8; 

-- 8. 글 삭제하기
select * from customer;
select * from fileboard;

DELETE FROM FILEBOARD WHERE cid= 'aa1';

COMMIT;









