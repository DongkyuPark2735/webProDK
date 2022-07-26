-- Member.xml( 회원가입, id 중복체크  id로 memeberDTO 가져오기, 로그인, 정보 수정)


-- idConfirm
SELECT COUNT(*) FROM MEMBER WHERE MID='AAA';

-- joinMember
INSERT INTO MEMBER(MID, MPW, MNAME, MMAIL, MPOST, MADDR) 
    VALUES('BBB', '1', '김길동', 'QER@NAVER.COM', '123450', '서울');
 
SELECT * FROM MEMBER;
-- getMember
SELECT * FROM MEMBER WHERE MID = 'BBB';
-- modifyMember
UPDATE MEMBER SET MPW = '1',
                        MNAME = '박길동',
                        MMAIL = 'QER@GOOGLE.COM',
                        MPOST = '12345',
                        MADDR = '경기'
                WHERE MID = 'BBB';

-- Book.xml (페이징 없이 신규순 list , 페이징 포함된 도서보기list(책 이름순), 책 갯수, 상세보기, 도서 등록, 도서 수정)

-- mainList
SELECT * FROM BOOK ORDER BY BTITLE;
-- bookList
    SELECT * 
        FROM( SELECT ROWNUM RN, B.*
                    FROM(SELECT * FROM BOOK ORDER BY BTITLE) B)
                    WHERE RN BETWEEN 2 AND 3;
-- totCntBook
SELECT COUNT(*) FROM BOOK;

-- getDetailBook
SELECT * FROM BOOK WHERE BNUM = 1;

-- registerBook
INSERT INTO BOOK(BNUM, BTITLE, BWRITER, BRDATE, BIMG1, BINFO) 
    VALUES(BOOK_SQ.NEXTVAL, 'JSP', '박제이', SYSDATE, 'noImg.png', '스프링 개념서');

-- modifyBook
UPDATE BOOK SET BTITLE = 'JSP1',
                        BWRITER = '홍제이',
                        BRDATE = '22/07/04',
                        BIMG1 = 'noImg.png',
                        BIMG2 = 'noImg.png',
                        BINFO = '스프링 개념서 1'
                    WHERE BNUM = 1;
        
SELECT * FROM BOOK;
COMMIT;

-- 검색 

SELECT * FROM BOOK WHERE 1=1 AND BTITLE LIKE '%'||UPPER('jsp')||'%' AND BWRITER LIKE  '%'||'홍'||'%';







