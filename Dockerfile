FROM tomcat:latest
COPY ./target/testing.war /opt/tomcat/webapps/

