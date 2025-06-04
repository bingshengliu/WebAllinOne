package com.xdra.hub.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * CharacteristicFrequencies
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-06-03T17:02:57.461268288+08:00[Asia/Shanghai]", comments = "Generator version: 7.8.0")
public class CharacteristicFrequencies {

  private Double impedance10Hz;

  private Double impedance10000Hz;

  public CharacteristicFrequencies impedance10Hz(Double impedance10Hz) {
    this.impedance10Hz = impedance10Hz;
    return this;
  }

  /**
   * Get impedance10Hz
   * @return impedance10Hz
   */
  
  @Schema(name = "impedance10Hz", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("impedance10Hz")
  public Double getImpedance10Hz() {
    return impedance10Hz;
  }

  public void setImpedance10Hz(Double impedance10Hz) {
    this.impedance10Hz = impedance10Hz;
  }

  public CharacteristicFrequencies impedance10000Hz(Double impedance10000Hz) {
    this.impedance10000Hz = impedance10000Hz;
    return this;
  }

  /**
   * Get impedance10000Hz
   * @return impedance10000Hz
   */
  
  @Schema(name = "impedance10000Hz", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("impedance10000Hz")
  public Double getImpedance10000Hz() {
    return impedance10000Hz;
  }

  public void setImpedance10000Hz(Double impedance10000Hz) {
    this.impedance10000Hz = impedance10000Hz;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CharacteristicFrequencies characteristicFrequencies = (CharacteristicFrequencies) o;
    return Objects.equals(this.impedance10Hz, characteristicFrequencies.impedance10Hz) &&
        Objects.equals(this.impedance10000Hz, characteristicFrequencies.impedance10000Hz);
  }

  @Override
  public int hashCode() {
    return Objects.hash(impedance10Hz, impedance10000Hz);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CharacteristicFrequencies {\n");
    sb.append("    impedance10Hz: ").append(toIndentedString(impedance10Hz)).append("\n");
    sb.append("    impedance10000Hz: ").append(toIndentedString(impedance10000Hz)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

