<template>
  <div class="card text-center" style="width: 59%; border-radius: 0rem">
    <div class="container">
      <div class="content row">
        <div class="col-md-6" style="margin-top: 8%; margin-bottom: 5%">
          <div class="row mt-5 ml-auto mr-auto">
            <fg-input
              class="col-md-9 col-12"
              style="
                border: 0px;
                float: none;
                margin: 0px auto;
                padding-top: 3px;
                padding-bottom: 0px;
              "
              v-model="user.id"
              type="text"
              autocomplete="off"
              placeholder="아이디"
            ></fg-input>
            <fg-input
              class="col-md-9 col-12"
              style="
                border: 0px;
                float: none;
                margin: 0px auto;
                padding-top: 3px;
                padding-bottom: 0px;
              "
              v-model="user.password"
              placeholder="비밀번호"
              type="password"
              autocomplete="off"
              @keyup.enter="clickLogin"
            ></fg-input>
          </div>
          <div class="row ml-auto mr-auto">
            <card
              v-if="!errors.requireId"
              class="col-md-6 col-6 text-center"
              style="border-radius: 10px; float: none; margin: 0px auto"
            >
              <h6 class="card-text" style="color: red">
                아이디를 입력해주세요.
              </h6>
            </card>
            <card
              v-if="!errors.requirePw"
              class="col-md-6 col-6 text-center"
              style="border-radius: 10px; float: none; margin: 0px auto"
            >
              <h6 class="card-text" style="color: red">
                비밀번호를 입력해주세요.(영문자/숫자/특수문자)
              </h6>
            </card>
          </div>
          <div
            class="col-md-5 col-6"
            style="float: none; margin: 0px auto; padding-top: 5%"
          >
            <div class="text-center">
              <a
                @click="clickLogin()"
                class="btn btn-info btn-round btn-lg btn-block"
                >로그인</a
              >
            </div>
          </div>
          <h6 style="text-align: center">
            <router-link to="/signup">
              <a class="link" style="color: #888888">계정이 없으신가요?</a>
            </router-link>
          </h6>
          <h6 style="text-align: center">
            <router-link to="/">
              <a class="link" style="color: #888888">메인으로</a>
            </router-link>
          </h6>
        </div>
        <div
          style="background: linear-gradient(60deg, #48c6ef, #6f86d6)"
          class="col-md-6"
        >
          <h4 class="h2-seo" style="color: white; margin-top: 15%">
            Welcome !
          </h4>
          <h2 class="h2-seo" style="color: white; margin-top: 1%">
            Find the property you want
          </h2>
          <div class="h2-seo" style="color: white; margin-top: 10%">
            <h5>어떤집에 살고싶으신가요?..</h5>
          </div>
          <h5 class="h2-seo" style="color: white; margin-top: 5%">
            이제는 1인 가구 시대!!
          </h5>
          <h5 class="h2-seo" style="color: white; margin-top: 5%">
            당신이 원하는 조건에 따라 매물을 추천해 드립니다! 
          </h5>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import { Card, Button, FormGroupInput } from "@/components";
import { mapActions } from "vuex";
export default {
  name: "login-page",
  bodyClass: "login-page",
  data() {
    return {
      color: "linear-gradient(0deg,#abecd6,#fbed96)",
      user: {
        id: "",
        password: "",
      },
      errors: {
        requireId: true,
        requirePw: true,
      },
    };
  },
  methods: {
    ...mapActions("user", ["requestLogin"]),
    clickLogin() {
      if (this.user.id == "") {
        this.errors.requireId = false;
        this.errors.requirePw = true;
        return;
      } else if (this.user.id != "" && this.user.password == "") {
        this.errors.requireId = true;
        this.errors.requirePw = false;
        return;
      } else if (this.user.id != "" && this.user.password != "") {
        this.errors.requireId = true;
        this.errors.requirePw = true;
        this.requestLogin(this.user);
        return;
      }
    },
  },
  components: {
    Card,
    [Button.name]: Button,
    [FormGroupInput.name]: FormGroupInput,
  },
};
</script>
<style scope="scope">
.nav-tabs.nav-tabs-primary > .nav-item > .nav-link.active {
  background-color: linear-gradient(-20deg, #f794a4 0%, #fdd6bd 100%);
}
.input .form-control,
.form-group .el-input__inner,
.el-date-picker .el-input .el-input__inner {
  background-color: #ffffff !important;
  border: 0 !important;
}
.input-group,
.form-group {
  margin-bottom: 0;
  position: relative;
}
</style>