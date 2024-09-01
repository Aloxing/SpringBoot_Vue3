<script setup>
import { ControlPlatformIcon } from 'tdesign-icons-vue-next';
import { ref,getCurrentInstance } from 'vue'
import axios from 'axios'
import { MessagePlugin } from 'tdesign-vue-next';

//全局url
const { proxy } = getCurrentInstance()
const url = proxy.$website

const token = window.localStorage.getItem("token_key");


//计划单词
const tableData = ref({})
const nums = ref(0)

axios.get(url+'/api/plan/words',{params:{token:token}}).then(res=>{
  tableData.value = res.data
  nums.value = res.data.data.length
}).catch(err=>{
  console.log("出错了")
})

//删除计划
const delPlan = (word,createTime) => {
  axios.delete(url+'/api/plan/delete',{params:{token:token,word:word,createTime:createTime}}
  ).then(res=>{
    if(res.data.code === 1){
      MessagePlugin.success("删除成功")
      axios.get(url+'/api/plan/words',{params:{token:token}}).then(res=>{
        tableData.value = res.data
        nums.value = res.data.data.length
      }).catch(err=>{
        console.log("出错了")
      })
    }else{
      MessagePlugin.error("删除失败")
    }
  }).catch(err=>{
    console.log("出错了")
  })
}

//进行背诵
const UsingWord = ref({
  id:null,
  word:'',
  translate:'',
  usingTime:''
})

const addUsing = (word,translate) => {
  UsingWord.value.word = word
  UsingWord.value.translate = translate
  axios.post(url+'/api/using/insert',UsingWord.value,{
    headers:{
      "Content-Type":"application/json",
      "token":window.localStorage.getItem('token_key')
    }
  })
    .then(res => {
      if(res.data.code === 1){
        MessagePlugin.success("添加成功")
      }else{
        MessagePlugin.error("添加失败")
      }
    })
    .catch(err => {
      console.log("出错了")
    })
  UsingWord.value.word = ''
  UsingWord.value.translate = ''
}



</script>

<template>
  <div class="top_divTag">
    <t-space :size="32">
      <t-statistic color="green" title="计划词汇数" :value="nums" unit="个">
        <template #prefix>
          <ControlPlatformIcon />
        </template>
      </t-statistic>
    </t-space>
  </div>
  <div class="main_div">
    <t-space>
      <h3>计划词单</h3>
    </t-space>
    <el-table :data="tableData.data" style="width: 100%;" max-height="500px">
      <el-table-column fixed prop="word" label="单词(Word)" width="200" />
      <el-table-column align="center" prop="translate" label="解释(Translate)" width="400" />
      <el-table-column align="center" prop="createTime" label="添加时间(CreateTime)" width="400" />
      <el-table-column align="right" fixed="right" label="" min-width="100">
        <template #default="scope">
          <t-button size="small" variant="text" theme="danger" @click="delPlan(scope.row.word,scope.row.createTime)">删除计划</t-button>
          <t-button size="small" variant="text" theme="success" @click="addUsing(scope.row.word,scope.row.translate)">进行背诵</t-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<style scoped>
*{
  box-sizing: border-box;
}
.top_divTag{
  height: 200px;
  width: 100%;
  padding: 20px;
  border-radius: 5px;
  background: rgb(255,255,255);
}
.main_div{
  margin-top: 20px;
  height: 600px;
  width: 100%;
  padding: 20px;
  border-radius: 5px;
  background: rgb(255,255,255);
}
</style>