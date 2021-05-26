<template>
  <div>
    <div style="margin-top:50px;">
      <el-input v-model="informName" placeholder="请输入通知名称" style="width:80%" clearable></el-input>
      <el-button type="primary" style="margin-left: 10px;" @click="searchInformByName" >搜索</el-button>
      <el-button type="primary" style="margin-left:10px;margin-bottom: 20px;" @click="showDialog">新增通知</el-button>
    </div>
    <div style="">
      <el-table
          @selection-change="handleSelectionChange"
          :data="informs"
          border>
        <el-table-column
            type="selection"
            width="60">
        </el-table-column>
        <el-table-column
            prop="uid"
            label="通知序号"
            width="90">
        </el-table-column>
        <el-table-column
            prop="name"
            label="通知名称"
            width="90">
        </el-table-column>
        <el-table-column
            prop="time"
            label="发布时间"
            width="90">
        </el-table-column>

        <el-table-column
            prop="info"
            label="通知内容"
            width="150">
        </el-table-column>

        <el-table-column width="160"
                         label="操作">
          align="left">
          <template slot-scope="scope">
            <el-button
                size="mini"
                @click="handleEdit(scope.row)">编辑</el-button>
            <el-button
                size="mini"
                type="danger"
                @click="handleDelete(scope.row)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
      <el-button type="danger" size="mini" style="margin-top: 12px" :disabled="multipleSelection.length === 0" @click="deleteInforms">批量删除</el-button>
    </div>


    <el-dialog :title="dialogTitle[dialogStatus]" :visible.sync="dialogFormVisible" center>
      <el-form :model="form" :rules="rules" ref="">
        <el-form-item label="通知名称" :label-width="formLabelWidth" prop="name">
          <el-input v-model="form.name" autocomplete="off" placeholder="请输入名称"></el-input>
        </el-form-item>

        <el-form-item label="通知时间" :label-width="formLabelWidth" prop="time">
            <el-input v-model="form.time" autocomplete="off" placeholder="请输入时间"></el-input>
        </el-form-item>
        <el-form-item label="通知内容" :label-width="formLabelWidth" prop="info">
          <el-input v-model="form.info" autocomplete="off" placeholder="请输入内容"></el-input>
        </el-form-item>

      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="submitInform">确 定</el-button>
      </div>
    </el-dialog>
    <el-upload
        style="margin-top:20px;"
        action="/upload"
        multiple
        :on-success="handleSuccess"
        :limit="3"
        :file-list="fileList">
      <el-button size="small" type="primary">点击上传</el-button>
    </el-upload>
  </div>
</template>

<script>
// @ is an alias to /src


this.$refs.inform.validate = function (param) {
  
}
export default {
  name: 'Inform',
  components: {
  },
  data () {
    return {
      fileList: [],
      informName: '',
      multipleSelection: [],
      dialogTitle: {
        addInform: "新增通知",
        editInform: "编辑通知"
      },
      dialogStatus: "",
      rules: {
        name: [
          {required: true, message: '请输入姓名',},
          {min: 2, max: 15, message: '名字长度为2--15',},
        ],
        time: [
          {required: true, message: '请输入',},
        ],
        info: [
          {required: true, message: '请输入',},
        ],
      },

      form: {
        name: '',
        time: '',
        info: '',

      },
        msg: '',
        search: '',
        dialogFormVisible: false,
      formLabelWidth: '120px',
      informs: [],

    }
  },
  created() {
    this.findAllInforms();
  },
  watch:{
    informName () {
      this.findAllInforms();
    }
  },
  methods: {
    // deleteFile (file) {
    //   console.log(file)
    // },

    handleSuccess (file) {
      const filename = file.name;
      this.$message({
        message: '文件上传成功！',
        type: 'success'
      });
    },
    searchInformByName () {
      if (this.informName !== '') {
        this.$axios.get("/inform/findInformByName?name="+this.informName).then( (resp)=> {
          this.informs = resp.data;
        }).catch( (error)=>{
          this.$message({
            type: 'error',
            message: "查询失败，原因是"+error.data.message
          });
        })
      }
    },
    deleteInforms () {
      this.$confirm('此操作将永久删除教师, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        let ids = '?';
        this.multipleSelection.forEach( (item)=>{
          ids += 'ids='+item.uid+'&'
        });
        this.$axios.post("/inform/deleteInformsByIds"+ids).then( (resp)=> {
          if (resp) {
            this.findAllInforms();
            this.$message.success("删除成功！");
          }
        })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        });
      });
    },
    handleSelectionChange(val) {
      this.multipleSelection = val;
      console.log(val)
    },
    submitInform () {
      if (this.dialogStatus === 'addInform'){
        this.addInform();
      } else if(this.dialogStatus === "editInform") {
        this.editInform();
      }
    },
    findAllInforms () {
      this.$axios.get("/inform/findAllInforms")
          .then((res) => {
            // debugger
            this.informs = res.data
          })
          .catch(error => {
            this.$message({
              type: 'error',
              message: "查询失败，原因是"+error.data.message
            });
          });
    },
    handleEdit (row) {//编辑
      this.dialogFormVisible = true;
      this.dialogStatus = "editInform";
      this.form.uid = row.uid;
      this.form.name = row.name;
      this.form.time = row.time;
      this.form.info = row.info;

    },
    handleDelete (row) {
      this.$confirm('此操作将永久删除该通知, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.$axios.post("/inform/deleteInform?uid="+row.uid).then ((resp)=>{
          this.$message.success("删除成功!")
          this.findAllInforms();
        })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        });
      });
    },
    showDialog () {
      this.form.uid = '';
      this.form.name = '';
      this.form.time = '';
      this.form.info = '';

      this.dialogFormVisible = true;
      this.dialogStatus = "addInform";
    },
    addInform () {
      this.$refs.inform.validate = function (param) {
        
      }
      this.$refs.inform.validate((valid) => {
        if (valid) {
          this.$axios.post("/inform/addInform",this.form).then( (response)=>{
            if (response) {
              this.dialogFormVisible = false;
              this.$message.success("添加成功！");
              this.findAllInforms();
            }
          }).catch((error)=>{
            this.$message({
              message: '添加数据失败，原因是'+error.data.message,
              type: 'error'
            })
          })
        } else {
          this.$message({
            message: '!!请按要求输入所有字段!!',
            type: 'error'
          })
          return false;
        }
      });
    },
    editInform () {

      this.$axios.post("/inform/updateInform",this.form).then( (resp)=>{
        this.dialogFormVisible = false;
        this.$message.success("修改保存成功!");
        this.findAllInforms();
      }).catch( (error)=> {
        this.$message({
          message: '数据更新失败，原因是'+error.data.message,
          type: 'error'
        })
      })
    }
  }
}
</script>
<style scoped>
.table {
  margin: 0 auto;
  clear: both;
}
</style>
