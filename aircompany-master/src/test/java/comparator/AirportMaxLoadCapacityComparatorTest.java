package comparator;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import plane.PassengerPlane;

import java.util.Comparator;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AirportMaxLoadCapacityComparatorTest {

    private Comparator comparator;
    private PassengerPlane passengerPlane1;
    private PassengerPlane passengerPlane2;

    @BeforeMethod
    public void setUp() {
        comparator = new AirportMaxLoadCapacityComparator();
        passengerPlane1 = new PassengerPlane("Boeing-747", 980, 16100, 70500, 242);
        passengerPlane2 = new PassengerPlane("Airbus A320", 930, 11800, 65500, 188);
    }

    @Test
    public void testCompare() {
        assertTrue(comparator.compare(passengerPlane1,passengerPlane2) > 0);
    }
}