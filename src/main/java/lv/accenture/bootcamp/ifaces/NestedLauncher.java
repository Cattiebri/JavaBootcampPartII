package lv.accenture.bootcamp.ifaces;

public class NestedLauncher {

    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.outerFunction();

        Outer.Inner inner = outer.new Inner();
        inner.innerFunction();

        Outer.Inner.VeryInner veryInner = inner.new VeryInner();
        veryInner.veryInnerFunction();

        Outer.StaticInner staticInner = new Outer.StaticInner();
        staticInner.innerStaticFunction();

        Outer.StaticInner.innerVeryStaticFunction();
    }

}
