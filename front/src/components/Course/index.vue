<!-- 普通增删改查示例 - 主要列表页面，动态展示导航栏对应页面 -->
<template>
  <div class="main">
    <!-- 导航栏 -->
    <div class="header">
      <!-- 左侧名字及其logo -->
      <div class="logo">
        一点知识
      </div>
      <!-- 中间导航栏内容 -->
      <div class="search">
        <el-menu
         :default-active="activeIndex"
         class="el-menu-demo"
         :class="{ active: isActive, 'text-danger': hasError }"
         mode="horizontal"
         @select="handleSelect"
         active-text-color="#ffd04b">
         <el-menu-item index="1" style="width: 170px; font-size: 16px;">平台介绍</el-menu-item>
         <el-menu-item index="2" style="width: 170px; font-size: 16px;">课程介绍</el-menu-item>
         <el-submenu index="3"  style="width: 170px; font-size: 16px;">
           <template slot="title">用户群体</template>
           <el-menu-item index="3-1">教师</el-menu-item>
           <el-menu-item index="3-2">学员</el-menu-item>
         </el-submenu>
         <el-menu-item index="4" style="width: 170px; font-size: 16px;">关于我们</el-menu-item>
        </el-menu>
      </div>
      <!-- 联系方式 -->
      <div class="phone">
        18783451844
      </div>
      <!-- 登录按钮 -->
      <div>
        <el-tooltip content="Top center" placement="top">
          <el-button>登录</el-button>
        </el-tooltip>
      </div>
    </div>
    <Tone/>
    <!-- 走马灯 -->
    <!-- <div class="swiper">
      <el-carousel :interval="5000" arrow="always">
          <el-carousel-item v-for="item in 4" :key="item">
            <div class="medium">
                 <img class="fengmian" src="https://ts4.cn.mm.bing.net/th?id=OIP-C._zJYJtxQmroqF7l4GGD5QQHaFj&w=288&h=216&c=8&rs=1&qlt=90&o=6&dpr=1.3&pid=3.1&rm=2">
             </div>
          </el-carousel-item>
      </el-carousel>
    </div> -->
  </div>
</template>

<script lang="ts" setup>
import { ref } from 'vue';
import Tone from './One.vue';
const isActive = ref(true)
const hasError = ref(false)
  const activeIndex = '1'
  const handleSelect = (key,keyPath) => {
  // eslint-disable-next-line vue/require-explicit-emits
  console.log(key, keyPath);
};
</script>

<style scoped>
.header{
  display: flex;
  flex-direction: row;
  margin-left: 15%;
}
.logo{
  width: 100px;
}
.search{
  margin-left: 10%;
  width: 60%;
}
.phone{
  width: 10%;
}
.login{
  width: 100px;
}
.active{
  font-size: 100px;
}
.swiper{
    margin-top: 2%;
    width: 100%;
    height: 600px;
    background-color: #a6c1ee;
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