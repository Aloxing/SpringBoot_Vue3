<script setup>
import axios from 'axios'
import {ref,getCurrentInstance} from 'vue'
import { MessagePlugin } from 'tdesign-vue-next';


//全局url
const { proxy } = getCurrentInstance()
const url = proxy.$website

//
axios.get(url+"/api/using/words",{params:{token:window.localStorage.getItem("token_key")}}).then(res=>{
  wordNums.value = res.data
  nub.value = res.data.data.length
  for(let i = 0;i<res.data.data.length;i++){
    wordData.value.push(res.data.data[i].word)
    wordTranslate.value.push(res.data.data[i].translate)
  }
}).catch(err=>{
  console.log("出问题啦")
})

const nub = ref(0)
const wordNums = ref({})
const wordData = ref([])
const wordTranslate = ref([])
const word = ref([])

const numbers = ref(0)
const numbers2 = ref(0)

const masterData = ref({
  id:null,
  word:'',
  translate:'',
  createTime:'',
  updateTime:''
})

const addMaster=()=>{
  axios.post(url+"/api/master/insert",masterData.value,{headers:{token:window.localStorage.getItem("token_key")}}).then(res=>{
    if(res.data.code === 1) MessagePlugin.success("恭喜你，完成啦")
    else console.log("出问题啦")
  }).catch(err=>{
    console.log("出问题啦")
  })
}

const deleteUsing=(word,usingTime)=>{
 axios.delete(url+"/api/using/delete",{params:{token:window.localStorage.getItem("token_key"),word:word,usingTime:usingTime}})
     .then(res=>{
       if(res.data.code === 0){
         console.log("出问题啦")
       }
     }).catch(err=>{
   console.log("出问题啦")
 })
}

const submit=()=>{
  if(nub.value === 0){
    MessagePlugin.error("词栈为空")
    return
  }
  let str = ''
  for(let i = 1;i<word.value.length;++i)str += word.value[i]
  if(wordData.value[numbers.value] === str){
    numbers.value++;
    MessagePlugin.success("恭喜你，回答正确")
    word.value = []
  }else{
    MessagePlugin.error("回答错误")
    word.value = []
  }
  if(numbers.value >= wordData.value.length){
    numbers.value = 0;
    numbers2.value++;
  }
  if(numbers2.value >= 10){
    for(let i = 0;i<wordData.value.length;++i){
      masterData.value.word = wordData.value[i]
      masterData.value.translate = wordTranslate.value[i]
      addMaster()
    }
    numbers2.value = 0;
    for(let i =0;i<wordNums.value.data.length;++i){
      deleteUsing(wordNums.value.data[i].word,wordNums.value.data[i].usingTime)
    }
  }
}


</script>

<template>
<div class="top_div">
  <t-space :size="100">
    <t-statistic title="目前词栈" :value="nub" unit="个">
      <template #prefix>
        <ControlPlatformIcon />
      </template>
    </t-statistic>
    <h4>答对次数: {{numbers2}}</h4>
  </t-space>
  <div style="margin-top: 100px;background: #ffffff;
    height: 400px;border-radius: 5px;
    border: 1px solid rgb(231,231,231);;
    text-align: center;padding-top:180px ">
    <t-space>
      <el-input maxlength="1" v-if="wordData.length>0" v-for="i in wordData[numbers].length" v-model="word[i]" style="width: 33px"/>
      <el-button type="primary" @click="submit">提交</el-button>
    </t-space>
    <h4 v-if="wordTranslate.length>0">{{wordTranslate[numbers]}}</h4>
  </div>
</div>
</template>

<style scoped>
*{
  box-sizing: border-box;
}
.top_div{
  height: 700px;
  width: 100%;
  padding: 20px;
  border-radius: 5px;
  background: rgb(255,255,255);
}

</style>