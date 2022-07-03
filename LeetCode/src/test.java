public class test {
    public static void main(String[] args) {
//        String zText = "";
//        fillString(zText);
//        System.out.println(zText);

        A a1 = new A(1);
        A a2 = new A(2);
        run(a1, a2);
        System.out.println("a1 = " + a1.value);
        System.out.println("a2 = " + a2.value);

    }

    static void fillString(String zText) {
        zText += "foo";
    }

    static class A {
        public int value;

        A(int i) {
            this.value = i;
        }
    }

    static void run(A arg1, A arg2) {
        arg1.value = 111;
        arg2 = arg1;
    }
}
