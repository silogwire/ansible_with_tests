FROM tomcat:8-jre8
COPY ./target/testing.war /usr/local/tomcat/webapps/

