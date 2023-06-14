FROM openjdk:17
EXPOSE 3000
ADD ./target/demo-masterchef-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
