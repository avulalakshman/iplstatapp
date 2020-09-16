package com.careerit.iplstatapp.service;

import java.util.List;
import java.util.Map;

import com.careerit.iplstatapp.dto.PlayerCountDTO;
import com.careerit.iplstatapp.dto.PlayerDTO;
import com.careerit.iplstatapp.dto.RoleAmountDTO;
import com.careerit.iplstatapp.dto.TeamAmountDTO;
import com.careerit.iplstatapp.dto.TeamDTO;
import com.careerit.iplstatapp.dto.TeamLabelsDTO;

public interface IplstatService {

	TeamLabelsDTO getAllTeamLabels();

	List<PlayerDTO> getPlayersByLabel(String label);

	List<PlayerCountDTO> getRoleCountByLabel(String label);

	List<PlayerDTO> getPlayersByLabelAndRole(String label, String role);

	List<TeamDTO> getAllTeams();

	List<TeamAmountDTO> getAllTeamAmount();

	List<RoleAmountDTO> getRoleAmountByLabel(String label);

	Map<String, List<PlayerDTO>> getMaxPaidPlayersByEachRole();

	List<PlayerDTO> getAllPlayers();

	List<PlayerDTO> search(String playerName);

}
