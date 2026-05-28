Calculator App
A Java calculator with two interfaces — a JavaFX GUI and a console-based CLI — supporting both basic arithmetic and advanced mathematical operations.

Features
Operation	Symbol	Notes
Addition	+	Supports multiple numbers
Subtraction	-	Supports multiple numbers
Multiplication	*	Supports multiple numbers
Division	/	Supports multiple numbers; guards against division by zero
Power	^	Requires exactly 2 numbers
Square Root	sqrt / √	Requires exactly 1 non-negative number
Factorial	!	Requires exactly 1 number (0–20)
Natural Log	log / ln	Requires exactly 1 positive number
Project Structure
workshop-calcApp-demo/
├── src/
│   ├── main/java/com/gloriane/
│   │   ├── Calculator.java       # Core calculation logic (static methods)
│   │   ├── CalculatorGUI.java    # JavaFX graphical interface
│   │   └── DemoApp.java          # Console/CLI interface
│   └── test/java/com/gloriane/
│       └── CalculatorTest.java   # JUnit 5 unit tests
├── run.bat                       # Run GUI via manual classpath
├── run-simple.bat                # Run GUI via Maven or fallback
└── pom.xml
Requirements
Java 21+
Maven 3.6+ (recommended)
JavaFX 21 (auto-downloaded via Maven)
Getting Started
Run the GUI (recommended)
mvn clean javafx:run
Or use the provided batch scripts on Windows:

# Auto-detects Maven or falls back to manual classpath
run-simple.bat

# Manual classpath (requires Maven dependencies already downloaded)
run.bat
Run the CLI
mvn compile exec:java -Dexec.mainClass="com.gloriane.DemoApp"

Example session:

===== Welcome to My Calculator App =====
How many numbers do you want to calculate with?
> 3
Enter number 1: 10
Enter number 2: 5
Enter number 3: 2
Select operation (+, -, *, /, ^, sqrt, !, log):
> +
The result is: 17.0
Do you want to perform another calculation? (y/n): n
Thank you for using the calculator!
Running Tests
mvn test

Tests cover: addition, subtraction, multiplication, division, power, square root, factorial, natural log, division by zero, null input, and empty arrays.

Built With
Java 21
JavaFX 21
JUnit Jupiter 5.10.0
Maven
