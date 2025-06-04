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
 * PackHistogramPoint
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-06-03T17:02:57.461268288+08:00[Asia/Shanghai]", comments = "Generator version: 7.8.0")
public class PackHistogramPoint {

  private Double absImpedanceMean;

  private Double maxAbsImpedance;

  private Double minAbsImpedance;

  private Double impedanceStdDev;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime timestamp;

  public PackHistogramPoint absImpedanceMean(Double absImpedanceMean) {
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

  public PackHistogramPoint maxAbsImpedance(Double maxAbsImpedance) {
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

  public PackHistogramPoint minAbsImpedance(Double minAbsImpedance) {
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

  public PackHistogramPoint impedanceStdDev(Double impedanceStdDev) {
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

  public PackHistogramPoint timestamp(OffsetDateTime timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  /**
   * Get timestamp
   * @return timestamp
   */
  @Valid 
  @Schema(name = "timestamp", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("timestamp")
  public OffsetDateTime getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(OffsetDateTime timestamp) {
    this.timestamp = timestamp;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PackHistogramPoint packHistogramPoint = (PackHistogramPoint) o;
    return Objects.equals(this.absImpedanceMean, packHistogramPoint.absImpedanceMean) &&
        Objects.equals(this.maxAbsImpedance, packHistogramPoint.maxAbsImpedance) &&
        Objects.equals(this.minAbsImpedance, packHistogramPoint.minAbsImpedance) &&
        Objects.equals(this.impedanceStdDev, packHistogramPoint.impedanceStdDev) &&
        Objects.equals(this.timestamp, packHistogramPoint.timestamp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(absImpedanceMean, maxAbsImpedance, minAbsImpedance, impedanceStdDev, timestamp);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PackHistogramPoint {\n");
    sb.append("    absImpedanceMean: ").append(toIndentedString(absImpedanceMean)).append("\n");
    sb.append("    maxAbsImpedance: ").append(toIndentedString(maxAbsImpedance)).append("\n");
    sb.append("    minAbsImpedance: ").append(toIndentedString(minAbsImpedance)).append("\n");
    sb.append("    impedanceStdDev: ").append(toIndentedString(impedanceStdDev)).append("\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
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

