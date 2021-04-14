<template>
  <div class="vab-logo" :style="{'width':!collapse?'180px':'80px'}">
    <span v-if="!collapse" style="color:#009688">{{title}}</span>
    <!-- <span v-else style="color:#009688">{{title.slice(0,2)}}</span> -->
    <img v-else width=18 :src="logo" alt="">
  </div>
</template>

<script>
  import VabIcon from '@/layout/vab-icon'
  import { mapGetters } from 'vuex'
  export default {
    name: 'VabLogo',
    components: { VabIcon },
    computed: {
      ...mapGetters({
        logo: 'settings/logo',
        title: 'settings/title',
        collapse: 'settings/collapse',
      }),
    },
  }
</script>
<style lang="less" scoped>
  .vab-logo {
    display: flex;
    align-items: center;
    justify-content: center;
    position: fixed;
    top: 0px;
    z-index: 99;
    background: #23262E;
    height: 64px;
    overflow: hidden;
    font-size: 15px;
    color: #fff;
    text-overflow: ellipsis;
    white-space: nowrap;
  }
</style>
