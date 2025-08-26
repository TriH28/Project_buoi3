# ---------- Stage 1: Build WAR ----------
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app

# copy pom.xml và src từ Project_buoi3
COPY pom.xml .
COPY src ./src

RUN mvn -q -DskipTests package

# ---------- Stage 2: Run trên Tomcat ----------
FROM tomcat:9.0-jdk17-temurin
RUN rm -rf /usr/local/tomcat/webapps/*
COPY --from=build /app/target/*.war /usr/local/tomcat/webapps/ROOT.war

# tắt shutdown port để khỏi spam
RUN sed -i 's/Server port="8005"/Server port="-1"/' /usr/local/tomcat/conf/server.xml

EXPOSE 8080
CMD ["catalina.sh","run"]
