<script setup>
import {ref,getCurrentInstance} from 'vue'
import axios from 'axios'
import { MessagePlugin } from 'tdesign-vue-next';
import {useRouter} from "vue-router";

const router = useRouter();

const { proxy } = getCurrentInstance()
const url = proxy.$website

const loginData = ref({
  username: '',
  password: ''
})

const submit = () => {
  axios.get(url+'/api/aloxing/login',{params:{...loginData.value}})

      .then(res => {
        if(res.data.code === 1){
          window.localStorage.setItem('token_key', res.data.data);
          MessagePlugin.success("登录成功")
          router.push('/main');
        }else{
          MessagePlugin.error("登录失败")
        }
      })
      .catch(err => {
        console.log("出错了")
      })
}
</script>

<template>
  <div class="login" style="width: 100vw;height: 100vh;">
    <div class="login_form" >

      <t-space style="width: 100%" direction="vertical">
        <h1 style="width: 100%;margin-bottom: 40px;color: rgb(0,0,0)">登录</h1>
        <t-input clearable="true" v-model="loginData.username" placeholder="昵 称:" />
        <t-input clearable="true" type="password" v-model="loginData.password" placeholder="密 码:" />
      </t-space>
      <t-space style="margin-top: 70px;width: 100%">
        <t-button style="width: 100%" variant="outline" theme="primary" ghost @click="submit">登录</t-button>
      </t-space>
    </div>
  </div>
</template>

<style scoped>
*{
  box-sizing: border-box;
}
.login{
  padding: 100px;
}
.login_form{
  padding: 40px;
  margin:100px auto;
  background: #ffffff;
  width: 450px;
  height: 400px;
  border: 1px solid #d3d3d3;
  border-radius: 5px;
}
</style>