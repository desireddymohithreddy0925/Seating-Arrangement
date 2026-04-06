# 🎓 Seating Arrangement Generator

## 📌 Project Overview

The **Seating Arrangement Generator** is a web-based application that automatically generates seating arrangements for participants while avoiding conflicts between them.
It uses a **backtracking algorithm** to ensure that no conflicting participants sit adjacent to each other.

---

## 🚀 Features

* 🪑 Automatic seating generation
* ⚠️ Conflict handling between participants
* 🔄 Backtracking-based solution
* 🎨 Modern UI with animations
* 📱 Mobile responsive design
* 🔁 Generate again option

---

## 🛠️ Tech Stack

* **Frontend:** HTML, CSS
* **Backend:** Java, Spring Boot
* **Template Engine:** Thymeleaf
* **Build Tool:** Maven

---

## 📂 Project Structure

```
src/main/java/com/example/demo/
    DemoApplication.java
    SeatingController.java
    SeatingService.java

src/main/resources/
    templates/
        index.html
        result.html
    static/
        style.css
    application.properties
```

---

## ⚙️ How It Works

1. User enters:

   * Number of rows & columns
   * Participants
   * Conflict pairs

2. Backend:

   * Initializes seating matrix
   * Applies **backtracking algorithm**
   * Checks conflicts before placing each participant

3. Output:

   * Displays valid seating arrangement
   * If not possible → shows error message

---

## 📥 Input Explanation

The system takes the following inputs from the user:

* **Rows (Integer):** Number of rows in seating layout
* **Columns (Integer):** Number of columns in seating layout
* **Participants (String):** Comma-separated names

  * Example: `A,B,C,D`
* **Conflicts (String):** Pairs of participants who should not sit together

  * Format: `A-B,B-C`

### 🔹 Example Input

```
Rows: 2  
Columns: 2  
Participants: A,B,C,D  
Conflicts: A-B
```

---

## 📤 Output Explanation

The system generates:

* A **2D seating arrangement (matrix)**
* Ensures:

  * No conflicting participants sit adjacent (left/right/up/down)
  * Each participant is placed exactly once

### 🔹 Example Output

```
A   C
D   B
```

### ❌ If Not Possible

```
No valid arrangement possible
```

---

## ▶️ How to Run the Project

### 1. Clone Repository

```
git clone https://github.com/your-username/seating-arrangement-generator.git
cd seating-arrangement-generator
```

### 2. Run Application

```
./mvnw spring-boot:run
```

### 3. Open in Browser

```
http://localhost:8081/
```

---

## 📊 Algorithm Used

* **Backtracking**

  * Tries all possible seating combinations
  * Places participant only if safe
  * Backtracks if conflict occurs

---

## 📸 Output Example

```
A   C
D   B
```

---

## 🔮 Future Scope

* 💾 Database integration (MySQL)
* 📄 Export seating as PDF
* 🧑‍💼 Admin panel
* 🎯 Advanced conflict rules
* 🏫 Real exam hall system

---

## 🙋‍♂️ Author

* DESIREDDY MOHITH REDDY

---

## ⭐ Acknowledgement

This project was developed as part of academic learning to understand:

* Backtracking algorithms
* Spring Boot development
* Full-stack integration

---

## 📌 Note

Make sure port **8081** is free before running the application.
