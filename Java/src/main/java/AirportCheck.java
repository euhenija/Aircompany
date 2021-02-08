import Planes.ExperimentalPlane;
import models.ClassificationLevel;
import Planes.Plane;
import java.util.List;


public class AirportCheck {

    private List<? extends Plane> planes;

    public AirportCheck(List<? extends Plane> planes) {
        this.planes = planes;
    }

    public boolean verifyListIsSortedByMaxLoadCapacity() {
        Airport airport = new Airport(planes);
        airport.sortPlanesByMaxLoadCapacity();
        List<? extends Plane> planesSortedByMaxLoadCapacity = airport.getPlanes();
        boolean nextPlaneMaxLoadCapacityIsHigherThanCurrent = true;
        for (int i = 0; (i < planesSortedByMaxLoadCapacity.size() - 1); i++) {
            if (planesSortedByMaxLoadCapacity.get(i).getMaxLoadCapacity() > planesSortedByMaxLoadCapacity.get(i + 1).getMaxLoadCapacity()) {
                nextPlaneMaxLoadCapacityIsHigherThanCurrent = false;
                break;
            }
        }
        return nextPlaneMaxLoadCapacityIsHigherThanCurrent;
    }

    public boolean verifyAtLeasOneExperimentalPlaneHasClassificationLevelHigherThanUnclassified() {
        Airport airport = new Airport(planes);
        List<ExperimentalPlane> ExperimentalPlanes = airport.getExperimentalPlanes();
        boolean hasUnclassifiedPlanes = true;
        for (ExperimentalPlane experimentalPlane : ExperimentalPlanes) {
            if (experimentalPlane.getClassificationLevel() == ClassificationLevel.UNCLASSIFIED) {
                hasUnclassifiedPlanes = false;
                break;
            }
        }
        return hasUnclassifiedPlanes;
    }
}
