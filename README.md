# side-security-jwt
jwt &amp; security login practice</br>

mysql로 디비 만들고</br>

CREATE TABLE member(</br>
ID 			VARCHAR(20),</br>
PASSWORD	VARCHAR(500),</br>
ROLE		VARCHAR(20)</br>
);</br>


insert into member VALUES("jss", "$2a$10$nmyDUQNFPXHjlohao1P5.uDHZJPt7GDDmStpfAgUnSFQCcDH3oaiy", "ADMIN"); </br>

localhost:8080/login</br>
jss/1234로 로그인 한다음에 개발자도구 jwt-header 토큰 들어오는것 확인</br>

참고한 사이트</br>
https://heowc.tistory.com/46</br>
