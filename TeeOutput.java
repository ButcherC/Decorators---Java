package com.company;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;

public class TeeOutput implements Output {
    public void write(Object o) {
        writeString(o.toString());
}

    public void writeString(String s){
        try {
            Writer writer = new PrintWriter(System.out);
            String[] myArray = s.split(",");
            for(int i = 0; i < myArray.length; i++)
            {

                writer.write(myArray[i]);
                writer.flush();
            }
        }
        catch(IOException ex) {
            throw new RuntimeException(ex);
        }

    }
    public void writeStringTwo(String t)
    {
        try{
            Writer writer = new PrintWriter(System.out);
            String[] theArray = t.split(" ,");
            for(int i = 0; i < theArray.length; i++)
            {
                writer.write(theArray[i]);
                //writer.write(myArray[i]);
                writer.flush();
            }
        }
        catch(IOException ex){
            throw new RuntimeException(ex);
        }
    }
}
