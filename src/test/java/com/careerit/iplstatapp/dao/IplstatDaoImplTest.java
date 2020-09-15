package com.careerit.iplstatapp.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.careerit.iplstatapp.dto.PlayerDTO;
import com.careerit.iplstatapp.dto.TeamLabelsDTO;

@SpringBootTest
public class IplstatDaoImplTest {

			@Autowired
			private IplstatDao iplstatDao;

			@Test
			void findTeamLabelsTest() {
					TeamLabelsDTO retObject = iplstatDao.findTeamLabels();
					assertEquals(8, retObject.getLabels().size());
					
			}
			
			@Test
			void findPlayersByLabelTest() {
				List<PlayerDTO> players = iplstatDao.findPlayersByLabel("CSK");
				for(PlayerDTO player:players) {
					System.out.println(player.getName());
				}
				assertEquals(24, players.size());
			}

}
