package profe.posting.utils;

import profe.posting.model.AvisoCurso;
import profe.posting.model.Comentario;

import java.util.List;

public class Utilidades {

    public static List<AvisoCurso> calcularPuntuacion(List<AvisoCurso> cursos) {
        float total = 0;
        for (AvisoCurso c : cursos) {
            var comentario = c.getComentarios();
            for (Comentario p : comentario) {
                total += p.getPuntuacion();
            }
            if (comentario.size() != 0) {
                c.setPuntuacion(total / comentario.size());
                total = 0;
            }
        }
        return cursos;
    }

    public static AvisoCurso calcularPuntuacion(AvisoCurso curso) {
        float total = 0;
        var comentario = curso.getComentarios();
        for (Comentario p : comentario) {
            total += p.getPuntuacion();
        }
        if (comentario.size() != 0) {
            curso.setPuntuacion(total / comentario.size());
            total = 0;
        }
        return curso;
    }
}
