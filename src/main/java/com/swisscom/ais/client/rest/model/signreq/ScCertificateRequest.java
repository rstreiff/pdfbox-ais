
package com.swisscom.ais.client.rest.model.signreq;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "sc.DistinguishedName",
    "sc.StepUpAuthorisation"
})
public class ScCertificateRequest {

    @JsonProperty("sc.DistinguishedName")
    private String scDistinguishedName;
    @JsonProperty("sc.StepUpAuthorisation")
    private ScStepUpAuthorisation scStepUpAuthorisation;

    @JsonProperty("sc.DistinguishedName")
    public String getScDistinguishedName() {
        return scDistinguishedName;
    }

    @JsonProperty("sc.DistinguishedName")
    public void setScDistinguishedName(String scDistinguishedName) {
        this.scDistinguishedName = scDistinguishedName;
    }

    public ScCertificateRequest withScDistinguishedName(String scDistinguishedName) {
        this.scDistinguishedName = scDistinguishedName;
        return this;
    }

    @JsonProperty("sc.StepUpAuthorisation")
    public ScStepUpAuthorisation getScStepUpAuthorisation() {
        return scStepUpAuthorisation;
    }

    @JsonProperty("sc.StepUpAuthorisation")
    public void setScStepUpAuthorisation(ScStepUpAuthorisation scStepUpAuthorisation) {
        this.scStepUpAuthorisation = scStepUpAuthorisation;
    }

    public ScCertificateRequest withScStepUpAuthorisation(ScStepUpAuthorisation scStepUpAuthorisation) {
        this.scStepUpAuthorisation = scStepUpAuthorisation;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ScCertificateRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("scDistinguishedName");
        sb.append('=');
        sb.append(((this.scDistinguishedName == null)?"<null>":this.scDistinguishedName));
        sb.append(',');
        sb.append("scStepUpAuthorisation");
        sb.append('=');
        sb.append(((this.scStepUpAuthorisation == null)?"<null>":this.scStepUpAuthorisation));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
