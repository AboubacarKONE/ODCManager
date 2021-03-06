package com.example.backend.controller;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import com.example.backend.model.Participation;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.model.AuthenticationRequest;
import com.example.backend.model.AuthenticationResponse;
import com.example.backend.service.JwtUtils;
import com.example.backend.service.auth.ApplicationUserDetailsService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/odcmanager/api/v1")
@CrossOrigin("*")
public class AuthenticationController {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtUtils jwtUtils;
	@Autowired
	private ApplicationUserDetailsService applicationUserDetailsService;

	@PostMapping("/authentificate")
	@ApiOperation(value = "créer une authenfication", notes = "cette methode permet de créer un token pour authentification")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Authentification réussie"),
			@ApiResponse(code = 400, message = "Authentification non réussie") })
	public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getLogin(), request.getPassword()));
		final UserDetails userDetails = applicationUserDetailsService.loadUserByUsername(request.getLogin());
		final String jwt = jwtUtils.generateToken((User) userDetails);

		return ResponseEntity.ok(AuthenticationResponse.builder().accessToken(jwt).build());
	}

}
