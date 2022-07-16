package marino.tacos.repositories;

import marino.tacos.models.CustomerReview;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface CustomerReviewRepository extends MongoRepository<CustomerReview, String> {
    List<CustomerReview> findByProductDescriptionContaining(String productDescription);
    List<CustomerReview> findByActionNeeded(boolean actionNeeded);
}