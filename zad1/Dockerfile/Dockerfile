# download base image ubuntu 22.04
FROM ubuntu:22.04

# UPDATE
RUN apt-get update

# configure place
RUN mkdir Dawid
WORKDIR Dawid
RUN mkdir Python

#INSTALL Python 3.8.15
WORKDIR /Dawid/Python
RUN apt install -y wget
RUN wget https://www.python.org/ftp/python/3.8.15/Python-3.8.15.tgz
RUN tar -xf Python-3.8.15.tgz
RUN apt install -y gcc
WORKDIR  /Dawid/Python/Python-3.8.15
RUN ./configure
RUN apt install -y make
RUN apt install -y zlib1g-dev
RUN make install

# add python to ENV
ENV PATH="${PATH}:/Dawid/Python/Python-3.8.15/bin"

# add JAVA 8
RUN apt-get install -y openjdk-8-jdk

#install kotlin
RUN apt install -y kotlin

#install gradle
WORKDIR Dawid
RUN mkdir Gradle
WORKDIR /Dawid/Gradle
RUN wget https://downloads.gradle-dn.com/distributions/gradle-7.5.1-all.zip
RUN unzip gradle-7.5.1-all.zip
WORKDIR /Dawid/Gradle/gradle-7.5.1/bin
RUN ./gradle

#add gradle to ENV
ENV PATH="${PATH}:/Dawid/Gradle/gradle-7.5.1/bin"



# add copy Gradle project with Kotlin "helloworld" app
# and JDBC SQLite settings in build.gradle
COPY Kotlin /Dawid/Kotlin
WORKDIR /Dawid/Kotlin
RUN ./gradlew
RUN ./gradlew run
RUN kotlinc hello.kt
RUN kotlin HelloKt
WORKDIR /Dawid



