package reserveplace.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import reserveplace.ManagementApplication;
import reserveplace.domain.ReservationCancelConfirmed;
import reserveplace.domain.ReservationConfirmed;

@Entity
@Table(name = "ReservationManagement_table")
@Data
//<<< DDD / Aggregate Root
public class ReservationManagement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long placeId;

    private Integer stock;

    private String placeNm;

    @PostPersist
    public void onPostPersist() {
        ReservationConfirmed reservationConfirmed = new ReservationConfirmed(
            this
        );
        reservationConfirmed.publishAfterCommit();
    }

    @PostUpdate
    public void onPostUpdate() {
        ReservationCancelConfirmed reservationCancelConfirmed = new ReservationCancelConfirmed(
            this
        );
        reservationCancelConfirmed.publishAfterCommit();
    }

    public static ReservationManagementRepository repository() {
        ReservationManagementRepository reservationManagementRepository = ManagementApplication.applicationContext.getBean(
            ReservationManagementRepository.class
        );
        return reservationManagementRepository;
    }
}
//>>> DDD / Aggregate Root
