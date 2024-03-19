FROM maven:3.8.3-openjdk-17 as build
WORKDIR /app
COPY . /app/
# sol taraf windows - sağ linux
RUN mvn clean package -DskipTests
# 5-10 => Yazılımı build etme işlemi

# Build edilen dosyayı ayağa kaldırma.
FROM openjdk:17-jdk
COPY --from=build /app/target/invoiceservice-0.0.1-SNAPSHOT.jar /app/invoiceservice.jar
CMD java -jar /app/invoiceservice.jar