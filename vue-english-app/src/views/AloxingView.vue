<script setup>
import {ref} from 'vue'
import MainView from "@/views/MainView.vue"
import JuniorView from "@/views/JuniorView.vue"
import HighView from "@/views/HighView.vue"
import CET4View from "@/views/CET4View.vue"
import CET6View from "@/views/CET6View.vue"
import GraduateView from "@/views/GraduateView.vue"
import SatView from "@/views/SatView.vue"
import ToeflView from "@/views/ToeflView.vue"
import UserDataView from "@/views/UserDataView.vue"
import PlanView from "@/views/PlanView.vue"
import MasterView from "@/views/MasterView.vue"
import UsingView from "@/views/UsingView.vue"
const ClickItem = ref([
  "单词总表",
  "初中词汇",
  "高中词汇",
  "四级词汇",
  "六级词汇",
  "考研词汇",
  "SAT词汇",
  "托福词汇",
  "计划词汇",
  "正在进行",
  "掌握词汇",
  "个人信息"
])
const key = ref(0)
const toKey=(str)=>{
  for(let i = 0;i<ClickItem.value.length;i++){
    if(str === ClickItem.value[i]){
      key.value=i
      return
    }
  }
}
</script>

<template>
  <!-- <MainView></MainView>-->
  <!--  <TestView></TestView>-->
  <el-affix :offset="0">
    <el-row class="header">
      <el-col :span="24">
        <div class="grid-content ep-bg-purple-dark">
          <h1 style="float: left">English</h1>
        </div>
      </el-col>
    </el-row>
  </el-affix>

  <el-row>
    <el-col class="aside" :span="3">
      <el-affix :offset="67">
        <div class="grid-content ep-bg-purple">
          <el-scrollbar  max-height="90vh">
            <el-menu class="el_menu" style="">
              <el-menu-item class="scrollbar-demo-item" v-for="(item,index) in ClickItem" :key="index" :index="index+''" @click="toKey(item)">
                {{item}}
              </el-menu-item>
            </el-menu>
          </el-scrollbar>
        </div>
      </el-affix>
    </el-col>
    <el-col class="main" :span="21">
      <div class="grid-content ep-bg-purple-light">
        <div class="view">
          <!--          回到顶部-->
          <el-backtop :right="100" :bottom="100" />

          <!--          显示页面-->

          <MainView v-if="key === 0"></MainView>
          <JuniorView v-if="key === 1"></JuniorView>
          <HighView v-if="key === 2"></HighView>
          <CET4View v-if="key === 3"></CET4View>
          <CET6View v-if="key === 4"></CET6View>
          <GraduateView v-if="key === 5"></GraduateView>
          <SatView v-if="key === 6"></SatView>
          <ToeflView v-if="key === 7"></ToeflView>
          <PlanView v-if="key === 8"></PlanView>
          <UsingView v-if="key === 9"></UsingView>
          <MasterView v-if="key === 10"></MasterView>
          <UserDataView v-if="key === 11"></UserDataView>
          <!--          <TestView></TestView>-->
        </div>
      </div>
    </el-col>
  </el-row>

</template>

<style scoped>

.view{
  padding: 24px;
}
.header {
  height: 67px;
  font-size: 14px;
  //color: rgba(255, 255, 255, 0.55);
  color: #519391;
  padding-left: 24px;
  padding-right: 24px;
  //background: #1f1f1f;
  background: rgb(255,255,255);

  //border-bottom: 1px solid rgb(75,75,75);
  border-bottom: 1px solid rgb(231,231,231);
}

.aside {
  //background: #1f1f1f;
  background: rgb(255,255,255);
  border-right: 1px solid rgb(231,231,231);
  height: 135vh;
  //height: 2000px;
  padding-left: 24px;
  padding-right: 24px;
  padding-top: 10px;
}

.el_menu{
  //background: #1f1f1f;
  background: rgb(255,255,255);
  border: none
}

.main{
  //border-left: 1px solid rgb(75,75,75);
  border-bottom: 1px solid rgb(231,231,231);
  //background: #1f1f1f;
  //background: rgb(255,255,255);
  background: #f3f3f3;
}

.el-row:last-child {
  margin-bottom: 0;
}

.grid-content {
  border-radius: 4px;
  min-height: 36px;
}

.scrollbar-demo-item {
  display: flex;
  align-items: center;
  justify-content: center;
  height: 50px;
  margin: 10px;
  border-radius: 4px;
  //background: #1f1f1f;
  background: rgb(255,255,255);
  color: black;
  font-weight: 700;
  text-align: center;
}
.scrollbar-demo-item:hover {
  background: rgba(161, 161, 161, 0.47);
}
.scrollbar-demo-item:active {
  background: rgba(255, 123, 70, 0.47);
}
</style>
