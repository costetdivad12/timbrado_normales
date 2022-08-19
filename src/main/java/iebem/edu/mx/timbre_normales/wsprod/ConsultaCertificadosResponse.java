//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.0 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2022.08.19 a las 12:08:36 PM CDT 
//


package iebem.edu.mx.timbre_normales.wsprod;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="numeroLote" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *         &lt;element name="estatusLote" type="{http://www.w3.org/2001/XMLSchema}short"/&gt;
 *         &lt;element name="mensaje" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="excelBase64" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "numeroLote",
    "estatusLote",
    "mensaje",
    "excelBase64"
})
@XmlRootElement(name = "consultaCertificadosResponse")
public class ConsultaCertificadosResponse {

    @XmlElement(required = true)
    protected BigInteger numeroLote;
    protected short estatusLote;
    protected String mensaje;
    protected byte[] excelBase64;

    /**
     * Obtiene el valor de la propiedad numeroLote.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumeroLote() {
        return numeroLote;
    }

    /**
     * Define el valor de la propiedad numeroLote.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumeroLote(BigInteger value) {
        this.numeroLote = value;
    }

    /**
     * Obtiene el valor de la propiedad estatusLote.
     * 
     */
    public short getEstatusLote() {
        return estatusLote;
    }

    /**
     * Define el valor de la propiedad estatusLote.
     * 
     */
    public void setEstatusLote(short value) {
        this.estatusLote = value;
    }

    /**
     * Obtiene el valor de la propiedad mensaje.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * Define el valor de la propiedad mensaje.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMensaje(String value) {
        this.mensaje = value;
    }

    /**
     * Obtiene el valor de la propiedad excelBase64.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getExcelBase64() {
        return excelBase64;
    }

    /**
     * Define el valor de la propiedad excelBase64.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setExcelBase64(byte[] value) {
        this.excelBase64 = value;
    }

}
