# ---------- Stage 1: Build WAR ----------
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app

# copy riêng pom.xml để cache dependency
COPY pom.xml .
RUN mvn -q -DskipTests dependency:go-offline

# copy source và build
COPY src ./src
RUN mvn -q -DskipTests package

# ---------- Stage 2: Run trên Tomcat ----------
FROM tomcat:9.0-jdk17-temurin

# dọn app mặc định
RUN rm -rf /usr/local/tomcat/webapps/*

# copy WAR đã build làm ROOT.war
COPY --from=build /app/target/*.war /usr/local/tomcat/webapps/ROOT.war

# tắt shutdown port 8005 để khỏi spam log
RUN sed -i 's/Server port="8005"/Server port="-1"/' /usr/local/tomcat/conf/server.xml

EXPOSE 8080
CMD ["catalina.sh","run"]
