package train.collection;

public class Inheritance {

    static class A{
        A(){
            fun();
        }

        void fun(){
            System.out.println("A");
        }
    }

    static class B extends A{
        B(){
            fun();
        }

        @Override
        void fun() {
            System.out.println("B");
        }
    }

    public static void main(String[] args) {
        A a = new B();
    }
}
