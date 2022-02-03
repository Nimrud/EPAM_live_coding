package pl.jaczewski.livecoding.testNG;

import java.util.List;

/**
 * @author Jovhar Isayev
 * @author DM
 * @author Krzysztof Jaczewski
 */
class House implements Visitable{
    private final Foundation foundation;
    private final List<Floor> floors;
    private final Roof roof;

    public House(Foundation foundation, List<Floor> floors, Roof roof) {
        this.foundation = foundation;
        this.floors = floors;
        this.roof = roof;
    }

    public void accept(HouseVisitor visitor) {
        visitor.visit(this);
        visitor.visit(foundation);
        for (Floor floor : floors) {
            visitor.visit(floor);
        }
        visitor.visit(roof);
    }

    public static class Builder {
        // methods to make Foundation, floors etc.
    }

}