package reserveplace.external;

import java.util.Date;
import lombok.Data;

@Data
public class ReservationManagement {

    private Long placeId;
    private Integer stock;
    private String placeNm;
    private Long orderId;
}
