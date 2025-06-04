package com.xdra.hub.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.xdra.hub.model.CharacteristicFrequencies;
import com.xdra.hub.model.DegradationLevel;
import java.time.OffsetDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * PackStatistics
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-06-03T17:02:57.461268288+08:00[Asia/Shanghai]", comments = "Generator version: 7.8.0")
public class PackStatistics {

  private String containerId;

  private String clusterId;

  private String packId;

  private String realTimeId;

  private Double maxAbsImpedance;

  private Double minAbsImpedance;

  private Double maxCoefficientOfVariation;

  private Double minCoefficientOfVariation;

  private Double maxImpedanceStdDev;

  private Double minImpedanceStdDev;

  private Double temperature;

  private Double absImpedanceMean;

  private Double impedanceStdDev;

  private Double coefficientOfVariation;

  private Double dispersion;

  private DegradationLevel degradationLevel;

  private String suggestion;

  private String alertText;

  private CharacteristicFrequencies characteristicFrequencies;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime creationTime;

  private Object cellColors;

  public PackStatistics containerId(String containerId) {
    this.containerId = containerId;
    return this;
  }

  /**
   * Get containerId
   * @return containerId
   */
  
  @Schema(name = "containerId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("containerId")
  public String getContainerId() {
    return containerId;
  }

  public void setContainerId(String containerId) {
    this.containerId = containerId;
  }

  public PackStatistics clusterId(String clusterId) {
    this.clusterId = clusterId;
    return this;
  }

  /**
   * Get clusterId
   * @return clusterId
   */
  
  @Schema(name = "clusterId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("clusterId")
  public String getClusterId() {
    return clusterId;
  }

  public void setClusterId(String clusterId) {
    this.clusterId = clusterId;
  }

  public PackStatistics packId(String packId) {
    this.packId = packId;
    return this;
  }

  /**
   * Get packId
   * @return packId
   */
  
  @Schema(name = "packId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("packId")
  public String getPackId() {
    return packId;
  }

  public void setPackId(String packId) {
    this.packId = packId;
  }

  public PackStatistics realTimeId(String realTimeId) {
    this.realTimeId = realTimeId;
    return this;
  }

  /**
   * Get realTimeId
   * @return realTimeId
   */
  
  @Schema(name = "realTimeId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("realTimeId")
  public String getRealTimeId() {
    return realTimeId;
  }

  public void setRealTimeId(String realTimeId) {
    this.realTimeId = realTimeId;
  }

  public PackStatistics maxAbsImpedance(Double maxAbsImpedance) {
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

  public PackStatistics minAbsImpedance(Double minAbsImpedance) {
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

  public PackStatistics maxCoefficientOfVariation(Double maxCoefficientOfVariation) {
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

  public PackStatistics minCoefficientOfVariation(Double minCoefficientOfVariation) {
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

  public PackStatistics maxImpedanceStdDev(Double maxImpedanceStdDev) {
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

  public PackStatistics minImpedanceStdDev(Double minImpedanceStdDev) {
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

  public PackStatistics temperature(Double temperature) {
    this.temperature = temperature;
    return this;
  }

  /**
   * Get temperature
   * @return temperature
   */
  
  @Schema(name = "temperature", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("temperature")
  public Double getTemperature() {
    return temperature;
  }

  public void setTemperature(Double temperature) {
    this.temperature = temperature;
  }

  public PackStatistics absImpedanceMean(Double absImpedanceMean) {
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

  public PackStatistics impedanceStdDev(Double impedanceStdDev) {
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

  public PackStatistics coefficientOfVariation(Double coefficientOfVariation) {
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

  public PackStatistics dispersion(Double dispersion) {
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

  public PackStatistics degradationLevel(DegradationLevel degradationLevel) {
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

  public PackStatistics suggestion(String suggestion) {
    this.suggestion = suggestion;
    return this;
  }

  /**
   * Get suggestion
   * @return suggestion
   */
  
  @Schema(name = "suggestion", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("suggestion")
  public String getSuggestion() {
    return suggestion;
  }

  public void setSuggestion(String suggestion) {
    this.suggestion = suggestion;
  }

  public PackStatistics alertText(String alertText) {
    this.alertText = alertText;
    return this;
  }

  /**
   * Get alertText
   * @return alertText
   */
  
  @Schema(name = "alertText", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("alertText")
  public String getAlertText() {
    return alertText;
  }

  public void setAlertText(String alertText) {
    this.alertText = alertText;
  }

  public PackStatistics characteristicFrequencies(CharacteristicFrequencies characteristicFrequencies) {
    this.characteristicFrequencies = characteristicFrequencies;
    return this;
  }

  /**
   * Get characteristicFrequencies
   * @return characteristicFrequencies
   */
  @Valid 
  @Schema(name = "characteristicFrequencies", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("characteristicFrequencies")
  public CharacteristicFrequencies getCharacteristicFrequencies() {
    return characteristicFrequencies;
  }

  public void setCharacteristicFrequencies(CharacteristicFrequencies characteristicFrequencies) {
    this.characteristicFrequencies = characteristicFrequencies;
  }

  public PackStatistics creationTime(OffsetDateTime creationTime) {
    this.creationTime = creationTime;
    return this;
  }

  /**
   * Get creationTime
   * @return creationTime
   */
  @Valid 
  @Schema(name = "creationTime", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("creationTime")
  public OffsetDateTime getCreationTime() {
    return creationTime;
  }

  public void setCreationTime(OffsetDateTime creationTime) {
    this.creationTime = creationTime;
  }

  public PackStatistics cellColors(Object cellColors) {
    this.cellColors = cellColors;
    return this;
  }

  /**
   * JSON representation of cell color information
   * @return cellColors
   */
  
  @Schema(name = "cellColors", description = "JSON representation of cell color information", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("cellColors")
  public Object getCellColors() {
    return cellColors;
  }

  public void setCellColors(Object cellColors) {
    this.cellColors = cellColors;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PackStatistics packStatistics = (PackStatistics) o;
    return Objects.equals(this.containerId, packStatistics.containerId) &&
        Objects.equals(this.clusterId, packStatistics.clusterId) &&
        Objects.equals(this.packId, packStatistics.packId) &&
        Objects.equals(this.realTimeId, packStatistics.realTimeId) &&
        Objects.equals(this.maxAbsImpedance, packStatistics.maxAbsImpedance) &&
        Objects.equals(this.minAbsImpedance, packStatistics.minAbsImpedance) &&
        Objects.equals(this.maxCoefficientOfVariation, packStatistics.maxCoefficientOfVariation) &&
        Objects.equals(this.minCoefficientOfVariation, packStatistics.minCoefficientOfVariation) &&
        Objects.equals(this.maxImpedanceStdDev, packStatistics.maxImpedanceStdDev) &&
        Objects.equals(this.minImpedanceStdDev, packStatistics.minImpedanceStdDev) &&
        Objects.equals(this.temperature, packStatistics.temperature) &&
        Objects.equals(this.absImpedanceMean, packStatistics.absImpedanceMean) &&
        Objects.equals(this.impedanceStdDev, packStatistics.impedanceStdDev) &&
        Objects.equals(this.coefficientOfVariation, packStatistics.coefficientOfVariation) &&
        Objects.equals(this.dispersion, packStatistics.dispersion) &&
        Objects.equals(this.degradationLevel, packStatistics.degradationLevel) &&
        Objects.equals(this.suggestion, packStatistics.suggestion) &&
        Objects.equals(this.alertText, packStatistics.alertText) &&
        Objects.equals(this.characteristicFrequencies, packStatistics.characteristicFrequencies) &&
        Objects.equals(this.creationTime, packStatistics.creationTime) &&
        Objects.equals(this.cellColors, packStatistics.cellColors);
  }

  @Override
  public int hashCode() {
    return Objects.hash(containerId, clusterId, packId, realTimeId, maxAbsImpedance, minAbsImpedance, maxCoefficientOfVariation, minCoefficientOfVariation, maxImpedanceStdDev, minImpedanceStdDev, temperature, absImpedanceMean, impedanceStdDev, coefficientOfVariation, dispersion, degradationLevel, suggestion, alertText, characteristicFrequencies, creationTime, cellColors);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PackStatistics {\n");
    sb.append("    containerId: ").append(toIndentedString(containerId)).append("\n");
    sb.append("    clusterId: ").append(toIndentedString(clusterId)).append("\n");
    sb.append("    packId: ").append(toIndentedString(packId)).append("\n");
    sb.append("    realTimeId: ").append(toIndentedString(realTimeId)).append("\n");
    sb.append("    maxAbsImpedance: ").append(toIndentedString(maxAbsImpedance)).append("\n");
    sb.append("    minAbsImpedance: ").append(toIndentedString(minAbsImpedance)).append("\n");
    sb.append("    maxCoefficientOfVariation: ").append(toIndentedString(maxCoefficientOfVariation)).append("\n");
    sb.append("    minCoefficientOfVariation: ").append(toIndentedString(minCoefficientOfVariation)).append("\n");
    sb.append("    maxImpedanceStdDev: ").append(toIndentedString(maxImpedanceStdDev)).append("\n");
    sb.append("    minImpedanceStdDev: ").append(toIndentedString(minImpedanceStdDev)).append("\n");
    sb.append("    temperature: ").append(toIndentedString(temperature)).append("\n");
    sb.append("    absImpedanceMean: ").append(toIndentedString(absImpedanceMean)).append("\n");
    sb.append("    impedanceStdDev: ").append(toIndentedString(impedanceStdDev)).append("\n");
    sb.append("    coefficientOfVariation: ").append(toIndentedString(coefficientOfVariation)).append("\n");
    sb.append("    dispersion: ").append(toIndentedString(dispersion)).append("\n");
    sb.append("    degradationLevel: ").append(toIndentedString(degradationLevel)).append("\n");
    sb.append("    suggestion: ").append(toIndentedString(suggestion)).append("\n");
    sb.append("    alertText: ").append(toIndentedString(alertText)).append("\n");
    sb.append("    characteristicFrequencies: ").append(toIndentedString(characteristicFrequencies)).append("\n");
    sb.append("    creationTime: ").append(toIndentedString(creationTime)).append("\n");
    sb.append("    cellColors: ").append(toIndentedString(cellColors)).append("\n");
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

