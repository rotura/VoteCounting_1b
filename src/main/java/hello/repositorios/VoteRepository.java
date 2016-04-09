package hello.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import hello.model.Vote;

public interface VoteRepository extends CrudRepository<Vote, Long> {

	@Query("SELECT v.party, COUNT(v.id) FROM Vote v GROUP BY v.party")
	List<Object[]> countAllVotes();

	//@Query("SELECT DISTINCT v.pollingStationCode FROM Vote v GROUP BY v.party")
	@Query("SELECT DISTINCT v.pollingStationCode, COUNT(v.id) FROM Vote v GROUP By v.pollingStationCode")
	List<Object[]> findAllPollingStations();
	
	//Obtención de los votos por partido y colegio
	@Query("SELECT v.pollingStationCode, v.party, COUNT(v.id) FROM Vote v GROUP By v.party")
	List<Object[]> findVotersByPollingStationAndParty();
}
