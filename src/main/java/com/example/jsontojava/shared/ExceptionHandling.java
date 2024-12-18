package com.example.jsontojava.shared;

class MyException extends Exception{
    public MyException(String i){
        super(i);
    }
}

public class ExceptionHandling {
    public static void main(String[] args) {
        try{
            throw new MyException("2");
        }
        catch (MyException e){
            System.out.println("Caught");
            System.out.println(e.getMessage());
        }
    }
}
