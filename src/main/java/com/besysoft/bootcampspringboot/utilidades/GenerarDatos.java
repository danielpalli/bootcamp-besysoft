package com.besysoft.bootcampspringboot.utilidades;

import com.besysoft.bootcampspringboot.dominio.Genero;
import com.besysoft.bootcampspringboot.dominio.Personaje;
import com.besysoft.bootcampspringboot.dominio.Serie;

import java.util.*;

@Deprecated
public class GenerarDatos {
    public static List<Serie> datosSeries() {

        Serie theWalkingDead = new Serie(1L, "The Walking Dead", 31102010L, 5);
        Serie laCasaDePapel = new Serie(2L, "La casa de papel", 2052017L, 3);
        Serie merlina = new Serie(3L, "Merlina", 23112022L, 4);
        Serie hungerGames = new Serie(4L, "Hunger Games", 23032012L, 2);

        Personaje rickGrimes = new Personaje(1L, "Rick Grimes", 49, 80.5, "Rick Grimes es el protagonista principal de la serie. Trabajaba como policía en una pequeña ciudad de Georgia, Rick es un líder natural incluso cuando podría dudar de sí mismo, pero estas dudas contribuyen a los altibajos que su personaje experimenta a lo largo de la serie. Su abrumadora necesidad de hacer lo correcto y proteger a aquellos que no pueden protegerse puede alejarlo de su familia, causando tensión dentro de su matrimonio con Lori. A medida que pasa el tiempo, Rick pierde a su esposa debido a una cesárea durante el nacimiento de su hija, Judith. Cuando conoce a Michonne, forman un fuerte vínculo, aunque al principio este desconfiaba de ella. A través de las cosas que estaban sucediendo, la personalidad de Rick se trastorna volviéndose muy desconfiado y totalmente despiadado. Al llegar a la zona segura de Alejandría, Rick se complica para adaptarse a la comunidad, pero esta demuestra ser una figura prominente para los alejandrinos y posteriormente se convierte en el nuevo líder de la zona segura de Alejandría. En ese lapso Rick comienza a sentirse atraído por Michone y ambos comienzan una relación amorosa, pero con la llegada de Los Salvadores y su líder Negan, quien asesina cruelmente a Glenn y Abraham, Rick cae en un desequilibrio emocional, y termina sumiso a Negan y los Salvadores. Rick comienza a levantarse emocionalmente cuando forma alianzas con Hilltop y el Reino y decide hacerle la guerra a Negan. Carl muere cuando un caminante lo muerde, esto lo conduce a una fuerte caída, pero a pesar de eso derrota a Negan y le perdona la vida en memoria de Carl y lo encierra en una celda en Alejandría. Cuando Rick y las comunidades construyen un puente, hay un caos con los salvadores rebeldes, y la rebelión de Maggie y Daryl, que querían matar a un Negan cautivo, provocan que Rick termine gravemente herido, el caos causó la horda. Los caminantes se sienten atraídos hacia el puente que Rick destruye y aparentemente muere, posteriormente Jadis se lo lleva a un herido Rick en un helicóptero a un rumbo desconocido. ");
        Personaje shaneWalsh = new Personaje(2L, "Shane Walsh", 35, 73.8, "Shane Walsh era un policía de un pequeño pueblo de Georgia; él era el compañero de Rick en el departamento de sheriff y su mejor amigo desde la secundaria. Shane dirigió el grupo de sobrevivientes de Atlanta y fue amante de Lori Hasta la llegada de Rick. Su fijación por Lori se vuelve muy obsesiva y perturbada, hasta que un cierto punto en el que asesina a Otis y luego Dale descubre su verdadera personalidad. Rick lo confronta por todas sus atrocidades pero aun así el lo perdona, posteriormente Shane formula un plan para matar a Rick y tras su intento fallido Rick termina su vida con un cuchillazo en el pecho y luego Carl termina su zombificación.");
        Personaje loriGrimes = new Personaje(3L, "Lori Grimes", 35, 62.8, "Lori Grimes es la esposa de Rick, y la madre de Carl y Judith. En la primera temporada, Lori tiene un romance con Shane, hasta que encuentra a Rick vivo. Cuando Rick regresa con Lori, esto provoca el hostigamiento de Shane, quien gradualmente pierde su equilibrio emocional, incluso cuando sabe que está esperando un hijo de Rick, quien este último se entera sobre este evento. Desde su huida de la granja hasta su intento de establecerse en la prisión, Lori se aleja cada vez más de Rick y Carl, y se culpa a sí misma. Ella se preocupa por la supervivencia de su bebé y cuando comienza el trabajo de parto después de un ataque caminante provocado por un convicto de la prisión, Lori convence a Maggie para que la someta a una cesárea, a pesar de que le resultará fatal. Lori muere dando a luz y Carl se ve obligado a dispararle para evitar la reanimación.");
        Personaje darylDixon = new Personaje(4L, "Lori Grimes", 35, 62.8, "Daryl Dixon (Norman Reedus)es el hermano menor de Merle. Es un Red Neck, campesino sureño con un fondo duro, Daryl es un supervivencialista, al principio tenía una hostilidad con el grupo de Atlanta pero con el trascurso del tiempo, Daryl se convierte en el mejor amigo y mano derecha de Rick. Tras la muerte de Rick abandona la comunidad, pero regresa a Alejandría al final de la temporada nueve. Pelea contra los Susurradores y luego se une a la Mancomunidad, aunque se da cuenta de que no es todo tan bonito como lo pintan y decide rebelarse y dirigir a su grupo en contra de la Mancomunidad.");
        Personaje sergioMarquina = new Personaje(5L, "Sergio Marquina", 47, 75.8, "Sergio Marquina, alias El Profesor, es un personaje de La casa de papel. Es el líder de la banda de atracadores a la Fábrica Nacional de Moneda y Timbre. Es un hombre del que poco se sabe y al que le gusta tener calculado hasta el más mínimo detalle.");
        Personaje andresDeFonollosa = new Personaje(6L, "Andrés de Fonollosa", 50, 72.3, "Andrés de Fonollosa, conocido bajo el alias de Berlín, es un personaje de La casa de papel. Es el líder de la banda que planea atracar la Fábrica Nacional de Moneda y Timbre.");
//
//        theWalkingDead.addPersonaje(rickGrimes);
//        theWalkingDead.addPersonaje(shaneWalsh);
//        theWalkingDead.addPersonaje(loriGrimes);
//        theWalkingDead.addPersonaje(darylDixon);
//        laCasaDePapel.addPersonaje(sergioMarquina);
//        laCasaDePapel.addPersonaje(andresDeFonollosa);

        return new ArrayList<>(Arrays.asList(theWalkingDead, laCasaDePapel, merlina, hungerGames));

    }

    public static List<Personaje> datosPersonajes() {

        Serie theWalkingDead = new Serie(1L, "The Walking Dead", 31102010L, 5);
        Serie laCasaDePapel = new Serie(2L, "La casa de papel", 2052017L, 3);
        Serie merlina = new Serie(3L, "Merlina", 23112022L, 4);
        Serie hungerGames = new Serie(4L, "Hunger Games", 23032012L, 2);

        Personaje rickGrimes = new Personaje(1L, "Rick Grimes", 49, 80.5, "Rick Grimes es el protagonista principal de la serie. Trabajaba como policía en una pequeña ciudad de Georgia, Rick es un líder natural incluso cuando podría dudar de sí mismo, pero estas dudas contribuyen a los altibajos que su personaje experimenta a lo largo de la serie. Su abrumadora necesidad de hacer lo correcto y proteger a aquellos que no pueden protegerse puede alejarlo de su familia, causando tensión dentro de su matrimonio con Lori. A medida que pasa el tiempo, Rick pierde a su esposa debido a una cesárea durante el nacimiento de su hija, Judith. Cuando conoce a Michonne, forman un fuerte vínculo, aunque al principio este desconfiaba de ella. A través de las cosas que estaban sucediendo, la personalidad de Rick se trastorna volviéndose muy desconfiado y totalmente despiadado. Al llegar a la zona segura de Alejandría, Rick se complica para adaptarse a la comunidad, pero esta demuestra ser una figura prominente para los alejandrinos y posteriormente se convierte en el nuevo líder de la zona segura de Alejandría. En ese lapso Rick comienza a sentirse atraído por Michone y ambos comienzan una relación amorosa, pero con la llegada de Los Salvadores y su líder Negan, quien asesina cruelmente a Glenn y Abraham, Rick cae en un desequilibrio emocional, y termina sumiso a Negan y los Salvadores. Rick comienza a levantarse emocionalmente cuando forma alianzas con Hilltop y el Reino y decide hacerle la guerra a Negan. Carl muere cuando un caminante lo muerde, esto lo conduce a una fuerte caída, pero a pesar de eso derrota a Negan y le perdona la vida en memoria de Carl y lo encierra en una celda en Alejandría. Cuando Rick y las comunidades construyen un puente, hay un caos con los salvadores rebeldes, y la rebelión de Maggie y Daryl, que querían matar a un Negan cautivo, provocan que Rick termine gravemente herido, el caos causó la horda. Los caminantes se sienten atraídos hacia el puente que Rick destruye y aparentemente muere, posteriormente Jadis se lo lleva a un herido Rick en un helicóptero a un rumbo desconocido. ");
        Personaje shaneWalsh = new Personaje(2L, "Shane Walsh", 35, 73.8, "Shane Walsh era un policía de un pequeño pueblo de Georgia; él era el compañero de Rick en el departamento de sheriff y su mejor amigo desde la secundaria. Shane dirigió el grupo de sobrevivientes de Atlanta y fue amante de Lori Hasta la llegada de Rick. Su fijación por Lori se vuelve muy obsesiva y perturbada, hasta que un cierto punto en el que asesina a Otis y luego Dale descubre su verdadera personalidad. Rick lo confronta por todas sus atrocidades pero aun así el lo perdona, posteriormente Shane formula un plan para matar a Rick y tras su intento fallido Rick termina su vida con un cuchillazo en el pecho y luego Carl termina su zombificación.");
        Personaje loriGrimes = new Personaje(3L, "Lori Grimes", 35, 62.8, "Lori Grimes es la esposa de Rick, y la madre de Carl y Judith. En la primera temporada, Lori tiene un romance con Shane, hasta que encuentra a Rick vivo. Cuando Rick regresa con Lori, esto provoca el hostigamiento de Shane, quien gradualmente pierde su equilibrio emocional, incluso cuando sabe que está esperando un hijo de Rick, quien este último se entera sobre este evento. Desde su huida de la granja hasta su intento de establecerse en la prisión, Lori se aleja cada vez más de Rick y Carl, y se culpa a sí misma. Ella se preocupa por la supervivencia de su bebé y cuando comienza el trabajo de parto después de un ataque caminante provocado por un convicto de la prisión, Lori convence a Maggie para que la someta a una cesárea, a pesar de que le resultará fatal. Lori muere dando a luz y Carl se ve obligado a dispararle para evitar la reanimación.");
        Personaje darylDixon = new Personaje(4L, "Lori Grimes", 35, 62.8, "Daryl Dixon (Norman Reedus)es el hermano menor de Merle. Es un Red Neck, campesino sureño con un fondo duro, Daryl es un supervivencialista, al principio tenía una hostilidad con el grupo de Atlanta pero con el trascurso del tiempo, Daryl se convierte en el mejor amigo y mano derecha de Rick. Tras la muerte de Rick abandona la comunidad, pero regresa a Alejandría al final de la temporada nueve. Pelea contra los Susurradores y luego se une a la Mancomunidad, aunque se da cuenta de que no es todo tan bonito como lo pintan y decide rebelarse y dirigir a su grupo en contra de la Mancomunidad.");
        Personaje sergioMarquina = new Personaje(5L, "Sergio Marquina", 47, 75.8, "Sergio Marquina, alias El Profesor, es un personaje de La casa de papel. Es el líder de la banda de atracadores a la Fábrica Nacional de Moneda y Timbre. Es un hombre del que poco se sabe y al que le gusta tener calculado hasta el más mínimo detalle.");
        Personaje andresDeFonollosa = new Personaje(6L, "Andrés de Fonollosa", 50, 72.3, "Andrés de Fonollosa, conocido bajo el alias de Berlín, es un personaje de La casa de papel. Es el líder de la banda que planea atracar la Fábrica Nacional de Moneda y Timbre.");
//
//        rickGrimes.addSerie(theWalkingDead);
//        shaneWalsh.addSerie(theWalkingDead);
//        loriGrimes.addSerie(theWalkingDead);
//        darylDixon.addSerie(theWalkingDead);
//        sergioMarquina.addSerie(laCasaDePapel);
//        andresDeFonollosa.addSerie(laCasaDePapel);

        return new ArrayList<>(Arrays.asList(rickGrimes, shaneWalsh, loriGrimes, darylDixon, sergioMarquina, andresDeFonollosa));
    }


    public static List<Genero> datosGenero() {

        Serie theWalkingDead = new Serie(1L, "The Walking Dead", 31102010L, 5);
        Serie laCasaDePapel = new Serie(2L, "La casa de papel", 2052017L, 3);
        Serie merlina = new Serie(3L, "Merlina", 23112022L, 4);
        Serie hungerGames = new Serie(4L, "Hunger Games", 23032012L, 2);

        Genero terror = new Genero(1L, "Terror");
        Genero drama = new Genero(2L, "Drama");
        Genero accion = new Genero(3L, "Accion");
        Genero cienciaFiccion = new Genero(4L, "Ciencia Ficcion");
        Genero suspenso = new Genero(5L, "Suspenso");

//        terror.addSerie(theWalkingDead);
//        drama.addSerie(theWalkingDead);
//        accion.addSerie(laCasaDePapel);
//        cienciaFiccion.addSerie(merlina);
//        suspenso.addSerie(hungerGames);
//        terror.addSerie(laCasaDePapel);

        return new ArrayList<>(Arrays.asList(terror, drama, accion, cienciaFiccion, suspenso));
    }

}
