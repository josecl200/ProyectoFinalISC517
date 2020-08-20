FROM openjdk:11-jdk-slim
LABEL maintainer="José C. Ureña <20160138@cce.pucmm.edu.do>"
ENV NOMBRE_APP = 'isc517finalconfigserver'
EXPOSE 8888
VOLUME /var/centralConf
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]