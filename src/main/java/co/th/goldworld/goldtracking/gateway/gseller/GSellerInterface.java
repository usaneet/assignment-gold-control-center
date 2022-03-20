package co.th.goldworld.goldtracking.gateway.gseller;

import co.th.goldworld.goldtracking.transfer.TransferRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GSellerInterface {

    @Autowired
    RestTemplate restTemplate;

    public void issueTransferToGSellerSystem(TransferRecord transferRecord){
        restTemplate.postForEntity("/gseller-service/v1/transfer",transferRecord, String.class);
    }
}
