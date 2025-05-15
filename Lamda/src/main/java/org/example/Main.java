package org.example;
class Demo{
    private static int hello=12;



    public void setHello(int hello) {
        this.hello = hello;
    }
    public void getHello() {
        System.out.println(this.hello);
    }

}
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
      new Demo().getHello();
      new Demo().setHello(56);
      new Demo().getHello();

    }
}
