package reserveplace.domain;

import java.util.*;
import lombok.*;
import reserveplace.domain.*;
import reserveplace.infra.AbstractEvent;

@Data
@ToString
public class ReservationConfirmed extends AbstractEvent {

    private Long placeId;
    private Integer stock;
    private Long orderId;
}
