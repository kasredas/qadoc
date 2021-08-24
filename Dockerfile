#FROM openjdk:18
FROM maven:3.8.2-jdk-11

COPY . /opt/qadoc

WORKDIR /opt/qadoc

#CMD /opt/qadoc/mvnw spring-boot:run
CMD sleep infinity
