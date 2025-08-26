FROM tomcat:9.0-jdk17-temurin

# dọn app mặc định
RUN rm -rf /usr/local/tomcat/webapps/*

# (nếu copy WAR sẵn)
COPY target/*.war /usr/local/tomcat/webapps/ROOT.war

# 🔇 tắt shutdown port 8005 và giữ HTTP ở 8080
RUN sed -i 's/Server port="8005"/Server port="-1"/' /usr/local/tomcat/conf/server.xml \
 && sed -i 's/Connector port="8080"/Connector port="8080"/' /usr/local/tomcat/conf/server.xml

EXPOSE 8080
CMD ["catalina.sh","run"]
