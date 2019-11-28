package cn.sq.appinfo.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * 
 * ������ʵ����
 * 
 */
public class Dev_User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//����id
	private Integer id;
	//�������ʺ�
	private String devCode;
	//����������
	private String devName;
	//����������
	private String devPassword;
	//�����ߵ�������
	private String devEmail;
	//�����߼��
	private String devInfo;
	//�����ߣ���Դ��backend_user�û�����û�id��
	private Integer createdBy;
	//����ʱ��
	private Date creationDate;
	//�����ߣ���Դ��backend_user�û�����û�id��
	private Integer modifyBy;
	//���¸���ʱ��
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
