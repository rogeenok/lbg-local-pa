# -- FIRST IMAGE WITH SRC -- 
FROM jimador/docker-jdk-8-maven-node
MAINTAINER Igor Konovalov "rogee.nok@gmail.com"
COPY backend /home/best-privatearea/backend
COPY backend/src/main/resources/application.properties.docker /home/best-privatearea/backend/src/main/resources/application.properties

# MAKE BUILD SRC
# --------------
RUN mvn -f /home/best-privatearea/backend/pom.xml clean package

# -- SECOND IMAGE WITH JAR ONLY
FROM anapsix/alpine-java
COPY --from=0 /home/best-privatearea/backend/target/best-app-0.1.jar /opt/best/best-privatearea-app.jar
ENTRYPOINT ["java","-jar","/opt/best/best-privatearea-app.jar"]
EXPOSE 8095