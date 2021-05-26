<template>
  <div>
    <div style="margin-top:50px;">
      <el-input v-model="teacherName" placeholder="请输入教师姓名" style="width:75%" clearable></el-input>
      <el-button type="primary" icon="el-icon-search" style="margin-left: 10px;" @click="searchTeacherByName">搜索</el-button>
      <el-button type="primary" style="margin-left:10px;margin-bottom: 20px;" @click="showDialog">新增教师</el-button>
    </div>
    <div>
      <el-table
              @selection-change="handleSelectionChange"
              :data="teachers"
              border>
        <el-table-column
                type="selection"
                width="50">
        </el-table-column>
        <el-table-column
                prop="uid"
                label="职工号"
                width="70">
        </el-table-column>
        <el-table-column
                prop="name"
                label="姓名"
                width="70">
        </el-table-column>
        <el-table-column
                prop="sex"
                label="性别"
                width="60">
        </el-table-column>
        <el-table-column
                prop="age"
                label="年龄"
                width="60">
        </el-table-column>
        <el-table-column
                prop="folk"
                label="民族"
                width="60">
        </el-table-column>
        <el-table-column
                prop="np"
                label="籍贯"
                width="80">
        </el-table-column>
        <el-table-column
                prop="identify"
                label="身份证号码"
                width="180">
        </el-table-column>
        <el-table-column
                prop="ps"
                label="政治面貌"
                width="90">
        </el-table-column>
        <el-table-column
                prop="ms"
                label="婚姻状况"
                width="90">
        </el-table-column>
        <el-table-column
                prop="graduate"
                label="毕业院校"
                width="140">
        </el-table-column>
        <el-table-column
                prop="tel"
                label="联系电话"
                width="120">
        </el-table-column>
        <el-table-column
                prop="email"
                label="电子邮箱"
                width="140">
        </el-table-column>
        <el-table-column
                prop="address"
                label="家庭地址"
                width="200">
        </el-table-column>
        <el-table-column
                 prop="college"
                 label="就职学院及专业"
                 width="280">
        </el-table-column>
        <el-table-column
                prop="subject"
                label="学科"
                width="110">
        </el-table-column>
        <el-table-column
                prop="teach_class"
                label="班级"
                width="90">
        </el-table-column>
        <el-table-column
                prop="num"
                label="班级人数"
                width="80">
        </el-table-column>
        <el-table-column
                prop="passrate"
                label="班级及格率"
                width="95">
        </el-table-column>
        <el-table-column
                prop="post"
                label="职位"
                width="80">
        </el-table-column>
        <el-table-column
                prop="evaluate"
                label="评价"
                width="70">
        </el-table-column>
        <el-table-column
                prop="ed"
                label="入职日期"
                width="130">
        </el-table-column>
        <el-table-column
                prop="hobby"
                label="兴趣爱好"
                width="140">
        </el-table-column>
        <el-table-column
                label="操作"
                width="150">
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
      <el-button type="danger" size="mini" style="margin-top: 12px" :disabled="multipleSelection.length === 0" @click="deleteTeachers">批量删除</el-button>
    </div>
    <el-dialog :title="dialogTitle[dialogStatus]" :visible.sync="dialogFormVisible" center>
      <el-form :model="form" :rules="rules" ref="teacher">
        <el-form-item label="姓名" :label-width="formLabelWidth" prop="name">
          <el-input v-model="form.name" placeholder="请输入姓名" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="性别" :label-width="formLabelWidth" prop="sex">
          <el-select v-model="form.sex" placeholder="请选择性别" style="width: 100%">
            <el-option
                    v-for="item in sex"
                    :key="item.value"
                    :value="item.label">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="年龄" :label-width="formLabelWidth" prop="age">
          <el-input v-model.number="form.age" placeholder="请输入年龄" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="民族" :label-width="formLabelWidth" prop="folk">
          <el-input v-model="form.folk" placeholder="请输入民族" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="籍贯" :label-width="formLabelWidth" prop="np">
          <el-input v-model="form.np" placeholder="请输入籍贯" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="身份证号码" :label-width="formLabelWidth" prop="identify">
          <el-input v-model="form.identify" placeholder="请输入身份证号码" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="政治面貌" :label-width="formLabelWidth" prop="ps">
          <el-select v-model="form.ps" placeholder="请选择政治面貌" style="width: 100%">
            <el-option
                    v-for="item in ps"
                    :key="item.value"
                    :value="item.label">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="婚姻状况" :label-width="formLabelWidth" prop="ms">
           <el-select v-model="form.ms" placeholder="请选择婚姻状况" style="width: 100%">
             <el-option
                     v-for="item in ms"
                     :key="item.value"
                     :value="item.label">
             </el-option>
           </el-select>
        </el-form-item>
        <el-form-item label="联系电话" :label-width="formLabelWidth" prop="tel">
           <el-input v-model="form.tel" placeholder="请输入联系电话" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="电子邮件" :label-width="formLabelWidth" prop="email">
           <el-input v-model="form.email" placeholder="请输入电子邮件" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="家庭住址" :label-width="formLabelWidth" prop="address">
           <el-input v-model="form.address" placeholder="请输入家庭住址" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="就职学院专业" :label-width="formLabelWidth" prop="college">
           <el-cascader
                    v-model="form.college"
                    style="width:100%"
                    :options="college"
                    :props="{ expandTrigger: 'hover'}"
                    @change="handleChange"></el-cascader>
        </el-form-item>
        <el-form-item label="毕业院校" :label-width="formLabelWidth" prop="graduate">
          <el-input v-model="form.graduate" placeholder="请输入毕业院校" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="学科" :label-width="formLabelWidth" prop="subject">
          <el-select v-model="form.subject" placeholder="请选择学科" style="width: 100%">
            <el-option
                    v-for="item in subject"
                    :key="item.value"
                    :value="item.label">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="班级" :label-width="formLabelWidth" prop="teach_class">
          <el-input v-model="form.teach_class" placeholder="例如：软工1班" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="班级人数" :label-width="formLabelWidth" prop="num">
          <el-input v-model.number="form.num" placeholder="请输入班级人数，例如：54" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="班级及格率" :label-width="formLabelWidth" prop="passrate">
          <el-slider
            v-model="form.passrate"
            show-input>
          </el-slider>
        </el-form-item>
        <el-form-item label="职位" :label-width="formLabelWidth" prop="post">
          <el-input v-model="form.post" placeholder="若无其他职位请输入讲师" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="评价" :label-width="formLabelWidth" prop="evaluate">
          <el-select v-model="form.evaluate" placeholder="请选择评价" style="width: 100%">
            <el-option
                   v-for="item in evaluate"
                   :key="item.value"
                   :value="item.label">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="入职日期" :label-width="formLabelWidth" prop="ed">
          <el-date-picker
            v-model="form.ed"
            style="width:100%"
            type="date"
            placeholder="请选择入职日期"
            value-format="yyyy-MM-dd"
          ></el-date-picker>
        </el-form-item>
        <el-form-item label="兴趣爱好" :label-width="formLabelWidth" prop="hobby">
          <el-checkbox-group v-model="form.hobby">
            <el-checkbox label="阅读" ></el-checkbox>
            <el-checkbox label="音乐" ></el-checkbox>
            <el-checkbox label="蹦极" ></el-checkbox>
            <el-checkbox label="跑步" ></el-checkbox>
            <el-checkbox label="游戏" ></el-checkbox>
            <el-checkbox label="登山" ></el-checkbox>
            <el-checkbox label="旅游" ></el-checkbox>
            <el-checkbox label="美食" ></el-checkbox>
            <el-checkbox label="滑翔" ></el-checkbox>
            <el-checkbox label="购物" ></el-checkbox>
          </el-checkbox-group>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="submitTeacher">确 定</el-button>
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


export default {
  name: 'Home',
  components: {
  },
  data () {
    const ageValidator = (rule, value, callback)=>{
          if(value < 20) return callback(new Error('年龄不小于20'))
          if(value > 60) return callback(new Error('年龄不大于60'))
          callback()
    }
    const idValidator = (rule, value, callback)=>{
          if(value && (!(/\d{17}[\d|x]|\d{15}/).test(value)||(value.length !== 15 && value.length !== 18)))
          return callback(new Error('身份证号码不符合规范'))
          callback()
    }
    const telValidator = (rule, value, callback)=>{
          if (value !== '') {
                var reg=/^1[3456789]\d{9}$/;
                if(!reg.test(value)){
                    callback(new Error('请输入有效的手机号码'));
                 }
          }
          callback();
    }
    const emailValidator = (rule, value, callback)=>{
          if (value !== '') {
                var reg=/^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
                if(!reg.test(value)){
                    callback(new Error('请输入有效的邮箱'));
                }
          }
          callback()
    }
    return {
      fileList: [],
      teacherName: '',
      multipleSelection:[],
      dialogTitle: {
        addTeacher: "新增教师",
        editTeacher: "编辑教师"
      },
      dialogStatus: "",
      rules: {
        name: [
          { required: true, message: '请输入姓名', trigger: 'blur'},
          { min:2, message:'姓名不能少于2个字'},
          { max:5, message:'姓名不能多于5个字'},
          { pattern:/^[\u4e00-\u9fa5]+$/,
            message:'请输入不含空格的中文名',
            trigger: 'blur'
          }
        ],
        sex: [
          { required: true, message: '请选择性别', trigger: 'change' }
        ],
        age: [
          { required: true, message: '年龄不能为空'},
          { type: 'number', message: '年龄必须为数字值'},
          { validator:ageValidator}
        ],
        folk:[
          { required: true, message: '请输入民族', trigger: 'blur'}
        ],
        np:[
          { required: true, message: '请输入籍贯', trigger: 'blur'}
        ],
        identify:[
          { required: true, message: '请输入身份证号码', trigger: 'blur'},
          {validator:idValidator}
        ],
        ps: [
          { required: true, message: '请选择政治面貌', trigger: 'change'}
        ],
        ms: [
          { required: true, message: '请选择婚姻状况', trigger: 'change'}
        ],
        tel: [
          { required: true, message: '请输入联系电话', trigger: 'blur'},
          {validator:telValidator}
        ],
        email: [
          { required: true, message: '请输入电子邮件', trigger: 'blur'},
          {validator:emailValidator}
        ],
        address: [
          { required: true, message: '请输入家庭住址', trigger: 'blur'}
        ],
        college: [
          { required: true, message: '请选择就职学院专业', trigger: 'blur'}
        ],
        graduate:[
          { required: true, message: '请输入毕业院校', trigger: 'blur'}
        ],
        subject: [
          { required: true, message: '请选择学科', trigger: 'change'}
        ],
        teach_class:[
          { required: true, message: '请输入班级', trigger: 'blur'}
        ],
        num: [
          { required: true, message: '请输入班级人数'},
          { type: 'number', message: '班级人数必须为数字值'}
        ],
        passrate: [
          { required: true, message: '班级及格率'},
          { type: 'number'}
        ],
        post: [
          { required: true, message: '请输入职务', trigger: 'blur'}
        ],
        evaluate: [
          { required: true, message: '请选择评价', trigger: 'change'}
        ],
        ed: [
          { required: true, message: '请输入入职日期', trigger: 'change'}
        ],
      },
      sex: [{
        value: '1',
        label: '男'
      }, {
        value: '2',
        label: '女'
      }],
      ps:[{
        value:'1',
        label:'党员'
      },{
        value:'2',
        label:'预备党员'
      },{
        value:'3',
        label:'群众'
      }],
      ms:[{
        value:'1',
        label:'已婚'
      },{
        value:'2',
        label:'未婚'
      }],
      college:[{
        value:'计算机与信息科学学院',
        label:'计算机与信息科学学院',
        children:[{
            value:'软件工程',
            label:'软件工程'
        },{
            value:'信息科学与管理',
            label:'信息科学与管理'
        },{
            value:'电子商务',
            label:'电子商务'
        }]
      },{
        value:'数学学院',
        label:'数学学院',
        children:[{
            value:'数学与应用数学',
            label:'数学与应用数学'
        },{
            value:'信息与计算数学',
            label:'信息与计算数学'
        }]
      },{
        value:'马克思主义学院',
        label:'马克思主义学院',
        children:[{
            value:'马克思主义哲学',
            label:'马克思主义哲学'
        },{
            value:'思想政治教育',
            label:'思想政治教育'
        },{
            value:'马克思主义政治学',
            label:'马克思主义政治学'
        }]
      },{
        value:'外国语语学院',
        label:'外国语语学院',
        children:[{
            value:'英语',
            label:'英语'
        },{
            value:'法语',
            label:'法语'
        },{
            value:'德语',
            label:'德语'
        },{
            value:'其他语种',
            label:'其他语种'
        }]
      },{
        value:'历史学院',
        label:'历史学院'
      }],
      subject: [{
        value:'1',
        label:'现代语文'
      },{
        value:'2',
        label:'线性代数'
      },{
        value:'3',
        label:'大学英语'
      },{
        value:'4',
        label:'中国通史'
      },{
        value:'5',
        label:'Java程序设计'
      },{
        value:'6',
        label:'马克思主义原理'
      },{
        value:'7',
        label:'形势与政策'
      }],
      evaluate:[{
        value:'1',
        label:'特优'
      },{
         value:'2',
         label:'优秀'
      },{
        value:'3',
        label:'良好'
      },{
        value:'3',
        label:'一般'
      }],
      msg: '',
      teachers:[],
      search: '',
      dialogFormVisible: false,
      form: {
        name: '',
        age: '',
        sex: '',
        subject: '',
        teach_class: '',
        num: '',
        post: '',
        evaluate: '',
        ed: '',
        folk:'',
        tel:'',
        email:'',
        np:'',
        identify:'',
        address:'',
        college:'',
        graduate:'',
        ps:'',
        ms:'',
        passrate:'',
        hobby:[],
      },
      formLabelWidth: '120px',
    }
  },
  created() {
    this.findAllTeachers();
  },
  watch:{
    teacherName () {
        this.findAllTeachers();
    }
  },
  methods: {
    // deleteFile (file) {
    //   console.log(file)
    // },
    handleChange(value){
       console.log(value)
    },
    handleSuccess (file) {
      const filename = file.name;
      this.$message({
        message: '文件上传成功！',
        type: 'success'
      });
    },
    searchTeacherByName () {
        if (this.teacherName !== '') {
            this.$axios.get("/teacher/findTeacherByName?name="+this.teacherName).then( (resp)=> {
                this.teachers = resp.data;
            }).catch( (error)=>{
                this.$message({
                    type: 'error',
                    message: "查询失败，原因是"+error.data.message
                });
            })
        }
    },
    deleteTeachers () {
      this.$confirm('此操作将永久删除教师, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        let ids = '?';
        this.multipleSelection.forEach( (item)=>{
          ids += 'ids='+item.uid+'&'
        });
        this.$axios.post("/teacher/deleteTeachersByIds"+ids).then( (resp)=> {
          if (resp) {
            this.findAllTeachers();
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
    submitTeacher () {
      if (this.dialogStatus === 'addTeacher'){
        this.addTeacher();
      } else if(this.dialogStatus === "editTeacher") {
        this.editTeacher();
      }
    },
    findAllTeachers () {
      this.$axios.get("/teacher/findAllTeachers")
              .then((res) => {
                this.teachers = res.data
              })
              .catch(error => {
                this.$message({
                  type: 'error',
                  message: "查询失败，原因是"+error.data.message
                });
              });
    },
    handleEdit (row) {
      this.dialogFormVisible = true;
      this.dialogStatus = "editTeacher";
      this.form.uid = row.uid;
      this.form.name = row.name;
      this.form.age = row.age;
      this.form.sex = row.sex;
      this.form.subject = row.subject;
      this.form.teach_class = row.teach_class;
      this.form.num = row.num;
      this.form.post = row.post;
      this.form.evaluate = row.evaluate;
      this.form.ed = row.ed;
      this.form.folk = row.folk;
      this.form.tel = row.tel;
      this.form.email = row.email;
      this.form.np = row.np;
      this.form.identify = row.identify;
      this.form.address = row.address;
      this.form.college = row.college.split('/');
      this.form.graduate = row.graduate;
      this.form.ps = row.ps;
      this.form.ms = row.ms;
      this.form.passrate = row.passrate;
      this.form.hobby = row.hobby.split(",");
    },
    handleDelete (row) {
      this.$confirm('此操作将永久删除该教师, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.$axios.post("/teacher/deleteTeacher?uid="+row.uid).then ((resp)=>{
          this.$message.success("删除成功!")
          this.findAllTeachers();
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
      this.form.age = '';
      this.form.sex = '';
      this.form.subject = '';
      this.form.teach_class = '';
      this.form.num = '';
      this.form.post = '';
      this.form.evaluate = '';
      this.form.ed = '';
      this.form.folk = '';
      this.form.tel = '';
      this.form.email = '';
      this.form.np = '';
      this.form.identify = '';
      this.form.address = '';
      this.form.college = '';
      this.form.graduate = '';
      this.form.ps = '';
      this.form.ms = '';
      this.form.passrate = '';
      this.form.hobby='';
      this.dialogFormVisible = true;
      this.dialogStatus = "addTeacher";
    },
    addTeacher () {
      this.$refs.teacher.validate((valid) => {
        if (valid) {
          this.form.college = this.form.college.join('/');
          this.form.hobby=this.form.hobby.join(',');
          this.$axios.post("/teacher/addTeacher",this.form).then( (resp)=>{
            if (resp) {
              this.dialogFormVisible = false;
              this.$message.success("添加成功！");
              this.findAllTeachers();
            }
          }).catch((error)=>{
              this.$message({
              message: '添加数据失败，原因是'+error.data.message,
              type: 'error'
            })
          })
          //this.$axios.post("/teacher/addTeacher",this.form).then( (resp)=>{
          //  if (resp.data=="") {
          //    this.dialogFormVisible = false;
          //   this.$message.success("添加成功！");
          //    this.findAllTeachers();
          //  }else{
          //      let data="";
          //      for(let i=0; i<resp.data.length;i++){
          //          data+=i+1+"、    :"+resp.data[i].defaultMessage+"<br>"
          //      }
          //      this.$message({
          //          dangerouslyUseHTMLString:true,
          //          message:'添加失败，原因是: '+"<br>"+data,
          //          type: 'error'
          //      });
          //  }
          //})
        }else {
            this.$message({
            message: '请输入所有字段',
            type: 'error'
            })
            return false;
        }
      })
    },
    editTeacher () {
      this.form.college = this.form.college.join('/');
      this.form.hobby=this.form.hobby.join(',');
      this.$axios.post("/teacher/updateTeacher",this.form).then( (resp)=>{
        this.dialogFormVisible = false;
        this.$message.success("修改成功!");
        this.findAllTeachers();
      }).catch( (error)=> {
        this.$message({
          message: '数据更新失败，原因是'+error.data.message,
          type: 'error'
        })
      })
      //this.$axios.post("/teacher/updateTeacher",this.form).then( (resp)=>{
      //  if(resp.data==""){
      //      this.dialogFormVisible = false;
      //      this.$message.success("修改成功!");
      //      this.findAllTeachers();
      //  }else{
      //      let data="";
      //      for(let i=0;i<resp.data.length;i++){
      //          data+=i+1+"、   :"+resp.data[i].defaultMessage+"<br>"
      //      }
      //      this.$message({
      //          dangerouslyUseHTMLString:true,
      //          message: '数据更新失败，原因是'+"<br>"+data,
      //          type: 'error'
      //          });
      //  }
      //})
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
