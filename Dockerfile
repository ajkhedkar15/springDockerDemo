FROM openjdk:8
EXPOSE 8080
ADD /build/libs/springDockerDemo-0.0.1-SNAPSHOT.jar springDockerDemo-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "springDockerDemo-0.0.1-SNAPSHOT.jar"]