package reserveplace.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import reserveplace.domain.*;
import reserveplace.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class ReservationConfirmed extends AbstractEvent {

    private Long rsvId;
    private Long orderId;
    private String status;
    private String usrId;
    private Integer stock;

    public ReservationConfirmed(ReservationManagement aggregate) {
        super(aggregate);
    }

    public ReservationConfirmed() {
        super();
    }
}
//>>> DDD / Domain Event
