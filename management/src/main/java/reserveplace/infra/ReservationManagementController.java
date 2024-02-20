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
// @RequestMapping(value="/reservationManagements")
@Transactional
public class ReservationManagementController {

    @Autowired
    ReservationManagementRepository reservationManagementRepository;

    @RequestMapping(
        value = "reservationManagements/{id}/reservationinform",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public ReservationManagement reservationInform(
        @PathVariable(value = "id") Long id,
        @RequestBody ReservationInformCommand reservationInformCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println(
            "##### /reservationManagement/reservationInform  called #####"
        );
        Optional<ReservationManagement> optionalReservationManagement = reservationManagementRepository.findById(
            id
        );

        optionalReservationManagement.orElseThrow(() ->
            new Exception("No Entity Found")
        );
        ReservationManagement reservationManagement = optionalReservationManagement.get();
        reservationManagement.reservationInform(reservationInformCommand);

        reservationManagementRepository.save(reservationManagement);
        return reservationManagement;
    }

    @RequestMapping(
        value = "reservationManagements/{id}/reservationcancelprocessing",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public ReservationManagement reservationCancelProcessing(
        @PathVariable(value = "id") Long id,
        @RequestBody ReservationCancelProcessingCommand reservationCancelProcessingCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println(
            "##### /reservationManagement/reservationCancelProcessing  called #####"
        );
        Optional<ReservationManagement> optionalReservationManagement = reservationManagementRepository.findById(
            id
        );

        optionalReservationManagement.orElseThrow(() ->
            new Exception("No Entity Found")
        );
        ReservationManagement reservationManagement = optionalReservationManagement.get();
        reservationManagement.reservationCancelProcessing(
            reservationCancelProcessingCommand
        );

        reservationManagementRepository.save(reservationManagement);
        return reservationManagement;
    }
}
//>>> Clean Arch / Inbound Adaptor
