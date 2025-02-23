<script setup>

</script>

<template>
    <div style="width:100vw; height:100vh; overflow:hidden; display:flex;">
        <div style="flex: 1;background-color: black">
            <el-image style="width: 100%; height: 100%;" fit="cover"
                src="https://getwallpapers.com/wallpaper/full/4/0/1/759898-free-large-desktop-background-images-1920x1080-for-phone.jpg"/>
        </div>
        <div class="home-title">
            <div>Don't do that!!!</div>
            <div>Brother Jie</div>
        </div>
        <div class="right-card">
            <router-view></router-view>
        </div>
    </div>
</template>

<style scoped>
.home-title {
    position: absolute;
    font-size: 100px;
    bottom: 30px;
    left: 30px;
    color: white;
    text-shadow: 0 0 10px black;
}
.right-card {
    width: 30vw;
    min-width: 400px;
    z-index: 1;
    background-color: white;
}
</style>