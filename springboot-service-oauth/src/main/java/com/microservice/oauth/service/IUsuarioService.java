package com.microservice.oauth.service;

import com.microservice.common.users.entity.Usuario;

public interface IUsuarioService {

	public Usuario findByUsername(String username);
}
