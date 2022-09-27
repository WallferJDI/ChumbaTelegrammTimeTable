FROM openjdk:17
EXPOSE 8080
ADD src/chumba-bot.jar chumba-bot.jar
ENTRYPOINT ["java","-jar","/chumba-bot.jar"]