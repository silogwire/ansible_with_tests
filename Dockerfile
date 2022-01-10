FROM tomcat:8-jre8
COPY ./target/testing.war /opt/tomcat/webapps/

