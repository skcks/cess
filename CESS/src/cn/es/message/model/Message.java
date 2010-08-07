package cn.es.message.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Message {
	private int id; // 主键
	private String title; // 主题
	private String contents; // 内容
	private Date createTime; // 创建时间
	private boolean isNew; // 是否为新消息
	private int originID; // 来源用户ID
	private String originType; // 来源用户种类
	private int targetID; // 目标用户ID
	private String targetType; // 目标用户种类
	// private int replyID; // 外键引用自身ID(message_id)
	private Set<Message> replyMessages = new HashSet<Message>();
	private Message preMessage;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(length = 64)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(length = 250)
	public String getContent() {
		return contents;
	}

	public void setContent(String contents) {
		this.contents = contents;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public boolean isNew() {
		return isNew;
	}

	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}

	@Column(length = 12)
	public int getOriginID() {
		return originID;
	}

	public void setOriginID(int originID) {
		this.originID = originID;
	}

	@Column(length = 16)
	public String getOriginType() {
		return originType;
	}

	public void setOriginType(String originType) {
		this.originType = originType;
	}

	public int getTargetID() {
		return targetID;
	}

	public void setTargetID(int targetID) {
		this.targetID = targetID;
	}

	@Column(length = 16)
	public String getTargetType() {
		return targetType;
	}

	public void setTargetType(String targetType) {
		this.targetType = targetType;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "preMessage")
	public Set<Message> getReplyMessages() {
		return replyMessages;
	}

	public void setReplyMessages(Set<Message> replyMessages) {
		this.replyMessages = replyMessages;
	}

	@ManyToOne
	@JoinColumn(name = "replyID")
	public Message getPreMessage() {
		return preMessage;
	}

	public void setPreMessage(Message preMessage) {
		this.preMessage = preMessage;
	}
}
