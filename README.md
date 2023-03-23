# 기능

---

- 스터디 소개( 메인페이지) - 화면설계 UI
    
    헤더 BET) 스터디목록 / 스터디 개설 / 커뮤니티  
    
        R)  비회원 : 로그인/ 회원가입 
    
       회원 :  마이페이지 / 로그아웃
    
      관리자 : 마이페이지 / 관리자 페이지 / 로그아웃 
    
    메인 ) 스터디  검색 (검색 범주 (option) )
    
    푸터 ) 로고 
    
- 회원관리
    - **아이디=이메일 (필수 NOT NULL)**
        - email 패턴
        - unique
        - message = “이미 가입된 이메일입니다”
    - **비밀번호**
        - 최소  8~16자 및  알파벳, 숫자,특수문자포함
        - password
        - message=”최소  8~16자 및  알파벳, 숫자,특수문자를 포함하여 입력해주세요”
    - **비밀번호 확인**
        - 비밀번호와 일치
        - password
        - message =” 비밀번호가 일치하지 않습니다”
    - **닉네임**
        - 중복 x
        - unique(sql)
        - message=”이미 사용중인 닉네임입니다”)
    - **회원명**
        - 숫자x  (실명)
        - text
        - 빈칸이면 message= “회원명을 입력해주세용”
    - **전화번호**
        - 010-0000-0000 / 010.0000.0000 / 01000000000 ⇒ 특수문자 제외
        - text
        - message = “전화번호 형식이 아닙니다”
    - **생년월일 (필수항목 제외)**
        - 년 / 월 / 일
        - date (달력뜨게)
    - **성별**
        - 남성 / 여성
        - radio
        - message=”성별을 선택해주세요”
    - **이용약관**
        - checkbox
        - message=”이용약관에 동의해주세요”
    - 버튼 - 취소하기, 가입하기
        - 취소 → 메인페이지
        - 가입 → 로그인페이지

💢 오류 💢

- 각각 형식 아래에 빨간색 글씨로 표현

- 로그인/로그아웃
    - 로그인
        - 이메일
            - message=”올바른 이메일 형식을 입력해 주세요”
        - 비밀번호
            - message=”비밀번호를 입력해주세요”
        - 아이디저장
        - (+아이디, 비밀번호찾기 )
        - 버튼 - 취소하기, 로그인하기
            - 취소 → 메인페이지
            - 가입 → 메인페이지

- 스터디 관리
    - 스터디 개설 폼
        - 카테고리(옵션→ 메인페이지 검색 기능과 동일)
        - 스터디명
        - 닉네임(노출이 될지 안될지..)
        - 신청최대 인원수(텍스트)
        - 스터디 주당 횟수(radio)
        - 소개글(editor+파일첨부)
        - 지역 (특정 지역 api)
        - 취소하기(버튼), 개설하기(버튼)
        
         (주당횟수만 선택 나머지 필수)
        
    - 스터디 관리
        - 스터디 목록 창 → 회원정보
        - 스터디 목록 ( 표 )
            - 선택하기 ( 선택 스터디 삭제하기)
            - 번호 (자동증감)
            - 스터디 명
            - 카테고리
            - 스터디개설자 (회원명)
            - 개설일시
            - 비고란 - 미리보기(소개글) , 관리하기(회원정보)
    - 검색기능
        - 카테고리별
        - 
- 마이페이지 (스터디 리뷰 작성 )
- 스터디 리뷰 작성, 수정, 삭제 ( 스터디 회원)

- 커뮤니티 관리
    - 체크박스 (삭제하기용)
    - 번호(증감)
    - 사용자 ( 닉네임)
    - 이메일
    - 게시글 명
    - 게시글 내용(editor)  + 파일첨부 0
    - 게시일자
    - 조회 수
    - 한 게시판당 게시글 노출 수
    - 관리하기 → 게시글 상세 (관리자 & 작성자 동일 화면보임 . (삭제, 수정, 댓글 ) )
    - 댓글 ( 삭제, 수정 )

- 신고내역 관리 ( 커뮤니티 )
    - 회원명
    - 이메일 (unique)
    - 구분 - 스터디, 커뮤니티
    - 신고사유
        - 상업적 광고 및 판매
        - 욕설/비하
        - 스터디 목적 부적절
        - 스터디 도배
        - 음란물/불건전한 만남 및 대화
        - 사기/ 사칭 / 유출
        - 기타 - text (100)
    - 신고 일시
    - 신고 횟수는 안하는걸로……어렵다….포기…
    - 비고란 ( 신고한 해당 게시글은 어떻게 확인할 것인지…..모르겠어요…. )
    
- 문의 관리
    - 문의유형
        - 개설 문의
        - 탈퇴 문의
        - 계정  (아이디 비번 생각안남 등의 유형 )  → 회원정보문의
        - 마이페이지
        - 스터디 신청 문의
        - 커뮤니티 이용
        - 서비스 오류
    - 회원명
    - 닉네임
    - 이메일 (자동)
    - 연락 수단 ( radio )
        - 휴대전화번호 ( 연락받을 번호 )
        - 이메일 (연락 받을 이메일 )
        - 기존이메일 ( 가입시 이메일 )
        - → 3개의 라디오, 3개의 text  각각 선택 각각 입력
    - 문의 내용 → text
    - 파일 첨부
    - 취소하기/ 문의하기 버튼