CREATE table board(		 	--게시글
	bno number(8), 					 -- - 번호
	title nvarchar2(50) not null, 	 -- - 제목
	content nvarchar2(1000) not null,-- - 내용
	password varchar2(20) not null,  -- - 비밀번호 
	attach nvarchar2(100), 			 -- - 파일 첨부 
	readcount number(8) default 0,	 -- - 조회수 
	name nvarchar2(10) not null, 	 -- - 작성자
	regdate date default sysdate, 	 -- - 작성 날짜 
	re_ref number(8) not null, 	 	 -- - 댓글 작성시 원본글 글번호 (그룹번호)
	re_lev number(8) not null, 	 	 -- - 댓글의 레벨(원본글의 댓글이냐 댓글의 댓글이냐 여부) 
 	re_seq number(8) not null		 -- - 댓글의 순서
);


--pk 규칙 정의
alter table board add constraint pk_board primary key(bno);

-- 시퀀스 정의 (bno 필드에 사용)
create sequence board_seq;
 
select * from board;

insert into board(bno, title, content, password, attach, name, re_ref, re_lev, re_seq) 
values(board_seq.nextval, '게시판작성', '게시판을 작성해봅시다','12345',null,'홍길동', board_seq.currval,0,0);

select count(*) from board;
-- 더미 데이터 삽입
insert into board(bno,name,password,title, content,re_ref,re_lev,re_seq) (select board_seq.nextval,name,password,title, content,board_seq.currval,re_lev,re_seq from board);
-- 댓글 
select bno,title,re_ref,re_seq,re_lev from board where bno=675;

-- re_ref number(8) not null, -- - 댓글 작성시 원본글 글번호 (그룹번호)
-- re_lev number(8) not null, -- - 댓글의 레벨(원본글의 댓글이냐 댓글의 댓글이냐 여부) 
-- re_seq number(8) not null  -- - 댓글의 순서

-- 1736 댓글 작성
-- re_ref : 원본글의 re_ref 값
-- re_seq : 원본글의 re_seq+1
-- re_lev : 원본글의 re_lev+1
insert into board(bno, title, content, password, attach, name, re_ref, re_lev, re_seq) 
values(board_seq.nextval, 'Re : 댓글작성', '게시판을 작성해봅시다','12345',null,'오마이',1736,1,1);

-- 1736번의 두번쨰 댓글
-- 가장최신 댓글이 위로 올라와야한다
-- 원본글의 re_ref, re_seq, re_lev  
update board set  re_seq = re_seq+1 where re_ref=1736 and re_seq>0; 

insert into board(bno, title, content, password, attach, name, re_ref, re_lev, re_seq) values(board_seq.nextval, 'Re : 댓글작성2', '게시판을 작성해봅시다','12345',null,'오마이',1736,1,1);

select bno,title,re_ref,re_seq,re_lev from board where re_ref=1736 order by re_seq;

select * from BOARD order by re_lev acs where bno = 1;
select * from BOARD where name like '%게시판%';
select * from BOARD where content like '%게시판%';
select * from BOARD where title like '%인코딩%';

-- pageShared 페이지 나누기 
-- rownum : 가상컬럼(임시값) - 조회된 결과 행에 번호를 매기는 것
select rownum, bno, title from board order by bno desc;

-- select rownum, bno, title from board where rownum>10; 로우넘은 결과가 다끝난 다음에 rownum
select rownum, bno, title from board where rownum<=10;

select rownum, bno, title from board where rownum<=10 order by bno desc;

-- rownum 과 order by 쓸때 주의점 
-- 출력된 결과에 rownum을 붙히는 개념 
-- 정렬을 한 후 번호를 매기지 않는다.
select rownum, bno, title from board where rownum<=10 order by re_ref desc, re_seq asc;

-- inline(인라인) Query(쿼리)의 개념으로 작성을 해야한다.
select rownum, bno, title from(select bno,title from board where bno>0 order by re_ref desc, re_seq asc) where rownum<=10;



-- 1 click => 최신글 10개를 가져오기 (1~10)
select rnum, bno, title from(select rownum rnum, A.* from
(select bno,title from board where bno>0 order by re_ref desc, re_seq asc) A
where rownum<=10) where rnum>0;
-- 2 click => 최신글 10개를 가져오기 (10~20
select rnum, bno, title from(select rownum rnum, A.* from
(select bno,title from board where bno>0 order by re_ref desc, re_seq asc) A
where rownum<=20) where rnum>10;

-- 3 click => 그 다음 최신글 10개를 가져오기(1~30 => 20~30)
select rnum, bno, title from 
(select rownum rnum, A.* 
from
(select bno,title from board where bno>0 and title like '%인코딩%' order by re_ref desc, re_seq asc) A 
where rownum<=30)
where rnum>20;
-- 1 2 3 4 5 6 7 8

-- 1 (10,0) : 1*10 (1-1)*10  *10 : 한페이지에 보여줄 게시글 갯수 
-- 2 (20,10) : 2*10 (2-1)*10
-- 3 (30,20)

select count(*) from board;


