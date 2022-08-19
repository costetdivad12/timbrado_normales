package iebem.edu.mx.timbre_normales.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class Ws10NormalesConfig {
    
    @Bean
    public Jaxb2Marshaller marshallerTest() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("iebem.edu.mx.timbre_normales.wsprod");
        return marshaller;
    }

    @Bean
    public WS10Client getWSCFDI33ClientTest(Jaxb2Marshaller marshaller) {
        WS10Client client = new WS10Client();
        client.setDefaultUri("https://mecqa.siged.sep.gob.mx/mec-ws/services/V1/CertificadosNormales.wsdl");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    } 

}
