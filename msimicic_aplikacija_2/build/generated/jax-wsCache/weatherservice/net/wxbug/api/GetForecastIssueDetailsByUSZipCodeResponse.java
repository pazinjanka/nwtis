
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
 *         &lt;element name="GetForecastIssueDetailsByUSZipCodeResult" type="{http://api.wxbug.net/}ApiForecastIssueData" minOccurs="0"/>
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
    "getForecastIssueDetailsByUSZipCodeResult"
})
@XmlRootElement(name = "GetForecastIssueDetailsByUSZipCodeResponse")
public class GetForecastIssueDetailsByUSZipCodeResponse {

    @XmlElement(name = "GetForecastIssueDetailsByUSZipCodeResult")
    protected ApiForecastIssueData getForecastIssueDetailsByUSZipCodeResult;

    /**
     * Gets the value of the getForecastIssueDetailsByUSZipCodeResult property.
     * 
     * @return
     *     possible object is
     *     {@link ApiForecastIssueData }
     *     
     */
    public ApiForecastIssueData getGetForecastIssueDetailsByUSZipCodeResult() {
        return getForecastIssueDetailsByUSZipCodeResult;
    }

    /**
     * Sets the value of the getForecastIssueDetailsByUSZipCodeResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ApiForecastIssueData }
     *     
     */
    public void setGetForecastIssueDetailsByUSZipCodeResult(ApiForecastIssueData value) {
        this.getForecastIssueDetailsByUSZipCodeResult = value;
    }

}
