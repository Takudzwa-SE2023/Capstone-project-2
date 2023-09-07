FROM openjdk:11
WORKDIR /app
COPY . /app
RUN javac Customer.java Restaurant.java SuperQuickFoods.java
CMD java SuperQuickFoods
