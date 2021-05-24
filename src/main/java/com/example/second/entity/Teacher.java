package com.example.second.entity;


//import com.sun.istack.internal.NotNull;

public class Teacher {

    private Long uid;

    private String name;

    private Integer age;

    private String sex;

    private String people;

    private long year;

    private String subject;

    private String edu;

    private String college;

    private String tel;

    private String weChat;

    private String mail;

    private String birthday;

    private String classes;

    private String grade;

    private String classT;

    private String marriage;

    private String bloodType;

    private String party;

    private String remark;

    private Integer height;

    private Integer weight;

    private String hobby;

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        if(height>0 &&height <=200){
            this.height = height;
        }else {
            System.out.println("不合法的身高值");
        }

    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
            this.weight = weight;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.length()>15 ||name.length()<2){
            System.out.println("不合法的名字值");
        }
        this.name = name == null ? null : name.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        if(age>25 & age<65){
            this.age = age ;
        }else{
            //this.age=this.age;
            System.out.println("不合法的年龄值");

        }

    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public long getYear() {
        return year;
    }

    public void setYear(long year) {
        if(year<=2021 && year >=2000){
            this.year = year;
        }else{
            System.out.println("不合法的入职年份值");
        }

    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getEdu() {
        return edu;
    }

    public void setEdu(String edu) {
        this.edu = edu;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }


    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
       this.tel=tel;
    }

    public String getWeChat() {
        return weChat;
    }

    public void setWeChat(String weChat) {
        this.weChat = weChat;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getMarriage() {
        return marriage;
    }

    public void setMarriage(String marriage) {
        this.marriage = marriage;
    }
    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getClassT() {
        return classT;
    }

    public void setClassT(String classT) {
        this.classT = classT;
    }

}