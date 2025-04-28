package org.example;
interface Demo{
    public void hello();
}
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Demo demo = () -> System.out.println("hello world");
    demo.hello();
    }
}
