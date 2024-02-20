package reserveplace.external;

import java.util.Date;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "management", url = "${api.url.management}")
public interface ReservationManagementService {
    @RequestMapping(
        method = RequestMethod.PUT,
        path = "/reservationManagements/{id}/reservationinform"
    )
    public void reservationInform(
        @PathVariable("id") Long placeId,
        @RequestBody ReservationInformCommand reservationInformCommand
    );
}
