package joyas_oscar.Pruebas;

import joyas_oscar.modelo.Joya;
import joyas_oscar.repositorio.JoyaRepositorio;

public class PruebaJoyaRepositorio {

    public static void main(String[] args) {
        JoyaRepositorio repositorio = new JoyaRepositorio();
        Joya joya = new Joya(
                0,
                "Joya de prueba",
                "Oro",
                12345.67,
                3,
                true);

        try {
            repositorio.guardar(joya);
            comprobar(joya.getIdJoya() > 0, "Guardar joya");

            Joya recuperada = repositorio.buscarPorId(joya.getIdJoya());
            comprobar(recuperada != null, "Buscar joya por ID");
            comprobar(recuperada != null && "Joya de prueba".equals(recuperada.getNombre()),
                    "Verificar datos guardados");

            joya.setNombre("Joya actualizada");
            joya.setMaterial("Platino");
            joya.setPrecio(9876.54);
            joya.setStock(7);

            comprobar(repositorio.actualizar(joya), "Actualizar joya");

            Joya actualizada = repositorio.buscarPorId(joya.getIdJoya());
            comprobar(actualizada != null && "Joya actualizada".equals(actualizada.getNombre()),
                    "Verificar datos actualizados");
            comprobar(repositorio.listar().stream()
                    .anyMatch(item -> item.getIdJoya() == joya.getIdJoya()),
                    "Listar joyas");

            comprobar(repositorio.desactivar(joya.getIdJoya()), "Desactivar joya de prueba");
            comprobar(repositorio.buscarPorId(joya.getIdJoya()) != null,
                    "Buscar joya desactivada por ID");

            System.out.println("Prueba CRUD de JoyaRepositorio completada.");
        } catch (RuntimeException ex) {
            System.out.println("La prueba falló: " + ex.getMessage());

            if (joya.getIdJoya() > 0) {
                try {
                    repositorio.desactivar(joya.getIdJoya());
                } catch (RuntimeException limpiezaEx) {
                    System.out.println("No fue posible limpiar la joya de prueba: "
                            + limpiezaEx.getMessage());
                }
            }
        }
    }

    private static void comprobar(boolean condicion, String prueba) {
        if (condicion) {
            System.out.println("OK - " + prueba);
        } else {
            throw new RuntimeException("Falló: " + prueba);
        }
    }
}
