package me.jiangcai.loveport.service.wsdl;

import org.junit.Before;
import org.junit.Test;

/**
 * @author CJ
 */
public class DisabledServiceTest {

    DisabledService disabledService = new DisabledService();
    ObjectFactory objectFactory = new ObjectFactory();
    NetworkCredential networkCredential = objectFactory.createNetworkCredential();

    @Before
    public void before() {
        networkCredential.setUserName(objectFactory.createNetworkCredentialUserName("hzcl"));
        networkCredential.setPassword(objectFactory.createNetworkCredentialPassword("123$%^"));
    }

    @Test
    public void ZjsclService() {
        QueryRequest request = objectFactory.createQueryRequest();
        request.setNetworkCredential(objectFactory.createQueryRequestNetworkCredential(networkCredential));
        request.setIdentityCard(objectFactory.createQueryRequestIdentityCard("330411193206131622"));

//        QueryDisabled queryDisabled = objectFactory.createQueryDisabled();
//        queryDisabled.setIn0(request);

        QueryResponse response = disabledService.getDisabledServiceHttpPort().queryDisabled(request);

        String state = response.getState().getValue();
        System.out.println(state);

        DisabledInfo info = response.getDisabled().getValue();
        DisableBasicInfo basicInfo = info.getBasic().getValue();
        System.out.println(basicInfo.getName().getValue());
        System.out.println(basicInfo);
    }

}