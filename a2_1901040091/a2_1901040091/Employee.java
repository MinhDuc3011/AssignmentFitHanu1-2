/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a2_1901040091;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;
import utils.DomainConstraint;
import utils.OptType;
import utils.DOpt;
import utils.AttrRef;
import utils.NotPossibleException;

/**
 * @overview Employee is information about employee
 * @attributes id Integer firstName String givenName String lastName String
 * email String address String phone String dob	Date gender	Gender
 *
 * @object A typical Employee is <pre>v = < id,fN,gN,lN,e,addr,p,dob,g ></pre>,
 * where
 * <pre>id(id), fN(firstName),gN(givenName),lN(lastName),e(email),addr(address),phone(phone),dob(dob), g(gender)
 * </pre>
 *
 * @abstract_properties mutable(id)=false /\ optional(id)=false /\ min = 100
 * mutable(firstName)=true /\ optional(firstName) = false /\ length = 35
 * mutable(givenName)=true /\ optional(givenName) = false /\ length = 35
 * mutable(lastName)=true /\ optional(lastName) = false /\ length = 35
 * mutable(email)=true /\ optional(email) = true /\ length = 200
 * mutable(address)=true /\ optional(address) = false /\ length = 1500
 * mutable(phone)=true /\ optional(phone) = false /\ length = 20
 * mutable(dob)=false /\ optional(dob)=false /\ min=1/1/1900
 * mutable(gender)=false /\ optional(gender)=false
 */
public class Employee {

    @DomainConstraint(type = "Integer", mutable = false, optional = false, min = 100)
    private int id;
    @DomainConstraint(type = "String", mutable = true, optional = false, length = 35)
    private String firstName;
    @DomainConstraint(type = "String", mutable = true, optional = false, length = 35)
    private String givenName;
    @DomainConstraint(type = "String", mutable = true, optional = false, length = 35)
    private String lastName;
    @DomainConstraint(type = "String", mutable = true, optional = true, length = 200)
    private String email;
    @DomainConstraint(type = "String", mutable = true, optional = false, length = 1500)
    private String address;
    @DomainConstraint(type = "String", mutable = true, optional = false, length = 20)
    private String phone;
    @DomainConstraint(type = "Date", mutable = false, optional = false, min = 1 / 1 / 1990)
    private Date dob;
    @DomainConstraint(type = "Gender", mutable = false, optional = false)
    private Gender gender;
    //constants
    private static final int MIN_ID = 100;
    private static final int LENGTH_FIRST = 35;
    private static final int LENGTH_GIVEN = 35;
    private static final int LENGTH_LAST = 35;
    private static final int LENGTH_EMAIL = 200;
    private static final int LENGTH_ADDRESS = 1500;
    private static final int LENGTH_NUMBERPHONE = 20;

    //constructor
    /**
     * @param id
     * @param firstName
     * @param givenName
     * @param lastName
     * @param email
     * @param address
     * @param phone
     * @param dob
     * @param gender
     * @throws java.text.ParseException
     * @effects <pre>
     *            if id,firstName,givenName,lastName,email,address,phone,dob,gender are valid
     *              Initialize this as Student:<id=this.id
     *              , firstName=this.firstName
     *              ,givenName=this.givenName
     *              ,lastName=this.lastName
     *              ,email=this.email
     *              ,address=this.address
     *              ,phone=this.phone
     *              ,dob=this.dob
     *              , gender=this.gender>
     *            else
     *             print error message
     * </pre>
     */
    @DOpt(type = OptType.Constructor)
    public Employee(@AttrRef("id") int id,
            @AttrRef("firstName") String firstName,
            @AttrRef("givenName") String givenName,
            @AttrRef("lastName") String lastName,
            @AttrRef("email") String email,
            @AttrRef("address") String address,
            @AttrRef("phone") String phone,
            @AttrRef("dob") Date dob,
            @AttrRef("gender") Gender gender) throws ParseException, NotPossibleException {
        if (!validateId(id)) {
            throw new NotPossibleException("Employee.init: invalid id: " + id);
        }
        if (!validateFirstName(firstName)) {
            throw new NotPossibleException("Employee.init: invalid firstName: " + firstName);
        }
        if (!validateGivenName(givenName)) {
            throw new NotPossibleException("Employee.init: invalid givevName: " + givenName);
        }
        if (!validateLastName(lastName)) {
            throw new NotPossibleException("Employee.init: invalid lastName: " + lastName);
        }
        if (!validateEmail(email)) {
            throw new NotPossibleException("Employee.init: invalid email: " + email);
        }

        if (!validateAddress(address)) {
            throw new NotPossibleException("Employee.init: invalid address: " + address);
        }
        if (!validatePhone(phone)) {
            throw new NotPossibleException("Employee.init: invalid phone: " + phone);
        }
        if (!validateDob(dob)) {
            throw new NotPossibleException("Employee.init: invalid dob: " + dob);
        }
        if (!validateGender(gender)) {
            throw new NotPossibleException("Employee.init: invalid gender: " + gender);
        }

        this.id = id;
        this.firstName = firstName;
        this.givenName = givenName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.dob = dob;
        this.gender = gender;
    }
    //constructor2

    /**
     * @param id
     * @param firstName
     * @param givenName
     * @param lastName
     * @param address
     * @param phone
     * @param dob
     * @param gender
     * @throws java.text.ParseException
     * @effects <pre>
     *            if id,firstName,givenName,lastName,email,address,phone,dob,gender are valid
     *              Initialize this as Student:<id=this.id
     *              , firstName=this.firstName
     *              ,givenName=this.givenName
     *              ,lastName=this.lastName
     *              ,address=this.address
     *              ,phone=this.phone
     *              ,dob=this.dob
     *              , gender=this.gender>
     *            else
     *             print error message
     * </pre>
     */
    @DOpt(type = OptType.Constructor)
    public Employee(@AttrRef("id") int id,
            @AttrRef("firstName") String firstName,
            @AttrRef("givenName") String givenName,
            @AttrRef("lastName") String lastName,
            @AttrRef("address") String address,
            @AttrRef("phone") String phone,
            @AttrRef("dob") Date dob,
            @AttrRef("gender") Gender gender) throws ParseException {
        if (!validateId(id)) {
            throw new NotPossibleException("Employee.init: invalid id: " + id);
        }
        if (!validateFirstName(firstName)) {
            throw new NotPossibleException("Employee.init: invalid firstName: " + firstName);
        }
        if (!validateGivenName(givenName)) {
            throw new NotPossibleException("Employee.init: invalid givevName: " + givenName);
        }
        if (!validateLastName(lastName)) {
            throw new NotPossibleException("Employee.init: invalid lastName: " + lastName);
        }
        if (!validateAddress(address)) {
            throw new NotPossibleException("Employee.init: invalid address: " + address);
        }
        if (!validatePhone(phone)) {
            throw new NotPossibleException("Employee.init: invalid phone: " + phone);
        }
        if (!validateDob(dob)) {
            throw new NotPossibleException("Employee.init: invalid dob: " + dob);
        }
        if (!validateGender(gender)) {
            throw new NotPossibleException("Employee.init: invalid gender: " + gender);
        }

        this.id = id;
        this.firstName = firstName;
        this.givenName = givenName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.dob = dob;
        this.gender = gender;
    }
//MUTATORS

    /**
     * @param firstName
     * @effects <pre>
     *   if firstName is valid
     *     set this.firstName=firstName
     *     return true
     *   else
     *     return false</pre>
     */
    @DOpt(type = OptType.Mutator)
    @AttrRef("firstName")
    public boolean setFirstName(String firstName) {
        if (validateFirstName(firstName)) {
            this.firstName = firstName;
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param givenName
     * @effects <pre>
     *   if givenName is valid
     *     set this.givenName=givenName
     *     return true
     *   else
     *     return false</pre>
     */
    @DOpt(type = OptType.Mutator)
    @AttrRef("givenName")
    public boolean setGivenName(String givenName) {
        if (validateGivenName(givenName)) {
            this.givenName = givenName;
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param lastName
     * @effects <pre>
     *   if lastName is valid
     *     set this.lastName=lastName
     *     return true
     *   else
     *     return false</pre>
     */
    @DOpt(type = OptType.Mutator)
    @AttrRef("lastName")
    public boolean setLastName(String lastName) {
        if (validateLastName(lastName)) {
            this.lastName = lastName;
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param email
     * @effects <pre>
     *   if email is valid and not null
     *     set this.email=email
     *     return true
     *   else
     *     return false</pre>
     */
    @DOpt(type = OptType.Mutator)
    @AttrRef("email")
    public boolean setEmail(String email) {
        if (getEmail() != null && validateEmail(email)) {
            this.email = email;
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param address
     * @effects <pre>
     *   if address is valid
     *     set this.address=address
     *     return true
     *   else
     *     return false</pre>
     */
    @DOpt(type = OptType.Mutator)
    @AttrRef("address")
    public boolean setAddress(String address) {
        if (validateAddress(address)) {
            this.address = address;
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param phone
     * @effects <pre>
     *   if phone is valid
     *     set this.phone=phone
     *     return true
     *   else
     *     return false</pre>
     */
    @DOpt(type = OptType.Mutator)
    @AttrRef("phone")
    public boolean setPhone(String phone) {
        if (!validatePhone(phone)) {
            return false;
        } else {
            this.phone = phone;
            return true;
        }
    }

    //OBSERVERS
    /**
     * @effects return <tt>id</tt>
     */
    @DOpt(type = OptType.Observer)
    @AttrRef("id")
    public int getId() {
        return id;
    }

    /**
     * @effects return <tt>firstName</tt>
     */
    @DOpt(type = OptType.Observer)
    @AttrRef("firstName")
    public String getFirstName() {
        return firstName;
    }

    /**
     * @effects return <tt>givenName</tt>
     */
    @DOpt(type = OptType.Observer)
    @AttrRef("givenName")
    public String getGivenName() {
        return givenName;
    }

    /**
     * @effects return <tt>lastName</tt>
     */
    @DOpt(type = OptType.Observer)
    @AttrRef("lastName")
    public String getLastName() {
        return lastName;
    }

    /**
     * @effects return <tt>email</tt>
     */
    @DOpt(type = OptType.Observer)
    @AttrRef("email")
    public String getEmail() {
        return email;
    }

    /**
     * @effects return <tt>address</tt>
     */
    @DOpt(type = OptType.Observer)
    @AttrRef("address")
    public String getAddress() {
        return address;
    }

    /**
     * @effects return <tt>phone</tt>
     */
    @DOpt(type = OptType.Observer)
    @AttrRef("phone")
    public String getPhone() {
        return phone;
    }

    /**
     * @effects return <tt>dob</tt>
     */
    @DOpt(type = OptType.Observer)
    @AttrRef("dob")
    public Date getDob() {
        return dob;
    }

    /**
     * @effects return <tt>gender</tt>
     */
    @DOpt(type = OptType.Observer)
    @AttrRef("gender")
    public Gender getGender() {
        return gender;
    }

    /**
     *
     * @effects return the full name of employee
     */
    public String getName() {
        return lastName + " " + givenName + " " + firstName;
    }

    /**
     * @effects return year of birth of employee
     *
     */
    public int getYob() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(dob);
        int year = cal.get(Calendar.YEAR);
        return year;
    }
    //validate

    /**
     * @param id
     * @effects <pre>
     *  if id is valid
     *    return true
     *  else
     *    return false
     * </pre>
     */
    @DOpt(type = OptType.Helper)
    @AttrRef("id")
    private boolean validateId(int id) {
        return (id >= MIN_ID);
    }

    /**
     * @param firstName
     * @effects <pre>
     *  if firstName is valid
     *    return true
     *  else
     *    return false
     * </pre>
     */
    @DOpt(type = OptType.Helper)
    @AttrRef("firstName")
    private boolean validateFirstName(String firstName) {
        if (firstName != null && firstName.length() > 0 && firstName.length() <= LENGTH_FIRST) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param givenName
     * @effects <pre>
     *  if givenName is valid
     *    return true
     *  else
     *    return false
     * </pre>
     */
    @DOpt(type = OptType.Helper)
    @AttrRef("givenName")
    private boolean validateGivenName(String givenName) {
        if ((givenName != null && givenName.length() > 0 && givenName.length() <= LENGTH_GIVEN)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param lastName
     * @effects <pre>
     *  if lastName is valid
     *    return true
     *  else
     *    return false
     * </pre>
     */
    @DOpt(type = OptType.Helper)
    @AttrRef("lastName")
    private boolean validateLastName(String lastName) {
        return (lastName != null && lastName.length() > 0 && lastName.length() <= 35);
    }

    /**
     * @param email
     * @effects <pre>
     *  if email is valid
     *    return true
     *  else
     *    return false
     * </pre>
     */
    @DOpt(type = OptType.Helper)
    @AttrRef("email")
    private boolean validateEmail(String email) {
        boolean check = false;
        String patternEmail = "^[A-Za-z0-9]+[@]{1}[A-Za-z0-9]+(\\.[A-Za-z0-9-]+)+$";
        if (email == null) {
            check = true;
        } else if (Pattern.matches(patternEmail, email) && email.length() > 0 && email.length() <= 200) {
            check = true;
        } else {
            check = false;
        }
        return check;
    }

    /**
     * @param address
     * @effects <pre>
     *  if address is valid
     *    return true
     *  else
     *    return false
     * </pre>
     */
    @DOpt(type = OptType.Helper)
    @AttrRef("address")
    private boolean validateAddress(String address) {
        if (address != null && address.length() > 0 && address.length() <= LENGTH_ADDRESS) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param phone
     * @effects <pre>
     *  if phone is valid
     *    return true
     *  else
     *    return false
     * </pre>
     */
    @DOpt(type = OptType.Helper)
    @AttrRef("phone")
    private boolean validatePhone(String phone) {
        if (phone != null) {
            String patternPhone = "^(\\(84\\)\\s){1}\\d{8,15}$";
            if (Pattern.matches(patternPhone, phone)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * @param dob
     * @effects <pre>
     *  if dob is valid
     *    return true
     *  else
     *    return false
     * </pre>
     */
    @DOpt(type = OptType.Helper)
    @AttrRef("dob")
    private boolean validateDob(Date dob) {
        try {
            if (dob != null) {
                String minDate = "01/01/1900";
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                Date date = df.parse(minDate);
                if (dob.compareTo(date) >= 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (ParseException ex) {
            return false;
        }

    }

    /**
     * @param gender
     * @effects <pre>
     *  if gender is valid
     *    return true
     *  else
     *    return false
     * </pre>
     */
    @DOpt(type = OptType.Helper)
    @AttrRef("gender")
    private boolean validateGender(Gender gender) {
        return (gender != null);
    }
    // DEFAULT		

    @Override
    /**
     * @effect convert data to String
     */
    public String toString() {
        return "Employee:<" + id + "," + firstName + "," + givenName + "," + lastName + "," + email + "," + address + "," + phone + "," + dob + "," + gender + ">";
    }

    /**
     * @effects <pre>
     *   if all attributes are valid
     *     return true
     *   else
     *     return false</pre>
     */
    public boolean repOK() throws ParseException {
        return validateId(id) && validateFirstName(firstName) && validateGivenName(givenName) && validateLastName(lastName) && validateEmail(email) && validateAddress(address) && validatePhone(phone) && validateDob(dob) && validateGender(gender);
    }

    /**
     * @effects <pre>
     *   if two employee have the same id
     *     return true
     *   else
     *     return false</pre>
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof Employee)) {
            return false;
        } else {
            Employee other = (Employee) o;
            return id == other.getId();
        }
    }
}
