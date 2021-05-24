## javax.sql 확장 패키지

- DriverManager를 대체할 수 있는 DataSource 인터페이스 제공
- Connection 및 Statement 객체의 풀링
- 분산 트랜잭션 처리
- Rowsets의 지원


## DataSource 적용

`pom.xml`

```xml
 <dependencies>
    <!-- https://mvnrepository.com/artifact/commons-dbcp/commons-dbcp -->
<dependency>
    <groupId>commons-dbcp</groupId>
    <artifactId>commons-dbcp</artifactId>
    <version>1.4</version>
</dependency>
<!-- https://mvnrepository.com/artifact/commons-pool/commons-pool -->
<dependency>
    <groupId>commons-pool</groupId>
    <artifactId>commons-pool</artifactId>
    <version>1.6</version>
</dependency>
<!-- https://mvnrepository.com/artifact/javax.servlet/jstl -->
<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>jstl</artifactId>
    <version>1.2</version>
</dependency>
  </dependencies>

```

## 톰캣 서버에 DataSource 설정하기

`context.xml`

```xml
 <Resource name="jdbc/??" auth="Container" type="javax.sql.DataSource"
               maxTotal="100" maxIdle="30" maxWaitMillis="10000"
               username="" password="" driverClassName="com.mysql.cj.jdbc.Driver"
               url="jdbc:mysql://localhost:3306/??"
               closeMethod="close"/>
```

## 웹 애플리케이션에서 톰캣 서버의 자원 사용

`web.xml`

```xml
<resource-ref>
 	<res-ref-name>jdbc/??</res-ref-name>
 	<res-type>javax.sql.DataSource</res-type>
 	<res-auth>Container</res-auth>
 </resource-ref>
```


## ContextLoaderListener 클래스 변경 

`ContextLoaderListener.java`

```java

```