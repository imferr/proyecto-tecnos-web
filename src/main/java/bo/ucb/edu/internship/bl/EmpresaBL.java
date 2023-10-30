package bo.ucb.edu.internship.bl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bo.ucb.edu.internship.dao.EmpresaDAO;
import bo.ucb.edu.internship.entity.EmpresaEntity;

@Service
public class EmpresaBL {

    private final EmpresaDAO empresaDAO;

    @Autowired
    public EmpresaBL(EmpresaDAO empresaDAO) {
        this.empresaDAO = empresaDAO;
    }

    // metodo para crear una empresa:
    public EmpresaEntity createEmpresa(EmpresaEntity empresaEntity) {
        if (empresaEntity.getcompanyName() == null || empresaEntity.getcompanyName().length() == 0) {
            throw new RuntimeException("El nombre de la empresa no puede estar vacio");
        } else if (empresaEntity.getTypeAgreement() == null || empresaEntity.getTypeAgreement().length() == 0) {
            throw new RuntimeException("El tipo de convenio no puede estar vacio");
        } else if (empresaEntity.getRequirements() == null || empresaEntity.getRequirements().length() == 0) {
            throw new RuntimeException("Los requisitos no pueden estar vacios");
        } else if (empresaEntity.getPhone() == null || empresaEntity.getPhone().length() == 0) {
            throw new RuntimeException("El telefono no puede estar vacio");
        } else if (empresaEntity.getEmail() == null || empresaEntity.getEmail().length() == 0) {
            throw new RuntimeException("El email no puede estar vacio");
        } // mensajede verificacion de telefono:
        else if (!empresaEntity.getPhone().matches("[0-9]{8}")) {
            throw new RuntimeException("El telefono no es valido");
        }
        // mensaje de verificacion de correo:
        else if (!empresaEntity.getEmail().matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+.$")) {
            throw new RuntimeException("El correo no es valido");
        }
        EmpresaEntity empresa = new EmpresaEntity();
        empresa.setcompanyName(empresaEntity.getcompanyName());
        empresa.setTypeAgreement(empresaEntity.getTypeAgreement());
        empresa.setRequirements(empresaEntity.getRequirements());
        empresa.setPhone(empresaEntity.getPhone());
        empresa.setEmail(empresaEntity.getEmail());
        EmpresaEntity empresaResult = empresaDAO.save(empresa);
        return empresaResult;
    }

    // metodo para obtener listado de absolutamente todas las empresas registradas:
    public List<EmpresaEntity> getAllEmpresas() {
        return empresaDAO.findAll();
    }

    //metodo para obtener una empresa por su id:
    public EmpresaEntity findEmpresaById(Integer id) {
        return empresaDAO.findById(id).orElseThrow(() -> new RuntimeException("No se encontró ninguna empresa con el ID proporcionado"));
    }

}
