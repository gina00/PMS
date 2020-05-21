<template>
  <div class="app-container">
    <aside>
      每日进度跟踪
      <el-button type="primary" @click="addCard">添加近日工作</el-button>
    </aside>
    <!-- <el-date-picker
      v-model="kanBanDate"
      align="right"
      type="date"
      placeholder="选择日期"
      @change="changeDate"
      value-format="yyyy-MM-dd"
      :picker-options="pickerOptions"
    ></el-date-picker>-->
    <div>
      <el-row :gutter="12">
        <el-col :span="6" v-for="(item,index) in list" :key="index+'c'">
          <el-card class="box-card">
            <div slot="header" class="clearfix">
              <span>{{item.name}}</span>
              <el-button style="float: right; padding: 3px 0" @click="edit(item)" type="text">修改</el-button>
              <el-button
                style="float: right; padding: 3px 0"
                @click="deleteItem(item)"
                type="text"
              >删除</el-button>
            </div>
            <div>今天工作：</div>
            <div
              v-for="(o,index) in item.todayWork"
              :key="index+'ct'"
              class="text item"
            >{{(index+1)+'： ' + o.name }}</div>

            <div>明天计划：</div>
            <div
              v-for="(o,index) in item.tomorrowWork"
              :key="index+'cto'"
              class="text item"
            >{{(index+1)+'： ' + o.name }}</div>
          </el-card>
        </el-col>
      </el-row>
    </div>

    <el-dialog title="添加工作" :visible.sync="dialogVisible" width="60%">
      <el-form ref="form" :model="form" label-width="80px">
        <el-form-item label="姓名">
          <el-input v-model="form.name"></el-input>
        </el-form-item>

        <el-form-item label="时间">
          <el-date-picker
            type="date"
            placeholder="选择日期"
            v-model="form.date"
            value-format="yyyy-MM-dd"
            style="width: 100%;"
          ></el-date-picker>
        </el-form-item>
        <el-form-item label="今日工作">
          <el-row></el-row>
          <el-row :gutter="20" v-for="(item,index) in form.todayWork" :key="index+'s'">
            <el-col :span="11">
              <el-input v-model="item.name">
                <template slot="prepend">工作项</template>
              </el-input>
            </el-col>
            <el-col :span="5">
              <el-input placeholder="剩余工时" v-model="item.residueHour">
                <template slot="prepend">剩余</template>
                <template slot="append">小时</template>
              </el-input>
            </el-col>
            <el-col :span="5">
              <el-input placeholder="全部工时" v-model="item.allHour">
                <template slot="prepend">全部</template>
                <template slot="append">小时</template>
              </el-input>
            </el-col>
          </el-row>
        </el-form-item>
        <el-form-item label="明日工作">
          <el-row></el-row>
          <el-row v-for="(item,index) in form.tomorrowWork" :key="index+'t'">
            <el-input v-model="item.name">
              <template slot="prepend">工作项</template>
            </el-input>
          </el-row>
        </el-form-item>

        <el-form-item>
          <el-button type="primary" @click="onSubmit">立即创建</el-button>
          <el-button @click="cancel">取消</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
  </div>
</template>

<script>
import { addKanban, getList, deleteKanban } from "@/api/kanban";
export default {
  name: "KanBan",
  data() {
    return {
      list: [],
      form: {
        name: "",
        date: new Date(),
        todayWork: [
          {
            name: "",
            allHour: 0,
            residueHour: 0
          },
          {
            name: "",
            allHour: 0,
            residueHour: 0
          },
          {
            name: "",
            allHour: 0,
            residueHour: 0
          }
        ],
        tomorrowWork: [
          {
            name: "",
            allHour: 0,
            residueHour: 0
          },
          {
            name: "",
            allHour: 0,
            residueHour: 0
          },
          {
            name: "",
            allHour: 0,
            residueHour: 0
          }
        ],
        bugs: 0,
        task: 0
      },
      dialogVisible: false,
      kanBanDate: "",
      pickerOptions: {
        disabledDate(time) {
          return time.getTime() > Date.now();
        },
        shortcuts: [
          {
            text: "今天",
            onClick(picker) {
              picker.$emit("pick", new Date());
            }
          },
          {
            text: "昨天",
            onClick(picker) {
              const date = new Date();
              date.setTime(date.getTime() - 3600 * 1000 * 24);
              picker.$emit("pick", date);
            }
          },
          {
            text: "一周前",
            onClick(picker) {
              const date = new Date();
              date.setTime(date.getTime() - 3600 * 1000 * 24 * 7);
              picker.$emit("pick", date);
            }
          }
        ]
      }
    };
  },
  mounted() {
    getList().then(response => {
      this.list = response;
    });
  },
  methods: {
    changeDate() {
      alert(this.kanBanDate);
    },
    addCard() {
      this.dialogVisible = true;
    },
    cancel() {
      this.dialogVisible = false;
    },
    onSubmit() {
      addKanban(this.form).then(
        r => {
          getList().then(response => {
            this.list = response;

            this.dialogVisible = false;
          });
        },
        error => {
          getList().then(response => {
            this.list = response;

            this.dialogVisible = false;
          });
        }
      );

      this.dialogVisible = false;
    },
    deleteItem(item) {
      deleteKanban(item).then(r => {
        getList().then(response => {
          this.list = response;
        });
      });
    },
    edit(item) {
      this.form = { ...item };
      this.dialogVisible = true;
    }
  }
};
</script>
