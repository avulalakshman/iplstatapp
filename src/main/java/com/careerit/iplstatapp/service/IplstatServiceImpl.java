package com.careerit.iplstatapp.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.careerit.iplstatapp.dao.IplstatDao;
import com.careerit.iplstatapp.dto.PlayerCountDTO;
import com.careerit.iplstatapp.dto.PlayerDTO;
import com.careerit.iplstatapp.dto.RoleAmountDTO;
import com.careerit.iplstatapp.dto.TeamAmountDTO;
import com.careerit.iplstatapp.dto.TeamDTO;
import com.careerit.iplstatapp.dto.TeamLabelsDTO;

@Service
public class IplstatServiceImpl implements IplstatService {

	@Autowired
	private IplstatDao iplstatDao;
	private static final Logger log = LoggerFactory.getLogger(IplstatServiceImpl.class);

	@Override
	public TeamLabelsDTO getAllTeamLabels() {
		TeamLabelsDTO labelDto = iplstatDao.findTeamLabels();
		log.info("Team label details:{}", labelDto.getLabels());
		return labelDto;
	}

	@Override
	public List<PlayerDTO> getPlayersByLabel(String label) {
		Assert.notNull(label, "Label name can't be empty or null");
		List<PlayerDTO> playerList = iplstatDao.findPlayersByLabel(label);
		log.info("Total {} players found for the label:{}", playerList.size(), label);
		return playerList;
	}

	@Override
	public List<PlayerCountDTO> getRoleCountByLabel(String label) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PlayerDTO> getPlayersByLabelAndRole(String label, String role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TeamDTO> getAllTeams() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TeamAmountDTO> getAllTeamAmount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RoleAmountDTO> getRoleAmountByLabel(String label) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, List<PlayerDTO>> getMaxPaidPlayersByEachRole() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PlayerDTO> getAllPlayers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PlayerDTO> search(String playerName) {
		// TODO Auto-generated method stub
		return null;
	}

}
