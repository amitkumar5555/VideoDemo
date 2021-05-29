package com.ooka.radio.ookavideoapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class HomeVideoModelList implements Serializable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("user_display_name")
    @Expose
    private String user_display_name;
    @SerializedName("video_id")
    @Expose
    private String video_id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;
    @SerializedName("owner_id")
    @Expose
    private String owner_id;
    @SerializedName("video_location")
    @Expose
    private String video_location;
    @SerializedName("tags")
    @Expose
    private String tags;
    @SerializedName("exp_from")
    @Expose
    private String exp_from;
    @SerializedName("exp_to")
    @Expose
    private String exp_to;
    @SerializedName("vacancy")
    @Expose
    private String vacancy;
    @SerializedName("contact_person_name")
    @Expose
    private String contact_person_name;
    @SerializedName("contact_person_number")
    @Expose
    private String contact_person_number;
    @SerializedName("whatsup_person_name")
    @Expose
    private String whatsup_person_name;
    @SerializedName("whatsup_person_number")
    @Expose
    private String whatsup_person_number;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("salaryMode")
    @Expose
    private String salaryMode;
    @SerializedName("salaryrange_from")
    @Expose
    private String salaryrange_from;
    @SerializedName("salaryrange_to")
    @Expose
    private String salaryrange_to;
    @SerializedName("type_name")
    @Expose
    private String type_name;
    @SerializedName("interview_timing")
    @Expose
    private String interview_timing;
    @SerializedName("company_name")
    @Expose
    private String company_name;
    @SerializedName("companylogo")
    @Expose
    private String companylogo;
    @SerializedName("views")
    @Expose
    private String views;
    @SerializedName("username")
    @Expose
    private String username;

    public String getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(String owner_id) {
        this.owner_id = owner_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @SerializedName("job_comment")
    @Expose
    private String job_comment;
    @SerializedName("job_likes")
    @Expose
    private String job_likes;
    @SerializedName("job_share_count")
    @Expose
    private String job_share_count;
    @SerializedName("education")
    @Expose
    private String education;
    @SerializedName("days_ago")
    @Expose
    private String days_ago;
    @SerializedName("is_liked")
    @Expose
    private Integer is_liked;
    @SerializedName("is_saved")
    @Expose
    private Integer is_saved;
    @SerializedName("contact_mode")
    @Expose
    private String contact_mode;
    @SerializedName("contact_timing")
    @Expose
    private String contact_timing;
    @SerializedName("contact_email")
    @Expose
    private String contact_email;
    @SerializedName("landmark")
    @Expose
    private String landmark;
    @SerializedName("CALL_MODE")
    @Expose
    private Integer CALL_MODE;
    @SerializedName("WHATSAPP_MODE")
    @Expose
    private Integer WHATSAPP_MODE;
    @SerializedName("EMAIL_MODE")
    @Expose
    private Integer EMAIL_MODE;
    @SerializedName("is_follow")
    @Expose
    private String is_follow;
    @SerializedName("role_id")
    @Expose
    private String role_id;
    @SerializedName("designtation")
    @Expose
    private String designtation;

    public String getDesigntation() {
        return designtation;
    }

    public void setDesigntation(String designtation) {
        this.designtation = designtation;
    }

    public String getUser_display_name() {
        return user_display_name;
    }

    public void setUser_display_name(String user_display_name) {
        this.user_display_name = user_display_name;
    }

    public String getRole_id() {
        return role_id;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }

    public String getIs_follow() {
        return is_follow;
    }

    public void setIs_follow(String is_follow) {
        this.is_follow = is_follow;
    }

    public Integer getCALL_MODE() {
        return CALL_MODE;
    }

    public void setCALL_MODE(Integer CALL_MODE) {
        this.CALL_MODE = CALL_MODE;
    }

    public Integer getWHATSAPP_MODE() {
        return WHATSAPP_MODE;
    }

    public void setWHATSAPP_MODE(Integer WHATSAPP_MODE) {
        this.WHATSAPP_MODE = WHATSAPP_MODE;
    }

    public Integer getEMAIL_MODE() {
        return EMAIL_MODE;
    }

    public void setEMAIL_MODE(Integer EMAIL_MODE) {
        this.EMAIL_MODE = EMAIL_MODE;
    }

    public String getJob_share_count() {
        return job_share_count;
    }

    public void setJob_share_count(String job_share_count) {
        this.job_share_count = job_share_count;
    }

    public String getContact_mode() {
        return contact_mode;
    }

    public void setContact_mode(String contact_mode) {
        this.contact_mode = contact_mode;
    }

    public String getContact_timing() {
        return contact_timing;
    }

    public void setContact_timing(String contact_timing) {
        this.contact_timing = contact_timing;
    }

    public String getContact_email() {
        return contact_email;
    }

    public void setContact_email(String contact_email) {
        this.contact_email = contact_email;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public Integer getIs_saved() {
        return is_saved;
    }

    public void setIs_saved(Integer is_saved) {
        this.is_saved = is_saved;
    }

    public Integer getIs_liked() {
        return is_liked;
    }

    public void setIs_liked(Integer is_liked) {
        this.is_liked = is_liked;
    }

    public String getDays_ago() {
        return days_ago;
    }

    public void setDays_ago(String days_ago) {
        this.days_ago = days_ago;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVideo_id() {
        return video_id;
    }

    public void setVideo_id(String video_id) {
        this.video_id = video_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getVideo_location() {
        return video_location;
    }

    public void setVideo_location(String video_location) {
        this.video_location = video_location;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getExp_from() {
        return exp_from;
    }

    public void setExp_from(String exp_from) {
        this.exp_from = exp_from;
    }

    public String getExp_to() {
        return exp_to;
    }

    public void setExp_to(String exp_to) {
        this.exp_to = exp_to;
    }

    public String getVacancy() {
        return vacancy;
    }

    public void setVacancy(String vacancy) {
        this.vacancy = vacancy;
    }

    public String getContact_person_name() {
        return contact_person_name;
    }

    public void setContact_person_name(String contact_person_name) {
        this.contact_person_name = contact_person_name;
    }

    public String getContact_person_number() {
        return contact_person_number;
    }

    public void setContact_person_number(String contact_person_number) {
        this.contact_person_number = contact_person_number;
    }

    public String getWhatsup_person_name() {
        return whatsup_person_name;
    }

    public void setWhatsup_person_name(String whatsup_person_name) {
        this.whatsup_person_name = whatsup_person_name;
    }

    public String getWhatsup_person_number() {
        return whatsup_person_number;
    }

    public void setWhatsup_person_number(String whatsup_person_number) {
        this.whatsup_person_number = whatsup_person_number;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSalaryMode() {
        return salaryMode;
    }

    public void setSalaryMode(String salaryMode) {
        this.salaryMode = salaryMode;
    }

    public String getSalaryrange_from() {
        return salaryrange_from;
    }

    public void setSalaryrange_from(String salaryrange_from) {
        this.salaryrange_from = salaryrange_from;
    }

    public String getSalaryrange_to() {
        return salaryrange_to;
    }

    public void setSalaryrange_to(String salaryrange_to) {
        this.salaryrange_to = salaryrange_to;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public String getInterview_timing() {
        return interview_timing;
    }

    public void setInterview_timing(String interview_timing) {
        this.interview_timing = interview_timing;
    }

    public String getCompanylogo() {
        return companylogo;
    }

    public void setCompanylogo(String companylogo) {
        this.companylogo = companylogo;
    }

    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
    }

    public String getJob_comment() {
        return job_comment;
    }

    public void setJob_comment(String job_comment) {
        this.job_comment = job_comment;
    }

    public String getJob_likes() {
        return job_likes;
    }

    public void setJob_likes(String job_likes) {
        this.job_likes = job_likes;
    }
}

