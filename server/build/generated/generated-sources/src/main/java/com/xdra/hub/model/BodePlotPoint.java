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
 * BodePlotPoint
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-06-03T17:02:57.461268288+08:00[Asia/Shanghai]", comments = "Generator version: 7.8.0")
public class BodePlotPoint {

  private Double frequency;

  private Double phase;

  private Double amplitude;

  public BodePlotPoint frequency(Double frequency) {
    this.frequency = frequency;
    return this;
  }

  /**
   * Get frequency
   * @return frequency
   */
  
  @Schema(name = "frequency", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("frequency")
  public Double getFrequency() {
    return frequency;
  }

  public void setFrequency(Double frequency) {
    this.frequency = frequency;
  }

  public BodePlotPoint phase(Double phase) {
    this.phase = phase;
    return this;
  }

  /**
   * Get phase
   * @return phase
   */
  
  @Schema(name = "phase", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("phase")
  public Double getPhase() {
    return phase;
  }

  public void setPhase(Double phase) {
    this.phase = phase;
  }

  public BodePlotPoint amplitude(Double amplitude) {
    this.amplitude = amplitude;
    return this;
  }

  /**
   * Get amplitude
   * @return amplitude
   */
  
  @Schema(name = "amplitude", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("amplitude")
  public Double getAmplitude() {
    return amplitude;
  }

  public void setAmplitude(Double amplitude) {
    this.amplitude = amplitude;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BodePlotPoint bodePlotPoint = (BodePlotPoint) o;
    return Objects.equals(this.frequency, bodePlotPoint.frequency) &&
        Objects.equals(this.phase, bodePlotPoint.phase) &&
        Objects.equals(this.amplitude, bodePlotPoint.amplitude);
  }

  @Override
  public int hashCode() {
    return Objects.hash(frequency, phase, amplitude);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BodePlotPoint {\n");
    sb.append("    frequency: ").append(toIndentedString(frequency)).append("\n");
    sb.append("    phase: ").append(toIndentedString(phase)).append("\n");
    sb.append("    amplitude: ").append(toIndentedString(amplitude)).append("\n");
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

