<!-- 普通增删改查示例 - 主要列表页面，动态展示导航栏对应页面 -->
<template>
  <div class="main">
    <!-- 走马灯 -->
    <div class="swiper">
      <el-carousel :interval="5000" arrow="always">
          <el-carousel-item v-for="item in 4" :key="item">
            <div class="medium">
                 <img class="fengmian" src="https://ts4.cn.mm.bing.net/th?id=OIP-C._zJYJtxQmroqF7l4GGD5QQHaFj&w=288&h=216&c=8&rs=1&qlt=90&o=6&dpr=1.3&pid=3.1&rm=2">
             </div>
          </el-carousel-item>
      </el-carousel>
    </div>
  </div>
</template>

<script lang="ts" setup>

</script>

<style scoped>
.swiper{
    margin-top: 2%;
    width: 100%;
    height: 600px;
    background-color: #000000;
}
.medium{
    width: 100%;
    height: 600px;
    display: flex;
  justify-content: center;
  align-items: center;
  background-color: aqua;
  }
  .fengmian{
    width: 100%;
    height: 100%;
  }
</style>