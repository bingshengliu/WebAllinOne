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
 * EquivalentCircuitDiagram
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-06-03T17:02:57.461268288+08:00[Asia/Shanghai]", comments = "Generator version: 7.8.0")
public class EquivalentCircuitDiagram {

  private Double r0;

  private Double rct;

  private Double cdl;

  private Double zw;

  public EquivalentCircuitDiagram r0(Double r0) {
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

  public EquivalentCircuitDiagram rct(Double rct) {
    this.rct = rct;
    return this;
  }

  /**
   * Get rct
   * @return rct
   */
  
  @Schema(name = "rct", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("rct")
  public Double getRct() {
    return rct;
  }

  public void setRct(Double rct) {
    this.rct = rct;
  }

  public EquivalentCircuitDiagram cdl(Double cdl) {
    this.cdl = cdl;
    return this;
  }

  /**
   * Get cdl
   * @return cdl
   */
  
  @Schema(name = "cdl", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("cdl")
  public Double getCdl() {
    return cdl;
  }

  public void setCdl(Double cdl) {
    this.cdl = cdl;
  }

  public EquivalentCircuitDiagram zw(Double zw) {
    this.zw = zw;
    return this;
  }

  /**
   * Get zw
   * @return zw
   */
  
  @Schema(name = "zw", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("zw")
  public Double getZw() {
    return zw;
  }

  public void setZw(Double zw) {
    this.zw = zw;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EquivalentCircuitDiagram equivalentCircuitDiagram = (EquivalentCircuitDiagram) o;
    return Objects.equals(this.r0, equivalentCircuitDiagram.r0) &&
        Objects.equals(this.rct, equivalentCircuitDiagram.rct) &&
        Objects.equals(this.cdl, equivalentCircuitDiagram.cdl) &&
        Objects.equals(this.zw, equivalentCircuitDiagram.zw);
  }

  @Override
  public int hashCode() {
    return Objects.hash(r0, rct, cdl, zw);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EquivalentCircuitDiagram {\n");
    sb.append("    r0: ").append(toIndentedString(r0)).append("\n");
    sb.append("    rct: ").append(toIndentedString(rct)).append("\n");
    sb.append("    cdl: ").append(toIndentedString(cdl)).append("\n");
    sb.append("    zw: ").append(toIndentedString(zw)).append("\n");
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

