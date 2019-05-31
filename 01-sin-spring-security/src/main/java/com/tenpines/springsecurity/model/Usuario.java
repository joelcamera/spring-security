package com.tenpines.springsecurity.model;

import javax.persistence.*;


@Entity
@Table
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;
    private String contraseña;
    private String mensaje;

    public Usuario(String unNombre, String unaContraseña, String unMensaje) {
        asertarCamposNoSonNull(unNombre, unaContraseña, unMensaje);

        nombre = unNombre;
        contraseña = unaContraseña;
        mensaje = unMensaje;
    }

    private void asertarCamposNoSonNull(String unNombre, String unaContraseña, String unMensaje) {
        asertarCampoNoEsNull(unNombre, "El usuario no tiene nombre");
        asertarCampoNoEsNull(unaContraseña, "El usuario no tiene contraseña");
        asertarCampoNoEsNull(unMensaje, "El usuario no tiene mensaje");
    }

    public String nombre() {
        return nombre;
    }

    public String contraseña() {
        return contraseña;
    }

    public String mensaje() {
        return mensaje;
    }

    private void asertarCampoNoEsNull(String unNombre, String s) {
        if (unNombre == null)
            throw new RuntimeException(s);
    }
}
