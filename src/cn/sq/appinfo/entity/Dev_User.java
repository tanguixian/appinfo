package cn.sq.appinfo.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * 
 * 开发者实体类
 * 
 */
public class Dev_User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//主键id
	private Integer id;
	//开发者帐号
	private String devCode;
	//开发者名称
	private String devName;
	//开发者密码
	private String devPassword;
	//开发者电子邮箱
	private String devEmail;
	//开发者简介
	private String devInfo;
	//创建者（来源于backend_user用户表的用户id）
	private Integer createdBy;
	//创建时间
	private Date creationDate;
	//更新者（来源于backend_user用户表的用户id）
	private Integer modifyBy;
	//最新更新时间
	private Date modifyDate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDevCode() {
		return devCode;
	}
	public void setDevCode(String devCode) {
		this.devCode = devCode;
	}
	public String getDevName() {
		return devName;
	}
	public void setDevName(String devName) {
		this.devName = devName;
	}
	public String getDevPassword() {
		return devPassword;
	}
	public void setDevPassword(String devPassword) {
		this.devPassword = devPassword;
	}
	public String getDevEmail() {
		return devEmail;
	}
	public void setDevEmail(String devEmail) {
		this.devEmail = devEmail;
	}
	public String getDevInfo() {
		return devInfo;
	}
	public void setDevInfo(String devInfo) {
		this.devInfo = devInfo;
	}
	public Integer getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Integer getModifyBy() {
		return modifyBy;
	}
	public void setModifyBy(Integer modifyBy) {
		this.modifyBy = modifyBy;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public Dev_User(Integer id, String devCode, String devName, String devPassword, String devEmail, String devInfo,
			Integer createdBy, Date creationDate, Integer modifyBy, Date modifyDate) {
		super();
		this.id = id;
		this.devCode = devCode;
		this.devName = devName;
		this.devPassword = devPassword;
		this.devEmail = devEmail;
		this.devInfo = devInfo;
		this.createdBy = createdBy;
		this.creationDate = creationDate;
		this.modifyBy = modifyBy;
		this.modifyDate = modifyDate;
	}
	public Dev_User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
