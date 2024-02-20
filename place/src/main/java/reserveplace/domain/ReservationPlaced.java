package reserveplace.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import reserveplace.domain.*;
import reserveplace.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class ReservationPlaced extends AbstractEvent {

    private Long orderId;
    private String placeNm;
    private String placeId;
    private String status;
    private String usrId;
    private Date strDt;
    private Date endDt;
    private Integer qty;
    private Double amount;

    public ReservationPlaced(Accommodation aggregate) {
        super(aggregate);
    }

    public ReservationPlaced() {
        super();
    }
}
//>>> DDD / Domain Event
