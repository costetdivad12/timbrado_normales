package iebem.edu.mx.timbre_normales.configuration;

import java.math.BigInteger;

import javax.websocket.Decoder.Binary;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.ws.Response;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import iebem.edu.mx.timbre_normales.wsprod.AutenticacionType;
import iebem.edu.mx.timbre_normales.wsprod.CargaCertificadosRequest;
import iebem.edu.mx.timbre_normales.wsprod.CargaCertificadosResponse;
import iebem.edu.mx.timbre_normales.wsprod.ConsultaModalidadRequest;
import iebem.edu.mx.timbre_normales.wsprod.ConsultaModalidadResponse;
import iebem.edu.mx.timbre_normales.wsprod.ObjectFactory;

public class WS10Client extends WebServiceGatewaySupport {
    

    public CargaCertificadosResponse  timbrarCertificado(String nombreA,byte[]  archivoBase64,BigInteger idMotivoAlta,AutenticacionType usuario,AutenticacionType password ){
        CargaCertificadosRequest request = new CargaCertificadosRequest();
       
        ObjectFactory of = new ObjectFactory();
        
        request.setNombreArchivo(nombreA);
        request.setArchivoBase64(archivoBase64);
        request.setIdMotivoAlta(idMotivoAlta);
        request.setAutenticacion(usuario);
        request.setAutenticacion(password);
        CargaCertificadosResponse response = (CargaCertificadosResponse) this.getWebServiceTemplate().marshalSendAndReceive(request);
        
        return response;
        
        
    }

    
    /**
     * @return
     */
    public ConsultaModalidadResponse ConsultaModalidad(){
       
       
         ConsultaModalidadRequest re = new ConsultaModalidadRequest();
         
         AutenticacionType autenticacion = new AutenticacionType();
          autenticacion.setUsuario("usuarionormal.qa1701");
          autenticacion.setPassword("BzTzoFAxK588LydS67");
        re.setAutenticacion(autenticacion);
        
          // ConsultaModalidadResponse resp = (ConsultaModalidadResponse) this.getWebServiceTemplate().marshalSendAndReceive(re);

          ConsultaModalidadResponse resp = (ConsultaModalidadResponse) this.getWebServiceTemplate().marshalSendAndReceive(re);
          return resp;

    }

}
