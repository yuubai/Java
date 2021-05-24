package com.example.second.entity;


public class Course {

        private Long cid;

        private String name;

        private String teacher;

        private String introduce;

        private String credit;

        private String classroom;

        public String getClassroom() {
                return classroom;
        }

        public void setClassroom(String classroom) {
                this.classroom = classroom;
        }

        public String getCredit() {
                return this.credit;
        }

        public void setCredit(String credit) {
                this.credit = credit;
        }

        public Long getUid() {
                return this.cid;
        }

        public void setUid(Long cid) {
                this.cid = cid;
        }

        public String getName() {
                return this.name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getTeacher() {
                return this.teacher;
        }

        public void setTeacher(String teacher) {
                this.teacher = teacher;
        }

        public String getIntroduce() {
                return this.introduce;
        }

        public void setIntroduce(String introduce) {
                this.introduce = introduce;
        }

}