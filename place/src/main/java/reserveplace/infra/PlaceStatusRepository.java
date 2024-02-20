package reserveplace.infra;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import reserveplace.domain.*;

@RepositoryRestResource(
    collectionResourceRel = "placeStatuses",
    path = "placeStatuses"
)
public interface PlaceStatusRepository
    extends PagingAndSortingRepository<PlaceStatus, Long> {}
