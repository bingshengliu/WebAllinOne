package com.xdra.hub.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
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
 * Cluster
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-06-03T17:02:57.461268288+08:00[Asia/Shanghai]", comments = "Generator version: 7.8.0")
public class Cluster {

  private String id;

  @Valid
  private List<String> packs = new ArrayList<>();

  public Cluster id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   */
  
  @Schema(name = "id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Cluster packs(List<String> packs) {
    this.packs = packs;
    return this;
  }

  public Cluster addPacksItem(String packsItem) {
    if (this.packs == null) {
      this.packs = new ArrayList<>();
    }
    this.packs.add(packsItem);
    return this;
  }

  /**
   * Get packs
   * @return packs
   */
  
  @Schema(name = "packs", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("packs")
  public List<String> getPacks() {
    return packs;
  }

  public void setPacks(List<String> packs) {
    this.packs = packs;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Cluster cluster = (Cluster) o;
    return Objects.equals(this.id, cluster.id) &&
        Objects.equals(this.packs, cluster.packs);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, packs);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Cluster {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    packs: ").append(toIndentedString(packs)).append("\n");
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

