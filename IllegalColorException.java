/*********************************************************************************************************************
 *********************************************************************************************************************
 *****  Class: CSC-360-001-2019-040    Semester: Summer 2019    Professor: Richard Fox    Student: Ryan Huffman  *****
 *****-----------------------------------------------------------------------------------------------------------*****
 *****                                       Programming Assignment #2                                           *****
 *****                                               Part 1                                                      *****
 *****                                    Exception : IllegalColorException                                      *****
 *****___________________________________________________________________________________________________________*****
 *****                         The IllegalColorException will require two constructors,                          *****
 *****                  a no-arg constructor which will simply do super(“some useful message”);                  *****
 *****                              such as “Bad Color value(s) specified”;                                      *****
 *****                                                                                                           *****
 *****                      A 1-arg constructor which will pass on the message it receives.                      *****
 *****   The IllegalColorException arises if one of the int values for the RGB value is not between 0 and 255.   *****
 *********************************************************************************************************************
 *********************************************************************************************************************/

// Exception class that extends Exception, used to handle when someone or a file inputs an invalid rgb value
    // (not between 0 and 255)
public class IllegalColorException extends Exception {


    // No-arg constructor for IllegalColorException used to provide a default IllegalColorException message
        // to the parent Exception class
    public IllegalColorException(){
        super("Bad Color value(s) specified");
    }


    // 1-arg constructor for IllegalColorException used to send a passed in String parameter message to the
        // to the parent Exception class
    public IllegalColorException(String message){
        super(message);
    }
}
