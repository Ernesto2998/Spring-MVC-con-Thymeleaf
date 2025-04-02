package dgtic.core.service.libro;

import dgtic.core.model.Libro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface LibroService {
    List<Libro> findAll();
    Optional<Libro> findById(Integer id);
    void save(Libro libro);
    void deleteById(Integer id);

    Page<Libro> findPage(Pageable pageable);
    Page<Libro> findLibroByTitulo(String titulo, Pageable pageable);
}
