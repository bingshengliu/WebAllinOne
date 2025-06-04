package com.xdra.hub.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Overview
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-06-03T17:02:57.461268288+08:00[Asia/Shanghai]", comments = "Generator version: 7.8.0")
public class Overview {

  private Integer monthlyInspections;

  private Long totalInspections;

  private Long totalMeasurements;

  private Integer totalRiskySamples;

  private Integer cumulativeRiskIdentifications;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime lastUpdatedAt;

  @Valid
  private List<String> alertTexts = new ArrayList<>();

  public Overview monthlyInspections(Integer monthlyInspections) {
    this.monthlyInspections = monthlyInspections;
    return this;
  }

  /**
   * Get monthlyInspections
   * @return monthlyInspections
   */
  
  @Schema(name = "monthlyInspections", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("monthlyInspections")
  public Integer getMonthlyInspections() {
    return monthlyInspections;
  }

  public void setMonthlyInspections(Integer monthlyInspections) {
    this.monthlyInspections = monthlyInspections;
  }

  public Overview totalInspections(Long totalInspections) {
    this.totalInspections = totalInspections;
    return this;
  }

  /**
   * Get totalInspections
   * @return totalInspections
   */
  
  @Schema(name = "totalInspections", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("totalInspections")
  public Long getTotalInspections() {
    return totalInspections;
  }

  public void setTotalInspections(Long totalInspections) {
    this.totalInspections = totalInspections;
  }

  public Overview totalMeasurements(Long totalMeasurements) {
    this.totalMeasurements = totalMeasurements;
    return this;
  }

  /**
   * Get totalMeasurements
   * @return totalMeasurements
   */
  
  @Schema(name = "totalMeasurements", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("totalMeasurements")
  public Long getTotalMeasurements() {
    return totalMeasurements;
  }

  public void setTotalMeasurements(Long totalMeasurements) {
    this.totalMeasurements = totalMeasurements;
  }

  public Overview totalRiskySamples(Integer totalRiskySamples) {
    this.totalRiskySamples = totalRiskySamples;
    return this;
  }

  /**
   * Get totalRiskySamples
   * @return totalRiskySamples
   */
  
  @Schema(name = "totalRiskySamples", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("totalRiskySamples")
  public Integer getTotalRiskySamples() {
    return totalRiskySamples;
  }

  public void setTotalRiskySamples(Integer totalRiskySamples) {
    this.totalRiskySamples = totalRiskySamples;
  }

  public Overview cumulativeRiskIdentifications(Integer cumulativeRiskIdentifications) {
    this.cumulativeRiskIdentifications = cumulativeRiskIdentifications;
    return this;
  }

  /**
   * Get cumulativeRiskIdentifications
   * @return cumulativeRiskIdentifications
   */
  
  @Schema(name = "cumulativeRiskIdentifications", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("cumulativeRiskIdentifications")
  public Integer getCumulativeRiskIdentifications() {
    return cumulativeRiskIdentifications;
  }

  public void setCumulativeRiskIdentifications(Integer cumulativeRiskIdentifications) {
    this.cumulativeRiskIdentifications = cumulativeRiskIdentifications;
  }

  public Overview lastUpdatedAt(OffsetDateTime lastUpdatedAt) {
    this.lastUpdatedAt = lastUpdatedAt;
    return this;
  }

  /**
   * Get lastUpdatedAt
   * @return lastUpdatedAt
   */
  @Valid 
  @Schema(name = "lastUpdatedAt", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("lastUpdatedAt")
  public OffsetDateTime getLastUpdatedAt() {
    return lastUpdatedAt;
  }

  public void setLastUpdatedAt(OffsetDateTime lastUpdatedAt) {
    this.lastUpdatedAt = lastUpdatedAt;
  }

  public Overview alertTexts(List<String> alertTexts) {
    this.alertTexts = alertTexts;
    return this;
  }

  public Overview addAlertTextsItem(String alertTextsItem) {
    if (this.alertTexts == null) {
      this.alertTexts = new ArrayList<>();
    }
    this.alertTexts.add(alertTextsItem);
    return this;
  }

  /**
   * Get alertTexts
   * @return alertTexts
   */
  
  @Schema(name = "alertTexts", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("alertTexts")
  public List<String> getAlertTexts() {
    return alertTexts;
  }

  public void setAlertTexts(List<String> alertTexts) {
    this.alertTexts = alertTexts;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Overview overview = (Overview) o;
    return Objects.equals(this.monthlyInspections, overview.monthlyInspections) &&
        Objects.equals(this.totalInspections, overview.totalInspections) &&
        Objects.equals(this.totalMeasurements, overview.totalMeasurements) &&
        Objects.equals(this.totalRiskySamples, overview.totalRiskySamples) &&
        Objects.equals(this.cumulativeRiskIdentifications, overview.cumulativeRiskIdentifications) &&
        Objects.equals(this.lastUpdatedAt, overview.lastUpdatedAt) &&
        Objects.equals(this.alertTexts, overview.alertTexts);
  }

  @Override
  public int hashCode() {
    return Objects.hash(monthlyInspections, totalInspections, totalMeasurements, totalRiskySamples, cumulativeRiskIdentifications, lastUpdatedAt, alertTexts);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Overview {\n");
    sb.append("    monthlyInspections: ").append(toIndentedString(monthlyInspections)).append("\n");
    sb.append("    totalInspections: ").append(toIndentedString(totalInspections)).append("\n");
    sb.append("    totalMeasurements: ").append(toIndentedString(totalMeasurements)).append("\n");
    sb.append("    totalRiskySamples: ").append(toIndentedString(totalRiskySamples)).append("\n");
    sb.append("    cumulativeRiskIdentifications: ").append(toIndentedString(cumulativeRiskIdentifications)).append("\n");
    sb.append("    lastUpdatedAt: ").append(toIndentedString(lastUpdatedAt)).append("\n");
    sb.append("    alertTexts: ").append(toIndentedString(alertTexts)).append("\n");
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

