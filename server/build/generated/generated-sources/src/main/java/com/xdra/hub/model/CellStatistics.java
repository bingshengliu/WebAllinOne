package com.xdra.hub.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.xdra.hub.model.BodePlotPoint;
import com.xdra.hub.model.DrtPlotPoint;
import com.xdra.hub.model.EquivalentCircuitDiagram;
import com.xdra.hub.model.NyquistPlot;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * CellStatistics
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-06-03T17:02:57.461268288+08:00[Asia/Shanghai]", comments = "Generator version: 7.8.0")
public class CellStatistics {

  private String containerId;

  private String clusterId;

  private String packId;

  private String groupId;

  private String cellId;

  private String realTimeId;

  private Double absImpedanceMean;

  private Double impedanceStdDev;

  private Double coefficientOfVariation;

  private Double phase;

  private Double impedanceMeanToMaxRatio;

  private Double impedanceMeanToMinRatio;

  private Double impedanceMeanToAvgRatio;

  private Double impedanceStdDevToMaxRatio;

  private Double impedanceStdDevToMinRatio;

  private Double impedanceStdDevToAvgRatio;

  @Valid
  private List<@Valid BodePlotPoint> bodePlot = new ArrayList<>();

  private NyquistPlot nyquistPlot;

  @Valid
  private List<@Valid DrtPlotPoint> drtPlot = new ArrayList<>();

  @Valid
  private List<List<Double>> realPartCorrelation = new ArrayList<>();

  @Valid
  private List<List<Double>> imagPartCorrelation = new ArrayList<>();

  private EquivalentCircuitDiagram equivalentCircuitDiagram;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime creationTime;

  private Double realPart10Hz;

  private Double imaginaryPart10Hz;

  private Double maxImpedanceStdDev;

  private Double minImpedanceStdDev;

  private Double maxAbsImpedance;

  private Double minAbsImpedance;

  private Double maxCoefficientOfVariation;

  private Double minCoefficientOfVariation;

  public CellStatistics containerId(String containerId) {
    this.containerId = containerId;
    return this;
  }

  /**
   * Get containerId
   * @return containerId
   */
  
  @Schema(name = "containerId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("containerId")
  public String getContainerId() {
    return containerId;
  }

  public void setContainerId(String containerId) {
    this.containerId = containerId;
  }

  public CellStatistics clusterId(String clusterId) {
    this.clusterId = clusterId;
    return this;
  }

  /**
   * Get clusterId
   * @return clusterId
   */
  
  @Schema(name = "clusterId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("clusterId")
  public String getClusterId() {
    return clusterId;
  }

  public void setClusterId(String clusterId) {
    this.clusterId = clusterId;
  }

  public CellStatistics packId(String packId) {
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

  public CellStatistics groupId(String groupId) {
    this.groupId = groupId;
    return this;
  }

  /**
   * Get groupId
   * @return groupId
   */
  
  @Schema(name = "groupId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("groupId")
  public String getGroupId() {
    return groupId;
  }

  public void setGroupId(String groupId) {
    this.groupId = groupId;
  }

  public CellStatistics cellId(String cellId) {
    this.cellId = cellId;
    return this;
  }

  /**
   * Get cellId
   * @return cellId
   */
  
  @Schema(name = "cellId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("cellId")
  public String getCellId() {
    return cellId;
  }

  public void setCellId(String cellId) {
    this.cellId = cellId;
  }

  public CellStatistics realTimeId(String realTimeId) {
    this.realTimeId = realTimeId;
    return this;
  }

  /**
   * Get realTimeId
   * @return realTimeId
   */
  
  @Schema(name = "realTimeId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("realTimeId")
  public String getRealTimeId() {
    return realTimeId;
  }

  public void setRealTimeId(String realTimeId) {
    this.realTimeId = realTimeId;
  }

  public CellStatistics absImpedanceMean(Double absImpedanceMean) {
    this.absImpedanceMean = absImpedanceMean;
    return this;
  }

  /**
   * Get absImpedanceMean
   * @return absImpedanceMean
   */
  
  @Schema(name = "absImpedanceMean", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("absImpedanceMean")
  public Double getAbsImpedanceMean() {
    return absImpedanceMean;
  }

  public void setAbsImpedanceMean(Double absImpedanceMean) {
    this.absImpedanceMean = absImpedanceMean;
  }

  public CellStatistics impedanceStdDev(Double impedanceStdDev) {
    this.impedanceStdDev = impedanceStdDev;
    return this;
  }

  /**
   * Get impedanceStdDev
   * @return impedanceStdDev
   */
  
  @Schema(name = "impedanceStdDev", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("impedanceStdDev")
  public Double getImpedanceStdDev() {
    return impedanceStdDev;
  }

  public void setImpedanceStdDev(Double impedanceStdDev) {
    this.impedanceStdDev = impedanceStdDev;
  }

  public CellStatistics coefficientOfVariation(Double coefficientOfVariation) {
    this.coefficientOfVariation = coefficientOfVariation;
    return this;
  }

  /**
   * Get coefficientOfVariation
   * @return coefficientOfVariation
   */
  
  @Schema(name = "coefficientOfVariation", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("coefficientOfVariation")
  public Double getCoefficientOfVariation() {
    return coefficientOfVariation;
  }

  public void setCoefficientOfVariation(Double coefficientOfVariation) {
    this.coefficientOfVariation = coefficientOfVariation;
  }

  public CellStatistics phase(Double phase) {
    this.phase = phase;
    return this;
  }

  /**
   * Get phase
   * @return phase
   */
  
  @Schema(name = "phase", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("phase")
  public Double getPhase() {
    return phase;
  }

  public void setPhase(Double phase) {
    this.phase = phase;
  }

  public CellStatistics impedanceMeanToMaxRatio(Double impedanceMeanToMaxRatio) {
    this.impedanceMeanToMaxRatio = impedanceMeanToMaxRatio;
    return this;
  }

  /**
   * Get impedanceMeanToMaxRatio
   * @return impedanceMeanToMaxRatio
   */
  
  @Schema(name = "impedanceMeanToMaxRatio", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("impedanceMeanToMaxRatio")
  public Double getImpedanceMeanToMaxRatio() {
    return impedanceMeanToMaxRatio;
  }

  public void setImpedanceMeanToMaxRatio(Double impedanceMeanToMaxRatio) {
    this.impedanceMeanToMaxRatio = impedanceMeanToMaxRatio;
  }

  public CellStatistics impedanceMeanToMinRatio(Double impedanceMeanToMinRatio) {
    this.impedanceMeanToMinRatio = impedanceMeanToMinRatio;
    return this;
  }

  /**
   * Get impedanceMeanToMinRatio
   * @return impedanceMeanToMinRatio
   */
  
  @Schema(name = "impedanceMeanToMinRatio", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("impedanceMeanToMinRatio")
  public Double getImpedanceMeanToMinRatio() {
    return impedanceMeanToMinRatio;
  }

  public void setImpedanceMeanToMinRatio(Double impedanceMeanToMinRatio) {
    this.impedanceMeanToMinRatio = impedanceMeanToMinRatio;
  }

  public CellStatistics impedanceMeanToAvgRatio(Double impedanceMeanToAvgRatio) {
    this.impedanceMeanToAvgRatio = impedanceMeanToAvgRatio;
    return this;
  }

  /**
   * Get impedanceMeanToAvgRatio
   * @return impedanceMeanToAvgRatio
   */
  
  @Schema(name = "impedanceMeanToAvgRatio", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("impedanceMeanToAvgRatio")
  public Double getImpedanceMeanToAvgRatio() {
    return impedanceMeanToAvgRatio;
  }

  public void setImpedanceMeanToAvgRatio(Double impedanceMeanToAvgRatio) {
    this.impedanceMeanToAvgRatio = impedanceMeanToAvgRatio;
  }

  public CellStatistics impedanceStdDevToMaxRatio(Double impedanceStdDevToMaxRatio) {
    this.impedanceStdDevToMaxRatio = impedanceStdDevToMaxRatio;
    return this;
  }

  /**
   * Get impedanceStdDevToMaxRatio
   * @return impedanceStdDevToMaxRatio
   */
  
  @Schema(name = "impedanceStdDevToMaxRatio", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("impedanceStdDevToMaxRatio")
  public Double getImpedanceStdDevToMaxRatio() {
    return impedanceStdDevToMaxRatio;
  }

  public void setImpedanceStdDevToMaxRatio(Double impedanceStdDevToMaxRatio) {
    this.impedanceStdDevToMaxRatio = impedanceStdDevToMaxRatio;
  }

  public CellStatistics impedanceStdDevToMinRatio(Double impedanceStdDevToMinRatio) {
    this.impedanceStdDevToMinRatio = impedanceStdDevToMinRatio;
    return this;
  }

  /**
   * Get impedanceStdDevToMinRatio
   * @return impedanceStdDevToMinRatio
   */
  
  @Schema(name = "impedanceStdDevToMinRatio", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("impedanceStdDevToMinRatio")
  public Double getImpedanceStdDevToMinRatio() {
    return impedanceStdDevToMinRatio;
  }

  public void setImpedanceStdDevToMinRatio(Double impedanceStdDevToMinRatio) {
    this.impedanceStdDevToMinRatio = impedanceStdDevToMinRatio;
  }

  public CellStatistics impedanceStdDevToAvgRatio(Double impedanceStdDevToAvgRatio) {
    this.impedanceStdDevToAvgRatio = impedanceStdDevToAvgRatio;
    return this;
  }

  /**
   * Get impedanceStdDevToAvgRatio
   * @return impedanceStdDevToAvgRatio
   */
  
  @Schema(name = "impedanceStdDevToAvgRatio", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("impedanceStdDevToAvgRatio")
  public Double getImpedanceStdDevToAvgRatio() {
    return impedanceStdDevToAvgRatio;
  }

  public void setImpedanceStdDevToAvgRatio(Double impedanceStdDevToAvgRatio) {
    this.impedanceStdDevToAvgRatio = impedanceStdDevToAvgRatio;
  }

  public CellStatistics bodePlot(List<@Valid BodePlotPoint> bodePlot) {
    this.bodePlot = bodePlot;
    return this;
  }

  public CellStatistics addBodePlotItem(BodePlotPoint bodePlotItem) {
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

  public CellStatistics nyquistPlot(NyquistPlot nyquistPlot) {
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

  public CellStatistics drtPlot(List<@Valid DrtPlotPoint> drtPlot) {
    this.drtPlot = drtPlot;
    return this;
  }

  public CellStatistics addDrtPlotItem(DrtPlotPoint drtPlotItem) {
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

  public CellStatistics realPartCorrelation(List<List<Double>> realPartCorrelation) {
    this.realPartCorrelation = realPartCorrelation;
    return this;
  }

  public CellStatistics addRealPartCorrelationItem(List<Double> realPartCorrelationItem) {
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

  public CellStatistics imagPartCorrelation(List<List<Double>> imagPartCorrelation) {
    this.imagPartCorrelation = imagPartCorrelation;
    return this;
  }

  public CellStatistics addImagPartCorrelationItem(List<Double> imagPartCorrelationItem) {
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

  public CellStatistics equivalentCircuitDiagram(EquivalentCircuitDiagram equivalentCircuitDiagram) {
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

  public CellStatistics creationTime(OffsetDateTime creationTime) {
    this.creationTime = creationTime;
    return this;
  }

  /**
   * Get creationTime
   * @return creationTime
   */
  @Valid 
  @Schema(name = "creationTime", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("creationTime")
  public OffsetDateTime getCreationTime() {
    return creationTime;
  }

  public void setCreationTime(OffsetDateTime creationTime) {
    this.creationTime = creationTime;
  }

  public CellStatistics realPart10Hz(Double realPart10Hz) {
    this.realPart10Hz = realPart10Hz;
    return this;
  }

  /**
   * Get realPart10Hz
   * @return realPart10Hz
   */
  
  @Schema(name = "realPart10Hz", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("realPart10Hz")
  public Double getRealPart10Hz() {
    return realPart10Hz;
  }

  public void setRealPart10Hz(Double realPart10Hz) {
    this.realPart10Hz = realPart10Hz;
  }

  public CellStatistics imaginaryPart10Hz(Double imaginaryPart10Hz) {
    this.imaginaryPart10Hz = imaginaryPart10Hz;
    return this;
  }

  /**
   * Get imaginaryPart10Hz
   * @return imaginaryPart10Hz
   */
  
  @Schema(name = "imaginaryPart10Hz", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("imaginaryPart10Hz")
  public Double getImaginaryPart10Hz() {
    return imaginaryPart10Hz;
  }

  public void setImaginaryPart10Hz(Double imaginaryPart10Hz) {
    this.imaginaryPart10Hz = imaginaryPart10Hz;
  }

  public CellStatistics maxImpedanceStdDev(Double maxImpedanceStdDev) {
    this.maxImpedanceStdDev = maxImpedanceStdDev;
    return this;
  }

  /**
   * Get maxImpedanceStdDev
   * @return maxImpedanceStdDev
   */
  
  @Schema(name = "maxImpedanceStdDev", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("maxImpedanceStdDev")
  public Double getMaxImpedanceStdDev() {
    return maxImpedanceStdDev;
  }

  public void setMaxImpedanceStdDev(Double maxImpedanceStdDev) {
    this.maxImpedanceStdDev = maxImpedanceStdDev;
  }

  public CellStatistics minImpedanceStdDev(Double minImpedanceStdDev) {
    this.minImpedanceStdDev = minImpedanceStdDev;
    return this;
  }

  /**
   * Get minImpedanceStdDev
   * @return minImpedanceStdDev
   */
  
  @Schema(name = "minImpedanceStdDev", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("minImpedanceStdDev")
  public Double getMinImpedanceStdDev() {
    return minImpedanceStdDev;
  }

  public void setMinImpedanceStdDev(Double minImpedanceStdDev) {
    this.minImpedanceStdDev = minImpedanceStdDev;
  }

  public CellStatistics maxAbsImpedance(Double maxAbsImpedance) {
    this.maxAbsImpedance = maxAbsImpedance;
    return this;
  }

  /**
   * Get maxAbsImpedance
   * @return maxAbsImpedance
   */
  
  @Schema(name = "maxAbsImpedance", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("maxAbsImpedance")
  public Double getMaxAbsImpedance() {
    return maxAbsImpedance;
  }

  public void setMaxAbsImpedance(Double maxAbsImpedance) {
    this.maxAbsImpedance = maxAbsImpedance;
  }

  public CellStatistics minAbsImpedance(Double minAbsImpedance) {
    this.minAbsImpedance = minAbsImpedance;
    return this;
  }

  /**
   * Get minAbsImpedance
   * @return minAbsImpedance
   */
  
  @Schema(name = "minAbsImpedance", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("minAbsImpedance")
  public Double getMinAbsImpedance() {
    return minAbsImpedance;
  }

  public void setMinAbsImpedance(Double minAbsImpedance) {
    this.minAbsImpedance = minAbsImpedance;
  }

  public CellStatistics maxCoefficientOfVariation(Double maxCoefficientOfVariation) {
    this.maxCoefficientOfVariation = maxCoefficientOfVariation;
    return this;
  }

  /**
   * Get maxCoefficientOfVariation
   * @return maxCoefficientOfVariation
   */
  
  @Schema(name = "maxCoefficientOfVariation", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("maxCoefficientOfVariation")
  public Double getMaxCoefficientOfVariation() {
    return maxCoefficientOfVariation;
  }

  public void setMaxCoefficientOfVariation(Double maxCoefficientOfVariation) {
    this.maxCoefficientOfVariation = maxCoefficientOfVariation;
  }

  public CellStatistics minCoefficientOfVariation(Double minCoefficientOfVariation) {
    this.minCoefficientOfVariation = minCoefficientOfVariation;
    return this;
  }

  /**
   * Get minCoefficientOfVariation
   * @return minCoefficientOfVariation
   */
  
  @Schema(name = "minCoefficientOfVariation", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("minCoefficientOfVariation")
  public Double getMinCoefficientOfVariation() {
    return minCoefficientOfVariation;
  }

  public void setMinCoefficientOfVariation(Double minCoefficientOfVariation) {
    this.minCoefficientOfVariation = minCoefficientOfVariation;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CellStatistics cellStatistics = (CellStatistics) o;
    return Objects.equals(this.containerId, cellStatistics.containerId) &&
        Objects.equals(this.clusterId, cellStatistics.clusterId) &&
        Objects.equals(this.packId, cellStatistics.packId) &&
        Objects.equals(this.groupId, cellStatistics.groupId) &&
        Objects.equals(this.cellId, cellStatistics.cellId) &&
        Objects.equals(this.realTimeId, cellStatistics.realTimeId) &&
        Objects.equals(this.absImpedanceMean, cellStatistics.absImpedanceMean) &&
        Objects.equals(this.impedanceStdDev, cellStatistics.impedanceStdDev) &&
        Objects.equals(this.coefficientOfVariation, cellStatistics.coefficientOfVariation) &&
        Objects.equals(this.phase, cellStatistics.phase) &&
        Objects.equals(this.impedanceMeanToMaxRatio, cellStatistics.impedanceMeanToMaxRatio) &&
        Objects.equals(this.impedanceMeanToMinRatio, cellStatistics.impedanceMeanToMinRatio) &&
        Objects.equals(this.impedanceMeanToAvgRatio, cellStatistics.impedanceMeanToAvgRatio) &&
        Objects.equals(this.impedanceStdDevToMaxRatio, cellStatistics.impedanceStdDevToMaxRatio) &&
        Objects.equals(this.impedanceStdDevToMinRatio, cellStatistics.impedanceStdDevToMinRatio) &&
        Objects.equals(this.impedanceStdDevToAvgRatio, cellStatistics.impedanceStdDevToAvgRatio) &&
        Objects.equals(this.bodePlot, cellStatistics.bodePlot) &&
        Objects.equals(this.nyquistPlot, cellStatistics.nyquistPlot) &&
        Objects.equals(this.drtPlot, cellStatistics.drtPlot) &&
        Objects.equals(this.realPartCorrelation, cellStatistics.realPartCorrelation) &&
        Objects.equals(this.imagPartCorrelation, cellStatistics.imagPartCorrelation) &&
        Objects.equals(this.equivalentCircuitDiagram, cellStatistics.equivalentCircuitDiagram) &&
        Objects.equals(this.creationTime, cellStatistics.creationTime) &&
        Objects.equals(this.realPart10Hz, cellStatistics.realPart10Hz) &&
        Objects.equals(this.imaginaryPart10Hz, cellStatistics.imaginaryPart10Hz) &&
        Objects.equals(this.maxImpedanceStdDev, cellStatistics.maxImpedanceStdDev) &&
        Objects.equals(this.minImpedanceStdDev, cellStatistics.minImpedanceStdDev) &&
        Objects.equals(this.maxAbsImpedance, cellStatistics.maxAbsImpedance) &&
        Objects.equals(this.minAbsImpedance, cellStatistics.minAbsImpedance) &&
        Objects.equals(this.maxCoefficientOfVariation, cellStatistics.maxCoefficientOfVariation) &&
        Objects.equals(this.minCoefficientOfVariation, cellStatistics.minCoefficientOfVariation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(containerId, clusterId, packId, groupId, cellId, realTimeId, absImpedanceMean, impedanceStdDev, coefficientOfVariation, phase, impedanceMeanToMaxRatio, impedanceMeanToMinRatio, impedanceMeanToAvgRatio, impedanceStdDevToMaxRatio, impedanceStdDevToMinRatio, impedanceStdDevToAvgRatio, bodePlot, nyquistPlot, drtPlot, realPartCorrelation, imagPartCorrelation, equivalentCircuitDiagram, creationTime, realPart10Hz, imaginaryPart10Hz, maxImpedanceStdDev, minImpedanceStdDev, maxAbsImpedance, minAbsImpedance, maxCoefficientOfVariation, minCoefficientOfVariation);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CellStatistics {\n");
    sb.append("    containerId: ").append(toIndentedString(containerId)).append("\n");
    sb.append("    clusterId: ").append(toIndentedString(clusterId)).append("\n");
    sb.append("    packId: ").append(toIndentedString(packId)).append("\n");
    sb.append("    groupId: ").append(toIndentedString(groupId)).append("\n");
    sb.append("    cellId: ").append(toIndentedString(cellId)).append("\n");
    sb.append("    realTimeId: ").append(toIndentedString(realTimeId)).append("\n");
    sb.append("    absImpedanceMean: ").append(toIndentedString(absImpedanceMean)).append("\n");
    sb.append("    impedanceStdDev: ").append(toIndentedString(impedanceStdDev)).append("\n");
    sb.append("    coefficientOfVariation: ").append(toIndentedString(coefficientOfVariation)).append("\n");
    sb.append("    phase: ").append(toIndentedString(phase)).append("\n");
    sb.append("    impedanceMeanToMaxRatio: ").append(toIndentedString(impedanceMeanToMaxRatio)).append("\n");
    sb.append("    impedanceMeanToMinRatio: ").append(toIndentedString(impedanceMeanToMinRatio)).append("\n");
    sb.append("    impedanceMeanToAvgRatio: ").append(toIndentedString(impedanceMeanToAvgRatio)).append("\n");
    sb.append("    impedanceStdDevToMaxRatio: ").append(toIndentedString(impedanceStdDevToMaxRatio)).append("\n");
    sb.append("    impedanceStdDevToMinRatio: ").append(toIndentedString(impedanceStdDevToMinRatio)).append("\n");
    sb.append("    impedanceStdDevToAvgRatio: ").append(toIndentedString(impedanceStdDevToAvgRatio)).append("\n");
    sb.append("    bodePlot: ").append(toIndentedString(bodePlot)).append("\n");
    sb.append("    nyquistPlot: ").append(toIndentedString(nyquistPlot)).append("\n");
    sb.append("    drtPlot: ").append(toIndentedString(drtPlot)).append("\n");
    sb.append("    realPartCorrelation: ").append(toIndentedString(realPartCorrelation)).append("\n");
    sb.append("    imagPartCorrelation: ").append(toIndentedString(imagPartCorrelation)).append("\n");
    sb.append("    equivalentCircuitDiagram: ").append(toIndentedString(equivalentCircuitDiagram)).append("\n");
    sb.append("    creationTime: ").append(toIndentedString(creationTime)).append("\n");
    sb.append("    realPart10Hz: ").append(toIndentedString(realPart10Hz)).append("\n");
    sb.append("    imaginaryPart10Hz: ").append(toIndentedString(imaginaryPart10Hz)).append("\n");
    sb.append("    maxImpedanceStdDev: ").append(toIndentedString(maxImpedanceStdDev)).append("\n");
    sb.append("    minImpedanceStdDev: ").append(toIndentedString(minImpedanceStdDev)).append("\n");
    sb.append("    maxAbsImpedance: ").append(toIndentedString(maxAbsImpedance)).append("\n");
    sb.append("    minAbsImpedance: ").append(toIndentedString(minAbsImpedance)).append("\n");
    sb.append("    maxCoefficientOfVariation: ").append(toIndentedString(maxCoefficientOfVariation)).append("\n");
    sb.append("    minCoefficientOfVariation: ").append(toIndentedString(minCoefficientOfVariation)).append("\n");
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

