<template>
  <avue-timeline pending :time="true" :time-width="200">
    <avue-timeline-item>北京</avue-timeline-item>
    <avue-timeline-item color="green">长春</avue-timeline-item>
    <avue-timeline-item>
      <div slot="time">2012-12-23</div>
      <div slot="content">到达呼伦贝尔</div>
    </avue-timeline-item>
    <avue-timeline-item icon="el-icon-circle-check-outline">
      <div slot="time">
        <p>2012-12-23</p>
        <p>天气晴</p>
      </div>
      <div slot="content">蒙古的草原</div>
    </avue-timeline-item>
    <avue-timeline-item icon="el-icon-tickets" color="green">
      <div slot="time">
        <p>2012-12-23</p>
        <p>小雨</p>
      </div>
      <div slot="content">
        <h3>春夜洛城闻笛</h3>
        <p>谁家玉笛暗飞声</p>
        <p>散入春风满洛城</p>
        <p>此夜曲中闻折柳</p>
        <p>何人不起故园情</p>
      </div>
    </avue-timeline-item>
    <avue-timeline-item>
      <a href="#" style="color: #409EFF;cursor: pointer;text-decoration: none;">加载更多</a>
    </avue-timeline-item>
  </avue-timeline>
</template>

<script>
export default {}
</script>

<style>
</style>
