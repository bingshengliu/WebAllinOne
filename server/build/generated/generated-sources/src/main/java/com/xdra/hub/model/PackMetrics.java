package com.xdra.hub.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.xdra.hub.model.DegradationLevel;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * PackMetrics
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-06-03T17:02:57.461268288+08:00[Asia/Shanghai]", comments = "Generator version: 7.8.0")
public class PackMetrics {

  private Double absImpedanceMean;

  private Double impedanceStdDev;

  private Double coefficientOfVariation;

  private Double dispersion;

  private DegradationLevel degradationLevel;

  public PackMetrics absImpedanceMean(Double absImpedanceMean) {
    this.absImpedanceMean = absImpedanceMean;
    return this;
  }

  /**
   * Get absImpedanceMean
   * @return absImpedanceMean
   */
  
  @Schema(name = "absImpedanceMean", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("absImpedanceMean")
  public Double getAbsImpedanceMean() {
    return absImpedanceMean;
  }

  public void setAbsImpedanceMean(Double absImpedanceMean) {
    this.absImpedanceMean = absImpedanceMean;
  }

  public PackMetrics impedanceStdDev(Double impedanceStdDev) {
    this.impedanceStdDev = impedanceStdDev;
    return this;
  }

  /**
   * Get impedanceStdDev
   * @return impedanceStdDev
   */
  
  @Schema(name = "impedanceStdDev", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("impedanceStdDev")
  public Double getImpedanceStdDev() {
    return impedanceStdDev;
  }

  public void setImpedanceStdDev(Double impedanceStdDev) {
    this.impedanceStdDev = impedanceStdDev;
  }

  public PackMetrics coefficientOfVariation(Double coefficientOfVariation) {
    this.coefficientOfVariation = coefficientOfVariation;
    return this;
  }

  /**
   * Get coefficientOfVariation
   * @return coefficientOfVariation
   */
  
  @Schema(name = "coefficientOfVariation", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("coefficientOfVariation")
  public Double getCoefficientOfVariation() {
    return coefficientOfVariation;
  }

  public void setCoefficientOfVariation(Double coefficientOfVariation) {
    this.coefficientOfVariation = coefficientOfVariation;
  }

  public PackMetrics dispersion(Double dispersion) {
    this.dispersion = dispersion;
    return this;
  }

  /**
   * Get dispersion
   * @return dispersion
   */
  
  @Schema(name = "dispersion", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("dispersion")
  public Double getDispersion() {
    return dispersion;
  }

  public void setDispersion(Double dispersion) {
    this.dispersion = dispersion;
  }

  public PackMetrics degradationLevel(DegradationLevel degradationLevel) {
    this.degradationLevel = degradationLevel;
    return this;
  }

  /**
   * Get degradationLevel
   * @return degradationLevel
   */
  @Valid 
  @Schema(name = "degradationLevel", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("degradationLevel")
  public DegradationLevel getDegradationLevel() {
    return degradationLevel;
  }

  public void setDegradationLevel(DegradationLevel degradationLevel) {
    this.degradationLevel = degradationLevel;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PackMetrics packMetrics = (PackMetrics) o;
    return Objects.equals(this.absImpedanceMean, packMetrics.absImpedanceMean) &&
        Objects.equals(this.impedanceStdDev, packMetrics.impedanceStdDev) &&
        Objects.equals(this.coefficientOfVariation, packMetrics.coefficientOfVariation) &&
        Objects.equals(this.dispersion, packMetrics.dispersion) &&
        Objects.equals(this.degradationLevel, packMetrics.degradationLevel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(absImpedanceMean, impedanceStdDev, coefficientOfVariation, dispersion, degradationLevel);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PackMetrics {\n");
    sb.append("    absImpedanceMean: ").append(toIndentedString(absImpedanceMean)).append("\n");
    sb.append("    impedanceStdDev: ").append(toIndentedString(impedanceStdDev)).append("\n");
    sb.append("    coefficientOfVariation: ").append(toIndentedString(coefficientOfVariation)).append("\n");
    sb.append("    dispersion: ").append(toIndentedString(dispersion)).append("\n");
    sb.append("    degradationLevel: ").append(toIndentedString(degradationLevel)).append("\n");
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

