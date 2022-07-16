package marino.apudr;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class DronesController {
    //***************************
    // Instances
    //***************************
    private static Map<Integer, Drones> droneRepo = new HashMap<>();
    static {
        Drones droneA = new Drones();
        droneA.setId(1);
        droneA.setName("Field A Drone");
        droneA.setAvailable(false);
        droneA.setService("Water the corn crops");
        droneRepo.put(droneA.getId(),droneA);

        Drones droneB = new Drones();
        droneB.setId(2);
	droneB.setName("Field B Drone");
        droneB.setAvailable(true);
        droneB.setService("Take picture of corn crops");
        droneRepo.put(droneB.getId(),droneB);
    }

    //***************************
    // CRUD Methods
    //***************************

    /**
     * <h1>GET</h1>
     * @return gets all drone objects in droneRepo
     */
    @RequestMapping(value="/drones")
    public ResponseEntity<Object> getDrones() {
        return new ResponseEntity<>(droneRepo.values(), HttpStatus.OK);
    }

    /**
     * <h1>DELETE</h1>
     * @param id
     * @return deletes drone in droneRepo at pos id
     */
    @RequestMapping(value="/drones/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteDrone(@PathVariable("id") Integer id) {
        droneRepo.remove(id);
        return new ResponseEntity<>("Drone is deleted and will no longer be available", HttpStatus.OK);
    }

    /**
     * <h1>POST</h1>
     * @param drone
     * @return posts drone into droneRepo
     */
    @RequestMapping(value="/drones", method = RequestMethod.POST)
    public ResponseEntity<Object> postDrone(@RequestBody Drones drone) {
        droneRepo.put(drone.getId(), drone);
        return new ResponseEntity<>("Drone has been added to list of available drones", HttpStatus.CREATED);
    }

    /**
     * <h1>PUT</h1>
     * @param id
     * @param drone
     * @return posts drone into droneRepo at position id
     */
    @RequestMapping(value="/drones/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> postDrone(@PathVariable("id") Integer id, @RequestBody Drones drone) {
        droneRepo.remove(id);
        drone.setId(id);
        droneRepo.put(id, drone);
        return new ResponseEntity<>("Properties of Drone have been changed!", HttpStatus.OK);
    }

}
