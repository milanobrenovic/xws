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
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import net.minidev.json.annotate.JsonIgnore;







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
	    @JsonIgnore
	 @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Agency> agencies = new HashSet<Agency>();
	    @JsonIgnore
	 @OneToMany(mappedBy = "agency", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
		private Set<NormalUser> agents = new HashSet<NormalUser>();
	    @JsonIgnore
	    @OneToMany(mappedBy = "agency", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
		private Set<NormalUser> eliteAgents = new HashSet<NormalUser>();	
	    @JsonIgnore
	    @OneToMany(mappedBy = "agency", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
		private Set<TransportationVehicle> ownedVehicles = new HashSet<TransportationVehicle>();	
	    @JsonIgnore
	    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
		private NormalUser agencyLeader;
	 
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
		this.agents = new HashSet<NormalUser>();
		this.eliteAgents = new HashSet<NormalUser>();
		this.agencies = new HashSet<Agency>();
		
	}
	
	

	public Agency(Long id,
			@NotEmpty(message = "Username cannot be empty.") @NotNull(message = "Username cannot be null.") String agencyName,
			Set<Agency> agencies, Set<NormalUser> agents, Set<NormalUser> eliteAgents,
			Set<TransportationVehicle> ownedVehicles, NormalUser agencyLeader) {
		super();
		this.id = id;
		this.agencyName = agencyName;
		this.agencies = agencies;
		this.agents = agents;
		this.eliteAgents = eliteAgents;
		this.ownedVehicles = ownedVehicles;
		this.agencyLeader = agencyLeader;
	}
	
	

	public NormalUser getAgencyLeader() {
		return agencyLeader;
	}

	public void setAgencyLeader(NormalUser agencyLeader) {
		this.agencyLeader = agencyLeader;
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

	public Agency(Long id,
			@NotEmpty(message = "Username cannot be empty.") @NotNull(message = "Username cannot be null.") String agencyName,
			Set<Agency> agencies, Set<NormalUser> agents, Set<NormalUser> eliteAgents,
			Set<TransportationVehicle> ownedVehicles) {
		super();
		this.id = id;
		this.agencyName = agencyName;
		this.agencies = agencies;
		this.agents = agents;
		this.eliteAgents = eliteAgents;
		this.ownedVehicles = ownedVehicles;
	}

	public Set<TransportationVehicle> getOwnedVehicles() {
		return ownedVehicles;
	}

	public void setOwnedVehicles(Set<TransportationVehicle> ownedVehicles) {
		this.ownedVehicles = ownedVehicles;
	}
		
	 
	 
	 
	 
	 
}
