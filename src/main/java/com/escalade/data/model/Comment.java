package com.escalade.data.model;

import javax.persistence.*;

@Entity
@Table(name = "comment")
public class Comment {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "comment_id")
	private int commentId;

	@Column(name = "content")
	private String content;

	@Column(name = "username")
	private String userName;

	@Column(name = "user_escalad_id")
	private Integer userEscaladId;

	@Column(name = "site_id")
	private int siteId;


	public Comment() {}

	public Comment(String content, String userName, Integer userEscaladId, int siteId) {
		this.content = content;
		this.userName = userName;
		this.userEscaladId = userEscaladId;
		this.siteId = siteId;
	}


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getUserEscaladId() {
		return userEscaladId;
	}

	public void setUserEscaladId(Integer userEscaladId) {
		this.userEscaladId = userEscaladId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}


	public int getId() {
		return commentId;
	}

	public void setId(int comment_id) {
		this.commentId = comment_id;
	}


	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}


	public int getSiteId() {
		return siteId;
	}

	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}

	@Override
	public String toString() {
		return "comment{" +
				"commentId=" + commentId +
				", content='" + content + '\'' +
				", userEscaladId='" + userEscaladId + '\'' +
				", siteId=" + siteId +
				'}';
	}
}