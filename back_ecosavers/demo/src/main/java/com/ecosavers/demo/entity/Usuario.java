    package com.ecosavers.demo.entity;

    import jakarta.persistence.*;
    import java.util.List;
    import com.ecosavers.demo.entity.Rol;
    @Entity
    @Table(name = "Usuario")
    public class Usuario {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String Name;
        private String email;
        private int TelNumber;
        private boolean Estado;
        private String Contraseña;

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

        public int getTelNumber(){return TelNumber;}
        public void setTelNumber(int TelNumber){this.TelNumber = TelNumber;}

        public Boolean getEstado(){return Estado;};
        public void setEstado(boolean Estado){ this.Estado = Estado;};

        public String getContraseña(){return Contraseña;};
        public void setContraseña(String Contraseña){this.Contraseña = Contraseña;};

        public Rol getRol(){return rol;};
        public void setRol(Rol roles){ this.rol = roles;}


    }
