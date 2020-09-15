package com.careerit.iplstatapp.domain;

import java.util.List;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Team {
		
		@Id
		private String id;
		private String city;
		private String home;
		private String label;
		private String coach;
		private String name;
		private List<Player> players;
}
