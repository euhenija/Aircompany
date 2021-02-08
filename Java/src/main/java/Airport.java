import Planes.ExperimentalPlane;
import models.ClassificationLevel;
import models.MilitaryType;
import Planes.MilitaryPlane;
import Planes.PassengerPlane;
import Planes.Plane;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Airport {

    private List<? extends Plane> planes;

    public Airport(List<? extends Plane> planes) {
        this.planes = planes;
    }

    public List<? extends Plane> getPlanes() {
        return planes;
    }

    public List<PassengerPlane> getPassengerPlanes() {
        List<PassengerPlane> passengerPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof PassengerPlane) {
                passengerPlanes.add((PassengerPlane) plane);
            }
        }
        return passengerPlanes;
    }

    public List<MilitaryPlane> getMilitaryPlanes() {
        List<MilitaryPlane> militaryPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof MilitaryPlane) {
                militaryPlanes.add((MilitaryPlane) plane);
            }
        }
        return militaryPlanes;
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        List<PassengerPlane> passengerPlanes = getPassengerPlanes();
        PassengerPlane planeWithMaxPassengerCapacityInTheAirport = passengerPlanes.get(0);
        for (PassengerPlane passengerPlane : passengerPlanes) {
            if (passengerPlane.getPassengersCapacity() > planeWithMaxPassengerCapacityInTheAirport.getPassengersCapacity()) {
                planeWithMaxPassengerCapacityInTheAirport = passengerPlane;
            }
        }
        return planeWithMaxPassengerCapacityInTheAirport;
    }

    public List<MilitaryPlane> getTransportMilitaryPlanes() {
        List<MilitaryPlane> transportMilitaryPlanes = new ArrayList<>();
        List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
        for (MilitaryPlane plane : militaryPlanes) {
            if (plane.getType() == MilitaryType.TRANSPORT) {
                transportMilitaryPlanes.add(plane);
            }
        }
        return transportMilitaryPlanes;
    }

    public List<MilitaryPlane> getBomberMilitaryPlanes() {
        List<MilitaryPlane> bomberMilitaryPlanes = new ArrayList<>();
        List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
        for (MilitaryPlane plane : militaryPlanes) {
            if (plane.getType() == MilitaryType.BOMBER) {
                bomberMilitaryPlanes.add(plane);
            }
        }
        return bomberMilitaryPlanes;
    }

    public List<ExperimentalPlane> getExperimentalPlanes() {
        List<ExperimentalPlane> experimentalPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof ExperimentalPlane) {
                experimentalPlanes.add((ExperimentalPlane) plane);
            }
        }
        return experimentalPlanes;
    }

    public Airport sortByMaxDistance() {
       Comparator<Plane> comparator = new Comparator<Plane>() {
           @Override
           public int compare(Plane o1, Plane o2) {
               return o1.getMaxFlightDistance() - o2.getMaxFlightDistance();
           }
       };
        Collections.sort(planes,comparator);
        return this;
    }

    public  Airport sortPlanesByMaxSpeed() {
        Collections.sort(planes, new Comparator<Plane>() {
            public int compare(Plane o1, Plane o2) {
                return o1.getMaxSpeed() - o2.getMaxSpeed();
            }
          }
        );
        return this;
    }

    public Airport sortPlanesByMaxLoadCapacity() {
        Collections.sort(planes, new Comparator<Plane>() {
            public int compare(Plane o1, Plane o2) {
                return o1.getMaxLoadCapacity() - o2.getMaxLoadCapacity();
            }
        });
        return this;
    }

//    public boolean verifyListIsSortedByMaxLoadCapacity() {
//        Airport airport = new Airport(planes);
//        airport.sortPlanesByMaxLoadCapacity();
//        List<? extends Plane> planesSortedByMaxLoadCapacity = airport.getPlanes();
//        boolean nextPlaneMaxLoadCapacityIsHigherThanCurrent = true;
//        for (int i = 0; (i < planesSortedByMaxLoadCapacity.size() - 1); i++) {
//            if (planesSortedByMaxLoadCapacity.get(i).getMaxLoadCapacity() > planesSortedByMaxLoadCapacity.get(i + 1).getMaxLoadCapacity()) {
//                nextPlaneMaxLoadCapacityIsHigherThanCurrent = false;
//             break;
//            }
//        }
//        return nextPlaneMaxLoadCapacityIsHigherThanCurrent;
//    }
//
//    public boolean verifyAtLeasOneExperimentalPlaneHasClassificationLevelHigherThanUnclassified() {
//        Airport airport = new Airport(planes);
//        List<ExperimentalPlane> ExperimentalPlanes = airport.getExperimentalPlanes();
//        boolean hasUnclassifiedPlanes = true;
//        for (ExperimentalPlane experimentalPlane : ExperimentalPlanes) {
//            if (experimentalPlane.getClassificationLevel() == ClassificationLevel.UNCLASSIFIED) {
//                hasUnclassifiedPlanes = false;
//                break;
//            }
//        }
//        return hasUnclassifiedPlanes;
//    }

    @Override
    public String toString() {
        return "Airport{" +
                "Planes=" + planes.toString() +
                '}';
    }

}
