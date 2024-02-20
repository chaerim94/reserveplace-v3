package reserveplace.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class ReservationCancelProcessingCommand {

    private Integer stock;
    private Long orderId;
}
