package pl.jaczewski.live_coding.testNG;

public interface HouseVisitor {
    void visit(Visitable visitable);

    default void visit(House house){
        visit((Visitable) house);
    };

    default void visit(Foundation foundation){
        visit((Visitable) foundation);
    };

    default void visit(Floor floor){
        visit((Visitable) floor);
    };

    default void visit(Roof roof){
        visit((Visitable) roof);
    };
}