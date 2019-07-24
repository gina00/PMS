<template>
  <div class="projectManage">
    <header>项目管理</header>

    <el-tabs :tab-position="tabPosition">
      <el-tab-pane label="用户管理">
        <el-row :gutter="32">
          <el-col :xs="24" :sm="24" :lg="10">
            <div class="chart-wrapper">
              <pie-chart />
            </div>
          </el-col>
          <el-col :xs="24" :sm="24" :lg="12">
              <proGress></proGress>
          </el-col>
        </el-row>
      </el-tab-pane>
      <el-tab-pane label="配置管理">配置管理</el-tab-pane>
      <el-tab-pane label="角色管理">角色管理</el-tab-pane>
      <el-tab-pane label="定时任务补偿">定时任务补偿</el-tab-pane>
    </el-tabs>
  </div>
</template>

<script>
import PieChart from "./PieChart";
import proGress from "./progress";
export default {
  components: {
    PieChart,
    proGress
  },
  data() {
    return {
      tabPosition: "right"
    };
  }
};
</script>

<style lang="scss" scoped>
.projectManage {
  header {
    padding-bottom: 20px;
  }
}
.chart-wrapper {
  background: #fff;
  padding: 16px 16px 0;
  margin-bottom: 32px;
}
</style>
