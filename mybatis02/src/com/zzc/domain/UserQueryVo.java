package com.zzc.domain;

import java.util.List;

public class UserQueryVo {
	
	//�������������Ҫ�Ĳ�ѯ����
	
	//������id
	private List<Integer> ids;
	
	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}

	//�û���ѯ����
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}	
	
	//���԰�װ�����Ĳ�ѯ���������綩������Ʒ��
	//......
	
}
