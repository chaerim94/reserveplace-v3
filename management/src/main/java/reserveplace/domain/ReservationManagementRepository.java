package reserveplace.domain;

import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import reserveplace.domain.*;
import java.util.Optional;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "reservationManagements",
    path = "reservationManagements"
)
public interface ReservationManagementRepository
    extends PagingAndSortingRepository<ReservationManagement, Long> {
        Optional<ReservationManagement> findByPlaceId(Long placeId);
    }
