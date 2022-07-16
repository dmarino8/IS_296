package marino.sql.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SqlController {


    @GetMapping(value="/experience")
    public String experience() {
        return "The best teacher in life is experience. -Bron";
    }




}
