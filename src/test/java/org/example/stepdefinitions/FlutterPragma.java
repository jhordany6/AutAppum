package org.example.stepdefinitions;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.example.questions.ObtenerTextoSegunCampoFlutter;
import org.example.questions.PresentarImagen;
import org.example.tasks.InteractuarConCalendario;
import org.example.tasks.InteractuarConCarousel;
import org.example.tasks.InteractuarConElementos;
import org.example.tasks.InteractuarConFormulario;
import org.example.utils.Time;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.example.userinterfaces.pragma.FormularioPage.MENSAJE_FORMULARIO_VALIDO;
import static org.hamcrest.Matchers.equalTo;

public class FlutterPragma {
    @Dado("^que (.*) quiere iniciar pruebas en flutter$")
    public void quiereIniciarPruebasEnFlutter(String actor) {
        theActorCalled(actor).entersTheScene();
        Time.getTimeFive();
    }

    @Cuando("^ingresa a la app$")
    public void ingresaaLaApp() {
        theActorInTheSpotlight().attemptsTo(InteractuarConElementos.deFlutter());
    }

    @Cuando("^interactua con el calendario$")
    public void interactuaConElCalendario() {
        theActorInTheSpotlight().attemptsTo(InteractuarConCalendario.deFlutter());
    }

    @Cuando("^interactua con el formulario$")
    public void interactuaConElFormulario() {
        theActorInTheSpotlight().attemptsTo(InteractuarConFormulario.deFlutter());
    }

    @Entonces("^el usuario debe ver el mensaje (.*)$")
    public void verificaElMensajeDeSaludo(String mensaje) {
        theActorInTheSpotlight().should(seeThat(ObtenerTextoSegunCampoFlutter.presentaElMensaje(MENSAJE_FORMULARIO_VALIDO), equalTo(mensaje)));

    }

    @Entonces("^debe ver la imagen uno$")
    public void debeVerLaImagenUno() {
        theActorInTheSpotlight().should(seeThat(PresentarImagen.delCarousel()));

    }

    @Cuando("^interactua con el carousel$")
    public void interactuaConElCarousel() {
        theActorInTheSpotlight().attemptsTo(InteractuarConCarousel.deFlutter());
    }
}