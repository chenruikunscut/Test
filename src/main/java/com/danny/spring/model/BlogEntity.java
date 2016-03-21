package com.danny.spring.model;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by DannyChen on 2016/3/16.
 */
@Entity
@Table(name = "blog", schema = "springtest")
public class BlogEntity {
    private int idblog;
    private String title;
    private String content;
    private Date publicDate;
    private UserEntity userByUserId;

    @Id
    @Column(name = "idblog", nullable = false)
    public int getIdblog() {
        return idblog;
    }

    public void setIdblog(int idblog) {
        this.idblog = idblog;
    }

    @Basic
    @Column(name = "title", nullable = false, length = 100)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "content", nullable = true, length = 255)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "public_date", nullable = false)
    public Date getPublicDate() {
        return publicDate;
    }

    public void setPublicDate(Date publicDate) {
        this.publicDate = publicDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BlogEntity that = (BlogEntity) o;

        if (idblog != that.idblog) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (publicDate != null ? !publicDate.equals(that.publicDate) : that.publicDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idblog;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (publicDate != null ? publicDate.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    public UserEntity getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(UserEntity userByUserId) {
        this.userByUserId = userByUserId;
    }
}
