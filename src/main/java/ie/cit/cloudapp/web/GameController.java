package ie.cit.cloudapp.web;

import ie.cit.cloudapp.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value={"games"})
public class GameController {

	@Autowired
	JdbcGameRepository gameRepository;

	@RequestMapping(method = RequestMethod.GET)
	public void justShowPage(Model model) {
		model.addAttribute("games", gameRepository.getAll());
	}

	@RequestMapping(method = RequestMethod.POST)
	public void createNewGame(Model model, @RequestParam String date,
			@RequestParam String venue,
			@RequestParam String winner) {
		Game game = new Game();
		
		game.setDate(date);
		game.setVenue(venue);
		game.setWinner(winner);

		gameRepository.save(game);
		model.addAttribute("games", gameRepository.getAll());
	}

	
	@RequestMapping(method = RequestMethod.PUT)
	public void updateGame(Model model, @RequestParam int gameId, 
			@RequestParam String winner) {
		
		Game game = gameRepository.get(gameId);
		game.setWinner(winner);
		
		gameRepository.update(game);
		model.addAttribute("games", gameRepository.getAll());
	}
}
