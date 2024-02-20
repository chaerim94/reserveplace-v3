package reserveplace.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class ReservationInformCommand {

    private Integer stock;
    private Long orderId;
}
