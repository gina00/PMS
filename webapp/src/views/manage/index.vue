<template>
  <div class="manageBox">
    <el-card shadow="never">
      <timePanel class="timeBox"></timePanel>
    </el-card>
    <el-card shadow="never">
      <project></project>
    </el-card>
    <el-card shadow="never">
      <LineChart :chart-data="lineChartData"></LineChart>
    </el-card>
  </div>
</template>

<script>
import timePanel from "./components/timePanel";
import project from "./components/project";
import LineChart from './components/LineChart'
const lineChartData = {
  newVisitis: {
    expectedData: [100, 120, 161, 134, 105, 160, 165],
    actualData: [120, 82, 91, 154, 162, 140, 145]
  },
  messages: {
    expectedData: [200, 192, 120, 144, 160, 130, 140],
    actualData: [180, 160, 151, 106, 145, 150, 130]
  },
  purchases: {
    expectedData: [80, 100, 121, 104, 105, 90, 100],
    actualData: [120, 90, 100, 138, 142, 130, 130]
  },
  shoppings: {
    expectedData: [130, 140, 141, 142, 145, 150, 160],
    actualData: [120, 82, 91, 154, 162, 140, 130]
  }
}
export default {
  components: {
    timePanel,
    project,
    LineChart
  },
  data() {
    return {
      lineChartData: lineChartData.newVisitis
    }
  }
};
</script>

<style lang="scss" scoped>
.manageBox{
  padding: 20px;
  .el-card{
    margin-bottom: 20px;
  }
}
.timeBox {
  padding: 20px;
}
</style>

