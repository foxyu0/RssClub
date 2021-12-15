FROM java:8
MAINTAINER foxyu0
VOLUME /tmp
ADD RssClub-1.0.0.jar /app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Xms128m","-Xmx128m","-jar","/app.jar","--spring.profiles.active=docker","-c"]