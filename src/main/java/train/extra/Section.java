package train.extra;

import java.util.ArrayList;
import java.util.List;

public class Section {

    public static void main(String[] args) {
        Boolean h = null;
        System.out.println(h);
        Child[] parents = new Child[6];
        for (Parent pa :
                parents) {
            pa = new Child();
            pa.to();
        }

        List<Parent> parents1 = new ArrayList<>();
        parents1.add(new Child());
    }

    static class Parent{
        public void to(){
            System.out.println("Parent");
        }
    }

    static class Child extends Parent{
        @Override
        public void to() {
            System.out.println("Child");
        }
    }
}
