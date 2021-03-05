package fr.sorbonne.paris.nord.university.tpteamshandlingapi.controller;


import fr.sorbonne.paris.nord.university.tpteamshandlingapi.entity.TeamEntity;
import fr.sorbonne.paris.nord.university.tpteamshandlingapi.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
public class TeamController {

    @GetMapping("/hello")
    public String getTeams() {
        return "Hello World";
    }

    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }
     //TeamEntity newTeamEntity = new TeamEntity(4L, "PSG","Dream Bigger");
    //TeamEntity savedTeamEntity = new TeamEntity(5L, "RSB","Mado");

    @GetMapping("/teams")
    List<TeamEntity> all() {
        return teamService.findTeams();
    }

    @GetMapping("/teams/{id}")
    public TeamEntity findById(@PathVariable Long id) {
        return teamService.findById(id);
    }
/*
    @DeleteMapping("/deleteTeam/{id}")
    void deleteTeam(@PathVariable Long id) {
        teamService.deleteByID(id);
    }


    @Transactional
    @PostMapping("/addTeam")
    TeamEntity newTeam(@RequestBody TeamEntity newTeam) {
        return (TeamEntity) teamService.updateTeam(newTeam);
    }

    @Transactional
    @PostMapping("/updateTeam")
    TeamEntity savedTeam(@RequestBody TeamEntity savedTeam) {
        return (TeamEntity)teamService.addTeam(savedTeam);
    }
*/

}