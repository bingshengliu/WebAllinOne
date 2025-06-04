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
 * DrtPlotPoint
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-06-03T17:02:57.461268288+08:00[Asia/Shanghai]", comments = "Generator version: 7.8.0")
public class DrtPlotPoint {

  private Double relaxT;

  private Double yT;

  public DrtPlotPoint relaxT(Double relaxT) {
    this.relaxT = relaxT;
    return this;
  }

  /**
   * Get relaxT
   * @return relaxT
   */
  
  @Schema(name = "relaxT", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("relaxT")
  public Double getRelaxT() {
    return relaxT;
  }

  public void setRelaxT(Double relaxT) {
    this.relaxT = relaxT;
  }

  public DrtPlotPoint yT(Double yT) {
    this.yT = yT;
    return this;
  }

  /**
   * Get yT
   * @return yT
   */
  
  @Schema(name = "yT", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("yT")
  public Double getyT() {
    return yT;
  }

  public void setyT(Double yT) {
    this.yT = yT;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DrtPlotPoint drtPlotPoint = (DrtPlotPoint) o;
    return Objects.equals(this.relaxT, drtPlotPoint.relaxT) &&
        Objects.equals(this.yT, drtPlotPoint.yT);
  }

  @Override
  public int hashCode() {
    return Objects.hash(relaxT, yT);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DrtPlotPoint {\n");
    sb.append("    relaxT: ").append(toIndentedString(relaxT)).append("\n");
    sb.append("    yT: ").append(toIndentedString(yT)).append("\n");
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

