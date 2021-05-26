import Vue from 'vue'
import VueRouter from 'vue-router'
import Student from '../views/Student'
import Teacher from '../views/Teacher'
import Home from '../views/Home'
import Login from '../views/Login'
import Index from '../views/public/Index'
import PublicHome from '../views/public/Home'
import Cintro from '../views/public/Cintro'
import Intro from '../views/public/Intro'
import Method from '../views/public/Method'
import Arrange from '../views/public/Arrange'
import Outline from '../views/public/Outline'
import Idea from '../views/public/Idea'
import Dynamic from '../views/public/Dynamic'
import Cteam from '../views/public/Cteam'
import Cbuild from '../views/public/Cbuild'
import Csource from '../views/public/Csource'
import Cproblem from '../views/public/Cproblem'
import Cresearch from '../views/public/Cresearch'
Vue.use(VueRouter);

const routes = [
  {
    path: '/',
    name: 'Login',
    component: Login,
    hidden: true
  },
  {
    path: '/home',
    name: 'Home',
    component: Home,
    hidden: true
  },
  {
    path: '/home',
    name: '导航一',
    component: Home,
    children:[
      {
        path: '/student',
        name: '管理学生',
        component: Student
      },
      {
        path: '/teacher',
        name:'教师管理',
        component: Teacher
      }
    ]
  },
  {
    path: '/index',
    name: "前台首页",
    component: Index,
    children: [
      {
        path: '/public',
        name: '首页',
        component: PublicHome
      },
      {
        path: '/cintro',
        name: '课程介绍',
        component: Cintro,
        children:[
          {
            path:'/intro',
            name:'课程简介',
            component: Intro,
          },
          {
            path: '/method',
            name: '教学方法',
            component: Method,
          },
          {
            path: '/arrange',
            name: '课程安排',
            component: Arrange,
          },
          {
            path: '/outline',
            name: '教学大纲',
            component: Outline,
          },
          {
            path: '/idea',
            name: '教学理念与目标',
            component: Idea,
          },
          {
            path: '/dynamic',
            name: '课程动态',
            component: Dynamic
          }
        ]
      },
      {
        path: '/cteam',
        name: '教学团队',
        component: Cteam,
      },
      {
        path: '/cbuild',
        name: '课程建设',
        component: Cbuild,
      },
      {
        path: '/csource',
        name: '课程资源',
        component: Csource,
      },
      {
        path: '/cproblem',
        name: '问题与答疑',
        component: Cproblem,
      },
      {
        path: '/cresearch',
        name: '课程研究',
        component: Cresearch,
      }
    ]
  }
]

const router = new VueRouter({
  routes
})

export default router
