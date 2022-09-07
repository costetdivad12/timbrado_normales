package iebem.edu.mx.timbre_normales.configuration;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.security.PrivateKey;
import java.security.Signature;
import java.util.List;

import javax.websocket.Decoder.Binary;
import javax.xml.bind.DatatypeConverter;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.ws.Response;

import org.apache.commons.ssl.PKCS8Key;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import iebem.edu.mx.timbre_normales.mapper.ConsultaInfo;
import iebem.edu.mx.timbre_normales.model.XmlModel;
import iebem.edu.mx.timbre_normales.wsprod.AutenticacionType;
import iebem.edu.mx.timbre_normales.wsprod.CargaCertificadosRequest;
import iebem.edu.mx.timbre_normales.wsprod.CargaCertificadosResponse;
import iebem.edu.mx.timbre_normales.wsprod.ConsultaModalidadRequest;
import iebem.edu.mx.timbre_normales.wsprod.ConsultaModalidadResponse;
import iebem.edu.mx.timbre_normales.wsprod.ObjectFactory;

public class WS10Client extends WebServiceGatewaySupport {

  @Autowired
  private JdbcTemplate jdbc;

  public CargaCertificadosResponse timbrarCertificado(String nombreA, byte[] archivoBase64, BigInteger idMotivoAlta,
      AutenticacionType usuario, AutenticacionType password) {
    CargaCertificadosRequest request = new CargaCertificadosRequest();

    ObjectFactory of = new ObjectFactory();

    request.setNombreArchivo(nombreA);
    request.setArchivoBase64(archivoBase64);
    request.setIdMotivoAlta(idMotivoAlta);
    request.setAutenticacion(usuario);
    request.setAutenticacion(password);
    CargaCertificadosResponse response = (CargaCertificadosResponse) this.getWebServiceTemplate()
        .marshalSendAndReceive(request);

    return response;

  }

  /**
   * @return
   */
  public ConsultaModalidadResponse ConsultaModalidad() {
    String certificatesTrustStorePath = "C:/Program Files/Java/jre1.8.0_111/lib/security/cacerts";
    System.setProperty("javax.net.ssl.trustStore", certificatesTrustStorePath);

    ConsultaModalidadRequest re = new ConsultaModalidadRequest();

    AutenticacionType autenticacion = new AutenticacionType();
    autenticacion.setUsuario("usuarionormal.qa1701");
    autenticacion.setPassword("BzTzoFAxK588LydS67");
    re.setAutenticacion(autenticacion);

    // ConsultaModalidadResponse resp = (ConsultaModalidadResponse)
    // this.getWebServiceTemplate().marshalSendAndReceive(re);

    ConsultaModalidadResponse resp = (ConsultaModalidadResponse) this.getWebServiceTemplate().marshalSendAndReceive(re);
    return resp;

  }

  public static byte[] leer(String is) throws Exception {

    File f = new File(is);

    FileInputStream fis = new FileInputStream(f);

    byte[] fbytes = new byte[(int) f.length()];
    fis.read(fbytes);
    fis.close();

    return fbytes;
  }

  public XmlModel ConsultaDatos(int idAlumno){
    final String sql = "SELECT  concat('||1.0|',CASE  WHEN tb_certificados.id_tipo_certificado=2 or tb_certificados.id_tipo_certificado=3 then 9 else 8 end ,'|educacionNormal|17|CACJ750418HMSRRS05|',tb_autoridad_educativa.puesto,'|Secretaría de Educación del Estado de Morelos|',tb_centros_trabajo.nombre_centro_trabajo,'|',tb_centros_trabajo.clave_centro_trabajo,'|',tb_centros_trabajo.clave_institucion,'|017|',CASE WHEN tb_centros_trabajo.clave_centro_trabajo='17DNL0001D' then '033'   WHEN  tb_centros_trabajo.clave_centro_trabajo='17DNL0004A' then '006'  WHEN tb_centros_trabajo.clave_centro_trabajo='17PNL0002H' then '007' WHEN tb_centros_trabajo.clave_centro_trabajo='17PNL0001I' then '007' else ''  end,'|',tb_carreras.clave_carrera,'|',tb_carreras.nombre_carrera,'|',tb_carreras.id_modalidad,'|',tb_certificados.plan,'|',tb_alumnos.curp,'|',tb_alumnos.nombre,'|',tb_alumnos.apellido_paterno,\"|\",tb_alumnos.apellido_materno,'|',CASE  when SUBSTR(tb_alumnos.curp,11,1)='H' then 1 else 2 end,'|',CURDATE(),'|',tb_certificados.numero_asignaturas_acreditadas,'|',tb_certificados.numero_asignaturas_totales,'|',tb_certificados.promedio_general ,'|', T.TOKEN,'||') as firma, CURDATE() as fecha_exp, tb_certificados.id_alumno as idAlumno  \n" +
    "FROM tb_alumnos\n" +
    "INNER JOIN tb_certificados ON tb_alumnos.id = tb_certificados.id_alumno\n" +
    "INNER JOIN tb_autoridad_educativa ON tb_certificados.id_autoridad_educativa = tb_autoridad_educativa.id\n" +
    "INNER JOIN tb_centros_trabajo ON tb_certificados.id_centro_trabajo = tb_centros_trabajo.id\n" +
    "INNER JOIN tb_carreras ON tb_certificados.id_carrera = tb_carreras.id\n" +
    "LEFT JOIN (SELECT M.id_carrera, M.id_alumno, GROUP_CONCAT(M.Clave, '|', M.calificacion, '|', M.numero_semestre, '|', M.Periodo SEPARATOR '|') AS TOKEN\n" +
    "		   FROM (SELECT A1.id_ciclo_escolar, A1.id_carrera, A1.id_alumno, A1.id_asignatura, A1.Clave, A1.calificacion, A2.numero_semestre, A2.anio_inicio AS Periodo\n" +
    "			 	 FROM (	SELECT Mat.id_ciclo_escolar, Mat.id_carrera, Cal.id_alumno, Cal.id_asignatura, Mat.clave_asignatura as Clave, Cal.calificacion\n" +
    "						FROM tb_calificaciones as Cal LEFT JOIN tb_asignaturas AS Mat ON Cal.id_asignatura = Mat.id\n" +
    "				) AS A1 \n" +
    "                LEFT JOIN (	SELECT Mat.id_ciclo_escolar, Mat.id_carrera, Mat.id as id_asignatura, Mat.clave_asignatura, Mat.numero_semestre, CE.periodo, CE.anio_inicio, CE.anio_fin\n" +
    "							FROM tb_asignaturas AS Mat LEFT JOIN tb_ciclos_escolares AS CE ON Mat.id_ciclo_escolar = CE.id\n" +
    "						  ) AS A2 \n" +
    "								ON A1.id_ciclo_escolar = A2.id_ciclo_escolar AND A1.id_carrera = A2.id_carrera AND A1.id_asignatura = A2.id_asignatura\n" +
    "					) AS M\n" +
    "			GROUP BY M.id_carrera, M.id_alumno\n" +
    "		  ) AS T ON tb_alumnos.id = T.id_alumno\n" +
    "WHERE tb_certificados.id_alumno = "+idAlumno;
    // curp_mapper mapper =new curp_mapper();
    // jdbc.query(sql, mapper, new Object[]{});
    ConsultaInfo mapper = new ConsultaInfo();
    XmlModel re =   jdbc.queryForObject(sql, mapper, new Object[] {  });
    // System.out.println(re);
    return re;
  }

  public XmlModel FirmaDatos(int idAlumno) {
    XmlModel cadena=ConsultaDatos(idAlumno);
     System.out.println(cadena.getCadena_original() );   
     String resultado= Firma(cadena.getCadena_original(), "CACJ7504189B3", "cacj7504");
     cadena.setFirma(resultado);
     final String sql = "insert into Firma (idAlumno,fecha_expedicion,cadena_original,firma) values (?,?,?,?)";

        String mensaje = "";
        int insert = jdbc.update(sql, cadena.getIdAlumno(), cadena.getFecha_exp(), cadena.getCadena_original(), resultado);
        if (insert != 0) {
            mensaje = "Registro exitoso";
        } else {
            mensaje = "Error en el registro";
        }
        return cadena;


  }

  public String Firma(String cadenaOriginal, String rfc, String password) {
    System.out.println("metodo de firma");
    String selloDigital = "";
    String selloDigital1 = "";

    try {
      if (rfc.length() != 0 & cadenaOriginal.length() != 0 && password.length() != 0) {
        // KeyStore ks = KeyStore.getInstance("pkcs12");
        // KeyStore ks = KeyStore.getInstance("pkcs12");

        // Cargar el archivo de la firma y el password
        // (rfc)----------------------------------------------------------------------------
        // String ruta = "C:\\salida" + ".pfx";

        String ruta = "C:\\Claveprivada_FIEL_CACJ7504189B3_20210303_145913.key";
        String ruta2 = "C:\\00001000000506637319.cer";

        // byte[] clavePrivada2 = da.leer(ruta2);
        // byte[] clavePrivada = da.leer(ruta);
        // String ruta="/opt/bitacoraDGSGD/firmaElectronica/"+rfc+"/"+rfc+".pfx";
        // ks.load(new FileInputStream(ruta), password.toCharArray());
        // PKCS8Key pkcs8 = new PKCS8Key(new FileInputStream(ruta),
        // password.toCharArray());

        final PKCS8Key pkcs8Key = new PKCS8Key(leer(ruta), password.toCharArray());
        final PrivateKey pk = pkcs8Key.getPrivateKey();

        // ----------------------------------------------------------------------------------------------------------------------------
        // Cargar key a partir del archivo pfx- el rfc es el
        // password-------------------------------------------------------------------
        // Enumeration<String> n = ks.aliases();
        // String alias = (String) ks.aliases().nextElement();
        // PrivateKey key = (PrivateKey) ks.getKey(alias, password.toCharArray());
        // Certificate[] chain = ks.getCertificateChain(alias);
        // ----------------------------------------------------------------------------------------------------------------------------
        // Sello
        // digital--------------------------------------------------------------------------------------------------------------
        // Signature firma = Signature.getInstance("SHA256withRSA");
        final Signature firma = Signature.getInstance("SHA256withRSA");
        // firma.initSign(pk);
        firma.initSign(pk);
        firma.update(cadenaOriginal.getBytes("UTF-8"));
        // byte[] cadenaFirmada = firma.sign();
        // BASE64Encoder b64 = new BASE64Encoder();
        selloDigital = DatatypeConverter.printBase64Binary(firma.sign());
        // System.out.println("cert " +
        // DatatypeConverter.printBase64Binary(da.leer(ruta2)));
        // selloDigital = DatatypeConverter.printBase64Binary(firma.sign());
        // System.out.println("base cert"+
        // DatatypeConverter.printBase64Binary(clavePrivada2));
        // ----------------------------------------------------------------------------------------------------------------------------
      }
    } catch (Exception e) {
      e.printStackTrace();
      selloDigital = "";
    }
    return selloDigital;
  }

  public void GeneracionXML() throws ParserConfigurationException {

    String certificado = "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";
    DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

    org.w3c.dom.Document doc = docBuilder.newDocument();
    org.w3c.dom.Element rootElement = doc.createElement("Dec");
    doc.appendChild(rootElement);

    org.w3c.dom.Attr Version = doc.createAttribute("version");
    Version.setValue("1.0");
    rootElement.setAttributeNode(Version);

    org.w3c.dom.Attr FolioControl = doc.createAttribute("folioControl");
    FolioControl.setValue("1234");
    rootElement.setAttributeNode(FolioControl);

    org.w3c.dom.Attr tipoCertificado = doc.createAttribute("tipoCertificado");
    tipoCertificado.setValue("1.0");
    rootElement.setAttributeNode(tipoCertificado);

    org.w3c.dom.Attr attr = doc.createAttribute("xmlns");
    attr.setValue("https://www.siged.sep.gob.mx/certificados");
    rootElement.setAttributeNode(attr);

    org.w3c.dom.Attr attr2 = doc.createAttribute("xmlns:xsi");
    attr2.setValue("http://www.w3.org/2001/XMLSchema-instance");
    rootElement.setAttributeNode(attr2);

  }

}
