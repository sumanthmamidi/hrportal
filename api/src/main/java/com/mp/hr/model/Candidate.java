package com.mp.hr.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Candidate
 */
@Validated

public class Candidate  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("id")
  private String id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("phoneNo")
  private String phoneNo = null;

  @JsonProperty("email")
  private String email = null;

  @JsonProperty("experience")
  private Integer experience = null;

  @JsonProperty("noticePeriod")
  private String noticePeriod = null;

  @JsonProperty("passoutYear")
  private Integer passoutYear = null;

  @JsonProperty("resumeId")
  private String resumeId = null;

  @JsonProperty("source")
  private String source = null;

  @JsonProperty("salary")
  private String salary = null;

  @JsonProperty("company")
  private String company = null;

  public Candidate id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Candidate name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(value = "")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Candidate phoneNo(String phoneNo) {
    this.phoneNo = phoneNo;
    return this;
  }

  /**
   * Get phoneNo
   * @return phoneNo
  **/
  @ApiModelProperty(value = "")


  public String getPhoneNo() {
    return phoneNo;
  }

  public void setPhoneNo(String phoneNo) {
    this.phoneNo = phoneNo;
  }

  public Candidate email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
  **/
  @ApiModelProperty(value = "")


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Candidate experience(Integer experience) {
    this.experience = experience;
    return this;
  }

  /**
   * Get experience
   * @return experience
  **/
  @ApiModelProperty(value = "")


  public Integer getExperience() {
    return experience;
  }

  public void setExperience(Integer experience) {
    this.experience = experience;
  }

  public Candidate noticePeriod(String noticePeriod) {
    this.noticePeriod = noticePeriod;
    return this;
  }

  /**
   * Get noticePeriod
   * @return noticePeriod
  **/
  @ApiModelProperty(value = "")


  public String getNoticePeriod() {
    return noticePeriod;
  }

  public void setNoticePeriod(String noticePeriod) {
    this.noticePeriod = noticePeriod;
  }

  public Candidate passoutYear(Integer passoutYear) {
    this.passoutYear = passoutYear;
    return this;
  }

  /**
   * Get passoutYear
   * @return passoutYear
  **/
  @ApiModelProperty(value = "")


  public Integer getPassoutYear() {
    return passoutYear;
  }

  public void setPassoutYear(Integer passoutYear) {
    this.passoutYear = passoutYear;
  }

  public Candidate resumeId(String resumeId) {
    this.resumeId = resumeId;
    return this;
  }

  /**
   * Get resumeId
   * @return resumeId
  **/
  @ApiModelProperty(value = "")


  public String getResumeId() {
    return resumeId;
  }

  public void setResumeId(String resumeId) {
    this.resumeId = resumeId;
  }

  public Candidate source(String source) {
    this.source = source;
    return this;
  }

  /**
   * Get source
   * @return source
  **/
  @ApiModelProperty(value = "")


  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public Candidate salary(String salary) {
    this.salary = salary;
    return this;
  }

  /**
   * Get salary
   * @return salary
  **/
  @ApiModelProperty(value = "")


  public String getSalary() {
    return salary;
  }

  public void setSalary(String salary) {
    this.salary = salary;
  }

  public Candidate company(String company) {
    this.company = company;
    return this;
  }

  /**
   * Get company
   * @return company
  **/
  @ApiModelProperty(value = "")


  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Candidate candidate = (Candidate) o;
    return Objects.equals(this.id, candidate.id) &&
        Objects.equals(this.name, candidate.name) &&
        Objects.equals(this.phoneNo, candidate.phoneNo) &&
        Objects.equals(this.email, candidate.email) &&
        Objects.equals(this.experience, candidate.experience) &&
        Objects.equals(this.noticePeriod, candidate.noticePeriod) &&
        Objects.equals(this.passoutYear, candidate.passoutYear) &&
        Objects.equals(this.resumeId, candidate.resumeId) &&
        Objects.equals(this.source, candidate.source) &&
        Objects.equals(this.salary, candidate.salary) &&
        Objects.equals(this.company, candidate.company);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, phoneNo, email, experience, noticePeriod, passoutYear, resumeId, source, salary, company);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Candidate {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    phoneNo: ").append(toIndentedString(phoneNo)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    experience: ").append(toIndentedString(experience)).append("\n");
    sb.append("    noticePeriod: ").append(toIndentedString(noticePeriod)).append("\n");
    sb.append("    passoutYear: ").append(toIndentedString(passoutYear)).append("\n");
    sb.append("    resumeId: ").append(toIndentedString(resumeId)).append("\n");
    sb.append("    source: ").append(toIndentedString(source)).append("\n");
    sb.append("    salary: ").append(toIndentedString(salary)).append("\n");
    sb.append("    company: ").append(toIndentedString(company)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

