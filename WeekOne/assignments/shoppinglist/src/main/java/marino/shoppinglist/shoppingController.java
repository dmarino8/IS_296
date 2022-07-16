package marino.shoppinglist;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;
import java.util.HashMap;
import java.util.Map;

@RestController
public class shoppingController {

    static Map<String, toDoList> toDoRepo = new HashMap();
    static toDoList groceryList = new toDoList();
    static toDoList workoutList = new toDoList();

    static {
        groceryList.setGroup_name("grocery");
        groceryList.addItem("apples");
        groceryList.addItem("mango");
        groceryList.addItem("oats");
        groceryList.addItem("shaving cream");
        groceryList.addItem("toothpaste");
        toDoRepo.put(groceryList.getGroup_name(),groceryList);
        workoutList.setGroup_name("workout");
        workoutList.addItem("bench");
        workoutList.addItem("squat");
        workoutList.addItem("pull-up");
        workoutList.addItem("push-up");
        workoutList.addItem("bicep curl");
        toDoRepo.put(workoutList.getGroup_name(),workoutList);
    }


    shoppingController() {

    }

    @GetMapping("/todo")
    public ResponseEntity<Object> getAll() {
        return new ResponseEntity<>(toDoRepo.values(), HttpStatus.OK);
    }
    /*public ResponseEntity<Object> getAllStats() {
        return new ResponseEntity<>(statsRepo.values(), HttpStatus.OK);
    }*/

    @GetMapping("/todo/{group_name}")
    public ResponseEntity<Object> getGroup(@PathVariable String group_name) {
        return new ResponseEntity<>(toDoRepo.get(group_name), HttpStatus.OK);
    }

    @GetMapping("/todo/all")
    public ResponseEntity<Object> getAllGroupNames() {
        String output = "";
        for (String id : toDoRepo.keySet()) {
            output += " " + id;
        }
        return new ResponseEntity<>(output, HttpStatus.OK);
    }


}
