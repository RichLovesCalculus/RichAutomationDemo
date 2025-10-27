
package com.framework.locators;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "usernameField",
    "passwordField",
    "loginButton"
})
@Generated("jsonschema2pojo")
public class Properties {

    @JsonProperty("usernameField")
    private UsernameField usernameField;
    @JsonProperty("passwordField")
    private PasswordField passwordField;
    @JsonProperty("loginButton")
    private LoginButton loginButton;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("usernameField")
    public UsernameField getUsernameField() {
        return usernameField;
    }

    @JsonProperty("usernameField")
    public void setUsernameField(UsernameField usernameField) {
        this.usernameField = usernameField;
    }

    @JsonProperty("passwordField")
    public PasswordField getPasswordField() {
        return passwordField;
    }

    @JsonProperty("passwordField")
    public void setPasswordField(PasswordField passwordField) {
        this.passwordField = passwordField;
    }

    @JsonProperty("loginButton")
    public LoginButton getLoginButton() {
        return loginButton;
    }

    @JsonProperty("loginButton")
    public void setLoginButton(LoginButton loginButton) {
        this.loginButton = loginButton;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Properties.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("usernameField");
        sb.append('=');
        sb.append(((this.usernameField == null)?"<null>":this.usernameField));
        sb.append(',');
        sb.append("passwordField");
        sb.append('=');
        sb.append(((this.passwordField == null)?"<null>":this.passwordField));
        sb.append(',');
        sb.append("loginButton");
        sb.append('=');
        sb.append(((this.loginButton == null)?"<null>":this.loginButton));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.usernameField == null)? 0 :this.usernameField.hashCode()));
        result = ((result* 31)+((this.passwordField == null)? 0 :this.passwordField.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.loginButton == null)? 0 :this.loginButton.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Properties) == false) {
            return false;
        }
        Properties rhs = ((Properties) other);
        return (((((this.usernameField == rhs.usernameField)||((this.usernameField!= null)&&this.usernameField.equals(rhs.usernameField)))&&((this.passwordField == rhs.passwordField)||((this.passwordField!= null)&&this.passwordField.equals(rhs.passwordField))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.loginButton == rhs.loginButton)||((this.loginButton!= null)&&this.loginButton.equals(rhs.loginButton))));
    }

}
