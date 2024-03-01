<!-- 普通增删改查示例 - 搜索组件 -->
<template>
  <div>
    <div class="search">
      <TSearch/>
    </div>
    
    <h1>列表主组件</h1>
  </div>
</template>

<script lang="ts" setup>
import TSearch from './Search.vue';
</script>
<style>
.search{
  height: 100px;
  background-color: aqua;
}
</style>