package reserveplace.infra;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import reserveplace.domain.*;
import java.util.Optional;


@RepositoryRestResource(collectionResourceRel = "mypages", path = "mypages")
public interface MypageRepository
    extends PagingAndSortingRepository<Mypage, Long> {
        Optional<Mypage> findByOrderId(Long orderIId);
    }
