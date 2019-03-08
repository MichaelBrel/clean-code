package comparator;

import plane.Plane;

import java.util.Comparator;

public class AirportMaxFlightDistanceComparator implements Comparator<Plane> {
    @Override
    public int compare(Plane o1, Plane o2) {
        return o1.getMaxFlightDistance() - o2.getMaxFlightDistance();
    }
}
