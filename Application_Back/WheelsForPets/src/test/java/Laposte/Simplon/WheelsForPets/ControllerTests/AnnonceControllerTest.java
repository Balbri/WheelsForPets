package Laposte.Simplon.WheelsForPets.ControllerTests;


import Laposte.Simplon.WheelsForPets.Controller.AnnonceController;
import Laposte.Simplon.WheelsForPets.Model.Annonce;
import Laposte.Simplon.WheelsForPets.Repository.AnnonceRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class AnnonceControllerTest {

    @Autowired(required=true)
    MockMvc mockMVC;


    @MockBean
    AnnonceRepository annonceRepository;




    @Test
    public void getAnnonces() throws Exception{
        when(this.annonceRepository.findAll()).thenReturn(new ArrayList<Annonce>());

        this.mockMVC.perform(get("/api/annonces")).andExpect(status().isOk());
    }


    @Test
    public void getLast3() throws Exception{
        when(this.annonceRepository.getLast3Annonces()).thenReturn(new ArrayList<>());
        this.mockMVC.perform(get("/api/annonces")).andExpect(status().isOk());
    }

    @Test public void getById() throws Exception{

        when(this.annonceRepository.findById(10)).thenReturn(Optional.of(new Annonce(10, new Date() ,
                "titre test", "description test", "houilles", 78800, new Date(),
                "Paris", 75000, new Date(), 25, true)));

        this.mockMVC.perform(get("/api/annonces/10")).andExpect(status().isOk())
                .andExpect(jsonPath("annonceId").value(10))
                .andExpect(jsonPath("dateRedaction").value("2018-12-12"))
                .andExpect((jsonPath("titre").value("titre test")))
                .andExpect(jsonPath("description").value("description test"))
                .andExpect(jsonPath("villeDepart").value("houilles"))
                .andExpect(jsonPath("cdpDepart").value(78800))
                .andExpect(jsonPath("dateDepart").value("2019-12-12"))
                .andExpect(jsonPath("villeArrivee").value("Paris"))
                .andExpect(jsonPath("cpArrivee").value(75000))
                .andExpect(jsonPath("dateArrivee").value("2019-13-12"))
                .andExpect(jsonPath("prix").value(25))
                .andExpect(jsonPath("validee").value(true))

                .andDo(print());
System.out.println(mockMVC);



    }
}
