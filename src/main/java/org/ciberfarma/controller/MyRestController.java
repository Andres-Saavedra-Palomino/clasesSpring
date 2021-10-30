package org.ciberfarma.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.ciberfarma.model.Producto;
import org.ciberfarma.model.Usuario;
import org.ciberfarma.repository.IProductoRepository;
import org.ciberfarma.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyRestController {
	@Autowired
	private IProductoRepository repo;
	@Autowired
	private IUsuarioRepository repou;
	

	@GetMapping(path = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, String> test(HttpServletResponse response) {
    response.addHeader("Access-Control-Allow-Origin", "*");
		HashMap<String, String> map = new HashMap<>();
		map.put("key", "value");
		map.put("foo", "bar");
		map.put("aa", "bb");
		return map;
	}

	@GetMapping(path = "/productos", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Producto> listaProductos(HttpServletResponse response) {
    response.addHeader("Access-Control-Allow-Origin", "*");
		return repo.findAll();
	}

	@GetMapping(path = "/productos/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Optional<Producto> producto(@PathVariable("id") String id,HttpServletResponse response) {
    response.addHeader("Access-Control-Allow-Origin", "*");
		return repo.findById(id);
	}
	@GetMapping(path = "/usuarios", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Usuario> listaUsuarios(HttpServletResponse response) {
    response.addHeader("Access-Control-Allow-Origin", "*");
		return repou.findAll();
	}

	@GetMapping(path = "/usuarios/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Optional<Usuario> usuario(@PathVariable("id") int id,HttpServletResponse response) {
    response.addHeader("Access-Control-Allow-Origin", "*");
		return repou.findById(id);
	}

}
