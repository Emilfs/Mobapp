package com.example.test.ui.main;

public class NativeConnection {

    static {
        System.loadLibrary("math-operation");
    }
    public native int div(int a, int b);

}
