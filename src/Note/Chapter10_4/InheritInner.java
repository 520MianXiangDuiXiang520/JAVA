package Note.Chapter10_4;

class WithInner{
    class Inner {

    }
}

public class InheritInner extends WithInner.Inner{
    InheritInner(WithInner s) {
        s.super();
    }
}
