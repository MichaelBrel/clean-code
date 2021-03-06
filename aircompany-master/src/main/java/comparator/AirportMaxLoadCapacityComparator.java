package comparator;

import plane.Plane;

import java.util.Comparator;

public class AirportMaxLoadCapacityComparator implements Comparator<Plane> {

    @Override
    public int compare(Plane o1, Plane o2) {
        return o1.getMaxLoadCapacity() - o2.getMaxLoadCapacity();
    }
}
