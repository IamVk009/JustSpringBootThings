# README

## Overview
This application interacts with DeepSeek AI using the `AiServiceImpl` class, which utilizes the Ollama framework for AI-driven responses. 
This guide explains how to install Ollama, set up DeepSeek:R1, and run the application successfully.

## Prerequisites
Ensure you have the following installed:
- **Java 17+**
- **Maven** (for building and running the application)

## Step 1: Install Ollama
Ollama is required to manage and interact with the AI models. Follow the instructions below to install it on your system.

### **For macOS**
brew install ollama

### **For Linux**
curl -fsSL https://ollama.ai/install.sh

### **For Windows**
1. Download the installer from [Ollama’s official website](https://ollama.ai/).
2. Run the installer and follow the setup instructions.

Verify installation by running:
ollama --version

## Step 2: Install DeepSeek:R1 Model
DeepSeek:R1 is an AI model that processes queries and generates responses.

### **Using Ollama to Download DeepSeek:R1**
Run the following command to pull the model:
ollama pull deepseek:r1
```
This will download and set up the DeepSeek model on your system.

To verify the installation:
ollama list
```
You should see `deepseek:r1` in the list of available models.

---

## Step 3: Configure the Application
Update your `application.properties` file with the necessary configurations for the AI service:
```
ollama.model=deepseek:r1
ollama.endpoint=http://localhost:11434
```

If running Ollama in a different setup, ensure the `endpoint` is correctly set to match your server.

---

## Step 4: Run the Application
Once the dependencies are set up, Run this Spring Boot Application in your IDE.

### **Testing the API**
Use the following endpoints to interact with the AI model:

#### **1. Synchronous AI Response**
GET http://localhost:8080/api/v1/ai/askAi?prompt=value
This API sends a prompt to the AI model and returns a **single** response.

#### **2. Streaming AI Response**
GET http://localhost:8080/api/v1/ai/askAi/stream?prompt=value
This API sends a prompt to the AI model and returns a **stream of responses** using a reactive approach (Flux).


## Conclusion
By following the steps above, you have successfully installed Ollama, set up DeepSeek:R1, and run the application. Now, you can send prompts and receive AI-generated responses. Happy coding!

## Referances
https://docs.spring.io/spring-ai/reference/1.0/api/chatclient.html

https://docs.spring.io/spring-ai/reference/1.0/api/chat/ollama-chat.html
