package com.stc.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;
import java.util.Objects;


@Document()
public class Post {

    @Id
    private String id;
    private String title;
    private List<String> comments;


    public Post(String title, List<String> comments) {
        this.comments = comments;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Post{" +
               "id=" + id +
               ", title='" + title + '\'' +
               ", comments=" + comments +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Post post = (Post) o;
        return Objects.equals(id, post.id) &&
               Objects.equals(title, post.title) &&
               Objects.equals(comments, post.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, comments);
    }
}
