# azure-spring-boot-mysql

Local Testing:
1. Run a MySql container on docker using the below command
    docker run -d -e MYSQL_ROOT_PASSWORD=pass -e MYSQL_DATABASE=employees -e MYSQL_USER=dummy -e MYSQL_PASSWORD=dummy -p 3306:3306 mysql:5.7
2. Connect to the MySql server using MySql shell and verify connection using the username and password.
3. Run the app in local using the below connection details

```yaml
spring:
  datasource:
    url: jdbc:mysql://192.168.233.128:3306/employees
    username: dummy
    password: dummy
    driver-class-name: com.mysql.cj.jdbc.Driver
  jpa:
    hibernate:
      ddl-auto: none
    properties:
      hibernate:
        dialect: org.hibernate.dialect.MySQL57Dialect
```
^ 192.168.233.128 is the ip of Ubuntu VM running on host

 
