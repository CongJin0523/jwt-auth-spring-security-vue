<script setup>
import {logout} from "@/net/index.js";
import router from "@/router/index.js";

function userLogout() {
    logout(() => router.push('/'));
}
</script>

<template>
    <div style="display: flex; flex-direction: column; justify-content: center;">
        <el-button @click="userLogout">Logout</el-button>
    </div>
</template>

<style scoped>

</style>