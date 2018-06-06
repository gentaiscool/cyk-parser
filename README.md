# Cocke–Younger–Kasami Algorithm Parser
This project shows the implementation of CYK algorithm in Java. It is a bottom-up parsing using dynamic programming paradigm with <b>O(n^3.|G|)</b> time complexity where <b>n</b> is the length of the string and <b>G</b> is the size of the Chomsky Normal Form (CNF) grammars. We also provide a GUI for the visualization.

## Requirement
- Java 7 (or later)
- (Optional) Eclipse IDE

## Update rules
The rules are in <b>rules.txt</b>. They are written in Context Free Grammar (CFG) standard form. 
1. Non-Terminal production (left and right: starts with upper case)
```
ModVPlace -> ModV PrepPlace
```
2. Terminal production (left: starts with upper case, right: lower case)
```
PrepPlace -> in
```

## Run the program
- <b>rules.txt</b> must be placed in the same directory as <b>parser.jar</b>
- Run the following command
```
java -jar parser.jar
```
- Type your sentence and press <b>Cek</b> button.

## Develop
- If you are interested using this code, you can fork and clone this repository and use Eclipse IDE to import the project.

## Authors
- Genta Indra Winata
- Sonny Lazuardi

## Note
Natural Language Processing Assignment in Institut Teknologi Bandung
