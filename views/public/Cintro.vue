<template>
    <div class="demo">
        <el-container>
            <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
                 <el-menu>
                    <div class="title"><h2>课程介绍</h2></div>
                     <el-menu-item>
                         <template slot="title"><i class="el-icon-paperclip"></i><router-link to="/intro">课程简介</router-link></template>
                     </el-menu-item>
                     <el-menu-item>
                         <template slot="title"><i class="el-icon-paperclip"></i><router-link to="/method">教学方法</router-link></template>
                     </el-menu-item>
                     <el-menu-item>
                         <template slot="title"><i class="el-icon-paperclip"></i><router-link to="/arrange">课程安排</router-link></template>
                     </el-menu-item>
                     <el-menu-item>
                         <template slot="title"><i class="el-icon-paperclip"></i><router-link to="/outline">教学大纲</router-link></template>
                     </el-menu-item>
                     <el-menu-item>
                         <template slot="title"><i class="el-icon-paperclip"></i><router-link to="/idea">课程理念与目标</router-link></template>
                     </el-menu-item>
                     <el-menu-item>
                         <template slot="title"><i class="el-icon-paperclip"></i><router-link to="/dynamic">课程动态</router-link></template>
                     </el-menu-item>
                 </el-menu>
            </el-aside>
            <el-main>
                <router-view/>
            </el-main>
        </el-container>
    </div>
</template>
<script>
export default {
  name: 'Home',
  components: {
  },
  data () {
    return {
      courses:[],
      msg: '',
      search: '',
    }
  },
  created() {
    this.findAllCourses();
  },
  mounted(){
    this.findAllCourses();
  },
  methods:{
    findAllCourses () {
      this.$axios.get("/course/findAllCourses")
      .then((res) => {
        this.courses = res.data
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
    h2{
        background-color:#a52a2a;
        color:white;
    }
</style>
