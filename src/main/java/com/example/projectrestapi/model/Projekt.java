package com.example.projectrestapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;


@Entity
@Table(name="projekt",        indexes = {
		@Index(name = "nazwa_index", columnList = "nazwa"),
		@Index(name = "data_oddania_index", columnList = "data_oddania"),
		@Index(name = "dataczas_utworzenia_index", columnList = "dataczas_utworzenia")
})
public class Projekt {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="projekt_id") //tylko jeżeli nazwa kolumny w bazie danych ma być inna od nazwy zmiennej
	private Integer projektId;
	@NotBlank(message = "Pole nazwa nie może być puste!")
	@Size(min = 3, max = 50, message = "Nazwa musi zawierać od {min} do {max} znaków!")
	@Column(nullable = false, length = 50)
	private String nazwa;

	private String opis;
	@Column(insertable=false, updatable=false)
	private LocalDateTime dataczas_utworzenia;
	private LocalDate data_oddania;

	public Projekt() {}
	public Projekt(Integer projektId, String nazwa, String opis, LocalDateTime dataCzasUtworzenia, LocalDate
			dataOddania){
		this.projektId = projektId;
		this.nazwa = nazwa;
		this.opis = opis;
		this.dataCzasUtworzenia = dataCzasUtworzenia;

	}
	@CreationTimestamp
	@Column(name = "dataczas_utworzenia", nullable = false, updatable = false)
	private LocalDateTime dataCzasUtworzenia;
	@UpdateTimestamp
	@Column(name = "dataczas_modyfikacji", nullable = false)
	private LocalDateTime dataCzasModyfikacji;

	@ManyToMany
	@JoinTable(name = "projekt_student",
			joinColumns = {@JoinColumn(name="projekt_id")},
			inverseJoinColumns = {@JoinColumn(name="student_id")})
	private Set<Student> studenci;
	@OneToMany(mappedBy = "projekt")
	@JsonIgnoreProperties({"projekt"})
	private List<Zadanie> zadania;
	public List<Zadanie> getZadania() {
		return zadania;
	}

	public void setZadania(List<Zadanie> zadania) {
		this.zadania = zadania;
	}
	public Integer getProjektId() {
		return projektId;
	}
	public void setProjektId(Integer projektId) {
		this.projektId = projektId;
	}
	public String getNazwa() {
		return nazwa;
	}
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public LocalDateTime getDataczas_utworzenia() {
		return dataczas_utworzenia;
	}
	public void setDataczas_utworzenia(LocalDateTime dataczas_utworzenia) {
		this.dataczas_utworzenia = dataczas_utworzenia;
	}
	public LocalDate getData_oddania() {
		return data_oddania;
	}
	public void setData_oddania(LocalDate data_oddania) {
		this.data_oddania = data_oddania;
	}
	public LocalDateTime getDataCzasUtworzenia() {
		return dataCzasUtworzenia;
	}
	public void setDataCzasUtworzenia(LocalDateTime dataCzasUtworzenia) {
		this.dataCzasUtworzenia = dataCzasUtworzenia;
	}
	public LocalDateTime getDataCzasModyfikacji() {
		return dataCzasModyfikacji;
	}
	public Set<Student> getStudenci() {
		return studenci;
	}
	public void setStudenci(Set<Student> studenci) {
		this.studenci = studenci;
	}
	public void setDataCzasModyfikacji(LocalDateTime dataCzasModyfikacji) {
		this.dataCzasModyfikacji = dataCzasModyfikacji;
	}
}