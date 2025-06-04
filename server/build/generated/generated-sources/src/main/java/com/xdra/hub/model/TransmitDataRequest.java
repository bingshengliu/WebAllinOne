package com.xdra.hub.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.xdra.hub.model.CellStatistics;
import com.xdra.hub.model.EisMeasurement;
import com.xdra.hub.model.PackStatistics;
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
 * TransmitDataRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-06-03T17:02:57.461268288+08:00[Asia/Shanghai]", comments = "Generator version: 7.8.0")
public class TransmitDataRequest {

  @Valid
  private List<@Valid EisMeasurement> eisMeasurements = new ArrayList<>();

  @Valid
  private List<@Valid CellStatistics> cellStatistics = new ArrayList<>();

  @Valid
  private List<@Valid PackStatistics> packStatistics = new ArrayList<>();

  public TransmitDataRequest eisMeasurements(List<@Valid EisMeasurement> eisMeasurements) {
    this.eisMeasurements = eisMeasurements;
    return this;
  }

  public TransmitDataRequest addEisMeasurementsItem(EisMeasurement eisMeasurementsItem) {
    if (this.eisMeasurements == null) {
      this.eisMeasurements = new ArrayList<>();
    }
    this.eisMeasurements.add(eisMeasurementsItem);
    return this;
  }

  /**
   * Get eisMeasurements
   * @return eisMeasurements
   */
  @Valid 
  @Schema(name = "eisMeasurements", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("eisMeasurements")
  public List<@Valid EisMeasurement> getEisMeasurements() {
    return eisMeasurements;
  }

  public void setEisMeasurements(List<@Valid EisMeasurement> eisMeasurements) {
    this.eisMeasurements = eisMeasurements;
  }

  public TransmitDataRequest cellStatistics(List<@Valid CellStatistics> cellStatistics) {
    this.cellStatistics = cellStatistics;
    return this;
  }

  public TransmitDataRequest addCellStatisticsItem(CellStatistics cellStatisticsItem) {
    if (this.cellStatistics == null) {
      this.cellStatistics = new ArrayList<>();
    }
    this.cellStatistics.add(cellStatisticsItem);
    return this;
  }

  /**
   * Get cellStatistics
   * @return cellStatistics
   */
  @Valid 
  @Schema(name = "cellStatistics", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("cellStatistics")
  public List<@Valid CellStatistics> getCellStatistics() {
    return cellStatistics;
  }

  public void setCellStatistics(List<@Valid CellStatistics> cellStatistics) {
    this.cellStatistics = cellStatistics;
  }

  public TransmitDataRequest packStatistics(List<@Valid PackStatistics> packStatistics) {
    this.packStatistics = packStatistics;
    return this;
  }

  public TransmitDataRequest addPackStatisticsItem(PackStatistics packStatisticsItem) {
    if (this.packStatistics == null) {
      this.packStatistics = new ArrayList<>();
    }
    this.packStatistics.add(packStatisticsItem);
    return this;
  }

  /**
   * Get packStatistics
   * @return packStatistics
   */
  @Valid 
  @Schema(name = "packStatistics", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("packStatistics")
  public List<@Valid PackStatistics> getPackStatistics() {
    return packStatistics;
  }

  public void setPackStatistics(List<@Valid PackStatistics> packStatistics) {
    this.packStatistics = packStatistics;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TransmitDataRequest transmitDataRequest = (TransmitDataRequest) o;
    return Objects.equals(this.eisMeasurements, transmitDataRequest.eisMeasurements) &&
        Objects.equals(this.cellStatistics, transmitDataRequest.cellStatistics) &&
        Objects.equals(this.packStatistics, transmitDataRequest.packStatistics);
  }

  @Override
  public int hashCode() {
    return Objects.hash(eisMeasurements, cellStatistics, packStatistics);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransmitDataRequest {\n");
    sb.append("    eisMeasurements: ").append(toIndentedString(eisMeasurements)).append("\n");
    sb.append("    cellStatistics: ").append(toIndentedString(cellStatistics)).append("\n");
    sb.append("    packStatistics: ").append(toIndentedString(packStatistics)).append("\n");
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

