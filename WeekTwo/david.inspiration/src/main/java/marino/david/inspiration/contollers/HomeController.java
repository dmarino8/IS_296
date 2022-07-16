package marino.david.inspiration.contollers;

import marino.david.inspiration.models.SiteView;
import marino.david.inspiration.repositories.SiteViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final SiteViewRepository siteViewRepo;

    @Autowired
    public HomeController(SiteViewRepository siteViewRepo) {
        this.siteViewRepo = siteViewRepo;
    }

    @GetMapping("/")
    public String home() {
        SiteView sv = new SiteView("another site view");
        siteViewRepo.save(sv);
        return "home";
    }
}
