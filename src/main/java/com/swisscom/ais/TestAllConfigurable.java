package com.swisscom.ais;

import com.swisscom.ais.client.AisClientConfiguration;
import com.swisscom.ais.client.impl.AisClientImpl;
import com.swisscom.ais.client.model.PdfHandle;
import com.swisscom.ais.client.model.SignatureResult;
import com.swisscom.ais.client.model.UserData;
import com.swisscom.ais.client.rest.RestClientConfiguration;
import com.swisscom.ais.client.rest.RestClientImpl;

import java.util.Collections;
import java.util.Properties;

/**
 * Test with an On Demand signature with Step Up that shows how to access all the configuration available and load it from a
 * properties file. The same configuration can also be tweaked by hand or via some framework (e.g. Spring, Guice, etc).
 */
public class TestAllConfigurable {

    public static void main(String[] args) throws Exception {
        // first load the properties from a local file
        Properties properties = new Properties();
        properties.load(TestOnDemandSignatureWithStepUp.class.getResourceAsStream("/local-config.properties"));

        // load the REST client config
        RestClientConfiguration restConfig = new RestClientConfiguration();
        restConfig.setFromProperties(properties);

        RestClientImpl restClient = new RestClientImpl();
        restClient.setConfiguration(restConfig);

        // load the AIS client config
        AisClientConfiguration aisConfig = new AisClientConfiguration();
        aisConfig.setFromProperties(properties);

        try (AisClientImpl aisClient = new AisClientImpl(aisConfig, restClient)) {
            // third, load even the user data from the properties store
            UserData userData = new UserData();
            userData.setFromProperties(properties);
            userData.setConsentUrlCallback((consentUrl, userData1) -> System.out.println("Consent URL: " + consentUrl));

            // finally, use the properties store even for local testing data
            PdfHandle document = new PdfHandle();
            document.setInputFromFile(properties.getProperty("local.test.inputFile"));
            document.setOutputToFile(properties.getProperty("local.test.outputFilePrefix") + System.currentTimeMillis() + ".pdf");

            SignatureResult result = aisClient.signWithOnDemandCertificateAndStepUp(Collections.singletonList(document), userData);
            System.out.println("Final result: " + result);
        }
    }

}
