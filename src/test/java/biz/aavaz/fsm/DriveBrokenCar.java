package biz.aavaz.fsm;


import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
public class DriveBrokenCar {

    @Test 
    @Order(1)
    public void givenParkedCar_whenDrivenAndParked_thenCheckPriceOfCar() {
        System.out.println("Test 1");
        Car aCar = Car.PARKED;
        System.out.println("aCar.price: " + aCar.getPrice());
        aCar = aCar.shiftGear(1);
        System.out.println("aCar.price: " + aCar.getPrice());
        aCar = aCar.shiftGear(0);
        System.out.println("aCar.price: " + aCar.getPrice());

        assertEquals(aCar.getPrice(), 10);
    }

    @Test 
    @Order(2)
    public void givenParkedCar_whenDrivenAndBroken_thenCheckPriceOfCar() {
        System.out.println("Test 2");
        Car aCar = Car.PARKED;
        System.out.println("aCar.price: " + aCar.getPrice());
        aCar = aCar.shiftGear(1);
        System.out.println("aCar.price: " + aCar.getPrice());
        aCar = aCar.shiftGear(2);
        System.out.println("aCar.price: " + aCar.getPrice());

        assertEquals(aCar.getPrice(), 0);
    }

}
