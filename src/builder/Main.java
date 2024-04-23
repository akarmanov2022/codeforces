package builder;

/**
 * @author Arseniy Karmanov
 */
public class Main {
    public static void main(String[] args) {
        Foo1 foo1 = new Foo1.Foo1Builder("1")
                .field2("1")
                .field3("3")
                .bar1("454")
                .bar2("343")
                .build();
        System.out.println("foo1 = " + foo1);
    }
}
