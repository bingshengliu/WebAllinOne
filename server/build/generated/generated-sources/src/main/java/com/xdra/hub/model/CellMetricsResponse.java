package com.xdra.hub.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.xdra.hub.model.BodePlotPoint;
import com.xdra.hub.model.CellHistogramPoint;
import com.xdra.hub.model.CellMetrics;
import com.xdra.hub.model.DrtPlotPoint;
import com.xdra.hub.model.EquivalentCircuitDiagram;
import com.xdra.hub.model.NyquistPlot;
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
 * CellMetricsResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-06-03T17:02:57.461268288+08:00[Asia/Shanghai]", comments = "Generator version: 7.8.0")
public class CellMetricsResponse {

  @Valid
  private List<@Valid CellHistogramPoint> histogram = new ArrayList<>();

  private NyquistPlot nyquistPlot;

  @Valid
  private List<@Valid BodePlotPoint> bodePlot = new ArrayList<>();

  @Valid
  private List<@Valid DrtPlotPoint> drtPlot = new ArrayList<>();

  @Valid
  private List<List<Double>> realPartCorrelation = new ArrayList<>();

  @Valid
  private List<List<Double>> imagPartCorrelation = new ArrayList<>();

  private CellMetrics metrics;

  private EquivalentCircuitDiagram equivalentCircuitDiagram;

  public CellMetricsResponse histogram(List<@Valid CellHistogramPoint> histogram) {
    this.histogram = histogram;
    return this;
  }

  public CellMetricsResponse addHistogramItem(CellHistogramPoint histogramItem) {
    if (this.histogram == null) {
      this.histogram = new ArrayList<>();
    }
    this.histogram.add(histogramItem);
    return this;
  }

  /**
   * Get histogram
   * @return histogram
   */
  @Valid 
  @Schema(name = "histogram", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("histogram")
  public List<@Valid CellHistogramPoint> getHistogram() {
    return histogram;
  }

  public void setHistogram(List<@Valid CellHistogramPoint> histogram) {
    this.histogram = histogram;
  }

  public CellMetricsResponse nyquistPlot(NyquistPlot nyquistPlot) {
    this.nyquistPlot = nyquistPlot;
    return this;
  }

  /**
   * Get nyquistPlot
   * @return nyquistPlot
   */
  @Valid 
  @Schema(name = "nyquistPlot", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("nyquistPlot")
  public NyquistPlot getNyquistPlot() {
    return nyquistPlot;
  }

  public void setNyquistPlot(NyquistPlot nyquistPlot) {
    this.nyquistPlot = nyquistPlot;
  }

  public CellMetricsResponse bodePlot(List<@Valid BodePlotPoint> bodePlot) {
    this.bodePlot = bodePlot;
    return this;
  }

  public CellMetricsResponse addBodePlotItem(BodePlotPoint bodePlotItem) {
    if (this.bodePlot == null) {
      this.bodePlot = new ArrayList<>();
    }
    this.bodePlot.add(bodePlotItem);
    return this;
  }

  /**
   * Get bodePlot
   * @return bodePlot
   */
  @Valid 
  @Schema(name = "bodePlot", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("bodePlot")
  public List<@Valid BodePlotPoint> getBodePlot() {
    return bodePlot;
  }

  public void setBodePlot(List<@Valid BodePlotPoint> bodePlot) {
    this.bodePlot = bodePlot;
  }

  public CellMetricsResponse drtPlot(List<@Valid DrtPlotPoint> drtPlot) {
    this.drtPlot = drtPlot;
    return this;
  }

  public CellMetricsResponse addDrtPlotItem(DrtPlotPoint drtPlotItem) {
    if (this.drtPlot == null) {
      this.drtPlot = new ArrayList<>();
    }
    this.drtPlot.add(drtPlotItem);
    return this;
  }

  /**
   * Get drtPlot
   * @return drtPlot
   */
  @Valid 
  @Schema(name = "drtPlot", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("drtPlot")
  public List<@Valid DrtPlotPoint> getDrtPlot() {
    return drtPlot;
  }

  public void setDrtPlot(List<@Valid DrtPlotPoint> drtPlot) {
    this.drtPlot = drtPlot;
  }

  public CellMetricsResponse realPartCorrelation(List<List<Double>> realPartCorrelation) {
    this.realPartCorrelation = realPartCorrelation;
    return this;
  }

  public CellMetricsResponse addRealPartCorrelationItem(List<Double> realPartCorrelationItem) {
    if (this.realPartCorrelation == null) {
      this.realPartCorrelation = new ArrayList<>();
    }
    this.realPartCorrelation.add(realPartCorrelationItem);
    return this;
  }

  /**
   * Get realPartCorrelation
   * @return realPartCorrelation
   */
  @Valid 
  @Schema(name = "realPartCorrelation", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("realPartCorrelation")
  public List<List<Double>> getRealPartCorrelation() {
    return realPartCorrelation;
  }

  public void setRealPartCorrelation(List<List<Double>> realPartCorrelation) {
    this.realPartCorrelation = realPartCorrelation;
  }

  public CellMetricsResponse imagPartCorrelation(List<List<Double>> imagPartCorrelation) {
    this.imagPartCorrelation = imagPartCorrelation;
    return this;
  }

  public CellMetricsResponse addImagPartCorrelationItem(List<Double> imagPartCorrelationItem) {
    if (this.imagPartCorrelation == null) {
      this.imagPartCorrelation = new ArrayList<>();
    }
    this.imagPartCorrelation.add(imagPartCorrelationItem);
    return this;
  }

  /**
   * Get imagPartCorrelation
   * @return imagPartCorrelation
   */
  @Valid 
  @Schema(name = "imagPartCorrelation", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("imagPartCorrelation")
  public List<List<Double>> getImagPartCorrelation() {
    return imagPartCorrelation;
  }

  public void setImagPartCorrelation(List<List<Double>> imagPartCorrelation) {
    this.imagPartCorrelation = imagPartCorrelation;
  }

  public CellMetricsResponse metrics(CellMetrics metrics) {
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
  public CellMetrics getMetrics() {
    return metrics;
  }

  public void setMetrics(CellMetrics metrics) {
    this.metrics = metrics;
  }

  public CellMetricsResponse equivalentCircuitDiagram(EquivalentCircuitDiagram equivalentCircuitDiagram) {
    this.equivalentCircuitDiagram = equivalentCircuitDiagram;
    return this;
  }

  /**
   * Get equivalentCircuitDiagram
   * @return equivalentCircuitDiagram
   */
  @Valid 
  @Schema(name = "equivalentCircuitDiagram", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("equivalentCircuitDiagram")
  public EquivalentCircuitDiagram getEquivalentCircuitDiagram() {
    return equivalentCircuitDiagram;
  }

  public void setEquivalentCircuitDiagram(EquivalentCircuitDiagram equivalentCircuitDiagram) {
    this.equivalentCircuitDiagram = equivalentCircuitDiagram;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CellMetricsResponse cellMetricsResponse = (CellMetricsResponse) o;
    return Objects.equals(this.histogram, cellMetricsResponse.histogram) &&
        Objects.equals(this.nyquistPlot, cellMetricsResponse.nyquistPlot) &&
        Objects.equals(this.bodePlot, cellMetricsResponse.bodePlot) &&
        Objects.equals(this.drtPlot, cellMetricsResponse.drtPlot) &&
        Objects.equals(this.realPartCorrelation, cellMetricsResponse.realPartCorrelation) &&
        Objects.equals(this.imagPartCorrelation, cellMetricsResponse.imagPartCorrelation) &&
        Objects.equals(this.metrics, cellMetricsResponse.metrics) &&
        Objects.equals(this.equivalentCircuitDiagram, cellMetricsResponse.equivalentCircuitDiagram);
  }

  @Override
  public int hashCode() {
    return Objects.hash(histogram, nyquistPlot, bodePlot, drtPlot, realPartCorrelation, imagPartCorrelation, metrics, equivalentCircuitDiagram);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CellMetricsResponse {\n");
    sb.append("    histogram: ").append(toIndentedString(histogram)).append("\n");
    sb.append("    nyquistPlot: ").append(toIndentedString(nyquistPlot)).append("\n");
    sb.append("    bodePlot: ").append(toIndentedString(bodePlot)).append("\n");
    sb.append("    drtPlot: ").append(toIndentedString(drtPlot)).append("\n");
    sb.append("    realPartCorrelation: ").append(toIndentedString(realPartCorrelation)).append("\n");
    sb.append("    imagPartCorrelation: ").append(toIndentedString(imagPartCorrelation)).append("\n");
    sb.append("    metrics: ").append(toIndentedString(metrics)).append("\n");
    sb.append("    equivalentCircuitDiagram: ").append(toIndentedString(equivalentCircuitDiagram)).append("\n");
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

