package com.xdra.hub.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
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
 * EisMeasurement
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-06-03T17:02:57.461268288+08:00[Asia/Shanghai]", comments = "Generator version: 7.8.0")
public class EisMeasurement {

  private String containerId;

  private String clusterId;

  private String packId;

  private String cellId;

  private Double realImpedance;

  private Double frequency;

  private Double imaginaryImpedance;

  private Double voltage;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime creationTime;

  private Double temperature;

  public EisMeasurement containerId(String containerId) {
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

  public EisMeasurement clusterId(String clusterId) {
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

  public EisMeasurement packId(String packId) {
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

  public EisMeasurement cellId(String cellId) {
    this.cellId = cellId;
    return this;
  }

  /**
   * Get cellId
   * @return cellId
   */
  
  @Schema(name = "cellId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("cellId")
  public String getCellId() {
    return cellId;
  }

  public void setCellId(String cellId) {
    this.cellId = cellId;
  }

  public EisMeasurement realImpedance(Double realImpedance) {
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

  public EisMeasurement frequency(Double frequency) {
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

  public EisMeasurement imaginaryImpedance(Double imaginaryImpedance) {
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

  public EisMeasurement voltage(Double voltage) {
    this.voltage = voltage;
    return this;
  }

  /**
   * Get voltage
   * @return voltage
   */
  
  @Schema(name = "voltage", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("voltage")
  public Double getVoltage() {
    return voltage;
  }

  public void setVoltage(Double voltage) {
    this.voltage = voltage;
  }

  public EisMeasurement creationTime(OffsetDateTime creationTime) {
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

  public EisMeasurement temperature(Double temperature) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EisMeasurement eisMeasurement = (EisMeasurement) o;
    return Objects.equals(this.containerId, eisMeasurement.containerId) &&
        Objects.equals(this.clusterId, eisMeasurement.clusterId) &&
        Objects.equals(this.packId, eisMeasurement.packId) &&
        Objects.equals(this.cellId, eisMeasurement.cellId) &&
        Objects.equals(this.realImpedance, eisMeasurement.realImpedance) &&
        Objects.equals(this.frequency, eisMeasurement.frequency) &&
        Objects.equals(this.imaginaryImpedance, eisMeasurement.imaginaryImpedance) &&
        Objects.equals(this.voltage, eisMeasurement.voltage) &&
        Objects.equals(this.creationTime, eisMeasurement.creationTime) &&
        Objects.equals(this.temperature, eisMeasurement.temperature);
  }

  @Override
  public int hashCode() {
    return Objects.hash(containerId, clusterId, packId, cellId, realImpedance, frequency, imaginaryImpedance, voltage, creationTime, temperature);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EisMeasurement {\n");
    sb.append("    containerId: ").append(toIndentedString(containerId)).append("\n");
    sb.append("    clusterId: ").append(toIndentedString(clusterId)).append("\n");
    sb.append("    packId: ").append(toIndentedString(packId)).append("\n");
    sb.append("    cellId: ").append(toIndentedString(cellId)).append("\n");
    sb.append("    realImpedance: ").append(toIndentedString(realImpedance)).append("\n");
    sb.append("    frequency: ").append(toIndentedString(frequency)).append("\n");
    sb.append("    imaginaryImpedance: ").append(toIndentedString(imaginaryImpedance)).append("\n");
    sb.append("    voltage: ").append(toIndentedString(voltage)).append("\n");
    sb.append("    creationTime: ").append(toIndentedString(creationTime)).append("\n");
    sb.append("    temperature: ").append(toIndentedString(temperature)).append("\n");
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

