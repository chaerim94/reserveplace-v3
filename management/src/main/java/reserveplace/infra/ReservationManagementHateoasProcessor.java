package reserveplace.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import reserveplace.domain.*;

@Component
public class ReservationManagementHateoasProcessor
    implements
        RepresentationModelProcessor<EntityModel<ReservationManagement>> {

    @Override
    public EntityModel<ReservationManagement> process(
        EntityModel<ReservationManagement> model
    ) {
        return model;
    }
}
