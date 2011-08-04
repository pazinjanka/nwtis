
package net.wxbug.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetForecastIssueDetailsByCityCodeResult" type="{http://api.wxbug.net/}ApiForecastIssueData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getForecastIssueDetailsByCityCodeResult"
})
@XmlRootElement(name = "GetForecastIssueDetailsByCityCodeResponse")
public class GetForecastIssueDetailsByCityCodeResponse {

    @XmlElement(name = "GetForecastIssueDetailsByCityCodeResult")
    protected ApiForecastIssueData getForecastIssueDetailsByCityCodeResult;

    /**
     * Gets the value of the getForecastIssueDetailsByCityCodeResult property.
     * 
     * @return
     *     possible object is
     *     {@link ApiForecastIssueData }
     *     
     */
    public ApiForecastIssueData getGetForecastIssueDetailsByCityCodeResult() {
        return getForecastIssueDetailsByCityCodeResult;
    }

    /**
     * Sets the value of the getForecastIssueDetailsByCityCodeResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ApiForecastIssueData }
     *     
     */
    public void setGetForecastIssueDetailsByCityCodeResult(ApiForecastIssueData value) {
        this.getForecastIssueDetailsByCityCodeResult = value;
    }

}
