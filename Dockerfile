FROM openjdk:11-jre-slim
RUN mkdir /app
WORKDIR /app
COPY SuperQuickFood.java /app
COPY Restaurant.java /app
COPY Customer.java /app
RUN javac *.java
CMD ["java", "SuperQuickFood"]
