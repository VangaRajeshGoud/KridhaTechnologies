FROM openjdk:17



WORKDIR /app

ADD target/KridhaWebApp KridhaWebApp.jar

EXPOSE 9191

ENTRYPOINT ["java", "-jar", "KridhaWebApp.jar"]