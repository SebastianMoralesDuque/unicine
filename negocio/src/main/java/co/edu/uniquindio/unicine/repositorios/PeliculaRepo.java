package co.edu.uniquindio.unicine.repositorios;

import co.edu.uniquindio.unicine.dto.HorarioSalaDTO;
import co.edu.uniquindio.unicine.entidades.Genero;
import co.edu.uniquindio.unicine.entidades.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeliculaRepo extends JpaRepository<Pelicula,Integer> {

    @Query("select p from Pelicula  p where  p.nombre like concat('%',:nombre,'%') and p.estado = :estadoPelicula")
    List<Pelicula> buscarPelicula (String nombre, Boolean estadoPelicula);

    @Query("select new co.edu.uniquindio.unicine.dto.HorarioSalaDTO(f.horario, f.sala) from Pelicula p join p.funciones f where p.codigo = :codigoPelicula and f.sala.teatro.codigo = :codigoTeatro")
    List<HorarioSalaDTO> listarHorarios(Integer codigoPelicula, Integer codigoTeatro);

    @Query("select p from Pelicula  p join p.generos g where g = :generoPelicula order by p.nombre asc")
    List<Pelicula> listarPeliculas (Genero generoPelicula);

    @Query("select pelicula from Pelicula pelicula where pelicula.nombre = :n")
    List<Pelicula> buscarPeliculaPorNombre(String n);

}
