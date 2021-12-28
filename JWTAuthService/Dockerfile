# Pull the java image
FROM openjdk:11
# create a directory
RUN mkdir /app
#Argument for jar file directory
ARG JAR_FILE=target/authService-0.0.1-SNAPSHOT.jar
# Copy the app files from target to working directory
COPY ${JAR_FILE} /app/authService-0.0.1-SNAPSHOT.jar
#set the directory for executing future commands
WORKDIR /app
#Run the main class
ENTRYPOINT ["java","-jar","/app/authService-0.0.1-SNAPSHOT.jar"]