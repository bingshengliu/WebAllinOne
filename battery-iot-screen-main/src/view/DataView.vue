<template>
  <div class="dashboard">
    <!-- 三列一行布局 -->
    <main class="dashboard-content">
      <div class="leftbox">
        <div class="content">
          <div class="checkBox" id="grid">
            <singlePackThree />
          </div>
          <div class="consumptionBox">
            <div class="title">
              <img
                class="angle"
                src="../assets/img/arrow.png"
                style="width: 20px"
                alt=""
              />
              <div class="label">Pack整体变化趋势</div>
            </div>
            <div class="packParams">
              <div class="itemInfo" style="color: #fac858">
                <div>Pack均值阻抗</div>
                <div>
                  {{ PackMetricsData?.metrics?.absImpedanceMean.toFixed(2) || 0 }}
                </div>
              </div>
              <div class="itemInfo">
                <div>Pack电池离散度</div>
                <div>
                  {{ PackMetricsData?.metrics?.dispersion.toFixed(2) || 0 }}
                </div>
              </div>
              <div class="itemInfo" style="color: #5470c6">
                <div>Pack标准差</div>
                <div>
                  {{ PackMetricsData?.metrics?.impedanceStdDev.toFixed(2) || 0 }}
                </div>
              </div>
              <div class="itemInfo">
                <div>Pack变异系数</div>
                <div>
                  {{ PackMetricsData?.metrics?.coefficientOfVariation.toFixed(2) || 0 }}
                </div>
              </div>
            </div>

            <Line
              id="nhline"
              width="100%"
              height="55%"
              :overViewData="PackMetricsData"
              :isOverViewData="true"
              :lineColor="'#62DBED'"
              :isSmooth="false"
            />

            <div class="stBox">
              <div style="font-size: 0.08rem; margin-left: 0.1rem">Pack衰退模式</div>
              <div class="status-panel">
                <div
                  class="btn active"
                  :class="{
                    active: PackMetricsData?.metrics?.degradationLevel === 'Normal',
                  }"
                >
                  正常
                </div>
                <div
                  class="btn"
                  :class="{
                    active: PackMetricsData?.metrics?.degradationLevel === 'Mild',
                  }"
                >
                  轻度衰退
                </div>
                <div
                  class="btn"
                  :class="{
                    active: PackMetricsData?.metrics?.degradationLevel === 'Severe',
                  }"
                >
                  严重衰退
                </div>
              </div>
            </div>
            <div class="packParams" style="font-size: 0.08rem">
              <div class="itemInfo2">
                <div>10hz阻抗</div>
                <div>
                  {{
                    PackMetricsData?.characteristicFrequencies?.impedance10Hz.toFixed(
                      2
                    ) || 0
                  }}
                </div>
              </div>
              <div class="itemInfo2" style="margin-left: 0.1rem">
                <div>1000hz阻抗</div>
                <div>
                  {{
                    PackMetricsData?.characteristicFrequencies?.impedance10000Hz.toFixed(
                      2
                    ) || 0
                  }}
                </div>
              </div>
            </div>
          </div>
          <div class="packBox">
            <div class="title">
              <img
                class="angle"
                src="../assets/img/arrow.png"
                style="width: 20px"
                alt=""
              />
              <div class="label">Pack特征阻抗分布热力图</div>
            </div>
            <div style="height: 80%; width: 100%">
              <singlePackThreeByColor :cellColorsData="PackMetricsData?.cellColors" />
            </div>
          </div>
        </div>
      </div>
      <!-- 中部布局 -->
      <div class="centerbox">
        <!-- 顶部 -->
        <div class="singleBatteryData">
          <div class="content">
            <div class="flex">
              <div class="title">
                <img
                  class="angle"
                  src="../assets/img/arrow.png"
                  style="width: 20px"
                  alt=""
                />
                <div class="label">Nyquist图</div>
              </div>
              <!-- <heatMapLine /> -->
              <heatMapLine :NyquistData="cellData?.nyquistPlot" />
            </div>
            <div class="flex">
              <div class="title">
                <img
                  class="angle"
                  src="../assets/img/arrow.png"
                  style="width: 20px"
                  alt=""
                />
                <div class="label">Bode图</div>
              </div>
              <Bode :Bodedata="cellData?.bodePlot" />
            </div>
          </div>
        </div>
        <div class="singleBatteryBoard">
          <div style="display: flex; height: 1.1rem">
            <div class="box">
              <div class="title">
                <img
                  class="angle"
                  src="../assets/img/arrow.png"
                  style="width: 20px"
                  alt=""
                />
                <div class="label">单体电池历史数据分析</div>
              </div>
              <div class="flex-between">
                <div class="flex-between">
                  <div style="width: 0.4rem">阻抗均值：</div>
                  <div class="numBg">
                    {{
                      cellData.metrics?.absImpedanceMean != null
                        ? cellData.metrics.absImpedanceMean.toExponential(2)
                        : '0'
                    }}
                  </div>
                </div>
                <KDELine
                  :KdeData="cellData.metrics?.absImpedanceMean?.toExponential(2)"
                  :min="cellData.metrics?.minAbsImpedance"
                  :max="cellData.metrics?.maxAbsImpedance"
                />
              </div>
              <div class="flex-between">
                <div class="flex-between">
                  <div style="width: 0.4rem">标准差：</div>
                  <div class="numBg">
                    {{
                      cellData.metrics?.impedanceStdDev != null
                        ? cellData.metrics.impedanceStdDev.toExponential(2)
                        : '0'
                    }}
                  </div>
                </div>

                <Bar
                  :id="'Bar1'"
                  :absData="cellData.metrics?.impedanceStdDev"
                  :min="cellData.metrics?.minImpedanceStdDev"
                  :max="cellData.metrics?.maxImpedanceStdDev"
                />
              </div>
              <div class="flex-between">
                <div class="flex-between">
                  <div style="width: 0.4rem">变异系数：</div>
                  <div class="numBg">
                    {{
                      cellData.metrics?.coefficientOfVariation != null
                        ? cellData.metrics.coefficientOfVariation.toExponential(2)
                        : '0'
                    }}
                  </div>
                </div>

                <ByBar
                  :id="'Bar2'"
                  :byData="cellData.metrics?.coefficientOfVariation"
                  :min="cellData.metrics?.maxCoefficientOfVariation"
                  :max="cellData.metrics?.minCoefficientOfVariation"
                />
              </div>
            </div>
            <div class="box">
              <div class="title">
                <img
                  class="angle"
                  src="../assets/img/arrow.png"
                  style="width: 20px"
                  alt=""
                />
                <div class="label">跨单体数据分析</div>
              </div>
              <div class="list">
                <div>
                  <p style="font-size: 0.09rem; font-weight: 600">跨单体抗阻均值对比</p>
                  <ul class="ulStyle">
                    <li>
                      <span>与单体最大值对比：</span>
                      <span style="float: right">
                        <img
                          v-if="cellData.metrics?.impedanceMeanToMaxRatio > 0"
                          src="../assets/img/greenarrow.png"
                          alt=""
                        />
                        <img v-else src="../assets/img/redarrow.png" alt="" />

                        <span>
                          {{
                            cellData.metrics?.impedanceMeanToMaxRatio?.toFixed(2) || 0
                          }}%</span
                        >
                      </span>
                    </li>
                    <li>
                      <span> 与单体最小值对比：</span>
                      <span style="float: right">
                        <img
                          v-if="cellData.metrics?.impedanceMeanToMinRatio > 0"
                          src="../assets/img/greenarrow.png"
                          alt=""
                        />
                        <img v-else src="../assets/img/redarrow.png" alt="" />

                        <span
                          >{{
                            cellData.metrics?.impedanceMeanToMinRatio?.toFixed(2) || 0
                          }}%</span
                        >
                      </span>
                    </li>
                    <li>
                      <span> 与均值对比：</span>
                      <span style="float: right">
                        <img
                          v-if="cellData.metrics?.impedanceMeanToAvgRatio > 0"
                          src="../assets/img/greenarrow.png"
                          alt=""
                        />
                        <img v-else src="../assets/img/redarrow.png" alt="" />

                        <span
                          >{{
                            cellData.metrics?.impedanceMeanToAvgRatio?.toFixed(2) || 0
                          }}%</span
                        >
                      </span>
                    </li>
                  </ul>
                </div>
                <div>
                  <p style="font-size: 0.09rem; font-weight: 600">跨单体标准差对比</p>
                  <ul class="ulStyle">
                    <li>
                      <span>与单体最大值对比：</span>
                      <span style="float: right">
                        <img
                          v-if="cellData.metrics?.impedanceMeanToAvgRatio > 0"
                          src="../assets/img/greenarrow.png"
                          alt=""
                        />
                        <img v-else src="../assets/img/redarrow.png" alt="" />

                        <span
                          >{{
                            cellData.metrics?.impedanceStdDevToMaxRatio?.toFixed(2) || 0
                          }}%</span
                        >
                      </span>
                    </li>
                    <li>
                      <span> 与单体最小值对比：</span>
                      <span style="float: right">
                        <img
                          v-if="cellData.metrics?.impedanceStdDevToMinRatio > 0"
                          src="../assets/img/greenarrow.png"
                          alt=""
                        />
                        <img v-else src="../assets/img/redarrow.png" alt="" />

                        <span
                          >{{
                            cellData.metrics?.impedanceStdDevToMinRatio?.toFixed(2) || 0
                          }}%</span
                        >
                      </span>
                    </li>
                    <li>
                      <span> 与均值对比：</span>
                      <span style="float: right">
                        <img
                          v-if="cellData.metrics?.impedanceStdDevToAvgRatio > 0"
                          src="../assets/img/greenarrow.png"
                          alt=""
                        />
                        <img v-else src="../assets/img/redarrow.png" alt="" />

                        <span
                          >{{
                            cellData.metrics?.impedanceStdDevToAvgRatio?.toFixed(2) || 0
                          }}%</span
                        >
                      </span>
                    </li>
                  </ul>
                </div>
              </div>
            </div>
          </div>

          <div style="display: flex; height: 1.4rem">
            <div
              class="title"
              style="
                margin-top: 0.2rem;
                padding-bottom: 0;
                padding-top: 0;
                width: 2rem;
                flex-direction: column;
              "
            >
              <div style="display: flex; gap: 0.03rem">
                <img
                  class="angle"
                  src="../assets/img/arrow.png"
                  style="width: 20px"
                  alt=""
                />

                <div class="label">模组级特征阻抗相关性分析</div>
              </div>

              <img src="../assets/img/cellHeatmap.png" style="width: 0.8rem" alt="" />
            </div>
            <heatmapRect :id="'heatmapRect1'" :heatData="cellData?.realPartCorrelation" />

            <heatmapRect
              :id="'heatmapRect2'"
              :heatDevData="cellData?.imagPartCorrelation"
            />
          </div>
        </div>

        <div class="historyData">
          <div class="title">
            <img class="angle" src="../assets/img/arrow.png" style="width: 20px" alt="" />
            <div class="label">历史数据分析</div>

            <div class="period" style="margin-left: 0.2rem">
              <div
                class="btn"
                :class="{ active: periodStatus === 'month' }"
                @click="tabPeriod('month')"
              >
                月
              </div>
              <div
                class="btn"
                :class="{ active: periodStatus === 'week' }"
                @click="tabPeriod('week')"
              >
                周
              </div>
              <div
                class="btn"
                :class="{ active: periodStatus === 'day' }"
                @click="tabPeriod('day')"
              >
                天
              </div>
            </div>
          </div>
          <div style="height: 75%">
            <DoubleLineChart
              :showPeriod="true"
              :legendOrient="'vertical'"
              :isShowLegend="true"
              :id="'DoubleLineChart1'"
              :HistoryDataByPeriod="cellData?.histogram"
            />
          </div>
        </div>
      </div>
      <!-- 右侧 -->
      <div class="rightbox">
        <div class="Resistance">
          <div class="title">
            <img class="angle" src="../assets/img/arrow.png" style="width: 30px" alt="" />
            <div class="label">单体电池原始数据图</div>
          </div>
          <div style="position: relative">
            <img src="/zukang.png" style="height: 1.2rem; width: 2.2rem" alt="" />
            <div class="point" style="top: 50%; left: 15%">
              {{ cellData?.equivalentCircuitDiagram?.r0.toExponential(2) || 0 }}
            </div>
            <div class="point" style="top: 50%; right: 17%">
              {{ cellData?.equivalentCircuitDiagram?.zw.toExponential(2) || 0 }}
            </div>
            <div class="point" style="top: 32%; right: 48%">
              {{ cellData?.equivalentCircuitDiagram?.rct.toExponential(2) || 0 }}
            </div>
            <div class="point" style="bottom: 20%; right: 48%">
              {{ cellData?.equivalentCircuitDiagram?.cdl.toExponential(2) || 0 }}
            </div>

            <!-- <zukangChart :data="cellData?.equivalentCircuitDiagram" /> -->
          </div>
        </div>
        <div class="CircuitBoard">
          <div class="title">
            <img class="angle" src="../assets/img/arrow.png" style="width: 30px" alt="" />
            <div class="label">弛豫时间分布图</div>
          </div>
          <div style="display: flex; height: 75%">
            <DoubleLineChart
              :showPeriod="false"
              :legendOrient="'horizontal'"
              :isShowLegend="true"
              :id="'DoubleLineChart2'"
              :DrtData="cellData?.drtPlot"
            />
          </div>
        </div>
        <div class="suggestion">
          <div class="title">
            <img class="angle" src="../assets/img/arrow.png" style="width: 30px" alt="" />
            <div class="label">专家建议</div>
          </div>

          <div style="display: flex; gap: 0.05rem; width: 100%">
            <img
              src="/ai1.gif"
              style="width: 1rem; height: 1.25rem; margin-left: 0.05rem"
              alt=""
            />
            <div style="width: 50%; padding: 0 0.03rem">
              <TextScroll
                :items="scrollItems"
                :height="300"
                :item-style="{ fontSize: '0.08rem', color: '#fff' }"
                vertical
                @click="onClick"
              />
            </div>
          </div>
        </div>
      </div>
    </main>
  </div>
</template>
<script setup lang="ts">
import { ref, onMounted, watch, nextTick, reactive, computed } from 'vue';

import Line from '../components/line.vue';
import Bode from '../components/bode.vue';
import DoubleLineChart from '../components/DoubleLineChart.vue';
import KDELine from '../components/KDELine.vue';
import Bar from '../components/bar.vue';
import ByBar from '../components/ByBar.vue';

//热力图
import heatMapLine from '../components/heatMapLine.vue';
import heatmapRect from '../components/heatmapRect.vue';
//左上左下模型展示
import singlePackThree from '../components/singlePackThree/index.vue';
import singlePackThreeByColor from '../components/singlePackThreeByColor/index.vue';

import { GetOverViewData, GetPackMetrics } from '../api/packApi.ts';
import store from '../store/index';

// pack级总览数据
const OverViewData = ref({});

const Bodedata = ref({});
const Nyquistdata = ref({});
const HistoryData = ref({});
const PackMetricsData = ref(null);
//单体电池数据看板
const singleData = reactive({});
const EqData = ref({});
const periodStatus = ref('week');

const cellData = computed(() => {
  return store.state.CurrentCellData;
});
const scrollItems = ref([
  {
    "title": "建议定期使用EIS技术对电池进行全频段阻抗测试，以监测其内部电化学状态的变化。阻抗升高往往预示着老化或性能下降，及时发现并处理有助于延长电池的使用寿命和保障安全。"
  },
  {
    "title": "锂电池在高温环境中运行会导致电解液分解、电极材料老化加剧，EIS检测能识别温升下阻抗变化的异常特征，建议避免在超过60℃环境下长时间使用电池，以降低热失控风险。"
  },
  {
    "title": "EIS能有效评估电池中SEI膜的稳定性与电荷转移效率，若检测到界面阻抗显著升高，说明SEI膜可能劣化或破裂，应及时采取养护或替换措施，防止性能进一步下降。"
  },
  {
    "title": "长期不使用的电池建议在恢复使用前进行一次EIS检测，检查其电荷传递和扩散阻抗变化，若出现异常升高，可能存在电解液干涸或极化问题，应避免直接投入使用。"
  },
  {
    "title": "过快的充放电速度会使电池内部产生较高的电化学应力，通过EIS可观察电荷转移电阻变化，建议限制充放电倍率在设备推荐范围内，以确保长期稳定运行。"
  },
  {
    "title": "EIS对不同频率下的阻抗响应敏感，可用于评估锂离子扩散能力，当低频阻抗升高显著时，可能表示极片结构老化或锂离子嵌脱效率下降，建议及时检查电池结构完整性。"
  },
  {
    "title": "在低温环境下使用锂电池，其离子迁移能力下降、内阻升高，通过EIS频谱可清晰观察温度对阻抗的影响，建议尽量避免在-10℃以下使用电池，防止不可逆损伤。"
  },
  {
    "title": "建立每个电池的初始EIS基准图谱，可作为后期健康评估的重要参考。当监测到阻抗轨迹偏离原始特征时，应结合温度、电压、循环次数等因素分析劣化原因。"
  },
  {
    "title": "电池长时间维持在高SOC状态（90%以上）容易加剧界面副反应，EIS检测能观察电荷转移电阻的逐步升高，建议保持电量在20%-80%之间，以减缓老化速度。"
  },
  {
    "title": "Pack级电池系统中若某些单体EIS图谱出现显著偏离，说明其可能存在容量失衡或微短路风险，应及时标记并替换，以免影响整组电池性能与安全。"
  },
  {
    "title": "电池模组运行过程中应定期利用EIS检测单体间一致性，当某些电芯阻抗明显偏高时，需定位问题电池，防止不一致性扩大引发整组失效或热失控。"
  },
  {
    "title": "储能系统建议每三个月对部分电池抽样做EIS测试，通过对比历史图谱判断系统整体衰退趋势，以便制定维护或更换计划，确保供电可靠性和经济性。"
  },
  {
    "title": "进入老化阶段的锂电池，其EIS图谱表现为中高频段阻抗上升、相位角变化异常，通过图谱形态变化可判断寿命末期到来，建议及时更换避免使用风险。"
  },
  {
    "title": "高能量密度电池往往对微观缺陷更敏感，EIS检测可以提前发现内部电极结构异常或导电性下降问题，有助于排查安全隐患、优化电池设计与使用方案。"
  },
  {
    "title": "建议在电池生产、装配、首次充电及服役前后均进行EIS检测，建立全过程阻抗追踪体系，为质量控制和故障分析提供坚实的数据基础。"
  },
  {
    "title": "当充电过程出现异常缓慢、发热升高等现象时，可通过EIS分析是否存在电荷转移受阻、电极极化增强等问题，作为充电故障诊断的重要工具。"
  },
  {
    "title": "不同频段的EIS特征可分别反映电解质导电性、极化阻抗、锂扩散等多种机理，建议构建数据库模型用于识别典型故障模式，提升智能诊断能力。"
  },
  {
    "title": "对于动力电池或高可靠性场景，应在实际运行中嵌入EIS模块，实现在线状态监测和预警机制，减少突发故障对车辆、电网或设备运行造成的影响。"
  },
  {
    "title": "锂电池的健康状态应从多维角度评估，EIS数据应结合温度、电流、电压、SOC与循环寿命等信息综合分析，构建多参数联合诊断模型更为可靠。"
  },
  {
    "title": "建议建立基于EIS测试的生命周期评估标准，用于衡量不同电芯类型、使用工况和材料体系下的耐久性差异，从而指导选型、定价与质保策略。"
  }
]
);

function getRFC3339Date(daysAgo) {
  const date = new Date();
  date.setUTCDate(date.getUTCDate() - daysAgo);
  return date.toISOString();
}
const tabPeriod = (type) => {
  periodStatus.value = type;
  let dayNum;
  if (type == 'month') {
    dayNum = 29;
  }
  if (type == 'week') {
    dayNum = 6;
  }
  if (type == 'day') {
    dayNum = 0;
  }
  store.commit('setdateFrom', getRFC3339Date(dayNum));
};

//生成左上角格子
const generateGrid = () => {
  const rows = 8;
  const cols = 13;
  const grid = document.getElementById('grid');
  let firstCell = null; // 记录第一个格子
  // 生成 13x8 小方格
  for (let row = 0; row < rows; row++) {
    for (let col = 0; col < cols; col++) {
      const cell = document.createElement('div');
      // ✅ 直接用 JS 设置样式

      cell.style.border = '1px solid #aaa';
      cell.style.color = 'black';

      cell.style.display = 'flex';
      cell.style.alignItems = 'center';
      cell.style.justifyContent = 'center';
      cell.style.cursor = 'pointer';
      cell.style.backgroundColor = 'white';
      cell.style.transition = 'background 0.3s';

      // ✅ 鼠标悬浮变色
      cell.addEventListener('mouseover', () => {
        if (!cell.classList.contains('active')) {
          cell.style.backgroundColor = 'lightblue';
        }
      });

      // ✅ 鼠标移出恢复
      cell.addEventListener('mouseout', () => {
        if (!cell.classList.contains('active')) {
          cell.style.backgroundColor = 'white';
        }
      });

      cell.dataset.index = `${row * cols + col + 1}`; // 计算序号（从 1 开始）
      cell.dataset.row = row;
      cell.dataset.col = col;
      cell.innerText = cell.dataset.index; // 显示序号
      grid.appendChild(cell);
      // 记录第一个格子
      if (row === 0 && col === 0) {
        firstCell = cell;
      }
      //方格点击事件
      cell.addEventListener('click', function () {
        // 1. 清除所有方格的选中状态
        document.querySelectorAll('.cell').forEach((c) => {
          c.classList.remove('active');
          c.setAttribute('style', 'background-color: white;'); // 强制设置为白色
          c.style.backgroundColor = 'white'; // ✅ 直接设置白色，不用 `!important`
        });
        // 2. 给当前点击的方格添加 active 状态

        this.classList.add('active');

        Bodedata.value = eisData[this.dataset.index].bode;
        Nyquistdata.value = eisData[this.dataset.index].nyquist;
        HistoryData.value = historyData[this.dataset.index];
        EqData.value = eqData[this.dataset.index];
        SingleData.value = singleData[this.dataset.index];
        SinglekuaData.value = singlekuaData[this.dataset.index + '_'];

        // console.log(Bodedata.value, 'Bodedata');
        // console.log(Nyquistdata.value, 'Nyquistdata');
        console.log(SinglekuaData.value, 'SinglekuaData');

        // 3. 打印点击的方格信息
        console.log(
          `点击方格: 序号 ${this.dataset.index}，行 ${this.dataset.row}，列 ${this.dataset.col}`
        );
      });
    }
  }
  // ✅ 默认选中第一个格子
  if (firstCell) {
    firstCell.classList.add('active');
    firstCell.style.backgroundColor = 'lightblue'; // ✅ 直接设置白色，不用 `!important`
  }
};

watch(
  () => window.nowPage,
  (newVal, oldVal) => {
    console.log('nowPage变化了');
    nextTick().then(() => {
      // generateGrid();
      store.commit('setCurrentComponent', 'DataView');
    });
  },
  { immediate: true }
);

const GetOverViewDataFun = async () => {
  let res = await GetOverViewData();
  OverViewData.value = res.data;
};
//获取pack级数据
const GetPackMetricsData = async () => {
  let res = await GetPackMetrics(
    store.state.CurrentContainer.id,
    store.state.CurrentPack
  );
  PackMetricsData.value = res;
};

onMounted(() => {
  GetOverViewDataFun();
  GetPackMetricsData();
});
</script>

<style scoped lang="scss">
.dashboard {
  width: 100%;
  height: calc(100% - 0.4rem);
  margin-top: -0.1rem;
  background: #0d0d0d;
  color: white;
  // overflow: hidden;
  padding: 0 20px;
}

.dashboard-header {
  display: flex;

  height: 4rem;
  justify-content: space-between;
  align-items: center;
  border-bottom: 2px solid #222;
  padding-bottom: 10px;

  h1 {
    font-size: 24px;
  }

  .dashboard-info {
    display: flex;
    gap: 15px;
  }
}

.dashboard-content {
  display: grid;
  width: 100%;

  grid-template-columns: 1fr 1.8fr 1fr; // 三列
  gap: 15px;
  margin-top: 0.2rem;
}
//左侧盒子
.leftbox {
  display: flex;
  flex-direction: column;
  align-items: center;
  border-radius: 8px;
  .content {
    width: 100%;
    display: flex;
    flex-direction: column;
    gap: 0.05rem;
    .flex {
      width: 100%;

      height: 1rem;
      background: url('../assets/img/boxbg.png') no-repeat 100% 100% / 100% 100%;
    }
  }
  .checkBox {
    box-sizing: border-box;
    position: relative;
    width: 100%;
    // display: grid;
    // grid-template-columns: repeat(13, 1fr); /* 13列均分 */
    // grid-template-rows: repeat(8, 1fr); /* 8行均分 */
    // gap: 2px; /* 方格间距 */
    padding: 10px;
    height: 1.4rem;
    background: url('../assets/img/boxbg.png') no-repeat 100% 100% / 100% 100%;
  }
  .consumptionBox {
    width: 100%;
    box-sizing: border-box;
    padding: 0.08rem 0;
    // height: 1.9rem;
    height: 1.9rem;

    background: url('../assets/img/boxbg.png') no-repeat 100% 100% / 100% 100%;
    .packParams {
      width: 100%;
      padding: 0.02rem 0.005rem;
      display: flex;
      font-size: 0.07rem;
      padding-left: 0.1rem;
      .itemInfo {
        width: 25%;
      }
      .itemInfo2 {
        display: flex;
        gap: 0.1rem;
      }
    }
    div {
      box-sizing: border-box;
      text-align: center;
      padding: 0 0.01rem;
    }
  }
  .stBox {
    height: 0.22rem;
    width: 100%;
    display: flex;
    align-items: center;
    gap: 0.08rem;
    border-top: 2px solid #2d4759;
  }
  .packBox {
    width: 100%;
    padding: 0.08rem 0;

    height: 1.65rem;

    // height: 100%;

    background: url('../assets/img/boxbg.png') no-repeat 100% 100% / 100% 100%;
    .packParams {
      width: 100%;
      padding: 20px 20px;
      display: grid;
      grid-template-columns: repeat(2, 1fr); /* 固定 3 列，每列宽度相等 */
      font-size: 28px;
    }
    div {
      text-align: center;
    }
  }
}
.centerbox {
  width: 5rem;

  display: flex;
  flex-direction: column;
  gap: 0.05rem;
  align-items: center;
  border-radius: 8px;

  .singleBatteryData {
    width: 100%;
    height: 1.1rem;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    .content {
      width: 100%;
      height: 100%;
      display: flex;
      gap: 0.05rem;
      .flex {
        width: 90%;

        background: url('../assets/img/boxbg.png') no-repeat 100% 100% / 100% 100%;
      }
    }
  }
  .singleBatteryBoard {
    width: 100%;
    padding: 0.03rem 0.04rem;

    background: url('../assets/img/boxbg.png') no-repeat 100% 100% / 100% 100%;
    .box {
      width: 50%;
      padding: 0.02rem 0.04rem;
    }
    ul {
      padding: 0;
    }
    .list {
      display: flex;
      font-size: 0.08rem;
img{
  width: 0.1rem !important;
}
      div {
        width: 50%;
        padding: 0 0.03rem;
      }
    }
    .ulStyle {
      margin-top: 0.1rem;
      li {
        height: 0.2rem;
        font-size: 0.08rem;
        list-style: none;
      }
    }
  }

  .historyData {
    width: 100%;
    height: 1.3rem;

    background: url('../assets/img/boxbg.png') no-repeat 100% 100% / 100% 100%;
  }
}
.heatmapRectData {
  box-sizing: border-box;
  width: 100%;
  background: url('../assets/img/boxbg.png') no-repeat 100% 100% / 100% 100%;
}

.rightbox {
  display: flex;
  flex-direction: column;
  gap: 0.05rem;
  align-items: center;
  border-radius: 8px;
  .CircuitBoard {
    width: 95%;
    height: 1.3rem;

    background: url('../assets/img/boxbg.png') no-repeat 100% 100% / 100% 100%;
  }
  .Resistance {
    width: 95%;
    height: 1.6rem;
    background: url('../assets/img/boxbg.png') no-repeat 100% 100% / 100% 100%;
  }
  .suggestion {
    box-sizing: border-box;
    width: 95%;
    height: 2.05rem;

    background: url('../assets/img/boxbg.png') no-repeat 100% 100% / 100% 100%;
    .content {
      width: 100%;
      padding: 0 0.05rem;
      .option-item {
        font-size: 0.07rem;
        display: flex;
        justify-content: space-between;
        padding: 0 0.1rem;
        align-items: center;
        background: url('../assets/img/suggestionbg.png') no-repeat 100% 100% / 100% 100%;

        height: 0.3rem;
        margin-bottom: 0.05rem;
      }
      .status.enabled {
        color: blue;
      }
      .status {
        color: red;
      }
    }
    .bottom {
      height: 0.35rem;
      padding-left: 0.1rem;
      font-weight: 600;
      font-size: 0.08rem;
    }
  }
}
.label {
  text-align: left;
  font-size: 0.09rem;
  font-weight: 600;
}
.title {
  display: flex;
  gap: 10px;
  align-items: center;
  padding: 0.07rem;
  .angle {
    width: 0.06rem !important;
  }
}
/* 小屏幕：宽度小于 600px 时调整样式 */
@media (max-width: 1930) {
  .title {
    gap: 5px;
    padding: 0.035rem !important;
  }
}
.numBg {
  width: 0.28rem;
  text-align: center;
  background: url('../assets/img/Vector.png') no-repeat 100% 100% / 100% 100%;
}
.cell {
  cursor: pointer;
  background-color: white !important;
  border: 1px solid #aaa;
  display: flex;
  align-items: center;
  justify-content: center;
  cursor: pointer;
  transition: background 0.3s;
}

.cell:hover {
  background-color: lightblue; /* 鼠标悬浮变色 */
}

.active {
  color: white;
  font-weight: bold;
  background: url('../assets/img/blue.png') no-repeat 100% 100% / 100% 100%;
}
.status-panel {
  display: flex;
  gap: 0.06rem;
  align-items: center;
  padding: 5px 10px;
  border-radius: 4px;
  color: #fff;
  font-family: Arial, sans-serif;
  .btn {
    height: 0.15rem;
    line-height: 0.15rem;
    width: 0.4rem;
    margin-left: 5px;
    padding: 5px 10px;
    font-size: 0.08rem;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    border: 0.01rem solid #2d4759;
  }
}

.item {
  margin-right: 8px;
  font-size: 30px;
}

.power {
  color: #3eff3e;
}
.power.negative {
  color: #ff4d4d;
}

.warning,
.remote {
  color: #ff4d4d;
}
.warning.active,
.remote.active {
  color: #3eff3e;
}

.btn.start {
  background: url('../assets/img/blue.png') no-repeat 100% 100% / 100% 100%;

  color: #fff;
}
.btn.stop {
  background: url('../assets/img/green.png') no-repeat 100% 100% / 100% 100%;

  color: #fff;
}
.btn.standby {
  background: url('../assets/img/red.png') no-repeat 100% 100% / 100% 100%;

  color: #fff;
}

.flex-between {
  display: flex;
  font-size: 0.08rem;
  align-items: center;
  justify-content: space-between;
}
.point {
  position: absolute;
  font-size: 0.08rem;
  color: #fac858;
  font-weight: 700;
}

.period .active {
  background: url('../assets/img/yellow.png') no-repeat 100% 100% / 100% 100%;
}
</style>
<style>
.m-scroll-vertical .scroll-item-wrap .scroll-item{
  white-space: wrap  !important;
}
</style>
