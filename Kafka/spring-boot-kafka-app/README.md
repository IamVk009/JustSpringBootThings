# Spring Boot Kafka Example

## Description

This is a simple Spring Boot application that demonstrates how to use Kafka as a messaging system with one producer and one consumer. The producer sends messages to a Kafka topic, and the consumer listens to that topic and processes the messages.

---

## What is Apache Kafka?

Apache Kafka is an open-source distributed event streaming platform used for building real-time data pipelines and streaming applications. It is designed to handle high throughput and is highly scalable. Kafka allows you to publish, subscribe to, store, and process streams of records (messages) in real-time.

---

## Key Kafka Concepts

### 1. **Producer**
A producer is an application that sends records (messages) to Kafka topics. The producer is responsible for choosing which topic to send data to and the partition within the topic where the message will be stored.

### 2. **Consumer**
A consumer is an application that reads records (messages) from Kafka topics. Consumers can join a group, and Kafka ensures that each record within a topic is read by only one consumer within the group.

### 3. **Topic**
A topic is a category or feed name to which records are sent by producers and consumed by consumers. Each record in Kafka is written to a topic and is associated with a partition.

### 4. **Broker**
A broker is a Kafka server that stores and serves records. Multiple brokers can be clustered together to form a Kafka cluster. A Kafka broker handles the reading and writing of records to the partitions of topics.

### 5. **Zookeeper**
Zookeeper is a centralized service used by Kafka to manage and coordinate the brokers. It helps Kafka maintain metadata, track the health of brokers, and coordinate the distribution of partitions across brokers. However, newer versions of Kafka are working to remove the dependency on Zookeeper.

---

## How to Set Up Kafka and Zookeeper Locally

### Prerequisites

To run this application locally, you'll need to install Kafka and Zookeeper. Here's how you can do that:

### Step 1: Install Zookeeper and Kafka

#### **For Windows Users**

1. **Install Zookeeper on Windows**

    - Download the Zookeeper binary from the official site:  
      [Zookeeper Releases](https://zookeeper.apache.org/releases.html)

    - Extract the ZIP file to a directory, e.g., `C:\zookeeper`.

    - Configure Zookeeper by editing the `conf\zoo_sample.cfg` file and renaming it to `zoo.cfg`. Set the `dataDir` property in the `zoo.cfg` file to a valid directory, e.g., `C:\zookeeper\data`.

    - To start Zookeeper, open a command prompt and run:

      ```bash
      cd C:\zookeeper
      bin\zkServer.cmd
      ```

2. **Install Kafka on Windows**

    - Download Kafka from the official site:  
      [Kafka Downloads](https://kafka.apache.org/downloads)

    - Extract the ZIP file to a directory, e.g., `C:\kafka`.

    - Open a command prompt and run the following command to start the Kafka broker:

      ```bash
      cd C:\kafka
      bin\windows\kafka-server-start.bat config\server.properties
      ```

   Kafka will now be running on `localhost:9092`.

#### **For Mac/Linux Users**

1. **Install Zookeeper on Mac/Linux**

    - **Using Homebrew (Mac)**:  
      Run the following command to install Zookeeper:

      ```bash
      brew install zookeeper
      ```

      After the installation is complete, start Zookeeper with:

      ```bash
      zkServer start
      ```

    - **For Linux**:  
      You can download Zookeeper from [Zookeeper Releases](https://zookeeper.apache.org/releases.html), extract it, and configure the `zoo.cfg` file as mentioned earlier. Start Zookeeper using:

      ```bash
      bin/zkServer.sh start
      ```

2. **Install Kafka on Mac/Linux**

    - **Using Homebrew (Mac)**:  
      Run the following command to install Kafka:

      ```bash
      brew install kafka
      ```

      To start Kafka, use the following command:

      ```bash
      kafka-server-start /usr/local/etc/kafka/server.properties
      ```

    - **For Linux**:  
      Download Kafka from [Kafka Downloads](https://kafka.apache.org/downloads), extract it, and start Kafka using:

      ```bash
      bin/kafka-server-start.sh config/server.properties
      ```

Kafka will now be running on `localhost:9092`.

---

### Step 2: Start Kafka

- **Start Kafka Broker**:
  Kafka relies on Zookeeper to manage and coordinate Kafka brokers, so you must start Kafka after starting Zookeeper.

  Run the following command to start the Kafka broker:

  ```bash
  bin/kafka-server-start.sh config/server.properties  # For Mac/Linux
  bin\kafka-server-start.bat config\server.properties  # For Windows

## Running the Application

Once you have Kafka and Zookeeper running, follow the steps below to run the Spring Boot Kafka example.

1. **Clone the Repository to your local machine**
2. **Run the Application**
3. **To test the Kafka producer and consumer, send a POST request to the application to produce a message to Kafka using Postman**
4. **The application has a consumer that listens to the Kafka topic and prints out the consumed messages. You can check the console/log output of the Spring Boot application to see the messages being consumed**

## Important Kafka Commands

1. **Create a Topic**

    ```bash
      cd C:\kafka
      bin\windows\kafka-topics.sh --bootstrap-server localhost:9092 --create --topic <topic-name> --partitions 1 --replication-factor 1
      ```
2. **List Topics**

    ```bash
      bin\windows\kafka-topics.sh --bootstrap-server localhost:9092 --list
      ```
3. **Describe a Topic**

    ```bash
      bin\windows\kafka-topics.sh --bootstrap-server localhost:9092 --describe --topic <topic-name>
      ```
4. **Produce a Message to a Topic**

    ```bash
      bin\windows\kafka-console-producer.sh --broker-list localhost:9092 --topic <topic-name>
      ```
5. **Consume Messages from a Topic**

    ```bash
      bin\windows\kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic <topic-name> --from-beginning
      ```

