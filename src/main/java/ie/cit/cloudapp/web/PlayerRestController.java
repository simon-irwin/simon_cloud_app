package ie.cit.cloudapp.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.util.UriTemplate;

import ie.cit.cloudapp.*;
import ie.cit.cloudapp.web.*;

@Controller
public class PlayerRestController {

	@Autowired
	private JdbcPlayerRepository repo;

	@RequestMapping(value = "/player", method = RequestMethod.GET)
	public @ResponseBody
	List<Player> listPlayers() {
		return repo.getAll();
	}
	
	@RequestMapping(value = "/player/{playerId}", method = RequestMethod.GET)
	public @ResponseBody
	Player player(@PathVariable Integer playerId) {
		return repo.get(playerId);
	}
	
	@RequestMapping(value = "/player", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void createPlayer(@RequestBody Player player, HttpServletRequest request,
			HttpServletResponse response) {
		repo.save(player);
		response.addHeader("Location",
				getLocationForChildResource(request, player.getId()));
	}
	
	private String getLocationForChildResource(HttpServletRequest request,
			Integer childIdentifier) {
		// get the current URL from the request
		final StringBuffer url = request.getRequestURL();
		// append the /xyz to the URL and make it a UriTemplate
		final UriTemplate template = new UriTemplate(url.append("/{childId}")
				.toString());
		return template.expand(childIdentifier).toASCIIString();
	}
}
