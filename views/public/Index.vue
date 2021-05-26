<template>
    <div class="demo">
        <el-container>
            <el-header height = "170px">
                <img src="../../assets/symbol.jpg" class="symbol">
                <h2>重庆师范大学</h2>
                <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal"
                    background-color="#B22222" text-color="#fff" active-text-color="#ffd04b">
                    <el-menu-item index="首页"><router-link to="/public">首页</router-link></el-menu-item>
                    <el-menu-item index="课程介绍"><router-link to="/cintro">课程介绍</router-link></el-menu-item>
                    <el-menu-item index="教学团队"><router-link to="/cteam">教学团队</router-link></el-menu-item>
                    <el-menu-item index="课程建设"><router-link to="/cbuild">课程建设</router-link></el-menu-item>
                    <el-menu-item index="课程资源"><router-link to="/csource">课程资源</router-link></el-menu-item>
                    <el-menu-item index="问题与答疑"><router-link to="/cproblem">问题与答疑</router-link></el-menu-item>
                    <el-menu-item index="课程研究"><router-link to="/cresearch">课程研究</router-link></el-menu-item>
                    <el-menu-item>
                        <el-input placeholder="请输入搜索内容" style="width:80%" clearable></el-input>
                        <el-button type="primary" style="margin-left: 10px;">搜索</el-button>
                    </el-menu-item>
                </el-menu>
            </el-header>
            <el-main>
                <router-view/>
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
            msg:'',
            search:'',
        }
    },
    methods: {
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
        margin-left:105px;
        border-radius:50px;
        opacity:0.7;
  }
</style>
