# JSP 프론트 컨트롤러

`21/05/21 리팩토링 시작`

### `컨텍스트 초기화 매개변수`
- JDBC 드라이버와 데이터베이스 연결 정보를 dao 클래스에 선언하였음
- DB 정보를 소스 파일 밖에 두면 변경사항이 생겨도 web.xml 편집하면 됨
- 유지보수가 쉬워짐

### `필터 사용하기 `
- 서블릿 필터에 UTF-8 인코딩 설정
- web.xml 필터 등록 & CharacterEncodingFilter 클래스 생성
- 각 서블릿 마다 인코딩 설정하는 번거로운 작업 생략 가능
- 서블릿 컨테이너가 웹 애플리케이션 시작할 때 필터의 인스턴스 생성
- init() 호출 -> 요청이 들어오면 요청에 해당하는 doFilter()호출
- doFilter() 에서 해야할 작업 후 다음 필터의 doFilter() 호출
- 마지막 필터는 내부적으로 서블릿의  service() 호출
- service() 호출이 끝나면 이전 필터로 돌아감(제일 처음 호출 필터까지 반복) 
- 클라이언트에게 응답 결과를 보냄

### `dao 객체 공유해서 사용하기`
- 프론트 컨트롤러 -> 페이지 컨트롤러 작업 위임
- 페이지 컨트롤러에서 dao 객체 사용 , 받은 vo 객체 처리
- 페이지 컨트롤러에서 요청 시 매번 dao 인스턴스 생성
- 가바지(garbage) 가 생성되고, 실행 시간이 길어짐
- SevletContextListener를 활용하자
- 리스너에서 DB 커넥션 객체 , DAO 객체 생성하기
- DAO 객체에 DB 커넥션 객체 주입하기
- dao 객체 ServletContext에 저장하기


###  [`DataSource와 JNDI`](src/board/listeners/DataSource.md)
- DriverManager -> DataSource 사용
- DataSource는 서버에서 관리함 -> 데이베이스&JDBC 드라이버 변경 시 애플리케이션 바꿀 필요가 없음
- Connection , Statement 객체 풀링 할 수 있음 & 분산 트랜잭션


