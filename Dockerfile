FROM openjdk:11

COPY . /opt/qadoc

WORKDIR /opt/qadoc

CMD /opt/qadoc/mvnw spring-boot:run
