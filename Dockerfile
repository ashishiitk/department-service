FROM openjdk:17-alpine
EXPOSE 9081
ADD /target/department-service.jar department-service.jar
ENTRYPOINT ["java","-jar","/department-service.jar"]