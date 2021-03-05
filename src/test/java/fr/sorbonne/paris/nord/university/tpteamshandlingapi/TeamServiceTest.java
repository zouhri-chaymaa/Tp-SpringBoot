package fr.sorbonne.paris.nord.university.tpteamshandlingapi;

import fr.sorbonne.paris.nord.university.tpteamshandlingapi.entity.TeamEntity;
import fr.sorbonne.paris.nord.university.tpteamshandlingapi.service.TeamService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



import java.util.List;


@SpringBootTest

public class TeamServiceTest {

    @Autowired
    private TeamService teamService;

    @Test
    public void shouldReturnTrue_whenGetTeamById_thenExpectedTeamInResult() {

        // Given.
       Long id = 1L;
        // When.
        TeamEntity result = teamService.findById(id);
        // Then.
        Assertions.assertThat(result).isNotNull();
    }
    @Test
    public void shouldReturnTrue_givenAllTeams_thenExpectedAllTeamInResult() {

        // Given.
        List<TeamEntity> allTeam;
        // When.
        allTeam= teamService.findTeams();
        // Then.
        Assertions.assertThat(allTeam).isNotNull().isNotEmpty();
    }

    @Test
    public void shouldReturnTrue_whenDeleteTeamById_thenExpectedTeamInResult() {

        // Given.
        Long id = 4L;
        // When.
        teamService.deleteByID(id);
        // Then.
        Assertions.assertThat(teamService.findById(id)).isNull();
    }

    @Test
    public void shouldReturnTrueWhenTheUpdatedIsDone(){
        //Given.
        TeamEntity teamEntity = new TeamEntity(1L, "PSG","Dream Bigger");
        String slogan = "Dream Bigger";
        //When.
        Object updatedTeam = teamService.updateTeam(teamEntity);
        //Then.
        Assertions.assertThat(teamEntity.getSlogan()).isEqualTo(slogan);
    }

    @Test
    public void shouldReturnTrueWhenTheAddedIsDone(){
        //Given.
        TeamEntity teamEntity = new TeamEntity();
        teamEntity.setId(6L);
        teamEntity.setName("Marseille");
        teamEntity.setSlogan("Droit aux buts");
        String given  = "Marseille";
        //When.
        Object addedTeam =  teamService.addTeam(teamEntity);
        //Then
        Assertions.assertThat(teamEntity.getName()).isEqualTo(given);
    }

}
