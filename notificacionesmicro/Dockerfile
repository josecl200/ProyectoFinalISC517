FROM openjdk:11-jdk-slim
LABEL maintainer="José C. Ureña <20160138@ce.pucmm.edu.do>"
ENV NOMBRE_APP = 'isc517finalnotificacionesmicro'
EXPOSE 200-65000
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]