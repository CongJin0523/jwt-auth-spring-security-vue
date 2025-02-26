<script setup>
import {reactive} from "vue";
import {EditPen, Lock, Message, User} from "@element-plus/icons-vue";
import router from "@/router/index.js";

const form = reactive({
    username: '',
    password: '',
    password_repeat: '',
    email: '',
    code: '',
})

const rule = {
    username: [],
    password: [],
    password_repeat: [],
    email: [],
    code: [],
}
</script>

<template>
    <div style="text-align: center; margin: 0 40px">
        <div style="margin-top: 150px">
            <div style="font-size: 25px;font-weight: bold;">Create a AW Account</div>
        </div>
        <div style="margin-top: 50px; width: 100%">
            <el-form :model="form" label-position="top" :rules="rule">
                <el-form-item>
                    <el-input v-model="form.username" placeholder="Username" maxlength="20" type="text">
                        <template #prefix>
                            <el-icon>
                                <User/>
                            </el-icon>
                        </template>
                    </el-input>
                </el-form-item>
                <el-form-item>
                    <el-input v-model="form.password" placeholder="Password" maxlength="20" type="password">
                        <template #prefix>
                            <el-icon>
                                <Lock/>
                            </el-icon>
                        </template>
                    </el-input>
                </el-form-item>
                <el-form-item>
                    <el-input v-model="form.password_repeat" placeholder="Repeat password" maxlength="20"
                              type="password">
                        <template #prefix>
                            <el-icon>
                                <Lock/>
                            </el-icon>
                        </template>
                    </el-input>
                </el-form-item>
                <el-form-item>
                    <el-input v-model="form.password_repeat" placeholder="email" maxlength="20" type="password">
                        <template #prefix>
                            <el-icon>
                                <Message/>
                            </el-icon>
                        </template>
                    </el-input>
                </el-form-item>
                <el-form-item>
                    <el-row :gutter="10" style="width: 100%;">
                        <el-col :span="17">
                            <el-input v-model="form.password_repeat" placeholder="Enter Code" maxlength="20" type="password">
                                <template #prefix>
                                    <el-icon>
                                        <EditPen/>
                                    </el-icon>
                                </template>
                            </el-input>
                        </el-col>
                        <el-col :span="5">
                            <el-button type="success">Get Code</el-button>
                        </el-col>
                    </el-row>
                </el-form-item>
            </el-form>
        </div>
        <div style="margin-top: 50px">
            <el-button type="primary" style="width: 80%">Submit</el-button>
        </div>
        <div style="margin-top: 20px">
            <span style="font-size: 14px;line-height: 15px;">Already have an account? </span>
            <el-link style="translate: 0 -1px" @click="router.push('/')">Log in</el-link>
        </div>
    </div>
</template>

<style scoped>
.el-form-item {
    text-align: left;
    font-weight: bold;
}
</style>