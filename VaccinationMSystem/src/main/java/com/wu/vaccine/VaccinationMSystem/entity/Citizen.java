package com.wu.vaccine.VaccinationMSystem.entity;


import java.util.Date;

public class Citizen {
    private int citizenId;
    private String name;
    private String gender;
    private String addhar_no;
    private String contact;
    private Date last_vaccinated;
    private String vaccination_status;
    private int age;

    public Citizen(int citizenId, String name, String gender, String addhar_no, String contact, Date last_vaccinated, String vaccination_status, int age) {
        this.citizenId = citizenId;
        this.name = name;
        this.gender = gender;
        this.addhar_no = addhar_no;
        this.contact = contact;
        this.last_vaccinated = last_vaccinated;
        this.vaccination_status = vaccination_status;
        this.age = age;
    }

    public Citizen() {
    }

    public int getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(int citizenId) {
        this.citizenId = citizenId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddhar_no() {
        return addhar_no;
    }

    public void setAddhar_no(String addhar_no) {
        this.addhar_no = addhar_no;
    }

    public Date getLast_vaccinated() {
        return last_vaccinated;
    }

    public void setLast_vaccinated(Date last_vaccinated) {
        this.last_vaccinated = last_vaccinated;
    }

    public String getVaccination_status() {
        return vaccination_status;
    }

    public void setVaccination_status(String vaccination_status) {
        this.vaccination_status = vaccination_status;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Citizen{" +
                "citizenId=" + citizenId +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", addhar_no='" + addhar_no + '\'' +
                ", contact='" + contact + '\'' +
                ", last_vaccinated=" + last_vaccinated +
                ", vaccination_status='" + vaccination_status + '\'' +
                ", age=" + age +
                '}';
    }
}
