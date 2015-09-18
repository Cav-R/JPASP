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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Casper
 */
@Entity
@Table(name = "project")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Project.findAll", query = "SELECT p FROM Project p"),
    @NamedQuery(name = "Project.findByProjectid", query = "SELECT p FROM Project p WHERE p.projectid = :projectid"),
    @NamedQuery(name = "Project.findByName", query = "SELECT p FROM Project p WHERE p.name = :name"),
    @NamedQuery(name = "Project.findByDescription", query = "SELECT p FROM Project p WHERE p.description = :description"),
    @NamedQuery(name = "Project.findByCreated", query = "SELECT p FROM Project p WHERE p.created = :created"),
    @NamedQuery(name = "Project.findByLastModified", query = "SELECT p FROM Project p WHERE p.lastModified = :lastModified")})
public class Project implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "Project_id")
    private Long projectid;
    @Column(name = "Name")
    private String name;
    @Column(name = "Description")
    private String description;
    @Column(name = "Created")
    @Temporal(TemporalType.DATE)
    private Date created;
    @Column(name = "LastModified")
    @Temporal(TemporalType.DATE)
    private Date lastModified;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "projectuser_project", joinColumns = {
        @JoinColumn(name = "project_id")}, inverseJoinColumns = {
        @JoinColumn(name = "projectuser_id")})
    private List<ProjectUser> userList;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Task> taskList;

    public Project() {
    }

    public List<ProjectUser> getUserList() {
        return userList;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public Project(Long projectid) {
        this.projectid = projectid;
    }

    public Long getProjectid() {
        return projectid;
    }

    public void setProjectid(Long projectid) {
        this.projectid = projectid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (projectid != null ? projectid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Project)) {
            return false;
        }
        Project other = (Project) object;
        if ((this.projectid == null && other.projectid != null) || (this.projectid != null && !this.projectid.equals(other.projectid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa_sp.Project[ projectid=" + projectid + " ]";
    }

}
