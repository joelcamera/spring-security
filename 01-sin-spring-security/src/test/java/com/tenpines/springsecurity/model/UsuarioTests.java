package com.tenpines.springsecurity.model;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.assertj.core.api.Java6Assertions.assertThatThrownBy;

public class UsuarioTests {

    private String unNombre;
    private String unaContraseña;
    private String unMensaje;

    @Before
    public void setup() {
        unNombre = "un nombre";
        unaContraseña = "un contraseña";
        unMensaje = "un mensaje";
    }

    @Test
    public void unUsuarioTieneNombreContraseñaYMensaje() {
        Usuario unUsuario = new Usuario(unNombre, unaContraseña, unMensaje);

        assertThat(unUsuario.nombre()).isEqualTo(unNombre);
        assertThat(unUsuario.contraseña()).isEqualTo(unaContraseña);
        assertThat(unUsuario.mensaje()).isEqualTo(unMensaje);
    }

    @Test
    public void crearUnUsuarioSinNombreLanzaExcepcion(){
        assertThatThrownBy(() -> new Usuario(null, unaContraseña, unMensaje))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("El usuario no tiene nombre");
    }

    @Test
    public void crearUnUsuarioSinContraseñaLanzaExcepcion(){
        assertThatThrownBy(() -> new Usuario(unNombre, null, unMensaje))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("El usuario no tiene contraseña");
    }

    @Test
    public void crearUnUsuarioSinMensajeLanzaExcepcion(){
        assertThatThrownBy(() -> new Usuario(unNombre, unaContraseña, null))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("El usuario no tiene mensaje");
    }
}
