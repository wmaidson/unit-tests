package br.com.auction.service;

import br.com.auction.dao.LanceDao;
import br.com.auction.dao.LeilaoDao;
import br.com.auction.dao.UsuarioDao;
import br.com.auction.dto.NovoLanceDto;
import br.com.auction.model.Lance;
import br.com.auction.model.Leilao;
import br.com.auction.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LanceService {

	@Autowired
	private LanceDao lances;

	@Autowired
	private UsuarioDao usuarios;

	@Autowired
	private LeilaoDao leiloes;

	public boolean propoeLance(NovoLanceDto lanceDto, String nomeUsuario) {

		Usuario usuario = usuarios.buscarPorUsername(nomeUsuario);
		Lance lance = lanceDto.toLance(usuario);

		Leilao leilao = this.getLeilao(lanceDto.getLeilaoId());

		if (leilao.propoe(lance)) {
			lances.salvar(lance);
			return true;
		}

		return false;
	}

	public Leilao getLeilao(Long leilaoId) {
		return leiloes.buscarPorId(leilaoId);
	}

}