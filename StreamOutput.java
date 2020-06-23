package com.company;

import java.io.IOException;
import java.io.Writer;

public class StreamOutput implements Output {
    public StreamOutput(Writer stream) {
        sink = stream;
    }
    private Writer sink;
    public void write(Object o) {
        writeString(o.toString());
    }
    public void writeString(String s) {
        try {
            sink.write(s);
        }
        catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
