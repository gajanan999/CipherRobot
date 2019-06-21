# CipherRobot - Cryptography Implementation in Java Using Spring Boot Application

## To Add In-Memory database configuration 
  Add the follwing dependency to our pom.xml file of spring boot application
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-data-jpa</artifactId>
      <version>2.1.4.RELEASE</version>
    </dependency>
    <dependency>
        <groupId>com.h2database</groupId>
        <artifactId>h2</artifactId>
        <scope>runtime</scope>
        <version>1.4.199</version>
    </dependency>
