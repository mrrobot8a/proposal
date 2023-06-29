package com.example.projectproposal.entity;




import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
@Entity // anotacion entity para declarar  una clase como entidad o objeto
@Table(name= "sedes") // anotacion Table para declarar el nombre de la tabla en la base datos (para diferencia el nombre de la tabla ala clase o artributo en ella)
@Data // nos declara los metodos getter , setter , hashcode , toString

 public class Sede implements Serializable{
    private static final long serialVersionUID = 1L;
   
    private final String messageE = "No puede estar vacio";

    @Id//anotacion para declar lleve primaria 
    @GeneratedValue(strategy = GenerationType.IDENTITY) //anotacion para generar un auto incrementable para este caso un id
    private Long id ;


    @NotEmpty(message= "No puede estar vacio")
    @Size(min = 4 ,  max = 12)
    @Column(name = "nombre_Sede", nullable = false, length = 20)
    private String nombreSede ;
    
    @NotEmpty
    @Column(name = "direccion", nullable = false, length = 20)
    private String direccion;
    
    @NotEmpty
    @Column(name = "telefono", nullable = false, length = 20)
    private String telefono ;
     
    @Email
    @Column(name = "email", nullable = false, length = 20 , unique = true)
    private String email ;
     
     
    @Column(name="create_at")
	@Temporal(TemporalType.DATE)
	private Date createAt;
     
    @PrePersist
    public void prePersist(){
        createAt = new Date();
    }
}
