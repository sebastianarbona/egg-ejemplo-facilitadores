package com.egg.facilitadores.controladores;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.egg.facilitadores.entidades.Alumno;
import com.egg.facilitadores.repository.AlumnoRepository;

@Controller
@RequestMapping("/alumnos")
public class ControladorAlumnos {

	@Autowired
	private AlumnoRepository alumnoRepository;
	
	
	@GetMapping("/listado")
	public ModelAndView listado() {
		ModelAndView modelo = new ModelAndView();
		
		
		List<Alumno> alumnos = alumnoRepository.findAll();
		
		modelo.addObject("alumnos", alumnos);
		modelo.setViewName("alumno-listado");
		
		return modelo;
	}

	@GetMapping("/eliminar")
	public String eliminar(@RequestParam Integer documento) {
		
		if(documento != null) {
			Alumno alumno = alumnoRepository.findById(documento).get();
			alumnoRepository.delete(alumno);
		}
		
		return "redirect:/alumnos/listado";
	}

	
	
	@GetMapping("/inicio")
	public ModelAndView inicio(@RequestParam(required=false) Integer documento) {
		
		Alumno alumno = new Alumno();
		if(documento != null) {
			alumno = alumnoRepository.findById(documento).get();
		}
		
		ModelAndView modelo = new ModelAndView();
		modelo.setViewName("alumno-formulario.html");
		modelo.addObject("alumno", alumno);
		return modelo;
	}
	
	
	@PostMapping("/guardar")
	public ModelAndView guardar(@ModelAttribute("alumno") Alumno alumno) {
		System.out.println("Alumno: " + alumno.toString());

		alumnoRepository.save(alumno);
		
		ModelAndView modelo = new ModelAndView();
		modelo.setViewName("alumno-formulario.html");
		modelo.addObject("alumno", alumno);
		modelo.addObject("mensaje", "El alumno se guardo correctamente.");
		
		
		return modelo;
	}
	
	
	@GetMapping("/desaprobar")
	public ModelAndView desaprobar() {
		
		String[] apellidos = new String[] {"Borja", "Innocenti", "Mora"}; 
		
		Random random = new Random();
		int n = random.nextInt(3);
		
		
		ModelAndView modelo = new ModelAndView(); 
		modelo.addObject("alumno", apellidos[n]);
		modelo.setViewName("alumno.html");
		modelo.addObject("aprobado", false);
		
		return modelo;
	}
	
	
	@GetMapping("/aprobar")
	public ModelAndView aprobar() {
		
		ModelAndView modelo = new ModelAndView(); 
		modelo.addObject("alumno", "Fiordelici");
		modelo.addObject("aprobado", true);
		modelo.setViewName("alumno.html");
		
		return modelo;
	}
}
