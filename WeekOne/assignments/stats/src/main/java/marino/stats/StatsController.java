package marino.stats;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StatsController {


    static Map<Integer, Stats> statsRepo = new HashMap<>();
    static Stats jaysonTatum = new Stats();
    static Stats stephCurry = new Stats();

    static {
        jaysonTatum.setId(1);
        jaysonTatum.setStat("21 points");
        jaysonTatum.setPlayer("Jayson Tatum");
        jaysonTatum.setSeriesGameNumber(1);
        statsRepo.put(jaysonTatum.getId(), jaysonTatum);

        stephCurry.setId(2);
        stephCurry.setStat("30 points");
        stephCurry.setPlayer("Steph Curry");
        stephCurry.setSeriesGameNumber(1);
        statsRepo.put(stephCurry.getId(), stephCurry);
    }


    @GetMapping("/stats")
    public ResponseEntity<Object> getAllStats() {
        return new ResponseEntity<>(statsRepo.values(), HttpStatus.OK);
    }

}
