FROM openjdk:8u141-jre-slim

WORKDIR /

RUN apt-get update &&  apt-get install -y curl jq

ARG JAR_FILE=product-core-1.0.0-SNAPSHOT.jar
ADD target/${JAR_FILE} //
RUN ln -s ${JAR_FILE} product-core.jar

ADD target/classes/start-product-core.sh //
RUN chmod +x /start-product-core.sh

CMD ["/start-product-core.sh"]