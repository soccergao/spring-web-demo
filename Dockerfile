FROM openjdk:8-jre
VOLUME /tmp
ARG JAR_FILE
#只支持将本地文件复制到容器 ,还有个ADD更强大但复杂点。
#COPY ${JAR_FILE} app.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]