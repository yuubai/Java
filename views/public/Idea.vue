<template>
    <el-main>
        <el-table :data="courses" style="width: 100%">
            <el-table-column label="教学理念与目标">
                <template slot-scope="scope">{{scope.row.intro}}</template>
            </el-table-column>
        </el-table>
    </el-main>
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
