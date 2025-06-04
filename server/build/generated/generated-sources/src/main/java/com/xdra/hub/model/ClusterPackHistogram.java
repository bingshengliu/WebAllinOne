package com.xdra.hub.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.xdra.hub.model.PackHistogramPoint;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * ClusterPackHistogram
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-06-03T17:02:57.461268288+08:00[Asia/Shanghai]", comments = "Generator version: 7.8.0")
public class ClusterPackHistogram {

  private String packId;

  @Valid
  private List<@Valid PackHistogramPoint> packHistogram = new ArrayList<>();

  public ClusterPackHistogram packId(String packId) {
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

  public ClusterPackHistogram packHistogram(List<@Valid PackHistogramPoint> packHistogram) {
    this.packHistogram = packHistogram;
    return this;
  }

  public ClusterPackHistogram addPackHistogramItem(PackHistogramPoint packHistogramItem) {
    if (this.packHistogram == null) {
      this.packHistogram = new ArrayList<>();
    }
    this.packHistogram.add(packHistogramItem);
    return this;
  }

  /**
   * Get packHistogram
   * @return packHistogram
   */
  @Valid 
  @Schema(name = "packHistogram", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("packHistogram")
  public List<@Valid PackHistogramPoint> getPackHistogram() {
    return packHistogram;
  }

  public void setPackHistogram(List<@Valid PackHistogramPoint> packHistogram) {
    this.packHistogram = packHistogram;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ClusterPackHistogram clusterPackHistogram = (ClusterPackHistogram) o;
    return Objects.equals(this.packId, clusterPackHistogram.packId) &&
        Objects.equals(this.packHistogram, clusterPackHistogram.packHistogram);
  }

  @Override
  public int hashCode() {
    return Objects.hash(packId, packHistogram);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ClusterPackHistogram {\n");
    sb.append("    packId: ").append(toIndentedString(packId)).append("\n");
    sb.append("    packHistogram: ").append(toIndentedString(packHistogram)).append("\n");
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

