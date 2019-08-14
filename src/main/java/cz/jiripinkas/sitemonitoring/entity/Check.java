/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.jiripinkas.sitemonitoring.entity;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Amine
 */
@Entity
@Table(name = "check", catalog = "test", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Check.findAll", query = "SELECT c FROM Check c")
    , @NamedQuery(name = "Check.findById", query = "SELECT c FROM Check c WHERE c.id = :id")
    , @NamedQuery(name = "Check.findByName", query = "SELECT c FROM Check c WHERE c.name = :name")
    , @NamedQuery(name = "Check.findByUrl", query = "SELECT c FROM Check c WHERE c.url = :url")})
public class Check implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 400)
    @Column(name = "name", nullable = false, length = 400)
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 400)
    @Column(name = "url", nullable = false, length = 400)
    private String url;

    public Check() {
    }

    public Check(Integer id) {
        this.id = id;
    }

    public Check(Integer id, String name, String url) {
        this.id = id;
        this.name = name;
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Check)) {
            return false;
        }
        Check other = (Check) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.Check[ id=" + id + " ]";
    }
    
}
