package kr.co.fastcampus.cli;

public class A {
    private B b;
    A(B b){
        this.b =b;
    }
    public void print(){
        System.out.println(b.calc());
    }
}
