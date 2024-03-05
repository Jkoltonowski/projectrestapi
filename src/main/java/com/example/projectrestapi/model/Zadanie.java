package com.example.projectrestapi.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="zadanie")
public class Zadanie {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="zadanie_id")
private Integer zadanieId;

@Column(insertable=false, updatable=false)
private Integer projekt_id;
private String nazwa;
private Integer kolejnosc;
private String opis;
private LocalDateTime dataczas_oddania;

public Zadanie() {} // pusty konstruktor


public Zadanie(String nazwa, Integer kolejnosc, String opis) {
	super();
	this.nazwa = nazwa;
	this.kolejnosc = kolejnosc;
	this.opis = opis;
}

@ManyToOne
@JoinColumn(name = "projekt_id")
private Projekt projekt;
public Integer getZadanieId() {
	return zadanieId;
}
public void setZadanieId(Integer zadanieId) {
	this.zadanieId = zadanieId;
}
public Integer getProjekt_id() {
	return projekt_id;
}
public void setProjekt_id(Integer projekt_id) {
	this.projekt_id = projekt_id;
}
public String getNazwa() {
	return nazwa;
}
public void setNazwa(String nazwa) {
	this.nazwa = nazwa;
}
public Integer getKolejnosc() {
	return kolejnosc;
}
public void setKolejnosc(Integer kolejnosc) {
	this.kolejnosc = kolejnosc;
}
public String getOpis() {
	return opis;
}
public void setOpis(String opis) {
	this.opis = opis;
}
public LocalDateTime getDataczas_oddania() {
	return dataczas_oddania;
}
public void setDataczas_oddania(LocalDateTime dataczas_oddania) {
	this.dataczas_oddania = dataczas_oddania;
}
public Projekt getProjekt() {
	return projekt;
}
public void setProjekt(Projekt projekt) {
	this.projekt = projekt;
}



}

