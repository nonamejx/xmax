package com.nicestflower.xmax.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.List;

public class AccountResponse {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("login")
    @Expose
    public String login;
    @SerializedName("firstName")
    @Expose
    public String firstName;
    @SerializedName("lastName")
    @Expose
    public String lastName;
    @SerializedName("email")
    @Expose
    public String email;
    @SerializedName("imageUrl")
    @Expose
    public String imageUrl;
    @SerializedName("activated")
    @Expose
    public Boolean activated;
    @SerializedName("langKey")
    @Expose
    public String langKey;
    @SerializedName("createdBy")
    @Expose
    public String createdBy;
    @SerializedName("createdDate")
    @Expose
    public String createdDate;
    @SerializedName("lastModifiedBy")
    @Expose
    public String lastModifiedBy;
    @SerializedName("lastModifiedDate")
    @Expose
    public String lastModifiedDate;
    @SerializedName("authorities")
    @Expose
    public List<String> authorities = null;

    public AccountResponse() {
    }

    public AccountResponse(Integer id, String login, String firstName, String lastName,
                           String email, String imageUrl, Boolean activated, String langKey,
                           String createdBy, String createdDate, String lastModifiedBy,
                           String lastModifiedDate, List<String> authorities) {
        this.id = id;
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.imageUrl = imageUrl;
        this.activated = activated;
        this.langKey = langKey;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.lastModifiedBy = lastModifiedBy;
        this.lastModifiedDate = lastModifiedDate;
        this.authorities = authorities;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Boolean getActivated() {
        return activated;
    }

    public void setActivated(Boolean activated) {
        this.activated = activated;
    }

    public String getLangKey() {
        return langKey;
    }

    public void setLangKey(String langKey) {
        this.langKey = langKey;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public String getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(String lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public List<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<String> authorities) {
        this.authorities = authorities;
    }

    @Override
    public String toString() {
        return "AccountResponse{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", activated=" + activated +
                ", langKey='" + langKey + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", lastModifiedBy='" + lastModifiedBy + '\'' +
                ", lastModifiedDate='" + lastModifiedDate + '\'' +
                ", authorities=" + authorities +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        AccountResponse that = (AccountResponse) o;

        return new EqualsBuilder()
                .append(id, that.id)
                .append(login, that.login)
                .append(firstName, that.firstName)
                .append(lastName, that.lastName)
                .append(email, that.email)
                .append(imageUrl, that.imageUrl)
                .append(activated, that.activated)
                .append(langKey, that.langKey)
                .append(createdBy, that.createdBy)
                .append(createdDate, that.createdDate)
                .append(lastModifiedBy, that.lastModifiedBy)
                .append(lastModifiedDate, that.lastModifiedDate)
                .append(authorities, that.authorities)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(login)
                .append(firstName)
                .append(lastName)
                .append(email)
                .append(imageUrl)
                .append(activated)
                .append(langKey)
                .append(createdBy)
                .append(createdDate)
                .append(lastModifiedBy)
                .append(lastModifiedDate)
                .append(authorities)
                .toHashCode();
    }
}
