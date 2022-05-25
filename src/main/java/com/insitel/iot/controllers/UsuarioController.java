/**
 * 
 */
package com.insitel.iot.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.insitel.iot.message.FileMessage;
import com.insitel.iot.models.Usuario;
import com.insitel.iot.services.UsuarioService;

/**
 * @author Agustín Palomino Pardo
 *
 */

@RestController
@RequestMapping("/iot/usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	/**
	 * Servicio para obtener todo los usuarios
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "obtenertodos", method = RequestMethod.GET)
	public ArrayList<Usuario> obtenerTodosUsuarios() throws Exception {
		return usuarioService.obtenerTodosUsuarios();
	}
	
	/**
	 * Servicio para crear un nuevo Usuario
	 * @param usuario
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "crear", method = RequestMethod.POST)
	public Usuario crearUsuario(@RequestBody Usuario usuario) throws Exception {
		return usuarioService.guardarUsuario(usuario);
	}
	
	/**
	 * Servicio para guardar o modificar campos de un Usuario
	 * @param usuario
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "actualizar", method = RequestMethod.POST)
	public ResponseEntity<FileMessage> guardarUsuario(@RequestBody Usuario usuario) throws Exception {
		
		String message = "";
		Long id = usuario.getId();
		String docIdentidad = usuario.getDocIdentidad();
		String nombre = usuario.getNombre();
		String apellido = usuario.getApellido();
		String celular = usuario.getCelular();
		long compania = usuario.getCompania();
		String correo = usuario.getCorreo();
		long departamento = usuario.getDepartamento();
		String telefono = usuario.getTelefono();
		String tipo = usuario.getTipo();
		
		Optional<Usuario> encontrado = usuarioService.buscarUsuarioPorId(id);
		if (encontrado.isPresent()) {
			Usuario aGrabar = encontrado.get();
			aGrabar.setDocIdentidad(docIdentidad);
			aGrabar.setNombre(nombre);
			aGrabar.setApellido(apellido);
			aGrabar.setCelular(celular);
			aGrabar.setCompania(compania);
			aGrabar.setCorreo(correo);
			aGrabar.setDepartamento(departamento);
			aGrabar.setTelefono(telefono);
			aGrabar.setTipo(tipo);
			
			usuarioService.guardarUsuario(aGrabar);
			message = "Se cambió el estado de Usuario correctamente";
			return ResponseEntity.status(HttpStatus.OK).body(new FileMessage(message));
		} else {
			message = "Error al grabar Usuario";
			return ResponseEntity.internalServerError().body(new FileMessage(message));
		}
		
	}
	
	/**
	 * Servicio para cambiar estado de Usuario
	 * @param usuario
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "cambiarest", method = RequestMethod.POST)
	public ResponseEntity<FileMessage> cambiarEstadoUsuario(@RequestBody Usuario usuario) throws Exception {
		
		String message = "";
		Long id = usuario.getId();
		String estado = usuario.getEstado();
		
		Optional<Usuario> encontrado = usuarioService.buscarUsuarioPorId(id);
		if (encontrado.isPresent()) {
			Usuario aGrabar = encontrado.get();
			aGrabar.setEstado(estado);
			usuarioService.guardarUsuario(aGrabar);
			message = "Se cambió el estado de Usuario correctamente";
			return ResponseEntity.status(HttpStatus.OK).body(new FileMessage(message));
		} else {
			message = "Error al grabar Usuario";
			return ResponseEntity.internalServerError().body(new FileMessage(message));
		}
	}
	
	/**
	 * Servicio para obtener Usuario por Id
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "porid/{id}", method = RequestMethod.POST)
	public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable("id") Long id) throws Exception {
		Optional<Usuario> usuario = usuarioService.buscarUsuarioPorId(id);
		if (usuario.isPresent()) {
			return ResponseEntity.ok(usuario.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}

}