package reserveplace.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import reserveplace.config.kafka.KafkaProcessor;
import reserveplace.domain.*;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    ReservationManagementRepository reservationManagementRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='PaymentApproved'"
    )
    public void wheneverReservationConfirmed_create(@Payload ReservationManagement reservationManagement) {

        Integer placeQty = reservationManagementRepository
        .findByPlaceId(reservationManagement.getPlaceId())
        .get()
        .getStock(); //- 1;

        if (placeQty > 0) {
            reservationManagement.setStock(placeQty - 1);
            reservationManagementRepository.save(reservationManagement);
    
            ReservationConfirmed reservationConfirmed = new ReservationConfirmed(reservationManagement);
            reservationConfirmed.publishAfterCommit();
        } else {
            // payment의 PaymentCancel 수행
            ReservationCancelConfirmed reservationCancelConfirmed = new ReservationCancelConfirmed(reservationManagement);
            reservationCancelConfirmed.publishAfterCommit();
        }
    }
}
//>>> Clean Arch / Inbound Adaptor
