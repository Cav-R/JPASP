/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa_sp;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Casper
 */
@Entity
@Table(name = "projectuser")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProjectUser.findAll", query = "SELECT p FROM ProjectUser p"),
    @NamedQuery(name = "ProjectUser.findByProjectUserid", query = "SELECT p FROM ProjectUser p WHERE p.projectUserid = :projectUserid"),
    @NamedQuery(name = "ProjectUser.findByUserName", query = "SELECT p FROM ProjectUser p WHERE p.userName = :userName"),
    @NamedQuery(name = "ProjectUser.findByEmail", query = "SELECT p FROM ProjectUser p WHERE p.email = :email"),
    @NamedQuery(name = "ProjectUser.findByCreated", query = "SELECT p FROM ProjectUser p WHERE p.created = :created")})
public class ProjectUser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ProjectUser_id")
    private Long projectUserid;
    @Column(name = "UserName")
    private String userName;
    @Column(name = "email")
    private String email;
    @Column(name = "Created")
    @Temporal(TemporalType.DATE)
    private Date created;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Project> projectList;

    public ProjectUser() {
    }

    public ProjectUser(Long projectUserid) {
        this.projectUserid = projectUserid;
    }

    public Long getProjectUserid() {
        return projectUserid;
    }

    public void setProjectUserid(Long projectUserid) {
        this.projectUserid = projectUserid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (projectUserid != null ? projectUserid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjectUser)) {
            return false;
        }
        ProjectUser other = (ProjectUser) object;
        if ((this.projectUserid == null && other.projectUserid != null) || (this.projectUserid != null && !this.projectUserid.equals(other.projectUserid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa_sp.ProjectUser[ projectUserid=" + projectUserid + " ]";
    }
    
}
