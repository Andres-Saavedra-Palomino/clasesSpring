package org.ciberfarma.controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.ciberfarma.model.Producto;
import org.ciberfarma.model.Usuario;
import org.ciberfarma.repository.ICategoriaRepository;
import org.ciberfarma.repository.IProductoRepository;
import org.ciberfarma.repository.IProveedorRepository;
import org.ciberfarma.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductoController {
	@Autowired
	private IProductoRepository repo;
	@Autowired
	private ICategoriaRepository repoc;
	@Autowired
	private IProveedorRepository repop;

	@Autowired
	private IUsuarioRepository repou;

	@GetMapping("/cargar")
	public String productoForm(Model model) {
		model.addAttribute("producto", new Producto());
		model.addAttribute("categorias", repoc.findAll());
		model.addAttribute("proveedores", repop.findAll());
		return "crud-productos";
	}

	@PostMapping("/editar")
	public String editarProducto(@ModelAttribute Producto p, Model model) {
		model.addAttribute("producto",repo.findById(p.getCodigo()));
		model.addAttribute("categorias", repoc.findAll());
		model.addAttribute("proveedores", repop.findAll());
		return "crud-productos";
	}
	
	@PostMapping("/grabar")
	public String agregarProducto(@ModelAttribute Producto producto, Model model) {
		repo.save(producto);
		model.addAttribute("categorias", repoc.findAll());
		model.addAttribute("proveedores", repop.findAll());
		return "crud-productos";
	}

	@GetMapping("/listar")
	public String listarPag(@ModelAttribute Producto producto, Model model) {
		model.addAttribute("lstProductos", repo.findAll());
		return "productos";
	}
	
	@GetMapping("/listaru")
	public String listarUPag(@ModelAttribute Producto producto, Model model) {
		model.addAttribute("lstUsuarios", repou.findAll());
		return "usuarios";
	}
	@GetMapping("/productos")
	public String tablaPag(@ModelAttribute Producto producto, Model model) {
		String[] cabeceras = {"codigo","descripcion","stock","precio","categoria","estado","proveedor"};
		List <String[]> rows = new ArrayList<String[]>();
		for (Producto p : repo.findAll()) {
			String[] a={p.getCodigo(), p.getDescripcion(),""+p.getStock(),"S/. "+new DecimalFormat("#,##0.00").format(p.getPrecio()),""+p.getCategoria().getDescripcion(),""+p.getEstado(),""+p.getProveedor().getNombre()};
			rows.add(a);
		}
		model.addAttribute("rows", rows);
		model.addAttribute("cabeceras", cabeceras);		
		return "mantenimiento";
	}
	@GetMapping("/usuarios")
	public String usuariosPag(@ModelAttribute Producto producto, Model model) {
		String[] cabeceras = {"codigo","nombre","apellido","correo","clave","fecha nac.","tipo","estado"};
		List <String[]> rows = new ArrayList<String[]>();
		for (Usuario u : repou.findAll()) {
			String[] a={""+u.getCodigo(), u.getNombre(), u.getApellido(), u.getCorreo(), u.getClave(), u.getFnacim(), ""+u.getTipo(), ""+u.getEstado()};
			rows.add(a);
		}
		model.addAttribute("rows", rows);
		model.addAttribute("cabeceras", cabeceras);		
		return "mantenimiento";
	}
	@GetMapping(value = "/productos/{codigo}")
	public String listarProducto(Model model,@PathVariable String codigo) {
		String[] cabeceras = {"codigo","descripcion","stock","precio","categoria","estado","proveedor"};
		List<String[]> rows = new ArrayList<String[]>();
		Producto p = repo.getById(codigo); 
		String[] a={p.getCodigo(), p.getDescripcion(),""+p.getStock(),"S/. "+new DecimalFormat("#,##0.00").format(p.getPrecio()),""+p.getCategoria().getDescripcion(),""+p.getEstado(),""+p.getProveedor().getNombre()};
		rows.add(a);
		model.addAttribute("rows", rows);
		model.addAttribute("cabeceras", cabeceras);		
		return "mantenimiento";
	}

	
}
