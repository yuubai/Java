<template>
    <div class="demo">
        <el-container>
            <el-main>
                <el-row>
                  <el-carousel height="350px" arrow="never">
                    <el-carousel-item v-for="item in imageBox" :key="item.id">
                        <img :src="item.idView" class="image">
                    </el-carousel-item>
                  </el-carousel>
                </el-row>
                <el-row>
                  <el-col :span="14">
                    <div class="news_box">
                      <h3>重师要闻</h3>
                      <el-table :data="cqnus" style="width: 100%" :show-header=false>
                        <el-table-column>
                        <template slot-scope="scope">{{scope.row.news}}</template>
                        </el-table-column>
                      </el-table>
                    </div>
                  </el-col>
                  <el-col :span="9" :offset="1">
                    <div class="focus_box">
                       <h3>专题聚焦</h3>
                       <el-table :data="cqnus" style="width: 100%" :show-header=false>
                         <el-table-column>
                           <template slot-scope="scope">{{scope.row.focus}}</template>
                         </el-table-column>
                       </el-table>
                    </div>
                  </el-col>
                </el-row>
                <el-row>
                  <el-col :span="14">
                    <div class="dynamic_box">
                       <h3>学术动态</h3>
                       <el-table :data="cqnus" style="width: 100%" :show-header=false>
                         <el-table-column>
                           <template slot-scope="scope">{{scope.row.dynamic}}</template>
                         </el-table-column>
                       </el-table>
                    </div>
                  </el-col>
                  <el-col :span="9" :offset="1">
                    <div class="notice_box">
                       <h3>重要通知</h3>
                        <el-table :data="cqnus" style="width: 100%" :show-header=false>
                          <el-table-column>
                            <template slot-scope="scope">{{scope.row.notice}}</template>
                          </el-table-column>
                        </el-table>
                    </div>
                  </el-col>
                </el-row>
            </el-main>
        </el-container>
    </div>
</template>

<script>
export default{
    name:'Home',
    components:{
    },
    data(){
        return{
            cqnus:[],
            imageBox:[{id:0, idView:require("../../assets/1.jpg")},
            {id:1, idView:require("../../assets/2.jpg")},
            {id:2, idView:require("../../assets/3.jpg")}],
            msg:'',
            search:'',
        }
    },
    create(){
        this.findAllCqnus();
    },
    mounted(){
        this.findAllCqnus();
    },
    methods: {
        findAllCqnus () {
          this.$axios.get("/cqnu/findAllCqnus")
                  .then((res) => {
                    this.cqnus = res.data
                  })
                  .catch(error => {
                    this.$message({
                      type: 'error',
                      message: "查询失败，原因是"+error.data.message
                    });
                  });
        }
      }
}
</script>
<style scoped>
  .el-main {
        background-color: #E9EEF3;
        color: #333;
        text-align: center;
     }
  .image{
        width:100%;
        height:100%;
  }
  .el-row {
        margin-bottom: 10px;
    }
  .row-bg {
        padding: 10px 0;
        background-color: #f9fafc;
    }
  .news_box, .focus_box, .dynamic_box, .notice_box{
        color: white;
        background-color:#a52a2a;
        text-align:center;
  }
</style>
