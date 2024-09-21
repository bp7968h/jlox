# jlox Interpreter
This project is an implementation of the jlox interpreter from the book Crafting Interpreters by Robert Nystrom. jlox is a tree-walk interpreter for the Lox programming language, which is dynamically typed and supports object-oriented and functional programming.

## Features
- Supports expressions, statements, and control flow.
- Dynamically typed variables.
- First-class functions and closures.
- Object-oriented programming with classes, inheritance, and methods.
- Error handling for both runtime and syntax errors.

## Prerequisites
- Java 8 or higher installed on your machine.

## Running jlox
1. Clone this repository:
```bash
git clone https://github.com/bp7968h/jlox.git
cd jlox
```

2. Compile the interpreter:
```
javac -d out src/lox/*.java
```

3. Run the interpreter:
```
java -cp out lox.Lox
```

4. To run a Lox script, provide the script file as an argument:
```
java -cp out lox.Lox script.lox
```

## Usage
You can use jlox interactively or run .lox files. In interactive mode, type Lox code directly into the terminal:
```bash
> print "Hello, World!";
Hello, World!
> var x = 10;
> print x + 2;
12
```