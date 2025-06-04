package com.xdra.hub.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.xdra.hub.model.ClusterPackHistogram;
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
 * ContainerPackMetricsResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-06-03T17:02:57.461268288+08:00[Asia/Shanghai]", comments = "Generator version: 7.8.0")
public class ContainerPackMetricsResponse {

  @Valid
  private List<@Valid ClusterPackHistogram> packHistograms = new ArrayList<>();

  public ContainerPackMetricsResponse packHistograms(List<@Valid ClusterPackHistogram> packHistograms) {
    this.packHistograms = packHistograms;
    return this;
  }

  public ContainerPackMetricsResponse addPackHistogramsItem(ClusterPackHistogram packHistogramsItem) {
    if (this.packHistograms == null) {
      this.packHistograms = new ArrayList<>();
    }
    this.packHistograms.add(packHistogramsItem);
    return this;
  }

  /**
   * Get packHistograms
   * @return packHistograms
   */
  @Valid 
  @Schema(name = "packHistograms", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("packHistograms")
  public List<@Valid ClusterPackHistogram> getPackHistograms() {
    return packHistograms;
  }

  public void setPackHistograms(List<@Valid ClusterPackHistogram> packHistograms) {
    this.packHistograms = packHistograms;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContainerPackMetricsResponse containerPackMetricsResponse = (ContainerPackMetricsResponse) o;
    return Objects.equals(this.packHistograms, containerPackMetricsResponse.packHistograms);
  }

  @Override
  public int hashCode() {
    return Objects.hash(packHistograms);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContainerPackMetricsResponse {\n");
    sb.append("    packHistograms: ").append(toIndentedString(packHistograms)).append("\n");
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

