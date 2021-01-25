<<이메일 인증 절차>>
1. 회원가입 진행
2. 버튼 클릭 '회원가입' API를 받는다. (body : email)
3. '인증 메일이 전송되었습니다' '인증해 주세요' :
	1. client에게 API전송
	2. timer set
	3. client email 전송
4. 이메일이 보내진다
5. 이메일 인증하기 클릭 - API 제공 : to auth server with email
6. 인증에 성공했습니다. 
	1. timer 검사
	2. client에게 전송
	3. db 조작
