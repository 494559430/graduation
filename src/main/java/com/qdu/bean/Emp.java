package com.qdu.bean;

import org.springframework.format.annotation.DateTimeFormat;

public class Emp {
    private Integer empid;

    private String empname;

    private String idcard;

    private Integer sex;
    private Integer age;
    private String email;

    private String loc;

    private String phone;

    private String hiredate;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private String hiredateStart;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private String hiredateEnd;

    private String sal;

    private String leavedate;

    private String jobid;
    private String jobName;
    private Integer state;

    public Integer getEmpid() {
        return empid;
    }

    public void setEmpid(Integer empid) {
        this.empid = empid;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname == null ? null : empname.trim();
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc == null ? null : loc.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getHiredate() {
        return hiredate;
    }

    public void setHiredate(String hiredate) {
        this.hiredate = hiredate == null ? null : hiredate.trim();
    }

    public String getSal() {
        return sal;
    }

    public void setSal(String sal) {
        this.sal = sal == null ? null : sal.trim();
    }

    public String getLeavedate() {
        return leavedate;
    }

    public void setLeavedate(String leavedate) {
        this.leavedate = leavedate == null ? null : leavedate.trim();
    }

    public String getJobid() {
        return jobid;
    }

    public void setJobid(String jobid) {
        this.jobid = jobid == null ? null : jobid.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getHiredateStart() {
        return hiredateStart;
    }

    public void setHiredateStart(String hiredateStart) {
        this.hiredateStart = hiredateStart;
    }

    public String getHiredateEnd() {
        return hiredateEnd;
    }

    public void setHiredateEnd(String hiredateEnd) {
        this.hiredateEnd = hiredateEnd;
    }
}