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
 * CellMetrics
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-06-03T17:02:57.461268288+08:00[Asia/Shanghai]", comments = "Generator version: 7.8.0")
public class CellMetrics {

  private Double maxImpedanceStdDev;

  private Double minImpedanceStdDev;

  private Double maxAbsImpedance;

  private Double minAbsImpedance;

  private Double maxCoefficientOfVariation;

  private Double minCoefficientOfVariation;

  private Double absImpedanceMean;

  private Double impedanceStdDev;

  private Double coefficientOfVariation;

  private Double impedanceMeanToMaxRatio;

  private Double impedanceMeanToMinRatio;

  private Double impedanceMeanToAvgRatio;

  private Double impedanceStdDevToMaxRatio;

  private Double impedanceStdDevToMinRatio;

  private Double impedanceStdDevToAvgRatio;

  public CellMetrics maxImpedanceStdDev(Double maxImpedanceStdDev) {
    this.maxImpedanceStdDev = maxImpedanceStdDev;
    return this;
  }

  /**
   * Get maxImpedanceStdDev
   * @return maxImpedanceStdDev
   */
  
  @Schema(name = "maxImpedanceStdDev", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("maxImpedanceStdDev")
  public Double getMaxImpedanceStdDev() {
    return maxImpedanceStdDev;
  }

  public void setMaxImpedanceStdDev(Double maxImpedanceStdDev) {
    this.maxImpedanceStdDev = maxImpedanceStdDev;
  }

  public CellMetrics minImpedanceStdDev(Double minImpedanceStdDev) {
    this.minImpedanceStdDev = minImpedanceStdDev;
    return this;
  }

  /**
   * Get minImpedanceStdDev
   * @return minImpedanceStdDev
   */
  
  @Schema(name = "minImpedanceStdDev", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("minImpedanceStdDev")
  public Double getMinImpedanceStdDev() {
    return minImpedanceStdDev;
  }

  public void setMinImpedanceStdDev(Double minImpedanceStdDev) {
    this.minImpedanceStdDev = minImpedanceStdDev;
  }

  public CellMetrics maxAbsImpedance(Double maxAbsImpedance) {
    this.maxAbsImpedance = maxAbsImpedance;
    return this;
  }

  /**
   * Get maxAbsImpedance
   * @return maxAbsImpedance
   */
  
  @Schema(name = "maxAbsImpedance", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("maxAbsImpedance")
  public Double getMaxAbsImpedance() {
    return maxAbsImpedance;
  }

  public void setMaxAbsImpedance(Double maxAbsImpedance) {
    this.maxAbsImpedance = maxAbsImpedance;
  }

  public CellMetrics minAbsImpedance(Double minAbsImpedance) {
    this.minAbsImpedance = minAbsImpedance;
    return this;
  }

  /**
   * Get minAbsImpedance
   * @return minAbsImpedance
   */
  
  @Schema(name = "minAbsImpedance", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("minAbsImpedance")
  public Double getMinAbsImpedance() {
    return minAbsImpedance;
  }

  public void setMinAbsImpedance(Double minAbsImpedance) {
    this.minAbsImpedance = minAbsImpedance;
  }

  public CellMetrics maxCoefficientOfVariation(Double maxCoefficientOfVariation) {
    this.maxCoefficientOfVariation = maxCoefficientOfVariation;
    return this;
  }

  /**
   * Get maxCoefficientOfVariation
   * @return maxCoefficientOfVariation
   */
  
  @Schema(name = "maxCoefficientOfVariation", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("maxCoefficientOfVariation")
  public Double getMaxCoefficientOfVariation() {
    return maxCoefficientOfVariation;
  }

  public void setMaxCoefficientOfVariation(Double maxCoefficientOfVariation) {
    this.maxCoefficientOfVariation = maxCoefficientOfVariation;
  }

  public CellMetrics minCoefficientOfVariation(Double minCoefficientOfVariation) {
    this.minCoefficientOfVariation = minCoefficientOfVariation;
    return this;
  }

  /**
   * Get minCoefficientOfVariation
   * @return minCoefficientOfVariation
   */
  
  @Schema(name = "minCoefficientOfVariation", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("minCoefficientOfVariation")
  public Double getMinCoefficientOfVariation() {
    return minCoefficientOfVariation;
  }

  public void setMinCoefficientOfVariation(Double minCoefficientOfVariation) {
    this.minCoefficientOfVariation = minCoefficientOfVariation;
  }

  public CellMetrics absImpedanceMean(Double absImpedanceMean) {
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

  public CellMetrics impedanceStdDev(Double impedanceStdDev) {
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

  public CellMetrics coefficientOfVariation(Double coefficientOfVariation) {
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

  public CellMetrics impedanceMeanToMaxRatio(Double impedanceMeanToMaxRatio) {
    this.impedanceMeanToMaxRatio = impedanceMeanToMaxRatio;
    return this;
  }

  /**
   * Get impedanceMeanToMaxRatio
   * @return impedanceMeanToMaxRatio
   */
  
  @Schema(name = "impedanceMeanToMaxRatio", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("impedanceMeanToMaxRatio")
  public Double getImpedanceMeanToMaxRatio() {
    return impedanceMeanToMaxRatio;
  }

  public void setImpedanceMeanToMaxRatio(Double impedanceMeanToMaxRatio) {
    this.impedanceMeanToMaxRatio = impedanceMeanToMaxRatio;
  }

  public CellMetrics impedanceMeanToMinRatio(Double impedanceMeanToMinRatio) {
    this.impedanceMeanToMinRatio = impedanceMeanToMinRatio;
    return this;
  }

  /**
   * Get impedanceMeanToMinRatio
   * @return impedanceMeanToMinRatio
   */
  
  @Schema(name = "impedanceMeanToMinRatio", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("impedanceMeanToMinRatio")
  public Double getImpedanceMeanToMinRatio() {
    return impedanceMeanToMinRatio;
  }

  public void setImpedanceMeanToMinRatio(Double impedanceMeanToMinRatio) {
    this.impedanceMeanToMinRatio = impedanceMeanToMinRatio;
  }

  public CellMetrics impedanceMeanToAvgRatio(Double impedanceMeanToAvgRatio) {
    this.impedanceMeanToAvgRatio = impedanceMeanToAvgRatio;
    return this;
  }

  /**
   * Get impedanceMeanToAvgRatio
   * @return impedanceMeanToAvgRatio
   */
  
  @Schema(name = "impedanceMeanToAvgRatio", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("impedanceMeanToAvgRatio")
  public Double getImpedanceMeanToAvgRatio() {
    return impedanceMeanToAvgRatio;
  }

  public void setImpedanceMeanToAvgRatio(Double impedanceMeanToAvgRatio) {
    this.impedanceMeanToAvgRatio = impedanceMeanToAvgRatio;
  }

  public CellMetrics impedanceStdDevToMaxRatio(Double impedanceStdDevToMaxRatio) {
    this.impedanceStdDevToMaxRatio = impedanceStdDevToMaxRatio;
    return this;
  }

  /**
   * Get impedanceStdDevToMaxRatio
   * @return impedanceStdDevToMaxRatio
   */
  
  @Schema(name = "impedanceStdDevToMaxRatio", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("impedanceStdDevToMaxRatio")
  public Double getImpedanceStdDevToMaxRatio() {
    return impedanceStdDevToMaxRatio;
  }

  public void setImpedanceStdDevToMaxRatio(Double impedanceStdDevToMaxRatio) {
    this.impedanceStdDevToMaxRatio = impedanceStdDevToMaxRatio;
  }

  public CellMetrics impedanceStdDevToMinRatio(Double impedanceStdDevToMinRatio) {
    this.impedanceStdDevToMinRatio = impedanceStdDevToMinRatio;
    return this;
  }

  /**
   * Get impedanceStdDevToMinRatio
   * @return impedanceStdDevToMinRatio
   */
  
  @Schema(name = "impedanceStdDevToMinRatio", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("impedanceStdDevToMinRatio")
  public Double getImpedanceStdDevToMinRatio() {
    return impedanceStdDevToMinRatio;
  }

  public void setImpedanceStdDevToMinRatio(Double impedanceStdDevToMinRatio) {
    this.impedanceStdDevToMinRatio = impedanceStdDevToMinRatio;
  }

  public CellMetrics impedanceStdDevToAvgRatio(Double impedanceStdDevToAvgRatio) {
    this.impedanceStdDevToAvgRatio = impedanceStdDevToAvgRatio;
    return this;
  }

  /**
   * Get impedanceStdDevToAvgRatio
   * @return impedanceStdDevToAvgRatio
   */
  
  @Schema(name = "impedanceStdDevToAvgRatio", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("impedanceStdDevToAvgRatio")
  public Double getImpedanceStdDevToAvgRatio() {
    return impedanceStdDevToAvgRatio;
  }

  public void setImpedanceStdDevToAvgRatio(Double impedanceStdDevToAvgRatio) {
    this.impedanceStdDevToAvgRatio = impedanceStdDevToAvgRatio;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CellMetrics cellMetrics = (CellMetrics) o;
    return Objects.equals(this.maxImpedanceStdDev, cellMetrics.maxImpedanceStdDev) &&
        Objects.equals(this.minImpedanceStdDev, cellMetrics.minImpedanceStdDev) &&
        Objects.equals(this.maxAbsImpedance, cellMetrics.maxAbsImpedance) &&
        Objects.equals(this.minAbsImpedance, cellMetrics.minAbsImpedance) &&
        Objects.equals(this.maxCoefficientOfVariation, cellMetrics.maxCoefficientOfVariation) &&
        Objects.equals(this.minCoefficientOfVariation, cellMetrics.minCoefficientOfVariation) &&
        Objects.equals(this.absImpedanceMean, cellMetrics.absImpedanceMean) &&
        Objects.equals(this.impedanceStdDev, cellMetrics.impedanceStdDev) &&
        Objects.equals(this.coefficientOfVariation, cellMetrics.coefficientOfVariation) &&
        Objects.equals(this.impedanceMeanToMaxRatio, cellMetrics.impedanceMeanToMaxRatio) &&
        Objects.equals(this.impedanceMeanToMinRatio, cellMetrics.impedanceMeanToMinRatio) &&
        Objects.equals(this.impedanceMeanToAvgRatio, cellMetrics.impedanceMeanToAvgRatio) &&
        Objects.equals(this.impedanceStdDevToMaxRatio, cellMetrics.impedanceStdDevToMaxRatio) &&
        Objects.equals(this.impedanceStdDevToMinRatio, cellMetrics.impedanceStdDevToMinRatio) &&
        Objects.equals(this.impedanceStdDevToAvgRatio, cellMetrics.impedanceStdDevToAvgRatio);
  }

  @Override
  public int hashCode() {
    return Objects.hash(maxImpedanceStdDev, minImpedanceStdDev, maxAbsImpedance, minAbsImpedance, maxCoefficientOfVariation, minCoefficientOfVariation, absImpedanceMean, impedanceStdDev, coefficientOfVariation, impedanceMeanToMaxRatio, impedanceMeanToMinRatio, impedanceMeanToAvgRatio, impedanceStdDevToMaxRatio, impedanceStdDevToMinRatio, impedanceStdDevToAvgRatio);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CellMetrics {\n");
    sb.append("    maxImpedanceStdDev: ").append(toIndentedString(maxImpedanceStdDev)).append("\n");
    sb.append("    minImpedanceStdDev: ").append(toIndentedString(minImpedanceStdDev)).append("\n");
    sb.append("    maxAbsImpedance: ").append(toIndentedString(maxAbsImpedance)).append("\n");
    sb.append("    minAbsImpedance: ").append(toIndentedString(minAbsImpedance)).append("\n");
    sb.append("    maxCoefficientOfVariation: ").append(toIndentedString(maxCoefficientOfVariation)).append("\n");
    sb.append("    minCoefficientOfVariation: ").append(toIndentedString(minCoefficientOfVariation)).append("\n");
    sb.append("    absImpedanceMean: ").append(toIndentedString(absImpedanceMean)).append("\n");
    sb.append("    impedanceStdDev: ").append(toIndentedString(impedanceStdDev)).append("\n");
    sb.append("    coefficientOfVariation: ").append(toIndentedString(coefficientOfVariation)).append("\n");
    sb.append("    impedanceMeanToMaxRatio: ").append(toIndentedString(impedanceMeanToMaxRatio)).append("\n");
    sb.append("    impedanceMeanToMinRatio: ").append(toIndentedString(impedanceMeanToMinRatio)).append("\n");
    sb.append("    impedanceMeanToAvgRatio: ").append(toIndentedString(impedanceMeanToAvgRatio)).append("\n");
    sb.append("    impedanceStdDevToMaxRatio: ").append(toIndentedString(impedanceStdDevToMaxRatio)).append("\n");
    sb.append("    impedanceStdDevToMinRatio: ").append(toIndentedString(impedanceStdDevToMinRatio)).append("\n");
    sb.append("    impedanceStdDevToAvgRatio: ").append(toIndentedString(impedanceStdDevToAvgRatio)).append("\n");
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

