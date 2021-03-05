package fr.sorbonne.paris.nord.university.tpteamshandlingapi.service;

import fr.sorbonne.paris.nord.university.tpteamshandlingapi.entity.TeamEntity;
import fr.sorbonne.paris.nord.university.tpteamshandlingapi.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;





@Service
public class TeamService {

    private final TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository){
        this.teamRepository = teamRepository;
    }

    //a method return all team
    public List<TeamEntity> findTeams(){
        return teamRepository.findAll();
    }

    // a method could return team by ID
    public TeamEntity findById(Long id){
        return teamRepository.findById(id).orElse(null);// because we can find an empty list
    }
    @Transactional
    // a methode to update the Team
    public Object updateTeam(TeamEntity teamEntity){
        return teamRepository.save(teamEntity);
    }
    @Transactional
    //a method to add a team
    public Object addTeam(TeamEntity teamEntity){
        return teamRepository.save(teamEntity);
    }
    @Transactional
    // method can delete a team by ID
    public void deleteByID(Long id){
        teamRepository.deleteById(id);
    }

}
