package marino.david.inspiration.repositories;

import marino.david.inspiration.models.SiteView;
import org.springframework.stereotype.Repository;

@Repository
public interface SiteViewRepository {
    SiteView save(SiteView siteView);
}
