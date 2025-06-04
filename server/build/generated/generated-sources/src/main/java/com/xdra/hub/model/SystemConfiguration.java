package com.xdra.hub.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.xdra.hub.model.Container;
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
 * SystemConfiguration
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-06-03T17:02:57.461268288+08:00[Asia/Shanghai]", comments = "Generator version: 7.8.0")
public class SystemConfiguration {

  @Valid
  private List<@Valid Container> containers = new ArrayList<>();

  /**
   * Gets or Sets packType
   */
  public enum PackTypeEnum {
    PACK52("pack52"),
    
    PACK104("pack104");

    private String value;

    PackTypeEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static PackTypeEnum fromValue(String value) {
      for (PackTypeEnum b : PackTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private PackTypeEnum packType;

  public SystemConfiguration containers(List<@Valid Container> containers) {
    this.containers = containers;
    return this;
  }

  public SystemConfiguration addContainersItem(Container containersItem) {
    if (this.containers == null) {
      this.containers = new ArrayList<>();
    }
    this.containers.add(containersItem);
    return this;
  }

  /**
   * Get containers
   * @return containers
   */
  @Valid 
  @Schema(name = "containers", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("containers")
  public List<@Valid Container> getContainers() {
    return containers;
  }

  public void setContainers(List<@Valid Container> containers) {
    this.containers = containers;
  }

  public SystemConfiguration packType(PackTypeEnum packType) {
    this.packType = packType;
    return this;
  }

  /**
   * Get packType
   * @return packType
   */
  
  @Schema(name = "packType", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("packType")
  public PackTypeEnum getPackType() {
    return packType;
  }

  public void setPackType(PackTypeEnum packType) {
    this.packType = packType;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SystemConfiguration systemConfiguration = (SystemConfiguration) o;
    return Objects.equals(this.containers, systemConfiguration.containers) &&
        Objects.equals(this.packType, systemConfiguration.packType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(containers, packType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SystemConfiguration {\n");
    sb.append("    containers: ").append(toIndentedString(containers)).append("\n");
    sb.append("    packType: ").append(toIndentedString(packType)).append("\n");
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

