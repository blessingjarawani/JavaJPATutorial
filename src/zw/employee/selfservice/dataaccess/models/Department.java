package zw.employee.selfservice.dataaccess.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Department")
public class Department extends  BaseEntity implements Serializable   {
    @Column(name ="Name")
  private String Name;
    @OneToMany(mappedBy = "Department")
  private Set<Employees> Employees = new HashSet<>();
  public  Department()
  {

  }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Set<zw.employee.selfservice.dataaccess.models.Employees> getEmployees() {
        return Employees;
    }

    public void setEmployees(Set<zw.employee.selfservice.dataaccess.models.Employees> employees) {
        Employees = employees;
    }
}
