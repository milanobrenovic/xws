package com.xws.tim12.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;



@Entity
public class Agency {
	 @Id
	 @Column
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 
	 
	 @NotEmpty(message = "Username cannot be empty.")
	 @NotNull(message = "Username cannot be null.")
	 @Column(nullable = false)
	 private String agencyName;
	 
	 @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Agency> agencies = new HashSet<Agency>();

	 @OneToMany(mappedBy = "agency", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
		private Set<NormalUser> agents = new HashSet<NormalUser>();
	 @OneToMany(mappedBy = "agency", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
		private Set<NormalUser> eliteAgents = new HashSet<NormalUser>();	
	 
	public Agency() {
		
	}
	 
	public Agency(Long id,
			@NotEmpty(message = "Username cannot be empty.") @NotNull(message = "Username cannot be null.") String agencyName,
			Set<Agency> agencies) {
		super();
		this.id = id;
		this.agencyName = agencyName;
		this.agencies = agencies;
	}
	
	public Agency(Long id,
			@NotEmpty(message = "Username cannot be empty.") @NotNull(message = "Username cannot be null.") String agencyName) {
		super();
		this.id = id;
		this.agencyName = agencyName;
		agents = new HashSet<NormalUser>();
		eliteAgents = new HashSet<NormalUser>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAgencyName() {
		return agencyName;
	}

	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}

	public Set<Agency> getAgencies() {
		return agencies;
	}

	public void setAgencies(Set<Agency> agencies) {
		this.agencies = agencies;
	}

	public Agency(Long id,
			@NotEmpty(message = "Username cannot be empty.") @NotNull(message = "Username cannot be null.") String agencyName,
			Set<Agency> agencies, Set<NormalUser> agents) {
		super();
		this.id = id;
		this.agencyName = agencyName;
		this.agencies = agencies;
		this.agents = agents;
	}

	public Set<NormalUser> getAgents() {
		return agents;
	}

	public void setAgents(Set<NormalUser> agents) {
		this.agents = agents;
	}

	public Agency(Long id,
			@NotEmpty(message = "Username cannot be empty.") @NotNull(message = "Username cannot be null.") String agencyName,
			Set<Agency> agencies, Set<NormalUser> agents, Set<NormalUser> eliteAgents) {
		super();
		this.id = id;
		this.agencyName = agencyName;
		this.agencies = agencies;
		this.agents = agents;
		this.eliteAgents = eliteAgents;
	}

	public Set<NormalUser> getEliteAgents() {
		return eliteAgents;
	}

	public void setEliteAgents(Set<NormalUser> eliteAgents) {
		this.eliteAgents = eliteAgents;
	}
		
	 
	 
	 
	 
	 
}
