
package highscore.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="quiz">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="overview" type="{}overview" minOccurs="0"/>
 *         &lt;element name="categories" type="{}categories" minOccurs="0"/>
 *         &lt;element name="questions" type="{}questions" minOccurs="0"/>
 *         &lt;element name="users" type="{}users" minOccurs="0"/>
 *         &lt;element name="games" type="{}games" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "quiz", propOrder = {
    "overview",
    "categories",
    "questions",
    "users",
    "games"
})
public class Quiz {

    protected Overview overview;
    protected Categories categories;
    protected Questions questions;
    protected Users users;
    protected Games games;

    /**
     * Ruft den Wert der overview-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Overview }
     *     
     */
    public Overview getOverview() {
        return overview;
    }

    /**
     * Legt den Wert der overview-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Overview }
     *     
     */
    public void setOverview(Overview value) {
        this.overview = value;
    }

    /**
     * Ruft den Wert der categories-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Categories }
     *     
     */
    public Categories getCategories() {
        return categories;
    }

    /**
     * Legt den Wert der categories-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Categories }
     *     
     */
    public void setCategories(Categories value) {
        this.categories = value;
    }

    /**
     * Ruft den Wert der questions-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Questions }
     *     
     */
    public Questions getQuestions() {
        return questions;
    }

    /**
     * Legt den Wert der questions-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Questions }
     *     
     */
    public void setQuestions(Questions value) {
        this.questions = value;
    }

    /**
     * Ruft den Wert der users-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Users }
     *     
     */
    public Users getUsers() {
        return users;
    }

    /**
     * Legt den Wert der users-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Users }
     *     
     */
    public void setUsers(Users value) {
        this.users = value;
    }

    /**
     * Ruft den Wert der games-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Games }
     *     
     */
    public Games getGames() {
        return games;
    }

    /**
     * Legt den Wert der games-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Games }
     *     
     */
    public void setGames(Games value) {
        this.games = value;
    }

}
