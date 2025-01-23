# **PillGate**

## **Team Members**
- Emran Hamdard  
- William Kasasa  
- Manami Hayashi  
- Alperen Doganci  
- Narjiss Haijj  

---

## **Overview of the Project**
PillGate is a Java-based project that interfaces with Arduino devices. Our Minimum Viable Product (MVP) aims to:
1. **Remind users** to take their pills on time.  
2. **Detect and track** whether users have taken their pills.

This project integrates software and hardware to enhance medication adherence and healthcare outcomes.

---

## **Table of Contents**
- [Installation](#installation)
- [Configuration Instructions](#configuration-instructions)
- [Dependencies](#dependencies)
- [Interface Documentation](#documentation-of-interface-with-other-systems)
- [Usage and Features](#usage-and-features)
- [Contributing](#contributing)
- [License](#license)

---

## **Installation**
1. Clone the repository:
    ```bash
    git clone https://github.com/Manami-Hayashi/PillGate.git
    cd PillGate
    ```
2. Connect your Arduino to your computer and identify the COM5 serial port.
3. Upload your Arduino code using the Arduino IDE, then close the IDE.
4. Open IntelliJ IDEA or your preferred Java IDE.
5. Build the Gradle configuration file.
6. Set up a working PostgreSQL database using **pgAdmin4**.
7. Configure the `P2DConfig` file with:
    - Your PostgreSQL username.
    - Your PostgreSQL password.
    - The database URL.
8. Ensure the `application.properties` file matches the credentials from your `P2DConfig` file for database connectivity.
9. Uncomment the dummy data in the code for login and testing purposes.
10. Execute the application.
11. Open your browser and go to:
    ```
    http://localhost:8080/home
    ```
12. Log in or register a new user. You can use the pre-existing user credentials:
    - Email: `john.doe@example.com`
    - Password: `pass123`
13. Set up your medication schedules.  
    **Tip**: For testing, set the `timeTakePill` to one or two minutes later.  
14. You will receive reminders to take your pills.
15. Check the dashboard page for graphs showing your medication schedule and adherence.

---

## **Configuration Instructions**
- Ensure the Gradle configuration file is set up with the required dependencies:
    ```gradle
    implementation "org.springframework.boot:spring-boot-starter-jdbc"
    runtimeOnly "com.h2database:h2"
    implementation "com.fazecast:jSerialComm:2.10.4" // Serial communication with Arduino
    runtimeOnly "org.postgresql:postgresql"
    implementation "org.jfree:jfreechart:1.5.3" // Graphs and charts
    ```

---

## **Dependencies**
The project relies on the following:
- **Spring JDBC**: For database interaction using JdbcTemplate.
- **H2 Database**: In-memory database for development and testing.
- **jSerialComm**: Handles serial communication between the Arduino COM5 port and the Java application.
- **PostgreSQL**: The production database for persisting application data.
- **jFreeChart**: Generates graphs for data visualization in the dashboard.

---

## **Documentation of Interface with Other Systems**
### **Arduino Integration**
- Arduino device setup includes:
    - An **HX711 Load Sensor** for weight measurement.
    - A **test bed and pill box** for monitoring pill usage.
- Instructions for configuring the Arduino device and uploading the code are available in the Arduino-specific README within the project.

  
---

## **Usage and Features**
- **Medication Reminder**: Alerts users to take their pills at scheduled times.
- **Pill Detection**: Monitors whether the pills have been taken, using the Arduino and HX711 sensor.
- **Dashboard Visualization**: Provides graphs and data on pill adherence and medication schedules.

---

## **Contributing**
We welcome contributions to improve **PillGate**. To contribute:
1. Fork the repository.
2. Create a feature branch:
    ```bash
    git checkout -b feature-name
    ```
3. Commit your changes:
    ```bash
    git commit -m "Add feature description"
    ```
4. Push the branch to your fork:
    ```bash
    git push origin feature-name
    ```
5. Open a Pull Request.

---

## **License**
This project is licensed under the [MIT License](https://opensource.org/licenses/MIT).

---

## **Conclusion**
PillGate is an innovative combination of hardware and software aimed at improving medication adherence. It offers a simple yet effective approach to tracking and reminding users of their medications, with the potential to significantly enhance healthcare outcomes.

---
