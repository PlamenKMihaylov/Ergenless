# ergenless-show

A Java OOP project simulating a dating show where participants ("Ergenkas")
go through date events and are eliminated based on different rules.

The project is built as part of an Object-Oriented Programming assignment
and demonstrates clean separation of responsibilities, interface-based design,
and basic algorithmic logic.

## 🧠 Core Concepts
- Interfaces and implementations
- Encapsulation and immutability
- Polymorphism
- Separation of concerns
- Basic algorithms (filtering, elimination rules, Boyer–Moore voting)

## 🧩 Project Structure
```
src/
 └── bg/sofia/uni/fmi/mjt/show/
     ├── Main.java
     ├── ShowAPI.java
     ├── ShowAPIImpl.java
     ├── date/
     │   └── DateEvent.java
     ├── ergenka/
     │   ├── Ergenka.java
     │   ├── RomanticErgenka.java
     │   └── HumorousErgenka.java
     └── elimination/
         ├── EliminationRule.java
         ├── LowestRatingEliminationRule.java
         ├── LowAttributeSumEliminationRule.java
         └── PublicVoteEliminationRule.java
```

## ▶️ How to Run

### Prerequisites
- Java JDK 17+ (or compatible)
- Terminal / Command Prompt

---

### Steps

1. **Navigate to the project root**  
   The project root is the directory that contains the `src` folder.

   ```bash
   cd path/to/ergenka-show
Compile the project
This compiles all Java source files and outputs the compiled classes to the out directory.

```bash
javac -d out $(find src -name "*.java")
Windows (PowerShell):

javac -d out (Get-ChildItem -Recurse src -Filter *.java).FullName
Run the application
Execute the Main class using its fully qualified name.


java -cp out bg.sofia.uni.fmi.mjt.show.Main
