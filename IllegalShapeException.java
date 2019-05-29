/*********************************************************************************************************************
 *********************************************************************************************************************
 *****  Class: CSC-360-001-2019-040    Semester: Summer 2019    Professor: Richard Fox    Student: Ryan Huffman  *****
 *****-----------------------------------------------------------------------------------------------------------*****
 *****                                       Programming Assignment #2                                           *****
 *****                                               Part 1                                                      *****
 *****                                   Exception : IllegalShapeException                                       *****
 *****___________________________________________________________________________________________________________*****
 *****                          The IllegalShapeException will require two constructors,                         *****
 *****                  a no-arg constructor which will simply do super(“some useful message”);                  *****
 *****             such as: “command is not one of the four valid Shape names or the word “Color””;              *****
 *****                                                                                                           *****
 *****                      A 1-arg constructor which will pass on the message it receives.                      *****
 *****   The IllegalShapeException arises if the command inputted is not one of the four valid Shape names or    *****
 *****                                            the word “Color”                                               *****
 *********************************************************************************************************************
 *********************************************************************************************************************/

// Exception class that extends Exception used to handle if a command is not one of the four valid Shape names
    // or the word “Color”
public class IllegalShapeException extends Exception {


    // No-arg constructor for IllegalShapeException used to provide a default IllegalShapeException message
        // to the parent Exception class
    public IllegalShapeException(){
        super("command is not one of the four valid Shape names or the word \"Color\"");
    }


    // 1-arg constructor for IllegalShapeException used to send a passed in String parameter message to the
        // to the parent Exception class
    public IllegalShapeException(String message){
        super(message);
    }
}
