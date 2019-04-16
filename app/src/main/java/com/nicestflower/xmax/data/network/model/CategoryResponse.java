package com.nicestflower.xmax.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

@Entity(nameInDb = "category")
public class CategoryResponse {

    @SerializedName("id")
    @Expose
    @Id
    private long id;

    @SerializedName("title")
    @Expose
    @Property(nameInDb = "title")
    private String title;

    @SerializedName("sectionCount")
    @Expose
    @Property(nameInDb = "section_count")
    private long sectionCount;

    @Generated(hash = 432552240)
    public CategoryResponse(long id, String title, long sectionCount) {
        this.id = id;
        this.title = title;
        this.sectionCount = sectionCount;
    }

    @Generated(hash = 1392536694)
    public CategoryResponse() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getSectionCount() {
        return sectionCount;
    }

    public void setSectionCount(long sectionCount) {
        this.sectionCount = sectionCount;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("title", title).append("sectionCount", sectionCount).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(sectionCount).append(id).append(title).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof CategoryResponse)) {
            return false;
        }
        CategoryResponse rhs = ((CategoryResponse) other);
        return new EqualsBuilder().append(sectionCount, rhs.sectionCount).append(id, rhs.id).append(title, rhs.title).isEquals();
    }

}
