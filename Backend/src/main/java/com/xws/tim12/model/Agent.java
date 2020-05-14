package com.xws.tim12.model;

import com.xws.tim12.enumeration.EntityType;
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

@Entity
public class Agent implements UserDetails {

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

    @Enumerated(EnumType.STRING)
    private EntityType entityType;

    @Column(nullable = true)
    private String companyName;

    @NotEmpty(message = "Business registration number cannot be empty.")
    @Column(nullable = false)
    private String businessRegistrationNumber;

    @NotEmpty(message = "Address cannot be empty.")
    @Column(nullable = false)
    private String address;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Vehicle> listOfRentedVehicles;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Pricelist pricelist;

    @Column()
    private Boolean isBanned;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Ad> ads;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "agent_authority",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id"))
    private Set<Authority> authorities;

    public Agent() {

    }

    public Agent(
            @NotEmpty(message = "Username cannot be empty.")
            @NotNull(message = "Username cannot be null.") String username,
            @NotEmpty(message = "Password cannot be empty.")
            @NotNull(message = "Password cannot be null.") String password,
            String firstName,
            String lastName,
            @Email() String email,
            EntityType entityType,
            String companyName,
            @NotEmpty(message = "Business registration number cannot be empty.") String businessRegistrationNumber,
            @NotEmpty(message = "Address cannot be empty.") String address,
            List<Vehicle> listOfRentedVehicles,
            Pricelist pricelist,
            Boolean isBanned,
            List<Ad> ads) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.entityType = entityType;
        this.companyName = companyName;
        this.businessRegistrationNumber = businessRegistrationNumber;
        this.address = address;
        this.listOfRentedVehicles = listOfRentedVehicles;
        this.pricelist = pricelist;
        this.isBanned = isBanned;
        this.ads = ads;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
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

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    public String getPassword() {
        return password;
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

    public EntityType getEntityType() {
        return entityType;
    }

    public void setEntityType(EntityType entityType) {
        this.entityType = entityType;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getBusinessRegistrationNumber() {
        return businessRegistrationNumber;
    }

    public void setBusinessRegistrationNumber(String businessRegistrationNumber) {
        this.businessRegistrationNumber = businessRegistrationNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Vehicle> getListOfRentedVehicles() {
        return listOfRentedVehicles;
    }

    public void setListOfRentedVehicles(List<Vehicle> listOfRentedVehicles) {
        this.listOfRentedVehicles = listOfRentedVehicles;
    }

    public Pricelist getPricelist() {
        return pricelist;
    }

    public void setPricelist(Pricelist pricelist) {
        this.pricelist = pricelist;
    }

    public Boolean getBanned() {
        return isBanned;
    }

    public void setBanned(Boolean banned) {
        isBanned = banned;
    }

    public List<Ad> getAds() {
        return ads;
    }

    public void setAds(List<Ad> ads) {
        this.ads = ads;
    }

    @Override
    public String toString() {
        return "Agent{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", entityType=" + entityType +
                ", companyName='" + companyName + '\'' +
                ", businessRegistrationNumber='" + businessRegistrationNumber + '\'' +
                ", address='" + address + '\'' +
                ", listOfRentedVehicles=" + listOfRentedVehicles.toString() +
                ", pricelist=" + pricelist.toString() +
                ", isBanned=" + isBanned +
                ", ads=" + ads.toString() +
                '}';
    }

}
