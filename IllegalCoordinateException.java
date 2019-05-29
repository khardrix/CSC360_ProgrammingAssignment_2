/*********************************************************************************************************************
 *********************************************************************************************************************
 *****  Class: CSC-360-001-2019-040    Semester: Summer 2019    Professor: Richard Fox    Student: Ryan Huffman  *****
 *****-----------------------------------------------------------------------------------------------------------*****
 *****                                       Programming Assignment #2                                           *****
 *****                                               Part 1                                                      *****
 *****                                 Exception : IllegalCoordinateException                                    *****
 *****___________________________________________________________________________________________________________*****
 *****                       The IllegalCoordinateException will require two constructors,                       *****
 *****                  a no-arg constructor which will simply do super(“some useful message”);                  *****
 *****                   such as: “x-value and/or y-value lies outside of the 500x500 Scene”;                    *****
 *****                                                                                                           *****
 *****                      A 1-arg constructor which will pass on the message it receives.                      *****
 *****          The IllegalCoordinateException arises if a numeric value causes the Shape being drawn            *****
 *****                                    to go outside of the 500x500 Scene                                     *****
 *********************************************************************************************************************
 *********************************************************************************************************************/

// Exception class that extends Exception, used to handle when someone or a file provides an x-value or y-value
    // that causes the Shape being drawn to go outside the 500x500 Scene.
public class IllegalCoordinateException extends Exception {


    // No-arg constructor for IllegalCoordinateException used to provide a default IllegalCoordinateException message
        // to the parent Exception class
    public IllegalCoordinateException(){
        super("x-value and/or y-value lies outside of the 500x500 Scene");
    }


    // 1-arg constructor for IllegalCoordinateException used to send a passed in String parameter message to the
        // to the parent Exception class
    public IllegalCoordinateException(String message){
        super(message);
    }
}
