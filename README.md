# Decorators---Java
Java program with a number of classes that decorate a simple, generic stream output class.
When the program runs, it prompts the user for a file to read, and then presents a menu of decorations to apply and produces the decorated output.

LineOutput: adds a newline with every write.

NumberedOutput: this adds newlines, and precedes each write with the current line number (1-based) right-justified in a field of width 5, followed by a colon and a space.

TeeOutput: write to two streams at a time; the one it wraps, plus one it receives as a constructor argument.

FilterOutput: writes only objects that satisfy a certain condition (unary predicate), received as a constructor parameter. (Gives user a choice of two predicates).

The decorated class is StreamOutput and the file used to test the decorators is decorator.dat.
