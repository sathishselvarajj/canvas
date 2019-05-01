The project is developed using java jdk 10.

Local Setup: Import the project as gradle project and execute gradle clean and build.

How to Run the application: Run "MyConsoleDrawer.java" as java application and enter the commands in console.

Command to draw a canvas - C 10 3 (to create a canvas with 10 and 3 as coordinates) Once canvas is drawn try different shapes like Line, Rectangle

To draw Rectangle - R 9 1 2 3 To draw Line - L 1 2 6 2 To to Bucket Fill - B 9 2 g

Sample outputs below: Please enter the command: C 10 3
------------
|          |
|          |
|          |
------------
Please enter the command: R 9 1 2 3
------------
| xxxxxxxx |
| x      x |
| xxxxxxxx |
------------
Please enter the command: L 1 2 6 2
------------
| xxxxxxxx |
|xxxxxx  x |
| xxxxxxxx |
------------
Please enter the command: B 10 1 g
------------
| xxxxxxxxg|
|xxxxxx  xg|
| xxxxxxxxg|
------------
Please enter the command: B 10 2 e
------------
| xxxxxxxxe|
|xxxxxx  xe|
| xxxxxxxxe|
------------