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
 * CellHistogramPoint
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-06-03T17:02:57.461268288+08:00[Asia/Shanghai]", comments = "Generator version: 7.8.0")
public class CellHistogramPoint {

  private Double realPart10Hz;

  private Double imagPart10Hz;

  private Double r0;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime timestamp;

  public CellHistogramPoint realPart10Hz(Double realPart10Hz) {
    this.realPart10Hz = realPart10Hz;
    return this;
  }

  /**
   * Get realPart10Hz
   * @return realPart10Hz
   */
  
  @Schema(name = "realPart10Hz", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("realPart10Hz")
  public Double getRealPart10Hz() {
    return realPart10Hz;
  }

  public void setRealPart10Hz(Double realPart10Hz) {
    this.realPart10Hz = realPart10Hz;
  }

  public CellHistogramPoint imagPart10Hz(Double imagPart10Hz) {
    this.imagPart10Hz = imagPart10Hz;
    return this;
  }

  /**
   * Get imagPart10Hz
   * @return imagPart10Hz
   */
  
  @Schema(name = "imagPart10Hz", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("imagPart10Hz")
  public Double getImagPart10Hz() {
    return imagPart10Hz;
  }

  public void setImagPart10Hz(Double imagPart10Hz) {
    this.imagPart10Hz = imagPart10Hz;
  }

  public CellHistogramPoint r0(Double r0) {
    this.r0 = r0;
    return this;
  }

  /**
   * Get r0
   * @return r0
   */
  
  @Schema(name = "r0", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("r0")
  public Double getR0() {
    return r0;
  }

  public void setR0(Double r0) {
    this.r0 = r0;
  }

  public CellHistogramPoint timestamp(OffsetDateTime timestamp) {
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
    CellHistogramPoint cellHistogramPoint = (CellHistogramPoint) o;
    return Objects.equals(this.realPart10Hz, cellHistogramPoint.realPart10Hz) &&
        Objects.equals(this.imagPart10Hz, cellHistogramPoint.imagPart10Hz) &&
        Objects.equals(this.r0, cellHistogramPoint.r0) &&
        Objects.equals(this.timestamp, cellHistogramPoint.timestamp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(realPart10Hz, imagPart10Hz, r0, timestamp);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CellHistogramPoint {\n");
    sb.append("    realPart10Hz: ").append(toIndentedString(realPart10Hz)).append("\n");
    sb.append("    imagPart10Hz: ").append(toIndentedString(imagPart10Hz)).append("\n");
    sb.append("    r0: ").append(toIndentedString(r0)).append("\n");
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

