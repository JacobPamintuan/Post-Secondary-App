package postApp;
import java.util.*;

public class Person{
	
	//person information
	String firstName;
	String lastName;
	
	int birthYear=2000;
	int birthMonth=1;
	int birthDay=1;
	
	String username;
	String password;
	
	String emailAddress;
	String gender;
	String firstLanguage;
	
	String phoneNumber;
	
	//address
	int streetNumber;
	String streetName;
	String city;
	String postalCode;
	String province;
	String country;
	
	
	//student information
	String studentNumber;
	String diploma;
	String school;
	
	Map<String, Integer> marks;
	
	int startYear;
	int startMonth;
	int startDay;
	
	int endYear;
	int endMonth;
	int endDay;
	
	//user information
	ArrayList<String> clickedPrograms;
	ArrayList<String> viewedPrograms;
	ArrayList<String> usedSearchTerms;
	ArrayList<String> starredPrograms;
	
	public Person() {
	
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
	public int getBirthYear() {
		return birthYear;
	}
	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear<=2020&&birthYear>=1950?birthYear:2000;
	}
	public int getBirthMonth() {
		return birthMonth;
	}
	public void setBirthMonth(int birthMonth) {
		this.birthMonth = birthMonth<=12&&birthMonth>=1?birthMonth:1;
	}
	public int getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(int birthDay) {
		int monthDays[] = {31,28,31,30,31,30,31,31,30,31,30,31};		
		this.birthDay = monthDays[getBirthDay()]>=birthDay&&birthDay>=1?birthDay:1;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getFirstLanguage() {
		return firstLanguage;
	}
	public void setFirstLanguage(String firstLanguage) {
		this.firstLanguage = firstLanguage;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getStreetNumber() {
		return streetNumber;
	}
	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getStudentNumber() {
		return studentNumber;
	}
	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}
	public String getDiploma() {
		return diploma;
	}
	public void setDiploma(String diploma) {
		this.diploma = diploma;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public Map<String, Integer> getMarks() {
		return marks;
	}
	public void setMarks(Map<String, Integer> marks) {
		this.marks = marks;
	}
	public int getStartYear() {
		return startYear;
	}
	public void setStartYear(int startYear) {
		this.startYear = startYear;
	}
	public int getStartMonth() {
		return startMonth;
	}
	public void setStartMonth(int startMonth) {
		this.startMonth = startMonth;
	}
	public int getStartDay() {
		return startDay;
	}
	public void setStartDay(int startDay) {
		this.startDay = startDay;
	}
	public int getEndYear() {
		return endYear;
	}
	public void setEndYear(int endYear) {
		this.endYear = endYear;
	}
	public int getEndMonth() {
		return endMonth;
	}
	public void setEndMonth(int endMonth) {
		this.endMonth = endMonth;
	}
	public int getEndDay() {
		return endDay;
	}
	public void setEndDay(int endDay) {
		this.endDay = endDay;
	}
	public ArrayList<String> getClickedPrograms() {
		return clickedPrograms;
	}
	public void setClickedPrograms(ArrayList<String> clickedPrograms) {
		this.clickedPrograms = clickedPrograms;
	}
	public ArrayList<String> getViewedPrograms() {
		return viewedPrograms;
	}
	public void setViewedPrograms(ArrayList<String> viewedPrograms) {
		this.viewedPrograms = viewedPrograms;
	}
	public ArrayList<String> getUsedSearchTerms() {
		return usedSearchTerms;
	}
	public void setUsedSearchTerms(ArrayList<String> usedSearchTerms) {
		this.usedSearchTerms = usedSearchTerms;
	}
	public ArrayList<String> getStarredPrograms() {
		return starredPrograms;
	}
	public void setStarredPrograms(ArrayList<String> starredPrograms) {
		this.starredPrograms = starredPrograms;
	}
	
	
	public String displayBasicUser() {
		String str = String.format( "First name: %s\nLast name: %s\nUsername: %s\nPassword: %s", firstName, lastName, username, password);
		
		return str;
	}
	
	
	
	
}
