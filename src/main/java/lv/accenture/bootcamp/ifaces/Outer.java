package lv.accenture.bootcamp.ifaces;

public class Outer {

    public void outerFunction() {
        System.out.println("Outer...");
    }

    public static class StaticInner {
        public void innerStaticFunction() {
            System.out.println("Inner static...");
        }

        public static void innerVeryStaticFunction() {
            System.out.println("Inner very static...");
        }
    }

    public class Inner {

        public void innerFunction() {
            System.out.println("Inner...");
        }

        public class VeryInner {

            public void veryInnerFunction() {
                System.out.println("Very inner...");
            }

        }

    }

}
