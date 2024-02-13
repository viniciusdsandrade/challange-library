package com.restful.challange.library.api.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/livro")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LivroController {
}
