package com.careerit.iplstatapp.dao;

import java.util.List;
import java.util.Map;

import com.careerit.iplstatapp.dto.PlayerCountDTO;
import com.careerit.iplstatapp.dto.PlayerDTO;
import com.careerit.iplstatapp.dto.RoleAmountDTO;
import com.careerit.iplstatapp.dto.TeamAmountDTO;
import com.careerit.iplstatapp.dto.TeamDTO;
import com.careerit.iplstatapp.dto.TeamLabelsDTO;

public interface IplstatDao {

	TeamLabelsDTO findTeamLabels();

	List<PlayerDTO> findPlayersByLabel(String label);

	List<PlayerCountDTO> findRoleCountByLabel(String label);

	List<PlayerDTO> findPlayersByLabelAndRole(String label, String role);

	List<TeamDTO> findAllTeams();

	List<TeamAmountDTO> findAllTeamAmount();

	List<RoleAmountDTO> findRoleAmountByLabel(String label);

	Map<String, List<PlayerDTO>> findMaxPaidPlayersByEachRole();

	List<PlayerDTO> findAllPlayers();

	List<PlayerDTO> search(String playerName);
}
