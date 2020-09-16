package com.careerit.iplstatapp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.careerit.iplstatapp.dto.PlayerDTO;
import com.careerit.iplstatapp.dto.TeamLabelsDTO;
import com.careerit.iplstatapp.service.IplstatService;

@RestController
@RequestMapping("/api/v1/stat")
public class IplstatController {

	@Autowired
	private IplstatService iplstatService;

	@GetMapping("/labels")
	public TeamLabelsDTO getTeamLabels() {
		return iplstatService.getAllTeamLabels();
	}

	@GetMapping("/{label}/players")
	public List<PlayerDTO> getPlayersByLabel(@PathVariable("label") String label) {
		return iplstatService.getPlayersByLabel(label);
	}

}
