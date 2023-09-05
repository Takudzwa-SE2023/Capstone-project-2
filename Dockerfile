FROM openjdk:11
RUN mkdir /app
WORKDIR /app
COPY SuperQuickFoods.java /app
COPY Restaurant.java /app
COPY Customer.java /app
RUN javac *.java
CMD ["java", "SuperQuickFood"]
