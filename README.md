# OpenAI Spring Boot Application

A Spring Boot application that integrates with OpenAI's API to provide AI-powered chat capabilities through REST endpoints. This application leverages Spring AI framework to simplify interactions with OpenAI models.

## Table of Contents

- [Features](#features)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Configuration](#configuration)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Project Structure](#project-structure)
- [Building and Running](#building-and-running)
- [Testing](#testing)
- [Troubleshooting](#troubleshooting)
- [Author](#author)
- [License](#license)

## Features

- 🤖 **OpenAI Integration**: Seamless integration with OpenAI's chat models using Spring AI
- 🌐 **REST API**: Simple REST endpoints for sending prompts and receiving AI-generated responses
- 🚀 **Spring Boot**: Modern Spring Boot 4.1.0 with auto-configuration
- ☕ **Java 17**: Built with Java 17 for enhanced performance and features
- 🧪 **Testing Ready**: Includes integration tests for context loading verification

## Prerequisites

Before you begin, ensure you have the following installed:

- **Java 17 or higher**: Download from [Oracle JDK](https://www.oracle.com/java/technologies/downloads/#java17) or use [OpenJDK](https://openjdk.java.net/)
- **Maven 3.6.0 or higher**: Download from [Apache Maven](https://maven.apache.org/download.cgi)
- **OpenAI API Key**: Get your API key from [OpenAI Platform](https://platform.openai.com/account/api-keys)
- **Git**: For cloning the repository (optional)

## Installation

### 1. Clone or Download the Project

```bash
git clone <repository-url>
cd openai
```

Or download and extract the project files to your desired location.

### 2. Verify Java Installation

```bash
java -version
```

Ensure the version is Java 17 or higher.

### 3. Verify Maven Installation

```bash
mvn -version
```

Ensure Maven is installed and properly configured.

## Configuration

### OpenAI API Key Setup

The application requires an OpenAI API key to function. Configure it using one of the following methods:

#### Option 1: Environment Variable (Recommended)

Set the `SPRING_AI_OPENAI_API_KEY` environment variable:

**On Windows (PowerShell):**
```powershell
$env:SPRING_AI_OPENAI_API_KEY="your-api-key-here"
```

**On Windows (Command Prompt):**
```cmd
set SPRING_AI_OPENAI_API_KEY=your-api-key-here
```

**On Linux/macOS:**
```bash
export SPRING_AI_OPENAI_API_KEY="your-api-key-here"
```

#### Option 2: Application Properties File

Create or edit `src/main/resources/application.yaml`:

```yaml
spring:
  ai:
    openai:
      api-key: your-api-key-here
      model: gpt-4
```

#### Option 3: Application Properties File (Alternative)

Create or edit `src/main/resources/application.properties`:

```properties
spring.ai.openai.api-key=your-api-key-here
spring.ai.openai.model=gpt-4
```

**⚠️ Important**: Never commit your API key to version control. Use environment variables or `.gitignore` property files.

## Usage

### Starting the Application

#### Using Maven

```bash
mvn spring-boot:run
```

#### Using JAR File

First, build the application:

```bash
mvn clean package
```

Then run the JAR:

```bash
java -jar target/openai-0.0.1-SNAPSHOT.jar
```

The application will start on `http://localhost:8080` by default.

### Making Requests

Once the application is running, you can interact with the API using curl, Postman, or any HTTP client.

#### Using cURL

```bash
curl "http://localhost:8080/get/What%20is%20artificial%20intelligence?"
```

#### Using PowerShell

```powershell
Invoke-RestMethod -Uri "http://localhost:8080/get/What%20is%20artificial%20intelligence?"
```

#### Using Python

```python
import requests

prompt = "What is artificial intelligence?"
response = requests.get(f"http://localhost:8080/get/{prompt}")
print(response.json())
```

## API Endpoints

### Get AI Response

**Endpoint:** `GET /get/{prompt}`

**Description:** Sends a prompt to OpenAI and returns both the prompt and the AI-generated response.

**Path Parameters:**
- `prompt` (string, required): The user's input prompt to be sent to the AI model

**Response Format:**
```json
{
  "prompt": "What is artificial intelligence?",
  "response": "Artificial intelligence (AI) is the simulation of human intelligence processes by computer systems..."
}
```

**Example Request:**
```bash
GET /get/Explain%20quantum%20computing%20in%20simple%20terms
```

**Example Response:**
```json
{
  "prompt": "Explain quantum computing in simple terms",
  "response": "Quantum computing is a type of computing that uses quantum bits (qubits) instead of traditional bits..."
}
```

**Status Codes:**
- `200 OK`: Request successful, response received
- `400 Bad Request`: Invalid prompt or missing required parameters
- `401 Unauthorized`: Invalid or missing OpenAI API key
- `500 Internal Server Error`: Server-side error or OpenAI API error

## Project Structure

```
openai/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/demo/openai/
│   │   │   │   └── OpenaiApplication.java    # Main Spring Boot application entry point
│   │   │   └── controller/
│   │   │       └── RestController.java       # REST endpoints for AI interactions
│   │   └── resources/
│   │       ├── application.yaml              # Application configuration (optional)
│   │       ├── application.properties        # Application properties (optional)
│   │       ├── static/                       # Static web resources
│   │       └── templates/                    # HTML templates
│   └── test/
│       └── java/
│           └── com/demo/openai/
│               └── OpenaiApplicationTests.java  # Integration tests
├── target/                                   # Compiled classes and packages
├── pom.xml                                   # Maven project configuration
├── mvnw                                      # Maven wrapper (Linux/macOS)
├── mvnw.cmd                                  # Maven wrapper (Windows)
├── HELP.md                                   # Build and deployment help
└── README.md                                 # This file
```

## Building and Running

### Clean Build

```bash
mvn clean install
```

### Build Only (Skip Tests)

```bash
mvn clean package -DskipTests
```

### Run with Maven

```bash
mvn spring-boot:run
```

### Run as Standalone JAR

```bash
# Build the JAR
mvn clean package

# Run the JAR
java -jar target/openai-0.0.1-SNAPSHOT.jar
```

### Run with Custom Port

```bash
java -jar target/openai-0.0.1-SNAPSHOT.jar --server.port=9090
```

### Run with Custom OpenAI API Key

```bash
java -jar target/openai-0.0.1-SNAPSHOT.jar --spring.ai.openai.api-key=your-key-here
```

## Testing

### Run All Tests

```bash
mvn test
```

### Run Specific Test Class

```bash
mvn test -Dtest=OpenaiApplicationTests
```

### Run Tests with Verbose Output

```bash
mvn test -X
```

### Test Coverage

The application includes integration tests that verify:
- Spring Boot application context initialization
- Bean configuration and auto-configuration
- ChatClient availability and configuration

Run the tests after making modifications to ensure nothing is broken:

```bash
mvn clean test
```

## Troubleshooting

### Issue: "Invalid API Key" or 401 Unauthorized

**Solution:**
1. Verify your OpenAI API key is correct
2. Ensure the API key is set in the environment variable or configuration file
3. Check that the API key has the necessary permissions in the OpenAI dashboard
4. Verify the format matches `sk-...`

### Issue: "Application fails to start"

**Solution:**
1. Ensure Java 17 or higher is installed: `java -version`
2. Check that Maven is properly installed: `mvn -version`
3. Verify internet connection for downloading dependencies
4. Clear Maven cache: `mvn clean`
5. Check logs for specific error messages

### Issue: "Port 8080 already in use"

**Solution:**
Run on a different port:
```bash
java -jar target/openai-0.0.1-SNAPSHOT.jar --server.port=9090
```

### Issue: "No response from the API"

**Solution:**
1. Verify the application is running: `http://localhost:8080/get/hello`
2. Check your internet connection and firewall settings
3. Ensure OpenAI API is reachable from your location
4. View application logs for detailed error information

### Issue: "Timeout errors"

**Solution:**
1. Increase the request timeout in your HTTP client
2. Check OpenAI service status
3. Verify API key limits haven't been exceeded
4. Try with a simpler, shorter prompt

## Dependencies

### Core Dependencies

- **Spring Boot 4.1.0**: Web framework and auto-configuration
- **Spring Web MVC**: REST endpoint creation and HTTP handling
- **Spring AI OpenAI**: OpenAI integration for chat capabilities

### Development Dependencies

- **JUnit 5**: Testing framework
- **Spring Boot Test**: Integration testing utilities

See `pom.xml` for complete dependency list.

## Author

**Pramod Rajane**

## License

This project is provided as-is for educational and demonstration purposes. Ensure compliance with OpenAI's terms of service when using their API.

## Additional Resources

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Spring AI Documentation](https://spring.io/projects/spring-ai)
- [OpenAI API Documentation](https://platform.openai.com/docs)
- [Java 17 Documentation](https://docs.oracle.com/en/java/javase/17/)
- [Maven Documentation](https://maven.apache.org/guides/)

## Support

For issues or questions:

1. Check the [Troubleshooting](#troubleshooting) section
2. Review application logs for error details
3. Verify all configuration settings
4. Check OpenAI API status and documentation

---

**Last Updated:** June 14, 2026

Happy coding! 🚀

