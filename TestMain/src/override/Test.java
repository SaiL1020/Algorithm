package override;

public class Test {
    public static void main(String[] args) {
        String str = "";
        Caller caller = new SubCaller();
        caller.call(str);
    }

    static class Caller {
        public void call(String str) {
            System.out.println("a String instance in Caller");
        }
    }

    static class SubCaller extends Caller {
        @Override
        public void call(String str) {
            System.out.println("a String instance in SubCaller");
        }
    }
}