package reserveplace.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reserveplace.domain.*;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/accommodations")
@Transactional
public class AccommodationController {

    @Autowired
    AccommodationRepository accommodationRepository;

    @RequestMapping(
        value = "accommodations/{id}/reservationstatusupdate",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Accommodation reservationStatusUpdate(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println(
            "##### /accommodation/reservationStatusUpdate  called #####"
        );
        Optional<Accommodation> optionalAccommodation = accommodationRepository.findById(
            id
        );

        optionalAccommodation.orElseThrow(() -> new Exception("No Entity Found")
        );
        Accommodation accommodation = optionalAccommodation.get();
        accommodation.reservationStatusUpdate();

        accommodationRepository.save(accommodation);
        return accommodation;
    }
}
//>>> Clean Arch / Inbound Adaptor
