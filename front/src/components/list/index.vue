<template>
  <div>
    <!-- 头部统计图 -->
    <HeadT />
    <!-- 统计图 -->
    <FootT />
    <!-- echarts 图表容器 -->
  </div>
</template>

<script setup lang="ts">
import HeadT from './head.vue';
// eslint-disable-next-line import/no-self-import
import FootT from './foot.vue';

</script>
<style scoped>
.one {
  width: 98%;
  height: 40%;
  border: 2px solid #E0FFFF;
  font-size: 12px;
}
</style>
