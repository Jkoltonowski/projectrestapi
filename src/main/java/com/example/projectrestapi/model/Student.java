package com.example.projectrestapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Set;


@Entity //Indeksujemy kolumny, które są najczęściej wykorzystywane do wyszukiwania studentów
@Table(name = "student",
indexes = { @Index(name = "idx_nazwisko", columnList = "nazwisko", unique = false),
 @Index(name = "idx_nr_indeksu", columnList = "nrIndeksu", unique = true) })

public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer studentId;
	private String imie;
	private String nazwisko;
	private String nrIndeksu;
	private String email;
	boolean stacjonarny;
	@JsonBackReference
	@ManyToMany(mappedBy = "studenci")
	private Set<Projekt> projekty;
	public Student() {}

	public Student(String imie, String nazwisko, String nrIndeksu, String email, Boolean stacjonarny) {
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.nrIndeksu = nrIndeksu;
		this.email = email;
		this.stacjonarny = stacjonarny;
		}

	public Set<Projekt> getProjekty() {
		return projekty;
	}

	public void setProjekty(Set<Projekt> projekty) {
		this.projekty = projekty;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public String getImie() {
		return imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public String getNrIndeksu() {
		return nrIndeksu;
	}

	public String getEmail() {
		return email;
	}

	public boolean isStacjonarny() {
		return stacjonarny;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public void setNrIndeksu(String nrIndeksu) {
		this.nrIndeksu = nrIndeksu;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setStacjonarny(boolean stacjonarny) {
		this.stacjonarny = stacjonarny;
	}
}
