FROM openjdk:17-alpine
EXPOSE 8080
ADD target/spring-boot-blogapp-1.0.jar spring-boot-blogapp-1.0.jar
ENTRYPOINT ["java","-jar","/spring-boot-blogapp-1.0.jar"]