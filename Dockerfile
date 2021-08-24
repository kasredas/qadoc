FROM openjdk:18

COPY . /opt/qadoc

WORKDIR /opt/qadoc

#CMD /opt/qadoc/mvnw spring-boot:run
CMD sleep infinity
