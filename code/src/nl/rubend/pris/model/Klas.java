package nl.rubend.pris.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Klas implements Serializable {
	private String klasNaam;
	private ArrayList<Cursus> cursusen = new ArrayList<>();
	private ArrayList<Student> studenten = new ArrayList<>();
	private ArrayList<Les> lessen = new ArrayList<>();

	public Klas(String nm) {
		this.klasNaam = nm;
	}


	// Getters
	public String getKlasNaam() {
		return klasNaam;
	}
	public ArrayList<Student> getStudenten() { return studenten; }
	public ArrayList<Cursus> getCursusen() {
		return this.cursusen;
	}

	public ArrayList<Les> getLessenOpDag(LocalDate date) {
		ArrayList<Les> response=new ArrayList<Les>();
		for(Les les:lessen) {
			if(les.getDatum().equals(date)) response.add(les);
		}
		return response;
	}

	public Map<Student,Aanwezigheid> getAanwezigheidBijLes(Les les) {
		Map<Student,Aanwezigheid> response=new HashMap<Student,Aanwezigheid>();
		for(Student student:getStudenten()) {
			response.put(student,student.getAanwezigheidBijLes(les));
		}
		return response;
	}



	// Adders en Setters
	protected void addLes(Les les) {
		this.lessen.add(les);
	}
	public void addStudent(Student student) {
		this.studenten.add(student);
		student.addKlas(this);
	}
	public void addCursus(Cursus cursus) {
		this.cursusen.add(cursus);
		cursus.addKlas(this);
	}
	public void removeStudent(Student student) {
		this.studenten.remove(student);
	}


	// To String
	public String toString() {
		return "klas: " + this.klasNaam;
	}
}
