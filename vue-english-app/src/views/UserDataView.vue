<script setup>
import axios from 'axios'
import {ref,getCurrentInstance} from 'vue'
import { MessagePlugin } from 'tdesign-vue-next';
import {useRouter} from "vue-router";

const router = useRouter();


//全局url
const { proxy } = getCurrentInstance()
const url = proxy.$website

const userData = ref({
  id:null,
  username:'',
  password:'',
  email:'',
  content:''
})

const token = window.localStorage.getItem("token_key");

axios.get(url+'/api/user/data',{params:{token:token}}).then(res => {
  userData.value = res.data.data[0]
}).catch(err=>{
  console.log("出错了")
})

//弹出框
const updateUsername = ref(false);
const updatePassword = ref(false);
const updateEmail = ref(false);
const updateContent = ref(false);
const username = ref('');
const password = ref('');
const email = ref('');
const content = ref('');

//下拉菜单

const options = [
  {
    content: '修改昵称',
    value: 1,
    onClick: () => updateUsername.value = true,
  },
  {
    content: '修改密码',
    value: 2,
    onClick: () => updatePassword.value = true,
  },
  {
    content: '修改邮箱',
    value: 3,
    onClick: () => updateEmail.value = true,
  },
  {
    content: '修改简介',
    value: 4,
    onClick: () => updateContent.value = true,
  },
];

const updateUsernameFunc=()=>{
  axios.get(url+'/api/user/update/username',{params:{name:username.value,token:token}}).then(res => {
    if(res.data.code===1){
      MessagePlugin.success('修改成功!')
      router.push('/');
      MessagePlugin.error('重新登录!')
      updateUsername.value = false;
      userData.value.username=username.value
    }else{
      MessagePlugin.error('修改失败!')
    }
  }).catch(err=>{
    console.log("出错了")
  })
}

const updatePasswordFunc=()=>{
  axios.get(url+'/api/user/update/password',{params:{word:password.value,token:token}}).then(res => {
    if(res.data.code===1){
      MessagePlugin.success('修改成功!')
      router.push('/');
      MessagePlugin.error('重新登录!')
      updateUsername.value = false;
      userData.value.password=password.value
    }else{
      MessagePlugin.error('修改失败!')
    }
  }).catch(err=>{
    console.log("出错了")
  })
}

const updateEmailFunc=()=>{
  axios.get(url+'/api/user/update/email',{params:{mail:email.value,token:token}}).then(res => {
    if(res.data.code===1){
      MessagePlugin.success('修改成功!')
      updateUsername.value = false;
      userData.value.email=email.value
    }else{
      MessagePlugin.error('修改失败!')
    }
  }).catch(err=>{
    console.log("出错了")
  })
}

const updateContentFunc=()=>{
  axios.get(url+'/api/user/update/content',{params:{tent:content.value,token:token}}).then(res => {
    if(res.data.code===1){
      MessagePlugin.success('修改成功!')
      updateUsername.value = false;
      userData.value.content=content.value
    }else{
      MessagePlugin.error('修改失败!')
    }
  }).catch(err=>{
    console.log("出错了")
  })
}

</script>

<template>
  <div class="topDiv">
    <t-space>
      <t-space>
        <t-dropdown :options="options" :min-column-width="88">
          <t-button theme="success" variant="text">修改信息</t-button>
        </t-dropdown>
      </t-space>
    </t-space>
  </div>
  <div class="mainDiv">
    <t-descriptions bordered table-layout="auto" title="个人信息">
      <t-descriptions-item label="序 号:">{{userData.id}}</t-descriptions-item>
      <t-descriptions-item label="昵 称:">{{userData.username}}</t-descriptions-item>
      <t-descriptions-item label="密 码:">{{userData.password}}</t-descriptions-item>
      <t-descriptions-item label="邮 箱:">{{userData.email}}</t-descriptions-item>
      <t-descriptions-item label="简 介:">{{userData.content}}</t-descriptions-item>
    </t-descriptions>
  </div>

  <t-dialog
      v-model:visible="updateUsername"
      attach="body"
      header="修改昵称"
      destroy-on-close
      :on-confirm="updateUsernameFunc"
  >
    <template #body>
      <div>
        <t-input v-model="username" clearable="true" ></t-input>
      </div>
    </template>
  </t-dialog>

  <t-dialog
      v-model:visible="updatePassword"
      attach="body"
      header="修改密码"
      destroy-on-close
      :on-confirm="updatePasswordFunc"
  >
    <template #body>
      <div>
        <t-input v-model="password" clearable="true" ></t-input>
      </div>
    </template>
  </t-dialog>

  <t-dialog
      v-model:visible="updateEmail"
      attach="body"
      header="修改邮箱"
      destroy-on-close
      :on-confirm="updateEmailFunc"
  >
    <template #body>
      <div>
        <t-input v-model="email" clearable="true" ></t-input>
      </div>
    </template>
  </t-dialog>

  <t-dialog
      v-model:visible="updateContent"
      attach="body"
      header="修改简介"
      destroy-on-close
      :on-confirm="updateContentFunc"
  >
    <template #body>
      <div>
        <t-input v-model="content" clearable="true" ></t-input>
      </div>
    </template>
  </t-dialog>

</template>

<style scoped>
.topDiv{
  border-radius: 5px;
  padding: 20px;
  background: rgb(255,255,255);
}
.mainDiv{
  margin-top: 20px;
  border-radius: 5px;
  padding: 20px;
  background: rgb(255,255,255);
}
.dialog-attach-wrap {
  position: relative;
  height: 400px;
  padding: 20px;
  border: 1px solid #ebedf0;
  border-radius: 2px;
  overflow: hidden;
}
</style>