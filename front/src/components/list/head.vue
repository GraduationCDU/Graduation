<template>
  <div>
    <div class="one">
      <div ref="echartsAdmin" style="height: 300px;"></div>
    </div>
    <div class="one">
    </div>
    <!-- echarts 图表容器 -->
  </div>
</template>

<script setup>
import { ref, onMounted, onUnmounted } from 'vue';
import * as echarts from 'echarts';

const echartsAdmin = ref(null);
const echartsOne = ref(null);
const echartsTwo = ref(null);
const echartsThree = ref(null);
const echartsFour = ref(null);
let adminChart;
let oneChart;
onMounted(() => {
  // 创建 echarts 实例
  adminChart = echarts.init(echartsAdmin.value);
  oneChart = echarts.init(echartsOne.value);
  // 配置项，总的饼图
  const options = {
    // Your ECharts options here...
    title: {
      text: '全省任务执行情况统计',
    },
    tooltip: {
      trigger: 'item',
    },
    legend: {
      top: '25%',
      left: '30%', // 调整小标签到饼图的距离
      itemGap: 20, // 调整小标签的间距
      orient: 'vertical', // 设置为垂直排序
      textStyle: {
        fontSize: 12, // 调整小标签的大小
      },
      itemWidth: 10, // 调整小标签图标的宽度
      itemHeight: 10, // 调整小标签图标的高度
    },
    series: [
      {
        name: '示例数据',
        type: 'pie',
        center: ['10%', '50%'], // 调整饼图的位置
        radius: ['40%', '65%'],
        avoidLabelOverlap: false,
        label: {
          show: false,
          position: 'center',
        },
        emphasis: {
          label: {
            show: true,
            fontSize: 40,
            fontWeight: 'bold',
          },
        },
        labelLine: {
          show: false,
        },
        data: [
          { value: 1048, name: '已完成', itemStyle: { color: '#0000FF' } },
          { value: 735, name: '逾期已完成', itemStyle: { color: '#1E90FF' } },
          { value: 580, name: '达到时序推进', itemStyle: { color: '#00BFFF' } },
          { value: 484, name: '未按时序推进', itemStyle: { color: '#87CEEB' } },
          { value: 300, name: '逾期未完成', itemStyle: { color: '#0000CD' } },
        ],
      },
    ],
  };
  // 周报饼图
  const optionsOne = {
    // Your ECharts options here...
    tooltip: {
      trigger: 'item',
    },
    series: [
      {
        name: '示例数据',
        type: 'pie',
        center: ['10%', '50%'], // 调整饼图的位置
        radius: ['40%', '65%'],
        avoidLabelOverlap: false,
        labelLine: {
          show: false,
        },
        data: [
          { value: 1048, name: '已完成', itemStyle: { color: '#0000FF' } },
          { value: 735, name: '逾期已完成', itemStyle: { color: '#1E90FF' } },
        ],
      },
    ],
  };
  // 使用刚指定的配置项和数据显示图表
  adminChart.setOption(options);
  oneChart.setOption(optionsOne);
});

onUnmounted(() => {
  // 在组件销毁时销毁 echarts 实例
  if (adminChart) {
    adminChart.dispose();
  }
  if (oneChart) {
    oneChart.dispose();
  }
});
</script>
<style >
.one {
  width: 98%;
  height: 40%;
  border: 2px solid #E0FFFF;
  font-size: 12px;
}
</style>
