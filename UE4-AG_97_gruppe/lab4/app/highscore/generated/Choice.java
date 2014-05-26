
package highscore.generated;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java-Klasse
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="choice">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *       &lt;attribute name="nr" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *       &lt;attribute name="correct" type="{}correct" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "choice", propOrder = {
    "value"
})
public class Choice {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "nr", required = true)
    protected BigDecimal nr;
    @XmlAttribute(name = "correct")
    protected Correct correct;

    /**
     * Ruft den Wert der value-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Legt den Wert der value-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Ruft den Wert der nr-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getNr() {
        return nr;
    }

    /**
     * Legt den Wert der nr-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setNr(BigDecimal value) {
        this.nr = value;
    }

    /**
     * Ruft den Wert der correct-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Correct }
     *     
     */
    public Correct getCorrect() {
        return correct;
    }

    /**
     * Legt den Wert der correct-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Correct }
     *     
     */
    public void setCorrect(Correct value) {
        this.correct = value;
    }

}
