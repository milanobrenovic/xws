package com.xws.tim12.model;

import net.minidev.json.annotate.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.xws.tim12.enumeration.UserRanking;
import com.xws.tim12.model.Agency;


@Entity
public class NormalUser implements UserDetails {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Username cannot be empty.")
    @NotNull(message = "Username cannot be null.")
    @Column(nullable = false)
    private String username;

    @JsonIgnore
    @NotEmpty(message = "Password cannot be empty.")
    @NotNull(message = "Password cannot be null.")
    @Column(nullable = false)
    private String password;

    @Column(columnDefinition = "VARCHAR(30)", nullable = true)
    private String firstName;

    @Column(columnDefinition = "VARCHAR(30)", nullable = true)
    private String lastName;

    @Email()
    private String email;

    @Column(columnDefinition = "VARCHAR(50)", nullable = true)
    private String country;

    @Column(columnDefinition = "VARCHAR(50)", nullable = true)
    private String phoneNumber;

    @Column(columnDefinition = "VARCHAR(50)", nullable = true)
    private String address;

    @Column(columnDefinition = "VARCHAR(50)", nullable = true)
    private String city;

    @Column()
    private Integer numberOfAds;

    @Column()
    private Boolean isBanned;
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Agency agency;
    
    private UserRanking rank;
    
    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinTable(
            name = "normal_user_authority",
            joinColumns = @JoinColumn(name = "normal_user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id"))
    private Set<Authority> authorities;
    
    @OneToOne(mappedBy = "agencyLeader", fetch = FetchType.EAGER)
	private Agency ownedAgency;

    public NormalUser() {

    }

    public NormalUser(@NotEmpty(message = "Username cannot be empty.") @NotNull(message = "Username cannot be null.") String username, @NotNull(message = "Password cannot be null.") String password, String firstName, String lastName, @Email() String email, String country, String phoneNumber, String address, String city, Integer numberOfAds, Boolean isBanned) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.country = country;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.city = city;
        this.numberOfAds = numberOfAds;
        this.isBanned = isBanned;
    }
    

    public NormalUser(Long id,
			@NotEmpty(message = "Username cannot be empty.") @NotNull(message = "Username cannot be null.") String username,
			@NotEmpty(message = "Password cannot be empty.") @NotNull(message = "Password cannot be null.") String password,
			String firstName, String lastName, @Email String email, String country, String phoneNumber, String address,
			String city, Integer numberOfAds, Boolean isBanned, Agency agency, UserRanking rank) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.country = country;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.city = city;
		this.numberOfAds = numberOfAds;
		this.isBanned = isBanned;
		this.agency = agency;
		this.rank = rank;
	}
    
    

	public NormalUser(
			@NotEmpty(message = "Username cannot be empty.") @NotNull(message = "Username cannot be null.") String username,
			@NotEmpty(message = "Password cannot be empty.") @NotNull(message = "Password cannot be null.") String password,
			String firstName, String lastName, @Email String email, String country, String phoneNumber, String address,
			String city, Integer numberOfAds, Boolean isBanned, UserRanking rank) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.country = country;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.city = city;
		this.numberOfAds = numberOfAds;
		this.isBanned = isBanned;
		this.rank = rank;
	}

	public NormalUser(Long id,
			@NotEmpty(message = "Username cannot be empty.") @NotNull(message = "Username cannot be null.") String username,
			@NotEmpty(message = "Password cannot be empty.") @NotNull(message = "Password cannot be null.") String password,
			String firstName, String lastName, @Email String email, String country, String phoneNumber, String address,
			String city, Integer numberOfAds, Boolean isBanned, Agency agency, UserRanking rank,
			Set<Authority> authorities) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.country = country;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.city = city;
		this.numberOfAds = numberOfAds;
		this.isBanned = isBanned;
		this.agency = agency;
		this.rank = rank;
		this.authorities = authorities;
	}

	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getNumberOfAds() {
        return numberOfAds;
    }

    public void setNumberOfAds(Integer numberOfAds) {
        this.numberOfAds = numberOfAds;
    }

    public Boolean getBanned() {
        return isBanned;
    }

    public void setBanned(Boolean banned) {
        isBanned = banned;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", country='" + country + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", numberOfAds=" + numberOfAds +
                ", isBanned=" + isBanned +
                '}';
    }

	public Boolean getIsBanned() {
		return isBanned;
	}

	public void setIsBanned(Boolean isBanned) {
		this.isBanned = isBanned;
	}

	public Agency getAgency() {
		return agency;
	}

	public void setAgency(Agency agency) {
		this.agency = agency;
	}

	public UserRanking getRank() {
		return rank;
	}

	public void setRank(UserRanking rank) {
		this.rank = rank;
	}
    
}
