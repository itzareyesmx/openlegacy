FROM openjdk:8

WORKDIR openlegacy/

COPY deploy_app.sh deploy_app.sh 
COPY src src
COPY gradle gradle
COPY webpack webpack
COPY angular.json angular.json
COPY package.json package.json
COPY build.gradle build.gradle
COPY gradlew gradlew
COPY postcss.config.js postcss.config.js
COPY tsconfig-aot.json tsconfig-aot.json
COPY tsconfig.json tsconfig.json

RUN apt-get update \
    && apt-get upgrade -y \
    && apt-get install -y curl \
    && curl -sL https://deb.nodesource.com/setup_8.x | bash - \
    && apt-get install -y nodejs \
    && npm install -g react-tools \
    && chmod u+x deploy_app.sh

RUN npm install
RUN npm run webpack:build


EXPOSE 8080

CMD ./deploy_app.sh