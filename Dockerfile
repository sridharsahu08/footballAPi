FROM adoptopenjdk/openjdk11:latest 
RUN mkdir /opt/app 
COPY build/libs/footballrank-0.0.1-SNAPSHOT.jar /opt/app 
CMD ["java", "-jar", "/opt/app/footballrank-0.0.1-SNAPSHOT.jar"]