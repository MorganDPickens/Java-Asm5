# Java-Asm5


1 Understand
1.1 Know the Objectives
Upon project completion, you will have acquired a solid understanding of the following concepts and their
implementation in code:
• Fractals (created using recursion)
• Event-Driven Programming
• Swing
1.2 Understand the Problem
Fractals are often drawn using recursion, usually starting with one drawn pattern, then branching off to smaller
“children” patterns, smaller and offset in some way until the desired recursion depth has been reached or the objects
become too small to bother drawing.
Page 2 of 3
In this fractal, first, the largest triangle is drawn, then inside it a new one, the vertices of which are located in the
middle of the sides of the triangle in which it is located. You get 4 inner triangles. Next, you need to inscribe new
triangles excluding the central one. This operation must be repeated up to the specified number of levels.
The coordinates of the vertices are specified in the text fields on the left, the level is at the top. The 'Clear' button
clears the window, the 'Draw' button draws the fractal.
2 Design
Before you code, create appropriate design documentation and obtain feedback. Update designs per feedback, then
use them during the rest of the development process and submit them as part of your project. Recommended tool:
Violet, which creates the diagram types we need, along with others.
3 Code
Create a Point class that has the following fields: int x, int y. Instead of creating a class Point, you can use a class Point
from Java. In this case, you should remember that getX() and getY() methods return type double (you need a type int).
Create a class Triangle that has six Point class variables (3 - vertices of the triangle and 3 midpoints of the sides of the
triangle). Add a draw(Graphics g) method, which draws the triangle.
Create a MyWindow class, which should be a subclass of the JFrame class.
You will need the following libraries:
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
All objects (you will need JLabel, JTextField, JButton, JSlider slide) are added to the JPanel.
Also, you will work with the JColorChooser (to set a color).
4 Document
4.1 Follow the Style Guide
Adhere to the Course Style Guide linked in the Reference section of the Modules list in Canvas.
4.2 Write JavaDoc
Write complete JavaDoc notation for all classes in this project. This means that an -Xdoclint:all comes back with no
errors or warnings. If there are errors or warnings, you will lose points.
5 Demonstrate
