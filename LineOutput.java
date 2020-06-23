package com.company;
import java.io.*;

public class LineOutput implements Output  {
 //private Writer sink;
 //LineOutput lineOutput = new LineOutput();
    public void write(Object o) {
        writeString(o.toString());
    }

    public void writeString(String s) {
        try {
            int count = 0;
            //myArray = new String[100];
            Writer writer = new PrintWriter(System.out);

            //((PrintWriter)writer).println(i);
            String[] myArray = s.split(",");
            for (int i = 0; i < myArray.length; i++) {
                writer.write(myArray[i]);
                writer.flush();
                ((PrintWriter) writer).println("\r\n");
                writer.flush();
            }
                    /*writer.write(s);

                    writer.flush();
                   ((PrintWriter)writer).println("\r\n");
                    writer.flush();*/


            //writer.write(s);
            //((PrintWriter) writer).println("\n");
            //writer.flush();

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
