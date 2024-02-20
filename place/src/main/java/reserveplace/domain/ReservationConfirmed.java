package reserveplace.domain;

import java.util.*;
import lombok.*;
import reserveplace.domain.*;
import reserveplace.infra.AbstractEvent;

@Data
@ToString
public class ReservationConfirmed extends AbstractEvent {

    private Long placeId;
    private String status;
    private Integer stock;
    private String placeNm;
}
