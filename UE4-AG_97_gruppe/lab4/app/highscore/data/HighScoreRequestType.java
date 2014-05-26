
package highscore.data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import highscore.generated.Quiz;


/**
 * <p>Java-Klasse.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="HighScoreRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://big.tuwien.ac.at/we/highscore/data}UserKey"/>
 *         &lt;element ref="{}quiz"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HighScoreRequestType", propOrder = {
    "userKey",
    "quiz"
})
public class HighScoreRequestType {

    @XmlElement(name = "UserKey", required = true)
    protected String userKey;
    @XmlElement(namespace = "", required = true)
    protected Quiz quiz;

    /**
     * Ruft den Wert der userKey-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserKey() {
        return userKey;
    }

    /**
     * Legt den Wert der userKey-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserKey(String value) {
        this.userKey = value;
    }

    /**
     * Ruft den Wert der quiz-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Quiz }
     *     
     */
    public Quiz getQuiz() {
        return quiz;
    }

    /**
     * Legt den Wert der quiz-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Quiz }
     *     
     */
    public void setQuiz(Quiz value) {
        this.quiz = value;
    }

}
