package com.company;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class FilterOutput implements Output, Predicate {
    public void write(Object o) {
        writeString(o.toString());
    }
    public boolean execute(Object o){return false;};
    public void writeString(String s){
        try {
            // this function will write the filtered output out
            Writer writer = new PrintWriter(System.out);
           writer.write(s);
           writer.flush();
            ((PrintWriter)writer).println("\r\n");
            writer.flush();
        }
        catch(IOException ex) {
            throw new RuntimeException(ex);
        }

    }
    public void containsCharD(String t)
    {
            FilterOutput filter = new FilterOutput();
            String[] theArray = t.split(" ,");
            for(int i = 0; i < theArray.length; i++)
            {
                if (theArray[i].contains("D"))
                {
                    filter.writeString(theArray[i]);
                }
            }
    }
    public void endsWithTer(String c)
    {
        FilterOutput filters = new FilterOutput();
        String[] theArray = c.split(" ,");
        for(int i = 0; i < theArray.length; i++)
        {
            if (theArray[i].endsWith("ter"))
            {
                filters.writeString(theArray[i]);
            }
        }
    }
}
