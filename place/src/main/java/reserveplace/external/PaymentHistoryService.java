package reserveplace.external;

import java.util.Date;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "payment", url = "${api.url.payment}")
public interface PaymentHistoryService {
    @RequestMapping(method = RequestMethod.POST, path = "/paymentHistories")
    public void paymentRequest(@RequestBody PaymentHistory paymentHistory);

    @RequestMapping(method = RequestMethod.DELETE, path = "/paymentHistories")
    public void paymentCancel(@RequestBody PaymentHistory paymentHistory);
}
