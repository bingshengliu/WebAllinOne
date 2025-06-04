package com.xdra.hub.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.xdra.hub.model.NyquistPlotPoint;
import com.xdra.hub.model.Range;
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
 * NyquistPlot
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-06-03T17:02:57.461268288+08:00[Asia/Shanghai]", comments = "Generator version: 7.8.0")
public class NyquistPlot {

  @Valid
  private List<@Valid NyquistPlotPoint> metrics = new ArrayList<>();

  @Valid
  private List<List<Double>> heatMap = new ArrayList<>();

  private Range xAxisRange;

  private Range yAxisRange;

  public NyquistPlot metrics(List<@Valid NyquistPlotPoint> metrics) {
    this.metrics = metrics;
    return this;
  }

  public NyquistPlot addMetricsItem(NyquistPlotPoint metricsItem) {
    if (this.metrics == null) {
      this.metrics = new ArrayList<>();
    }
    this.metrics.add(metricsItem);
    return this;
  }

  /**
   * Get metrics
   * @return metrics
   */
  @Valid 
  @Schema(name = "metrics", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("metrics")
  public List<@Valid NyquistPlotPoint> getMetrics() {
    return metrics;
  }

  public void setMetrics(List<@Valid NyquistPlotPoint> metrics) {
    this.metrics = metrics;
  }

  public NyquistPlot heatMap(List<List<Double>> heatMap) {
    this.heatMap = heatMap;
    return this;
  }

  public NyquistPlot addHeatMapItem(List<Double> heatMapItem) {
    if (this.heatMap == null) {
      this.heatMap = new ArrayList<>();
    }
    this.heatMap.add(heatMapItem);
    return this;
  }

  /**
   * Get heatMap
   * @return heatMap
   */
  @Valid 
  @Schema(name = "heatMap", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("heatMap")
  public List<List<Double>> getHeatMap() {
    return heatMap;
  }

  public void setHeatMap(List<List<Double>> heatMap) {
    this.heatMap = heatMap;
  }

  public NyquistPlot xAxisRange(Range xAxisRange) {
    this.xAxisRange = xAxisRange;
    return this;
  }

  /**
   * Get xAxisRange
   * @return xAxisRange
   */
  @Valid 
  @Schema(name = "xAxisRange", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("xAxisRange")
  public Range getxAxisRange() {
    return xAxisRange;
  }

  public void setxAxisRange(Range xAxisRange) {
    this.xAxisRange = xAxisRange;
  }

  public NyquistPlot yAxisRange(Range yAxisRange) {
    this.yAxisRange = yAxisRange;
    return this;
  }

  /**
   * Get yAxisRange
   * @return yAxisRange
   */
  @Valid 
  @Schema(name = "yAxisRange", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("yAxisRange")
  public Range getyAxisRange() {
    return yAxisRange;
  }

  public void setyAxisRange(Range yAxisRange) {
    this.yAxisRange = yAxisRange;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NyquistPlot nyquistPlot = (NyquistPlot) o;
    return Objects.equals(this.metrics, nyquistPlot.metrics) &&
        Objects.equals(this.heatMap, nyquistPlot.heatMap) &&
        Objects.equals(this.xAxisRange, nyquistPlot.xAxisRange) &&
        Objects.equals(this.yAxisRange, nyquistPlot.yAxisRange);
  }

  @Override
  public int hashCode() {
    return Objects.hash(metrics, heatMap, xAxisRange, yAxisRange);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NyquistPlot {\n");
    sb.append("    metrics: ").append(toIndentedString(metrics)).append("\n");
    sb.append("    heatMap: ").append(toIndentedString(heatMap)).append("\n");
    sb.append("    xAxisRange: ").append(toIndentedString(xAxisRange)).append("\n");
    sb.append("    yAxisRange: ").append(toIndentedString(yAxisRange)).append("\n");
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

