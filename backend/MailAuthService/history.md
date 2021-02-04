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

<<암호화 과정 설계>>
HTTPS(SSL) - 비대칭키 암호화 활용
SHA256 + Salt + Key Stretching 활용

1. Client는 암호화된 데이터(Email)을 Mail-Auth 서버로 보낸다
2. Mail-Auth 서버에서는 해당 데이터를 SHA256 + Salt + Key Stretching을 활용하여
암호화한 후, 이것을 DB에 저장한다(for development db)
3. 그리고 인증 과정에서 사용자에게는 암호화되지 않은 email로 email을 보내지만,
다음으로 사용될 인증 완료 과정에서의 모든 url은 암호화된 정보를 활용한다.
4. db에는 email을 직접적으로 저장하지 않고 반드시 암호화된 email을 저장한다.
