//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.0 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2022.09.05 a las 03:47:55 PM CDT 
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
 *         &lt;element name="idMotivoCancelacion" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *         &lt;element name="autenticacion" type="{http://ws.web.mec.sep.mx/schemas}autenticacionType"/&gt;
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
    "idMotivoCancelacion",
    "autenticacion"
})
@XmlRootElement(name = "cancelarLoteCertificadosRequest")
public class CancelarLoteCertificadosRequest {

    @XmlElement(required = true)
    protected BigInteger numeroLote;
    @XmlElement(required = true)
    protected BigInteger idMotivoCancelacion;
    @XmlElement(required = true)
    protected AutenticacionType autenticacion;

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
     * Obtiene el valor de la propiedad idMotivoCancelacion.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getIdMotivoCancelacion() {
        return idMotivoCancelacion;
    }

    /**
     * Define el valor de la propiedad idMotivoCancelacion.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setIdMotivoCancelacion(BigInteger value) {
        this.idMotivoCancelacion = value;
    }

    /**
     * Obtiene el valor de la propiedad autenticacion.
     * 
     * @return
     *     possible object is
     *     {@link AutenticacionType }
     *     
     */
    public AutenticacionType getAutenticacion() {
        return autenticacion;
    }

    /**
     * Define el valor de la propiedad autenticacion.
     * 
     * @param value
     *     allowed object is
     *     {@link AutenticacionType }
     *     
     */
    public void setAutenticacion(AutenticacionType value) {
        this.autenticacion = value;
    }

}
