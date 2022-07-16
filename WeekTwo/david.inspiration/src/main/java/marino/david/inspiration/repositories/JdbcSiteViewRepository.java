package marino.david.inspiration.repositories;

import marino.david.inspiration.models.SiteView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcSiteViewRepository implements SiteViewRepository {
    private JdbcTemplate jdbc;

    @Autowired
    public JdbcSiteViewRepository (JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public SiteView save(SiteView siteView) {
        jdbc.update(
                "insert into siteviews (message) values(?)",
                //siteView.getId(),
                siteView.getMessage()
        );
        return siteView;
    }
}
