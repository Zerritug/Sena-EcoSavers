    package com.ecosavers.demo.entity;

    import jakarta.persistence.*;
    import jakarta.validation.constraints.*;
    import java.time.LocalDate;
    import java.time.LocalDateTime;
    import java.util.List;
    import com.ecosavers.demo.entity.Rol;
    import org.springframework.cglib.core.Local;

    @Entity
    @Table(name = "Usuario")
    public class Usuario {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String Name;
        private String email;
        private Long TelNumber;
        private boolean Estado;
        private String Contraseña;
        private LocalDateTime bloqueo;


        //relacion entre tablas
        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "rol_id", nullable = false)
        private Rol rol; //la clase Rol esta en la entidad de Rol.java

        public Usuario(){} //constructor

        public Long getId(){return id;};
        public void setId(Long id){this.id = id;}

        public String getName(){return Name;};
        public void setName(String Name){this.Name = Name;};

        public String getEmail(){return email;};
        public void setEmail(String Email){this.email = Email;};

        public Long getTelNumber(){return TelNumber;}
        public void setTelNumber(Long TelNumber){this.TelNumber = TelNumber;}

        public Boolean getEstado(){return Estado;};
        public void setEstado(boolean Estado){ this.Estado = Estado;};

        public String getPassword(){return Contraseña;};
        public void setPassword(String Contraseña){this.Contraseña = Contraseña;};

        public LocalDateTime getBloqueo(){return bloqueo;}
        public void setBloqueo (LocalDateTime bloqueo){this.bloqueo = bloqueo;}
        public Rol getRol(){return rol;};
        public void setRol(Rol roles){ this.rol = roles;}

        @Column(name = "email", nullable = false, unique = true)
        @Email(message = "Invalid email format")
        @NotBlank(message = "Email is required")
        private String email;

        @Column(name = "password", nullable = false)
        @NotBlank(message = "Password is required")
        private String password;
    }
