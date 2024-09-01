<script setup>
import { ref } from 'vue'
import axios from "axios";

const color = ref('rgb(255,255,255)')
const input = ref('')//绑定查找单词信息
const WordNum=ref({})

const activeIndex = ref('1')
const handleSelect = (key, keyPath) => {
  console.log(key, keyPath)
}

//分页组件

const currentPage = ref(1)
const pageSize = ref(100)
const background = ref(false)
const disabled = ref(false)
const sum_words = ref({})
const handleSizeChange = (val) => {
  console.log(`${val} items per page`)
}
const handleCurrentChange = (val) => {
  console.log(`current page: ${val}`)
}

//

//获取后端数据
//刷新
const SX=()=>{
  axios.get('http://localhost:8080/api/english/words',{params:{currentPage:currentPage.value,pageSize:pageSize.value}}).then(res => {
    WordNum.value=res.data
  }).catch(err=>{
    console.log("出错了")
  })
}

//查找信息
const select=()=>{

  if(input.value==='' || input.value===null){
    axios.get('http://localhost:8080/api/english/words',{params:{currentPage:currentPage.value,pageSize:pageSize.value}}).then(res => {
      WordNum.value=res.data
    }).catch(err=>{
      console.log("出错了")
    })
    return
  }
  axios.get('http://localhost:8080/api/english/words/select',{params:{word:input.value}}).then(res => {
    WordNum.value=res.data
  }).catch(err=>{
    console.log("出错了")
  })

}

//获取信息
axios.get('http://localhost:8080/api/english/words',{params:{currentPage:currentPage.value,pageSize:pageSize.value}}).then(res => {
  WordNum.value=res.data
}).catch(err=>{
  console.log("出错了")
})

//获取单词总数
axios.get('http://localhost:8080/api/english/words/sum').then(res => {
  sum_words.value=res.data
}).catch(err=>{
  console.log("出错了")
})

</script>

<template>
  <div class="select-word">
    <div style="float: left;margin-left: 10px">
      <h4 style="display: inline-block;color: #252525;margin-top: 20px;margin-right: 10px">单词颜色</h4>
      <el-color-picker v-model="color" show-alpha />
    </div>
    <div style="margin-left: 10px;margin-top: 15px;">

      <el-input
          v-model="input"
          style="width: 100px;"
          placeholder="输入单词"
          clearable
      />

      <el-button style="background: rgb(255,255,255);margin-left: 3px" @click="select">查询</el-button>
    </div>
  </div>

  <div class="select-word">
    <el-pagination
        style="color: black;"
        v-model:current-page="currentPage"
        v-model:page-size="pageSize"
        :page-sizes="[100, 200, 300, 400,500,600,700,800,900,1000]"
        :disabled="disabled"
        :background="background"
        layout="total, sizes, prev, pager, next, jumper"
        :total=sum_words.data
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        @click="SX"
    />
  </div>


  <div class="table-word">
    <el-scrollbar max-height="100%">
      <el-popover
          v-for="item in WordNum.data" :key="item"
          placement="top-start"
          :title="item.word"
          :width="200"
          trigger="click"
          :content="item.translation"
      >
        <template #reference>
          <div :style="{background: color}"  class="word" >
            <!--        <p style="width:100%;text-align: center;float: left;color: #ffffff">{{item.word}}</p>-->
            <el-tag :style="{background: color}" class="tag" type="white">{{item.word}}</el-tag>
          </div>
        </template>
      </el-popover>

    </el-scrollbar>
  </div>

</template>

<style scoped>
*{
  box-sizing: border-box;
}
.select-word {
  display: flex;
  padding: 10px;

  width: 100%;
  height: 80px;
  background: rgb(255, 255, 255);
  border-bottom:  1px solid rgb(231,231,231);
  margin-bottom: 15px;
}
.table-word {
  padding: 15px;
  width: 100%;
  height: 1000px;
  border-radius: 4px;
  border: 1px solid rgb(231,231,231);
  background: rgb(255,255,255);
}

.word {
  display:flex;
  float: left;
  color: black;
  padding: 8px;
  margin: 10px;
  width: 18%;
  height: 80px;
  border-radius: 5px;
  border: 1px solid rgb(231,231,231);
}

.tag{
  background: rgb(255,255,255);
  border:none;
  width: 100%;
  height: 100%
}


.demo-pagination-block + .demo-pagination-block {
  margin-top: 10px;
}
.demo-pagination-block .demonstration {
  margin-bottom: 16px;
}
</style>