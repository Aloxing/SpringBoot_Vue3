<script setup>
import {ref,getCurrentInstance} from 'vue'
import axios from 'axios'

//全局url
const { proxy } = getCurrentInstance()
const url = proxy.$website


const tableData = ref({})//表格内容
const dataNums = ref({})//获取数据数量
//分页组件

const currentPage = ref(1)
const pageSize = ref(100)
const background = ref(false)
const disabled = ref(false)
const handleSizeChange = (val) => {
  console.log(`${val} items per page`)
}
const handleCurrentChange = (val) => {
  console.log(`current page: ${val}`)
}

//查找值
const dwData=ref('')
const xsData=ref('')

//获取后端信息
//刷新
const SX=()=>{
  axios.get(url+'/api/toefl/words',{params:{currentPage:currentPage.value,pageSize:pageSize.value}})
      .then(res => {
        tableData.value=res.data
      })
      .catch(err => {
        console.log("出错了")
      })
}

axios.get(url+'/api/toefl/words/sum')
    .then(res => {
      dataNums.value=res.data
    })
    .catch(err => {
      console.log("出错了")
    })

axios.get(url+'/api/toefl/words',{params:{currentPage:currentPage.value,pageSize:pageSize.value}})
    .then(res => {
      tableData.value=res.data
    })
    .catch(err => {
      console.log("出错了")
    })

const dwSelect=()=>{
  if(dwData.value==='' || dwData.value===null){
    axios.get(url+'/api/toefl/words',{params:{currentPage:currentPage.value,pageSize:pageSize.value}})
        .then(res => {
          tableData.value=res.data
        })
        .catch(err => {
          console.log("出错了")
        })
    return
  }

  axios.get(url+'/api/toefl/words/select',{params:{word:dwData.value}})
      .then(res => {
        tableData.value=res.data
      })
      .catch(err => {
        console.log("出错了")
      })
}


const xsSelect=()=>{
  if(xsData.value==='' || xsData.value===null){
    axios.get(url+'/api/toefl/words',{params:{currentPage:currentPage.value,pageSize:pageSize.value}})
        .then(res => {
          tableData.value=res.data
        })
        .catch(err => {
          console.log("出错了")
        })
    return
  }

  axios.get(url+'/api/toefl/words/selectany',{params:{word:xsData.value}})
      .then(res => {
        tableData.value=res.data
      })
      .catch(err => {
        console.log("出错了")
      })
}

//添加计划
import { MessagePlugin } from 'tdesign-vue-next';
const PlanWord = ref({
  id:null,
  word:'',
  translate:'',
  createTime:'',
  updateTime:'',
})



const addPlan = (word,translate) => {
  PlanWord.value.word=word
  PlanWord.value.translate=translate
  axios.post(url+'/api/plan/insert',PlanWord.value,
      {headers:
            {
              "Content-Type":"application/json",
              "token":window.localStorage.getItem('token_key')
            }}
  )
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
  PlanWord.value.word=''
  PlanWord.value.translate=''
}


</script>

<template>
  <div class="top">
    <t-row class="top_row" >
      <t-col :flex="2">
        <div>
          <t-input placeholder="定位查找" status="success" clearable="true"
                   style="margin-top: 35px;margin-left: 35px;width: 20%;float: left"
                   v-model="dwData"
          />
          <t-button @click="dwSelect" style="margin-top: 35px;margin-left: 5px" variant="outline"> 查找 </t-button>
        </div>
      </t-col>
      <t-col :flex="3">
        <div>
          <div>
            <t-input placeholder="相似查找" status="success" clearable="true"
                     style="margin-top: 35px;margin-left: 35px;width: 20%;float: left"
                     v-model="xsData"
            />
            <t-button @click="xsSelect" style="margin-top: 35px;margin-left: 5px" variant="outline"> 查找 </t-button>
          </div>
        </div>
      </t-col>
    </t-row>



    <t-row class="content">
      <div style="width:100%;height:100%">
        <el-table :data="tableData.data" style="width: 100%;" max-height="800px">
          <el-table-column fixed prop="word" label="单词(Word)" width="200" />
          <el-table-column align="center" prop="translate" label="解释(Translate)" width="400" />
          <el-table-column align="right" fixed="right" label="" min-width="100">
            <template #default="scope">
              <t-button size="small" variant="text" theme="danger" @click="addPlan(scope.row.word,scope.row.translate)">添加计划</t-button>

            </template>
          </el-table-column>
        </el-table>
        <el-pagination
            style="color: black;margin-top: 40px"
            v-model:current-page="currentPage"
            v-model:page-size="pageSize"
            :page-sizes="[100, 200, 300]"
            :disabled="disabled"
            :background="background"
            layout="total, sizes, prev, pager, next, jumper"
            :total=dataNums.data
            @size-change="handleSizeChange"
            @current-change="handleCurrentChange"
            @click="SX"
        />
      </div>
    </t-row>

  </div>


</template>

<style scoped>
*{
  box-sizing: border-box;
}
.top{
  background: rgb(255,255,255);
  //background: rgba(103, 56, 220, 0.4);
  height: 100px;
  border-radius: 5px;
}
.top_row{
  border-radius: 5px;
  height: 100%;
}
.content{
  margin-top: 10px;
  background: rgb(255,255,255);
  border-radius: 5px;
  height: 100vh;
  width: 100%;
  padding: 20px;
}
.word{
  border-radius: 5px;
  margin-bottom: 10px;
  width: 100%;
  background: #ad6060;
}
</style>