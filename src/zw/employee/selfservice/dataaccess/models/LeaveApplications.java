package zw.employee.selfservice.dataaccess.models;

import zw.employee.selfservice.dictionaries.Dictionaries;

import javax.naming.Name;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@Table(name ="LeaveApplications")
public class LeaveApplications  extends  BaseEntity implements Serializable {
    @Column(name ="LeaveType")
    private Dictionaries.LeaveType LeaveType;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="DateFrom", length = 19)
    private Date DateFrom;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="DateTo", length = 19)
    private  Date DateTo;
    @Column(name ="DaysTaken")
    private  Date DaysTaken;
    @Column(name ="Comment")
    private  String Comment;
    @ManyToOne
    @JoinColumn(name = "EmployeeId")
    private  Employees Employees;
  public  LeaveApplications()
  {

  }

    public Dictionaries.LeaveType getLeaveType() {
        return LeaveType;
    }

    public void setLeaveType(Dictionaries.LeaveType leaveType) {
        LeaveType = leaveType;
    }

    public Date getDateFrom() {
        return DateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        DateFrom = dateFrom;
    }

    public Date getDateTo() {
        return DateTo;
    }

    public void setDateTo(Date dateTo) {
        DateTo = dateTo;
    }


    public Date getDaysTaken() {
        return DaysTaken;
    }

    public void setDaysTaken(Date daysTaken) {
        DaysTaken = daysTaken;
    }


    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }

    public zw.employee.selfservice.dataaccess.models.Employees getEmployees() {
        return Employees;
    }

    public void setEmployees(zw.employee.selfservice.dataaccess.models.Employees employees) {
        Employees = employees;
    }
}
