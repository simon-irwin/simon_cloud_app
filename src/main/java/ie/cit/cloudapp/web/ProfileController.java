package ie.cit.cloudapp.web;

import ie.cit.cloudapp.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value={"playerprofile"})
public class ProfileController {

	@Autowired
	JdbcPlayerRepository playerRepository;

	@RequestMapping(method = RequestMethod.GET)
	public void justShowPage(Model model) {
		model.addAttribute("player", playerRepository.getPlayerLoggedIn());
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
		player.setTeamColour(teamcolour);

		playerRepository.save(player);
		model.addAttribute("players", playerRepository.getPlayerLoggedIn());
	}

	
	@RequestMapping(method = RequestMethod.DELETE)
	public void deletePlayer(Model model, @RequestParam int playerId) {
		playerRepository.delete(playerId);
		model.addAttribute("player", playerRepository.getPlayerLoggedIn());
	}

	@RequestMapping(method = RequestMethod.PUT)
	public void updatePlayer(Model model, @RequestParam int playerId) {
		Player player = playerRepository.get(playerId);
		playerRepository.updateProfile(player);
		model.addAttribute("players", playerRepository.getPlayerLoggedIn());
	}
}
