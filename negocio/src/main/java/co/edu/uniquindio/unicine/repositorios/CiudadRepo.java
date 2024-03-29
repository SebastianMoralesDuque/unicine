package co.edu.uniquindio.unicine.repositorios;

import co.edu.uniquindio.unicine.entidades.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CiudadRepo extends JpaRepository<Ciudad,Integer> {

    @Query("select c.codigo, c.nombre, count (t) from Ciudad c join  c.teatros t group by  c.codigo")
    List<Object[]> contarTeatros();
}
