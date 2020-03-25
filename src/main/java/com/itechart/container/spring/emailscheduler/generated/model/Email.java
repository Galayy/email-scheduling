package com.itechart.container.spring.emailscheduler.generated.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import java.util.Objects;
import java.util.UUID;

/**
 * Email
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-03-25T16:30:20.677955+03:00[Europe/Minsk]")

public class Email {
    @JsonProperty("id")
    private UUID id;

    @JsonProperty("emailAddress")
    private String emailAddress;

    @JsonProperty("lastSentAt")
    private java.time.Instant lastSentAt;

    public Email id(UUID id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     *
     * @return id
     */
    @ApiModelProperty(readOnly = true, value = "")

    @Valid

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Email emailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    /**
     * Get emailAddress
     *
     * @return emailAddress
     */
    @ApiModelProperty(value = "")


    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Email lastSentAt(java.time.Instant lastSentAt) {
        this.lastSentAt = lastSentAt;
        return this;
    }

    /**
     * Get lastSentAt
     *
     * @return lastSentAt
     */
    @ApiModelProperty(readOnly = true, value = "")

    @Valid

    public java.time.Instant getLastSentAt() {
        return lastSentAt;
    }

    public void setLastSentAt(java.time.Instant lastSentAt) {
        this.lastSentAt = lastSentAt;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Email email = (Email) o;
        return Objects.equals(this.id, email.id) &&
                Objects.equals(this.emailAddress, email.emailAddress) &&
                Objects.equals(this.lastSentAt, email.lastSentAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, emailAddress, lastSentAt);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Email {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    emailAddress: ").append(toIndentedString(emailAddress)).append("\n");
        sb.append("    lastSentAt: ").append(toIndentedString(lastSentAt)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}

