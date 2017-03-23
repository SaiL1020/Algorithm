package hashcode;

/**
 * @author      SaiL1020
 * time:        3/23/17 12:59 AM
 * project:     Algorithm
 */
public class Test extends B {
    private class AnotherClass {

    }

    private class ThirdClass {

    }

    public void run() {
        Object o = new Object(), o2 = new Object();
        System.out.println(o.hashCode() + " " + o2.hashCode());
        System.out.println(System.identityHashCode(o) + " " + System.identityHashCode(o2));
        System.out.println(getValue());
    }

    public static void main(String[] args) {
        new Test().run();
    }
}
