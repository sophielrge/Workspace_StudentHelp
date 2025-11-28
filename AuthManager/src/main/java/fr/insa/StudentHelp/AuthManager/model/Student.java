package fr.insa.StudentHelp.AuthManager.model;

import java.util.List;

public class Student {


    private Long id;
    private String lastname;
    private String firstname;
    private String email;
    private String speciality;
    private List<String> skills;
    private List<String> availability;
    private double rating;
    private int counter;

    public Student() {}

    public Student(Long id, String lastname, String firstname, String email,
                      String speciality, List<String> skills,
                      List<String> availability ) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.speciality = speciality;
        this.skills = skills;
        this.availability = availability;
        this.rating = 0;
        this.counter = 0;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getLastname() { return lastname; }
    public void setLastname(String lastname) { this.lastname = lastname; }

    public String getFirstname() { return firstname; }
    public void setFirstname(String firstname) { this.firstname = firstname; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSpeciality() { return speciality; }
    public void setSpeciality(String speciality) { this.speciality = speciality; }

    public List<String> getSkills() { return skills; }
    public void setSkills(List<String> skills) { this.skills = skills; }

    public List<String> getAvailability() { return availability; }
    public void setAvailability(List<String> availability) { this.availability = availability; }

    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}
}