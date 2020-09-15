package com.careerit.iplstatapp.dao;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.match;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.unwind;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.aggregation.UnwindOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import com.careerit.iplstatapp.dto.PlayerCountDTO;
import com.careerit.iplstatapp.dto.PlayerDTO;
import com.careerit.iplstatapp.dto.RoleAmountDTO;
import com.careerit.iplstatapp.dto.TeamAmountDTO;
import com.careerit.iplstatapp.dto.TeamDTO;
import com.careerit.iplstatapp.dto.TeamLabelsDTO;

@Repository
public class IplstatDaoImpl implements IplstatDao {

	@Autowired
	private MongoOperations mongoOperations;

	private static final Logger log = LoggerFactory.getLogger(IplstatDaoImpl.class);

	@Override
	public TeamLabelsDTO findTeamLabels() {

		GroupOperation group = group().addToSet("label").as("labels");
		ProjectionOperation project = project().and("labels").as("labels").andExclude("_id");

		Aggregation aggregation = Aggregation.newAggregation(group, project);
		log.debug("Query :{}", aggregation);
		AggregationResults<TeamLabelsDTO> result = mongoOperations.aggregate(aggregation, "team", TeamLabelsDTO.class);
		TeamLabelsDTO teamLabelDto = result.getUniqueMappedResult();
		log.info("Total team labels found in DB :{}", teamLabelDto);
		return teamLabelDto;
	}

	@Override
	public List<PlayerDTO> findPlayersByLabel(String label) {

		MatchOperation match = match(Criteria.where("label").is(label));

		UnwindOperation unwind = unwind("players");

		ProjectionOperation project = project().and("players.name").as("name").and("players.role").as("role")
				.and("players.price").as("price").and("lable").as("label").andExclude("_id");

		Aggregation aggregation = Aggregation.newAggregation(match, unwind, project);

		log.debug("Query :{}", aggregation);

		AggregationResults<PlayerDTO> result = mongoOperations.aggregate(aggregation, "team", PlayerDTO.class);
		List<PlayerDTO> playersList = result.getMappedResults();
		log.info("{} Total players for the given label : {}", playersList.size(), label);
		return playersList;
	}

	@Override
	public List<PlayerCountDTO> findRoleCountByLabel(String label) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PlayerDTO> findPlayersByLabelAndRole(String label, String role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TeamDTO> findAllTeams() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TeamAmountDTO> findAllTeamAmount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RoleAmountDTO> findRoleAmountByLabel(String label) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, List<PlayerDTO>> findMaxPaidPlayersByEachRole() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PlayerDTO> findAllPlayers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PlayerDTO> search(String playerName) {
		// TODO Auto-generated method stub
		return null;
	}

}
