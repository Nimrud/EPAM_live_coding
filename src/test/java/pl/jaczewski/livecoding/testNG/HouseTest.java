package pl.jaczewski.livecoding.testNG;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

/**
 * @author Jovhar Isayev
 * @author Krzysztof Jaczewski
 */
@Test
public class HouseTest {
//    public void testHouseCreation() {
//        // given
//        // when
//        House house = new House(new Foundation(),List.of(new Floor()),new Roof());
//        House house2 = new House(house.getFoundation(),List.of(new Floor()),new Roof());
//        // then
//        SoftAssert softAssert = new SoftAssert();
//
//        softAssert.assertNotNull(house.getFoundation());
//        softAssert.assertFalse(house.getFloors().isEmpty());
//        softAssert.assertNotNull(house.getRoof());
//        softAssert.assertAll();
//    }

    @Test
    public void testHouseVisiting() {
        //given
        House house = new House(new Foundation(), List.of(new Floor()), new Roof());
        //when
        BuildingInspector visitor = new BuildingInspector();

        house.accept(visitor);
        SoftAssert softAssert = new SoftAssert();
        //then
        softAssert.assertTrue(visitor.houseLooksGood);
        softAssert.assertTrue(visitor.hasFloor);
        softAssert.assertTrue(visitor.hasFoundation);
        softAssert.assertTrue(visitor.hasRoof);
        softAssert.assertAll();

    }

    public void lazyHouseVisiting() {
        // given
        final House house = new House(new Foundation(), List.of(new Floor()), new Roof());

        // when
        final LazyBuildingInspector lazyBuildingInspector = new LazyBuildingInspector();
        house.accept(lazyBuildingInspector);
        // then
        Assert.assertTrue(counter >= 4);
    }

    public void lazyHouseVisiting2() {
        // given
        final House house = new House(new Foundation(), List.of(new Floor()), new Roof());

        // when

        // local class:
//        class LazyHouseVisitor1 implements HouseVisitor {
//            boolean isNew = true;
//            @Override
//            public void visit(Visitable visitable) {
//                counter++;
//            }
//        };
//        final LazyHouseVisitor1 lazyHouseVisitor1 = new LazyHouseVisitor1();
//        System.out.println("lazyHouseVisitor1.isNew = " + lazyHouseVisitor1.isNew);

        // anonymous class:
        var lazyBuildingInspector = new HouseVisitor() {
            int localCounter;
            @Override
            public void visit(Visitable visitable) {
                localCounter++;
            }
        };
        house.accept(lazyBuildingInspector);
        // then
        Assert.assertTrue(lazyBuildingInspector.localCounter >= 4);
    }

    private int counter;

    private class LazyBuildingInspector implements HouseVisitor {

        @Override
        public void visit(Visitable visitable) {
            counter++;
        }


    }

    static class BuildingInspector implements HouseVisitor {

        private boolean houseLooksGood;
        private boolean hasFoundation;
        private boolean hasFloor;
        private boolean hasRoof;

        @Override
        public void visit(Visitable visitable) {

        }

        @Override
        public void visit(House house) {
            houseLooksGood = true;
        }

        @Override
        public void visit(Foundation foundation) {
            hasFoundation = true;
        }

        @Override
        public void visit(Floor floor) {
            hasFloor = true;
        }

        @Override
        public void visit(Roof roof) {
            hasRoof = true;
        }
    }
}
