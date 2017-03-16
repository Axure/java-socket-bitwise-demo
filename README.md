# Java Socket and Bitwise Operation Demo

* Warning, this project is an IntelliJ IDEA project, and have to be opened with the IDE *

## Run

Run the `Server` class to start the server, and run the `Client` class to run the client.

## Results

You shouldn't use raw bitwise operation when trying to read WORDs from the socket (or any binary stream).

It seems that the `byte`s are first converted to `int` and then shifted, hence you can observe that `a << 8 + b` becomes `ffffff00` when `a == 0xff, b == 0xff`.

But the same thing will not happen for literals, e.g. `0xff << 8 + 0xff`, because the literals are themselves int (according to the ["Java Language Specification"](http://docs.oracle.com/javase/specs/jls/se7/html/jls-3.html#jls-3.10.1).

