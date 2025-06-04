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
 * NyquistPlotPoint
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-06-03T17:02:57.461268288+08:00[Asia/Shanghai]", comments = "Generator version: 7.8.0")
public class NyquistPlotPoint {

  private Double realImpedance;

  private Double imaginaryImpedance;

  public NyquistPlotPoint realImpedance(Double realImpedance) {
    this.realImpedance = realImpedance;
    return this;
  }

  /**
   * Get realImpedance
   * @return realImpedance
   */
  
  @Schema(name = "realImpedance", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("realImpedance")
  public Double getRealImpedance() {
    return realImpedance;
  }

  public void setRealImpedance(Double realImpedance) {
    this.realImpedance = realImpedance;
  }

  public NyquistPlotPoint imaginaryImpedance(Double imaginaryImpedance) {
    this.imaginaryImpedance = imaginaryImpedance;
    return this;
  }

  /**
   * Get imaginaryImpedance
   * @return imaginaryImpedance
   */
  
  @Schema(name = "imaginaryImpedance", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("imaginaryImpedance")
  public Double getImaginaryImpedance() {
    return imaginaryImpedance;
  }

  public void setImaginaryImpedance(Double imaginaryImpedance) {
    this.imaginaryImpedance = imaginaryImpedance;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NyquistPlotPoint nyquistPlotPoint = (NyquistPlotPoint) o;
    return Objects.equals(this.realImpedance, nyquistPlotPoint.realImpedance) &&
        Objects.equals(this.imaginaryImpedance, nyquistPlotPoint.imaginaryImpedance);
  }

  @Override
  public int hashCode() {
    return Objects.hash(realImpedance, imaginaryImpedance);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NyquistPlotPoint {\n");
    sb.append("    realImpedance: ").append(toIndentedString(realImpedance)).append("\n");
    sb.append("    imaginaryImpedance: ").append(toIndentedString(imaginaryImpedance)).append("\n");
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

