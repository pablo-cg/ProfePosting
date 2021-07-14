package profe.posting.utils;

import profe.posting.model.Comentario;
import profe.posting.model.Curso;

import java.util.List;

public class Utilidades {

    public static List<Curso> calcularPuntuacion(List<Curso> cursos) {
        float total = 0;
        for (Curso c : cursos) {
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

    public static Curso calcularPuntuacion(Curso curso) {
        float total = 0;
        var comentario = curso.getComentarios();
        for (Comentario p : comentario) {
            total += p.getPuntuacion();
        }
        if (comentario.size() != 0) {
            curso.setPuntuacion(total / comentario.size());
        }
        return curso;
    }

}
