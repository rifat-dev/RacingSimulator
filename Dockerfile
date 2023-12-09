FROM tomcat:10.1.16-jre17-temurin-jammy
COPY build/libs/racingSimulator-0.0.1-SNAPSHOT.jar /usr/local/tomcat/webapps/ROOT.jar
EXPOSE 8080
WORKDIR /usr/local/tomcat/webapps
ENTRYPOINT ["java", "-jar", "/usr/local/tomcat/webapps/ROOT.jar"]