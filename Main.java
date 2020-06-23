package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        // first we want to read the text file line by line
        try {
            // create references to Decorator classes
            LineOutput lineObject = new LineOutput();
            NumberedOutput numObject = new NumberedOutput();
            TeeOutput teeObject = new TeeOutput();
            FilterOutput filterObject = new FilterOutput();
            String requestedFileName;
            String requestDecorator = "";
            // get file name from user
            System.out.println("Please enter a file to read.");
            BufferedReader myReader = new BufferedReader(new InputStreamReader((System.in)));
            requestedFileName = myReader.readLine();
            List<String> lines = Files.readAllLines(Paths.get(requestedFileName));
            // now we need to present decoration options to the user
            System.out.println("Please choose what decorators you would like to apply to the file.\n");
            System.out.println("Please enter input as: LineOutput, NumberedOutput, TeeOutput, FilterOutput.");
            System.out.println("Apply by hitting enter. Input 'n' once to exit the decorator menu and 'n' again to finish.");
            BufferedReader myInput = new BufferedReader(new InputStreamReader((System.in)));
            // get requested decorators
            while(!"n".equals(requestDecorator)) {
                requestDecorator = myInput.readLine();

                if ((requestDecorator.contains("LineOutput"))) {
                    lineObject.write(lines);
                }
                else if(requestDecorator.contains("NumberedOutput"))
                {
                    numObject.write(lines);
                }
                else if(requestDecorator.contains("TeeOutput"))
                {
                    System.out.println("Please enter a second file name to read.");
                    String secondFile = myReader.readLine();
                    List<String> otherLines = Files.readAllLines((Paths.get(secondFile)));
                    teeObject.write(lines);
                    teeObject.writeStringTwo(otherLines.toString());
                }
                else if(requestDecorator.contains("FilterOutput"))
                {
                    System.out.println("Please enter whether you would like to find strings that contain a 'D' by entering 'd'.\n");
                    System.out.println("Or you would like to find strings that end with 'ter' by entering 't'.\n");
                    String filterChoice = myReader.readLine();
                    if(filterChoice.equals("d"))
                    {
                        filterObject.containsCharD(lines.toString());
                    }
                    else if(filterChoice.equals("t"))
                    {
                        filterObject.endsWithTer(lines.toString());
                    }
                    else
                    {
                        System.out.println("Invalid input, please enter the decorator name and start again.");
                        filterChoice = myReader.readLine();
                    }
                }
                else
                {
                    System.out.println("Your input is invalid, please enter the decorator name and try again.");
                    requestDecorator = myReader.readLine();
                }
            }// end while loop
           
            filterObject.endsWithTer(lines.toString());




        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
