package dgtic.core.service.Sucursal;

import dgtic.core.model.Sucursal;
import dgtic.core.repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SucursalServiceImpl implements SucursalService{

    @Autowired
    SucursalRepository sucursalRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Sucursal> findAll() {
        return sucursalRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Sucursal> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(Sucursal sucursal) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    @Transactional(readOnly = true)
    public Page<Sucursal> findPage(Pageable pageable) {
        return sucursalRepository.findAll(pageable);
    }
}
