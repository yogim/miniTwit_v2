package com.ymhase.miniTwit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "followermap")
public class Relationship  {
	
	
	@Id
	@Column(name = "relationship_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int relationship_id;

	@ManyToOne
	@JoinColumn(name = "follower")
	private Users follower;

	@ManyToOne
	@JoinColumn(name = "followed")
	private Users followed;

	public Relationship() {
		super();
	}

	public Relationship(Users follower, Users followed) {
		super();
		this.follower = follower;
		this.followed = followed;
	}

	public Users getFollower() {
		return follower;
	}

	public void setFollower(Users follower) {
		this.follower = follower;
	}

	public Users getFollowed() {
		return followed;
	}

	public void setFollowed(Users followed) {
		this.followed = followed;
	}

}
