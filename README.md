# 위메프 과제

* Spring-boot 2.1.4
* Java 1.8


# 과제 설명

### 화면

* 입력 : URL(input), TYPE(select), 출력묶음(input)
  * TYPE : HTML태그제거, TEXT만
* 출력 : 몫, 나머지


### 규칙

1. 모든 문자 입력가능 (URL에)
2. 영어, 숫자만 출력 (몫, 나머지에)
3. 오름차순
    * 영어 : AaBb....Zz
    * 숫자 : 0123...9
    
4. 교차출력
    * 영어 숫자 영어 (영어 먼저 출력)
    
5. 출력묶음단위



# 진행 과정
1. 프로젝트 세팅
    * pom.xml 에러로 Spring Boot 2.1.4로 다운그레이드
    
2. HttpConnectionUtil 구현

3. Converter 구현
    * TYPE에 맞는 Converter
    * 추후 확장성을 고려해 인터페이스로 만듦
    * Enum
    * 정규식
    
4. Sorter 구현
    * 오름차순 정렬 및 교차출력 
    * 처음에 Util로 구현했다가 Sorter 추상클래스로 변경
    * Count 정렬
    * CharacterManager 클래스로 객체로 관리
    * 템플릿 메서드 디자인 패턴 사용
    * 자바 8 스트림, 옵셔널
    
5. 화면
    * jQuery, BootStrap
    * URL 인코딩 및 ajax 전송 이전에 유효값체크
    * readonly, 숫자만 입력, 디폴트값 
 
6. Worker 구현
    * 적절한 Converter와 Sorter로 작업
    * 스트래티지 패턴 사용
  
7. 로그 설정 / 인터셉터
    * log4j2
    * 인터셉터에서 path 찍기
    * Worker 작업 완료 후 정보

8. 테스트 코드 
    * HttpConnectionUtil, Converter, Sorter에 적용
    
    
# 추후 개선
* 스프링 프레임워크 활용
	* (스프링에 대한 추가 공부 이후)
  * @Service와 @Autowired로 고치기
  * Validate, MVC (@NotNull, initBind 등..)

* 예외처리
	* CustomException 만들까
	* 예외 처리 관리 방법 알아보기

* 구조
	* Converter 인터페이스를 없애고 Enum에 정규식 String변수를 추가하는 게 나을듯
	* 템플릿 메서드 패턴으로 고쳐보기
  * restful api로? (TYPE만 이용해서)

* 프론트
	* thymeleaf 써보기 (Enum 타입 내려주기)
	* Https:// 없이 URL 입력 가능하도록 입력폼 개선
  * jQuery, BootStrap 라이브러리 다운로드받아 프로젝트에 추가하기
      * 개발 편의로 CDN을 썼지만 환경에 따라 외부 접속이 안되는 곳도 있음
  
    


  



