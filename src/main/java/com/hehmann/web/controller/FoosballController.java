package com.hehmann.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.hehmann.domain.Tournament;

@Controller
@RequestMapping("/")
public class FoosballController {
	private List<Tournament> tournaments = new ArrayList<Tournament>();
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String showTournamentList(@RequestParam(value="newTournament", required=true) String newTournamentName, Map<String, Object> model) {			
		Tournament newTournament = new Tournament(newTournamentName);
		if(tournaments.contains(newTournament))
			model.put("message", "Turnier mit Namen \"" + newTournamentName + "\" existiert bereits.");
		else
			tournaments.add(newTournament);
		return showTournamentList(model);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showTournamentList(Map<String, Object> model) {
		model.put("tournamentList", tournaments);
		return "tournamentList";
	}
	
	@RequestMapping(value = "/data", method = RequestMethod.GET)
	public String showData(Map<String, Object> model) {
		model.put("content", "test3");
		return "data";
	}
	
	@RequestMapping(value = "/greetings.html", method = RequestMethod.POST)
	public String showAllGreetings(@RequestParam(value="greetingText", required=true) String greetingText, Map<String, Object> model) {			
		model.put("greetingText", greetingText);
		return "greetings";
	}
	
	@RequestMapping(value = "/addgreeting.html", method = RequestMethod.GET)
	public String showAddGreetingPage() {
		return "addgreeting";
	}
}