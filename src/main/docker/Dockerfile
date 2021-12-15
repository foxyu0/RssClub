FROM java:8
MAINTAINER 70kg 123456@qq.com
ENV LANG C.UTF-8
ENV TIMEZONE Asia/Shanghai
VOLUME /tmp
ADD RssClub-1.0.0.jar RssClub.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Xms128m","-Xmx128m","-jar","/app.jar","--spring.profiles.active=docker","-c"]