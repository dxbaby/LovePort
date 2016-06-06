package me.jiangcai.loveport.service.wsdl;

import org.junit.Test;

/**
 * @author CJ
 */
public class DisabledServiceTest {

    @Test
    public void doit() {

        ObjectFactory objectFactory = new ObjectFactory();
        NetworkCredential networkCredential = objectFactory.createNetworkCredential();
        networkCredential.setUserName(objectFactory.createNetworkCredentialUserName(""));
        networkCredential.setPassword(objectFactory.createNetworkCredentialPassword(""));


        DisabledService disabledService = new DisabledService();

        DisabledRequest request = objectFactory.createDisabledRequest();
        request.setNetworkCredential(objectFactory.createDisabledQueryRequestNetworkCredential(networkCredential));
        request.setIdentityCard(objectFactory.createDisabledRequestIdentityCard("XXXX"));

//        request.setIdentityCard();
//        DisabledQueryRequest queryRequest = new DisabledQueryRequest();
        QueryRequest queryRequest = new QueryRequest();
//        queryRequest.set
//        queryRequest.set
        DisabledResponse disabledResponse = disabledService.getDisabledServiceHttpPort().singleQuery(request);
        String state = disabledResponse.getState().getValue();
        System.out.println(state);
    }

}