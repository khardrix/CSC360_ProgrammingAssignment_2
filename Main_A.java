/*********************************************************************************************************************
 *********************************************************************************************************************
 *****  Class: CSC-360-001-2019-040    Semester: Summer 2019    Professor: Richard Fox    Student: Ryan Huffman  *****
 *****-----------------------------------------------------------------------------------------------------------*****
 *****                                   Programming Assignment #2, Part A                                       *****
 *****___________________________________________________________________________________________________________*****
 *****                                                                                                           *****
 *****         This assignment consists of writing two programs. Both use javafx to create graphics.             *****
 ***** You will have to explore the textbook and code examples to figure out which packages or classes to import.*****
 *****                 Do not import unnecessary packages but you can import entire packages                     *****
 *****     rather than specific classes of a package (e.g., javafx.scene.* rather than javafx.scene.Scene).      *****
 *****                                                                                                           *****
 *****-----------------------------------------------------------------------------------------------------------*****
 *****                              Part 1: Creating Graphics from an Input File                                 *****
 *****-----------------------------------------------------------------------------------------------------------*****
 *****       Similar to programming assignment #1, write a program which inputs commands from a text file.       *****
 *****                     For each command, draw the specified Shape into a Pane object.                        *****
 *****          The types of Shapes you will draw are limited to Circle, Rectangle, Ellipse and Line.            *****
 *****                  For each, the command (Shape) will be followed by either 3 or 4 int values               *****
 *****         (note: these classes expect doubles but the input file will have int values for simplicity,       *****
 *****                        you can input and store them as ints or doubles, your choice).                     *****
 *****                              The Circle only requires 3 values, the others 4.                             *****
 *****                                                                                                           *****
 *****-----------------------------------------------------------------------------------------------------------*****
 *****                             For instance, input might look like the following:                            *****
 *****                                            Circle 50 50 25                                                *****
 *****                                         Rectangle 50 100 25 50                                            *****
 *****                                          Ellipse 100 100 80 40                                            *****
 *****                                                                                                           *****
 *****                              In addition to shapes, another command is Color,                             *****
 *****           followed by 3 int values between 0 and 255 to indicate the RGB values of a new Color.           *****
 *****                  Have a Color variable which is initialized to Color.rgb(0,0,0) (black)                   *****
 *****                       and whenever a new Color command is reached in the input file,                      *****
 *****                      change the Color to the new Color using color = Color.rgb(r,g,b);                    *****
 *****                               where r,g,b are the latest three int values input.                          *****
 *****             Before generating a new shape, use setFill to set its Color to the current color,             *****
 *****                                except for Line which should use setStroke.                                *****
 *****                               All Shapes should be drawn with 100% opacity.                               *****
 *****                                          Make your Scene 500,500.                                         *****
 *****                                                                                                           *****
 *****                                  Write your program with three methods:                                   *****
 *****                                    main (which merely calls launch),                                      *****
 *****                                  start (which creates a Pane and Scene,                                   *****
 *****                 inserts the Pane into the Scene and the Scene into the Stage and shows the Stage.         *****
 *****                          You may set a title in your Stage but it is not necessary),                      *****
 *****                                               and input.                                                  *****
 *****                         The input method will do all of the inputting from disk file.                     *****
 *****                             The input method should receive the Pane object and                           *****
 *****  contain the logic to determine what the latest command is and draw the appropriate Shape into the Pane.  *****
 *****  The input method should have two nested try blocks similar to what you should have done in program #1.   *****
 *****                                                                                                           *****
 *****                     The outer block will try to open the input file using a Scanner.                      *****
 *****                 Upon successfully opening the file, iterate through each entry of the file.               *****
 *****                           Inside this while loop, have another try block.                                 *****
 *****                      This try block will get the next command, which is a String.                         *****
 *****              Based on the command, input either 3 or 4 numbers (ints or doubles, your choice),            *****
 *****                           change the Color or draw the Shape onto the Pane.                               *****
 *****       This inner try block should explicitly throw an Exception if either the command is not known,       *****
 *****           a value input does not fit within the Pane, or a value input is not a legal RGB value.          *****
 *****                          This is explained in detail in the next paragraph.                               *****
 *****                        By placing your inner try block within the while loop,                             *****
 *****                  it allows your program to continue to input from the text file and                       *****
 *****                          draw Shapes until you reach the end of the file                                  *****
 *****                     (as opposed to the while loop terminating upon an Exception).                         *****
 *****                                                                                                           *****
 *****                                 Create three new Exception classes:                                       *****
 *****                                        IllegalShapeException                                              *****
 *****      (this will arise if the command is not one of the four valid Shape names or the word “Color”),       *****
 *****                                                                                                           *****
 *****                                      IllegalCoordinateException                                           *****
 *****   (this will arise if a numeric value causes the Shape being drawn to go outside of the 500x500 Scene     *****
 *****                           – for instance with a negative value for x or y, or                             *****
 *****              if the height/width/radius causes the shape to extend before 0 or beyond 500),               *****
 *****                                                                                                           *****
 *****                                      and IllegalColorException                                            *****
 *****            (which arises if one of the int values for the RGB value is not between 0 and 255).            *****
 *****                                                                                                           *****
 *****                     The catch blocks for these will follow in the inner try block.                        *****
 *****                         In addition, have a catch for NumberFormatException                               *****
 *****             (which should arise if a value that is supposed to be numeric is not numeric).                *****
 *****                                                                                                           *****
 *****        Assume that all Shapes are correctly specified in terms of the proper number of parameters         *****
 *****                          (Circle and Color have 3 parameters, the others 4) and                           *****
 *****                     that if there is an incorrect command (e.g., Arc or Colour) then                      *****
 *****                 there are no parameters which follow it – this will simplify your code so                 *****
 *****                that you don’t have to worry about handling parameters of an incorrect Shape.              *****
 *****                                                                                                           *****
 *****                        For this program, define the three new Exception classes                           *****
 *****                     (each of which should have a no-arg and a 1-arg constructor) and                      *****
 *****                          then your main class with the methods described above.                           *****
 *****                  You do not need any other classes and while you can add other methods,                   *****
 *****                     only the three mentioned above are required (main, start, input).                     *****
 *****                                                                                                           *****
 *****                       When done, test your program on the file input1.txt and                             *****
 *****           compare your results to the output image listed below this assignment in this module.           *****
 *****        Once your program is running correctly, run it on the input files input2.txt and input3.txt,       *****
 *****                           also listed below this assignment in this module.                               *****
 *****                                                                                                           *****
 *****___________________________________________________________________________________________________________*****
 *****                                                                                                           *****
 *****                                 Part 2: Creating Graphics from User Input                                 *****
 *****___________________________________________________________________________________________________________*****
 *****     This program will require that you input values from the user via the keyboard (using a Scanner).     *****
 *****                 The input will consist of 3 Strings and several double (or int) values.                   *****
 *****                  In order to display the Strings, place each into its own Text object.                    *****
 *****          The second and third Text objects will have coordinates of 50,350 and 350,350 respectively       *****
 *****                                        (make your Scene 500,500),                                         *****
 *****        the first Text object will be the Node of a Polyline so you do not indicate its coordinates.       *****
 *****                    The double/int values will dictate the coordinates of the Polyline.                    *****
 *****                                                                                                           *****
 *****                   Create a PathTransition variable whose Path will be the Polyline and                    *****
 *****                             whose Node will be the first input Text object.                               *****
 *****    The other two Strings will be used as the Nodes in two RotateTransition objects to spin them around    *****
 *****           (NOTE: see chapter 15 exercise 2 or the javafx API for how to use RotateTransition).            *****
 *****             The PathTransition should autoReverse and the two RotateTransitions should not.               *****
 *****                     Have the RotateTransition objects spin a full 360 degrees and                         *****
 *****                             all three objects should animate indefinitely.                                *****
 *****                              Add the three Texts and Polyline to the Pane.                                *****
 *****                                                                                                           *****
 *****                 To create the Polyline, input all of the double/int values into an array.                 *****
 *****                              Set the array’s initial size to 100 elements.                                *****
 *****              If you only fill a portion of the array, the remaining elements will all be 0s.              *****
 *****                       This will cause your Polyline to include <0,0> as a point.                          *****
 *****                To prevent this, once you have finished inputting all values from the user,                *****
 *****            create a second array whose size is num (the number of int/double values input) and            *****
 *****     use a for loop that iterates from 0 to num to copy from the original array into the second array.     *****
 *****                                                                                                           *****
 *****-----------------------------------------------------------------------------------------------------------*****
 *****                               For instance, the code might look like this:                                *****
 *****                                   double[] array2 = new double[num];                                      *****
 *****                                   for(int i=0;i<num;i++) array2[i] = array[i];                            *****
 *****                                                                                                           *****
 *****-----------------------------------------------------------------------------------------------------------*****
 *****                          Use this second, smaller, array to make your Polyline.                           *****
 *****                       In order to ensure that the Strings are not overly long and                         *****
 *****    that the end points of the Polyline are both within the Scene and do not run into the spinning text,   *****
 *****                            you will create and use two Exception classes:                                 *****
 *****                     TextTooLongException (for Strings greater than 12 characters) and                     *****
 *****         IllegalCoordinateException (for points with a coordinate less than 20 or greater than 350).       *****
 *****                                                                                                           *****
 *****   These two Exception classes should have a no-arg and a 1-arg constructor, similar to what you did in    *****
 *****                                              program #1.                                                  *****
 *****    When inputting a String, if it is too long, throw a TextTooLongException with a useful message that    *****
 *****                                indicates why the Exception was thrown.                                    *****
 *****                              When inputting the values for your Polyline,                                 *****
 *****                   use a while loop which continues while the user enters non-0 values.                    *****
 *****                 If an input value is outside of the legal bounds (< 20 but not 0, > 350),                 *****
 *****                                   throw an IllegalCoordinateException.                                    *****
 *****                The input value for an x-coordinate can be 0, which will terminate the loop,               *****
 *****         but if a valid x-coordinate is input and the y-coordinate is 0 (y is not legal but x is),         *****
 *****                                   throw the IllegalCoordinateException.                                   *****
 *****                                                                                                           *****
 *****          Again, make sure you have a useful message as the parameter of your throw statement.             *****
 *****            Place the code to input the three Strings and the doubles inside a try block and               *****
 *****                             explicitly throw the Exceptions as necessary.                                 *****
 *****                             The catch blocks should follow the try block.                                 *****
 *****                 You can add an additional catch for a NumberFormatException if you desire.                *****
 *****                        After successfully inputting all values, create the Polyline,                      *****
 *****      Text objects, PathTransition and RotateTransition objects, add the Polyline and Text objects to      *****
 *****                   the Pane and start the animation for all three Transition objects.                      *****
 *****                      As the inputs and while loop are all inside of one try block,                        *****
 *****              any Exception thrown will cause the program to discontinue further input and                 *****
 *****                             thus nothing will appear in the pop-up window.                                *****
 *****                                                                                                           *****
 *****                                 An example of my output is shown below.                                   *****
 *****                      There are two screen captures so you can see the Strings rotating.                   *****
 *****                                                                                                           *****
 *****___________________________________________________________________________________________________________*****
 *****                                  Program #2 submission instructions:                                      *****
 *****-----------------------------------------------------------------------------------------------------------*****
 *****           Submit all of your source code (the main program and three Exception classes for 2a,            *****
 *****                           the main program and two Exception classes for 2b),                             *****
 *****                the output created running 2a on input files input2.txt and input3.txt, and                *****
 *****           the output of running 2b on whatever input you like that does not throw an Exception.           *****
 *****                   Since these programs generate pop-up windows rather than text output,                   *****
 *****                                use screen captures to obtain each output.                                 *****
 *****               Place all code and output into either a single zip file as or copy all code and             *****
 *****                                 the outputs into a single Word document.                                  *****
 *****                            Email the zip file or Word document to foxr@nku.edu.                           *****
 *********************************************************************************************************************
 *********************************************************************************************************************/

// IMPORTS of needed tools and plug-ins
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.*;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javafx.scene.shape.*;
import javafx.scene.layout.*;


public class Main_A extends Application {

    // CLASS VARIABLE(s) declaration(s)
    // Scanner input1 = null;
    // Scanner input2 = null;
    // Scanner input3 = null;

    public static void main(String[] args) {
        launch(args);
    }


    public void start(Stage primaryStage){

        // Creating the Pane
        Pane pane = new Pane();

        // Create the Scene with the Pane, Set the Title of the Stage, Set the Scene to the Stage, Show the Stage
        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Programming Assignment #2: Ryan Huffman");
        primaryStage.setScene(scene);
        primaryStage.show();

        input(pane);
    }


    public void input(Pane pane){



        // INSTANCE VARIABLE(s) declaration(s)
        Scanner input1 = null;
        Scanner input2 = null;
        Scanner input3 = null;

        // String variables that hold the input file names
        String shapeFile1 = "shapes1.txt";
        String shapeFile2 = "shapes2.txt";
        String shapeFile3 = "shapes3.txt";

        // Shape variable to hold the last Shape
        Shape shape = null;

        // int variables to hold x/y coordinates (beginning and ending), radius, width, height, half width,
            // half height, red (r), green (g) and blue (b) values
        int x = 0;
        int y = 0;
        int endX = 0;
        int endY = 0;
        int radius = 0;
        int width = 0;
        int height = 0;
        int halfWidth = 0;
        int halfHeight = 0;
        int redValue = 0;
        int greenValue = 0;
        int blueValue = 0;

        // String variables to get the String int values to be converted to ints for x/y coordinates, width and height
        String stringValue1 = null;
        String stringValue2 = null;
        String stringValue3 = null;
        String stringValue4 = null;

        // Default Color variable
        Color color = Color.rgb(0,0,0,1.0);

        // try block to try to open the input files
        try{
            // Attempting to open the input files
            input1 = new Scanner(new File(shapeFile1));
            input2 = new Scanner(new File(shapeFile2));
            input3 = new Scanner(new File(shapeFile3));

            // while loop to iterate through the entire file and draw and color all the shapes
            while(input1.hasNext()){
                // String variable to hold the next String in the file and move the file forward one String
                String command = input1.next().trim();

                // try block to attempt to execute the given commands and throw appropriate errors if not
                try{
                    // if block that checks if the command equals "Circle"
                    if(command.equals("Circle")){
                        // String values to be tested if they are digits and turned into int variables to be used with
                            // the Circle object if they pass the tests
                        stringValue1 = input1.next();
                        stringValue2 = input1.next();
                        stringValue3 = input1.next();

                        // if block that checks that all characters for the x-coordinate are digits and
                            // throws a NumberFormatException if not
                        if(allDigits(stringValue1)){
                            x = Integer.parseInt(stringValue1);
                        } else{
                            throw new NumberFormatException("The x-coordinate value of the Circle object is " +
                                    "not a valid digit");
                        }

                        // if block that checks that all characters for the y-coordinate are digits and
                            // throws a NumberFormatException if not
                        if(allDigits(stringValue2)){
                            y = Integer.parseInt(stringValue2);
                        } else{
                            throw new NumberFormatException("The y-coordinate value of the Circle object is " +
                                    "not a valid digit");
                        }

                        // if block that checks that all characters for the radius are digits and
                            // throws a NumberFormatException if not
                        if(allDigits(stringValue3)){
                            radius = Integer.parseInt(stringValue3);
                        } else{
                            throw new NumberFormatException("The radius value of the Circle object is " +
                                    "not a valid digit");
                        }

                        // if block to check that the Circle doesn't go outside the left side of the Scene and
                            // throws an IllegalCoordinateException if so
                        if((x - radius) < 0){
                            throw new IllegalCoordinateException("The x-value of, " + x + ", minus the radius of, " +
                                    radius + ", makes your Circle go outside the left side of the Scene");
                        }
                        // else if block to check that the Circle doesn't go outside the right side of the Scene and
                            // throws an IllegalCoordinateException if so
                        else if(((x + radius) > 500)){
                            throw new IllegalCoordinateException("The x-value of, " + x + ", plus the radius of, " +
                                    radius + ", makes your Circle go outside the right side of the Scene");
                        }
                        // else if block to check that the Circle doesn't go outside the top side of the Scene and
                            // throws an IllegalCoordinateException if so
                        else if((y - radius) < 0){
                            throw new IllegalCoordinateException("The y-value of, " + y + ", minus the radius of, " +
                                    radius + ", makes your Circle go outside the top of the Scene");
                        }
                        // else if block to check that the Circle doesn't go outside the bottom side of the Scene and
                            // throws an IllegalCoordinateException if so
                        else if(((y + radius) > 500)){
                            throw new IllegalCoordinateException("The y-value of, " + y + ", plus the radius of, " +
                                    radius + ", makes your Circle go outside the bottom of the Scene");
                        }
                        // else block that executes if the Circle's x/y coordinates are legal and
                            // creates a new Circle if so
                        else{
                            shape = new Circle(x, y, radius);
                            shape.setFill(color);
                            pane.getChildren().add(shape);
                        }
                    }

                    // else if block that command equals "Rectangle"
                    else if(command.equals("Rectangle")){
                        // String values to be tested if they are digits and turned into int variables to be used with
                            // the Rectangle object if they pass the tests
                        stringValue1 = input1.next();
                        stringValue2 = input1.next();
                        stringValue3 = input1.next();
                        stringValue4 = input1.next();

                        // if block that checks that all characters for the x-coordinate are digits and
                            // throws a NumberFormatException if not
                        if(allDigits(stringValue1)){
                            x = Integer.parseInt(stringValue1);
                        } else{
                            throw new NumberFormatException("The x-coordinate value of the Rectangle object is " +
                                    "not a valid digit");
                        }

                        // if block that checks that all characters for the y-coordinate are digits and
                            // throws a NumberFormatException if not
                        if(allDigits(stringValue2)){
                            y = Integer.parseInt(stringValue2);
                        } else{
                            throw new NumberFormatException("The y-coordinate value of the Rectangle object is " +
                                    "not a valid digit");
                        }

                        // if block that checks that all characters for the width are digits and
                            // throws a NumberFormatException if not
                        if(allDigits(stringValue3)){
                            width = Integer.parseInt(stringValue3);
                        } else{
                            throw new NumberFormatException("The width value of the Rectangle object is " +
                                    "not a valid digit");
                        }

                        // if block that checks that all characters for the height are digits and
                            // throws a NumberFormatException if not
                        if(allDigits(stringValue4)){
                            height = Integer.parseInt(stringValue4);
                        } else{
                            throw new NumberFormatException("The height value of the Rectangle object is " +
                                    "not a valid digit");
                        }

                        // if block to check that the Rectangle doesn't go outside the left side of the Scene and
                            // throws an IllegalCoordinateException if so
                        if((x - width) < 0){
                            throw new IllegalCoordinateException("The x-value of, " + x + ", minus the width of, " +
                                    width + ", makes your Rectangle go outside the left side of the Scene");
                        }
                        // else if block to check that the Rectangle doesn't go outside the right side of the Scene and
                            // throws an IllegalCoordinateException if so
                        else if((x + width) > 500){
                            throw new IllegalCoordinateException("The x-value of, " + x + ", plus the width of, " +
                                    width + ", makes your Rectangle go outside the right side of the Scene");
                        }
                        // else if block to check that the Rectangle doesn't go outside the top side of the Scene and
                            // throws an IllegalCoordinateException if so
                        else if((y - height) < 0){
                            throw new IllegalCoordinateException("The y-value of, " + y + ", minus the height of, " +
                                    height + ", makes your Rectangle go outside the top side of the Scene");
                        }
                        // else if block to check that the Rectangle doesn't go outside the bottom side of the Scene and
                            // throws an IllegalCoordinateException if so
                        else if((y + height) > 500){
                            throw new IllegalCoordinateException("The y-value of, " + y + ", plus the height of, " +
                                    height + ", makes your Rectangle go outside the bottom side of the Scene");
                        }
                        // else block that executes if the Rectangle's x/y coordinates are legal and
                            // creates a new Rectangle if so
                        else{
                            shape = new Rectangle(x, y, width, height);
                            shape.setFill(color);
                            pane.getChildren().add(shape);
                        }
                    }

                    // else if block that command equals "Ellipse"
                    else if(command.equals("Ellipse")){
                        // String values to be tested if they are digits and turned into int variables to be used with
                            // the Ellipse object if they pass the tests
                        stringValue1 = input1.next();
                        stringValue2 = input1.next();
                        stringValue3 = input1.next();
                        stringValue4 = input1.next();

                        // if block that checks that all characters for the x-coordinate are digits and
                            // throws a NumberFormatException if not
                        if(allDigits(stringValue1)){
                            x = Integer.parseInt(stringValue1);
                        } else{
                            throw new NumberFormatException("The x-coordinate value of the Ellipse object is " +
                                    "not a valid digit");
                        }

                        // if block that checks that all characters for the y-coordinate are digits and
                            // throws a NumberFormatException if not
                        if(allDigits(stringValue2)){
                            y = Integer.parseInt(stringValue2);
                        } else{
                            throw new NumberFormatException("The y-coordinate value of the Ellipse object is " +
                                    "not a valid digit");
                        }

                        // if block that checks that all characters for the halfWidth are digits and
                            // throws a NumberFormatException if not
                        if(allDigits(stringValue3)){
                            halfWidth = Integer.parseInt(stringValue3);
                        } else{
                            throw new NumberFormatException("The halfWidth value of the Ellipse object is " +
                                    "not a valid digit");
                        }

                        // if block that checks that all characters for the halfHeight are digits and
                            // throws a NumberFormatException if not
                        if(allDigits(stringValue4)){
                            halfHeight = Integer.parseInt(stringValue4);
                        } else{
                            throw new NumberFormatException("The halfHeight value of the Ellipse object is " +
                                    "not a valid digit");
                        }

                        // if block to check that the Ellipse doesn't go outside the left side of the Scene and
                            // throws an IllegalCoordinateException if so
                        if((x - halfWidth) < 0){
                            throw new IllegalCoordinateException("The x-value of, " + x + ", minus the half width " +
                                    "of, " + halfWidth + ", makes your Ellipse go outside the left side of the Scene");
                        }
                        // else if block to check that the Ellipse doesn't go outside the right side of the Scene and
                            // throws an IllegalCoordinateException if so
                        else if((x + halfWidth) > 500){
                            throw new IllegalCoordinateException("The x-value of, " + x + ", plus the half width " +
                                    "of, " +  halfWidth + ", makes your Ellipse go outside the right side of " +
                                    "the Scene");
                        }
                        // else if block to check that the Ellipse doesn't go outside the top side of the Scene and
                            // throws an IllegalCoordinateException if so
                        else if((y - halfHeight) < 0){
                            throw new IllegalCoordinateException("The y-value of, " + y + ", minus the half height of" +
                                    ", " + halfHeight + ", makes your Ellipse go outside the top side of the Scene");
                        }
                        // else if block to check that the Ellipse doesn't go outside the bottom side of the Scene and
                            // throws an IllegalCoordinateException if so
                        else if((y + halfHeight) > 500){
                            throw new IllegalCoordinateException("The y-value of, " + y + ", plus the half height of" +
                                    ", " +  halfHeight + ", makes your Ellipse go outside the bottom side of " +
                                    "the Scene");
                        }
                        // else block that executes if the Ellipse's x/y coordinates are legal and
                            // creates a new Ellipse if so
                        else{
                            shape = new Ellipse(x, y, halfWidth, halfHeight);
                            shape.setFill(color);
                            pane.getChildren().add(shape);
                        }
                    }

                    // else if block that command equals "Line"
                    else if(command.equals("Line")){
                        // String values to be tested if they are digits and turned into int variables to be used with
                            // the Line object if they pass the tests
                        stringValue1 = input1.next();
                        stringValue2 = input1.next();
                        stringValue3 = input1.next();
                        stringValue4 = input1.next();

                        // if block that checks that all characters for the starting x-coordinate are digits and
                            // throws a NumberFormatException if not
                        if(allDigits(stringValue1)){
                            x = Integer.parseInt(stringValue1);
                        } else{
                            throw new NumberFormatException("The starting x-coordinate value of the Line object is " +
                                    "not a valid digit");
                        }

                        // if block that checks that all characters for the starting y-coordinate are digits and
                            // throws a NumberFormatException if not
                        if(allDigits(stringValue2)){
                            y = Integer.parseInt(stringValue2);
                        } else{
                            throw new NumberFormatException("The starting y-coordinate value of the Line object is " +
                                    "not a valid digit");
                        }

                        // if block that checks that all characters for the ending x-coordinate are digits and
                            // throws a NumberFormatException if not
                        if(allDigits(stringValue3)){
                            endX = Integer.parseInt(stringValue3);
                        } else{
                            throw new NumberFormatException("The ending x-coordinate value of the Ellipse object is " +
                                    "not a valid digit");
                        }

                        // if block that checks that all characters for the ending y-coordinate are digits and
                            // throws a NumberFormatException if not
                        if(allDigits(stringValue4)){
                            endY = Integer.parseInt(stringValue4);
                        } else{
                            throw new NumberFormatException("The ending y-coordinate value of the Ellipse object is " +
                                    "not a valid digit");
                        }

                        // if block to check that the Line doesn't start outside the left side of the Scene and
                            // throws an IllegalCoordinateException if so
                        if(x < 0){
                            throw new IllegalCoordinateException("The x-value of, " + x + ", is less than 0. Which " +
                                    "makes your Line start outside the left side of the Scene");
                        }
                        // else if block to check that the Line doesn't start outside the right side of the Scene and
                            // throws an IllegalCoordinateException if so
                        else if(x > 500){
                            throw new IllegalCoordinateException("The x-value of, " + x + ", is greater than 500. " +
                                    "Which makes your Line start outside the right side of the Scene");
                        }
                        // else if block to check that the Line doesn't start outside the top side of the Scene and
                            // throws an IllegalCoordinateException if so
                        else if(y < 0){
                            throw new IllegalCoordinateException("The y-value of, " + y + ", is less than 0. Which " +
                                    "makes your Line start outside the top side of the Scene");
                        }
                        // else if block to check that the Line doesn't start outside the bottom side of the Scene and
                            // throws an IllegalCoordinateException if so
                        else if(y > 500){
                            throw new IllegalCoordinateException("The y-value of, " + y + ", is greater than 500. " +
                                    "Which makes your Line start outside the bottom side of the Scene");
                        }
                        // else if block to check that the Line doesn't end outside the left side of the Scene and
                            // throws an IllegalCoordinateException if so
                        else if(endX < 0){
                            throw new IllegalCoordinateException("The x-value of, " + endX + ", is less than 0. " +
                                    "Which makes your Line end outside the left side of the Scene");
                        }
                        // else if block to check that the Line doesn't end outside the right side of the Scene and
                            // throws an IllegalCoordinateException if so
                        else if(endX > 500){
                            throw new IllegalCoordinateException("The x-value of, " + endX + ", is greater than 500. " +
                                    "Which makes your Line end outside the right side of the Scene");
                        }
                        // else if block to check that the Line doesn't end outside the top side of the Scene and
                            // throws an IllegalCoordinateException if so
                        else if(endY < 0){
                            throw new IllegalCoordinateException("The y-value of, " + endY + ", is less than 0. " +
                                    "Which makes your Line end outside the top side of the Scene");
                        }
                        // else if block to check that the Line doesn't end outside the bottom side of the Scene and
                            // throws an IllegalCoordinateException if so
                        else if(endY > 500){
                            throw new IllegalCoordinateException("The y-value of, " + endY + ", is greater than 500. " +
                                    "Which makes your Line end outside the bottom side of the Scene");
                        }
                        // else block that executes if the Line's x/y coordinates are legal and
                            // creates a new Line if so
                        else{
                            shape = new Line(x, y, endX, endY);
                            shape.setStroke(color);
                            pane.getChildren().add(shape);
                        }
                    }

                    // else if block that command equals "Color"
                    else if(command.equals("Color")){
                        // String values to be tested if they are digits and turned into int variables to be used with
                            // the Color values if they pass the tests
                        stringValue1 = input1.next();
                        stringValue2 = input1.next();
                        stringValue3 = input1.next();

                        // if block that checks that all characters for the red color value are digits and
                            // throws a NumberFormatException if not
                        if(allDigits(stringValue1)){
                            redValue = Integer.parseInt(stringValue1);
                        } else{
                            throw new NumberFormatException("The red color value of the rgb Color value is " +
                                    "not a valid digit");
                        }

                        // if block that checks that all characters for the green color value are digits and
                            // throws a NumberFormatException if not
                        if(allDigits(stringValue2)){
                            greenValue = Integer.parseInt(stringValue2);
                        } else{
                            throw new NumberFormatException("The green color value of the rgb Color value is " +
                                    "not a valid digit");
                        }

                        // if block that checks that all characters for the blue color value are digits and
                            // throws a NumberFormatException if not
                        if(allDigits(stringValue3)){
                            blueValue = Integer.parseInt(stringValue3);
                        } else{
                            throw new NumberFormatException("The blue value of the rgb Color value is " +
                                    "not a valid digit");
                        }

                        // if block to check that the red Color value is not less than 0 and
                            // throws an IllegalColorException if so
                        if(redValue < 0){
                            throw new IllegalColorException("The red Color value of, " + redValue + ", is " +
                                    "less than 0. Which is not a valid rgb Color value between 0 and 255");
                        }
                        // else if block to check that the red Color value is not greater than 255 and
                            // throws an IllegalColorException if so
                        else if(redValue > 255){
                            throw new IllegalColorException("The red Color value of, " + redValue + ", is " +
                                    "greater than 255. Which is not a valid rgb Color value between 0 and 255");
                        }
                        // else if block to check that the green Color value is not less than 0 and
                            // throws an IllegalColorException if so
                        else if(greenValue < 0){
                            throw new IllegalColorException("The green Color value of, " + greenValue + ", is " +
                                    "less than 0. Which is not a valid rgb Color value between 0 and 255");
                        }
                        // else if block to check that the green Color value is not greater than 255 and
                            // throws an IllegalColorException if so
                        else if(greenValue > 255){
                            throw new IllegalColorException("The green Color value of, " + greenValue + ", is " +
                                    "greater than 255. Which is not a valid rgb Color value between 0 and 255");
                        }
                        // else if block to check that the blue Color value is not less than 0 and
                            // throws an IllegalColorException if so
                        else if(blueValue < 0){
                            throw new IllegalColorException("The blue Color value of, " + blueValue + ", is " +
                                    "less than 0. Which is not a valid rgb Color value between 0 and 255");
                        }
                        // else if block to check that the blue Color value is not greater than 255 and
                            // throws an IllegalColorException if so
                        else if(blueValue > 255){
                            throw new IllegalColorException("The blue Color value of, " + blueValue + ", is " +
                                    "greater than 255. Which is not a valid rgb Color value between 0 and 255");
                        }
                        // else block that sets the rgb Color value of the Color variable "color" after all the
                            // rgb Color are checked to be valid
                        else{
                            color = Color.rgb(redValue, greenValue, blueValue, 1.0);
                        }
                    }

                    // else block that throws an IllegalShapeException is a legal "command" was not given
                    else{
                        throw new IllegalShapeException("\"" + command + "\" is not a legal command");
                    }
                }
                catch(IllegalColorException colExc){
                    System.out.println(colExc);
                }
                catch(IllegalCoordinateException corExc){
                    System.out.println(corExc);
                }
                catch(IllegalShapeException shpExc){
                    System.out.println(shpExc);
                }
                catch(NumberFormatException numExc){
                    System.out.println(numExc);
                }
            }
        }
        catch(IOException ioE){
            System.out.println(ioE);
        }
        finally{
            if(input1 != null){
                input1.close();
            }
            if(input2 != null){
                input2.close();
            }
            if(input3 != null){
                input3.close();
            }
        }
    }


    // boolean method to return whether a String is made up entirely of integers.
    private static boolean allDigits(String str){

        // boolean variable to find out if the passed in string contains only integers.
        boolean allDigits = true;

        // for loop to test that all the characters that should be digits, are digits
        for(int i = 0; i < str.length(); i++){
            if(!Character.isDigit(str.charAt(i))){
                allDigits = false;
            }
        }

        // returns true or false on whether all the digits that should have been digits were digits
        return allDigits;
    }
}
