package reserveplace.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import reserveplace.domain.*;
import reserveplace.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class ReservationCancelConfirmed extends AbstractEvent {

    private Long rsvId;
    private Long orderId;
    private String status;
    private String usrId;
    private Integer stock;

    public ReservationCancelConfirmed(ReservationManagement aggregate) {
        super(aggregate);
    }

    public ReservationCancelConfirmed() {
        super();
    }
}
//>>> DDD / Domain Event
