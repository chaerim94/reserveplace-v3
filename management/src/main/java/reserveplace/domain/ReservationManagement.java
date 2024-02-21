package reserveplace.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import reserveplace.ManagementApplication;

@Entity
@Table(name = "ReservationManagement_table")
@Data
//<<< DDD / Aggregate Root
public class ReservationManagement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long placeId;

    private Integer stock;

    private Long orderId;

    @PostPersist
    public void onPostPersist() {}

    public static ReservationManagementRepository repository() {
        ReservationManagementRepository reservationManagementRepository = ManagementApplication.applicationContext.getBean(
            ReservationManagementRepository.class
        );
        return reservationManagementRepository;
    }

    //<<< Clean Arch / Port Method
    public void reservationInform(
        ReservationInformCommand reservationInformCommand
    ) {
        //implement business logic here:

        ReservationConfirmed reservationConfirmed = new ReservationConfirmed(
            this
        );
        reservationConfirmed.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void reservationCancelProcessing(
        ReservationCancelProcessingCommand reservationCancelProcessingCommand
    ) {
        //implement business logic here:

        ReservationCancelConfirmed reservationCancelConfirmed = new ReservationCancelConfirmed(
            this
        );
        reservationCancelConfirmed.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
