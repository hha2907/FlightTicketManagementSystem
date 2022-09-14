package entities;
// Generated Jun 6, 2022, 6:02:59 PM by Hibernate Tools 4.3.6.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * Employee generated by hbm2java
 */
@Entity
@Table(name = "employee", catalog = "sellticketdb", uniqueConstraints = @UniqueConstraint(columnNames = "CitizenIdentify"))
public class Employee implements java.io.Serializable {

	private Integer employeeId;
	private String employeeName;
	private String citizenIdentify;
	private Date dateOfBirth;
	private String gender;
	private String address;
	private String phone;
	private String role;
	private Integer isActive;
	private Set<Invoice> invoices = new HashSet<Invoice>(0);
	private Set<Account> accounts = new HashSet<Account>(0);
	private Set<Ticket> tickets = new HashSet<Ticket>(0);

	public Employee() {
	}

	public Employee(String employeeName, String citizenIdentify, Date dateOfBirth, String gender, String address,
			String phone, String role, Integer isActive, Set<Invoice> invoices, Set<Account> accounts,
			Set<Ticket> tickets) {
		this.employeeName = employeeName;
		this.citizenIdentify = citizenIdentify;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.address = address;
		this.phone = phone;
		this.role = role;
		this.isActive = isActive;
		this.invoices = invoices;
		this.accounts = accounts;
		this.tickets = tickets;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "Employee_ID", unique = true, nullable = false)
	public Integer getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	@Column(name = "EmployeeName", length = 50)
	public String getEmployeeName() {
		return this.employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	@Column(name = "CitizenIdentify", unique = true, length = 50)
	public String getCitizenIdentify() {
		return this.citizenIdentify;
	}

	public void setCitizenIdentify(String citizenIdentify) {
		this.citizenIdentify = citizenIdentify;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DateOfBirth", length = 10)
	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Column(name = "Gender", length = 10)
	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "Address", length = 500)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "Phone", length = 10)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "Role", length = 100)
	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Column(name = "isActive")
	public Integer getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
	public Set<Invoice> getInvoices() {
		return this.invoices;
	}

	public void setInvoices(Set<Invoice> invoices) {
		this.invoices = invoices;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
	public Set<Account> getAccounts() {
		return this.accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
	public Set<Ticket> getTickets() {
		return this.tickets;
	}

	public void setTickets(Set<Ticket> tickets) {
		this.tickets = tickets;
	}

}
