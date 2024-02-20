package reserveplace.infra;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import reserveplace.domain.*;

@RepositoryRestResource(
    collectionResourceRel = "manageStatuses",
    path = "manageStatuses"
)
public interface ManageStatusRepository
    extends PagingAndSortingRepository<ManageStatus, Long> {}
