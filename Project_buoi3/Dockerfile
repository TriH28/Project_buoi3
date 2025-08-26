# Sử dụng Tomcat 9 + JDK 11
FROM tomcat:9.0-jdk11

# Xóa app mặc định của Tomcat (ROOT)
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy WAR vào Tomcat
COPY Project_buoi3.war /usr/local/tomcat/webapps/ROOT.war

# Expose cổng 8080
EXPOSE 8080

# Chạy Tomcat
CMD ["catalina.sh", "run"]
