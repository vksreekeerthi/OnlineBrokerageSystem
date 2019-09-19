FROM openjdk
COPY "./build/libs/OnlineBrokerageSystem-0.0.1-SNAPSHOT.jar" app/OnlineBrokerageSystem/
WORKDIR app/OnlineBrokerageSystem/
EXPOSE 8085
ENTRYPOINT ["java", "-jar","OnlineBrokerageSystem-0.0.1-SNAPSHOT.jar"]