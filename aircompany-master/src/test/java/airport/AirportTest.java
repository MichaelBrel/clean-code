package airport;

import airport.Airport;
import model.ClassificationLevel;
import model.ExperimentalType;
import model.MilitaryType;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import plane.ExperimentalPlane;
import plane.MilitaryPlane;
import plane.PassengerPlane;
import plane.Plane;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class AirportTest {
    private static Airport airport;
    private static List<Plane> planes;

    @BeforeClass
    public void setUp() {
        planes = Arrays.asList(new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
                new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
                new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
                new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
                new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
                new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
                new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
                new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196),
                new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryType.BOMBER),
                new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryType.BOMBER),
                new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryType.BOMBER),
                new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryType.FIGHTER),
                new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryType.FIGHTER),
                new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryType.TRANSPORT),
                new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalType.HIGH_ALTITUDE, ClassificationLevel.SECRET),
                new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalType.VTOL, ClassificationLevel.TOP_SECRET));
        airport = new Airport(planes);
    }


    @Test
    public void testGetTransportMilitaryPlanes() {
        List<MilitaryPlane> expectedTransportMilitaryPlanes = new ArrayList<>();
        expectedTransportMilitaryPlanes.add(new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryType.TRANSPORT));
        List<MilitaryPlane> actualTransportMilitaryPlanes = airport.getTransportMilitaryPlanes();
        assertEquals(expectedTransportMilitaryPlanes, actualTransportMilitaryPlanes);
    }

    @Test
    public void testGetPassengerPlaneWithMaxPassengerCapacity() {
        PassengerPlane expectedPlaneWithMaxPassengerCapacity = new PassengerPlane("Boeing-747", 980, 16100, 70500, 242);
        PassengerPlane actualPlaneWithMaxPassengerCapacity = airport.getPassengerPlaneWithMaxPassengerCapacity();
        assertEquals(expectedPlaneWithMaxPassengerCapacity, actualPlaneWithMaxPassengerCapacity);
    }

    @Test
    public void testGetBomberMilitaryPlanes() {
        List<MilitaryPlane> expectedBomberMilitaryPlanes = new ArrayList<>();
        expectedBomberMilitaryPlanes.add(new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryType.BOMBER));
        expectedBomberMilitaryPlanes.add(new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryType.BOMBER));
        expectedBomberMilitaryPlanes.add(new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryType.BOMBER));
        List<MilitaryPlane> actualBomberMilitaryPlanes = airport.getBomberMilitaryPlanes();
        assertEquals(expectedBomberMilitaryPlanes,actualBomberMilitaryPlanes);
    }

    @Test
    public void testGetExperimentalPlanes() {
        List<ExperimentalPlane> expectedExperimentalPlanes = new ArrayList<>();
        expectedExperimentalPlanes.add(new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalType.HIGH_ALTITUDE, ClassificationLevel.SECRET));
        expectedExperimentalPlanes.add(new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalType.VTOL, ClassificationLevel.TOP_SECRET));
        List<ExperimentalPlane> actualExperimentalPlanes = airport.getExperimentalPlanes();
        assertEquals(expectedExperimentalPlanes,actualExperimentalPlanes);
    }


}
