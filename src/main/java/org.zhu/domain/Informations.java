package org.zhu.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author junhi
 * @Date 2019/5/27 13:57
 */

public class Informations {

    private int id;
    private String title;
    private String content;
    private Integer replyCount;
    private String reportTime;

    public Informations(int id, String title, String content, Integer replyCount, String reportTime) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.replyCount = replyCount;
        this.reportTime = reportTime;
    }

    public Informations() {
    }

    @Override
    public String toString() {
        return "Informations{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", replyCount=" + replyCount +
                ", reportTime='" + reportTime + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(Integer replyCount) {
        this.replyCount = replyCount;
    }

    public String getReportTime() {
        return reportTime;
    }

    public void setReportTime(String reportTime) {
        this.reportTime = reportTime;
    }
}
