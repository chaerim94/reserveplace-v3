package reserveplace.external;

import java.util.Date;
import lombok.Data;

@Data
public class ReservationManagement {

    private Long placeId;
    private Integer stock;
    private Long orderId;
}
