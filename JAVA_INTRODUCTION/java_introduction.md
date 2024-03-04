# Steps to use JAVA with Visual Studio Code :D

## First you have to download the following elements
1. JAVA EXTENSION PACK IN VISUAL STUDIO CODE
2. JDK (JAVA development kit) here you have the link: https://www.oracle.com/java/technologies/downloads/#jdk21-windows
    - I recommend you to use the x64 installer because is the easier one.

## Once you downloaded them you have to set the environment variable.
    - After installing the JDK, set the JAVA_HOME environment variable to point to the JDK installation directory.
    - Make sure the PATH environment variable includes the path to the JDK bin directory.

## Now you can program in JAVA.

# Introduction to JAVA 
## Steps to set  the variable and path environments.
   - system => advanced system settings => environment variables => NEW ("JAVA_HOME", path of the container JAVA folder.)
   - system => advanced system settings => environment PATH => PATH => EDIT (EXAMPLE: C:Program Files\Java\jdk-21\bin) => SAVE
   - restart Visual Studio Code

## Once you completed the setting of the environments you should be able to code in JAVA.

# Syntax of JAVA, first 'Hello, World!'

// FIRST HELLO WORLD!
1.  public class introduction {
        public static void main(String[] args) {
            System.out.println("Hello, World!");
        }
    }

2. Open the terminal.

3. cd 'path of the folder where the .java its saved'.

4. javac 'name of the java file + .java'.  This is the java compilator, translates .java into bytecode (The language of JVM (JAVA virtual machine))

5. java 'name of the java file'. This command execute the program.   

### You can avoid all these steps if you have the JAVA EXTENSION PACK in Visual Studio Code because it gives you a tool to directly execute the program with two buttons RUN|DEBUG
<!-- ALL OF THIS JUST TO MAKE A FKIN HELLO WORLD :( -->

# Rules for JAVA
    - DOBLE QUOTATION MARKS FOR TEXT STRINGS (""), SIMPLE QUOTATION MARKS CANNOT BE USED FOR TEXT STRINGS.
    - SIMPLE QUOTATION MARKS TO USE INSIDE OF A TEXT STRINGS OR IF YOU WANT TO PRINT JUST ONE CHARACTER ('A').
    - IN JAVA WE DONT USE BACKSTICKS (``).
    - UNDEFINED DOES NOT EXIST, IF YOU TRY TO USE A VARIABLE BEFORE INITIALIZING IT YOU WILL GET AN ERROR, EACH DATA TYPE HAS ITS OWN PREDETERMINATED VALUE WHICH CAN BE NULL, 0 FOR NUMBERS, AND FALSE FOR BOOLEANS.

# Data types in JAVA
### Primitive data types: 
#### Numeric Data Types:
    int: 32-bit signed integer.
    long: 64-bit signed integer.
    float: 32-bit floating-point.
    double: 64-bit floating-point.
    Use L for long literals (e.g., long bigNumber = 1000000000L).
    Example: int age = 25;

#### Boolean Data Type:
    Represents true or false values.
    Example: boolean isJavaFun = true;

#### Character Data Type:
    Represents a single character.
    Use single quotes (' ') for character literals.
    Example: char grade = 'A';

### Reference data types:
#### Arrays:
    Collections of elements of the same type.
    Declared using square brackets (e.g., int[] numbers).
    Example: int[] scores = {90, 85, 92};

#### Strings in Java:
    Strings represent sequences of characters.
    Use double quotes (" ") for string literals.
    Example: String message = "Hello, World!".

#### Classes and Objects:
    You can create your own classes and objects.

#### Enumerations:
    enum: Represents a fixed set of constants.

### OTHER TYPE OF DATA
#### Constants:
    Use final for constants (e.g., final double PI = 3.14;).
    Constants are variables whose values shouldn't change.

#### Special Data Types:
    null: Represents the absence of a value.

#### Primitive Data Types vs. Objects:
    Primitive data types (int, boolean, etc.) store values directly.
    Objects (e.g., String, Integer) are instances of classes and offer more functionality.

#### EXAMPLES FOR EACH TYPE OF DATA
    - Primitive Data Types
        int age = 25;
        double price = 49.99;
        float temperature = 23.5f;  // Note the 'f' indicating it's a float
        char grade = 'A';
        boolean isJavaFun = true;

    - Reference Data Types (Objects)
        String message = "Hello, World!";
        int[] numbers = {1, 2, 3, 4, 5};
        Person person = new Person("John Doe");
        Color color = Color.RED;

    - Enumerations
        enum Day { SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY };
        Day today = Day.MONDAY;

    - Special Data Type
         String name = null;


# JAVA STRUCTURE 
###  - Java Class Structure:
    A Java class defines the structure and behavior of an object.
    It can contain fields (properties) and methods (behaviors).

###  - Public Class and Main Method:
    In Java, the main method in a public class is the main entry point for program execution.
    Only one class can be public per file, and its name must match the filename.
    
### - Java Packages:
    Packages are directories containing related classes.
    They are used to organize and structure source code.

###  - Naming Conventions:
    Conventions like using src for source folder and com as part of package names are common but not mandatory.
    Following conventions aids collaboration and code comprehension.

###  - Classes in the Same Package:
    Multiple .java files in the same package can share non-public classes, but only one can be public.

###  - Java Compilation and Execution:
    javac compiles .java files into .class files.
    java executes the program by specifying the main class with the main method.

###  - Project Organization:
    Organizing classes into packages and following a clear structure enhances maintainability and code understanding. 

##  - Folder structure: 
proyecto/
└── src/
    └── com/
        └── ejemplo/
            ├── MiClasePrincipal.java
            ├── OtraClase.java
            └── ClaseAdicional.java

