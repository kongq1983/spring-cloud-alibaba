FROM java:8
VOLUME /tmp
ADD nacos-discovery-1.0-SNAPSHOT.jar /nacos-discovery-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/nacos-discovery-1.0-SNAPSHOT.jar"]