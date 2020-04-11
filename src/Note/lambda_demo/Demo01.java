package Note.lambda_demo;

@FunctionalInterface
public interface Demo01 {
    void test();

    default void defMethod() {
        System.out.println("default function");
    }

    static void staticMethod() {
        System.out.println("static function");
    }

    @Override
    boolean equals(Object object);
}
