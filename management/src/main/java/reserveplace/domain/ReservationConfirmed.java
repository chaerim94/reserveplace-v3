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

    private Long placeId;
    private Integer stock;
    private String placeNm;

    public ReservationConfirmed(ReservationManagement aggregate) {
        super(aggregate);
    }

    public ReservationConfirmed() {
        super();
    }
}
//>>> DDD / Domain Event
