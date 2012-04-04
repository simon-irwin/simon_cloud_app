package ie.cit.cloudapp.web;

import ie.cit.cloudapp.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value={"signup", "admin"})
public class SignupController {

	@Autowired
	JdbcPlayerRepository playerRepository;

	@RequestMapping(method = RequestMethod.GET)
	public void justShowPage(Model model) {
		model.addAttribute("players", playerRepository.getAll());
	}

	@RequestMapping(method = RequestMethod.POST)
	public void createNewPlayer(Model model, @RequestParam String username,
			@RequestParam String password,
			@RequestParam String firstName,
			@RequestParam String surname, @RequestParam String club, 
			@RequestParam String teamcolour) {
		Player player = new Player();
		player.setUsername(username);
		player.setPassword(password);
		player.setFirstName(firstName);
		player.setSurname(surname);
		player.setClub(club);
		player.setTeamColour(teamcolour); //hard code to red for now

		playerRepository.save(player);
		model.addAttribute("players", playerRepository.getAll());
	}

	//@RequestParam("surname")
	
	@RequestMapping(method = RequestMethod.DELETE)
	public void deletePlayer(Model model, @RequestParam int playerId) {
		playerRepository.delete(playerId);
		model.addAttribute("players", playerRepository.getAll());
	}

	@RequestMapping(method = RequestMethod.PUT)
	public void updatePlayer(Model model, @RequestParam int playerId) {
		Player player = playerRepository.get(playerId);
		if (player.getTeamColour().equalsIgnoreCase("red"))
			player.setTeamColour("Green");
		
		else
			player.setTeamColour("Red");
		
		playerRepository.update(player);
		model.addAttribute("players", playerRepository.getAll());
	}
}
