package ups.edu.ec.sistemacitasmedicas.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ups.edu.ec.sistemacitasmedicas.repositorio.CabeceraFacturaRepositorio;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class FacturaRepositoryTest {

    @Autowired
    private CabeceraFacturaRepositorio cabeceraFacturaRepositorio;

    @Test
    void testGuardarFacturaDetalle() {
        CabeceraFactura cabeceraFactura;
        try {
            cabeceraFactura = new CabeceraFactura(11, "17-06-2023", 100.0, 18.0, 118.0, true);
            CabeceraFactura cabeceraFacturaGuardada = cabeceraFacturaRepositorio.save(cabeceraFactura);
            Assertions.assertNotNull(cabeceraFacturaGuardada);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testObtenerCabeceraPorId() {
        CabeceraFactura cabeceraFactura1;
        try {
            cabeceraFactura1 = new CabeceraFactura(11, "17-06-2023", 100.0, 18.0, 118.0, true);
            CabeceraFactura cabeceraFacturaGuardada = cabeceraFacturaRepositorio.save(cabeceraFactura1);

            Optional<CabeceraFactura> cabeceraFacturaObtenidaOptional = cabeceraFacturaRepositorio.findById(11);

            // Verificar que la cabeceraFacturaObtenidaOptional no sea nula
            Assertions.assertNotNull(cabeceraFacturaObtenidaOptional);

            // Verificar si el Optional contiene un valor antes de acceder a él
            if (cabeceraFacturaObtenidaOptional.isPresent()) {
                CabeceraFactura cabeceraFacturaObtenida = cabeceraFacturaObtenidaOptional.get();

                // Verificar que la información de la cabeceraFacturaObtenida coincida con la información de la cabeceraFactura de prueba
                Assertions.assertEquals(cabeceraFactura1.getCabeceraFactura_id(), cabeceraFacturaObtenida.getCabeceraFactura_id());
                Assertions.assertEquals(cabeceraFactura1.getFecha(), cabeceraFacturaObtenida.getFecha());
                Assertions.assertEquals(cabeceraFactura1.getSubtotal(), cabeceraFacturaObtenida.getSubtotal());
                Assertions.assertEquals(cabeceraFactura1.getTotalIva(), cabeceraFacturaObtenida.getTotalIva());
                Assertions.assertEquals(cabeceraFactura1.getTotalFactura(), cabeceraFacturaObtenida.getTotalFactura());
                Assertions.assertEquals(cabeceraFactura1.isEstado(), cabeceraFacturaObtenida.isEstado());
            } else {
                // Si el Optional está vacío, lanzar una excepción o realizar alguna otra acción según lo requieras

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testListarCabeceras(){
        List<CabeceraFactura> cabeceraFacturas = cabeceraFacturaRepositorio.findAll();
        assertThat(cabeceraFacturas).size().isGreaterThan(0);
    }

    @Test
    public void eliminarMedicos(){

        Integer id = 2;
        boolean existe =  cabeceraFacturaRepositorio.findById(id).isPresent();
        cabeceraFacturaRepositorio.deleteById(id);
        boolean Noexiste =  cabeceraFacturaRepositorio.findById(id).isPresent();

        assertTrue(existe);
        assertFalse(Noexiste);

    }



}