package leilao;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import br.com.auction.dao.LeilaoDao;
import br.com.auction.model.Leilao;

public class HelloWorldMockito {
	
	@Test
	void hello() {
		LeilaoDao mock = Mockito.mock(LeilaoDao.class);
		List<Leilao> todos = mock.buscarTodos();
		Assert.assertTrue(todos.isEmpty());
	}

}