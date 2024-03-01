<template>
  <div>
    <div
      ref="barChart"
      style="width: 100%;
  height: 400px;"
    ></div>
    <!-- echarts 图表容器 -->
  </div>
</template>

<script setup lang="ts">
import { ref, onMounted, onUnmounted } from 'vue';
import * as echarts from 'echarts';

const barChart = ref<null | HTMLDivElement>(null);
let twoChart;
onMounted(() => {
  // 使用 ECharts 初始化柱状图
  twoChart = echarts.init(barChart.value);

  // 数据
  const data = [
    { name: '周报', value: [10, 15, 20, 25, 32, 24, 12, 42, 13, 32, 14], itemStyle: { color: '#87CEFA' } },
    { name: '月报', value: [12, 18, 22, 28, 21, 26, 24, 32, 14, 12, 22], itemStyle: { color: '#00BFFF' } },
    { name: '季报', value: [14, 20, 24, 30, 21, 21, 32, 22, 23, 22, 16], itemStyle: { color: '#1E90FF' } },
    { name: '年报', value: [16, 22, 26, 32, 12, 46, 22, 12, 14, 42, 32], itemStyle: { color: '#0000FF' } },
  ];

  // ECharts 配置
  const options = {
    title: {
      text: '支队/市州任务执行情况统计',
    },
    legend: {
      left: '30%', // 调整小标签到饼图的距离
      itemGap: 40, // 调整小标签的间距
      textStyle: {
        fontSize: 12, // 调整小标签的大小
      },
      itemWidth: 20, // 调整小标签图标的宽度
      itemHeight: 10, // 调整小标签图标的高度
    },
    xAxis: {
      type: 'category',
      data: ['一支队', '二支队', '三支队', '三支队', '四支队', '五支队', '六支队', '七支队', '八支队', '九支队'],
    },
    yAxis: [
      {
        type: 'value',
        name: '任务(个)',
        axisLine: {
          lineStyle: {
            color: 'blue', // 右侧线的颜色
            width: 2, // 右侧线的宽度
          },
        },
      },
      {
        type: 'value',
        name: '完成率(%)',
      },
    ],
    series: [
      // 柱状图系列
      ...data.map((group) => ({
        name: group.name,
        type: 'bar',
        yAxisIndex: 0, // 使用第一个 y 轴
        data: group.value,
      })),
      // 折线图系列
      {
        name: '完成率',
        type: 'line',
        yAxisIndex: 1, // 使用第二个 y 轴
        data: [60, 78, 75, 82, 63, 93, 61, 83, 92, 62], // 折线图的数据
      },
    ],
  };

  // 设置 ECharts 配置
  twoChart.setOption(options);
});
onUnmounted(() => {
  // 在组件销毁时销毁 echarts 实例
  if (twoChart) {
    twoChart.dispose();
  }
});
</script>
<style scoped>
.one {
  width: 98%;
  height: 40%;
  border: 2px solid #E0FFFF;
  font-size: 12px;
}
</style>
