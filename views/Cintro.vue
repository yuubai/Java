<template>
    <div class="demo">
        <el-container>
            <el-header height = "170px">
                <img src="../assets/symbol.jpg" class="symbol">
                <h2>重庆师范大学</h2>
                <el-menu :default-active="activeIndex2" class="el-menu-demo" mode="horizontal"
                    background-color="#B22222" text-color="#fff" active-text-color="#ffd04b">
                    <el-menu-item index="首页">首页</el-menu-item>
                    <el-menu-item index="课程介绍">课程介绍</el-menu-item>
                    <el-menu-item index="教学团队">教学团队</el-menu-item>
                    <el-menu-item index="课程建设">课程建设</el-menu-item>
                    <el-menu-item index="课程资源">课程资源</el-menu-item>
                    <el-menu-item index="问题与答疑">问题与答疑</el-menu-item>
                    <el-menu-item index="课程研究">课程研究</el-menu-item>
                    <el-menu-item>
                        <el-input placeholder="请输入搜索内容" style="width:80%" clearable></el-input>
                        <el-button type="primary" style="margin-left: 10px;">搜索</el-button>
                    </el-menu-item>
                </el-menu>
            </el-header>
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
                        <el-table-column width="710">
                        <template slot-scope="scope">{{scope.row.news}}</template>
                        </el-table-column>
                      </el-table>
                    </div>
                  </el-col>
                  <el-col :span="9" :offset="1">
                    <div class="focus_box">
                       <h3>专题聚焦</h3>
                       <el-table :data="cqnus" style="width: 100%" :show-header=false>
                         <el-table-column width="450">
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
                         <el-table-column width="710">
                           <template slot-scope="scope">{{scope.row.dynamic}}</template>
                         </el-table-column>
                       </el-table>
                    </div>
                  </el-col>
                  <el-col :span="9" :offset="1">
                    <div class="notice_box">
                       <h3>重要通知</h3>
                        <el-table :data="cqnus" style="width: 100%" :show-header=false>
                          <el-table-column width="450">
                            <template slot-scope="scope">{{scope.row.notice}}</template>
                          </el-table-column>
                        </el-table>
                    </div>
                  </el-col>
                </el-row>
            </el-main>
            <el-footer>2018级 软件工程 胡洪</el-footer>
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
            imageBox:[{id:0, idView:require("../assets/1.jpg")},
            {id:1, idView:require("../assets/2.jpg")},
            {id:2, idView:require("../assets/3.jpg")}],
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
  .el-header{
        background-color: #800000;
        color: #333;
      }
  .el-footer{
        background-color: #800000;
        color: white;
        text-align:center;
        line-height: 60px;
  }
  .el-main {
        background-color: #E9EEF3;
        color: #333;
        text-align: center;
     }
  .symbol{
        position:absolute;
        width:100px;
        height:100px;
        border-radius:50px;
        margin:left;
        opacity:0.9;
    }
  h2{
        position:absolute;
        width:1200px;
        text-align:center;
        font-family:楷体;
        font-size:40px;
        color:white;
  }
  .el-menu{
        position:absolute;
        margin-top:109px;
        border-radius:50px;
        opacity:0.7;
  }
  .image{
        width:100%;
        height:100%;
  }
  .el-row {
        margin-bottom: 20px;
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
