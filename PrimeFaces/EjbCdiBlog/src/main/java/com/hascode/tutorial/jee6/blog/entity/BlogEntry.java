package com.hascode.tutorial.jee6.blog.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


@Entity
//@Table(name = "blogentry")
public class BlogEntry implements Serializable {
	//private static final long	serialVersionUID	= 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	//@GeneratedValue
	private int				id;

	//@Size(min = 1, max = 10)
	private String				title;


	//@Size(min = 1, max = 100)
	private String				content;

	//@Size(min = 1, max = 10)
	private String				author;

	//@Past
	@Temporal(TemporalType.TIMESTAMP)
	private Date				created;
	//private Date				created				= new Date();

//	@PrePersist
//	private void onCreate() {
//		created = new Date();
//	}

	public int getId() {
		return id;
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	//	/**
//	 * @param id
//	 *            the id to set
//	 */
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	/**
//	 * @return the title
//	 */
//	public String getTitle() {
//		return title;
//	}
//
//	/**
//	 * @param title
//	 *            the title to set
//	 */
//	public void setTitle(String title) {
//		this.title = title;
//	}
//
//	/**
//	 * @return the content
//	 */
//	public String getContent() {
//		return content;
//	}
//
//	/**
//	 * @param content
//	 *            the content to set
//	 */
//	public void setContent(String content) {
//		this.content = content;
//	}
//
//	/**
//	 * @return the author
//	 */
//	public String getAuthor() {
//		return author;
//	}
//
//	/**
//	 * @param author
//	 *            the author to set
//	 */
//	public void setAuthor(String author) {
//		this.author = author;
//	}
//
//	/**
//	 * @return the created
//	 */
//	public Date getCreated() {
//		return created;
//	}
//
//	/**
//	 * @param created
//	 *            the created to set
//	 */
//	public void setCreated(Date created) {
//		this.created = created;
//	}
//
//	/**
//	 * @return the id
//	 */
//	public int getId() {
//		return id;
//	}
}
