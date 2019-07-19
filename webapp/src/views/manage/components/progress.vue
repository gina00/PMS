<template>
  <div>
    <section class="progressBox">
      <div class="topText">
        <span>总任务</span>
        <span>/</span>
        <span>未完成</span>
      </div>
    </section>
    <div class="progressLine">
      <section class="line1">
        <div class="progressText">
          <i class="el-icon-success"></i>
          <span>昨日完成</span>
          <span></span>
        </div>
        <el-progress :percentage="50"></el-progress>
      </section>
      <section class="line1">
        <div>昨日已完成</div>
        <el-progress :percentage="100" :format="format"></el-progress>
      </section>
      <section class="line1">
        <div>昨日已完成</div>
        <el-progress :percentage="100" status="success"></el-progress>
      </section>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style lang="scss" scoped>
.progressBox {
  height: 30px;
  position: relative;
  .topText {
    position: absolute;
    right: 20px;
    margin-bottom: 20px;
  }
  .progressLine {
    margin-top: 20px;
    .line1{
        margin-top: 10px;
    }
  }
}
</style>

