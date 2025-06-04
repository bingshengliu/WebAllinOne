package com.xdra.hub.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.xdra.hub.model.CellColorInfo;
import com.xdra.hub.model.CharacteristicFrequencies;
import com.xdra.hub.model.PackHistogramPoint;
import com.xdra.hub.model.PackMetrics;
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
 * PackMetricsResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-06-03T17:02:57.461268288+08:00[Asia/Shanghai]", comments = "Generator version: 7.8.0")
public class PackMetricsResponse {

  @Valid
  private List<@Valid PackHistogramPoint> packHistogram = new ArrayList<>();

  private PackMetrics metrics;

  private String suggestion;

  private CharacteristicFrequencies characteristicFrequencies;

  @Valid
  private List<@Valid CellColorInfo> cellColors = new ArrayList<>();

  public PackMetricsResponse packHistogram(List<@Valid PackHistogramPoint> packHistogram) {
    this.packHistogram = packHistogram;
    return this;
  }

  public PackMetricsResponse addPackHistogramItem(PackHistogramPoint packHistogramItem) {
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

  public PackMetricsResponse metrics(PackMetrics metrics) {
    this.metrics = metrics;
    return this;
  }

  /**
   * Get metrics
   * @return metrics
   */
  @Valid 
  @Schema(name = "metrics", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("metrics")
  public PackMetrics getMetrics() {
    return metrics;
  }

  public void setMetrics(PackMetrics metrics) {
    this.metrics = metrics;
  }

  public PackMetricsResponse suggestion(String suggestion) {
    this.suggestion = suggestion;
    return this;
  }

  /**
   * Get suggestion
   * @return suggestion
   */
  
  @Schema(name = "suggestion", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("suggestion")
  public String getSuggestion() {
    return suggestion;
  }

  public void setSuggestion(String suggestion) {
    this.suggestion = suggestion;
  }

  public PackMetricsResponse characteristicFrequencies(CharacteristicFrequencies characteristicFrequencies) {
    this.characteristicFrequencies = characteristicFrequencies;
    return this;
  }

  /**
   * Get characteristicFrequencies
   * @return characteristicFrequencies
   */
  @Valid 
  @Schema(name = "characteristicFrequencies", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("characteristicFrequencies")
  public CharacteristicFrequencies getCharacteristicFrequencies() {
    return characteristicFrequencies;
  }

  public void setCharacteristicFrequencies(CharacteristicFrequencies characteristicFrequencies) {
    this.characteristicFrequencies = characteristicFrequencies;
  }

  public PackMetricsResponse cellColors(List<@Valid CellColorInfo> cellColors) {
    this.cellColors = cellColors;
    return this;
  }

  public PackMetricsResponse addCellColorsItem(CellColorInfo cellColorsItem) {
    if (this.cellColors == null) {
      this.cellColors = new ArrayList<>();
    }
    this.cellColors.add(cellColorsItem);
    return this;
  }

  /**
   * Get cellColors
   * @return cellColors
   */
  @Valid 
  @Schema(name = "cellColors", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("cellColors")
  public List<@Valid CellColorInfo> getCellColors() {
    return cellColors;
  }

  public void setCellColors(List<@Valid CellColorInfo> cellColors) {
    this.cellColors = cellColors;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PackMetricsResponse packMetricsResponse = (PackMetricsResponse) o;
    return Objects.equals(this.packHistogram, packMetricsResponse.packHistogram) &&
        Objects.equals(this.metrics, packMetricsResponse.metrics) &&
        Objects.equals(this.suggestion, packMetricsResponse.suggestion) &&
        Objects.equals(this.characteristicFrequencies, packMetricsResponse.characteristicFrequencies) &&
        Objects.equals(this.cellColors, packMetricsResponse.cellColors);
  }

  @Override
  public int hashCode() {
    return Objects.hash(packHistogram, metrics, suggestion, characteristicFrequencies, cellColors);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PackMetricsResponse {\n");
    sb.append("    packHistogram: ").append(toIndentedString(packHistogram)).append("\n");
    sb.append("    metrics: ").append(toIndentedString(metrics)).append("\n");
    sb.append("    suggestion: ").append(toIndentedString(suggestion)).append("\n");
    sb.append("    characteristicFrequencies: ").append(toIndentedString(characteristicFrequencies)).append("\n");
    sb.append("    cellColors: ").append(toIndentedString(cellColors)).append("\n");
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

