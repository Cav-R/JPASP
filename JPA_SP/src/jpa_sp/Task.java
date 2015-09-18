/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa_sp;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Casper
 */
@Entity
@Table(name = "task")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Task.findAll", query = "SELECT t FROM Task t"),
    @NamedQuery(name = "Task.findByName", query = "SELECT t FROM Task t WHERE t.name = :name"),
    @NamedQuery(name = "Task.findByDescription", query = "SELECT t FROM Task t WHERE t.description = :description"),
    @NamedQuery(name = "Task.findByHoursAssigned", query = "SELECT t FROM Task t WHERE t.hoursAssigned = :hoursAssigned"),
    @NamedQuery(name = "Task.findByHoursUsed", query = "SELECT t FROM Task t WHERE t.hoursUsed = :hoursUsed"),
    @NamedQuery(name = "Task.findByTaskid", query = "SELECT t FROM Task t WHERE t.taskid = :taskid"),
    @NamedQuery(name = "Task.findByProjectid", query = "SELECT t FROM Task t WHERE t.projectid = :projectid")})
public class Task implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "Name")
    private String name;
    @Column(name = "Description")
    private String description;
    @Column(name = "HoursAssigned")
    private Integer hoursAssigned;
    @Column(name = "HoursUsed")
    private Integer hoursUsed;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "Task_id")
    private Long taskid;
    @Column(name = "Project_id")
    private Long projectid;

    public Task() {
    }

    public Task(Long taskid) {
        this.taskid = taskid;
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

    public Integer getHoursAssigned() {
        return hoursAssigned;
    }

    public void setHoursAssigned(Integer hoursAssigned) {
        this.hoursAssigned = hoursAssigned;
    }

    public Integer getHoursUsed() {
        return hoursUsed;
    }

    public void setHoursUsed(Integer hoursUsed) {
        this.hoursUsed = hoursUsed;
    }

    public Long getTaskid() {
        return taskid;
    }

    public void setTaskid(Long taskid) {
        this.taskid = taskid;
    }

    public Long getProjectid() {
        return projectid;
    }

    public void setProjectid(Long projectid) {
        this.projectid = projectid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (taskid != null ? taskid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Task)) {
            return false;
        }
        Task other = (Task) object;
        if ((this.taskid == null && other.taskid != null) || (this.taskid != null && !this.taskid.equals(other.taskid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa_sp.Task[ taskid=" + taskid + " ]";
    }

}
