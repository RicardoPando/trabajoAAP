package backend.project.controllers;
import backend.project.entities.CanalContacto;
import backend.project.services.CanalContactoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CanalContactoController {

    @Autowired
    CanalContactoService canalContactoService;
    //http://localhost:8080/api/canalContacto

    //listar
    @GetMapping("/canalContacto")
    public ResponseEntity<List<CanalContacto>> getAllCanalContacto() {
        List<CanalContacto> canalContactoList = canalContactoService.listAll();
        return new ResponseEntity<List<CanalContacto>>(canalContactoList, HttpStatus.OK);
    }
    //listar por id
    @GetMapping("/canalContacto/{id}")
    public ResponseEntity<CanalContacto> getCanalContactoById(@PathVariable("id") Long id) {
        CanalContacto canalContacto = canalContactoService.findById(id);
        return new ResponseEntity<CanalContacto>(canalContacto, HttpStatus.OK);
    }
    //crear
    @PostMapping("/canalContacto")
    public ResponseEntity<CanalContacto> createCanalContacto(@RequestBody CanalContacto canalContacto) {
        CanalContacto newCanalContacto = canalContactoService.save(canalContacto);
        return new ResponseEntity<CanalContacto>(newCanalContacto, HttpStatus.CREATED);
    }
    //eliminar
    @DeleteMapping("/canalContacto/{id}")
    public ResponseEntity<HttpStatus> deleteCanalContacto(@PathVariable("id") Long id) {
        canalContactoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    //modificar
    //Alternativa 1 -> Pasar el Id por la ruta
    @PutMapping("/canalContacto/{id}")
    public ResponseEntity<CanalContacto> updateCanalContacto(@RequestBody CanalContacto canalContacto, @PathVariable("id") Long id) {
        CanalContacto foundCanalContacto = canalContactoService.findById(id);
        if (canalContacto.getTelefono()!=null) {
            foundCanalContacto.setTelefono(canalContacto.getTelefono());
        }
        if (canalContacto.getEmail()!=null) {
            foundCanalContacto.setEmail(canalContacto.getEmail());
        }
        if (canalContacto.getLinkedin()!=null) {
            foundCanalContacto.setLinkedin(canalContacto.getLinkedin());
        }
        if (canalContacto.getUrl()!=null) {
            foundCanalContacto.setUrl(canalContacto.getUrl());
        }
        CanalContacto newCanalContacto = canalContactoService.save(foundCanalContacto);
        return new ResponseEntity<CanalContacto>(newCanalContacto, HttpStatus.OK);
    }
}
