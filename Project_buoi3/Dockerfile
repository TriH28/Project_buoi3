FROM tomcat:9.0-jdk17-temurin

# bỏ webapp mặc định
RUN rm -rf /usr/local/tomcat/webapps/*

# copy WAR có sẵn trong thư mục hiện tại (context)
COPY Project_buoi3.war /usr/local/tomcat/webapps/ROOT.war

# tắt shutdown port 8005 để khỏi spam warning
RUN sed -i 's/Server port="8005"/Server port="-1"/' /usr/local/tomcat/conf/server.xml

EXPOSE 8080
CMD ["catalina.sh","run"]
