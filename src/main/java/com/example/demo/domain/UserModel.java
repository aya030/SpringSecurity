package com.example.demo.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public class UserModel implements UserDetails {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String roles;

	@Override
	public String getPassword() {
		// パスワードを返す
		return password;
	}

	@Override
	public String getUsername() {
		// ユーザー名を返す。
		return username;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	@Override
	public boolean isAccountNonExpired() {
		// ユーザアカウントが認証期限切れしていないかどうかを返す
		// 認証期限切れしている場合falseを返すが、今回は特に考慮していないので
		// 固定でtrueを返しておく（以下メソッドでも同様の理由でtrueを返している）
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// ユーザアカウントがロックしていないかどうか
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// ユーザアカウントの資格が認証期限切れしていないかどうか
		return true;
	}

	@Override
	public boolean isEnabled() {
		// ユーザアカウントが無効になっていないか
		return true;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// 認証とロールの付与
		Collection<GrantedAuthority> authorityList = new ArrayList<>();
		if ("ADMIN".equals(roles)) {
			authorityList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		} else if ("USER".equals(roles)) {
			authorityList.add(new SimpleGrantedAuthority("ROLE_USER"));
		}
		return authorityList;
	}

}

