package com.cipher;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.cipher.dao.DataRepository;
import com.cipher.entities.DataEntity;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DataRepositoryTest {

	@Autowired
    private TestEntityManager entityManager;
	
	@Autowired
	DataRepository dataRepository;
	
	@Test
	public void whenFindByName_thenReturnEmployee() {
	    // given

	    DataEntity dataEntity=new DataEntity();
	    dataEntity.setText("CzfXp5tMpqcGQCRdIqXHpQ==");
		dataEntity.setKey("Gajanan");
		dataEntity.setAlgorithm("AES");
		dataEntity.setUserName("Gajanan");
	    
	    entityManager.persist(dataEntity);
	    entityManager.flush();
	    // when
	    DataEntity found = dataRepository.findByText(dataEntity.getText());
	 
	    // then
	    assertThat(found.getText())
	      .isEqualTo(dataEntity.getText());
	}
}
