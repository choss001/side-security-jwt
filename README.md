# side-security-jwt
jwt &amp; security login practice

mysql로 디비 만들고

CREATE TABLE member(
ID 			VARCHAR(20),
PASSWORD	VARCHAR(500),
ROLE		VARCHAR(20)
);


insert into member VALUES("jss", "$2a$10$nmyDUQNFPXHjlohao1P5.uDHZJPt7GDDmStpfAgUnSFQCcDH3oaiy", "ADMIN"); 


localhost:8080/login
jss/1234로 로그인 한다음에 개발자도구 jwt-header 토큰 들어오는것 확인

참고한 사이트
https://heowc.tistory.com/46
