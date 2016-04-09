package hello;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hello.model.Vote;
import hello.repositorios.VoteRepository;

@Controller
public class VoteController {
	
	@Autowired
	private VoteRepository repository;
	
	@RequestMapping(value="/stadistic", method=RequestMethod.GET)
	    public String stadistic(Model model) {
	        model.addAttribute("pollingStations", repository.findAllPollingStations());
			model.addAttribute("votesPartyPStation", repository.findVotersByPollingStationAndParty());
	        return "stadistic";
	    }
	
	@RequestMapping(value="/stadistic_json", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> stadisticData() {
		
		List<Object[]> parties = repository.countAllVotes();
		
		Map<String, Object> data = new HashMap<>();
		
		List<Map<String, String>> cols = new ArrayList<>();
		
		Map<String, String> col = new HashMap<>();
		col.put("name", "Partido");
		col.put("type", "string");
		cols.add(col);

		col = new HashMap<>();
		col.put("name", "Votos");
		col.put("type", "number");
		cols.add(col);
		
		data.put("cols", cols);
		
		List<Map<String, List<Map<String, Object>>>> rows = new ArrayList<>();

		for (Object[] party: parties) {
			Map<String, Object> partido = new HashMap<>();
			partido.put("v", party[0]);
	
			Map<String, Object> votos = new HashMap<>();
			votos.put("v", party[1]);
	
			List<Map<String, Object>> celdas = new ArrayList<>();
			celdas.add(partido);
			celdas.add(votos);
			
			Map<String, List<Map<String, Object>>> row = new HashMap<>();
			row.put("c", celdas);
			
			rows.add(row);
		}
		
		data.put("rows", rows);
		
		return data;
	}

	@RequestMapping(value="/stadistic_pollingstation_json/{pollingStationCode}", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> stadisticDataPollingStation(@PathVariable("pollingStationCode") String pollingStationCode) {
		
		List<Object[]> parties = repository.findAllPollingStations();
		
		Map<String, Object> data = new HashMap<>();
		
		List<Map<String, String>> cols = new ArrayList<>();
		
		Map<String, String> col = new HashMap<>();
		col.put("name", "Partido");
		col.put("type", "string");
		cols.add(col);

		col = new HashMap<>();
		col.put("name", "Votos");
		col.put("type", "number");
		cols.add(col);
		
		data.put("cols", cols);
		
		List<Map<String, List<Map<String, Object>>>> rows = new ArrayList<>();

		for (Object[] party: parties) {
			Map<String, Object> partido = new HashMap<>();
			partido.put("v", party[0]);
	
			Map<String, Object> votos = new HashMap<>();
			votos.put("v", party[1]);
	
			List<Map<String, Object>> celdas = new ArrayList<>();
			celdas.add(partido);
			celdas.add(votos);
			
			Map<String, List<Map<String, Object>>> row = new HashMap<>();
			row.put("c", celdas);
			
			rows.add(row);
		}
		
		data.put("rows", rows);
		
		return data;
	}

}
